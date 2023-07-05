package employee_management;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeDriver {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public static void main(String[] args) {
		System.out.println("----------WELCOME TO EMPLOYEE MANAGEMENT SYSTEM ----------");
		emp();
	}
		public static void emp() {
		Employee e = new Employee();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("1. For add employee");
		System.out.println("2. For view employees");
		System.out.println("3. For updtae employee");
		System.out.println("4. For remove employee");
		System.out.println("5. For Exit.");
		int choice = s.nextInt();
		
		switch (choice) {
		case 1:
		{
			System.out.println("Enter the id ");
			int id = s.nextInt();
			e.setId(id);
			
			System.out.println("Enter first name ");
			String fname = s.next();
			e.setFirst_name(fname);
			
			System.out.println("enter last name ");
			String lname = s.next();
			e.setLast_name(lname);
			
			System.out.println("Enter email id ");
		    String email = s.next();
		    e.setEmail(email);
		    
		    System.out.println("Enter yoj");
		    int yoj =s.nextInt();
		    e.setYoj(yoj);
		    
		    et.begin();
		    em.persist(e);
		    et.commit();
		    System.out.println("------------------------------------");
		    System.out.println("Employee added successfully !" );
		    System.out.println("------------------------------------");
		    
		    emp();
		    
		    break;
		    
		    
		}
		
		
		
		
		case 2:
		{
			
			Query q = em.createQuery("from Employee");
			List<Employee> emp = q.getResultList();
			System.out.println("-----------------------------------------------------------------------------------------");
			    System.out.println( "ID" +" "+ " First_Name"+"    "+" Last_Name"+"       "+"Email "+"   "+"      YOJ ");
			    System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("");
			    for (Employee employee : emp) {
				
				System.out.println(employee.getId()+"       "+employee.getFirst_name()+"         "+employee.getLast_name()+"     "+employee.getEmail()+"  "+"  "+employee.getYoj());
				System.out.println("");
				
			}
			    System.out.println("--------------------------------------------------------------------------------------");
			    
			    emp();
		    break;
		}
		case 3: 
		{
			System.out.println("Enter Id to updte:");
			int id = s.nextInt();
			e.setId(id);
			
			
			
			System.out.println("Enter first name ");
			String fname = s.next();
			e.setFirst_name(fname);
			
			System.out.println("enter last name ");
			String lname = s.next();
			e.setLast_name(lname);
			
			System.out.println("Enter email id ");
		    String email = s.next();
		    e.setEmail(email);
		    
		    System.out.println("Enter yoj");
		    int yoj =s.nextInt();
		    e.setYoj(yoj);
		    
		    et.begin();
		    em.merge(e);
		    
		    et.commit();
		    System.out.println("------------------------------------");
		    System.out.println("Updated Successfully!");
		    System.out.println("------------------------------------");
		    
		    emp();
			break;
		}
		case 4:
		{
			System.out.println("Enter id to remove employee ");
			int id = s.nextInt();
			Employee emp = em.find(Employee.class, id);
			
			et.begin();
			em.remove(emp);
			et.commit();
			System.out.println("------------------------------------");
			System.out.println("Employee removed successfully !");
			System.out.println("------------------------------------");
		    
		    emp();
		    break;
			
			 
			}
		case 5:
		{
			System.out.println("----------THANKS FOR USING..!----------");
			System.out.println("-------------VISIT AGAIN------------");
			System.exit(0);
		}
		
				

			
			}
			
		}
			
			

	
		
		
		
		
		
		
		
	}


