package by.scnsoft.specification_sandbox.repository;

import by.scnsoft.specification_sandbox.entity.dto.FilmDto;
import by.scnsoft.specification_sandbox.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    List<FilmDto> findAllDtosBy();
}
