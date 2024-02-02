package by.scnsoft.specification_sandbox.service;

import by.scnsoft.specification_sandbox.entity.Director;
import by.scnsoft.specification_sandbox.entity.dto.FilmDto;
import by.scnsoft.specification_sandbox.repository.FilmRepository;
import by.scnsoft.specification_sandbox.repository.dao.FilmDao;
import by.scnsoft.specification_sandbox.service.interfaces.DtoFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.scnsoft.specification_sandbox.specification.FilmSpecification.directorNameContains;
import static by.scnsoft.specification_sandbox.specification.FilmSpecification.titleContains;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class FilmServiceDtoImpl implements DtoFindAllService<FilmDto> {

    private final FilmRepository filmRepository;
    private final FilmDao filmDao;

    @Override
    public List<FilmDto> findAll() {
        return filmRepository.findAllDtosBy();
    }

    public List<FilmDto> findAllByCriteria(String title, String description, String directorName) {
        return filmDao.findFilmsByTitleOrDescriptionOrDirectorName(title, description, directorName)
                .stream().map(film ->
                        new FilmDto(
                                film.getTitle(),
                                film.getDescription(),
                                new Director(film.getDirector().getName())))
                .toList();
    }

    public List<FilmDto> findAllBySpecification(String title, String directorName) {
        return filmRepository.findAll(
                        where(titleContains(title)).or(directorNameContains(directorName)))
                .stream()
                .map(film ->
                        new FilmDto(
                                film.getTitle(),
                                film.getDescription(),
                                new Director(film.getDirector().getName())))
                .toList();
    }
}
