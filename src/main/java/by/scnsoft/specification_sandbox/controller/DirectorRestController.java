package by.scnsoft.specification_sandbox.controller;

import by.scnsoft.specification_sandbox.entity.dto.view.DirectorView;
import by.scnsoft.specification_sandbox.service.DirectorServiceViewImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
