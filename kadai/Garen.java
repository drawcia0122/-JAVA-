package kadai;

public class Garen extends Champion {
	public void attack(Monster[] m) {
		super.attack(m);
		int selected = new java.util.Scanner(System.in).nextInt() - 1;
		if (selected < m[0].num && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			super.time();
			System.out.println("「フン！」");
			super.time();
			m[selected].takeDamage(this.ad);
			System.out.println(m[selected].name + "に" + this.ad + "のダメージ!!");
			super.time();
			if (m[selected].hp <= 0) {
				System.out.println(m[selected].name + "は霧散した");
				super.time();
			}
		} else{
			System.out.println("「ムッ...狙いが定まらない！」");
			super.time();
			this.attack(m);
		}
	}

	public void skillR(Monster[] m) {
		super.attack(m);
		int selected = new java.util.Scanner(System.in).nextInt() - 1;
		if (selected < m[0].num && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			System.out.println("「DEMAAACIAAAA!!!!!!!」");
			int dmg = 50 + (m[selected].maxHp - m[selected].hp) / 4;
			m[selected].takeDamage(dmg);
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			super.time();
			if (m[selected].hp <= 0) {
				System.out.println(m[selected].name + "は霧散した");
				super.time();
			}
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

	public void comando(Monster[] m) {
		System.out.println("行うコマンドを数字で選択してください。");
		System.out.println("1:攻撃 2:逃げる 3:体力確認 4:ULT");
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
			this.comando(m);
			break;
		case 4:
			this.skillR(m);
			break;
		default:
			System.out.println("そんなコマンドはない！！");
		}
	}

	public Garen() {
		this.name = "ガレン";
		this.hp = 690;
		this.ad = 69;
		this.ap = 100;
	}
}
