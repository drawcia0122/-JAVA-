package kadai;

public class Matango extends Monster {

	//	public void choice() {
	//		System.out.println(this.name + "のターン!!");
	//		int matangoSelected = new java.util.Random().nextInt(1) + 1;
	//		switch (matangoSelected) {
	//		case 1:
	//			this.attack(Champion);
	//		}

	public void attack(Champion c) {
		if (this.hp <= 0) {
			return;
		}

		System.out.println(this.name + "のターン!!");
		super.time();
		int matangoSelected = new java.util.Random().nextInt(1);
		switch (matangoSelected) {
		case 1:
			this.attack(c);
			break;
		}
		System.out.println(this.name + "「キョキョーーーッ!!」");
		super.time();
		int dmg = this.ad;
		System.out.println(c.name + "に" + dmg + "のダメージ!!");
		super.time();
		c.takeDamage(dmg);
	}

	public Matango() {
		this.name = "マタンゴちゃん";
		this.hp = 100;
		this.maxHp = 100;
		this.ad = 300;
	}

	public Matango(char sufix, int num) {
		this.name = "マタンゴちゃん" + sufix;
		this.hp = 100;
		this.maxHp = 100;
		this.ad = 200;
		this.sufix = sufix;
		this.num = num;
	}
}
