package fpws.fasit;

import fj.F;
import fj.F2;

public class FunksjonerFasit {
    // Desverre finnes det ingen egen type for funksjoner i java. Vi må representere funksjoner gjennom
    // funksjonelle interface, dvs si et interface som bare har en metode.
    //
    // Functionaljava bruker interfacet F til å representere en funksjon, slik at vi har måter å bearbeide funksjoner.
    //
    // F<A,B> er en funksjon som tar inn et argument av typen A, og som returnerer en verdi av typen B
    // Vi kaller den en funksjon fra A til B.
    //
    // Siden det er vanskelig å lese bruker vi en enklere notasjon i dokumentasjonen: A -> B
    // F2<A,B,C> er en funksjon som tar inn to argumenter, og kan skrives slik : (A, B) -> C

    //Lag en funksjon som endrer fortegn på en integer (negate: int -> int)
    public static final F<Integer, Integer> negate = (x) -> -x;

    //Lag en funksjon som legger sammen to tall
    public static final F2<Integer, Integer, Integer> plus = (x, y) -> x+y;

    //Lag en funksjon som trekker fra to tall
    public static final F2<Integer, Integer, Integer> minus = (x, y) -> x - y;


    //En funksjon med to parametere kan også skrives som en funksjon som tar inn ett parameter og gir en ny
    //funksjon. Dette kalles Currying (etter Haskell Curry), og gir deg mulighet til å
    //kalle ett argument om gangen
    // (A,B) -> C <=> A -> B -> C
    public static final F<Integer, F<Integer, Integer>> plusC = (x) -> (y) -> x + y;

    //Lag en funksjon som gir lengden på en string
    // Hint: Man kan referere til en metode i en klasse ved å bruke :: operatoren på en klasse.
    public static final F<String, Integer> strLength = String::length;


    //Vi fortsetter med fold

}
