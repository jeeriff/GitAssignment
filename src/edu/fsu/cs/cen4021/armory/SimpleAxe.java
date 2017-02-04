package edu.fsu.cs.cen4021.armory;

/**
 * Created by msharrison on 2/2/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 * Simple Axe class implementation
 * Base damage: 60
 * Armor behavior:
 * Ignores all armor if armor points are between 0 and 20.
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 */

class SimpleAxe extends BasicWeapon implements Weapon {

    SimpleAxe() {
        super(60);
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    //Armor behavior:
    //Ignores all armor if armor points are between 0 and 20
    public int hit(int armor) {
        if(armor > 0 && armor < 20)
            armor = 0;
        int damage = DAMAGE - armor;
        if (damage < 0)
            return 0;
        return damage;
    }

}