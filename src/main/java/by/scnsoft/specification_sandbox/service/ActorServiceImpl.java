package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.dto.ActorDto;
import by.scnsoft.specification_sandbox.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDto> findAll() {
        return this.actorRepository.findAllBy();
    }
}
