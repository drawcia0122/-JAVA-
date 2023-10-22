package kadai;

public class Urgot extends Champion {

	public void attack(Monster[] m) {
		super.attack(m);
		int selected = Main.scanner.nextInt() - 1;
		if (m[selected].hp <= 0) {
			super.time();
			System.out.println("既に死んでいる");
		}
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			super.time();
			System.out.println("「死は救済なり」");
			super.time();
			int dmg = this.ad - m[selected].ar;
			if (dmg <= 0) {
				dmg = 0;
			}
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			m[selected].takeDamage(dmg);
			super.time();
		}
		if (selected > m.length) {
			System.out.println("「...?」");
			super.time();
			this.attack(m);
		}
	}

	public void skillR(Monster[] m) {
		super.attack(m);
		int selected = Main.scanner.nextInt() - 1;
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			System.out.println(this.name + "のデスグラインダー!!");
			super.time();
			if (m[selected].hp <= m[selected].maxHp / 3) {
				System.out.println("ギャリギャリギャリ");
				super.time();
				int dmg = m[selected].hp;
				System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
				super.time();
				m[selected].takeDamage(dmg);
				super.time();
			}
			else{
				System.out.println("効果がないようだ");
				super.time();
			}
		} else {
			System.out.println("「ムッ...狙いが定まらない！」");
			super.time();
			this.attack(m);
		}
	}

	public Urgot() {
		this.name = "アーゴット";
		this.hp = 655;
		this.maxHp = 655;
		this.ad = 63;
		this.ap = 0;
		this.ar = 20;
		this.pick = false;
		this.haveItem = false;
	}
}
