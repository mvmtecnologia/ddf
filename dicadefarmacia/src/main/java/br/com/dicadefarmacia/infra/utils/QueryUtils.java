package br.com.dicadefarmacia.infra.utils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class QueryUtils {
	
	public static final String IGUAL = " = ";
	public static final String INICIO_LIKE = "inicioLike";
	public static final String FIM_LIKE = "fimLike";
	public static final String LIKE = "like";
	public static final String MAIOR_QUE = ">";
	public static final String MENOR_QUE = "<";
	
	public static String montarQuery(Object object,Set<String> selectCampos,Map<String,String> comparadores, Set<String> orderBy, Map<String, Object> atributos){
		String nomeClasse = StringUtils.primeiraLetraToLowerCase(object.getClass().getSimpleName());
		
		achaAtributos(object, nomeClasse, atributos);
		Set<String> todosCampos = new TreeSet<String>(atributos.keySet());
		
		StringBuilder query = new StringBuilder(" select");
			
		for (String campo : selectCampos) {
			query.append(" "+montarAlias(nomeClasse+"_"+campo)+" as "+campo+",");
			todosCampos.add(nomeClasse+"_"+campo);
		}
		if(selectCampos == null || selectCampos.isEmpty()){
			query.append(" "+nomeClasse);
		}else{	
			query.deleteCharAt(query.length()-1);
		}
		query.append(" from " +StringUtils.primeiraLetraToUpperCase(nomeClasse)+" "+nomeClasse+" ");
		for (String string : orderBy) {
			todosCampos.add(nomeClasse+"_"+string);
		}
		
		query.append(montarInnerJoin(todosCampos));
		
		query.append(" where ");
		
		query.append(montarWhere(atributos, comparadores, nomeClasse));
		
		if(orderBy != null && !orderBy.isEmpty()){
			query.append(" order by ");
			for (String string : orderBy) {
				query.append(montarAlias(nomeClasse+"_"+string)+", ");
			}
			query.deleteCharAt(query.length()-2);
		}
		
		
		return query.toString();
		
	}
	
	private static String montarWhere(Map<String, Object> valores, Map<String, String> comparadores,String nomeClasse){
		nomeClasse = StringUtils.primeiraLetraToLowerCase(nomeClasse);
		StringBuilder sb = new StringBuilder("");
		for (String parametro : valores.keySet()) {
			Object obj = valores.get(parametro);
			String comp = comparadores == null ? null: comparadores.get(StringUtils.removePrefixo(parametro, nomeClasse+"_"));
			String alias = montarAlias(parametro);
			
			if(comp != null){
				if(comp.equals(IGUAL) && obj instanceof Date){
					sb.append("(day("+alias+") = day(:" + parametro+ ") and  month("+alias+") = month(:"+parametro+") and year("+alias+") = year(:" + parametro+")) and ");
				
				}else if(comp.equals(IGUAL)){
						sb.append(alias + " = :" + parametro+" and ");
					
					
				}else if(comp.equals(FIM_LIKE) 
						|| comp.equals(INICIO_LIKE)
						|| comp.equals(LIKE)){
					sb.append(alias + " like :" + parametro +" and ");
				
				}else if(comp.equals(MAIOR_QUE)){
					sb.append(alias + " > :" + parametro+" and ");
				
				}else if(comp.equals(MENOR_QUE)){
					sb.append(alias + " < :" + parametro+" and ");
				}		
			}else{
				if(obj instanceof Date){
					sb.append("(day("+alias+") = day(:" + parametro+ ") and  month("+alias+") = month(:"+parametro+") and year("+alias+") = year(:" + parametro+")) and ");
				
				}else if(obj instanceof String){
					sb.append(alias + " like :" + parametro +" and ");
				
				}else{
					sb.append(alias + " = :" + parametro+" and ");
				}		
				
			}
		}		
		
		return StringUtils.removeSufixo(sb.toString(), "and ");
	}
	
	private static String montarAlias(String alias){
		StringBuilder sb = new StringBuilder(alias);
		for (int i = alias.length()-1; i >= 0 ; i--) {
			if(sb.charAt(i) == '_'){
				sb.setCharAt(i, '.');
				return sb.toString();
			}
		}
		return null;
	}
	
	private static String montarInnerJoin(Set<String> atributos){
		Set<String> sets = new TreeSet<String>();
		for (String atributo : atributos) {
			String[] arrayAtributos = atributo.split("_");
			List<String> atbs = new ArrayList<String>();
			for (String string : arrayAtributos) {
				atbs.add(string);
			}
			
			
			NumberFormat f = NumberFormat.getInstance();
			f.setMinimumIntegerDigits(3);
			int prioridade = 0;
			String alias = atbs.get(0);
			while(atbs.size() > 2){
				sets.add(f.format(prioridade)+" " + "inner join "+ alias + "." + atbs.get(1)+" " + (alias +=  "_" + atbs.get(1)));
				
				atbs.remove(atbs.get(0));
				prioridade++;
			}
		}
		StringBuilder innerJoin = new StringBuilder("");
		for (String string : sets) {
			innerJoin.append(new StringBuffer(string).delete(0, 3));
		}
		
		return innerJoin.toString();
	}

	private static void achaAtributos(Object object, String nomeClasse, Map<String, Object> atributos){
		
		Method[] methods = null;
		try {
			methods = Class.forName(object.getClass().getName()).getMethods();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for (Method method : methods) {
			if(!method.getName().contains("get")){
				continue;
			}
			Object obj =  PropertyUtils.getPropriedadeMetodo(object, method.getName());
			if(obj != null && !method.getName().equals("getClass") ){
				if(obj instanceof Integer){
					atributos.put(nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof String){
					atributos.put(nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof Double){
					atributos.put(nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof Long){
					atributos.put(nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof Character){
					atributos.put(nomeClasse+ "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof Date){
					atributos.put(nomeClasse+ "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof BigDecimal){
					atributos.put(nomeClasse + "_"+ PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof BigInteger){
					atributos.put(nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else if(obj instanceof Float){
					atributos.put(nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()),obj);
				
				}else{
					achaAtributos(obj, nomeClasse + "_" + PropertyUtils.getNomeAtributo(method.getName()), atributos);
				}
			}
		}
	}
	

}
