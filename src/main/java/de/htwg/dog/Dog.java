/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.htwg.dog;

import de.htwg.dog.Controller.Controller;
import de.htwg.dog.Model.impl.Game;
import de.htwg.dog.View.Gui.Gui;
import de.htwg.dog.View.Tui.Tui;
import java.util.Scanner;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author kev
 */
public class Dog {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set up logging through log4j
        PropertyConfigurator.configure("log4j.properties");
                
        Game model = new Game();
        Controller cont = new Controller(model);
        Gui gui = new Gui(cont, model);
        gui.repaint();
        Tui tui = new Tui(cont, model);
        cont.StartGame();
        
        boolean continu = true;
        Scanner scanner = new Scanner(System.in);
        while (continu) {
           continu = tui.ProcessInput(scanner.next());
        } 
    }
    
}
