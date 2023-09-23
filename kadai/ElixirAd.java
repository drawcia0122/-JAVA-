package kadai;

public class ElixirAd extends ConsumptionItem{
	public void useItem(Champion c){
		if(this.NumberOfPieces > 0) {
			this.NumberOfPieces -= 1;
			System.out.println(c.name + "は" + this.name + "を使った！");
			c.ad += this.increasedAd;
			System.out.println(c.name + "の攻撃力が" + this.increasedAd + "増加した！");
		}else {
			System.out.println("もうない");
		}
	}
	public ElixirAd() {
		this.name = "ラースエリクサー";
		this.increasedAd = 30;
		this.NumberOfPieces = 2;
	}
}
