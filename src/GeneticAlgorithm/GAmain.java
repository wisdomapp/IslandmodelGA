package GeneticAlgorithm;

import java.util.Scanner;

import PGA.PGA;
import SGA.SGA;

public class GAmain{
	private static GeneticAlgorithm ga;
	public static void main(String[] args){

		System.out.println("SGAなら0,PGAなら1.");
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int line = in.nextInt();//文字列の入力受付
        if(line==0){
        	GeneticAlgorithm ga=new SGA();
        	GAmain.ga=ga;
        }else if(line==1){
        	GeneticAlgorithm ga=new PGA();
        	GAmain.ga=ga;
        }
    	ga.FirstInput(); //初期入力
    	ga.performInitialization(ga); //初期化
    	//ga.performFitness(ga); //評価

	}

}