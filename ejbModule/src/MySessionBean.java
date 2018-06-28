package src;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import src.entity.Employee;

/**
 * Session Bean implementation class MySessionBean
 */
@Stateless (mappedName = "src/MySessionBean")
@LocalBean
public class MySessionBean implements MySessionBeanRemote {

    /**
     * Default constructor. 
     */
    public MySessionBean() {
        // TODO Auto-generated constructor stub
    }
 
    @PersistenceContext(unitName = "HR")
	private EntityManager manager;
	
	public boolean addEmployee(Employee emp) {
		getManager().persist(emp);
		return true;
	}

	public boolean removeEmployee(Employee emp) {
		getManager().remove(getManager().merge(emp));

		return true;
	}

	public Employee findEmployeeById(long id) {
		return (Employee) getManager().createNamedQuery("Employee.findEmployeeById").setParameter("employeeId", id)
				.getSingleResult();
	}

	public Employee updateEmployee(Employee emp) {
		return getManager().merge(emp);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> listOfEmployees(){
		return getManager().createQuery("From Employee").getResultList();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}

