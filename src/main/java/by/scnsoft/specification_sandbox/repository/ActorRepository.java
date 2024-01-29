package by.scnsoft.specification_sandbox.repository;

import by.scnsoft.specification_sandbox.dto.ActorDto;
import by.scnsoft.specification_sandbox.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<ActorDto> findAllBy();
}
