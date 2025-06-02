package modelo;

public class ProductoFactory {
    static ProductoFactory generador = new ProductoFactory();
    private int serie = 0;
    private ProductoFactory(){}

    CocaCola generarCocaCola(){
        serie += 1;
        return new CocaCola(serie);
    }

    Fanta generarFanta(){
        serie += 1;
        return new Fanta(serie);
    }

    Sprite generarSprite(){
        serie += 1;
        return new Sprite(serie);
    }

    Super8 generarSuper8(){
        serie += 1;
        return new Super8(serie);
    }

    Snickers generarSnickers(){
        serie += 1;
        return new Snickers(serie);
    }
}
