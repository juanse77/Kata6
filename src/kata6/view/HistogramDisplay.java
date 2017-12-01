package kata6.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public final class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    private JPanel createPanel() {
        ChartPanel panel = new ChartPanel(createChart(createDataset()));
        panel.setPreferredSize(new Dimension(500,400));
        return panel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart jfc = 
                ChartFactory.createBarChart(
                "JFreeChart",
                "Dominios email",
                "Nº email",
                dataset, 
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return jfc;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataset.addValue(histogram.get(key),"",key);
        }
        return dataset;
    }
    
    public void excute() {
        setVisible(true);
    }   
}
