package lab1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParse {
    public static void main(String[] args) {
        try{
            File inputFile = new File("lab1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : "+doc.getFirstChild().getNodeName());

            NodeList tag1List = doc.getElementsByTagName("tag1");
            NodeList tag2List = doc.getElementsByTagName("tag2");

            for(int i = 0; i < tag2List.getLength(); i++){
                Node nodeTag2 = tag2List.item(i);
                System.out.println("Current element : "+nodeTag2.getNodeName());

                if(nodeTag2.getNodeType() == Node.ELEMENT_NODE){
                    Element eTag2 = (Element) nodeTag2;

                    System.out.println("tag2Id : "+eTag2.getAttribute("tag2Id"));

                    System.out.println("t1 : "
                            +eTag2
                            .getElementsByTagName("t1")
                            .item(0)
                            .getTextContent());

                    System.out.println("t2 : "
                            +eTag2
                            .getElementsByTagName("t2")
                            .item(0)
                            .getTextContent());

                    System.out.println("t3 : "
                            +eTag2
                            .getElementsByTagName("t3")
                            .item(0)
                            .getTextContent());

                    System.out.println("t4 : "
                            +eTag2
                            .getElementsByTagName("t4")
                            .item(0)
                            .getTextContent());

                    NodeList listElements = doc.getElementsByTagName("listElements");

                    System.out.println("List of elements");

                    Node nodeElement = listElements.item(i);

                    if (nodeElement.getNodeType() == Node.ELEMENT_NODE) {
                        Element eList = (Element) nodeElement;
                        NodeList listOfElementsFromTag2 = eList.getElementsByTagName("listElement");
                        for(int count = 0; count < listOfElementsFromTag2.getLength(); count++){
                            Node node1 = listOfElementsFromTag2.item(count);

                            if(node1.getNodeType() == Node.ELEMENT_NODE){
                                Element elementList = (Element) node1;
                                System.out.println("  " + (count + 1) +". "+ elementList.getTextContent());
                            }
                        }

                    }


                    System.out.println("t5 : "
                            +eTag2
                            .getElementsByTagName("t5")
                            .item(0)
                            .getTextContent());
                }

                System.out.println();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
