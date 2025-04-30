package org.example;

public class Comprador {
    private final String sabor;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws PagoIncorrectoException,PagoInsuficienteException,NoHayProductoException{
        Producto p = exp.comprarProducto(m,cualProducto);
        sabor = p.sabor;
        vuelto = 0;
        Moneda tmp = exp.getVuelto();
        while(tmp != null){
            vuelto += tmp.getValor();
            tmp = exp.getVuelto();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queCompraste(){
        return sabor;
    }
}
