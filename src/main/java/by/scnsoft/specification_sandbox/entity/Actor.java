package by.scnsoft.specification_sandbox.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "t_actor")
@Data
public class Actor {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "c_name")
    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films;
}
