package org.jfree.chart.demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedXYPlotDemo2 extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    public CombinedXYPlotDemo2(String s) {
        super(s);
        JFreeChart jfreechart = createCombinedChart();
        ChartPanel chartpanel = new ChartPanel(jfreechart, true, true, true, true, true);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createCombinedChart() {
        IntervalXYDataset dataset1 = createDataset1();
        XYBarRenderer renderer1 = new XYBarRenderer(0.20000000000000001D);
        renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.0")));
        XYPlot plot1 = new XYPlot(dataset1, new DateAxis("Date"), null, renderer1);
        //
        XYDataset dataset2 = createDataset2();
        StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.0")));
        XYPlot plot2 = new XYPlot(dataset2, new DateAxis("Date"), null, renderer2);
        //
        NumberAxis valueAxis = new NumberAxis("Value");
        valueAxis.setTickMarkInsideLength(3F);
        CombinedRangeXYPlot combinedPlot = new CombinedRangeXYPlot(valueAxis);
        combinedPlot.add(plot1, 1);
        combinedPlot.add(plot2, 1);
        return new JFreeChart("Combined (Range) XY Plot", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);
    }

    private static IntervalXYDataset createDataset1() {
        TimeSeries timeseries = new TimeSeries("Series 1");
        timeseries.add(new Day(1, 3, 2002), 12353.299999999999D);
        timeseries.add(new Day(2, 3, 2002), 13734.4D);
        timeseries.add(new Day(3, 3, 2002), 14525.299999999999D);
        timeseries.add(new Day(4, 3, 2002), 13984.299999999999D);
        timeseries.add(new Day(5, 3, 2002), 12999.4D);
        timeseries.add(new Day(6, 3, 2002), 14274.299999999999D);
        timeseries.add(new Day(7, 3, 2002), 15943.5D);
        timeseries.add(new Day(8, 3, 2002), 14845.299999999999D);
        timeseries.add(new Day(9, 3, 2002), 14645.4D);
        timeseries.add(new Day(10, 3, 2002), 16234.6D);
        timeseries.add(new Day(11, 3, 2002), 17232.299999999999D);
        timeseries.add(new Day(12, 3, 2002), 14232.200000000001D);
        timeseries.add(new Day(13, 3, 2002), 13102.200000000001D);
        timeseries.add(new Day(14, 3, 2002), 14230.200000000001D);
        timeseries.add(new Day(15, 3, 2002), 11235.200000000001D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeseries);
        return timeseriescollection;
    }

    private static XYDataset createDataset2() {
        TimeSeries timeseries = new TimeSeries("Series 2");
        timeseries.add(new Day(3, 3, 2002), 6853.1999999999998D);
        timeseries.add(new Day(4, 3, 2002), 9642.2999999999993D);
        timeseries.add(new Day(5, 3, 2002), 8253.5D);
        timeseries.add(new Day(6, 3, 2002), 5352.3000000000002D);
        timeseries.add(new Day(7, 3, 2002), 3532D);
        timeseries.add(new Day(8, 3, 2002), 2635.3000000000002D);
        timeseries.add(new Day(9, 3, 2002), 3998.1999999999998D);
        timeseries.add(new Day(10, 3, 2002), 1943.2D);
        timeseries.add(new Day(11, 3, 2002), 6943.8999999999996D);
        timeseries.add(new Day(12, 3, 2002), 7843.1999999999998D);
        timeseries.add(new Day(13, 3, 2002), 6495.3000000000002D);
        timeseries.add(new Day(14, 3, 2002), 7943.6000000000004D);
        timeseries.add(new Day(15, 3, 2002), 8500.7000000000007D);
        timeseries.add(new Day(16, 3, 2002), 9595.8999999999996D);
        return new TimeSeriesCollection(timeseries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jfreechart = createCombinedChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[]) {
        CombinedXYPlotDemo2 combinedxyplotdemo2 = new CombinedXYPlotDemo2("Combined XY Plot Demo");
        combinedxyplotdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(combinedxyplotdemo2);
        combinedxyplotdemo2.setVisible(true);
    }
}
