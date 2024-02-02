package by.scnsoft.specification_sandbox.controller;

import by.scnsoft.specification_sandbox.entity.dto.ActorDto;
import by.scnsoft.specification_sandbox.entity.dto.view.ActorView;
import by.scnsoft.specification_sandbox.service.ActorServiceDtoImpl;
import by.scnsoft.specification_sandbox.service.ActorServiceViewImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    private final ActorServiceDtoImpl actorServiceDto;
    private final ActorServiceViewImpl actorServiceView;

    @GetMapping
    public ResponseEntity<List<ActorView>> findAllActors() {
        return ResponseEntity.ok(this.actorServiceView.findAll());
    }

    /**
     * Мануальная пагинация
     * @param page номер страницы
     * @param size количество результатов на странице
     * @return список найденных элементов, удовлетворяющих условию
     */
    @GetMapping("/pageable")
    public ResponseEntity<List<ActorDto>> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<ActorDto> resultPage = actorServiceDto.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(resultPage.getContent());
    }

    /**
     * Реализация пагинации с помощью Spring Data Web Support
     * @param pageRequest по умолчанию параметр page = 0; size = 20
     */
    @GetMapping("/pageable_auto")
    public ResponseEntity<List<ActorDto>> findPaginatedAuto(Pageable pageRequest) {
        return ResponseEntity.ok(actorServiceDto.findPaginatedAuto(pageRequest).getContent());
    }
}
