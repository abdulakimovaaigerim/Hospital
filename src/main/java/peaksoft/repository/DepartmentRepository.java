package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
