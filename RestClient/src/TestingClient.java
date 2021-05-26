import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestingClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		try(Scanner scan = new Scanner(System.in)){
			String choice = "";
			while(!choice.toLowerCase().equals("exit")) {
				System.out.println("What do you want to do?");
				System.out.println("To List all Staffs from the zoo (list)");
				System.out.println("To List all Staffs from the zoo with a certain role (role)");
				System.out.println("To add a new staff to the zoo (add)");
				System.out.println("To remove a staff from the zoo (remove)");
				System.out.println("To update a staff from the zoo (update)");
				choice = scan.nextLine();
				if(choice.toLowerCase().equals("list")) {
					listAllStaffs(client, scan);
				}
				else if(choice.toLowerCase().equals("role"))
				{
					listStaffsByRole(client, scan);
				}
				else if(choice.toLowerCase().equals("add"))
				{
					addStaff(client, scan);
				}
				else if(choice.toLowerCase().equals("remove"))
				{
					removeStaff(client, scan);
				}
				else if(choice.toLowerCase().equals("update"))
				{
					updateStaff(client, scan);
				}
				else {
					System.out.println("Invalid choice");
				}
				System.out.println("");
				System.out.println("Press enter to go again and exit to stop");
				scan.nextLine();
				choice = scan.nextLine();
			}
			
		}
		

		
		
		
	}
	
	private static void listAllStaffs(Client client, Scanner scan) {
		//Uses GET to get all the staffs from the zoo
		System.out.println("Lists all staffs");
		Response allstaffs = client.target("http://localhost:8080/ZooManagement/webservice/zoostaffs").request().buildGet().invoke();
		List<ZooStaff> staffs = allstaffs.readEntity(new GenericType<List<ZooStaff>>() {});		
				
		for (ZooStaff zooStaff : staffs) {
			System.out.println(zooStaff);
			System.out.println("");
		}			
		allstaffs.close();
	}
	
	private static void listStaffsByRole(Client client, Scanner scan) {
		//Uses GET to get all the staffs from the zoo with a certain role
		System.out.println("What role do you want to list? (feeder/cleaner/vet)");
		String role = scan.nextLine();
	    System.out.println("List of all staffs with the role " + role.toLowerCase());
	    Response response = client.target("http://localhost:8080/ZooManagement/webservice/zoostaffs/query?role=" + role).request().buildGet().invoke();
	    List<ZooStaff> staffByRole = response.readEntity(new GenericType<List<ZooStaff>>() {});

	    for (ZooStaff zooStaff : staffByRole) {
	    	
	    	System.out.println(zooStaff);
	    	System.out.println("");
	    }
	    
	    
	    response.close();
	}
	
	private static void addStaff(Client client, Scanner scan) {
		//Adds a new staff to the zoo with POST
	    
		
	    System.out.println("Creating a new Staff");
		ZooStaff newStaff = new ZooStaff();
	    System.out.println("Name: ");
	    String name = scan.nextLine();
	    
	    System.out.println("Role (feeder/cleaner/vet): ");
	    String role = scan.nextLine();
	    
	    System.out.println("AnimalGroup (Apes/Cats/Fish): ");
	    String animalGroup = scan.nextLine();
	    
	    System.out.println("Salary: ");
	    int salary = scan.nextInt();
	    
		newStaff.setFullName(name);
		newStaff.setRole(role);
		newStaff.setAnimalGroup(animalGroup);
		newStaff.setSalary(salary);
		
		Entity staffEntity = Entity.entity(newStaff, "application/JSON");
		
		Response addstaff = client.target("http://localhost:8080/ZooManagement/webservice/zoostaffs").request().buildPost(staffEntity).invoke();
		
		System.out.println("added the staff: " + addstaff.readEntity(ZooStaff.class).getFullName());
		
		addstaff.close();
	}
	
	private static void removeStaff(Client client, Scanner scan) {
		//Uses DELETE to remove a staff from the zoo database
		
		System.out.println("Id of the staff you want to remove: ");
		int id = scan.nextInt();
		Response deleteStaff = client.target("http://localhost:8080/ZooManagement/webservice/zoostaffs/" + id).request().buildDelete().invoke();
		deleteStaff.close();
	}
	
	private static void updateStaff(Client client, Scanner scan) {
		//Uses PUT to update a staff from the zoo database
		
		
		System.out.println("Id of the staff you want to edit: ");
		int id = scan.nextInt();
		
		scan.nextLine();
		System.out.println("New Role (feeder/cleaner/vet): ");
		String role = scan.nextLine();
		
		System.out.println("New Salary: ");
		int salary = scan.nextInt();
		
		ZooStaff updatedStaff = new ZooStaff();
		updatedStaff.setRole(role);
		updatedStaff.setSalary(salary);			
		Entity staffEntity = Entity.entity(updatedStaff,"application/JSON");		
		Response updateStaff = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/2").request().buildPut(staffEntity).invoke();
		updateStaff.close();
	}
	
	
	
}

