package Library;

public abstract class User {

    protected String name;
    protected String student_ID;
    protected Operation[] operations;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String student_ID) {
        this.name = name;
        this.student_ID = student_ID;
    }

    public String getName() {
        return name;
    }

    public String getStudent_ID() {
        return student_ID;
    }
    abstract public String toString();

    abstract public void menu(Database database, User user);
}

