package edu.fsu.cs.cen4021;

import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

/**
 * @author Javier
 */
public class RoleGame {

    public static void main(String[] args) {
        //Sword test - implemented by default
        Weapon sword = WeaponFactory.getWeapon("sword");
        System.out.println("Sword has " + sword.hit() + " of damage.");
        int armor = 20;
        System.out.println("Swords was able to do " + sword.hit(armor) + " of damage due to an armor with " + armor + " points.");

        //SimpleArrow test
        Weapon arrow = WeaponFactory.getWeapon("simplearrow");
        armor = 15;
        System.out.println("SimpleArrow was able to do " + arrow.hit(armor) +
                " of damage due to an armor with " + armor + " points.");
        //TODO: Add the remaining weapons here

    }
}
