package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
