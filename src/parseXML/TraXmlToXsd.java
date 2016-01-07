package parseXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class TraXmlToXsd {
	
	private PrintWriter out=null;
	private String xmlFilePath;
	private String xsdFilePath;
	
	public static void main(String[] args) {
		TraXmlToXsd px=new TraXmlToXsd();
		px.xmlFilePath="D:/aa.xml";//需要传入的xml文件路径
		px.xsdFilePath="D:/ab.xsd";//写出的xsd文件路径
		px.writeXSD();
		px.traverseXML(px.importFile());
		px.out.println("</xs:schema>");
	}
	
	/**
	 * 导入xml文件
	 */
	public Element importFile(){
		SAXBuilder reader=new SAXBuilder();
		Document doc = null;
		Element root=null;
		try {
			doc=reader.build(new File(xmlFilePath));
			root=doc.getRootElement();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		return root;
	}
	
	/**
	 * 解析xml，生成xsd
	 */
	public void traverseXML(Element element){
		List<Object> elList=element.getChildren();
		if(null==elList||0==elList.size()){
//			System.out.println(element.getName());
			out.println("\t\t\t\t<xs:element type=\"xs:string\" name=\""+element.getName()+"\"/>");
		}else{
//			System.out.println(element.getName());
			out.println("\t<xs:element name=\""+element.getName()+"\">");
			out.println("\t\t<xs:complexType>");
			out.println("\t\t\t<xs:sequence>");
			for(int i=0;i<elList.size();i++){
				Element child=(Element) elList.get(i);
				traverseXML(child);
			}
			out.println("\t\t\t</xs:sequence>");
			out.println("\t\t</xs:complexType>");
			out.println("\t</xs:element>");
		}
	}
	
	/**
	 * 开始写xsd
	 */
	public void writeXSD(){
		try {
			out=new PrintWriter(new FileWriter(new File(xsdFilePath)),true);
			out.println("<xs:schema attributeFormDefault=\"unqualified\" elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
