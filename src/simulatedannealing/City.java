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

import java.util.logging.Logger;

/**
 *
 * @author lllyu
 */
public class City {
    private int x;
    private int y;
    
    public City(){
        this.x = (int)(Math.random()*100);
        this.y = (int)(Math.random()*100);
    }
    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double distanceTo(City other){
        int xDistance = Math.abs(getX()-other.getX());
        int yDistance = Math.abs(getY()-other.getY());
        return Math.sqrt(xDistance*xDistance+yDistance*yDistance);
    }
    @Override
    public String toString() {
        return "City{" + "x=" + x + ", y=" + y + '}';
    }
}
