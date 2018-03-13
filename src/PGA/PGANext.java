package PGA;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.NextBehavior;

public class PGANext implements NextBehavior {

    @Override
    public void eliteCheck(GeneticAlgorithm ga) {
	for (int island = 0; island < ga.getISLAND(); island++) {
	    double[] tmp = new double[ga.getPoplation()];
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		if (ga.getGrayF() == 0) {
		    tmp[pop] = Integer.parseInt(ga.PGAdata[ga.getCurrentgeneration()][island].mutation[pop], 2)
			    / Math.pow(2.0, ga.getGeneSize());
		} else if (ga.getGrayF() == 1) {
		    tmp[pop] = Integer.parseInt(ga.Gray(ga.PGAdata[ga.getCurrentgeneration()][island].mutation[pop]), 2)
			    / Math.pow(2.0, ga.getGeneSize());
		}
		if (ga.PGAdata[ga.getCurrentgeneration()][island].fit[ga.PGAdata[ga
			.getCurrentgeneration()][island].Elite] < tmp[pop])
		    break;
		if (pop == ga.getPoplation() - 1) {
		    int minindex = 0;
		    for (int pop2 = 0; pop2 < ga.getPoplation(); pop2++) {
			if (tmp[pop] < tmp[minindex])
			    minindex = pop;
		    }
		    ga.PGAdata[ga.getCurrentgeneration()][island].mutation[minindex] = ga.PGAdata[ga
			    .getCurrentgeneration()][island].poplation[ga.PGAdata[ga
				    .getCurrentgeneration()][island].Elite];
		}
	    }
	}
    }

    @Override
    public void next(GeneticAlgorithm ga) {
	ga.setCurrentgeneration((ga.getCurrentgeneration() + 1));
	for (int island = 0; island < ga.getISLAND(); island++) {
	    ga.PGAdata[ga.getCurrentgeneration()][island].poplation = ga.PGAdata[ga.getCurrentgeneration()
		    - 1][island].mutation;
	}
    }

}