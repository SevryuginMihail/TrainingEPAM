package Sevryugin.task2;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Класс осуществляет валидацию XML документа books.xml с помощью файла book.xsd
 */
public class MyXmlValidator {
    /**
     * Метод производит валидацию XML документа по схеме
     *
     * @param xsdPath - путь к схеме
     * @param xmlPath - путь к XML документу
     * @return - @true, если валидация успешна, @false - документ валидацию не прошел
     */
    public static boolean validateXml(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
}
