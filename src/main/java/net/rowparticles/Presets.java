package net.rowparticles;

public class Presets {
    private String Name;
    private double Amplitude;
    private double Radius;
    private int Saturation;
    private int Duration;

    public Presets(String Name, double Amplitude, double Radius, int Saturation, int Duration) {
        this.Name = Name;
        this.Amplitude = Amplitude;
        this.Radius = Radius;
        this.Saturation = Saturation;
        this.Duration = Duration;
    }

    public String getName() {return Name;}
    public double getAmp() {return Amplitude;}
    public double getRad() {return Radius;}
    public int getSat() {return Saturation;}
    public int getDur() {return Duration;}
}
