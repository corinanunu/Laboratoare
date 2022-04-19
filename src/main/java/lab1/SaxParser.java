package lab1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {
    public static void main(String[] args) {
        try{
            File inputFile = new File("lab1.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandlerLab1 userHandlerLab1 = new UserHandlerLab1();
            saxParser.parse(inputFile, userHandlerLab1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class UserHandlerLab1 extends DefaultHandler {
    boolean bT1 = false;
    boolean bT2 = false;
    boolean bT3 = false;
    boolean bT4 = false;
    boolean bLists = false;
    boolean bT5 = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("tag2")){
            String id = attributes.getValue("tag2Id");
            System.out.println("Tag2 id = "+id);
        }else if(qName.equalsIgnoreCase("t1")){
            bT1 = true;
        }else if(qName.equalsIgnoreCase("t2")){
            bT2 = true;
        }else if(qName.equalsIgnoreCase("t3")){
            bT3 = true;
        }else if(qName.equalsIgnoreCase("t4")){
            bT4 = true;
        }else if(qName.equalsIgnoreCase("listElement")){
            bLists = true;
        }else if(qName.equalsIgnoreCase("t5")){
            bT5 = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("tag2")){
            System.out.println("End element : "+qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bT1){
            System.out.println("t1 : "+new String(ch, start, length));
            bT1 = false;
        }else if(bT2){
            System.out.println("t2 : "+new String(ch, start, length));
            bT2 = false;
        }else if(bT3){
            System.out.println("t3 : "+new String(ch, start, length));
            bT3 = false;
        }else if(bT4){
            System.out.println("t4 : "+new String(ch, start, length));
            bT4 = false;
        }else if(bLists){
            System.out.println("Lists : "+new String(ch, start, length));
            bLists = false;
        }else if(bT5){
            System.out.println("t5 : "+new String(ch, start, length));
            bT5 = false;
        }
    }
}
