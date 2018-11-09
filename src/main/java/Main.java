import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Scanner;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


public class Main {

    private static PersonList personList;

    public static void main(String[] args) {
        personList = PersonList.getInstance();

        setupScheduler();

        System.out.println("*Program do ewidencji mieszkańców*");

        while (true) {
            System.out.println(">>> Nastepna osoba:");

            Person person = new Person();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj miasto: ");
            person.setCity(scanner.nextLine());
            System.out.println(person.getCity());

            System.out.println("Podaj imię i nazwisko: ");
            person.setName(scanner.nextLine());
            System.out.println(person.getName());

            System.out.println("Podaj PESEL: ");
            Pesel pesel = new Pesel(scanner.next());
            person.setPesel(pesel);
            System.out.println(pesel.toString());


            if (pesel.isPeselValid()) {
                personList.addPerson(person);
                System.out.println("> PESEL ok, osoba dodana na liste.");
            } else {
                System.out.println("> PESEL zly, osoba nie zostanie dodana na liste.");
            }

        }

    }

    private static void setupScheduler() {
        try {
            Scheduler scheduler = null;
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail jobSaver = newJob(TimerSaver.class)
                    .withIdentity("job1", "group1")
                    .build();

            Trigger triggerSaver = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(cronSchedule("0/30 * * * * ? *"))
                    .build();

            scheduler.scheduleJob(jobSaver, triggerSaver);


            JobDetail jobChecker = newJob(TimerChecker.class)
                    .withIdentity("job2", "group1")
                    .build();

            Trigger triggerChecker = newTrigger()
                    .withIdentity("trigger2", "group1")
                    .withSchedule(cronSchedule("0/60 * * * * ? *"))
                    .build();

            scheduler.scheduleJob(jobChecker, triggerChecker);


        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
