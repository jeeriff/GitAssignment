package edu.fsu.cs.cen4021.armory;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by msharrison on 2/4/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 *
 * The Ancient Magic Staff class implementation
 * Base damage: Determined by deserializing and manipulating ancientstaff.obj object
 * Armor behavior:
 * Ignores 25% of total armor points (rounded down to the nearest point).
 *
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 *
 * Format for object deserialization and manipulation was derived from:
 * http://crunchify.com/how-to-serialize-deserialize-list-of-objects-in-java-java-serialization-example/
 * http://stackoverflow.com/questions/4313457/java-arraylist-index
 * http://stackoverflow.com/questions/10766492/what-is-the-simplest-way-to-reverse-an-arraylist
 */

class AncientMagicStaff extends BasicWeapon implements Weapon {
    int DeserializeStaff() {
        ArrayList<Integer> list;
        int finalDamage = 0;
        try {
            int index;
            String fileName = "conf/ancientstaff.obj";
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            //Store list from object file
            list = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
            //Square every element in list
            for(int i = 0; i != list.size(); ++i) {
                index = list.get(i);
                index = index * index;
                list.set(i, index);
            }
            //Remove the second and fifth elements
            list.remove(1);
            list.remove(3);
            //Reverse the order of the list
            Collections.reverse(list);
            //The final damage number is the sum of the first, third, and seventh elements
            finalDamage = list.get(0) + list.get(2) + list.get(6);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return finalDamage;
    }
    int staffDamage = DeserializeStaff();
    AncientMagicStaff() {
        super(0);
    }

    @Override
    public int hit() {
        return staffDamage;
    }

    @Override
    //Armor behavior:
    //Ignores 25% of total armor points (rounded down to the nearest point)
    public int hit(int armor) {
        double armorDouble = armor;
        armorDouble = armorDouble * 0.75;
        armor = (int) armorDouble;
        int damage = staffDamage - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}