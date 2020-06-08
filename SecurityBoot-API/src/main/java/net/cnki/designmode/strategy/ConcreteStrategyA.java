package net.cnki.designmode.strategy;

/**
 * 实现了抽象策略定义的接口，提供具体的算法实现。
 * @author ZhiPengyu
 * @ClassName:    [ConcreteStrategyA.java]
 * @Description:  [具体策略类A]
 * @CreateDate:   [2020年6月8日 上午10:25:19]
 */
public class ConcreteStrategyA implements ICalculator {

	@Override
	public String strategyMethod() {
		
		return "策略方法封装-A执行";
		// TODO Auto-generated method stub

	}

}
