package src;

import java.util.List;

import javax.ejb.Remote;

import src.entity.Employee;

@Remote
public interface MySessionBeanRemote {
	public boolean addEmployee(Employee emp);
	
	public boolean removeEmployee(Employee emp);
	
	public Employee findEmployeeById(long id);
	
	public Employee updateEmployee(Employee emp);
	
	public List<Employee> listOfEmployees();

}
