package ua.lviv.iot.career;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CareerTest {
    
    int[][] careerPathOnFirstJob = {{4}, {3, 1}, {2, 1, 5}, {1, 3, 2, 1}};
    int[][] careerPathOnSecondJob = {{0}, {1, 1}, {0, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 1, 0}};
    int[][] careerPathOnThirdJob = {{0}, {5, 8}, {6, 1, 1}, {1, 8, 10, 3}, {1, 6, 2, 10, 0}, {9, 4, 7, 3, 3, 0}};
    int[][] careerPathOnForthJob = {{9999}};
    
    int countOfLevelsOnFirstJob = careerPathOnFirstJob.length;
    int countOfLevelsOnSecondJob = careerPathOnSecondJob.length;
    int countOfLevelsOnThirdJob = careerPathOnThirdJob.length;
    int countOfLevelsOnForthJob = careerPathOnForthJob.length;


    @Test
    public void testFirstJob() {
        int expectedMaxSumOfExperinceOnFirstJob = 12;
        
        CareerPath careerOnFirstJob = new CareerPath(countOfLevelsOnFirstJob, careerPathOnFirstJob);
        int maxSumOfExperinceOnFirstJob = CareerPathManager.countMaxSumOfExperince(careerOnFirstJob);
        
        assertEquals(expectedMaxSumOfExperinceOnFirstJob, maxSumOfExperinceOnFirstJob);
        
    }
    
    @Test
    public void testSecondJob() {
        int expectedMaxSumOfExperinceOnSecondJob = 3;
        
        CareerPath careerOnSecondJob = new CareerPath(countOfLevelsOnSecondJob, careerPathOnSecondJob);
        int maxSumOfExperinceOnSecondJob = CareerPathManager.countMaxSumOfExperince(careerOnSecondJob);
        
        assertEquals(expectedMaxSumOfExperinceOnSecondJob, maxSumOfExperinceOnSecondJob);
    }
    
    @Test
    public void testThirdJob() {
        int expectedMaxSumOfExperinceOnThirdJob = 32;
        
        CareerPath careerOnThirdJob = new CareerPath(countOfLevelsOnThirdJob, careerPathOnThirdJob);
        int maxSumOfExperinceOnThirdJob = CareerPathManager.countMaxSumOfExperince(careerOnThirdJob);
        
        assertEquals(expectedMaxSumOfExperinceOnThirdJob, maxSumOfExperinceOnThirdJob);
    }
    
    @Test
    public void testForthJob() {
        int expectedMaxSumOfExperinceOnForthJob = 9999;
        
        CareerPath careerOnForthJob = new CareerPath(countOfLevelsOnForthJob, careerPathOnForthJob);
        int maxSumOfExperinceOnForthJob = CareerPathManager.countMaxSumOfExperince(careerOnForthJob);
        
        assertEquals(expectedMaxSumOfExperinceOnForthJob, maxSumOfExperinceOnForthJob);
        
    }
}
