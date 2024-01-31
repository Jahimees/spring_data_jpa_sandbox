package by.scnsoft.specification_sandbox.entity.dto.view;

public interface FilmView extends ViewEntity {

    String getTitle();
    String getDescription();
    DirectorView getDirector();
}
