package kata6.model;

public class Person {
    private final Integer id;
    private final String name;
    private final Character gender;
    private final String birthDate;
    private final float weight;
    private final String mail;

    public Person(Integer id, String name, Character gender, String birthDate, float weight, String mail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.weight = weight;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public float getWeight() {
        return weight;
    }

    public String getMail() {
        return mail;
    }    
}
