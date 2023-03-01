package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
