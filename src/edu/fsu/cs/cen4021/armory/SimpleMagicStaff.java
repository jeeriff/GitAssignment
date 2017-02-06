package edu.fsu.cs.cen4021.armory;

/**
 * Created by msharrison on 2/2/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 * Simple Magic Staff class implementation
 * Base damage: 80
 * Armor behavior:
 * Ignores 20% of total armor points (rounded down to the nearest point).
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 */

class SimpleMagicStaff extends BasicWeapon implements Weapon {
    //Constructor
    SimpleMagicStaff() {
        super(80);
    }

    @Override
    //Hit with no armor
    public int hit() {
        return DAMAGE;
    }

    @Override
    //Hit with armor
    //Armor behavior:
    //Ignores 20% of total armor points (rounded down to the nearest point)
    public int hit(int armor) {
        double armorDouble = armor;
        armorDouble = armorDouble * 0.8;
        armor = (int) armorDouble;
        int damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
