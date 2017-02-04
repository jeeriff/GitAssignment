package edu.fsu.cs.cen4021.armory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by msharrison on 2/3/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 * The Chosen One Axe class implementation
 * Base damage: Determined by reading thechosenone.txt file
 * Armor behavior:
 * Ignores all armor if armor points are between 0 and 20.
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 */

class TheChosenOneAxe extends BasicWeapon implements Weapon {

    int GetDamage () {
        String fileName = "conf/thechosenone.txt";
        String firstLine = "";
        String currentLine;
        String lastLine = "";
        int index = 1;
        int damageFound = 0;
        int damageNumber = 0;

        try (BufferedReader br = new BufferedReader((new FileReader(fileName)))) {
            while ((currentLine = br.readLine()) != null && damageFound == 0) {
                if(index < 4) {
                    if(index == 1)
                        firstLine = currentLine;
                    if(index == 2)
                        lastLine = currentLine;
                    if(index == 3) {
                        if(!(Objects.equals(lastLine, currentLine)) && Objects.equals(firstLine, currentLine)) {
                            damageNumber = 2;
                            damageFound = 1;
                        }
                        else if (!(Objects.equals(firstLine, lastLine)) && Objects.equals(lastLine, currentLine)) {
                            damageNumber = 1;
                            damageFound = 1;
                        }
                    }
                }
                else {
                    if (!(Objects.equals(currentLine, lastLine)) && index > 2) {
                        damageFound = 1;
                        damageNumber = index;
                    }
                    lastLine = currentLine;
                }
            ++index;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return damageNumber;
    }
    int axeDamage = GetDamage();
    TheChosenOneAxe() { super(0); }

    @Override
    public int hit() {
        return axeDamage;
    }

    @Override
    public int hit(int armor) {
        if(armor > 0 && armor < 20)
            armor = 0;
        int damage = axeDamage - armor;
        if (damage < 0)
            return 0;
        return damage;
    }
}