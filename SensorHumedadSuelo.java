package AgroTech;

import java.util.concurrent.ThreadLocalRandom;

public class SensorHumedadSuelo extends Sensor {
    
    private double humedadPct;

    public SensorHumedadSuelo(String id, String ubicacion, boolean activo, double humedadPct) {
        super(id, ubicacion, activo);
        this.humedadPct = 0.0;
    }

    @Override
    public double tomarLectura() {
        if (!isActivo()) {
            return 0.0;
        }
        this.humedadPct = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
        return this.humedadPct;
    }

    @Override
    public String evaluarEstado() {
        if (!isActivo())
            return "Sensor Desactivado";
        
        if (humedadPct < 30.0) {
            return "ALERTA: Suelo muy seco (Necesita riego)";
        } else if (humedadPct > 80.0) {
            return "ALERTA: Suelo saturado de agua";
        }
        return "NORMAL: Humedad óptima";
    }

    public double getHumedadPct() {
        return humedadPct;
    }
}
