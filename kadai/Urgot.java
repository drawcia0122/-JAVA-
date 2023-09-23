package kadai;

public class Urgot extends Champion {
	public void attack(Monster[] m) {
		super.attack(m);
		int selected = new java.util.Scanner(System.in).nextInt() - 1;
		if (selected < m.length && m[selected].hp > 0) {
			super.time();
			System.out.println(this.name + "のターン!!");
			super.time();
			System.out.println("「死は救済なり」");
			super.time();
//			ここはメソッドにかえたい
			int dmg = this.ad - m[selected].ar;
			if(dmg <= 0) {
				dmg =0;
			}
//			ここまで
			m[selected].takeDamage(this.ad);
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			super.time();
			if (m[selected].hp <= 0) {
				System.out.println(m[selected].name + "は霧散した");
				super.time();
			}
		} else {
			System.out.println("「...?」");
			super.time();
			this.attack(m);
		}
	}

	public void skillR(Monster[] m) {
		super.attack(m);
		int selected = new java.util.Scanner(System.in).nextInt() - 1;
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			System.out.println(this.name + "のデスグラインダー!!");
			super.time();
			if (m[selected].maxHp - (m[selected].maxHp - m[selected].hp) <= m[selected].maxHp / 3) {
				System.out.println("ギャリギャリギャリ");
				super.time();
				int dmg = m[selected].hp;
				m[selected].hp -= dmg;
				System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
				super.time();
				System.out.println(m[selected].name + "は霧散した");
				super.time();
			}
			if (m[selected].hp > 0) {
				System.out.println("効果がないようだ");
				super.time();
			}
		} else {
			System.out.println("「ムッ...狙いが定まらない！」");
			super.time();
			this.attack(m);
		}
	}

	public void comando(Monster[] m,Champion c,ConsumptionItem i) {
		System.out.println("行うコマンドを数字で選択してください。");
		System.out.println("1:攻撃 2:逃げる 3:体力確認 4:ULT 5:アイテム");
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
			this.comando(m,c,i);
			break;
		case 4:
			this.skillR(m);
			break;
		case 5:
			i.useItem(c);
			break;
		default:
			System.out.println("そんなコマンドはない！！");
		}
	}

	public Urgot() {
		this.name = "アーゴット";
		this.hp = 655;
		this.maxHp = 655;
		this.ad = 63;
		this.ap = 0;
		this.ar = 20;
		this.deathCheck = false;
	}
}
