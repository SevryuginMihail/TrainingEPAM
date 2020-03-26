package Sevryugin.task1;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Данный класс реализует технологию парсера DOM для логгирования XML документа в файл
 */
@Slf4j
public class DomParser {
    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("plant_catalog.xml");
            Node root = document.getDocumentElement();
            log.info("");
            log.info("List of plant");
            NodeList plants = root.getChildNodes();
            for (int i = 0; i < plants.getLength(); i++) {
                Node plant = plants.item(i);
                if (plant.getNodeType() != Node.TEXT_NODE) {
                    NodeList plantProps = plant.getChildNodes();
                    for (int j = 0; j < plantProps.getLength(); j++) {
                        Node plantProp = plantProps.item(j);
                        if (plantProp.getNodeType() != Node.TEXT_NODE) {
                            log.info(plantProp.getNodeName() + " : " + plantProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    log.info("==========>>>>");
                }
            }
            System.out.println("dom разбор успешно завершен");
            System.out.println("\tlogs/domLog.log.txt");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
