package com.stprogramming.restapi.Repository;

import com.stprogramming.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
