package AgroTech;

public abstract class Sensor {
 
    private final String id;
    private String ubicacion;
    private volatile boolean activo;

    public Sensor(String id, String ubicacion, boolean activo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    public abstract double tomarLectura();

    public abstract String evaluarEstado();
    
    public String getId() {
        return id;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void reubicarSensor(String nuevaUbicacion) {
        if (!this.activo) {
            this.ubicacion = nuevaUbicacion;
            System.out.println("Sensor reubicado con éxito a: " + nuevaUbicacion);
        } else {
            System.out.println("No se puede mover un sensor mientras está activo.");
        }
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo; }
}
