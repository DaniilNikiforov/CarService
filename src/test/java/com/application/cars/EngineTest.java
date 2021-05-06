package com.application.cars;

import org.junit.Before;
import org.junit.Test;

public class EngineTest {
    Engine engine;

    @Before
    public void setDefaultInitialization(){
        engine = new Engine();
    }

    @Test(expected = RuntimeException.class)
    public void setHorsepower_InvalidValue_RuntimeException() {
        engine.setHorsepower(0);
    }

    @Test(expected = RuntimeException.class)
    public void setMaxSpeed_InvalidValue_RuntimeException() {
        engine.setMaxSpeed(-5);
    }

    @Test(expected = RuntimeException.class)
    public void setNumberOfGears_InvalidValue_RuntimeException() {
        engine.setNumberOfGears(-1);
    }
}
