package com.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.entity.TestMessage;
import com.thoughtworks.xstream.XStream;

public class Message {
       
	/**
	 * 新建方法，将接收到的XML格式，转化为Map对象
	 * @param request 将request对象，通过参数传入
	 * @return 返回转换后的Map对象	 
	 * @throws IOException 
	 * @throws DocumentException */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map=new HashMap<String, String>();
		//从dom4j.jar  中拿到SAXReader对象
		SAXReader reader=new SAXReader();
		
		
		
		InputStream is=request.getInputStream();//从request中获取输入流
		Document doc=reader.read(is);//从reader对象中读取输入流
		Element root=doc.getRootElement();//获取XML文档的根元素
		List<Element> list=root.elements();//获取根元素下所有子节点
		
		for(Element e:list){
			map.put(e.getName(), e.getText());//遍历list对象并将结果保存到集合中
		}
		is.close();
		return map;
		
	}
	
	/**
	 * 将文本消息对象转化成XML格式
	 * @param message 文本消息对象
	 * @return 返回转换后的XML格式
	 */
	public static String objectToXml(TestMessage message){
	XStream xs = new XStream();
	//由于转换后xml根节点默认为class类，需转化为<xml>
	xs.alias("xml", message.getClass());
	return xs.toXML(message);
	}
	
}
