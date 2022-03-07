package mainpackage;

public class Nodo {
    
    private Object valor;
    private Nodo next=null;

    public Nodo(Object value) {
        this.valor = value;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
