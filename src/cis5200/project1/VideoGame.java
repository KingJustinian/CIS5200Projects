/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis5200.project1;

import java.util.ArrayList;
import java.util.List;

public abstract class VideoGame {
    final private String name;
    
    public VideoGame(String name)
    {
        this.name = name;
    }
    
    public String getName() { return name; };
    
    public abstract void cleanGame();
}
