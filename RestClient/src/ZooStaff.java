

public class ZooStaff {
	private int id;
	private String fullName;
	private String animalGroup;
	private String role;
	private int salary;

	public ZooStaff() {}
	
	public ZooStaff(String fullName, String animalGroup, String role, int salary) {
		this.fullName = fullName;
		this.animalGroup = animalGroup;
		this.role = role;
		this.salary = salary;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAnimalGroup(String animalGroup) {
		this.animalGroup = animalGroup;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAnimalGroup() {
		return animalGroup;
	}

	public String getRole() {
		return role;
	}

	public int getSalary() {
		return salary;
	}
	
	public String toString() {
		return "StaffId: " + this.id + "\nName: " + this.fullName + " \nRole: " + this.role + " for " + this.animalGroup;
	}
}