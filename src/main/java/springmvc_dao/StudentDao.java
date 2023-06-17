package springmvc_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc_dto.Student;

@Repository
public class StudentDao {
	@Autowired
	public EntityManager entityManager;
	
	public void saveStudent(Student student)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public List<Student>getAllStudent()
	{
		Query query=entityManager.createQuery("select s from Student s");
		List<Student>list =query.getResultList();
		return list;
		
	}
	public boolean deleteStudent(int id)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student =entityManager.find(Student.class, id);
		if(student !=null)
		{
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	public Student getStudentById(int id)
	{
		Student student =entityManager.find(Student.class,id);
		return student;
	}
	public Student updateStudent(Student student)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		return student;
		
	}

}
