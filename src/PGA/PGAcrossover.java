package PGA;

import java.util.ArrayList;
import java.util.Collections;

import GeneticAlgorithm.CrossoverBehavior;
import GeneticAlgorithm.GeneticAlgorithm;

public class PGAcrossover implements CrossoverBehavior {

    @Override
    public void OnePointcrossover(GeneticAlgorithm ga) {
	for (int island = 0; island < ga.getISLAND(); island++) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    int roop = ga.getPoplation() / 2;
	    for (int pop = 0; pop < ga.getPoplation(); pop++)
		list.add(pop);
	    Collections.shuffle(list);
	    if (Math.random() <= ga.getProbability()) {

		for (int pop = 0; pop < roop; pop++) {
		    int point = (int) (Math.random() * ga.getGeneSize()); // 何文字目で区切るか
		    String pop1 = ga.PGAdata[ga.getCurrentgeneration()][island].selection[list.get(pop * 2)]
			    .substring(0, point);
		    String pop2 = ga.PGAdata[ga.getCurrentgeneration()][island].selection[list.get(pop * 2)]
			    .substring(point);
		    String pop3 = ga.PGAdata[ga.getCurrentgeneration()][island].selection[list.get(pop * 2 + 1)]
			    .substring(0, point);
		    String pop4 = ga.PGAdata[ga.getCurrentgeneration()][island].selection[list.get(pop * 2 + 1)]
			    .substring(point);
		    ga.PGAdata[ga.getCurrentgeneration()][island].crossover[pop * 2] = pop1 + pop2;
		    ga.PGAdata[ga.getCurrentgeneration()][island].crossover[pop * 2 + 1] = pop3 + pop4;
		    System.out.println("pop[" + list.get(pop * 2) + "]とpop[" + list.get(pop * 2 + 1) + "]を"
			    + (point + 1) + "文字目で交叉.");
		}
		if (ga.getPoplation() % 2 == 1) {
		    ga.PGAdata[ga.getCurrentgeneration()][island].crossover[ga.getPoplation()
			    - 1] = ga.PGAdata[ga.getCurrentgeneration()][island].selection[ga.getPoplation() - 1];
		}
	    }

	    for (int pop = 0; pop < ga.getPoplation(); pop++) {

		System.out.println(ga.PGAdata[ga.getCurrentgeneration()][island].crossover[pop]);
	    }

	}
    }

    @Override
    public void MaskCrossover(GeneticAlgorithm ga) {
	for (int island = 0; island < ga.getISLAND(); island++) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int pop = 0; pop < ga.getPoplation(); pop++)
		list.add(pop);
	    int roop = ga.getPoplation() / 2;
	    StringBuilder[] tmp = new StringBuilder[ga.getPoplation()];
	    for (int pop = 0; pop < ga.getPoplation(); pop++) {
		tmp[pop] = new StringBuilder("");
		tmp[pop].append(ga.PGAdata[ga.getCurrentgeneration()][island].selection[pop]);
	    }
	    System.out.println("交叉開始.");
	    Collections.shuffle(list);
	    if (Math.random() <= ga.getProbability()) {

		char tmp2 = ' ';

		for (int pop = 0; pop < roop; pop++) {
		    String Mask = "";
		    for (int i = 0; i < ga.getGeneSize(); i++) {
			Mask += (int) (Math.random() + 0.5);
		    }
		    // System.out.println("PoP[" + list.get(pop * 2) + "]とPop["
		    // +
		    // list.get(pop * 2 + 1) + "]が交叉");
		    // System.out.println("マスクは" + Mask);
		    for (int z = 0; z < ga.getGeneSize(); z++) {
			if (Mask.charAt(z) == '0') {
			    // System.out.println((z + 1) + "文字目を交叉");
			    tmp2 = ga.PGAdata[ga.getCurrentgeneration()][island].selection[list.get(pop * 2)].charAt(z);
			    tmp[list.get(pop * 2)].setCharAt(z, tmp[pop].charAt(z));
			    tmp[list.get(pop * 2 + 1)].setCharAt(z, tmp2);
			}
		    }
		}
		for (int i = 0; i < ga.getPoplation(); i++) {

		    ga.PGAdata[ga.getCurrentgeneration()][island].crossover[i] = new String(tmp[i]);
		    // System.out.println(ga.PGAdata[ga.getCurrentgeneration()][island].crossover[i]);
		}
	    }
	    System.out.println("交叉終了.");
	}
    }

}