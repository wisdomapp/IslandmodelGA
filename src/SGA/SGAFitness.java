package SGA;

import GeneticAlgorithm.FitnessBehavior;
import GeneticAlgorithm.GeneticAlgorithm;

public class SGAFitness implements FitnessBehavior {

    // 10進数変換
    @Override
    public void conversion(GeneticAlgorithm ga) {
	if (ga.getGrayF() == 0) {
	    for (int i = 0; i < ga.getPoplation(); i++) {
		ga.SGAdata[ga.getCurrentgeneration()].decimalNumber[i] = Integer
			.parseInt(ga.SGAdata[ga.getCurrentgeneration()].poplation[i], 2);
		// System.out.println(ga.SGAdata[ga.getCurrentgeneration()].decimalNumber[i]);
	    }
	    System.out.println("binary解釈で10進数に変換.");
	} else if (ga.getGrayF() == 1) {
	    // グレイコード変換
	    for (int i = 0; i < ga.getPoplation(); i++) {
		ga.SGAdata[ga.getCurrentgeneration()].decimalNumber[i] = Integer
			.parseInt(ga.Gray(ga.SGAdata[ga.getCurrentgeneration()].poplation[i]), 2);
		// System.out.println(ga.SGAdata[ga.getCurrentgeneration()].decimalNumber[i]);
	    }
	    System.out.println("graycode解釈で10進数に変換.");
	}
    }

    @Override
    public void conpatible(GeneticAlgorithm ga) {
	double multi = Math.pow(2.0, ga.getGeneSize());
	for (int i = 0; i < ga.getPoplation(); i++) {
	    double x = ga.SGAdata[ga.getCurrentgeneration()].decimalNumber[i] / multi;
	    ga.SGAdata[ga.getCurrentgeneration()].fit[i] = ga.fitnessFunction(x);// 適合度関数
	    // System.out.println("Pop2["+i+"]の適合度は"+ga.SGAdata[ga.getCurrentgeneration()].fit[i]);
	}
	System.out.println("適合度評価完了.");
    }
}