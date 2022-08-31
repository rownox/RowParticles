package me.rownox.rowparticles;

public enum Presets {
    WAVE(2, 0.5, 20, 2),
    BALL(5, 0.6, 10, 5);
    private final double AMPLITUDE, RADIUS;
    private final int SATURATION, DURATION;

    Presets(final double AMPLITUDE, final double RADIUS, final int SATURATION, final int DURATION) {
        this.AMPLITUDE = AMPLITUDE;
        this.RADIUS = RADIUS;
        this.SATURATION = SATURATION;
        this.DURATION = DURATION;
    }

    public double getAmplitude() {
        return AMPLITUDE;
    }

    public double getRadius() {
        return RADIUS;
    }

    public int getSaturation() {
        return SATURATION;
    }

    public int getDuration() {
        return DURATION;
    }
}
