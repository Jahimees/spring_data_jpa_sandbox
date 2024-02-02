package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.entity.Actor;
import by.scnsoft.specification_sandbox.entity.dto.ActorDto;
import by.scnsoft.specification_sandbox.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceDtoImpl {

    private final ActorRepository actorRepository;

    /**
     * Мануальная пагинация
     */
    public Page<ActorDto> findPaginated(int page, int size) {
        Pageable pageRequest = createPageRequest(page, size);

        Page<Actor> actorPage = actorRepository.findAll(pageRequest);
        return actorPage.map(actor -> new ActorDto(actor.getName(), actor.getFilms()));
    }

    /**
     * Spring Data Web Support
     */
    public Page<ActorDto> findPaginatedAuto(Pageable pageRequest) {
        Page<Actor> actorPage = actorRepository.findAll(pageRequest);

        return actorPage.map(actor -> new ActorDto(actor.getName(), actor.getFilms()));
    }

    private Pageable createPageRequest(int page, int size) {
        return PageRequest.of(page, size);
    }
}
