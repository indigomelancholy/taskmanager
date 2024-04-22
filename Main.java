import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(15);


        Task task1 = new Task(1, "Solve trigonometry problems", "12/04/2024");
        Task task2 = new Task(2, "Finish poster design", "15/04/2024");
        Task task3 = new Task(3, "Write english essay", "20/04/2024");
taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);



        while (true) { //printing out a menu
            System.out.println("*** Task Management System ***");

            System.out.println("1. Add a new task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. View all tasks");
            System.out.println("4. Display reports of tasks due today");
            System.out.println("5. Exit");

            System.out.print("Enter a number from the menu: ");

            int option = scan.nextInt();

            switch (option) { //using switch cases to organise the menu
                case 1:
                    System.out.print("Enter task ID: ");

                    int taskId = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter task description: ");
                    String desc = scan.nextLine();

                    System.out.print("Enter due date (day/month/year): ");
                    String dueDate = scan.nextLine();

                    if(isValidDate(dueDate)) {
                        Task task = new Task(taskId, desc, dueDate);
                        taskManager.addTask(task);

                    } else {

                        System.out.println("Invalid date!");

                    }
                    break;


                case 2:
                   try {
                       System.out.print("Enter task ID to mark it as complete: ");

                       int taskIdtoComp = scan.nextInt();
                       scan.nextLine();

                       taskManager.markCompleted(taskIdtoComp);
                   } catch (InputMismatchException e){
                       System.out.println("Invalid input!");
                       scan.nextLine();
                   }


                case 3:
if(taskManager.getNum() > 0){
    taskManager.viewTasks();
}else{
    System.out.println("No tasks left!");
}
                    break;


                case 4:
                    System.out.print("Enter today's date (day/month/year): ");
                    String currentDate = scan.next(); //we scan the current date

                    if(isValidDate(currentDate)) { //we check if the date is in the valid format
                        taskManager.report(currentDate);

                    } else {

                        System.out.println("Invalid date!");
                    }

                    break;


                case 5:
                    System.out.println("Exiting the application!");
                    System.exit(0);


                default:
                    System.out.println("Invalid option, please enter a number from 1 to 5.");
            }
        }
    }

    public static boolean isValidDate(String date) { //i had
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}