public class Person {

    private String city;
    private String name;
    private Pesel pesel;

    public Person() {
    }

    public Person(String city, String name, Pesel pesel) {
        this.city = city;
        this.name = name;
        this.pesel = pesel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }
}
