package SGA;

import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.MutationBehavior;

public class SGAMutation implements MutationBehavior{

	@Override
	public void mutation(GeneticAlgorithm ga) {
			System.out.println("突然変異開始");
			StringBuilder[] tmp = new StringBuilder[ga.getPoplation()];
			double Mutpro=1.0/ga.getGeneSize();
			
			for(int i=0;i<ga.getPoplation();i++){
				tmp[i]=new StringBuilder("");
				//System.out.println("test");
				tmp[i].append(ga.SGAdata[ga.getCurrentgeneration()].crossover[i]);
			}
			

			
			for(int i=0;i<ga.getPoplation();i++){
				for(int i2=0;i2<ga.getGeneSize();i2++){
					if(Math.random() <= Mutpro){
						if(ga.SGAdata[ga.getCurrentgeneration()].crossover[i].charAt(i2)=='1'){
							tmp[i].setCharAt(i2,  '0');
							System.out.println("NewPop2["+i+"]の"+(i2+1)+"文字目が0に突然変異");
						}else{
							tmp[i].setCharAt(i2,  '1');
							System.out.println("NewPop2["+i+"]の"+(i2+1)+"文字目が1に突然変異");
						}
					}
				}
				
			}
			
			
			for(int i3=0;i3<ga.getPoplation();i3++){
				ga.SGAdata[ga.getCurrentgeneration()].crossover[i3]=new String(tmp[i3]);
				System.out.println("NewPop3["+i3+"]="+ga.SGAdata[ga.getCurrentgeneration()].crossover[i3]);
				
			}
			
			ga.setCurrentgeneration((ga.getCurrentgeneration()+1));
			System.out.println("突然変異終了");
			
			
		
	}
	
}