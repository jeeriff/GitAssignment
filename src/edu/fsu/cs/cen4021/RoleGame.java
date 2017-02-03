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

        //SimpleAxe test
        Weapon axe = WeaponFactory.getWeapon("simpleaxe");
        armor = 12;
        System.out.println("SimpleAxe was able to do " + axe.hit(armor) +
                " of damage due to an armor with " + armor + " points.");
        armor = 25;
        System.out.println("SimpleAxe was able to do " + axe.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //SimpleMagicStaff test
        Weapon staff = WeaponFactory.getWeapon("simplemagicstaff");
        armor = 35;
        System.out.println("SimpleMagicStaff was able to do " + staff.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //TODO: Add the remaining weapons here

    }
}
