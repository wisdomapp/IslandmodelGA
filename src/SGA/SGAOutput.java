package SGA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.OutputBehavior;

public class SGAOutput implements OutputBehavior{

	@Override
	public void output(GeneticAlgorithm ga) {


	    Scanner scanner = new Scanner(System.in);
	    System.out.print("ファイル名を入力 > ");

	    String input = scanner.nextLine();
	    scanner.close();



		try {
			File file = new File("..\\islandmodelGA\\txtfiles\\",input+".txt");
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		      for(int gen=0;gen<ga.getGeneration();gen++){
		    	  if(ga.getGrayF()==0){
		    		  for(int pop=0;pop<ga.getPoplation();pop++){
		    			  pw.println(ga.SGAdata[gen].mutation[pop]+" "+ga.SGAdata[gen].fit[pop]);
		    		  }
		    	  }else if(ga.getGrayF()==1){
		    		  for(int pop=0;pop<ga.getPoplation();pop++){
		    			  pw.println(ga.(data[i].Pop[i2])+" "+data[i].Pop3[i2]);
		    		  }
		    	  }
		    	  pw.println("#");
		      }
		      pw.close();
		    } catch (IOException e) {
		      System.out.println(e);
		    }
		System.out.println("保存終了");

	}

}