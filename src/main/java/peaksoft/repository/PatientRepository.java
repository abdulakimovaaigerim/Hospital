package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
