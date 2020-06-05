package net.cnki.designmode.prototype;

/**
 * 1、抽象类（接口）：不可以被实例化（不能new对象），只能被继承。里面的方法可以是抽象方法（无方法体）也可以不是，随意。如果存在抽象方法则此类肯定是抽象类，同时子类必须重写抽象方法。
 * 2、原型模式：必须实现Cloneable接口。当一个类被多次创建，但内容基本相同时使用复制，返回的对象为新的对象。只需要对不同的地方再次修改就可以了。构造函数式不会执行
 * @author ZhiPengyu
 * @ClassName:    [Phone.java]
 * @Description:  [原型模式简单实现，能够在某些场景下提高创建对象的效率。]
 * @CreateDate:   [2020年6月5日 上午10:55:12]
 */
public class Phone implements Cloneable {
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Phone(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Phone phone = null;
		try {
			phone = (Phone) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return phone;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + "]";
	}
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Phone phone = new Phone(1,"手机");
		Phone miPhone = (Phone) phone.clone();
		miPhone.setId(2);
		Phone miPhone1 = (Phone) phone.clone();
		miPhone1.setId(3);
		
		System.out.println(phone.toString());
		System.out.println(miPhone.toString());
		System.out.println(miPhone1.toString());
	}
}
