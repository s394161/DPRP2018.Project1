import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TimerSaver implements org.quartz.Job {
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println(">> Tajmer zapisywacz <<");

        PersonList personList = PersonList.getInstance();
        if (personList.size() > 0) {

            System.out.println("Zapisze do pliku tyle nowych osob: " + personList.size());

            List<String> content = new ArrayList<>();

            try {
                content = Files.readAllLines(Paths.get("odp.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.out.println("Plik odp.txt nie istnieje na razie. Bedzie tworzony od nowa.");
            }

            PrintWriter writer = null;
            try {
                writer = new PrintWriter("odp.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (content.size() > 0) {
                for (int i = 0; i < content.size(); i = i + 4) {
                    Person person = new Person(content.get(i), content.get(i + 1), new Pesel(content.get(i + 2)));

                    for (Person item : personList) {
                        if(!item.getPesel().toString().equals(person.getPesel().toString())){
                            personList.addPerson(person);
                        }
                    }
                }
            }

            personList.sortByCity();

            for (Person person : personList) {
                writer.println(person.getCity());
                writer.println(person.getName());
                writer.println(person.getPesel());
                writer.println("");
            }

            if (writer != null) {
                writer.close();
            }

            personList.removeAllPersons();
        } else {
            System.out.println("Brak nowych osob do zapisania");
        }
        System.out.println("-----------------------");
    }
}
