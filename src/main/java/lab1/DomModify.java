package lab1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomModify {
    public static void main(String[] args) {
        try{
            File inputFile = new File("lab1.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            Node tag0 = doc.getFirstChild();
            System.out.println("Root element - "+tag0.getNodeName());

            Element tag1 = doc.createElement("tag1");
            Attr tag1name = doc.createAttribute("tag1name");
            tag1name.setValue("nameDepartment");
            Attr tg1Id = doc.createAttribute("tg1Id");
            tg1Id.setValue("3");
            tag1.setAttributeNode(tag1name);
            tag1.setAttributeNode(tg1Id);
            tag0.appendChild(tag1);

            Element tag2 = doc.createElement("tag2");
            Attr tag2Id = doc.createAttribute("tag2Id");
            tag2Id.setValue("005");
            tag1.appendChild(tag2);

            Element t1 = doc.createElement("t1");
            t1.appendChild(doc.createTextNode("string 5"));
            tag2.appendChild(t1);

            Element t2 = doc.createElement("t2");
            t2.appendChild(doc.createTextNode("string 5"));
            tag2.appendChild(t2);

            Element t3 = doc.createElement("t3");
            t3.appendChild(doc.createTextNode("date or int 5"));
            tag2.appendChild(t3);

            Element t4 = doc.createElement("t4");
            t4.appendChild(doc.createTextNode("string 5"));
            tag2.appendChild(t4);

            Element listElements = doc.createElement("listElements");
            tag2.appendChild(listElements);

            Element listElement1 = doc.createElement("listElement");
            listElement1.appendChild(doc.createTextNode("list5 string a"));
            listElements.appendChild(listElement1);

            Element listElement2 = doc.createElement("listElement");
            listElement2.appendChild(doc.createTextNode("list5 string b"));
            listElements.appendChild(listElement2);

            Element listElement3 = doc.createElement("listElement");
            listElement3.appendChild(doc.createTextNode("list5 string c"));
            listElements.appendChild(listElement3);

            Element listElement4 = doc.createElement("listElement");
            listElement4.appendChild(doc.createTextNode("list5 string d"));
            listElements.appendChild(listElement4);

            Element t5 = doc.createElement("t5");
            t5.appendChild(doc.createTextNode("string 5"));
            tag2.appendChild(t5);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(inputFile);
            transformer.transform(source, fileResult);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
