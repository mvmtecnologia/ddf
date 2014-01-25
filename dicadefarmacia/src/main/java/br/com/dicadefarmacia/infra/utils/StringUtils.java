package br.com.dicadefarmacia.infra.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	public static String removePrefixo(String string, String remove){
		if(remove == null){
			return string;
		}
		if(string.length() < remove.length()){
			return string;
		}
		String stringAux = "";
		for(int i = 0; i < remove.length(); i++){
			if(remove.charAt(i) == string.charAt(i)){
				stringAux += remove.charAt(i);
			}
		}
		if(stringAux.equals(remove)){
			stringAux = "";
			for(int i = remove.length();i<string.length(); i++){
				stringAux += string.charAt(i);
			}
			return stringAux;
		}
		return string;
	}
	
	public static String removeSufixo(String string, String remove){
		if(remove == null){
			return string;
		}
		if(string.length() < remove.length()){
			return string;
		}
		String stringAux = "";
		int diferenca = string.length() - remove.length();
		for(int i = 0; i < remove.length(); i++){
			if(remove.charAt(i) == string.charAt(i + diferenca)){
				stringAux += remove.charAt(i);
			}
		}
		if(stringAux.equals(remove)){
			stringAux = "";
			for(int i = 0; i < diferenca; i++){
				stringAux += string.charAt(i);
			}
			return stringAux;
		}
		return string;
	}
	
	public static String primeiraLetraToUpperCase(String string){
		 StringBuilder sb = new StringBuilder(string);
	       sb.setCharAt(0, Character.toUpperCase((sb.charAt(0))));
	       return sb.toString();
	}
	
	public static String primeiraLetraToLowerCase(String string){
		 StringBuilder sb = new StringBuilder(string);
	       sb.setCharAt(0, Character.toLowerCase((sb.charAt(0))));
	       return sb.toString();
	}
	
	public static boolean isNuloOuBranco(String string){
		if(string == null || string.trim().equals("")){
			return true;
		}
		return false;
	}

}
