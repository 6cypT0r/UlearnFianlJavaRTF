package com.mycompany.ulearnfinaljava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request 
{
    Request()
    {
        
    }
    
    public List Graph()
    {
        List<String> requests; 
        
        List<Integer> Value = new ArrayList<>();
        String url = "jdbc:sqlite:NetBeansProjects/UlearnFinalJava/src/main/resources/NewData.bd";
        
        File sqlrq = new File("NetBeansProjects/UlearnFinalJava/src/main/resources/BaseRequests.txt");
        if(!(sqlrq.exists()))
        {
            CreateSQLRequests();
        }
        else
        {
            try(Connection conn = DriverManager.getConnection(url))
            {

                Path pathRQ = Paths.get("NetBeansProjects/UlearnFinalJava/src/main/resources/BaseRequests.txt");
                requests = Files.readAllLines(pathRQ, StandardCharsets.UTF_8);
                Statement stm = conn.createStatement();

                for(int i =0; i < requests.size();i++)
                {
                    Value.add(stm.executeQuery(requests.get(i)).getInt("count(Global_Sales)"));
                }
            }
            catch(SQLException | IOException ex )
            {
                 System.out.println(ex.getMessage());
            }
            
        }
        return Value;
    }
    
    public String ShowName(int number)
    {
        String name = "";
        String rq = "";
        String url = "jdbc:sqlite:NetBeansProjects/UlearnFinalJava/src/main/resources/NewData.bd";
        try(Connection conn = DriverManager.getConnection(url))
        {
            if(number == 2)
            {
                rq = "SELECT *, Max(Global_Sales) FROM Data where Year =='2000';";
                Statement ts = conn.createStatement();
                name = ts.executeQuery(rq).getString("Name");
            }
            else if(number ==3)
            {
                rq ="SELECT *,max(JP_Sales) FROM Data WHERE Year >='2000' and Year <='2006';";
                Statement ts = conn.createStatement();
                name = ts.executeQuery(rq).getString("Name");
            }
        }
        catch(SQLException ex)
        {
             System.out.println(ex.getMessage());
        }
        
        
        return name;
        
    }
    public void CreateSQLRequests()
    {
        
        String sql = "SELECT count(Global_Sales) FROM Data WHERE Platform =='";
        List<String> platforms;
        
         FileWriter myWriter;
        try 
        {
            Path path = Paths.get("NetBeansProjects/UlearnFinalJava/src/main/resources/Platfroms.txt");
            platforms = Files.readAllLines(path, StandardCharsets.UTF_8);
            myWriter = new FileWriter("NetBeansProjects/UlearnFinalJava/src/main/resources/BaseRequests.txt");
            
            
            for(int i = 0; i < platforms.size();i++)
            {
                myWriter.append(sql+platforms.get(i)+"';"+"\n");
            }
             myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
