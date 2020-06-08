package net.cnki.designmode.strategy;

/**
 * 实现了抽象策略定义的接口，提供具体的算法实现。
 * @author ZhiPengyu
 * @ClassName:    [ConcreteStrategyB.java]
 * @Description:  [具体策略类B]
 * @CreateDate:   [2020年6月8日 上午10:25:03]
 */
public class ConcreteStrategyB implements ICalculator {

	@Override
	public String strategyMethod() {
		// TODO Auto-generated method stub
		return "策略方法封装-B执行";
	}

}
