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
		int dmg = this.ad - c.ar;
		if(dmg <= 0) {
			dmg =0;
		}
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

	public Matango(char sufix) {
		this.name = "マタンゴちゃん" + sufix;
		this.hp = 100;
		this.maxHp = 100;
		this.ad = 50;
		this.ar = 5;
		this.sufix = sufix;
	}
}
