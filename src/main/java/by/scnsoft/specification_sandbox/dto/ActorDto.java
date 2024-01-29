package by.scnsoft.specification_sandbox.dto;

import by.scnsoft.specification_sandbox.entity.Film;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * DTO-проекция. Для того, чтобы работало, нужно, чтобы свойства entity и dto объекта совпадали, чтобы
 * в Repository можно было сделать так: ... extends JpaRepository<Actor, Integer>, но при этом в методах
 * List<ActorDto> findAllBy...
 */
@Getter
@EqualsAndHashCode
public class ActorDto {

    private String name;
//    private List<Film> films;

    public ActorDto(String name) {
        this.name = name;
//        this.films = List.copyOf(films);
//        var iterator = films.iterator();
//
//        var filmBuilder = new StringBuilder();
//        while (iterator.hasNext()) {
//            filmBuilder.append(iterator.next().toString());
//            if (iterator.hasNext()) {
//                filmBuilder.append(", ");
//            }
//        }
//
//        this.films = filmBuilder.toString();
    }
}
