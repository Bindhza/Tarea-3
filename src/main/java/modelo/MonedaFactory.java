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
    Moneda100 generarMoneda100(){
        serie++;
        return new Moneda100(serie);
    }
    Moneda500 generarMoneda500(){
        serie++;
        return new Moneda500(serie);
    }
    Moneda1000 generarMoneda1000(){
        serie++;
        return new Moneda1000(serie);
    }
}
