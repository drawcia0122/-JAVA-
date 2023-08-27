package kadai;

public class Urgot extends Champion{
	public void attack(Monster m) {
		System.out.println(this.name + "の攻撃!!");
		System.out.println("「死は救済なり」");
		m.hp -= this.ad;
		System.out.println(m.name + "に" + this.ad + "のダメージ!!");
	}
	public int comando(Monster m) {
		System.out.println("行うコマンドを数字で選択してください。");
		System.out.println("1:攻撃 2:逃げる 3:体力確認");
		int selected = new java.util.Scanner(System.in).nextInt();
		switch (selected) {
		case 1:
			this.attack(m);
			break;
		case 2:
			this.run();
			break;
		case 3:
			this.check(m);
			break;
		default:
			System.out.println("そんなコマンドはない！！");		
		}
		return selected;
	}
	
	public Urgot() {
		this.name = "アーゴット";
		this.hp = 655;
		this.ad = 63;
		this.ap = 0;
	}
}
