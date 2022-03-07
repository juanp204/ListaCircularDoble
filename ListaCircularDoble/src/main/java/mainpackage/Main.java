package mainpackage;

public class Main {
	
	 public static void main(String[] args) {
	        Lista listadoblecircular = new Lista();
	        listadoblecircular.add(2);
	        listadoblecircular.add(3);
	        listadoblecircular.add(4);
	        listadoblecircular.add(6);
	        listadoblecircular.add(5);
	        listadoblecircular.add(4);
	        listadoblecircular.add(null);
	        listadoblecircular.add(8);
	        listadoblecircular.add(null);
	        listadoblecircular.add(listadoblecircular.head.getNext(), 9);
	        Nodo n = listadoblecircular.head;
	        for (int i = listadoblecircular.counter; i>=1; i--) {
	            System.out.println(n.getValor());
	            n=n.getNext();
	        }
	        
	        
	        System.out.println ("Si se debe incluir el elemento 100: " + listadoblecircular.contains(100));
	        System.out.println("------------------------");
	        
	        System.out.println ("El noveno elemento es: " + listadoblecircular.get(null));
	        System.out.println("------------------------");
	        
	        System.out.println("nodos: "+listadoblecircular.nodeOf(129));
	        System.out.println("------------------------");
	        
	        
	        System.out.println("se encontro el 5? : "+listadoblecircular.contains(5));
	        System.out.println("------------------------");
	        
	    }

}
