package by.scnsoft.specification_sandbox.entity.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class DirectorDto implements DtoEntity {

    String name;

    public DirectorDto(String name) {
        this.name = name;
    }
}
