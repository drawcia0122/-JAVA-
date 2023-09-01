package kadai;

public abstract class Champion {
	String name;
	int hp;
	int ad;
	int ap;
	boolean deathCheck;
	public  void attack(Monster[] m) {
		System.out.println("攻撃対象を選択しろ！");
		int i =1;
		for (Monster monster : m) {
			if(monster.hp > 0) {
			System.out.print(i+":"+ monster.name + "  ");
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
	public void check(Monster[] m) {
		System.out.println(this.name + "は、お互いのHPを確認した" );
		time();
		System.out.println(this.name + ":" + this.hp);
		for (Monster monster : m ) {
			if(monster.hp <= 0) {
				System.out.println(monster.name + "は死んでいる");
			}else {
		System.out.println(monster.name + ":" + monster.hp);
			}
		}time();
	}
	
	public void takeDamage(int d) {
		this.hp -= d;
	}
	
	public abstract void comando(Monster[] m);
	
	public boolean checkHp(int hp) {
		if(this.hp >= 0) {
			deathCheck = false;
		}else if(this.hp <= 0){
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
