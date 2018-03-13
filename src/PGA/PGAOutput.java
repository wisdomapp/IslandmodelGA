package PGA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.OutputBehavior;

public class PGAOutput implements OutputBehavior {

    @Override
    public void output(GeneticAlgorithm ga) {

	Scanner scanner = new Scanner(System.in);
	System.out.print("ファイル名を入力 > ");

	String input = scanner.nextLine();
	scanner.close();

	try {
	    File file = new File("..\\GeneticAlgorithm\\txtfiles\\", input + ".txt");
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
	    for (int gen = 0; gen < ga.getGeneration(); gen++) {
		for (int island = 0; island < ga.getISLAND(); island++) {
		    if (ga.getGrayF() == 0) {
			for (int pop = 0; pop < ga.getPoplation(); pop++) {
			    pw.println(ga.PGAdata[gen][island].poplation[pop] + " " + ga.PGAdata[gen][island].fit[pop]);
			}
		    } else if (ga.getGrayF() == 1) {
			for (int pop = 0; pop < ga.getPoplation(); pop++) {
			    pw.println(ga.Gray(ga.PGAdata[gen][island].poplation[pop]) + " "
				    + ga.PGAdata[gen][island].fit[pop]);
			}
		    }
		    pw.println("#");
		}
		pw.println("*");
	    }
	    pw.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
	System.out.println("保存終了");

    }

}