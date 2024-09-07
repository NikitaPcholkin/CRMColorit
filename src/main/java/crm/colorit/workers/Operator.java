package crm.colorit.workers;

import crm.colorit.util.Constants;
import crm.colorit.core.Database;
import crm.colorit.core.Managment;

public class Operator extends Managment {

    public Operator(int age, String lastName, String firstName) {
        super(age, lastName, firstName);
    }

    public Operator(int id) {
        super(id);
    }

    @Override
    public void startWork() {

    }

    @Override
    public void registerWorker() {
        Database.register(Constants.OPERATOR, getFirstName(), getLastName(), getAge());
    }

    @Override
    public void getWorkerInfo() {
        Database.getWorkerById(getId());
    }

    @Override
    public void kickWorker() {
        Database.deleteWorkerById(getId());
    }
}
