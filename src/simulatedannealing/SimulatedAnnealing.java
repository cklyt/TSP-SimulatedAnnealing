/*
 * Copyright 2019 lllyu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package simulatedannealing;

import java.util.Random;

/**
 *
 * @author lllyu
 */
public class SimulatedAnnealing {
    private SingleTour best;
    public void Simulation(){
        double temperature = 100;
        double coolingRate = 0.003;
        
        SingleTour currentSolution = new SingleTour();
        currentSolution.generateIndividual();
        
        System.out.println("Initial solution distance:"+currentSolution.getDistance());
        
        best = new SingleTour(currentSolution.getTour());
        
        while(temperature>1){
            SingleTour newSolution = new SingleTour(currentSolution.getTour());
            
            int randomIndex1 = (int)(newSolution.getTourSize()*Math.random());
            City city1 = newSolution.getCity(randomIndex1);
            int randomIndex2 = (int)(newSolution.getTourSize()*Math.random());
            City city2 = newSolution.getCity(randomIndex2);
            
            newSolution.setCity(randomIndex2, city1);
            newSolution.setCity(randomIndex1, city2);
            
            double currentEnergy = currentSolution.getDistance();
            double neighbourEnergy = newSolution.getDistance();
            if(acceptanceProbability(currentEnergy,neighbourEnergy,temperature)>Math.random()){
                currentSolution = new SingleTour(newSolution.getTour());
            }
            
            if(currentSolution.getDistance()<best.getDistance()){
                best = new SingleTour(currentSolution.getTour());
            }
            
            temperature *= 1- coolingRate;
        }
        
    }

    public SingleTour getBest() {
        return best;
    }
    
    private double acceptanceProbability(double currentEnergy, double neighbourEnergy, double temperature){
        if(neighbourEnergy<currentEnergy){
            return 1;
        }
        
        return Math.exp((currentEnergy-neighbourEnergy)/temperature);
    }
}
