package by.scnsoft.specification_sandbox.repository.dao;

import by.scnsoft.specification_sandbox.entity.Director;
import by.scnsoft.specification_sandbox.entity.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmDao implements IFIlmDao {

    private final EntityManager entityManager;

    public List<Film> findFilmsByTitleOrDescriptionOrDirectorName(String title, String description, String directorName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder(); //1 Получаем CB
        CriteriaQuery<Film> criteriaQuery = criteriaBuilder.createQuery(Film.class); //2 создаем запрос и указываем класс

        Root<Film> film = criteriaQuery.from(Film.class);
        //Пример обычных предикатов
        Predicate titlePredicate = criteriaBuilder.equal(film.get("title"), title);
        Predicate descriptionPredicate = criteriaBuilder.like(film.get("description"), "%" + description + "%");

        //Пример вложенного предиката Film.Director.name
        Path<Director> directorPath = film.get("director");
        Predicate directorNamePredicate = criteriaBuilder.like(directorPath.get("name"), "%" + directorName + "%");

        //Сбор в единый предикат
        Predicate totalPredicate = criteriaBuilder.or(titlePredicate, descriptionPredicate, directorNamePredicate);
        criteriaQuery.where(totalPredicate);

        TypedQuery<Film> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
