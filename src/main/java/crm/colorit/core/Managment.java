package crm.colorit.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Managment {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Managment(int age, String lastName, String firstName) {;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Managment(int id) {
        this.id = id;
    }
    public abstract void startWork();
    public abstract void registerWorker();
    public abstract void getWorkerInfo();
    public abstract void kickWorker();
}
