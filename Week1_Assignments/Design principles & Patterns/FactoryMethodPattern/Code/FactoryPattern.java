public class FactoryPattern {

    // Document interface
    interface Document {
        void open();
    }

    // Concrete implementations
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }

    // Factory abstract class
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete factories
    static class WordFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Main method
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}
