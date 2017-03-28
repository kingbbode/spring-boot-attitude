package com.kingbbode.repository;

import com.kingbbode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YG-MAC on 2017. 3. 26..
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
