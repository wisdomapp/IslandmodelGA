package SGA;

import GeneticAlgorithm.EliteBehavior;
import GeneticAlgorithm.GeneticAlgorithm;

public class SGASingleElite implements EliteBehavior{

	public void eliteStrat(GeneticAlgorithm ga) {
		int index=0;
		double max=ga.SGAdata[ga.getCurrentgeneration()].fit[0];
		for(int pop=0;pop<ga.getPoplation();pop++){
			max=Math.max(max, ga.SGAdata[ga.getCurrentgeneration()].fit[pop]);
		}
		for(int pop=0;pop<ga.getPoplation();pop++){
			if(ga.SGAdata[ga.getCurrentgeneration()].fit[pop]==max){
				ga.SGAdata[ga.getCurrentgeneration()].Elite=index;
				break;
			}
			index++;
		}
		System.out.println("エリートインデックスは"+ga.SGAdata[ga.getCurrentgeneration()].Elite);
	}
	
}