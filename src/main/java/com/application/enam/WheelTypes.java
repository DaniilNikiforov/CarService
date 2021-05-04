package com.application.enam;

public enum WheelTypes {
    WINTER(false),
    SUMMER(true),
    ROADLESS(false),
    SPORTS(true);

    private final boolean isForFastDriving;

    private WheelTypes(final boolean isForFastDriving) {
        this.isForFastDriving = isForFastDriving;
    }

    public boolean isForFastDriving() {
        return this.isForFastDriving;
    }

}
