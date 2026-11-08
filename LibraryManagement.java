
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== LIBRARY BOOK RECORD MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book Record");
            System.out.println("2. Display All Book Records");
            System.out.println("3. Search Book Record");
            System.out.println("4. Append Book Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 4:
                    try {
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Availability Status: ");
                        String status = sc.nextLine();

                        FileOutputStream fout;

                        if (choice == 1) {
                            fout = new FileOutputStream("Library.txt");
                        } else {
                            fout = new FileOutputStream("Library.txt", true);
                        }

                        String data = id + "," + title + "," +
                                      author + "," + status + "\n";

                        fout.write(data.getBytes());
                        fout.close();

                        System.out.println("Book record successfully added to the file.");
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        FileInputStream fin =
                            new FileInputStream("Library.txt");

                        int ch;

                        System.out.println("\nAll Book Records:");

                        while ((ch = fin.read()) != -1) {
                            System.out.print((char) ch);
                        }

                        fin.close();
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Book ID to search: ");
                        int searchId = sc.nextInt();

                        FileInputStream fin =
                            new FileInputStream("Library.txt");

                        String data = "";
                        int ch;
                        boolean found = false;

                        while ((ch = fin.read()) != -1) {
                            if (ch == '\n') {
                                String[] record = data.split(",");

                                if (Integer.parseInt(record[0]) == searchId) {
                                    System.out.println("\nBook Found!");
                                    System.out.println("Book ID: " + record[0]);
                                    System.out.println("Book Title: " + record[1]);
                                    System.out.println("Author Name: " + record[2]);
                                    System.out.println("Availability Status: " + record[3]);
                                    found = true;
                                }

                                data = "";
                            } else if (ch != '\r') {
                                data = data + (char) ch;
                            }
                        }

                        if (!data.isEmpty()) {
                            String[] record = data.split(",");

                            if (Integer.parseInt(record[0]) == searchId) {
                                System.out.println("\nBook Found!");
                                System.out.println("Book ID: " + record[0]);
                                System.out.println("Book Title: " + record[1]);
                                System.out.println("Author Name: " + record[2]);
                                System.out.println("Availability Status: " + record[3]);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Book not found!");
                        }

                        fin.close();
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
