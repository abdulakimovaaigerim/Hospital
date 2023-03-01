package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Appointment;


@Repository

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
