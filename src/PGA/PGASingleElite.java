package PGA;

import GeneticAlgorithm.EliteBehavior;
import GeneticAlgorithm.GeneticAlgorithm;

public class PGASingleElite implements EliteBehavior {

    @Override
    public void eliteStrat(GeneticAlgorithm ga) {
	int[] index = new int[ga.getISLAND()];
	double[] max = new double[ga.getISLAND()];

	for (int island = 0; island < ga.getISLAND(); island++) {
	    max[island] = ga.PGAdata[ga.getCurrentgeneration()][island].fit[0];
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		max[island] = Math.max(max[island], ga.PGAdata[ga.getCurrentgeneration()][island].fit[pop]);
	    }
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		if (ga.PGAdata[ga.getCurrentgeneration()][island].fit[pop] == max[island]) {
		    ga.PGAdata[ga.getCurrentgeneration()][island].Elite = index[island];
		    break;
		}
		index[island]++;
	    }
	    // System.out.println(island+"エリートインデックスは"+ga.PGAdata[ga.getCurrentgeneration()][island].Elite);

	}
	System.out.println("エリート保存完了.");
    }

}