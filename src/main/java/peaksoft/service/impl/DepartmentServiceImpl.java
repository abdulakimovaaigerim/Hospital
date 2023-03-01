package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Department;
import peaksoft.entities.Doctor;
import peaksoft.repository.DepartmentRepository;
import peaksoft.repository.DoctorRepository;
import peaksoft.service.DepartmentService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentService departmentService;

    private final DoctorRepository doctorRepository;


    @Override
    public void saveDepartment(Long hospitalId, Department department) {
        departmentRepository.findById(hospitalId);

    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> getAllDepartment(Long id) {
        return departmentRepository.findAll();
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department oldDepartment = departmentService.getDepartmentById(id);
        oldDepartment.setName(department.getName());
        departmentRepository.save(oldDepartment);

    }

    @Override
    public void removeDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void assignDoctor(Long doctorId, Long departmentId) {
        try {
            departmentRepository.findById(departmentId).get();
            Department department = new Department();
            doctorRepository.findById(doctorId);
            Doctor doctor = new Doctor();

            if (department.getId() != null) {
                for (Doctor d : department.getDoctors()) {
                    if (Objects.equals(d.getId(), departmentId)) {
                        throw new IOException("This doctor already exists!");
                    }

                }
                doctor.addDepartment(department);
                department.addDoctor(doctor);
                doctorRepository.save(doctor);
                departmentRepository.save(department);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
