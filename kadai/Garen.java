package kadai;

public class Garen extends Champion {
	public void attack(Monster[] m) {
		super.selectTarget(m);
		int selected = Main.scanner.nextInt() - 1;
		if (m[selected].hp <= 0) {
			super.time();
			System.out.println("既に死んでいる");
		}
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			super.time();
			System.out.println("「フン！」");
			super.time();
			int dmg = this.ad - m[selected].ar;
			if (dmg <= 0) {
				dmg = 0;
			}
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			m[selected].takeDamage(dmg);
			super.time();
		
		} else {
				System.out.println("狙いが定まらない！");
				this.attack(m);
			}
		}

	public void skillR(Monster[] m) {
		super.selectTarget(m);
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
			this.skillR(m);
		} else {
			System.out.println("「ムッ...狙いが定まらない！！」");
			super.time();
			this.skillR(m);
		}
	}



	public Garen() {
		this.name = "ガレン";
		this.hp = 690;
		this.maxHp = 690;
		this.ad = 69;
		this.ap = 100;
		this.ar = 30;
		this.pick = false;
		this.haveItem = false;
	}
}
