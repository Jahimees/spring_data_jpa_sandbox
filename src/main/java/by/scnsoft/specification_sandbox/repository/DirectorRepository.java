package by.scnsoft.specification_sandbox.repository;

import by.scnsoft.specification_sandbox.entity.dto.view.DirectorView;
import by.scnsoft.specification_sandbox.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    List<DirectorView> findAllViewsBy();
}
