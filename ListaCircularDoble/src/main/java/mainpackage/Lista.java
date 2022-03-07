package mainpackage;

public class Lista {

    Nodo head = null;
    int counter = 0;

    public Lista(){}
    
    public Lista(Object o) {
        Nodo n = new Nodo(o);
        head = n;
        head.setNext(n);
        head.setPrev(n);
        
        counter++;
    }

    public boolean add(Object o) {
        try {
            Nodo n = new Nodo(o);
            if (head == null) {
                head = n;
                head.setNext(n);
                head.setPrev(n);

            } else {
                head.getPrev().setNext(n);
                n.setPrev(head.getPrev());
                n.setNext(head);
                head.setPrev(n);
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
                Nodo o = new Nodo(object);
                o.setNext(n.getNext());
                n.getNext().setNext(o);
                n.setNext(o);
                o.setNext(n);
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

            this.add(head.getPrev(),object);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addLast(Object object) {
        return this.add(object);
    }

    public void clear() {
        head = null;
        counter = 0;
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
        for (int i = counter; i >= 1; i--) {
            if (n == node) {
                return n.getPrev();
            }
            n = n.getPrev();

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
        return head.getPrev().getValor();
    }

    public boolean remove(Object object) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n.getValor() == object) {
                n.getPrev().setNext(n.getNext());
                n.getNext().setPrev(n.getPrev());
                counter--;
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public boolean remove(Nodo node) {
        Nodo n = head;
        for (int i = counter; i >= 1; i--) {
            if (n == node) {
                n.getNext().setPrev(n.getPrev());
                n.getPrev().setNext(n.getNext());
                counter--;
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public boolean removeAll(Object[] objects) {
        try {
            for (Object o : objects) {
                Nodo n = head;
                for (int i = counter; i >= 1; i--) {
                    if (n.getValor() == o) {
                        n.getNext().setPrev(n.getPrev());
                        n.getPrev().setNext(n.getNext());
                        counter--;
                    }
                    n = n.getNext();
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean retainAll(Object[] objects) {
        try {
            Nodo n = head;
            for (int i = counter; i >= 1; i--) {

                for (Object o : objects) {
                    if (n.getValor() != o)
                    {
                    	this.remove(n);
                    }
                n = n.getNext();
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
        to.setNext(l.head);
        to.setPrev(from);
        from.setPrev(to);
        return l;
    }

}
