package kadai;

public class Matango extends Monster{
	public void attack(Champion c) {
		System.out.println(this.name + "の攻撃!!");
		System.out.println("「キョキョーーーッ!!」");
		System.out.println(c.name + "に" + this.ad + "のダメージ!!");
		c.hp -= this.ad;
	}
	
	public Matango() {
		this.name = "マタンゴちゃん";
		this.hp = 100;
		this.ad = 300;
	}
}
