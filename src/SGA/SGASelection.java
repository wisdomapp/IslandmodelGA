package SGA;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.SelectionBehavior;

public class SGASelection implements SelectionBehavior {

    @Override
    public void selection(GeneticAlgorithm ga) {
	double tmp = 0.0;
	int[] select = new int[ga.getPoplation()];
	int index = 0;

	for (int pop = 0; pop < ga.getPoplation(); pop++) {
	    if (pop == ga.SGAdata[ga.getCurrentgeneration()].Elite) {
		pop++;
		if (pop >= ga.getPoplation())
		    break;
	    }
	    tmp += ga.SGAdata[ga.getCurrentgeneration()].fit[pop];
	}
	for (int pop = 0; pop < ga.getPoplation(); pop++) {
	    if (pop == ga.SGAdata[ga.getCurrentgeneration()].Elite) {
		pop++;
		if (pop >= ga.getPoplation())
		    break;
	    }
	    ga.SGAdata[ga.getCurrentgeneration()].probability[pop] = ga.SGAdata[ga.getCurrentgeneration()].fit[pop]
		    / tmp;
	    // System.out.println(ga.SGAdata[ga.getCurrentgeneration()].probability[pop]);
	}

	for (int pop = 0; pop < ga.getPoplation(); pop++) {
	    double multi = 0.0;
	    double roulette = Math.random();
	    // System.out.println((pop) + "回目のルーレットは" + roulette);
	    for (int pop2 = 0; pop2 < ga.getPoplation(); pop2++) {
		if (pop2 == ga.SGAdata[ga.getCurrentgeneration()].Elite) {
		    pop2++;
		    if (pop2 >= ga.getPoplation())
			break;
		}

		multi += ga.SGAdata[ga.getCurrentgeneration()].probability[pop2];
		if (multi > roulette) {
		    index = pop2;
		    break;
		}

	    }
	    System.out.println("選択されたのはPop[" + index + "]");
	    select[pop] = index;

	    ga.SGAdata[ga.getCurrentgeneration()].selection[pop] = ga.SGAdata[ga
		    .getCurrentgeneration()].poplation[select[pop]];
	    System.out.println(ga.SGAdata[ga.getCurrentgeneration()].selection[pop]);
	}
    }

}