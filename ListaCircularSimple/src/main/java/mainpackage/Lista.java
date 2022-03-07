package mainpackage;

public class Lista {

    Nodo head = null;
    
    int counter;
    

    public Lista() {
    }

    public Lista(Object o) {
        Nodo n = new Nodo(o);
        head = n;
        counter++;
    }

    public boolean add(Object object) {
        try {
            Nodo n = new Nodo(object);
            if (head == null) {
                head = n;
                head.setNext(n);                                     
            }             
            else {
                n.setNext(head.getNext());
                head.setNext(n);
                head = n;
            }
            
            counter++;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean add(Nodo node, Object object) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n == null) {
                return false;
            }
            if (n == node) {
                         
            Nodo n1 = new Nodo(object);
                n1.setNext(n.getNext());
                n.setNext(n1);
                
                
            counter++;
                return true;
            } else {
                n = n.getNext();
            }
        }
        return false;

    }

    public boolean addAll(Object[] objects) {
        try {
            for (Object o : objects) {
                this.add(o);
                counter++;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addAll(Nodo node, Object[] objects) {
        try {
            Nodo n = head;
            for (int i = counter; i >= 1; i--) {
                if (n == null) {
                    return false;
                }
                if (n == node) {
                   
                    for (Object o : objects) {
                        this.add(n, o);
                        counter++;
                    }
                    break;
                } else {
                    n = n.getNext();
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public boolean addFirst(Object object) {
        try {

            this.add(object);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addLast(Object object) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (head == null) {
                head = n;
                head.setNext(n);                                     
            }
            if (n.getNext()==head){
                Nodo n1 = new Nodo(object);
                n.setNext(n1);
                n1.setNext(head);  
                return true;
            }
            else {
                n = n.getNext();
            }
            
            counter++;
        }
        return false;
                
    }

    public void clear() {
        head = null;
        counter = 0;
        System.out.println("Lista vacia");
    }

   
    public Lista clone() {
        return this;
    }

    public boolean contains(Object object) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n.getValor() == object) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public boolean containsAll(Object[] object) {
        boolean b = true;
        for (Object o : object) {
            Nodo n = head;
            boolean p = false;
            for (int i = counter; i >= 1; i--) {
                if (n.getValor() == o)
                {
                	p = true;
                }
                n = n.getNext();
            }
            if(!p)
            {
            	b = false;
            	break;
            }
        }
        return b;
    }

    public Nodo nodeOf(Object object) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n.getValor() == object) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    public boolean isEquals(Object object) {
        return this == object;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object get() {
        return head.getValor();
    }

    public Object get(Nodo node) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n == node) {
                return n.getValor();
            }
            n = n.getNext();

        }
        return null;
    }

    public Object getPrevious(Nodo node) {
        Nodo n = head;
        Nodo n1 = null;
        for (int i = counter; i >= 1; i--) {
            if (head == null) {
                return null;                                   
            }
            if (n == node){               
                return n1;               
            }
            else {
                n1 = n;
                n = n.getNext();              
            }
            
        }
        return null;       
    }

    public Object getNext(Nodo node) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n == node) {
                return n.getNext();
            }
            n = n.getNext();

        }
        return null;
    }

    public Object getFirst() {
        return head.getValor();
    }

    public Object getLast() {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (head == null) {
                return null;                                   
            }
            if (n.getNext()==head){               
                return n;
            }
            else {
                n = n.getNext();
            }
            
        }
        return null;
    }

    public boolean remove(Object object) {
        Nodo n = head;
        Nodo n1 = null;
        for (int i = counter; i >= 1; i--) {
            if (head == null) {
                return false;                                   
            }
            if (n.getValor() == object ){ 
                n1.setNext(n.getNext());
                return true;
            }
            else {
                n1 = n;
                n = n.getNext();              
            }           
        }
        return false;
    }

    public boolean remove(Nodo node) {
        Nodo n = head;
        Nodo n1 = null;
        for (int i = counter; i >= 1; i--) {
            if (head == null) {
                return false;                                   
            }
            if (n.getValor() == node ){ 
                n1.setNext(n.getNext());
                return true;
            }
            else {
                n1 = n;
                n = n.getNext();              
            }           
        }
        return false;
    }

    public boolean removeAll(Object[] objects) {
        try {
            for (Object o : objects) {
                this.remove(o);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean retainAll(Object[] objects) {
        try {
            for (int i = counter; i >= 1; i--) {
                boolean b = true;
                Nodo n = head;
                for (Object o : objects) {
                    if (n.getValor() == o){
                        b = false;
                    }
                }
                if (b){
                    remove(n);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean set(Nodo node, Object object) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n == node) {
                n.setValor(object);
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public Lista subList(Nodo from, Nodo to)
    {
    	
        Lista l = new Lista();
        l.head = from;
        Nodo n2 = from;
        for (int i = counter; i >= 1; i--) {
            if (n2 == to){
                n2.setNext(from);
            }
            n2 = n2.getNext();
        }          
        return l;
    }

}
