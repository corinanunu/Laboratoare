package lab1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomQuery {
    public static void main(String[] args) {
        try{
            File inputFile = new File("lab1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.print("Root element : ");
            System.out.println(doc.getDocumentElement().getNodeName());

            NodeList tag2List = doc.getElementsByTagName("tag2");

            for(int i = 0; i < tag2List.getLength(); i++){
                Node node = tag2List.item(i);
                System.out.print("\n"+(i+1)+". Current element : ");
                System.out.println(node.getNodeName());

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String tagId = element.getAttribute("tag2Id");
                    //if(tagId.equals("001")){
                    System.out.print("----[ id = ");
                    System.out.print(tagId);
                    System.out.print(" ]----");
                    System.out.println("");

                    Node t1 = element.getElementsByTagName("t1").item(0);
                    System.out.println("t1 - "+t1.getTextContent());
                    Node t2 = element.getElementsByTagName("t2").item(0);
                    System.out.println("t2 - "+t2.getTextContent());
                    Node t3 = element.getElementsByTagName("t3").item(0);
                    System.out.println("t3 - "+t3.getTextContent());
                    Node t4 = element.getElementsByTagName("t1").item(0);
                    System.out.println("t4 - "+t4.getTextContent());
                    NodeList listOfElements = element.getElementsByTagName("listElements");
                    for(int z = 0; z < listOfElements.getLength(); z++){
                        Node nodeList = listOfElements.item(z);

                        if(nodeList.getNodeType() == Node.ELEMENT_NODE){
                            Element elementList = (Element) nodeList;
                            System.out.println(elementList.getTextContent());
                        }
                    }
                    Node t5 = element.getElementsByTagName("t5").item(0);
                    System.out.println("t5 - "+t5.getTextContent());
                    //}
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
