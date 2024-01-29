package by.scnsoft.specification_sandbox.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "t_film")
public class Film {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_director")
    private Director director;

    @ManyToMany
    private List<Actor> actors;
}
