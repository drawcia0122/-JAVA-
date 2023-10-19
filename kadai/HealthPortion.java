package kadai;

public class HealthPortion extends ConsumptionItem{


	public void useItem(Champion c) {
		int differense = c.maxHp - c.hp;
		if(c.hp <= 0) {
			System.out.println("もう死んでる");
		}
		else {
		if(this.NumberOfPieces > 0) {
			this.NumberOfPieces -= 1;
			System.out.println(c.name + "は" + this.name + "を使った！");
			if(differense >= 0 && (c.hp + this.healHp)>= c.maxHp ) {
				System.out.println(c.name + "のHPが" + differense + "回復!");
				c.hp += differense;
				}else if(differense >= this.healHp) {
					System.out.println(c.name + "のHPが" + this.healHp + "回復!");
					c.hp += this.healHp;
				}
			}else {
				System.out.println("もうない");
			}
		}
	}
	
	
	public HealthPortion() {
		this.name = "ヘルスポーション";
		this.healHp = 150;
		this.NumberOfPieces = 2;
	}
	
	}

