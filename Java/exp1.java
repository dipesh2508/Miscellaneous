import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    String designation;
    double salary;

    Employee(int id, String name, String department, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nDepartment: " + department + "\nDesignation: " + designation + "\nSalary: " + salary;
    }
}

public class exp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[10]; 
        int employeeCount = 0;

        int choice;
        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the number

            switch (choice) {
                case 1:
                    if (employeeCount < employees.length) {
                        addEmployee(scanner, employees, employeeCount);
                        employeeCount++;
                    } else {
                        System.out.println("Employee array is full. Cannot add more employees.");
                    }
                    break;

                case 2:
                    searchEmployee(scanner, employees, employeeCount);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);
    }

    private static void addEmployee(Scanner scanner, Employee[] employees, int index) {
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the number

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter the employee's salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        employees[index] = new Employee(id, name, department, designation, salary);
        System.out.println("Employee added successfully.");
    }

    private static void searchEmployee(Scanner scanner, Employee[] employees, int employeeCount) {
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].id == id) {
                found = true;
                System.out.println("Employee found:");
                System.out.println(employees[i]);
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found");
        }
    }
}