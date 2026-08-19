package AgroTech;

import java.util.concurrent.ThreadLocalRandom;

public class SensorTemperatura extends Sensor {
    
    private double celsius;

    public SensorTemperatura(String id, String ubicacion, boolean activo, double celsius) {
        super(id, ubicacion, activo);
        this.celsius = tomarLectura();
    }

    @Override
    public double tomarLectura() {
        if (!isActivo()) {
            return 0.0;
        }
        this.celsius = ThreadLocalRandom.current().nextDouble(15.0, 45.0);
        return this.celsius;
    }

    @Override
    public String evaluarEstado() {
        if (!isActivo())
            return "Sensor Desactivado";

        if (celsius > 35.0) {
            return "ALERTA: Temperatura crítica alta";
        } else if (celsius < 18.0) {
            return "ALERTA: Temperatura muy baja";
        }
        return "NORMAL: Temperatura estable";
    }

    public double getCelsius() {
        return celsius;
    }
    
}
