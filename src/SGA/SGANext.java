package SGA;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.NextBehavior;

public class SGANext implements NextBehavior {

    @Override
    public void eliteCheck(GeneticAlgorithm ga) {
	double[] tmp = new double[ga.getPoplation()];
	for (int pop = 0; pop < ga.getPoplation(); pop++) {
	    if (ga.getGrayF() == 0) {
		tmp[pop] = Integer.parseInt(ga.SGAdata[ga.getCurrentgeneration()].mutation[pop], 2)
			/ Math.pow(2.0, ga.getGeneSize());
	    } else if (ga.getGrayF() == 1) {
		tmp[pop] = Integer.parseInt(ga.Gray(ga.SGAdata[ga.getCurrentgeneration()].mutation[pop]), 2)
			/ Math.pow(2.0, ga.getGeneSize());
	    }
	    if (ga.SGAdata[ga.getCurrentgeneration()].fit[ga.SGAdata[ga.getCurrentgeneration()].Elite] < tmp[pop])
		break;
	    if (pop == ga.getPoplation() - 1) {
		int minindex = 0;
		for (int pop2 = 0; pop2 < ga.getPoplation(); pop2++) {
		    if (tmp[pop] < tmp[minindex])
			minindex = pop;
		}
		ga.SGAdata[ga.getCurrentgeneration()].mutation[minindex] = ga.SGAdata[ga
			.getCurrentgeneration()].poplation[ga.SGAdata[ga.getCurrentgeneration()].Elite];
	    }
	}
    }

    @Override
    public void next(GeneticAlgorithm ga) {
	ga.setCurrentgeneration((ga.getCurrentgeneration() + 1));
	ga.SGAdata[ga.getCurrentgeneration()].poplation = ga.SGAdata[ga.getCurrentgeneration() - 1].mutation;

    }

}