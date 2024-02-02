package by.scnsoft.specification_sandbox.controller;

import by.scnsoft.specification_sandbox.entity.Director;
import by.scnsoft.specification_sandbox.entity.dto.view.DirectorView;
import by.scnsoft.specification_sandbox.service.DirectorServiceViewImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorRestController {

    private final DirectorServiceViewImpl directorService;

    @GetMapping
    public ResponseEntity<List<DirectorView>> findAllDirectors() {
        return ResponseEntity.ok(this.directorService.findAll());
    }

    ///Test сопоставление с учетом регистра
    @GetMapping("/examples/of")
    public ResponseEntity<Director> findDirectorByNameExample(@RequestParam String name) {
        Example<Director> example = Example.of(new Director(name));

        return ResponseEntity.ok(directorService.findOneByExample(example));
    }

    //Test сопоставление без учета регистра
    @GetMapping("/examples/ignore_case")
    public ResponseEntity<Director> findDirectorByExampleIgnoreCase(@RequestParam String name) {
        //all = && any = ||
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example<Director> example = Example.of(new Director(name), exampleMatcher);

        return ResponseEntity.ok(directorService.findOneByExample(example));
    }

    //Test пользовательское соответствия. В данном случае ищет совпадение или по имени (его части) или по id
    @GetMapping("/examples/matching_any")
    public ResponseEntity<List<Director>> findDirectorsByExampleMatchingAny(@RequestParam(required = false) String name,
                                                                            @RequestParam(required = false) Integer id) {
        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<Director> example = Example.of(new Director(id, name), customExampleMatcher);

        return ResponseEntity.ok(directorService.findAllByExample(example));
    }
}
