package com.example.project.LegalComplianceManagement.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.LegalComplianceManagement.Entity.EmployeeCentral;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<EmployeeCentral , Integer> 
{
     public EmployeeCentral findByid(Integer id);
     public List<EmployeeCentral> findBydoj(Date doj);
     public List<EmployeeCentral> findBypost(String post);
     public EmployeeCentral findByaddhar(Long addhar);
     public void deleteByid(Integer id);
    public List<EmployeeCentral> findBydojAndName(Date doj, String name);
}
