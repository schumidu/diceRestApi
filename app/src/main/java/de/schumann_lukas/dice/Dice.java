package de.schumann_lukas.dice;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Dice {

    public int generateDiceValue(final int max) {
        return (int) (Math.random()*max) +1;
    }
    
}
