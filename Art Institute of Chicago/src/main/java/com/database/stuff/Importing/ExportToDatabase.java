package com.database.stuff.Importing;

import com.database.stuff.Model.ArtFiles;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExportToDatabase {

    private String tableName;
    private String tableNamePercentage;
    private BasicDataSource dataSource = new BasicDataSource();
    private final JdbcTemplate jdbcTemplate;
    private List<ArtFiles> artFiles;
    ImportData importData = new ImportData();

    public static void main(String[] args) {
        String table = "artwork";
        ExportToDatabase exportToDatabase = new ExportToDatabase(table);
        exportToDatabase.generateScript();
    }


    public ExportToDatabase(String tableName) {
        this.tableName = tableName + ".sql";
        tableNamePercentage = tableName;
        dataSource.setUrl("jdbc:postgresql://localhost:5432/artwork");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        jdbcTemplate = new JdbcTemplate(dataSource);
        artFiles = importData.readData();
        System.out.println(artFiles.get(2).toString());
        System.out.println("2");
    }

    public void generateScript()
    {
        List<String> script = new ArrayList<>();
        script.add(printHeader());
        for(ArtFiles artFile : artFiles)
        {
            String test = "Insert Into "+tableName.substring(0, tableName.length() - 4)+" (aic_id, title, main_reference_number, department_title, artist_title) Values('";
            test = test +artFile.getId()+"'" + ", ";
            test = test +"'"+ artFile.getTitle() +"'"+ ", ";
            test = test +"'"+ artFile.getMainReferenceNumber()+"'" + ", ";;
            test = test + "'"+artFile.getDepartmentTitle() +"'"+ ", ";
            test = test +"'"+ artFile.getArtistTitle()+"');";
            script.add(test);
        }
        script.add("Commit;");
        writeToFile(script);
    }

    public void writeToFile(List<String> script)
    {
        try(PrintWriter pW = new PrintWriter(tableName))
        {
            for(String line : script)
            {
                pW.println(line);
            }
        }catch(Exception e)
        {
            System.out.println("Could not write to file");
        }
    }


    public String printHeader() {

        String val = "Start Transaction;\n" +
                "\n" +
                "Drop Table If Exists "+tableName.substring(0, tableName.length() - 4)+";\n" +
                "\n" +
                "Create Table "+tableName.substring(0, tableName.length() - 4)+"(\n" +
                "\n" +
                "    database_id serial,\n" +
                "    aic_id varchar(15),\n" +
                "    title varchar(2500), \n" +
                "    main_reference_number varchar(2500), \n" +
                "    department_title varchar(2500), \n" +
                "    artist_title varchar(2500) \n" +
                "\n" +
                ");";
        return val;
    }
}
