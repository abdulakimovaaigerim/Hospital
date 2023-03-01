package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Doctor;
import peaksoft.entities.Hospital;
import peaksoft.repository.DoctorRepository;
import peaksoft.service.DoctorService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorService doctorService;


    @Override
    public void saveDoctor(Long hospitalId, Doctor doctor) {
        doctorRepository.findById(hospitalId);
        Hospital hospital = new Hospital();
        hospital.setDoctor(doctor);
        doctor.setHospital(hospital);
        doctorRepository.save(doctor);


    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public List<Doctor> getAllDoctor(Long id) {
        return doctorRepository.findAll();
    }

    @Override
    public void updateDoctor(Long id, Doctor doctor) {
        Doctor oldDoctor = doctorService.getDoctorById(id);
        oldDoctor.setFirstName(doctor.getFirstName());
        oldDoctor.setLastName(doctor.getLastName());
        oldDoctor.setEmail(doctor.getEmail());
        oldDoctor.setPosition(doctor.getPosition());
        doctorRepository.save(doctor);

    }

    @Override
    public void removeDoctorById(Long id) {
        doctorRepository.deleteById(id);

    }

}
