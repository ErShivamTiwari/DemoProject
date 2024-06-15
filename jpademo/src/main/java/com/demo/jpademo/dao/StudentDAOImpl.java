package com.demo.jpademo.dao;

import com.demo.jpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Transactional
    public void saveIntoDB(Student student) {
        entityManager.persist(student);

    }
    //code from entitymanager for geting single data from db
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    //code from entity manager to get all data from db
    public List<Student> getAllStudents() {
        //create query

        TypedQuery<Student> allQuery = entityManager.createQuery("from Student where firstName='shivam' ", Student.class);

        //return query result

        return allQuery.getResultList();

    }

    @Override
    public List<Student> getStudentsByName(String name) {

        //create query

        TypedQuery<Student> getDetailsByName = entityManager.createQuery("from Student where firstName=:theData", Student.class);

        //set query parameter
        getDetailsByName.setParameter("theData", name);

        //return query result

        return getDetailsByName.getResultList();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // below code is to update data for single row
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // below code is to update data for single row
    @Transactional
    public void updateAllStudents(String nameE) {

        entityManager.createQuery("update Student set firstName=:dataFile").setParameter("dataFile", nameE).executeUpdate();

    }

    @Transactional
    public void deleteStudentById(int id) {

        Student student=entityManager.find(Student.class, id);

        entityManager.remove(student);
    }
    @Transactional
    public void deleteAllStudents() {
        entityManager.createQuery("delete from Student").executeUpdate();
    }
}
