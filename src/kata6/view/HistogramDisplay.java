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

public final class HistogramDisplay<T> extends ApplicationFrame {

    private final Histogram<T> histogram;
    private final String nameEjeX;
    private final String tituloChart;
    private final String nameEjeY;

    public HistogramDisplay(Histogram<T> histogram, String nameEjeX, String tituloChart, String nameEjeY) {
        super("HISTOGRAMA");
        this.nameEjeX = nameEjeX;
        this.histogram = histogram;
        this.tituloChart = tituloChart;
        this.nameEjeY = nameEjeY;
        
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel() {
        ChartPanel panel = new ChartPanel(createChart(createDataset()));
        panel.setPreferredSize(new Dimension(500, 400));
        return panel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart jfc =
                ChartFactory.createBarChart(tituloChart,
                nameEjeX,
                nameEjeY,
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return jfc;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataset;
    }

    public void execute() {
        setVisible(true);
    }
}
