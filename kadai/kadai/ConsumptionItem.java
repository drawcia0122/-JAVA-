package kadai;

public abstract class ConsumptionItem {
	String name;
	int healHp;
	int increasedAr;
	int increasedAd;
	int NumberOfPieces;
	
	public abstract void useItem(Champion c);
}
