package com.easy.commons.utils;


import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * 基于CGlib
 * 实体工具类，目前copy不支持map、list
 * 
 * @Title: BeanUtils.java
 * @Package com.huazhukeji.commons.utils
 * @author 耿壮
 * @date 2016年7月28日 上午10:25:12
 * @company 河北华助科技有限公司
 * @version V1.0
 */
public final class BeanUtils extends org.springframework.beans.BeanUtils {
	private BeanUtils(){}

	/**
	 * 实例化对象
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<?> clazz) {
		try {
			return (T) clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 实例化对象
	 * 
	 * @param clazzStr
	 * @return
	 */
	public static <T> T newInstance(String clazzStr) {
		try {
			Class<?> clazz = Class.forName(clazzStr);
			return newInstance(clazz);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * copy 对象属性到另一个对象，默认不使用Convert
	 * 
	 * @param src
	 * @param clazz
	 * @return
	 */
	public static <T> T copy(Object src, Class<T> clazz) {
		BeanCopier copier = BeanCopier.create(src.getClass(), clazz, false);

		T to = newInstance(clazz);
		copier.copy(src, to, null);
		return to;
	}

	/**
	 * 拷贝对象
	 * 
	 * @param src
	 * @param dist
	 */
	public static void copy(Object src, Object dist) {
		BeanCopier copier = BeanCopier
				.create(src.getClass(), dist.getClass(), false);

		copier.copy(src, dist, null);
	}

	/**
	 * 将对象装成map形式
	 * 
	 * @param src
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map toMap(Object src) {
		return BeanMap.create(src);
	}
}
