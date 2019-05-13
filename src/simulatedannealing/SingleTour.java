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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lllyu
 */
public class SingleTour {
    private List<City> tour = new ArrayList<>();
    private double distance = 0;
    public SingleTour(){
        for(int i =0;i<Repository.getNumberOfCities();++i){
            tour.add(null);
        }
    }
    
    public SingleTour(List<City> tour){
        List<City> curentTour = new ArrayList<>();
        for(int i =0;i<tour.size();++i){
            curentTour.add(tour.get(i));
        }       
        
        this.tour = curentTour;
    }
    
    public double getDistance(){
        if(distance == 0){
            int tourDist = 0;
            for(int cityIndex = 0;cityIndex<getTourSize();++cityIndex){
                City fromCity= getCity(cityIndex);
                City destCity;
                //check if next city is the starting city
                if(cityIndex+1<getTourSize()){
                    destCity = getCity(cityIndex+1);
                }else{
                    destCity = getCity(0);
                }
                
                tourDist += fromCity.distanceTo(destCity);
            }
            this.distance = tourDist;
        }
        
        return distance;
    }
    public List<City> getTour() {
        return tour;
    }

    public void generateIndividual(){
        for(int cityIndex =0; cityIndex<Repository.getNumberOfCities(); ++cityIndex){
            setCity(cityIndex,Repository.getCity(cityIndex));
        }
        Collections.shuffle(tour);
    }

    public void setCity(int cityIndex, City city) {
        this.tour.set(cityIndex, city);
        this.distance = 0;
    }
    
    public City getCity(int tourPosition){
        return this.tour.get(tourPosition);
    }
    
    public int getTourSize(){
        return this.tour.size();
    }

    @Override
    public String toString() {
        String s = "";
        for(int i =0;i<getTourSize();++i){
            s+=getCity(i)+" -> ";
        }
        return s;
    }
    
}
