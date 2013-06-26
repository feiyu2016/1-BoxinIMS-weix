package com.boxin.ims.modules.wechat.utils;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XMLUtils {

	public static Map<String, String> xml2Map(String xmlStr)
			throws Exception {
		Map<String, String> rtnMap = new HashMap<String, String>();
//		SAXBuilder builder = new SAXBuilder();
//		Document doc = builder.build(new StringReader(xmlStr));
		SAXReader reader = new SAXReader();
		Document doc  =  reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
		
		// 得到根节点  
		Element root = doc.getRootElement();
		String rootName = root.getName();
		rtnMap.put("root.name", rootName);
		// 调用递归函数，得到所有最底层元素的名称和值，加入map中  
		convert(root, rtnMap, rootName);
		return rtnMap;
	}

	/**
	 * 递归函数，找出最下层的节点并加入到map中，由xml2Map方法调用。
	 * 
	 * @param e
	 *            xml节点，包括根节点
	 * @param map
	 *            目标map
	 * @param lastname
	 *            从根节点到上一级节点名称连接的字串
	 */
	public static void convert(Element e, Map<String, String> map,
			String lastname) {
		if (e.attributes().size() > 0) {
			Iterator it_attr = e.attributes().iterator();
			while (it_attr.hasNext()) {
				Attribute attribute = (Attribute) it_attr.next();
				String attrname = attribute.getName();
				String attrvalue = e.attributeValue(attrname);
				map.put(lastname + "." + attrname, attrvalue);
			}
		}
		List children = e.elements();
		Iterator it = children.iterator();
		while (it.hasNext()) {
			Element child = (Element) it.next();
			String name = lastname + "." + child.getName();
			// 如果有子节点，则递归调用
			if (child.elements().size() > 0) {
				convert(child, map, name);
			} else {
				// 如果没有子节点，则把值加入map
				map.put(name, child.getText());
				// 如果该节点有属性，则把所有的属性值也加入map
				if (child.attributes().size() > 0) {
					Iterator attr = child.attributes().iterator();
					while (attr.hasNext()) {
						Attribute attribute = (Attribute) attr.next();
						String attrname = attribute.getName();
						String attrvalue = child.attributeValue(attrname);
						map.put(name + "." + attrname, attrvalue);
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String xmlStr = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[EVENT]]></Event><EventKey><![CDATA[EVENTKEY]]></EventKey></xml>";
		try {
			
			Map<String,String> map = xml2Map(xmlStr);
			System.out.println(map.size());
		} catch (Exception e) {
			 
			e.printStackTrace();
			
		}
	}
}
