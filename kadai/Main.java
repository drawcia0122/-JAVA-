package kadai;

public class Main {

	public static void main(String[] args) {
		Champion[] c = new Champion[3];
		c[0] = new Garen();
		c[1] = new Lux();
		c[2] = new Urgot();
		Monster matango = new Matango();
		
		Lux lux = (Lux)c[1];

		//キャラ選択
		System.out.println("キャラクターを選んでください。 1:" + c[0].name + " 2:" + c[1].name + " 3:" + c[2].name);
		int championSelected = new java.util.Scanner(System.in).nextInt();
		int s = championSelected - 1;
		while (championSelected > 3) {
			System.out.println("ちゃんと選べよい");
			System.out.println("キャラクターを選んでください。 1:" + c[0].name + " 2:" + c[1].name + " 3:" + c[2].name);
			championSelected = new java.util.Scanner(System.in).nextInt();
			s = championSelected - 1;
		}
		System.out.println("あなたは" + c[s].name + "をピックした。");

		System.out.println(c[s].name + "は" + matango.name + "に遭遇した！");

		while (c[s].hp > 0 && matango.hp > 0) {
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//バトル開始
			
			int selected = c[s].comando(matango);
			
			
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (c[s].hp > 0 && matango.hp > 0 && selected != 3) {
				System.out.println(matango.name + "のターン!!");
				int matangoSelected = new java.util.Random().nextInt(1) + 1;
				switch (matangoSelected) {
				case 1:
					matango.attack(c[s]);
				}
			}
			if (c[s].hp > 0 && matango.hp <= 0) {
				System.out.println(matango.name + "は体が崩れ霧散した");
				System.out.println("VICTRY");
			} else if (c[s].hp < 0 && matango.hp > 0) {
				System.out.println(c[s].name + "は力尽きた");
				System.out.println("DEFEAT");
			}
		}
	}

}
