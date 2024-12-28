package otomataodevv;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class muharremolgac {
	private String baslangicdurumu;
	private String[] kabuldurumu;
	private Map<String, Map<Character, String>> gecisler;
	
	public muharremolgac (String baslangicdurumu, String[] kabuldurumu, Map<String, Map<Character, String>> gecisler) {
		this.baslangicdurumu = baslangicdurumu;
		this.kabuldurumu = kabuldurumu;
		this.gecisler = gecisler;		
	}
	public boolean calistir (String input) {
		String mevcutdurum = baslangicdurumu;
		System.out.println("Başlangıç durumu: " + mevcutdurum);
		for (char harf : input.toCharArray()) {
			if(!gecisler.containsKey(mevcutdurum) || !gecisler.get(mevcutdurum).containsKey(harf)) {
				System.out.println("Geçiş bulunamadı. Durum=" +mevcutdurum);
				return false;
			}
			mevcutdurum = gecisler.get(mevcutdurum).get(harf);
			System.out.println("Harf :" + harf + " Yeni durum :" + mevcutdurum);	
		}
		for (String kabuldurumu : kabuldurumu) {
			if (mevcutdurum.equals(kabuldurumu)) {
				System.out.println("Kabul Durumu");
				return true;
			}
		}
		System.out.println("Dizge kabul edilmedi");
		return false;
	}
	public static void main(String[] args) {
		String baslangicdurumu = "q0";
		String[] kabuldurumu = {"q8"};
		Map<String, Map<Character, String>> gecisler = new HashMap<>();
		gecisler.put("q0", Map.of('a', "q2", 'b', "q1"));
		gecisler.put("q1", Map.of('a', "q4", 'b', "q3"));
		gecisler.put("q2", Map.of('a', "q5", 'b', "q4"));
		gecisler.put("q3", Map.of('a', "q6", 'b', "q3"));
		gecisler.put("q4", Map.of('a', "q7", 'b', "q6"));
		gecisler.put("q5", Map.of('a', "q5", 'b', "q7"));
		gecisler.put("q6", Map.of('a', "q8", 'b', "q6"));
		gecisler.put("q7", Map.of('a', "q7", 'b', "q8"));
		gecisler.put("q8", Map.of('a', "q8", 'b', "q8"));
		
		muharremolgac dfa = new muharremolgac(baslangicdurumu, kabuldurumu, gecisler);
		Scanner sc = new Scanner(System.in);
		System.out.println("Dizgeyi giriniz");
		String inputString = sc.nextLine();
		dfa.calistir(inputString);
	}
}
