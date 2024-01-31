package by.scnsoft.specification_sandbox.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "t_actor")
@Data
public class Actor implements RawEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "c_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "t_films_actors",
            joinColumns = {@JoinColumn(name = "id_film")},
            inverseJoinColumns = {@JoinColumn(name = "id_actor")}
    )
    private List<Film> films;
}
