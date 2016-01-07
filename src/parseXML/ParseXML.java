package parseXML;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXML {
	public static void main(String[] args) {
		ParseXML px=new ParseXML();
		px.readXML();
	}
	
	public void readXML(){
		try {
			Document document=new SAXReader().read(new File("e:/pty.xml"));
			Element element=document.getRootElement();
			Iterator<Element> it=element.elementIterator();
			while(it.hasNext()){
				Element el=it.next();
//				List<Attribute> list=el.attributes();
//				for(Attribute att:list){
//					System.out.println(att.getName());
//					System.out.println(att.getValue());
//				}
				
				Iterator<Element> iter=el.elementIterator();
				while(iter.hasNext()){
					Element e=iter.next();
					System.out.println(e.getName());
				}
				
			}
//			System.out.println(element.getName());
//			System.out.println(element.getPath());
//			System.out.println(element.getStringValue());
//			System.out.println(element.getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}
