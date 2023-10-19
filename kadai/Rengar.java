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
			if(dmg <= 0) {
				dmg =0;
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

	public void comando(Champion[] c,Monster[] m,ConsumptionItem i) {
		System.out.println("行うコマンドを数字で選択してください。");
		System.out.println("1:攻撃 2:逃げる 3:体力確認 4:ULT 5:アイテム");
		int selected = Main.scanner.nextInt();
		switch (selected) {
		case 1:
			this.attack(m);
			break;
		case 2:
			this.run();
			break;
		case 3:
			this.check(c,m);
			this.comando(c,m,i);
			break;
		case 4:
			this.skillR(m);
			break;
		case 5:
			this.useItem(c,m,i);
			break;
		default:
			System.out.println("そんなコマンドはない！！");
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
