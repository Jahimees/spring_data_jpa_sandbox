package by.scnsoft.specification_sandbox.entity.dto.view;

import java.util.List;

public interface ActorView extends ViewEntity {

    String getName();
    List<FilmView> getFilms();
}
