package be.ucll.crafsmanship.template.dataprocessor;

public class DataProcessor {
    private String inputFile;
    private String outputFile;

    public final void process() {
        load();
        transform();
        save();
    }

    public DataProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    void load(){
        System.err.println("override this function in the sub class");
    }

    void transform(){
        System.err.println("override this function in the sub class");
    }

    void save(){
        System.err.println("override this function in the sub class");
    }
}
