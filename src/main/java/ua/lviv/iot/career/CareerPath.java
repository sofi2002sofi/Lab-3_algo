package ua.lviv.iot.career;

public class CareerPath {
    
    public int countOfLevels;
    
    public int[][] graph;
    
    public CareerPath(int countOfLevels, int[][] graph) {
        super();
        this.countOfLevels = countOfLevels;
        this.graph = graph;
    }

}
