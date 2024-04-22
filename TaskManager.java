public class TaskManager {
    private Task[] arrtasks; //here i create the array in which i store the tasks
    private int numtasks; //this is the number of tasks in the arr
    public int getNum(){
        return numtasks;
    }

    public TaskManager(int max) { //i set a maximum to this array

        this.arrtasks = new Task[max];
        this.numtasks = 0;
    }

    public void addTask(Task newtask) {

        if (numtasks < arrtasks.length) {

            arrtasks[numtasks] = newtask; //creating a variable newtask
            numtasks = numtasks + 1;

            System.out.println("You just added a task.");

        } else {

            System.out.println("You are exceeding the application's task limit. You can't add more tasks.");
        } //alternative outcome if the application has reached its max limit
    }

    public void markCompleted(int taskId) {

        for (Task task : arrtasks) {

            if (task.getTaskId() == taskId) { //checking whether the id of the task we are looking for matches the task itself and that it exists in the array
                task.setCompleted(); //using the method from the Task class

                System.out.println("Task marked as completed.");

                return;
            }
        }

        System.out.println("The task you are looking for is not on the list!"); //alternative outcome if the id doesnt match
    }

    public void viewTasks() {
        System.out.println("Your tasks are:");

        for (Task task : arrtasks) {

            if (task != null) {
                System.out.println(task.getDescription() + "\n | Due: " + task.getDueDate() + "\n | Status: " + task.Completed()); //printing out the details of the task

            }
        }
    }

    public void report(String currentDate) {
        System.out.println("The tasks due today are:");

        for (Task task : arrtasks) {

            if (task.getDueDate().equals(currentDate) && task != null) { //if statement that checks only for the tasks due today
                System.out.println(task.getDescription()); //displaying their information
            }
        }
    }
}

