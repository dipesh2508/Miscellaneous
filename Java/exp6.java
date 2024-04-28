import java.util.ArrayList;
import java.util.Scanner;

public class exp6 {
    public static void main(String[] args) {
        ArrayList<String> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to be inserted: ");
                    String item = scanner.nextLine();
                    itemList.add(item);
                    System.out.println("Inserted successfully");
                    break;
                case 2:
                    System.out.print("Enter the item to search : ");
                    String searchItem = scanner.nextLine();
                    if (itemList.contains(searchItem))
                        System.out.println("Item found in the list.");
                    else
                        System.out.println("Item not found in the list.");
                    break;
                case 3:
                    System.out.print("Enter the item to delete : ");
                    String deleteItem = scanner.nextLine();
                    if (itemList.contains(deleteItem)) {
                        itemList.remove(deleteItem);
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item does not exist.");
                    }
                    break;
                case 4:
                    System.out.println("The Items in the list are :");
                    for (String listItem : itemList) {
                        System.out.println(listItem);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
