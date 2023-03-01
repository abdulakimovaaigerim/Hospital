package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entities.Department;

import java.util.List;

@Service
public interface DepartmentService {


    void saveDepartment(Long hospitalId, Department department);


    Department getDepartmentById(Long id);


    List<Department> getAllDepartment(Long id);


    void updateDepartment(Long id, Department department);


    void removeDepartmentById(Long id);


    void assignDoctor(Long doctorId, Long departmentId);
}
