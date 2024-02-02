package by.scnsoft.specification_sandbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "t_director")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director implements RawEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "c_name")
    private String name;

    public Director(String name) {
        this.name = name;
    }
}
