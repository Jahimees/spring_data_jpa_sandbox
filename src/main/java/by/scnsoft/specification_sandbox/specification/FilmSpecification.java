package by.scnsoft.specification_sandbox.specification;

import by.scnsoft.specification_sandbox.entity.Film;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class FilmSpecification implements SpecificationUtil<Film> {

    private FilmSpecification() {
    }

    public static Specification<Film> titleContains(String title) {
        return (film, cq, cb) -> cb.like(film.get("title"), "%" + title + "%");
    }

    //IgnoreCase достигается приведением всех символов к одному регистру
    public static Specification<Film> directorNameContains(String directorName) {
        return (film, cq, cb) -> {
            if (directorName == null) {
                return null;
            }
            return cb.like(cb.lower(film.get("director").get("name")), "%" + directorName.toLowerCase() + "%");
        };
    }

}
