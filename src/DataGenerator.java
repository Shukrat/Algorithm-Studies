
public class DataGenerator {
	
	private int[] randomData;
	
	DataGenerator(int num){
		randomData = new int[num];
		for(int i = 0; i < randomData.length; i++){
			int rand = (int)(Math.random() * num) + 1;
			randomData[i] = rand;
		}
		
	}
	
	public int[] getArray(){
		return randomData;
	}
	
}
