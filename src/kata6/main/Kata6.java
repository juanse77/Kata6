package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.Attribute;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    private String nameFile;
    private List<Mail> listMail;
    HistogramBuilder<Mail> builder;
    Histogram<Character> letters;
    Histogram<String> domains;

    public static void main(String[] args) {
        Kata6 kata4 = new Kata6();
        try {
            kata4.execute();
        } catch (IOException ex) {
            System.out.println("Error de entrada salida: " + ex.getMessage());
            System.out.println(ex.getStackTrace().toString());
        }
    }

    private void input() throws IOException {
        nameFile = "emailsfile.txt";
        listMail = MailListReader.read(nameFile);
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
    }

    private void output() {
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer Caracter").execute();
    }

    private void execute() throws IOException {
        input();
        process();
        output();
    }
}
