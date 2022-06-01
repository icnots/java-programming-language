class A{}

class B extends A{}
class C extends B{}


class Z{
    B myfunc(B b){
        System.out.println("I got a B");
        return b;
    }
}

class Y extends Z{
    // do not do this
    A myfunc(A b){
        System.out.println("I got a A");
        return b;
    }
}

/*
package-elés
extends, implements
toString / konstruktor paraméter ellenőrzéssel / exception dobással

equals+hashCode / compareTo (Comparable interface) / iterator (Iterator, Iterable használata) / fájl beolvasás/kiírás / abstract osztály
*/

