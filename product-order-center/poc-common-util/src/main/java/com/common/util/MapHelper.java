package com.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.common.util.DateUtil;

//描述：可将多个 java bean 自动转换成一个map, 满足一个请求传输多个java bean对象，保持接口不变，动态扩展
//特点：支持将多一个 java bean 属性以key-value方式存储到map<String, Object>中，key命名风格:  类名小写+.+类属性名称
//限制：暂时不支持嵌套bean
public class MapHelper {

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Object convertToBean(Class type, Map<String, Object> map) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
			Object obj = type.newInstance(); // 创建 JavaBean 对象

			String strPrefix = type.getSimpleName().toLowerCase() + ".";
			// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				try {
					PropertyDescriptor descriptor = propertyDescriptors[i];
					String propertyName = descriptor.getName();

					if (map.containsKey(strPrefix + propertyName)) {
						Object value = map.get(strPrefix + propertyName);
						Object[] args = new Object[1];
						args[0] = value;
						if(  descriptor.getPropertyType(). equals( java.util.Date.class) ) {
							if( value != null  &&  value instanceof  Long) {
								 args[0] = new  java.util.Date((long) value);
							} 
							else  if( value != null  &&  value instanceof  String ) {
								 //缺省支持: yyyy-MM-dd HH:mm:ss 标准日期格式
								args[0] = DateUtil.toDate((String)value);
							}
						}
						
						descriptor.getWriteMethod().invoke(obj, args);
					}
				} catch (Exception e) {

				}
			}
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Map<String, Object> convertToMap(Object bean) {
		try {
			Class type = bean.getClass();
			Map<String, Object> returnMap = new HashMap<String, Object>();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			String strPrefix = type.getSimpleName().toLowerCase() + ".";
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				try {
					PropertyDescriptor descriptor = propertyDescriptors[i];
					String propertyName = descriptor.getName();
					if (!propertyName.equals("class")) {
						Method readMethod = descriptor.getReadMethod();
						Object result = readMethod.invoke(bean, new Object[0]);
						if (result != null) {
							returnMap.put(strPrefix + propertyName, result);
						} else {
							returnMap.put(strPrefix + propertyName, null);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//  public static void main(String[] args) {
//		Calling calling = new Calling();
//		Date cur = new Date(System.currentTimeMillis() - 10000 * 1000);
//		calling.setId(0);
//		calling.setCusId(10);
//		calling.setBusiType(2);
//		calling.setCalComment("系统测试");
//		calling.setConnectTime(cur);
//		calling.setCallTime(cur);
//
//		calling.setHangupTime(new Date());
//		calling.setUpdateTime(new Date());
//		calling.setTalkSeconds(16);
//		calling.setSysType(1);
//		calling.setCaller("13817886226");
//		calling.setCalled("612011");
//		calling.setSessionId("1299392200022");
//		calling.setSeqId("1");
//		calling.setNodeId("2");
//		calling.setEmpId(462);
//		Map<String, Object> param = MapHelper.convertToMap(calling);
//		System.out.println("param:" + param);
//
//		Calling newCalling = (Calling) MapHelper.convertToBean(Calling.class, param);
//
//		System.out.println("bean-1:" + calling);
//		System.out.println("bean-2:" + newCalling);
//}

}
