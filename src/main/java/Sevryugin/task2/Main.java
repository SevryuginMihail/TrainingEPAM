package Sevryugin.task2;

public class Main {
    public static void main(String[] args) {
        DomWriter.createXML();
        System.out.println( MyXmlValidator.validateXml("src/main/resources/book.xsd", "books.xml"));
    }
}
