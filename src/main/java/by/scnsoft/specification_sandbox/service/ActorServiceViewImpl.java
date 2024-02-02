package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.entity.dto.view.ActorView;
import by.scnsoft.specification_sandbox.repository.ActorRepository;
import by.scnsoft.specification_sandbox.service.interfaces.ViewFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceViewImpl implements ViewFindAllService<ActorView> {

    private final ActorRepository actorRepository;

    @Override
    public List<ActorView> findAll() {
        return this.actorRepository.findAllViewsBy();
    }

}

