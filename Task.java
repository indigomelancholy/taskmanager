public class Task {

    //creating the attributes..
    private int taskId;

    private String dueDate;
    private String description;
    private boolean completed;

    public Task(int taskId, String description, String dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.dueDate = dueDate;

        this.completed = false; //im setting the tasks to stay uncompleted by default so that the user could change that
    }

    //the following methods are the getter and setter ones
    public int getTaskId() {

        return taskId;
    }

    public String getDueDate() {

        return dueDate;
    }
    public String getDescription() {

        return description;
    }

    public boolean Completed() {

        return completed;
    }

    public void setCompleted() {
        this.completed = true;
    }



}