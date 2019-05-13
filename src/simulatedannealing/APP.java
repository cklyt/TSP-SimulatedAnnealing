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

/**
 *
 * @author lllyu
 */
public class APP {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            City city = new City();
            Repository.addCity(city);
        }
        SimulatedAnnealing annealing = new SimulatedAnnealing();
        annealing.Simulation();
        
        System.out.println("Final approximated solution's distance is: "+annealing.getBest().getDistance());
        System.out.println("Tour: "+annealing.getBest());
    }
}
