package modelo;

public class ProductoFactory {
    private static ProductoFactory generador;
    private int serie;
    private ProductoFactory(int serie){
        this.serie = serie;
    }

    public static ProductoFactory obtenerGen(){
        if (generador == null){
            generador = new ProductoFactory(0);
        }
        return generador;
    }

    private void incrementar(){
        serie++;
    }

    CocaCola generarCocaCola(){
        incrementar();
        return new CocaCola(serie);
    }

    Fanta generarFanta(){
        incrementar();
        return new Fanta(serie);
    }

    Sprite generarSprite(){
        incrementar();
        return new Sprite(serie);
    }

    Super8 generarSuper8(){
        incrementar();
        return new Super8(serie);
    }

    Snickers generarSnickers(){
        serie += 1;
        return new Snickers(serie);
    }
}
