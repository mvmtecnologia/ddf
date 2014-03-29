package br.com.dicadefarmacia.infra.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
public class PropertyUtils {

	/**
	 * @author rozolin
	 * @param object
	 * @param atributo
	 *            - String com o nome do atributo
	 * @return Object
	 */
	private static Object getMetodoPropriedade(Object object, Method method) {

		if (object != null || method != null) {

			try {
				return method.invoke(object, new Object[0]);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private static void setMetodoPropriedade(Object object, Method method,
			Object valor) {

		if (object != null || method != null) {

			try {
				method.invoke(object, valor);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Object getPropriedadeMetodo(Object object, Method method) {
		return getPropriedade(object, method.getName());
	}
	public static Object getPropriedadeMetodo(Object object, String method) {
		return getPropriedade(object, method);
	}
	public static Object getPropriedadeAtributo(Object object, String atributo) {
		return getPropriedade(object, getNomeMetodo(atributo));
	}
	
	
	
	/**
	 * Passa o objeto e o nome do metodo "get" para retornar que será retornado o valor
	 * @author rozolin
	 * @param object 
	 * @param nomeMetodo - nome do metodo "get" 
	 * @return retorna o valor do metodo 
	 */
	private static Object getPropriedade(Object object,
			String nomeMetodo) {

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
			if (method.getName().equals(nomeMetodo)
					&& method.getParameterTypes().length == 0) {
				return getMetodoPropriedade(object, method);
			}
		}

		return null;
	}
	/**
	 * Passa o nome do metodo "get" como parametro e é retornado o nome do atributo
	 * @param metodo - metodo "get"
	 * @return nome do atributo 
	 */
	public static String getNomeAtributo(String metodo) {
		return StringUtils.primeiraLetraToLowerCase(StringUtils.removePrefixo(
				metodo, "get"));
	}
	
	/**
	 * Passa o nome do atributo como parametro e é retornado o nome do metodo "get" 
	 * @author rozolin
	 * @param atributo - nome do atributo
	 * @return nome do metodo "get" 
	 */
	public static String getNomeMetodo(String atributo) {
		return "get" + StringUtils.primeiraLetraToUpperCase(atributo);
	}

	/**
	 * Passa o nome do metodo "set" como parametro e é retornado o nome do atributo 
	 * @author rozolin
	 * @param metodo - nome do metodo
	 * @return nome do atributo 
	 */
	public static String setNomeAtributo(String metodo) {
		return StringUtils.primeiraLetraToLowerCase(StringUtils.removePrefixo(
				metodo, "set"));
	}
	/**
	 * Retornar o nome do metodo set do atributo 
	 * @param atributo 
	 * @return string com o nome do metodo set do atributo passado como parametro
	 */

	public static String setNomeMetodo(String atributo) {
		return "set" + StringUtils.primeiraLetraToUpperCase(atributo);
	}
	/**
	 * Retorna uma classe a classe que representa o tipo do atributo 
	 * @author rozolin
	 * @param object - instacia da classe 
	 * @param atributo - atributo que para recuperar o tipo 
	 * @return classe que representa o tipo do atributo 
	 */

	public static Class<?> getReturnType(Object object, String atributo) {

		try {
			Method method = Class.forName(object.getClass().getName())
					.getMethod(getNomeMetodo(atributo), new Class[0]);
			return method.getReturnType();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retorna um nova instancia da classe passado como parametro 
	 * @author rozolin
	 * @param classe - Classe para poder criar uma nova instancia 
	 * @return retorna uma nova instancia
	 */
	public static <E> E getNewObject(Class<E> classe) {

		try {
			return classe.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Retorna o valor do atributo do objeto que está anotado como {@link javax.persistence.Id} 
	 * @author rozolin
	 * @param object - objeto que possui o atributo com a annotation {@link javax.persistence.Id}
	 * @return valor do atributo
	 */
	public static Object getIdValor(Object object){
		try {
		return getPropriedade(object, getIdNome(Class.forName(object.getClass().getName())));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Retorna o nome do atributo da classe que está anotado como {@link javax.persistence.Id}
	 * 
	 * @param classe - classe que possui o atributo com o annotation {@link javax.persistence.Id}
	 * @return nome do atributo
	 */
	public static String getIdNome(Class<?> classe){
		if(classe == Object.class){
			return null;
		}
		Field[] fields = classe.getDeclaredFields();
		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				if(annotation.toString().equals("@javax.persistence.Id()")){
					return field.getName();
				}
			}
		}		
		return getIdNome(classe.getSuperclass());
	}
	/**
	 * Chamar o metodo set de um atribudo passando o nome e parametro
	 * @param object - Objeto que possui o metodo 
	 * @param nomeMetodo - nome do metodo que será chamado
	 * @param valor - valor que será passado para o metodo como parametro
	 */
	public static void setPropriedadeMetodo(Object object,
			String nomeMetodo, Object valor) {
		setPropriedade(object, setNomeAtributo(nomeMetodo), valor);
	}
	/**
	 * Setar um valor em um atributo de um determinado objeto
	 * @author rozolin
	 * @param object - Objeto que possui o atributo 
	 * @param nomeAtributo - nome do atributo
	 * @param valor - valor que será passado para o atributo 
	 */
	public static void setPropriedade(Object object,
			String nomeAtributo, Object valor) {

		String nomeMetodo = setNomeMetodo(nomeAtributo);
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
			if (method.getName().equals(nomeMetodo)
					&& method.getParameterTypes().length == 1) {
				setMetodoPropriedade(object, method, valor);
			}
		}
	}

}
