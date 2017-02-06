package edu.fsu.cs.cen4021.armory;

/**
 * Created by msharrison on 2/2/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 * Simple Arrow class implementation
 * Base damage: 70
 * Armor behavior:
 * Ignores 5 points of armor.
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 */

class SimpleArrow extends BasicWeapon implements Weapon {
    //Constructor
    SimpleArrow() {
        super(70);
    }

    @Override
    //Hit with no armor
    public int hit() {
        return DAMAGE;
    }

    @Override
    //Hit with armor
    //Armor behavior:
    //Ignores 5 points of armor
    public int hit(int armor) {
        if(armor > 5)
            armor = armor - 5;
        else
            armor = 0;
        int damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}