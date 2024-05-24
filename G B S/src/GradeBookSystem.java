import java.util.Scanner;

public class GradeBookSystem {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            if (!userManager.isLoggedIn()) {
                System.out.println("\nWelcome to the Grade Book System");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter username: ");
                        String regUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String regPassword = scanner.nextLine();
                        userManager.register(regUsername, regPassword, name);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = scanner.nextLine();
                        userManager.login(loginUsername, loginPassword);
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                Student student = userManager.getCurrentStudent();
                if (student != null) {
                    System.out.println("\nGrade Book System");
                    System.out.println("1. Add Subject");
                    System.out.println("2. Add Grade");
                    System.out.println("3. View Grades");
                    System.out.println("4. View Report");
                    System.out.println("5. Logout");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter subject name: ");
                            String subject = scanner.nextLine();
                            student.addSubject(subject);
                            System.out.println("Subject added.");
                            break;
                        case 2:
                            System.out.print("Enter subject name: ");
                            String subjectName = scanner.nextLine();
                            System.out.print("Enter grade: ");
                            int grade = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            student.addGrade(subjectName, grade);
                            System.out.println("Grade added.");
                            break;
                        case 3:
                            System.out.print("Enter subject name: ");
                            String viewSubject = scanner.nextLine();
                            System.out.println("Grades for " + viewSubject + ": " + student.getGrades(viewSubject));
                            break;
                        case 4:
                            System.out.println(student.getReport());
                            break;
                        case 5:
                            userManager.logout();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("Error: No student logged in.");
                }
            }
        }
        scanner.close();
    }
}
