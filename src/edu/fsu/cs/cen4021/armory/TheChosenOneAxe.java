package edu.fsu.cs.cen4021.armory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by msharrison on 2/3/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 *
 * The Chosen One Axe class implementation
 * Base damage: Determined by reading thechosenone.txt file
 * Armor behavior:
 * Ignores all armor if armor points are between 0 and 20.
 *
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 *
 * Format for text file read was derived from:
 * http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
 * https://www.mkyong.com/java8/java-8-stream-read-a-file-line-by-line/
 */

class TheChosenOneAxe extends BasicWeapon implements Weapon {
    //Damage number is calculated in GetDamage()
    int axeDamage = GetDamage();

    //Constructor
    TheChosenOneAxe() { super(0); }

    @Override
    //Hit with no armor
    public int hit() {
        return axeDamage;
    }

    @Override
    //Hit with armor
    //Armor behavior:
    //Ignores all armor if armor points are between 0 and 20
    public int hit(int armor) {
        if(armor > 0 && armor < 20)
            armor = 0;
        int damage = axeDamage - armor;
        if (damage < 0)
            return 0;
        return damage;
    }

    /*
    GetDamage opens the file thechosenone.txt and parses it to determine
    the damage number for the weapon
    */
    int GetDamage () {
        String fileName = "conf/thechosenone.txt";
        String firstLine = "";
        String currentLine;
        String lastLine = "";
        int index = 1;
        int damageFound = 0;
        int damageNumber = 0;

        //File for armor calculation is opened
        try (BufferedReader br = new BufferedReader((new FileReader(fileName)))) {
            while ((currentLine = br.readLine()) != null && damageFound == 0) {
                if(index < 4) { //Special cases are required for the first 2 lines
                    if(index == 1)
                        firstLine = currentLine;
                    if(index == 2)
                        lastLine = currentLine;
                    if(index == 3) {
                        if(!(Objects.equals(lastLine, currentLine)) && Objects.equals(firstLine, currentLine)) {
                            damageNumber = 2;
                            damageFound = 1;
                        } //If lines 2 and 3 are different but 1 and 3 are the same, 2 is the damage number
                        else if (!(Objects.equals(firstLine, lastLine)) && Objects.equals(lastLine, currentLine)) {
                            damageNumber = 1;
                            damageFound = 1;
                        } //If lines 1 and 2 are different but 2 and 3 are the same, 1 is the damage number
                        else if (!(Objects.equals(firstLine, currentLine)) && Objects.equals(firstLine, lastLine)) {
                            damageNumber = 3;
                            damageFound = 1;
                        } //If lines 1 and 3 are different but 1 and 2 are the same, 3 is the damage number
                    }
                }
                else { //Beyond the first 3 lines, the search is simpler and more straightforward
                    if (!(Objects.equals(currentLine, lastLine)) && index > 3) {
                        damageFound = 1;
                        damageNumber = index;
                    }
                    lastLine = currentLine;
                }
                ++index;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return damageNumber;
    }
}

