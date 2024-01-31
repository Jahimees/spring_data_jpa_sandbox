package by.scnsoft.specification_sandbox.controller;

import by.scnsoft.specification_sandbox.entity.dto.FilmDto;
import by.scnsoft.specification_sandbox.service.FilmServiceDtoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
