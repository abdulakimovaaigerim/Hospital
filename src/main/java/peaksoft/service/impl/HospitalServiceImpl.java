package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Hospital;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.HospitalService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    private final HospitalService hospitalService;


    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepository.save(hospital);

    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).get();

    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();

    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital oldHospital = hospitalService.getHospitalById(id);
        oldHospital.setName(hospital.getName());
        oldHospital.setAddress(hospital.getAddress());
        oldHospital.setImage(hospital.getImage());
        hospitalRepository.save(oldHospital);

    }

    @Override
    public void removeHospitalById(Long hospitalId) {
        hospitalRepository.deleteById(hospitalId);

    }

}
