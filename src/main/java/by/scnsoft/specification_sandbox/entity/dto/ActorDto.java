package by.scnsoft.specification_sandbox.entity.dto;

import by.scnsoft.specification_sandbox.entity.Film;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * DTO-проекция. Для того, чтобы работало, нужно, чтобы свойства (названия) entity и dto объекта совпадали, чтобы
 * в Repository можно было сделать так: ... extends JpaRepository<Actor, Integer>, но при этом в методах
 * List<ActorDto> findAllBy...
 * Не работает вложенная проекция (именно возвращение проекции из репозитория)!!! ДАННАЯ РЕАЛИЗАЦИЯ НЕ СРАБОТАЕТ!
 */
@Getter
@Setter
@EqualsAndHashCode
public class ActorDto implements DtoEntity {

    private String name;
    private List<FilmDto> films;

    public ActorDto(String name, List<Film> films) {
        this.name = name;
        this.films = films.stream().map(film -> {
            return new FilmDto(film.getTitle(), film.getDescription(), film.getDirector());
        }).toList();
    }
}
