package kadai;

public abstract class Champion {
	String name;
	int hp;
	int ad;
	int ap;
	public abstract void attack(Monster m);
	public void run() {
		System.out.println(this.name + "は逃げ出した!");
		System.out.println("しかし逃げられなかった!!");
	}
	public void check(Monster m) {
		System.out.println(this.name + "は、お互いのHPを確認した" );
		System.out.println(this.name + ":" + this.hp + "、" + m.name + ":" + m.hp);
	}
	
	public abstract int comando(Monster m);
}
