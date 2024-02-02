package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.entity.Director;
import by.scnsoft.specification_sandbox.entity.dto.view.DirectorView;
import by.scnsoft.specification_sandbox.repository.DirectorRepository;
import by.scnsoft.specification_sandbox.service.interfaces.ViewFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorServiceViewImpl implements ViewFindAllService<DirectorView> {

    private final DirectorRepository directorRepository;

    @Override
    public List<DirectorView> findAll() {
        return directorRepository.findAllViewsBy();
    }

    public Director findOneByExample(Example<Director> example) {
        Optional<Director> directorOptional = directorRepository.findOne(example);

        if (directorOptional.isEmpty()) {
            return null;
        }

        return directorOptional.get();
    }

    public List<Director> findAllByExample(Example<Director> example) {
        return directorRepository.findAll(example);
    }
}