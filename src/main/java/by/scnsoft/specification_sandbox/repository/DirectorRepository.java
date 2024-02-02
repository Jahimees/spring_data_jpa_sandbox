package by.scnsoft.specification_sandbox.repository;

import by.scnsoft.specification_sandbox.entity.Director;
import by.scnsoft.specification_sandbox.entity.dto.view.DirectorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>, QueryByExampleExecutor<Director> {

    List<DirectorView> findAllViewsBy();
}
