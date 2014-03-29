package br.com.dicadefarmacia.infra.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
public class BeanToAliasTransformer implements ResultTransformer {

	private Class<?> classe;

	private BeanToAliasTransformer(Class<?> classe) {
		if (classe != null) {
			this.classe = classe;
		} else {
			throw new NullPointerException("A classe não pode ser nula");
		}
	}

	public static ResultTransformer aliasToBean(Class<?> classe) {
		return new BeanToAliasTransformer(classe);
	}

	@Override
	public List transformList(List lista) {
		return lista;
	}

	@Override
	public Object transformTuple(Object[] objetos, String[] alias) {
		Object object = null;
		try {
			object = classe.newInstance();

			setPropriedades(object, objetos, alias);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	private void setPropriedades(Object object, Object[] objetos, String[] alias) {

		for (int i = 0; i < alias.length; i++) {
			Object filho = object;
			String[] props = alias[i].split("_");
			for (int j = 0; j < props.length; j++) {
				Object aux = PropertyUtils.getPropriedadeAtributo(filho, props[j]);
				if (j != (props.length - 1)) {
					if (aux == null) {
						aux = PropertyUtils.getNewObject(PropertyUtils
								.getReturnType(filho, props[j]));
						PropertyUtils.setPropriedade(filho, props[j], aux);
					}
					filho = PropertyUtils.getPropriedadeAtributo(filho, props[j]);
				} else {
					aux = objetos[i];
					if (objetos[i].getClass() == String.class) {
						PropertyUtils.setPropriedade(filho, props[j], aux);
					
					} else if (PropertyUtils.getReturnType(filho, props[j]) == Integer.class) {
						PropertyUtils.setPropriedade(filho, props[j],
								new Integer( aux.toString()));

					} else if (PropertyUtils.getReturnType(filho, props[j]) == Double.class) {
						PropertyUtils.setPropriedade(filho, props[j],
								new Double(aux.toString()));

					} else if (PropertyUtils.getReturnType(filho, props[j]) == Long.class) {
						PropertyUtils.setPropriedade(filho, props[j], new Long(
								(aux.toString())));

					} else if (PropertyUtils.getReturnType(filho, props[j]) == Float.class) {
						PropertyUtils.setPropriedade(filho, props[j],
								new Float(aux.toString()));

					} else if (PropertyUtils.getReturnType(filho, props[j]) == BigDecimal.class) {
						PropertyUtils.setPropriedade(filho, props[j], new BigDecimal(aux.toString()));

					} else if (PropertyUtils.getReturnType(filho, props[j]) == BigInteger.class) {
						PropertyUtils.setPropriedade(filho, props[j],
								new BigInteger(aux.toString()));
						
					} else if (objetos[i].getClass() == Date.class
							|| objetos[i].getClass() == Timestamp.class) {
						PropertyUtils.setPropriedade(filho, props[j], aux);
					}

				}

			}

		}

	}

}
