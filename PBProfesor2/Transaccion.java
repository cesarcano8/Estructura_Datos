package PBProfesor2;

public class Transaccion {
    private Object objeto;
    private String tipo;
    private String operacion;

    public Transaccion(Object objeto, String tipo ,String operacion){
        this.objeto = objeto;
        this.operacion=operacion;
        this.tipo = tipo;
    }
    
    public String getOperacion() {
        return operacion;
    }
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    public Object getObjeto() {
        return objeto;
    }
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
        public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
