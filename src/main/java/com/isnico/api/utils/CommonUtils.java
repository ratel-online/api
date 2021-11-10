package com.isnico.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

public class CommonUtils {

	public static String getUUID() { return UUID.randomUUID().toString().replace("-", ""); };

	
	public static <T,V> List<V> convertPovo(List<T> sources, Class<V> vClass){
		return convertPovo(sources, vClass, null);
	}
	
	/**
	 * Copy List<Po> to List<Vo>
	 * 
	 * @param sources List of Po
	 * @param vClass Vo's class
	 * @param modify {@link Modify}
	 * @return List of Vo
	 * @author nico
	 */
	public static <T,V> List<V> convertPovo(List<T> sources, Class<V> vClass, Modify<V> modify){
		List<V> vs = new ArrayList<V>(10);
		if(CollectionUtils.isEmpty(sources)) {
			return vs;
		}
		sources.forEach(source -> {
			try {
				V v = vClass.newInstance();
				BeanUtils.copyProperties(source, v);
				if(modify != null) {
					modify.modify(v);
				}
				vs.add(v);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		return vs;
	}
	
	/**
	 * 修改vo参数
	 */
	public static interface Modify<T>{
		public void modify(T entity);
	}
	
	/**
	 * Copy 
	 * 
	 * @param source
	 * @param vClass
	 * @return
	 */
	public static <T,V> V convertPovo(T source, Class<V> vClass){
		if(source == null) {
			return null;
		}
		V v = null;
		try {
			v = vClass.newInstance();
			BeanUtils.copyProperties(source, v);
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return v;
	}

}
