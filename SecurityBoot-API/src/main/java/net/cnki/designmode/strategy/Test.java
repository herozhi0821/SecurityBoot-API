package net.cnki.designmode.strategy;

public class Test {

	public static void main(String[] args) {
		//采用环境类，将具体采用哪个封装算法的逻辑进行分装，以供用户直接使用
		Context c =new Context();//厨房
		ICalculator iCalculator = new ConcreteStrategyA();//清蒸，ICalculator做的方式
		c.setiCalculator(iCalculator);
		System.out.println(c.strategyMethod());
		
		iCalculator = new ConcreteStrategyB();//红烧，ICalculator做的方式
		c.setiCalculator(iCalculator);
		System.out.println(c.strategyMethod());
		
		System.out.println("-----------------");
		//不采用环境类，方法的选择不进行封装，使用时直接或间接确定
		ICalculator iCalculator1 = new ConcreteStrategyA();
		System.out.println(iCalculator1.strategyMethod());
	}

}
