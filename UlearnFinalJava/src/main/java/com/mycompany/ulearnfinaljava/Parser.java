package com.mycompany.ulearnfinaljava;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Parser 
{
    List<String> Rank;
    List<String> Name;
    List<String> Platform;
    List<String> Year;
    List<String> Genre;
    List<String> Publisher;
    List<String> NA_Sales;
    List<String> EU_Sales;
    List<String> JP_Sales;
    List<String> Other_Sales;
    List<String> Global_Sales;
    
    HashSet<String> UniquePlatforms;

    
    CSVParser cvp;
    
    Path pth;
    
    Parser()
    {
        Read();   
    }
    public void Read()
    {
         //create path
        pth = Path.of("NetBeansProjects/UlearnFinalJava/src/main/resources/Test.csv");
        
        //create tables
        Rank = new ArrayList<>();
        Name = new ArrayList<>();
        Platform = new ArrayList<>();
        Year = new ArrayList<>();
        Genre = new ArrayList<>();
        Publisher = new ArrayList<>();
        NA_Sales = new ArrayList<>();
        EU_Sales = new ArrayList<>();
        JP_Sales = new ArrayList<>();
        Other_Sales = new ArrayList<>();
        Global_Sales = new ArrayList<>();
        
        UniquePlatforms = new HashSet<>();
        
        try
        {
            cvp = new CSVParserBuilder().withSeparator(',').withQuoteChar('\"').build();
            BufferedReader br = Files.newBufferedReader(pth, StandardCharsets.UTF_8);
            var reader = new CSVReaderBuilder(br).withCSVParser(cvp).build();
            reader.readNext();
            String[] line ;

            
            while((line=reader.readNext())!=null)
            {

                Rank.add(line[0]);
                Name.add(line[1]);
                Platform.add(line[2]);
                UniquePlatforms.add(line[2]); //fill the set
                Year.add(line[3]);
                Genre.add(line[4]);
                Publisher.add(line[5]);
                NA_Sales.add(line[6]);
                EU_Sales.add(line[7]);
                JP_Sales.add(line[8]);
                Other_Sales.add(line[9]);
                Global_Sales.add(line[10]);
            }
            
            
        }
        catch(FileNotFoundException ex)
        { 
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        
        File PlatformStorage = new File("NetBeansProjects/UlearnFinalJava/src/main/resources/Platfroms.txt");
        
        if(!(PlatformStorage.exists()))
        {
           CreatePlatfromList();
        }
    }
    
    public int getSize()
    {
        return Rank.size();
    }
    
    public void CreatePlatfromList()
    {
        Path path = Paths.get("NetBeansProjects/UlearnFinalJava/src/main/resources/Platfroms.txt");
              
        List<String> pl = new ArrayList<>(UniquePlatforms);
        Collections.sort(pl);
        
        try 
        {
            Files.write(path,pl,StandardCharsets.UTF_8);
        } 
        catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public String GetValue(String request, int position)
    {
        if(request.equals("Rank"))
        {
            return Rank.get(position);
        }
        else if(request.equals("Name"))
        {
            return Name.get(position);
        }
        else if(request.equals("Platform"))
        {
            return Platform.get(position);
        }
        else if(request.equals("Year"))
        {
            return Year.get(position);
        }
        else if(request.equals("Genre"))
        {
            return Genre.get(position);
        }
        else if(request.equals("Publisher"))
        {
            return Publisher.get(position);
        }
        else if(request.equals("NA_Sales"))
        {
            return NA_Sales.get(position);
        }
        else if(request.equals("EU_Sales"))
        {
            return EU_Sales.get(position);
        }
        else if(request.equals("JP_Sales"))
        {
            return JP_Sales.get(position);
        }
        else if(request.equals("Other_Sales"))
        {
            return Other_Sales.get(position);
        }
        else if(request.equals("Global_Sales"))
        {
            return Global_Sales.get(position);
        }
        else
        {
            return null;
        }
    }    
}
