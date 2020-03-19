package Sevryugin.task1;

import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Slf4j
public class StaxParser {
    public static void main(String[] args) {
        final String fileName="plant_catalog.xml";
        try{
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName,new FileInputStream(fileName));
            while(xmlr.hasNext()){
                xmlr.next();
                if(xmlr.isStartElement()){
                    log.info(xmlr.getLocalName());
                }else if(xmlr.isEndElement()){
                    log.info("/"+xmlr.getLocalName());
                }else if(xmlr.hasText() && xmlr.getText().trim().length() > 0){
                    log.info("    "+xmlr.getText());
                }
            }
            System.out.println("stax разбор успешно завершен");
            System.out.println("\tlogs/staxLog.log.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
