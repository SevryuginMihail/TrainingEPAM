package Sevryugin.task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Класс создает XML документ и заполняет его, используя технологию DOM
 */
public class DomWriter {
    public static void createXML() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // root element
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("Books");
            document.appendChild(rootElement);
            // book element
            Element book = document.createElement("book");
            rootElement.appendChild(book);
            // author element
            Element author = document.createElement("author");
            book.appendChild(author);
            // author's elements
            Element firstName = document.createElement("firstName");
            firstName.appendChild(document.createTextNode("Lev"));
            author.appendChild(firstName);
            Element secondName = document.createElement("secondName");
            secondName.appendChild(document.createTextNode("Nikolayevich"));
            author.appendChild(secondName);
            Element lastName = document.createElement("lastName");
            lastName.appendChild(document.createTextNode("Tolstoy"));
            author.appendChild(lastName);
            // book's elements
            Element numberPages = document.createElement("numberPages");
            numberPages.appendChild(document.createTextNode("960"));
            book.appendChild(numberPages);
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode("Anna Karenina"));
            book.appendChild(name);
            Element publisher = document.createElement("publisher");
            publisher.appendChild(document.createTextNode("exmo"));
            book.appendChild(publisher);
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("books.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("XML файл записан");
            System.out.println("books.xml");
        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
