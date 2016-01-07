package parseXML;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4xsd {
	public static void main(String[] args) {
		new Dom4xsd().readXML("e:/PTY004request.xml");
	}
	
	public void readXML(String filepath){
		SAXReader reader=new SAXReader();
		Document document;
		try {
			document = reader.read(new File(filepath));
			Element root=document.getRootElement();
			recursionXML(root);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
//	public void recursionXML(Element element){
//		System.out.println("***"+element.getName());
//		Iterator<Attribute> itAtt=element.elementIterator();
//		while(itAtt.hasNext()){
//			Attribute att=itAtt.next();
//			System.out.println("节点名： "+att.getName()+"---节点值： "+att.getValue());
//		}
//		
//		if(!"".equals(element.getTextTrim())){
//			System.out.println("++文本内容： "+element.getTextTrim());
//		}
//		
//		Iterator<Element> it=element.elementIterator();
//		while(it.hasNext()){
//			Element e=it.next();
//			recursionXML(e);
//		}
//		
//	}
	int count=0;
	public void recursionXML(Element element){
		if(!"".equals(element.getName().trim())){
			System.out.println("***"+element.getName());
		}
		List<Element> list=element.elements();
		Map<Integer, String> map=new HashMap<Integer, String>();
		count++;
//		System.out.println("#######  第 "+count+" 次");
		if(0!=list.size()){System.out.println("#######  第 "+count+" 次");
			for(Element el:list){
				recursionXML(el);
			}
		}
		
	}
	
	
}
