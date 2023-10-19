package kadai;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Champion {
	String name;
	int hp;
	int maxHp;
	int ad;
	int ap;
	int ar;
	boolean pick;
	boolean haveItem = false;
	boolean deathCheck = false;

	public static Scanner scanner = new Scanner(System.in);

	public void attack(Monster[] m) {
		System.out.println("攻撃対象を選択しろ！");
		int i = 1;
		for (Monster monster : m) {
			if (monster.hp > 0) {
				System.out.print(i + ":" + monster.name + "  ");
			}
			i++;
		}

	}

	public abstract void skillR(Monster[] m);

	public void run() {
		System.out.println(this.name + "は逃げ出した!");
		time();
		System.out.println("しかし逃げられなかった!!");
		time();
	}

	public void check(Champion[] c, Monster[] m) {
		System.out.println(this.name + "は、お互いのHPを確認した");
		time();
		for (Champion champion : c) {
			if (champion.hp <= 0) {
				System.out.println(champion.name + "は死んでいる");
			} else {
				System.out.println(champion.name + ":" + champion.hp);
			}
		}
		for (Monster monster : m) {
			if (monster.hp <= 0) {
				System.out.println(monster.name + "は死んでいる");
			} else {
				System.out.println(monster.name + ":" + monster.hp);
			}
		}
		time();
	}

	public int takeDamage(int damage) {
		if (damage >= 0) {
			this.hp -= damage;
			if (this.hp <= 0) {
				System.out.println(this.name + "は力尽きた");
				this.deathCheck = true;
			}
		} else if (damage < 0) {
			this.hp -= 0;
		}
		return damage;
	}

	public int damageCalculation(int ar) {
		int dmg = this.ad - ar;
		if (dmg <= 0) {
			dmg = 0;
		}
		return dmg;
	}

	public abstract void comando(Champion[] c, Monster[] m, ConsumptionItem i);

	public boolean checkHp(int hp) {
		if (this.hp >= 0) {
			deathCheck = false;
		} else if (this.hp <= 0) {
			deathCheck = true;
		}
		return deathCheck;
	}

	public void equipment(EquipmentItem i) {
		this.hp += i.increasedHealth;
		this.maxHp += i.increasedHealth;
		this.ad += i.increasedAd;
		this.ar += i.increasedAr;
		i.check = true;
	}

	public void useItem(Champion c[], Monster[] m, ConsumptionItem i) {
		if (this.haveItem != true) {
			System.out.println("アイテムを持っていない！！");
		} else {
			System.out.println("使用するキャラクターを選んで下さい");
			for (Champion champion : c) {
				int index = Arrays.asList(c).indexOf(champion) + 1;
				System.out.print(index + ":" + champion.name + "  ");
			}

			int selected = Main.scanner.nextInt() - 1;
			if (selected > c.length) {
				System.out.println("ちゃんと選べよい");
				System.out.println("使用するキャラクターを選んで下さい");
				for (Champion champion : c) {
					int index = Arrays.asList(c).indexOf(champion) + 1;
					System.out.print(index + ":" + champion.name + "  ");
				}
				selected = Main.scanner.nextInt() - 1;
			}

			i.useItem(c[selected]);
		}
	}

	public void pick() {
		this.pick = true;
	}

	public static void time() {
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
