import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonList extends ArrayList<Person> {

    private static PersonList instance;

    private PersonList() {
    }

    public static synchronized PersonList getInstance() {
        if (instance == null) {
            instance = new PersonList();
        }
        return instance;
    }

    void addPerson(Person person){
        add(person);
    }

    void removeAllPersons(){
        clear();
    }

    void sortByCity(){
        if (size() > 0) {
            Collections.sort(this, new Comparator<Person>() {
                @Override
                public int compare(final Person object1, final Person object2) {
                    return object1.getCity().compareTo(object2.getCity());
                }
            });
        }
    }
}
