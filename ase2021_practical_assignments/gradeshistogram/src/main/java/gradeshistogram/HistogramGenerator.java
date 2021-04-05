/**
 * 
 */
package gradeshistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author Natalia Katsiapi
 *
 */
public class HistogramGenerator {

	/**
	 * The method reads the grades from the file and returns them as an array of doubles. 
	 * 
	 * @param filename
	 * @return an array of doubles
	 */
	public double[] getGrades(String filename) {
		List<Double> grades = new ArrayList();
		File gradesFile = new File(filename);
		Scanner reader;	
		try {
			reader = new Scanner(gradesFile);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				try {
					grades.add(Double.parseDouble((data)));
				} catch (NumberFormatException ex) {
					System.out.println("Misformated number");
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
		double[] gradesAsArray = new double[grades.size()];
		for (int i = 0; i < gradesAsArray.length; i++) {
			gradesAsArray[i] = grades.get(i);
		}
		return gradesAsArray;
	}
	
	/***
	 * Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 * 
	 * @param dataValues Single dimension double array
	 */
	public void generateChart(double[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend	
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Students", "Grades", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("Grades", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		HistogramGenerator hs = new HistogramGenerator();
		double[] grades = hs.getGrades(args[0]);
		for(double g : grades) {
			System.out.println(g);
		}
		hs.generateChart(grades);
	}

}
