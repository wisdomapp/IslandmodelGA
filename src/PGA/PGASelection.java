package PGA;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.SelectionBehavior;

public class PGASelection implements SelectionBehavior {

    @Override
    public void selection(GeneticAlgorithm ga) {
	double[] tmp = new double[ga.getISLAND()];

	for (int island = 0; island < ga.getISLAND(); island++) {
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		if (pop == ga.PGAdata[ga.getCurrentgeneration()][island].Elite) {
		    pop++;
		    if (pop >= ga.getPoplation())
			break;
		}
		tmp[island] += ga.PGAdata[ga.getCurrentgeneration()][island].fit[pop];
	    }
	}
	for (int island = 0; island < ga.getISLAND(); island++) {
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		if (pop == ga.PGAdata[ga.getCurrentgeneration()][island].Elite) {
		    pop++;
		    if (pop >= ga.getPoplation())
			break;
		}
		ga.PGAdata[ga.getCurrentgeneration()][island].probability[pop] = ga.PGAdata[ga
			.getCurrentgeneration()][island].fit[pop] / tmp[island];
		// System.out.println(ga.PGAdata[ga.getCurrentgeneration()][island].probability[pop]);
	    }
	}
	for (int island = 0; island < ga.getISLAND(); island++) {
	    int[] select = new int[ga.getPoplation()];
	    int index = 0;
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		double multi = 0.0;
		double roulette = Math.random();
		// System.out.println((pop) + "回目のルーレットは" + roulette);
		for (int pop2 = 0; pop2 < ga.getPoplation(); pop2++) {
		    if (pop2 == ga.PGAdata[ga.getCurrentgeneration()][island].Elite) {
			pop2++;
			if (pop2 >= ga.getPoplation())
			    break;
		    }

		    multi += ga.PGAdata[ga.getCurrentgeneration()][island].probability[pop2];
		    if (multi > roulette) {
			index = pop2;
			break;
		    }

		}
		// System.out.println("選択されたのはPop[" + index + "]");
		select[pop] = index;

		ga.PGAdata[ga.getCurrentgeneration()][island].selection[pop] = ga.PGAdata[ga
			.getCurrentgeneration()][island].poplation[select[pop]];
		/// System.out.println(ga.PGAdata[ga.getCurrentgeneration()][island].selection[pop]);
	    }
	}
	System.out.println("ルーレット選択完了.");
    }

}