package crm.colorit.workers;

import crm.colorit.core.Database;
import crm.colorit.core.Managment;
import crm.colorit.util.Constants;

public class Salesman extends Managment {

    public Salesman( int age, String lastName, String firstName) {
        super(age, lastName, firstName);
    }

    @Override
    public void startWork() {

    }

    @Override
    public void registerWorker() {
        Database.register(Constants.SALESMAN, getFirstName(), getLastName(), getAge());
    }

    @Override
    public void getWorkerInfo() {

    }

    @Override
    public void kickWorker() {

    }
}
