package GeneticAlgorithm;

import java.util.Scanner;

public abstract class GeneticAlgorithm {

    private int GAtype; // GAtype選択
    private int ISLAND = 4; // 島の数
    private int IMMIGRATION = 25; // 移住イベント世代数
    private double probability = 1.0;// 交叉確率
    private int grayF; // グレイコードフラグ
    private int poplation; // 集団数
    private int geneSize; // 個体長
    private int generation; // 世代数
    private int crossingF; // 交叉フラグ
    private boolean fileF; // ファイル保存フラグ
    private int currentisland; // 現在の島
    private int currentgeneration; // 現在の世代
    public Data[] SGAdata; // SGA用構造体
    public Data[][] PGAdata; // PGA用構造体
    public InitializationBehavior initializationBehavior;
    public FitnessBehavior fitnessBehavior;
    public EliteBehavior eliteBehavior;
    public SelectionBehavior selectionBehavior;
    public CrossoverBehavior crossoverBehavior;

    public GeneticAlgorithm() {

    }

    // 初期化
    public void performInitialization(GeneticAlgorithm ga) {
	initializationBehavior.initialization(ga);// 初期集団生成
    }

    // 評価
    public void performFitness(GeneticAlgorithm ga) {
	fitnessBehavior.conversion(ga);// １０進数変換
	fitnessBehavior.conpatible(ga);// 適合度計算
    }

    // エリート戦略
    public void performElite(GeneticAlgorithm ga) {
	eliteBehavior.eliteStrat(ga);// エリート保存
    }

    // 選択
    public void performSelection(GeneticAlgorithm ga) {
	selectionBehavior.selection(ga);// ルーレット選択
    }

    // 交叉
    public void performCrossover(GeneticAlgorithm ga) {
	if (ga.getCrossingF() == 0) {
	    crossoverBehavior.OnePointcrossover(ga);
	} else if (ga.getCrossingF() == 1) {
	    crossoverBehavior.MaskCrossover(ga);
	}

    }

    // 突然変異
    public void performMutation() {

    }

    // ファイル出力
    public void performOutput() {

    }

    // 初期入力
    public void FirstInput() {
	System.out.println("世代数を設定してください。");
	setGeneration(intReader());
	System.out.println("集団数を設定してください。");
	setPoplation(intReader());
	System.out.println("遺伝子長を設定してください。");
	setGeneSize(intReader());
	System.out.println("binaryなら0,graycodeなら1を入力してください。");
	setGrayF(intReader());
	System.out.println("一点交叉なら0,一様交叉なら1を入力してください。");
	setCrossingF(intReader());
    }

    // int型標準入力
    public static int intReader() {
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	int line = in.nextInt();// 文字列の入力受付
	return line;
    }

    // graycode変換
    public String Gray(String Pop) {
	String Tmp = "";
	for (int z = 0; Pop.length() > z; z++) {
	    if (z == 0) {
		Tmp += String.valueOf(Pop.charAt(0));
	    } else {
		char t0, t1;
		int s0, s1;
		t0 = Pop.charAt(z);
		t1 = Tmp.charAt(z - 1);
		s0 = Integer.parseInt(String.valueOf(t0));
		s1 = Integer.parseInt(String.valueOf(t1));
		int h = s0 ^ s1;
		Tmp += String.valueOf(h);
	    }

	}
	return Tmp;
    }

    public double fitnessFunction(double tmp) {
	// Pop3[i]=Math.abs(Math.sin(5*Math.PI*tmp));
	// Pop3[i]=tmp*Math.abs(Math.sin(4*Math.PI*tmp));//関数(GraphPanelも修正必須)
	double x = -4 * tmp * (tmp - 1);// 適合度関数
	return x;
    }

    // アクセサ
    public int getISLAND() {
	return ISLAND;
    }

    public void setISLAND(int iSLAND) {
	ISLAND = iSLAND;
    }

    public int getIMMIGRATION() {
	return IMMIGRATION;
    }

    public void setIMMIGRATION(int iMMIGRATION) {
	IMMIGRATION = iMMIGRATION;
    }

    public int getGrayF() {
	return grayF;
    }

    public void setGrayF(int grayF) {
	this.grayF = grayF;
    }

    public int getPoplation() {
	return poplation;
    }

    public void setPoplation(int poplation) {
	this.poplation = poplation;
    }

    public int getGeneSize() {
	return geneSize;
    }

    public void setGeneSize(int geneSize) {
	this.geneSize = geneSize;
    }

    public int getGeneration() {
	return generation;
    }

    public void setGeneration(int generation) {
	this.generation = generation;
    }

    public int getCrossingF() {
	return crossingF;
    }

    public void setCrossingF(int crossingF) {
	this.crossingF = crossingF;
    }

    public boolean isFileF() {
	return fileF;
    }

    public void setFileF(boolean fileF) {
	this.fileF = fileF;
    }

    public int getGAtype() {
	return GAtype;
    }

    public void setGAtype(int gAtype) {
	GAtype = gAtype;
    }

    public Data[] getSGAdata() {
	return SGAdata;
    }

    public void setSGAdata(Data[] sGAdata) {
	SGAdata = sGAdata;
    }

    public Data[][] getPGAdata() {
	return PGAdata;
    }

    public void setPGAdata(Data[][] pGAdata) {
	PGAdata = pGAdata;
    }

    public int getCurrentisland() {
	return currentisland;
    }

    public void setCurrentisland(int currentisland) {
	this.currentisland = currentisland;
    }

    public int getCurrentgeneration() {
	return currentgeneration;
    }

    public void setCurrentgeneration(int currentgeneration) {
	this.currentgeneration = currentgeneration;
    }

    public double getProbability() {
	return probability;
    }

    public void setProbability(double probability) {
	this.probability = probability;
    }

}