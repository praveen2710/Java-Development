package com.bebetteratjava.outsideinTDD;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesRepository {

    private final String fileLocation;
    private List<Sale> sales;

    public SalesRepository(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public List<Sale> loadSales() {
        if(sales == null){
            sales = new ArrayList<>();
            final File file = new File(fileLocation);
            if(!file.exists() || !file.canRead() || !file.isFile()){
                System.err.println("Unable to find readable file:" + file.getAbsolutePath());
            }
            try(CSVReader reader = new CSVReader(new FileReader(fileLocation))){
                String[] nextLine;
                while((nextLine = reader.readNext())!= null){
                    String store = nextLine[1].trim();
                    int qty = parseInt(nextLine[2].trim());
                    int pricePerItem = parseInt(nextLine[3].trim());
                    sales.add(new Sale(store,qty,pricePerItem));
                }
                return sales;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return sales;
    }
}
