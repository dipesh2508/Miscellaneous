import java.util.Scanner;

class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 5.0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void receiveRating(int rating) {
        averageRating = (averageRating + rating) / 2.0;
    }
}

class VideoStore {
    private Video[] inventory;

    public VideoStore() {
        inventory = new Video[10];
    }

    public void addVideo(String title) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new Video(title);
                break;
            }
        }
    }

    public void checkOut(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && !video.isCheckedOut()) {
                video.checkOut();
                System.out.println("Video '" + title + "' checked out successfully.");
                return;
            }
        }
        System.out.println("Video '" + title + "' not found or already checked out.");
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && video.isCheckedOut()) {
                video.returnVideo();
                System.out.println("Video '" + title + "' returned successfully.");
                return;
            }
        }
        System.out.println("Video '" + title + "' not found or not checked out.");
    }

    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                System.out.println("Rating received for video '" + title + "'.");
                return;
            }
        }
        System.out.println("Video '" + title + "' not found.");
    }

    public void listInventory() {
        System.out.println("\nInventory:");
        for (Video video : inventory) {
            if (video != null) {
                System.out.println("Title: " + video.getTitle() +
                        ", Checked Out: " + video.isCheckedOut() +
                        ", Average Rating: " + video.getAverageRating());
            }
        }
    }
}

public class exp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();

        // Add 3 videos
        videoStore.addVideo("The Matrix");
        videoStore.addVideo("Godfather II");
        videoStore.addVideo("Star Wars Episode IV: A New Hope");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Rent a Video");
            System.out.println("2. Return a Video");
            System.out.println("3. Rate a Video");
            System.out.println("4. List Inventory");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    rentVideo(videoStore, scanner);
                    break;
                case 2:
                    returnVideo(videoStore, scanner);
                    break;
                case 3:
                    rateVideo(videoStore, scanner);
                    break;
                case 4:
                    videoStore.listInventory();
                    break;
                case 5:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void rentVideo(VideoStore videoStore, Scanner scanner) {
        System.out.print("Enter the title of the video you want to rent: ");
        String title = scanner.nextLine();
        videoStore.checkOut(title);
    }

    private static void returnVideo(VideoStore videoStore, Scanner scanner) {
        System.out.print("Enter the title of the video you want to return: ");
        String title = scanner.nextLine();
        videoStore.returnVideo(title);
    }

    private static void rateVideo(VideoStore videoStore, Scanner scanner) {
        System.out.print("Enter the title of the video you want to rate: ");
        String title = scanner.nextLine();
        System.out.print("Enter your rating (1-5): ");
        int rating = scanner.nextInt();
        videoStore.receiveRating(title, rating);
    }
}
