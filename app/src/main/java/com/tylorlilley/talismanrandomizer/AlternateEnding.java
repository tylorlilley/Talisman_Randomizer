package com.tylorlilley.talismanrandomizer;

/**
 * Created by Tylor on 10/17/2016.
 * Updated on 9/8/2018
 */
public class AlternateEnding {

    private String name;
    private boolean revealed;
    private boolean hidden;
    private int expansion;

    public AlternateEnding(String givenName, boolean isRevealed, boolean isHidden, int expansionNumber) {
        name = givenName;
        revealed = isRevealed;
        hidden = isHidden;
        expansion = expansionNumber;
    }

    public AlternateEnding(String fromString) {
        String[] splitString = fromString.split(":");
        name = splitString[0];
        revealed = Boolean.parseBoolean(splitString[1]);
        hidden = Boolean.parseBoolean(splitString[2]);
        expansion = Integer.parseInt(splitString[3]);
    }

    public String getName() { return name; }
    public int getExpansion() { return expansion; }
    public boolean includeInHidden() { return !revealed; }
    public boolean includeInRevealed() { return !hidden; }

    @Override
    public String toString() {
        return (name+':'+Boolean.toString(revealed)+':'+Boolean.toString(hidden)+':'+Integer.toString(expansion));
    }

}
