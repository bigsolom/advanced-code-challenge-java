package com.statista.code.challenge.dal;

import com.statista.code.challenge.models.Department;
import com.statista.code.challenge.models.CrossfitDepartment;
import com.statista.code.challenge.models.TriathlonDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class DepartmentsRepository {
    Map<String, Department> departments = Stream.of(new TriathlonDepartment("crossfit_department"),new CrossfitDepartment("triathlon_department")).collect(Collectors.toMap(Department::getName, Function.identity()));

    public List<Department> findAll() {
        return departments.values().stream().collect(Collectors.toList());
    }

    public Optional<Department> findByName(String name){
        Department result = departments.get(name);
        if(result == null){
            return Optional.empty();
        }
        return Optional.of(result);
    }
}
