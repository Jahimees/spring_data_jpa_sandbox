package by.scnsoft.specification_sandbox.entity.dto;

import by.scnsoft.specification_sandbox.entity.Director;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class FilmDto implements DtoEntity {

    private String title;
    private String description;
    private DirectorDto director;

    public FilmDto(String title, String description, Director director) {
        this.title = title;
        this.description = description;
        this.director = new DirectorDto(director.getName());
    }
}
