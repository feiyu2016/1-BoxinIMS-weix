package com.boxin.framework.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class ReflectAssistant {
	private static final Log log = LogFactory.getLog(ReflectAssistant.class);

	@SuppressWarnings("unchecked")
	public static final Class getClass(String className, Class callingClass) {
		Class clazz = null;
		try {
			if (callingClass != null) {
				clazz = Class.forName(className, false, Thread.currentThread()
						.getContextClassLoader());

			}
			if (clazz == null) {
				clazz = Class.forName(className, false, ReflectUtils.class
						.getClassLoader());
			}
			if (clazz == null) {
				clazz = Class.forName(className, false, callingClass
						.getClassLoader());
			}
		} catch (ClassNotFoundException e) {
			log.warn("not find class for class name :" + className + "; msg: "
					+ e.getMessage());
		}
		return clazz;
	}

	/**
	 * 把一个Collection<T>变成��Map<String,T>，Map中的key是指定属性（T.getPropertyNamebr>
	 * 如果属值不唯一，数据将会有丢失
	 * 
	 * @param models
	 *            Collection<T>
	 * @param propertyName
	 *            指定的属性名
	 * @return Map<String, T>
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static final <T> Map<String, T> collectionToMap(
			Collection<T> models, String propertyName)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		if (StringUtils.isBlank(propertyName) || propertyName.length() < 2) {
			throw new IllegalArgumentException("invalid propertyName:"
					+ propertyName);
		}
		String methodName = getGetMehodName(propertyName);
		Map<String, T> map = new HashMap<String, T>();
		for (Iterator<T> iter = models.iterator(); iter.hasNext();) {
			T element = iter.next();
			Method getMethod = element.getClass().getMethod(methodName,
					new Class[0]);
			Object getObj = getMethod.invoke(element, new Object[0]);
			String key = (getObj == null ? null : getObj.toString());
			map.put(key, element);
		}
		return map;
	}

	/**
	 * 根据��属名，得到它的get方法
	 * 
	 * @param propertyName
	 * @return
	 */
	public static final String getGetMehodName(String propertyName) {
		return "get" + StringUtils.capitalize(propertyName);
	}

	/**
	 * 根据��属名，得到它的set方法
	 * 
	 * @param propertyName
	 * @return
	 */
	public static final String getSetMehodName(String propertyName) {
		return "set" + StringUtils.capitalize(propertyName);
	}

	/**
	 * get没有参数，get方法是public
	 * 
	 * @param method
	 * @return
	 */
	public static final boolean isGetMethod(Method method) {
		if (method == null) {
			return false;
		}
		if (!method.getName().startsWith("get")) {
			return false;
		}
		if (method.getParameterTypes().length > 0) {
			return false;
		}
		if (!Modifier.isPublic(method.getModifiers())) {
			return false;
		}
		return true;
	}

	/**
	 * set的参数必须只有一个，set的返回类型为void，set方法是public
	 * 
	 * @param method
	 * @return
	 */
	public static final boolean isSetMethod(Method method) {
		if (method == null) {
			return false;
		}
		if (!method.getName().startsWith("set")) {
			return false;
		}
		if (method.getParameterTypes().length != 1) {
			return false;
		}
		if (method.getReturnType() != Void.TYPE) {
			return false;
		}
		if (!Modifier.isPublic(method.getModifiers())) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static final Map<String, Object> getStaticFieldValues(Class clazz) {
		Map<String, Object> map = null;
		Field[] fs = clazz.getFields();
		if (fs != null && fs.length > 0) {
			map = new HashMap<String, Object>();
			for (Field f : fs) {
				Object fv = null;
				try {
					fv = f.get(null);
				} catch (IllegalArgumentException e) {
					continue;
				} catch (IllegalAccessException e) {
					continue;
				} catch (NullPointerException e) {
					continue;
				}
				map.put(f.getName(), fv);
			}
		}
		return map;
	}

	/**
	 * 获取obj对象中属性fieldName的
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static final Object getFieldValue(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field f = getField(obj.getClass(), fieldName);
		boolean bak = f.isAccessible();
		if (!bak)
			f.setAccessible(true);
		Object ret = f.get(obj);
		if (!bak)
			f.setAccessible(false);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public static final Field getField(Class c, String fieldName)
			throws NoSuchFieldException {
		while (!c.getName().equals(Object.class.getName())) {
			try {
				Field f = c.getDeclaredField(fieldName);
				return f;
			} catch (NoSuchFieldException e) {
				c = c.getSuperclass();
			}
		}
		throw new NoSuchFieldException("[" + c + "," + fieldName);
	}

	/**
	 * 设置对象obj中fieldName 
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
		Field f = getField(obj.getClass(), fieldName);
		boolean bak = f.isAccessible();
		if (!bak)
			f.setAccessible(true);
		f.set(obj, value);
		if (!bak)
			f.setAccessible(false);
	}

	public static final boolean equals(Object x, Object y) {
		return x == y || (x != null && y != null && x.equals(y));
	}
}
