package by.scnsoft.specification_sandbox.repository;

import by.scnsoft.specification_sandbox.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
