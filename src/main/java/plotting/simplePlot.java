package plotting;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
public class simplePlot extends JPanel {
    public static void plot(double arr[],String PlotName) {
        // Create a dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String seriesName="Convolution";
        for(int i=0;i<arr.length;i++)
        {
            dataset.addValue(arr[i], seriesName,  String.valueOf(i));
        }

        // Create a line chart
        JFreeChart chart = ChartFactory.createLineChart(
                PlotName,  // Chart title
                "index",              // X-Axis Label
                "value",             // Y-Axis Label
                dataset              // Dataset
        );

        // Display the chart in a JFrame
        JFrame frame = new JFrame("JFreeChart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
    public static void plot(int arr[][],String PlotName) {
        // Create a dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String seriesName="Convolution";
        for(int i=0;i<arr.length;i++)
        {
            dataset.addValue(arr[i][0], seriesName,  String.valueOf(i));
        }

        // Create a line chart
        JFreeChart chart = ChartFactory.createLineChart(
                PlotName,  // Chart title
                "index",              // X-Axis Label
                "value",             // Y-Axis Label
                dataset              // Dataset
        );

        // Display the chart in a JFrame
        JFrame frame = new JFrame("JFreeChart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}