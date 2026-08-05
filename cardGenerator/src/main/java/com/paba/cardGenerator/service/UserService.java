package com.paba.cardGenerator.service;
import com.paba.cardGenerator.entity.Department;
import com.paba.cardGenerator.entity.User;
import com.paba.cardGenerator.repository.DepartmentRepository;
import com.paba.cardGenerator.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public UserService(UserRepository userRepository, DepartmentRepository departmentRepository){
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }


    @Transactional
    public User registerUser(User user){
        LocalDateTime now = LocalDateTime.now();

        if(user.getEmail()==null ||!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Registered Failed: Please provide valid email");
        }
        int age = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
        if(user.getDateOfBirth() == null || age <18 ){
            throw new IllegalArgumentException("Registered Failed: Age must be over 18");
        }
        user.setCreatedAt(LocalDate.from(now));
        user.setUpdatedAt(LocalDate.from(now));
        if(user.getDepartment()== null ){
            throw new IllegalArgumentException("Registered Failed: Department is missing");

        }
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null){
            throw new IllegalArgumentException("Registered Failed: Please provide the unique email address");
        }
      if(!departmentRepository.existsById(user.getDepartment().getId())){
          throw new EntityNotFoundException("Specified department does not exists");
      }

      Department existingDepartment = departmentRepository.getReferenceById(user.getDepartment().getId());
        user.setDepartment(existingDepartment);
      return userRepository.save(user);



    }
}
