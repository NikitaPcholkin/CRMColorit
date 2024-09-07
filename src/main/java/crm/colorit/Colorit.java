package crm.colorit;

import crm.colorit.core.Managment;
import crm.colorit.workers.Cleaner;
import crm.colorit.workers.Operator;
import crm.colorit.workers.Salesman;
import crm.colorit.util.WorkersUtil;

import java.lang.reflect.Constructor;
import java.util.Scanner;

import static crm.colorit.util.Utils.clearConsole;
import static crm.colorit.util.Utils.sendConsole;

public class Colorit {

    public static void startup() {
        Scanner scanner = new Scanner(System.in);
        sendConsole("[1] Зарегистрировать работника" +
                "\n[2] Получить информацию о работнике" +
                "\n[3] Уволить работника" +
                "\nВыберите действие: ");

        int selected = scanner.nextInt();

        switch (selected) {
            case 1: register(); break;
            case 2: getInfo(); break;
            case 3: kick(); break;
            default:
                sendConsole("Ошибка");
                System.out.close();
        }

    }

    public static void register() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        sendConsole(  "[1] Уборщик" +
                "\n[2] Продавец" +
                "\n[3] Оператор" +
                "\nВыберите рабочее место: ");
        int selectedWorkd = scanner.nextInt();

        switch (selectedWorkd) {
            case 1: registerWorker(Cleaner.class); break;
            case 2: registerWorker(Salesman.class); break;
            case 3: registerWorker(Operator.class); break;
        }
    }

    public static void registerWorker(Class<? extends Managment> workerClass) {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        sendConsole("Введите имя работника: ");
        String firstName = scanner.nextLine();
        clearConsole();
        sendConsole("Введите фамилию работника: ");
        String lastName = scanner.nextLine();
        clearConsole();
        sendConsole("Введите сколько полных лет работнику: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        clearConsole();
        try {
            Constructor<? extends Managment> constructor = workerClass.getConstructor(int.class, String.class, String.class);
            Managment worker = constructor.newInstance(age, lastName, firstName);
            worker.registerWorker();
            clearConsole();
        } catch (Exception e) {
            sendConsole("Ошибка при создании работника: " + e.getMessage());
        }
    }

    public static void getInfo() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        sendConsole("Введите идентификатор работника для получения информации: ");
        int id = scanner.nextInt();
        Managment worker = new WorkersUtil(id);
        worker.getWorkerInfo();
    }

    public static void kick() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        sendConsole("Введите идентификатор увольняемого работника: ");
        int id = scanner.nextInt();
        Managment worker = new WorkersUtil(id);
        worker.kickWorker();
    }
}
