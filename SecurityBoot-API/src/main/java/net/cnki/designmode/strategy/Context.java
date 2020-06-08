package net.cnki.designmode.strategy;

/**
 * 持有一个策略类的引用，最终给客户端调用
 * @author ZhiPengyu
 * @ClassName:    [Context.java]
 * @Description:  [环境类]
 * @CreateDate:   [2020年6月8日 上午10:29:52]
 */
public class Context {

	private ICalculator iCalculator;

	public ICalculator getiCalculator() {
		return iCalculator;
	}

	public void setiCalculator(ICalculator iCalculator) {
		this.iCalculator = iCalculator;
	}
	
	public String strategyMethod() {
		return iCalculator.strategyMethod();
    }
}
