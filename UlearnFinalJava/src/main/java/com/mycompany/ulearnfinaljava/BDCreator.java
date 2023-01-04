package com.mycompany.ulearnfinaljava;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class BDCreator {
    BDCreator()
    {
        Create();
    }
    
    public void Create()
    {
        
        File base = new File("NetBeansProjects/UlearnFinalJava/src/main/resources/NewData.bd");
        if(!(base.exists()))
        {
            String url = "jdbc:sqlite:NetBeansProjects/UlearnFinalJava/src/main/resources/NewData.bd";
            String act = "CREATE TABLE IF NOT EXISTS Data (Rank TEXT, Name TEXT, Platform TEXT, Year TEXT, Genre TEXT, Publisher TEXT, NA_Sales TEXT, EU_Sales TEXT, JP_Sales TEXT, Other_Sales TEXT, Global_Sales TEXT) ";
            String sql = "INSERT INTO Data(Rank,Name,Platform, Year,Genre,Publisher,NA_Sales,EU_Sales,JP_Sales,Other_Sales,Global_Sales) VALUES(?,?,?,?,?,?,?,?,?,?,?) ";

            try (Connection conn = DriverManager.getConnection(url))
            {
                if (conn != null)
                {
                    Parser pr = new Parser();
                    Statement stm  = conn.createStatement();

                    stm.execute(act);

                    conn.setAutoCommit(false);
                    PreparedStatement ptm = conn.prepareStatement(sql);
                    for(int i = 0; i< pr.getSize(); i++)
                    {
                        ptm.setString(1, pr.GetValue("Rank", i));
                        ptm.setString(2, pr.GetValue("Name", i));
                        ptm.setString(3, pr.GetValue("Platform", i));
                        ptm.setString(4, pr.GetValue("Year", i));
                        ptm.setString(5, pr.GetValue("Genre", i));
                        ptm.setString(6, pr.GetValue("Publisher", i));
                        ptm.setString(7, pr.GetValue("NA_Sales", i));
                        ptm.setString(8, pr.GetValue("EU_Sales", i));
                        ptm.setString(9, pr.GetValue("JP_Sales", i));
                        ptm.setString(10, pr.GetValue("Other_Sales", i));
                        ptm.setString(11, pr.GetValue("Global_Sales", i));
                        ptm.addBatch();
                    }
                    ptm.executeBatch();
                    conn.commit();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
}
