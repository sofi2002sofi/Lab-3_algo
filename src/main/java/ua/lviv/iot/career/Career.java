package ua.lviv.iot.career;

import java.io.IOException;

public class Career {
    
    public static void printGraph(int[][] graph) {
        for (int[] line : graph) {
            for(int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        int[][] graph = CareerPathManager.readGraph("input.csv");
        int countOfLevels = CareerPathManager.readCountOfLevels("input.csv");
        
        CareerPath career = new CareerPath(countOfLevels, graph);
        int maxSumOfExperince = CareerPathManager.countMaxSumOfExperince(career);
        
        CareerPathManager.writeMaxSumOfExperince("output.csv", maxSumOfExperince);
        
    }

}
