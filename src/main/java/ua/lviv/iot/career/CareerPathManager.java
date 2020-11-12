package ua.lviv.iot.career;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CareerPathManager {
    
    public static void writeMaxSumOfExperince(String fileName, int maxSumOfExperince) {
        
        FileWriter csvWriter = null;
        try {
            
            csvWriter = new FileWriter(fileName);
            csvWriter.append(Integer.toString(maxSumOfExperince));
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            
            try {
               
                csvWriter.flush();
                csvWriter.close();
           
            } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
                
    }
    
    public static int readCountOfLevels(String fileName) {
        int countOfLevels = 0;
        Path pathToFile = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
        
            String line = br.readLine(); 
            countOfLevels = Integer.parseInt(line);
        
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return countOfLevels;
    }
    
    public static int[][] readGraph(String fileName){
        
        int[][] graph = null;
        int countOfLevels;
        
        Path pathToFile = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
            
            String line = br.readLine(); 
            countOfLevels = Integer.parseInt(line);
            graph = new int[countOfLevels][];
            line = br.readLine();
            int levelIndex = 0;
            
            while (line != null) { 
                graph[levelIndex] = new int [levelIndex + 1];
                String[] numbers = line.split(" ");
                
                for(int elementIndex = 0; elementIndex < (levelIndex + 1); elementIndex++) {
                    graph[levelIndex][elementIndex] = Integer.parseInt(numbers[elementIndex]);
                }
                
                levelIndex++;
                line = br.readLine(); 
            }
            
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return graph;
    }
    
    public static int countMaxSumOfExperince(CareerPath career) {
        
        for(int iteratorOfLevels = (career.countOfLevels - 2); iteratorOfLevels > -1; --iteratorOfLevels) {
            
            for(int iteratorOfElementsOnLevel = 0; iteratorOfElementsOnLevel < (iteratorOfLevels + 1); ++iteratorOfElementsOnLevel) {
                
                int leftSubordinateEmployeeExperience = career.graph[iteratorOfLevels+1][iteratorOfElementsOnLevel];
                int rightSubordinateEmployeeExperience = career.graph[iteratorOfLevels+1][iteratorOfElementsOnLevel+1];
                
                if (leftSubordinateEmployeeExperience > rightSubordinateEmployeeExperience) {
                    career.graph[iteratorOfLevels][iteratorOfElementsOnLevel] += leftSubordinateEmployeeExperience;
                } else {
                    career.graph[iteratorOfLevels][iteratorOfElementsOnLevel] += rightSubordinateEmployeeExperience;
                }
                
            }
        }
        
        int maxSumOfExperince = career.graph[0][0];
        
        return maxSumOfExperince;
    }

}
