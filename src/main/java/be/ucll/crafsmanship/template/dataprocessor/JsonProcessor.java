package be.ucll.crafsmanship.template.dataprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonProcessor extends DataProcessor {
    private Map<String, String> data;
    private List<String> outputData;

    public JsonProcessor(String inputFile, String outputFile){
        super(inputFile, outputFile);
        this.data = new HashMap<String, String>();
        this.outputData = new ArrayList<String>();
    }

    @Override
    protected void load() {
        System.out.println("loading JSON...");
        this.data.put("Naam", "Robbe");
        this.data.put("Achternaam", "Caerts");
        this.data.put("Dorp","Olmen");
    }

    @Override
    protected void transform() {
        System.out.println("transforming JSON...");
        data.forEach((k,v)->{
            this.outputData.add(k + ":" + v);
        });
    }

    @Override
    protected void save() {
        System.out.println("saving Json...");
    }
}
