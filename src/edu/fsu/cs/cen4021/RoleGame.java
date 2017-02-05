package edu.fsu.cs.cen4021;

import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

/**
 * @author Javier
 * New classes implement by:
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
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
        System.out.println("SimpleArrow has " + arrow.hit() + " of damage.");
        armor = 20;
        System.out.println("SimpleArrow was able to do " + arrow.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //SimpleAxe test
        Weapon axe = WeaponFactory.getWeapon("simpleaxe");
        System.out.println("SimpleAxe has " + axe.hit() + " of damage.");
        armor = 20;
        System.out.println("SimpleAxe was able to do " + axe.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //SimpleMagicStaff test
        Weapon staff = WeaponFactory.getWeapon("simplemagicstaff");
        System.out.println("SimpleMagicStaff has " + staff.hit() + " of damage.");
        armor = 20;
        System.out.println("SimpleMagicStaff was able to do " + staff.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //TheChosenOneAxe test
        Weapon chosenAxe = WeaponFactory.getWeapon("chosenoneaxe");
        System.out.println("TheChosenOneAxe has " + chosenAxe.hit() + " of damage.");
        armor = 20;
        System.out.println("TheChosenOneAxe was able to do " + chosenAxe.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //AncientMagicStaff test
        Weapon ancientStaff = WeaponFactory.getWeapon("ancientstaff");
        System.out.println("AncientMagicStaff has " + ancientStaff.hit() + " of damage.");
        armor = 20;
        System.out.println("AncientMagicStaff was able to do " + ancientStaff.hit(armor) +
                " of damage due to an armor with " + armor + " points.");

        //WebRitualArrow test
        Weapon webArrow = WeaponFactory.getWeapon("webritualarrow");
        System.out.println("WebRitualArrow has " + webArrow.hit() + " of damage.");
        armor = 20;
        System.out.println("WebRitualArrow was able to do " + webArrow.hit(armor) +
                " of damage due to an armor with " + armor + " points.");
    }
}
