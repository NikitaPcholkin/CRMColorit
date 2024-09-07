package crm.colorit.util;

import crm.colorit.core.Database;
import crm.colorit.core.Managment;

public class WorkersUtil extends Managment {
    public WorkersUtil(int id) {
        super(id);
    }
    @Override
    public void startWork() {

    }

    @Override
    public void registerWorker() {

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
