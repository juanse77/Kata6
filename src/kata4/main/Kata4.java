package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

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
        fileName = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emailsfile.txt"; 
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
