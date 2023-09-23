package kadai;

public class ElixirAr extends ConsumptionItem {
	public void useItem(Champion c) {
		if (this.NumberOfPieces > 0) {
			this.NumberOfPieces -= 1;
			System.out.println(c.name + "は" + this.name + "を使った！");
			c.ar += this.increasedAr;
			System.out.println(c.name + "のアーマーが" + this.increasedAr + "増加した！");
		}else {
			System.out.println("もうない");
		}
	}

	public ElixirAr() {
		this.name = "硬くなるエリクサー";
		this.increasedAr = 20;
		this.NumberOfPieces = 2;
	}
}
