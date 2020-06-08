package net.cnki.designmode.strategy;

/**
 * 定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 * @author ZhiPengyu
 * @ClassName:    [ICalculator.java]
 * @Description:  [抽象策略类]
 * @CreateDate:   [2020年6月8日 上午10:20:52]
 */
public interface ICalculator {
	public String strategyMethod();//抽象策略方法
}
