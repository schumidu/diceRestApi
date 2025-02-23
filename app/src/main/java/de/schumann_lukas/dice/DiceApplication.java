package de.schumann_lukas.dice;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("dice")
public class DiceApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(
            ThrowDiceRes.class
        );
    }
        
}
