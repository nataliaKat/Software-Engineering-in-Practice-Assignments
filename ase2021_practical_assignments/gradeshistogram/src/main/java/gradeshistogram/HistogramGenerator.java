package gradeshistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Creates a histogram based on an input file.
 * 
 * @author Natalia Katsiapi
 *
 */
public class HistogramGenerator {

	/**
	 * Reads the grades from the file and returns them as an array of doubles.
	 * 
	 * @param filename
	 * @return gradesAsArray A double array of grades.
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

	/**
	 * Receives a single dimension array of ints. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The chart is
	 * generated and then presented in the screen.
	 * 
	 * @param dataValues Single dimension double array
	 */
	public void generateChart(double[] dataValues) {

		HistogramDataset dataset = new HistogramDataset();
		
		// This calculates the number of bins to be used which is the maximum grade + 1
		int numberOfBins = (int) Arrays.stream(dataValues).max().orElse(-1) + 1;
		dataset.addSeries("grade", dataValues, numberOfBins);

		JFreeChart histogram = ChartFactory.createHistogram("Grades Histogram", "Grade", "Frequency", dataset);
		ChartFrame frame = new ChartFrame("Grades", histogram);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		HistogramGenerator hs = new HistogramGenerator();
		double[] grades = hs.getGrades(args[0]);
		hs.generateChart(grades);
	}

}
