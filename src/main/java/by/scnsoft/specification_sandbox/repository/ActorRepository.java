package by.scnsoft.specification_sandbox.repository;

import by.scnsoft.specification_sandbox.entity.Actor;
import by.scnsoft.specification_sandbox.entity.dto.view.ActorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<ActorView> findAllViewsBy();
}
