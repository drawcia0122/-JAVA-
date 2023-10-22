package kadai;

public class Rengar extends Champion {
	public void attack(Monster[] m) {
		super.attack(m);
		int selected = Main.scanner.nextInt() - 1;
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			super.time();
			System.out.println("「にゃーん」");
			super.time();
			int dmg = this.ad - m[selected].ar;
			if (dmg <= 0) {
				dmg = 0;
			}
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			m[selected].takeDamage(dmg);
			super.time();
		} else if (m[selected].hp <= 0) {
			System.out.println("「既に倒している！」");
			super.time();
			this.attack(m);
		} else {
			System.out.println("「ムッ...狙いが定まらない！」");
			super.time();
			this.attack(m);
		}
	}

	public void skillR(Monster[] m) {
		super.attack(m);
		int selected = Main.scanner.nextInt() - 1;
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			System.out.println("「DEMAAACIAAAA!!!!!!!」");
			int dmg = 50 + (m[selected].maxHp - m[selected].hp) / 4;
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			m[selected].takeDamage(dmg);
			super.time();
		} else if (m[selected].hp <= 0) {
			System.out.println("「既に倒している！」");
			super.time();
			this.attack(m);
		} else {
			System.out.println("「ムッ...狙いが定まらない！！」");
			super.time();
			this.attack(m);
		}
	}

	public Rengar() {
		this.name = "レンガー";
		this.hp = 620;
		this.maxHp = 620;
		this.ad = 68;
		this.ap = 0;
		this.ar = 34;
		this.pick = false;
		this.haveItem = false;
	}
}
