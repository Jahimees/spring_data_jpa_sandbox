package by.scnsoft.specification_sandbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "t_director")
@Data
public class Director {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "c_name")
    private String name;
}
