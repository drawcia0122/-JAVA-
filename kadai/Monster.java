package kadai;

public abstract class Monster {
	String name;
	int hp;
	int maxHp;
	int ad;
	char sufix;
	boolean deathCheck;
	int num;

	public abstract void attack(Champion c);

	public void takeDamage(int d) {
		this.hp -= d;
	}

	public boolean checkHp(Monster m) {
		if (this.hp > 0) {
			deathCheck = false;
		} else if (this.hp <= 0) {
			deathCheck = true;
		}
		return deathCheck;
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
