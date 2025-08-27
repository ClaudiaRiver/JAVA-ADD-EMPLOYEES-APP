import java.util.Scanner;
import java.util.ArrayList;

class Employee {
    String id;
    String name;
    String department;

    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n📋 EMPLOYEE MANAGEMENT MENU");
            System.out.println("1. Register new employee");
            System.out.println("2. Search employee by ID");
            System.out.println("3. Delete employee by ID");
            System.out.println("4. Show all employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Full Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Department: ");
                    String department = scanner.nextLine();
                    employeeList.add(new Employee(id, name, department));
                    System.out.println("✅ Employee registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    String searchId = scanner.nextLine();
                    boolean found = false;
                    for (Employee emp : employeeList) {
                        if (emp.id.equalsIgnoreCase(searchId)) {
                            System.out.println("👤 Employee found:");
                            System.out.println("ID: " + emp.id);
                            System.out.println("Name: " + emp.name);
                            System.out.println("Department: " + emp.department);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Employee not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean deleted = false;
                    for (Employee emp : employeeList) {
                        if (emp.id.equalsIgnoreCase(deleteId)) {
                            employeeList.remove(emp);
                            System.out.println("🗑️ Employee deleted successfully.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("❌ Employee not found. Cannot delete.");
                    }
                    break;

                case 4:
                    System.out.println("\n📃 List of Employees:");
                    if (employeeList.isEmpty()) {
                        System.out.println("⚠️ No employees registered.");
                    } else {
                        for (Employee emp : employeeList) {
                            System.out.println("- " + emp.id + " | " + emp.name + " | " + emp.department);
                        }
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("👋 Program terminated.");
                    break;

                default:
                    System.out.println("⚠️ Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}