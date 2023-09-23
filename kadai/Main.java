package kadai;

public class Main {

	public static void main(String[] args) {
		Champion[] champions = new Champion[3];
		champions[0] = new Garen();
		champions[1] = new Lux();
		champions[2] = new Urgot();

		// 		キャラ選択
		System.out.println("キャラクターを選んでください。");
		int i = 1;
		for (Champion champion : champions) {
			System.out.print(i + ":" + champion.name + "  ");
			i++;
		}
		int championSelected = new java.util.Scanner(System.in).nextInt();
		int s = championSelected - 1;
		while (championSelected > 3) {
			System.out.println("ちゃんと選べよい");
			System.out.println("キャラクターを選んでください。");
			i = 1;
			for (Champion champion : champions) {
				System.out.print(i + ":" + champion.name + "  ");
				i++;
			}
			championSelected = new java.util.Scanner(System.in).nextInt();
			s = championSelected - 1;
		}
		System.out.println("あなたは" + champions[s].name + "をピックした。");
		time();

		//装備選択
		System.out.println("装備を選んでください");
		EquipmentItem[] equipmentItems = new EquipmentItem[3];
		equipmentItems[0] = new RubyCrystal();
		equipmentItems[1] = new BfSword();
		equipmentItems[2] = new ClothArmmor();
		i = 1;
		for (EquipmentItem equipmentItem : equipmentItems) {
			System.out.print(i + ":" + equipmentItem.name + "  ");
			i++;
		}
		int equipmentItemSelected = new java.util.Scanner(System.in).nextInt();
		int is = equipmentItemSelected - 1;
		while (equipmentItemSelected > 3) {
			System.out.println("ちゃんと選べよい");
			System.out.println("装備を選んでください。");
			i = 1;
			for (EquipmentItem item : equipmentItems) {
				System.out.print(i + ":" + item.name + "  ");
				i++;
			}
			equipmentItemSelected = new java.util.Scanner(System.in).nextInt();
			is = equipmentItemSelected - 1;
		}
		System.out.println("あなたは" + equipmentItems[is].name + "を装備した。");
		champions[s].equipment(equipmentItems[is]);

		//消費アイテム選択
		System.out.println("消費アイテムを選んでください");
		ConsumptionItem[] consumptionItems = new ConsumptionItem[3];
		consumptionItems[0] = new HealthPortion();
		consumptionItems[1] = new ElixirAr();
		consumptionItems[2] = new ElixirAd();
		i = 1;
		for (ConsumptionItem consumptionItem : consumptionItems) {
			System.out.print(i + ":" + consumptionItem.name + "  ");
			i++;
		}
		int consumptionItemSelected = new java.util.Scanner(System.in).nextInt();
		is = consumptionItemSelected - 1;
		while (consumptionItemSelected > 3) {
			System.out.println("ちゃんと選べよい");
			System.out.println("消費アイテムを選んでください。");
			i = 1;
			for (ConsumptionItem consumptionItem : consumptionItems) {
				System.out.print(i + ":" + consumptionItem.name + "  ");
				i++;
			}
			consumptionItemSelected = new java.util.Scanner(System.in).nextInt();
			is = consumptionItemSelected - 1;
		}
		System.out.println("あなたは" + consumptionItems[is].name + "を" + consumptionItems[is].NumberOfPieces + "個手に入れた");

		//		モンスター生成、エンカウント
		int monsterCount = new java.util.Random().nextInt(3) + 1;
		Monster[] monsters = new Monster[monsterCount];
		i = 0;
		char sufix = 'A';
		for (i = 0; i < monsterCount; i++) {
			monsters[i] = new Matango(sufix);
			sufix++;
			System.out.println(monsters[i].name + "が現れた！");
			time();
		}

		//		バトル開始
		boolean[] check = new boolean[monsterCount];
		boolean r = false;
		while (champions[s].hp > 0 && r == false) {
			champions[s].comando(monsters, champions[s], consumptionItems[is]);
			for (Monster monster : monsters) {
				monster.attack(champions[s]);
				champions[s].checkHp(champions[s].hp);
				if (champions[s].deathCheck == true) {
					break;
				}
				monster.checkHp(monster);

				for (i = 0; i < monsterCount; i++) {
					check[i] = monster.deathCheck;
				}
			}
			//			勝利判定
			r = true;
			for (Monster monster : monsters) {
				if (monster.deathCheck == false) {
					r = false;
					break;
				}
			}
			if (champions[s].deathCheck == false && r == true) {
				System.out.println("敵を全滅させた");
				System.out.println("VICTORY");
				break;
			}
			if (champions[s].deathCheck == true) {
				System.out.println(champions[s].name + "は力尽きた");
				System.out.println("DEFEAT");
			}
		}
	}

	public static void victoryDecision() {

	}

	public static void time() {
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
