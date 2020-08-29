package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;
    //use Constructor Injection
    //new Version of spring no need to inject if one constructor available
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
//    @Transactional
    public List<Employee> findAll() {
        //get current Session
        Session currentSession=entityManager.unwrap(Session.class);
        //create Query
        Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);

        //execute Query
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Session currentSession=entityManager.unwrap(Session.class);
        //get employee
        Employee theQuery=currentSession.get(Employee.class,id);

        return theQuery;
    }

    @Override
    public void save(Employee employee) {
        //get current Session
        Session currentSession=entityManager.unwrap(Session.class);
        //save Query
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        //get current Session
        Session currentSession=entityManager.unwrap(Session.class);
//        Employee employee=currentSession.get(Employee.class,id);
//        //save Query
//        currentSession.delete(employee);
        Query theQuery=currentSession.createQuery("delete from Employee where id=:id");
        theQuery.setParameter("id",id);
        theQuery.executeUpdate();
    }


}
