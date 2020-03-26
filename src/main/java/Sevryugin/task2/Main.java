package Sevryugin.task2;

/**
 * Класс создает, заполняет и валидирует XML документ
 */
public class Main {
    public static void main(String[] args) {
        DomWriter.createXML();
        System.out.println(MyXmlValidator.validateXml("src/main/resources/book.xsd", "books.xml"));
    }
}
