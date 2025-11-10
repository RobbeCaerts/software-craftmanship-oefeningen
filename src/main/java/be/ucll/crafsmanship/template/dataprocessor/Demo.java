package be.ucll.crafsmanship.template.dataprocessor;

public class Demo {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVProcessor("input.csv", "output.csv");
        DataProcessor jsonProcessor = new JsonProcessor("input.json","output.json");

        System.out.println("\nProcessing CSV Data...");
        csvProcessor.process();

        System.out.println("\nProcessing JSON Data...");
        jsonProcessor.process();
    }
}
