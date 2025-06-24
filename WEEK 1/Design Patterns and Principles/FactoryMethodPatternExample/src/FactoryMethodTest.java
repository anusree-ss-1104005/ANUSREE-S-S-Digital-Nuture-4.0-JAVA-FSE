public class FactoryMethodTest {
    public static void main(String[] args) {
        
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();
        
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
        
        // Alternatively, use the template method in DocumentFactory
        System.out.println("\nUsing template method:");
        wordFactory.processDocument();
        pdfFactory.processDocument();
        excelFactory.processDocument();
    }
}