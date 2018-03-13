package PGA;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.MutationBehavior;

public class PGAMutation implements MutationBehavior {

    @Override
    public void mutation(GeneticAlgorithm ga) {
	System.out.println("突然変異開始");
	for (int island = 0; island < ga.getISLAND(); island++) {

	    StringBuilder[] tmp = new StringBuilder[ga.getPoplation()];
	    double Mutpro = 1.0 / ga.getGeneSize();

	    for (int i = 0; i < ga.getPoplation(); i++) {
		tmp[i] = new StringBuilder("");
		// System.out.println("test");
		tmp[i].append(ga.PGAdata[ga.getCurrentgeneration()][island].crossover[i]);
	    }

	    for (int i = 0; i < ga.getPoplation(); i++) {
		for (int i2 = 0; i2 < ga.getGeneSize(); i2++) {
		    if (Math.random() <= Mutpro) {
			if (ga.PGAdata[ga.getCurrentgeneration()][island].crossover[i].charAt(i2) == '1') {
			    tmp[i].setCharAt(i2, '0');
			    System.out.println("NewPop2[" + i + "]の" + (i2 + 1) + "文字目が0に突然変異");
			} else {
			    tmp[i].setCharAt(i2, '1');
			    System.out.println("NewPop2[" + i + "]の" + (i2 + 1) + "文字目が1に突然変異");
			}
		    }
		}

	    }

	    for (int i3 = 0; i3 < ga.getPoplation(); i3++) {
		ga.PGAdata[ga.getCurrentgeneration()][island].mutation[i3] = new String(tmp[i3]);
		System.out.println("NewPop3[" + i3 + "]=" + ga.PGAdata[ga.getCurrentgeneration()][island].mutation[i3]);

	    }

	}

	System.out.println("突然変異終了");

    }

}