package com.tylorlilley.talismanrandomizer;

/**
 * Created by Tylor on 10/17/2016.
 * Updated on 9/8/2018
 */
public class Character {

    private String name;
    private int expansion;

    public Character(String givenName, int expansionNumber) {
        name = givenName;
        expansion = expansionNumber;
    }

    public Character(String fromString) {
        String[] splitString = fromString.split(":");
        name = splitString[0];
        expansion = Integer.parseInt(splitString[1]);
    }

    public String getName() { return name; }
    public int getExpansion() { return expansion; }

    @Override
    public String toString() {
        return (name+':'+Integer.toString(expansion));
    }
}
