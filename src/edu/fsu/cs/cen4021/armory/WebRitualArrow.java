package edu.fsu.cs.cen4021.armory;
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.Objects;

/**
 * Created by msharrison on 2/4/17.
 * Matthew Harrison
 * FSUID:msh13d
 * CS Account: harrison
 * Web Ritual Arrow class implementation
 * Base damage:
 * Determined by reading a header element at the following website:
 * http://ww2.cs.fsu.edu/~escobara/courses/cen4021.html
 * Armor behavior:
 * Ignores 10 points of armor.
 *
 * Implementation format derived from style implemented by
 * Javier Avila in the Sword class.
 *
 * Format for parsing website was derived from:
 * https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
 */

class WebRitualArrow extends BasicWeapon implements Weapon {
    int GetDamage() {
        int finalDamage;
        try {
            URL html = new URL("http://ww2.cs.fsu.edu/~escobara/courses/cen4021.html");
            BufferedReader in = new BufferedReader(new InputStreamReader((html.openStream())));
            String inputLine;
            //While loop manually parses website, looking for <h1> tag, which is after <body>
            while ((inputLine = in.readLine()) != null) {
                if (Objects.equals("<body>", inputLine)) {
                    inputLine = in.readLine();
                    String parse = inputLine;
                    String dam;
                    dam = parse.substring(4, 8);
                    finalDamage = Integer.parseInt(dam);
                    return finalDamage;
                }
            }
            in.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return 0;
    }
    int arrowDamage = GetDamage();
    WebRitualArrow() { super(0); }

    @Override
    public int hit() {
        return arrowDamage;
    }

    @Override
    //Armor behavior:
    //Ignores 10 points of armor
    public int hit(int armor) {
        if(armor > 10)
            armor = armor - 10;
        else
            armor = 0;
        int damage = arrowDamage - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
