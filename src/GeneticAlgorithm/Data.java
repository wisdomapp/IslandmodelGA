package GeneticAlgorithm;

public class Data{
	public String[] poplation={}; //初期集団
	public int[] decimalNumber={}; //10進数変換
	public double[] fit={};//適合度計算
	public double[] probability={}; //確率分布計算
	public int[] roulette={}; //ルーレット選択
	public String[] selection={}; //淘汰
	public String[] crossover={}; //交叉
	public String[] mutation={}; //突然変異
	public int Elite; //エリート個体

	public Data(int i){
		this.poplation=new String[i];//初期集団
		this.decimalNumber=new int[i]; //10進数変換
		this.fit=new double[i];//適合度計算
		this.probability=new double[i]; //確率分布計算
		this.roulette=new int[i]; //ルーレット選択
		this.selection=new String[i]; //淘汰
		this.crossover=new String[i]; //交叉
		this.mutation=new String[i]; //突然変異
		this.Elite=i; //エリート個体
	}
}