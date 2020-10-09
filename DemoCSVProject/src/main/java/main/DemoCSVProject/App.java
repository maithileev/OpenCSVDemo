package main.DemoCSVProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;


import main.DemoCSVProject.model.TaskModel;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        String fileName = "src/main/resources/DemoFile.csv";
        Path myPath = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {
        	HeaderColumnNameMappingStrategy<TaskModel> strategy
            = new HeaderColumnNameMappingStrategy<>();
    strategy.setType(TaskModel.class);
    CsvToBean<TaskModel> csvToBean = new CsvToBeanBuilder<TaskModel>(br)
            .withMappingStrategy(strategy)
            .withIgnoreLeadingWhiteSpace(true)
            .build();
    
    	System.out.println("Status \t\t| \t Priority \t | \t Deadline \t | \t Fixed Cost \t | \t Actual Hours");
     	List<TaskModel> tasks = csvToBean.parse();
     	
     	for(TaskModel task : tasks) {
     		System.out.println(task.getStatus() + "\t|\t" + task.getPriority() +"\t\t |\t" + task.getDeadline()+"\t\t |\t" +task.getFixedCost()+"\t\t |\t" +task.getActualHours());
     	}
     	System.out.println("Total Fixed Cost: "+TaskModel.getTotalFixedCost());
     	System.out.println("Total Actual Hours: "+TaskModel.getTotalActualHours());
     	
        }
    }
}
