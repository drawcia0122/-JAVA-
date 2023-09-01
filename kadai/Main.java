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

		//		モンスター生成、エンカウント
		int m = new java.util.Random().nextInt(3) + 1;
		Monster[] monsters = new Monster[m];
		i = 0;
		char sufix = 'A';
		for (i = 0; i < m; i++) {
			monsters[i] = new Matango(sufix, m);
			sufix++;
			System.out.println(monsters[i].name + "が現れた！");
			time();
		}

		//		バトル開始
		boolean[] check = new boolean[m];
		boolean r = false;
		while (champions[s].hp > 0 && r == false) {
			champions[s].comando(monsters);
			for (Monster monster : monsters) {
				monster.attack(champions[s]);
				champions[s].checkHp(champions[s].hp);
				if (champions[s].deathCheck == true) {
					break;
				}
				monster.checkHp(monster);

				for (i = 0; i < m; i++) {
					check[i] = monster.deathCheck;
				}
			}
//			勝利判定
			r = true;
			for (i = 0; i < m; i++) {
				if (!check[i] == true) {
					r = false;
					break;
				}
				if (champions[s].deathCheck == false && r == true) {
					System.out.println("敵を全滅させた");
					System.out.println("VICTORY");
					break;
				}
			}
			if (champions[s].deathCheck == true) {
				System.out.println(champions[s].name + "は力尽きた");
				System.out.println("DEFEAT");
			}
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
