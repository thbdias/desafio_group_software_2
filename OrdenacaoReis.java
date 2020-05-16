import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdenacaoReis {
	
	/**
	 * funcao que recebe uma lista de reis aleatorios,
	 * ordena essa lista, e cria um map de lista de reis que possuem prefixos iguais
	 * 
	 * @param reis
	 * @return
	 */
	private static Map<Integer, List<String>> getListasDePrefixos(List<String> reis) {
		Map<Integer, List<String>> mapReis = new HashMap<>();
		int posicaoMap = 0;
		Collections.sort(reis); //ordenar o nome dos reis		
		
		List<String> aux = new ArrayList<>();
		aux.add(reis.get(0));
		String prefixoAtual = aux.get(0).split(" ")[0];		
		
		for (int i = 1; i < reis.size(); i++) {
			if (prefixoAtual.equals(reis.get(i).split(" ")[0])) {
				aux.add(reis.get(i));
			}
			else {
				mapReis.put(posicaoMap, aux);
				aux = new ArrayList<>();
				aux.add(reis.get(i));
				prefixoAtual = aux.get(0).split(" ")[0];
				posicaoMap++;
			}
		}
		mapReis.put(posicaoMap, aux);		
		return mapReis;
	}
	
	private static String getSufixo(String nome) {
		return nome.split(" ")[1];
	}
	
	private static String getPrefixo(String nome) {
		return nome.split(" ")[0];
	}
	
	private static List<String> getNumeroRomanos1a50(){
		List<String> listNumeroRomano = new ArrayList<>();		
		listNumeroRomano.add("");		
		listNumeroRomano.add("I");
		listNumeroRomano.add("II");
		listNumeroRomano.add("III");
		listNumeroRomano.add("IV");
		listNumeroRomano.add("V");
		listNumeroRomano.add("VI");
		listNumeroRomano.add("VII");
		listNumeroRomano.add("VIII");
		listNumeroRomano.add("IX");
		listNumeroRomano.add("X");
		listNumeroRomano.add("XI");
		listNumeroRomano.add("XII");
		listNumeroRomano.add("XIII");
		listNumeroRomano.add("XIV");
		listNumeroRomano.add("XV");
		listNumeroRomano.add("XVI");
		listNumeroRomano.add("XVII");
		listNumeroRomano.add("XVIII");
		listNumeroRomano.add("XIX");
		listNumeroRomano.add("XX");
		listNumeroRomano.add("XXI");
		listNumeroRomano.add("XXII");
		listNumeroRomano.add("XXIII");
		listNumeroRomano.add("XXIV");
		listNumeroRomano.add("XXV");
		listNumeroRomano.add("XXVI");
		listNumeroRomano.add("XXVII");
		listNumeroRomano.add("XXVIII");
		listNumeroRomano.add("XXIX");
		listNumeroRomano.add("XXX");
		listNumeroRomano.add("XXXI");
		listNumeroRomano.add("XXXII");
		listNumeroRomano.add("XXXIII");
		listNumeroRomano.add("XXXIV");
		listNumeroRomano.add("XXXV");
		listNumeroRomano.add("XXXVI");
		listNumeroRomano.add("XXXVII");
		listNumeroRomano.add("XXXVIII");
		listNumeroRomano.add("XXXIX");
		listNumeroRomano.add("XL");
		listNumeroRomano.add("XLI");
		listNumeroRomano.add("XLII");
		listNumeroRomano.add("XLIII");
		listNumeroRomano.add("XLIV");
		listNumeroRomano.add("XLV");
		listNumeroRomano.add("XLVI");
		listNumeroRomano.add("XLVII");
		listNumeroRomano.add("XLVIII");
		listNumeroRomano.add("XLIX");
		listNumeroRomano.add("L");		
		return listNumeroRomano;
	}
	
	private static List<String> ordernarListaPeloSufixo(List<String> reis) {		

		List<Integer> listSufixoInteiro = new ArrayList<>();
		List<String> listNumeroRomano = getNumeroRomanos1a50();		
		for (String nomeRei : reis) {			
			listSufixoInteiro.add(listNumeroRomano.indexOf(getSufixo(nomeRei)));
		}
		
		List<String> reisComSufixoInteiro = new ArrayList<>();		
		for (int i = 0; i < reis.size(); i++) {
			reisComSufixoInteiro.add(getPrefixo(reis.get(i)) + " " + listSufixoInteiro.get(i));
		}
		
		Collections.sort(reisComSufixoInteiro); //ordenar o nome dos reis
		
		List<String> reisComSufixoRomanoOrdenado = new ArrayList<>();
		for (int i = 0; i < reisComSufixoInteiro.size(); i++) {		
			reisComSufixoRomanoOrdenado.add(getPrefixo(reisComSufixoInteiro.get(i)) + " " + listNumeroRomano.get(Integer.parseInt(getSufixo(reisComSufixoInteiro.get(i)))));
		}		
		
		return reisComSufixoRomanoOrdenado;
	}
	
	public static String[] obterListaOrdenada(String[] reis) {
		
		Map<Integer, List<String>> mapReis = getListasDePrefixos(Arrays.asList(reis));	
		List<String> listaReisFinal = new ArrayList<String>();
		
		for(int i = 0; i < mapReis.size(); i++) {
			List<String> listaOrdenadaPeloSufixo = ordernarListaPeloSufixo(mapReis.get(i));
			listaReisFinal.addAll(listaOrdenadaPeloSufixo);
		}	
		
		return listaReisFinal.stream().toArray(String[]::new);
	}

	public static void main(String[] args) {		
		
//		String[] reis = {"Louis IX", "Louis VIII"};
//		String[] reis = {"Louis IX", "Philippe II"};
//		String[] reis = {"Richard III", "Richard I", "Richard II"};
//		String[] reis = {"John X", "John I", "John L", "John V"};
		String[] reis = {"Philippe VI", "Jean II", "Charles V", "Charles VI", "Charles VII", "Louis XI"};
//		String[] reis = {"Philippe II", "Philip II"};
//		String[] reis = {"ZZZLouis L", "Philippe II", "ZZZLouis X"};		
		String[] reisOrdenado = obterListaOrdenada(reis);
		
		for (String item : reisOrdenado) {
			System.out.println(item);
		}
		
	}

}
