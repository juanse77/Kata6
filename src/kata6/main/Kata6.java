package kata6.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.Attribute;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    private String nameFile;
    private List<Mail> listMail;
    private List<Person> people;
    HistogramBuilder<Mail> builder;
    HistogramBuilder<Person> builderPerson;
    Histogram<Character> letters;
    Histogram<String> domains;
    Histogram<Character> gender;
    Histogram<Float> weight;

    public static void main(String[] args) {
        Kata6 kata4 = new Kata6();
        try {
            kata4.execute();
        } catch (IOException ex) {
            System.out.println("Error de entrada salida: " + ex.getMessage());
            System.out.println(ex.getStackTrace().toString());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de carga de la clase: " + ex.getMessage());
            System.out.println(ex.getStackTrace().toString());
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
            System.out.println(ex.getStackTrace().toString());
        }
    }

    private void input() throws IOException, ClassNotFoundException, SQLException {
        nameFile = "emailsfile.txt";
        listMail = MailListReader.read(nameFile);
        people = DataBaseList.read();
    }

    private void process() throws IOException {
        builder = new HistogramBuilder<>(listMail);
        domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });

        letters = builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });

        builderPerson = new HistogramBuilder<>(people);
        gender = builderPerson.build(new Attribute<Person, Character>() {
            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });

        weight = builderPerson.build(new Attribute<Person, Float>() {
            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
        });
    }

    private void output() {
        new HistogramDisplay(domains, "Dominios", "Distribución de emails").execute();
        new HistogramDisplay(letters, "Primer Caracter", "Distribución de caracteres").execute();
        new HistogramDisplay(gender, "Género", "Distribución de géneros").execute();
        new HistogramDisplay(weight, "Pesos", "Distribución de pesos").execute();
    }

    private void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
}
