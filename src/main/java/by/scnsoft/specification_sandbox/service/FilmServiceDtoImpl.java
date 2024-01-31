package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.entity.dto.FilmDto;
import by.scnsoft.specification_sandbox.repository.FilmRepository;
import by.scnsoft.specification_sandbox.service.interfaces.DtoFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceDtoImpl implements DtoFindAllService<FilmDto> {

    private final FilmRepository filmRepository;

    @Override
    public List<FilmDto> findAll() {
        return filmRepository.findAllDtosBy();
    }
}
