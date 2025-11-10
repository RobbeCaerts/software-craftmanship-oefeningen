package be.ucll.crafsmanship.template.dataprocessor;

import java.util.ArrayList;
import java.util.List;

public class CSVProcessor extends DataProcessor {
    private List<String> data;

    public CSVProcessor(String inputFile, String outputFile) {
        super(inputFile, outputFile);
        this.data = new ArrayList<>();
    }

    @Override
    protected void load() {
        System.out.println("loading CSV...");
        this.data.add("line 1");
        this.data.add("line 2");
        this.data.add("line 3");
    }

    @Override
    protected void transform() {
        System.out.println("transforming CSV...");
        data.replaceAll(String::toUpperCase);
    }

    @Override
    protected void save() {
        System.out.println("saving CSV...");
    }

}
