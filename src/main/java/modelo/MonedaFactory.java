package modelo;

public class MonedaFactory {
    private static MonedaFactory generador;
    int serie;

    private MonedaFactory(int serie){
        this.serie = serie;
    }

    public static MonedaFactory obtenerGen(){
        if (generador == null){
            generador = new MonedaFactory(0);
        }
        return generador;
    }
    public Moneda100 generarMoneda100(){
        serie++;
        return new Moneda100(serie);
    }
    public Moneda500 generarMoneda500(){
        serie++;
        return new Moneda500(serie);
    }
    public Moneda1000 generarMoneda1000(){
        serie++;
        return new Moneda1000(serie);
    }
}
