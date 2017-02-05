/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsu.cs.cen4021.armory;

/**
 * @author Javier
 * New classes implement by:
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 */
public class WeaponFactory {

    public static Weapon getWeapon(String type) {
        switch (type) {
            case "sword":
                return new Sword();
            case "simplearrow":
                return new SimpleArrow();
            case "simpleaxe":
                return new SimpleAxe();
            case "simplemagicstaff":
                return new SimpleMagicStaff();
            case "chosenoneaxe":
                return new TheChosenOneAxe();
            case "ancientstaff":
                return new AncientMagicStaff();
            case "webritualarrow":
                return new WebRitualArrow();
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

}
