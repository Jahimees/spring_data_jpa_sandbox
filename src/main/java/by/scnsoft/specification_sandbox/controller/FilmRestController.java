package by.scnsoft.specification_sandbox.controller;

import by.scnsoft.specification_sandbox.entity.dto.FilmDto;
import by.scnsoft.specification_sandbox.service.FilmServiceDtoImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("films")
public class FilmRestController {

    private final FilmServiceDtoImpl filmService;

    @GetMapping
    public ResponseEntity<List<FilmDto>> findAll() {
        return ResponseEntity.ok(filmService.findAll());
    }

    @GetMapping("/criteria")
    public ResponseEntity<List<FilmDto>> findFilmsByCriteria(@RequestParam(required = false) String title,
                                                             @RequestParam(required = false) String description,
                                                             @RequestParam(required = false) String directorName) {
        return ResponseEntity.ok(filmService.findAllByCriteria(title, description, directorName));
    }

    @GetMapping("/specification")
    public ResponseEntity<List<FilmDto>> findFilmsBySpecification(@RequestParam(required = false) String title,
                                                                  @RequestParam(required = false) String directorName) {
        return ResponseEntity.ok(filmService.findAllBySpecification(title, directorName));
    }
}
