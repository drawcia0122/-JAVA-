package kadai;

public class Lux extends Champion {
	public void attack(Monster m) {
		System.out.println(this.name + "のビームが炸裂!!");
		System.out.println("「DEMAAAAAAAACIAAAAAA!!!!」");
		m.hp -= this.ap;
		System.out.println(m.name + "に" + this.ap + "のダメージ!!");
	}
	public void beam(Monster m) {
		System.out.println(this.name + "のビームが炸裂!!");
		System.out.println("DEMAAAAAAAACIAAAAAA!!!!");
		m.hp -= this.ap * 2;
		System.out.println(m.name + "に" + this.ap * 2 + "のダメージ!!");
	}
	
	public int comando(Monster m) {
		System.out.println("行うコマンドを数字で選択してください。");
		System.out.println("1:攻撃 2:逃げる 3:体力確認 4:ビーム");
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
		case 4:
			this.beam(m);
			break;
		default:
			System.out.println("そんなコマンドはない！！");		
		}
		return selected;
	}

	public Lux() {
		this.name = "ラックス";
		this.hp = 560;
		this.ad = 54;
		this.ap = 100;
	}
}