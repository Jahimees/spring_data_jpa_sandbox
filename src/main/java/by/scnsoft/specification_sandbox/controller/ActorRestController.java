package by.scnsoft.specification_sandbox.controller;

import by.scnsoft.specification_sandbox.entity.Actor;
import by.scnsoft.specification_sandbox.entity.dto.view.ActorView;
import by.scnsoft.specification_sandbox.service.ActorServiceViewImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorRestController {

    private final ActorServiceViewImpl actorService;

    @GetMapping
    public ResponseEntity<List<ActorView>> findAllActors() {
        return ResponseEntity.ok(this.actorService.findAll());
    }

    @GetMapping
    public ResponseEntity<Actor> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
//        https://www.baeldung.com/rest-api-pagination-in-spring
    }
}
