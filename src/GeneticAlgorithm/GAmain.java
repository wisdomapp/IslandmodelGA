package GeneticAlgorithm;

import java.util.Scanner;

import SGA.SGA;

public class GAmain{

	public static void main(String[] args){

		System.out.println("SGAなら0,PGAなら1.");
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int line = in.nextInt();//文字列の入力受付
        if(line==0){
        	GeneticAlgorithm ga=new SGA();
        	ga.FirstInput();
        	ga.performInitialization(ga);
        }else if(line==1){

        }

	}

}