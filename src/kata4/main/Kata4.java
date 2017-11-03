package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    
    public static void main(String[] args) throws IOException {
       final String fileName = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emailsfile.txt";
       List<Mail> mailList = MailListReader.read(fileName);
       Histogram<String> histogram = MailHistogramBuilder.build(mailList);
       HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
       histoDisplay.excute();
    }
}
