package crm.colorit.workers;

import crm.colorit.core.Database;
import crm.colorit.core.Managment;
import crm.colorit.util.Constants;

public class Cleaner extends Managment {

    public Cleaner(int age, String lastName, String firstName) {
        super(age, lastName, firstName);
    }

    @Override
    public void startWork() {
        System.out.println("Cleaner: starting work");
    }

    @Override
    public void registerWorker() {
        Database.register(Constants.CLEANER, getFirstName(), getLastName(), getAge());
    }

    @Override
    public void getWorkerInfo() {

    }

    @Override
    public void kickWorker() {

    }
}
