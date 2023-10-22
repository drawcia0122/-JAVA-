package kadai;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int i = 1;
		Champion[] champions = new Champion[] { new Garen(), new Lux(), new Urgot(), new Rengar() };
		// 		キャラ選択
		var championPicks = new Champion[3];
		for (int pick = 0; pick < championPicks.length; pick++) {
			//			int championPickNumber = pick - 1;
			System.out.println("キャラクターを3体選んでください。");
			for (Champion champion : champions) {
				if (champion.pick == false) {
					int index = Arrays.asList(champions).indexOf(champion) + 1;
					System.out.print(index + ":" + champion.name + "  ");
				}
			}
			int championSelected = Main.scanner.nextInt() - 1;
			while (championSelected > champions.length || champions[championSelected].pick == true) {
				System.out.println("ちゃんと選べよい");
				System.out.println("キャラクターを選んでください。");
				for (Champion champion : champions) {
					if (champion.pick == false) {
						int index = Arrays.asList(champions).indexOf(champion) + 1;
						System.out.print(index + ":" + champion.name + "  ");
					}
				}
				championSelected = Main.scanner.nextInt() - 1;
			}
			System.out.println("あなたは" + champions[championSelected].name + "をピックした。");
			champions[championSelected].pick();
			championPicks[pick] = champions[championSelected];
			time();
		}
		//装備選択
		System.out.println("装備を選んでください");
		EquipmentItem[] equipmentItems = new EquipmentItem[] { new RubyCrystal(), new BfSword(), new ClothArmor() };
		for (EquipmentItem equipmentItem : equipmentItems) {
			int index = Arrays.asList(equipmentItems).indexOf(equipmentItem) + 1;
			System.out.print(index + ":" + equipmentItem.name + "  ");
		}
		int equipmentItemSelected = Main.scanner.nextInt() - 1;
		while (equipmentItemSelected > equipmentItems.length) {
			System.out.println("ちゃんと選べよい");
			System.out.println("装備を選んでください。");
			for (EquipmentItem equipmentItem : equipmentItems) {
				int index = Arrays.asList(equipmentItems).indexOf(equipmentItem) + 1;
				System.out.print(index + ":" + equipmentItem.name + "  ");
			}
			equipmentItemSelected = Main.scanner.nextInt() - 1;
		}
		System.out.println("装備させるキャラクターを選んで下さい");
		for (Champion championPick : championPicks) {
			int index = Arrays.asList(championPicks).indexOf(championPick) + 1;
			System.out.print(index + ":" + championPick.name + "  ");
		}
		int equipmentPick = Main.scanner.nextInt() - 1;
		while (equipmentPick > equipmentItems.length) {
			System.out.println("ちゃんと選べよい");
			System.out.println("装備させるキャラクターを選んでください。");
			for (Champion championPick : championPicks) {
				int index = Arrays.asList(championPicks).indexOf(championPick) + 1;
				System.out.print(index + ":" + championPick.name + "  ");
			}
			equipmentPick = Main.scanner.nextInt() - 1;
		}
		System.out.println(
				championPicks[equipmentPick].name + "は" + equipmentItems[equipmentItemSelected].name + "を装備した。");
		championPicks[equipmentPick].equipment(equipmentItems[equipmentItemSelected]);

		//消費アイテム選択
		System.out.println("消費アイテムを選んでください");
		ConsumptionItem[] consumptionItems = new ConsumptionItem[] { new HealthPortion(), new ElixirAr(),
				new ElixirAd() };
		for (ConsumptionItem consumptionItem : consumptionItems) {
			int index = Arrays.asList(consumptionItems).indexOf(consumptionItem) + 1;
			System.out.print(index + ":" + consumptionItem.name + "  ");
		}
		int consumptionItemSelected = Main.scanner.nextInt() - 1;
		while (consumptionItemSelected > consumptionItems.length) {
			System.out.println("ちゃんと選べよい");
			System.out.println("消費アイテムを選んでください。");
			for (ConsumptionItem consumptionItem : consumptionItems) {
				int index = Arrays.asList(consumptionItems).indexOf(consumptionItem) + 1;
				System.out.print(index + ":" + consumptionItem.name + "  ");
			}
			consumptionItemSelected = new java.util.Scanner(System.in).nextInt() - 1;
		}

		System.out.println("取得させるキャラクターを選んで下さい");
		i = 1;
		for (Champion championPick : championPicks) {
			System.out.print(i + ":" + championPick.name + "  ");
			i++;
		}
		int consumptionPick = Main.scanner.nextInt() - 1;
		while (consumptionPick > consumptionItems.length) {
			System.out.println("ちゃんと選べよい");
			System.out.println("取得させるキャラクターを選んでください。");
			i = 1;
			for (Champion championPick : championPicks) {
				System.out.print(i + ":" + championPick.name + "  ");
				i++;
			}
			consumptionPick = new java.util.Scanner(System.in).nextInt() - 1;
		}
		System.out.println(
				championPicks[consumptionPick].name + "は" + consumptionItems[consumptionItemSelected].name + "を"
						+ consumptionItems[consumptionItemSelected].NumberOfPieces + "個手に入れた");
		championPicks[consumptionPick].haveItem = true;

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
		boolean monstersDeathCheck = false;
		boolean championsDeathCheck = false;
		while (championsDeathCheck == false && monstersDeathCheck == false) {
			//味方の行動選択
			for (Champion championPick : championPicks) {
				if (championPick.deathCheck != true) {
					//モンスター全滅判定
					for (Monster monster : monsters) {
						monstersDeathCheck = true;
						if (monster.deathCheck != true) {
							monstersDeathCheck = false;
							break;
						}
					}
					//モンスターが全滅していない場合生きてるチャンピオンが動く
					if (championPick.deathCheck == false && monstersDeathCheck == false) {
						System.out.println(championPick.name + "のターン！");
						championPick.comando(championPicks, monsters, consumptionItems[consumptionItemSelected]);
					}
				}
			}
			//モンスターの行動
			for (Monster monster : monsters) {
				if (monster.deathCheck != true) {
					//味方全滅判定
					for (Champion champion : championPicks) {
						championsDeathCheck = true;
						if (champion.deathCheck != true) {
							championsDeathCheck = false;
							break;
						}
					}
					//対象選択、行動
					if (monster.deathCheck == false && championsDeathCheck == false) {
						int target = new java.util.Random().nextInt(3);
						while (championPicks[target].deathCheck != false) {
							target = new java.util.Random().nextInt(3);
						}
						monster.attack(championPicks[target]);
					}
				}
			}
		}

		//リザルト
		if (monstersDeathCheck == true) {
			System.out.println("敵を全滅させた");
			System.out.println("VICTORY");
		} else if (championsDeathCheck == true) {
			System.out.println("DEFEAT");
		}
	}

	public static void time() {
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
