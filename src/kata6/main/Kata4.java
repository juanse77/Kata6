package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata4 {
    
    private String fileName;
    private List<Mail> mailList;
    Histogram<String> histogram;
    HistogramDisplay histoDisplay;
            
    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
        kata4.execute();
    }
    
    private void input() throws IOException {
        fileName = "emailsfile.txt"; 
        mailList = MailListReader.read(fileName);
    }
    
    private void process() throws IOException {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.excute();
    }
    
    private void execute() throws IOException {
        input();
        process();
        output();       
    }
}
