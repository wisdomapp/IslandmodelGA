package PGA;

import GeneticAlgorithm.FitnessBehavior;
import GeneticAlgorithm.GeneticAlgorithm;

public class PGAFitness implements FitnessBehavior{

	//10進数変換
	public void conversion(GeneticAlgorithm ga){
		if(ga.getGrayF()==0){
			for(int island=0;island<ga.getISLAND();island++){
				for(int i=0;i<ga.getPoplation();i++){
					ga.PGAdata[ga.getCurrentgeneration()][island].decimalNumber[i]=
							Integer.parseInt(ga.PGAdata[ga.getCurrentgeneration()][island].poplation[i],2);
					//System.out.println(ga.PGAdata[ga.getCurrentgeneration()][island].decimalNumber[i]);
				}
			}
			System.out.println("binary解釈で10進数に変換.");
		}else if(ga.getGrayF()==1){
			//グレイコード変換
			for(int island=0;island<ga.getISLAND();island++){
				for(int i=0;i<ga.getPoplation();i++){
					ga.PGAdata[ga.getCurrentgeneration()][island].decimalNumber[i]=
							Integer.parseInt(ga.Gray(ga.PGAdata[ga.getCurrentgeneration()][island].poplation[i]),2);
					//System.out.println(ga.PGAdata[ga.getCurrentgeneration()][island].decimalNumber[i]);
				}
			}
			System.out.println("graycode解釈で10進数に変換.");
		}
	}

	public void conpatible(GeneticAlgorithm ga) {
		double multi=Math.pow(2.0,ga.getGeneSize());
		for(int island=0;island<ga.getISLAND();island++){
			for(int i=0;i<ga.getPoplation();i++){
				double x=ga.PGAdata[ga.getCurrentgeneration()][island].decimalNumber[i]/multi;
				ga.PGAdata[ga.getCurrentgeneration()][island].fit[i]=ga.fitnessFunction(x);//適合度関数
				//System.out.println("island["+island+"]の適合度は"+ga.PGAdata[ga.getCurrentgeneration()][island].fit[i]);
			}
		}
		System.out.println("適合度評価完了.");
	}
}