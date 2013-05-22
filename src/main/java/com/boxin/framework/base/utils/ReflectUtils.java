package com.boxin.framework.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public final class ReflectUtils {
	/**
	 * @see ReflectAssistant#getClass(String, Class)
	 */
	@SuppressWarnings("unchecked")
	public static final Class getClass(String className, Class callingClass) {
		return ReflectAssistant.getClass(className, callingClass);
	}

	/**
	 * @see ReflectAssistant#collectionToMap(Collection, String)
	 */
	public static final <T> Map<String, T> collectionToMap(
			Collection<T> models, String propertyName)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		return ReflectAssistant.collectionToMap(models, propertyName);
	}

	/**
	 * @see ReflectAssistant#getGetMehodName(String)
	 */
	public static final String getGetMehodName(String propertyName) {
		return ReflectAssistant.getGetMehodName(propertyName);
	}

	/**
	 * @see ReflectAssistant#getSetMehodName(String)
	 */
	public static final String getSetMehodName(String propertyName) {
		return ReflectAssistant.getSetMehodName(propertyName);
	}

	/**
	 * @see ReflectAssistant#isGetMethod(Method)
	 */
	public static final boolean isGetMethod(Method method) {
		return ReflectAssistant.isGetMethod(method);
	}

	/**
	 * @see ReflectAssistant#getSetMehodName(String)
	 */
	public static final boolean isSetMethod(Method method) {
		return ReflectAssistant.isSetMethod(method);
	}

	/**
	 * @see ReflectAssistant#getStaticFieldValues(Class)
	 */
	@SuppressWarnings("unchecked")
	public static final Map<String, Object> getStaticFieldValues(Class clazz) {
		return ReflectAssistant.getStaticFieldValues(clazz);
	}

	/**
	 * @see ReflectAssistant#equals(Object, Object)
	 */
	public static final boolean equals(Object x, Object y) {
		return ReflectAssistant.equals(x, y);
	}

	/**
	 * 获取obj对象中属性fieldName的
	 * 
	 * @param obj
	 *            对象
	 * @param fieldName
	 *            属
	 * @return Object 
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static final Object getFieldValue(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		return ReflectAssistant.getFieldValue(obj, fieldName);
	}

	@SuppressWarnings("unchecked")
	public static final Field getField(Class c, String fieldName)
			throws NoSuchFieldException {
		return ReflectAssistant.getField(c, fieldName);
	}

	/**
	 * 设置对象obj中fieldName属的
	 * 
	 * @param obj
	 * @param fieldName
	 * @param value
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static final void setFieldValue(Object obj, String fieldName,
			Object value) throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		ReflectAssistant.setFieldValue(obj, fieldName, value);
	}
	
	/**
	 * @author Jakemanse
	 * @param classPath
	 * @return
	 * @time 2013-1-4 上午11:29:08
	 * <p>function : </p>
	 * @@param classPath
	 * @@return
	 */
	public static Object newInstance(String classPath){
		try {
			Class clazz = Class.forName(classPath);
			return net.sf.cglib.core.ReflectUtils.newInstance(clazz);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
