import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class exp7 {
    private static final String FILENAME = "employees.txt";
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        loadEmployees();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMain Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting the System");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, age, salary));
        saveEmployees();
    }

    private static void displayAllEmployees() {
        System.out.println("----Report-----");
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getAge() + " " + employee.getSalary());
        }
        System.out.println("----End of Report-----");
    }

    private static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                double salary = Double.parseDouble(parts[3]);
                employees.add(new Employee(id, name, age, salary));
            }
        } catch (IOException | NumberFormatException e) {
            // File may not exist or may be corrupted, so just ignore and start with an empty list
        }
    }

    private static void saveEmployees() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Employee employee : employees) {
                writer.println(employee.getId() + "," + employee.getName() + "," + employee.getAge() + "," + employee.getSalary());
            }
        } catch (IOException e) {
            System.err.println("Error saving employees: " + e.getMessage());
        }
    }
}
