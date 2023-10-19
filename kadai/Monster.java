package kadai;

public abstract class Monster {
	String name;
	int hp;
	int maxHp;
	int ad;
	int ar;
	char sufix;
	boolean deathCheck = false;
	int num;

	public abstract void attack(Champion c);

	public int takeDamage(int damage) {
		if (damage >= 0) {
			this.hp -= damage;
			if (this.hp <= 0) {
				System.out.println(this.name + "は霧散した");
				this.checkHp(this);
			}
		} else if (damage < 0) {
			this.hp -= 0;
		}
		return damage;
	}

	public boolean checkHp(Monster m) {
		if (this.hp > 0) {
			this.deathCheck = false;
		} else if (this.hp <= 0) {
			this.deathCheck = true;
		}
		return this.deathCheck;
	}

	public static void time() {
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
//	public static void encount() {
////		int encount = new java.util.Random().nextInt(1) ;
//		Monster monsters[]  = new Monster[2];
//		monsters[0] = new Matango();
//		monsters[1] = new Matango();
//	}
