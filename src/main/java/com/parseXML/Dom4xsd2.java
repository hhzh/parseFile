package com.parseXML;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4xsd2 {
	public static void main(String[] args) {
		SAXReader reader=new SAXReader();
		Document document;
		try {
			document = reader.read(new File("e:/PTY004request.xml"));
			Element root=document.getRootElement();
			List<Element> ele=root.selectNodes("//body/insured[position()<2]");
			for(int i=0;i<ele.size();i++){
				System.out.println(ele.get(i).getName()+"  @@@  "+ele.get(i).getText());
				List<Element> list=ele.get(i).elements();
				for(int j=0;j<list.size();j++){
					Element el=list.get(j);
					System.out.println("$$ "+el.getName()+" && "+el.getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public void recursionXML(Element element){
		if(!"".equals(element.getName().trim())){
			System.out.println("***"+element.getName());
		}
		List<Element> list=element.elements();
		if(0!=list.size()){
			for(Element el:list){
				recursionXML(el);
			}
		}
		
	}
	
	
}
