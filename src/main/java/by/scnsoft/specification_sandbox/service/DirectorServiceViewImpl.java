package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.entity.dto.view.DirectorView;
import by.scnsoft.specification_sandbox.repository.DirectorRepository;
import by.scnsoft.specification_sandbox.service.interfaces.ViewFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceViewImpl implements ViewFindAllService<DirectorView> {

    private final DirectorRepository directorRepository;

    @Override
    public List<DirectorView> findAll() {
        return directorRepository.findAllViewsBy();
    }
}