package fpws.fasit;

import fj.F2;
import fj.Monoid;
import fj.data.List;

public class FoldFasit{


    //Fold er en fellesbetegnelse på å kollapse datastrakturer (også kalt katamorfisme)
    //På datastrukturer der det har betydning hvilken "ende" man starter har man foldLeft og foldRight.

    public static final List<Integer> ints = List.range( 10, 20 );

    //List.foldLeft1 er en metode som kollapser listen til en verdi med samme type som listens innhold.

    //Summer alle tall i listen
    //hint fj.List har en funksjon som heter foldLeft1
    public static final Integer sumOfList1 = ints.foldLeft1( FunksjonerFasit.plus );


    //Hva skjer når listen er bare ett element lang?
    public static final Integer sumOfList2 = ints.take( 1 ).foldLeft1( FunksjonerFasit.plus );

    //Går det an å bruke funksjonen minus i listen?
    //Hva blir evt. resultatet?

    //BØR vi bruke minus?

    //Det kan virke lurt at funksjonene vi reduserer med bør har en egenskap kjent fra matematikken, den må være assosiativ.
    //Vi setter opp en lov:
    //La sum være en funksjon (A,A) -> A
    // sum(sum(a,b),b) <=> sum(a, sum(b, c))
    // eks.: 1 + (2 + 3)) <=> ((1 + 2) + 3)


    //Hva skjer når det er ingen elementer i listen?
    //public final String noInts = List.<Integer>nil().foldLeft1( plus );

    //Vi ser at foldLeft1 har en svakhet. Den må ha ett element i listen for at vi kan redusere listen.
    //For at vi ikke skal få runtime feil må vi bruke funksjonalitet som ikke tillated dette.
    //Vi må derfor sørge for at vi har en startverdi (zero) før vi summerer verdiene i listen.
    //Denne startverdien må ha en spesiell egenskap: Dersom vi summerer starteverdien med en anne verdi,
    //får vi den andre verdien
    //
    //sum(a,zero) <=> sum(zero,a) <=> a



    //Aå, hvilket utgangspunkt bruker man for addisjon?
    public final Integer zero1 = 0;

    //Hvilken annen måte enn addisjon kan vi beregne tall der faktorenes orden er likegyldig?
    //Multiplikasjon
    public final F2<Integer,Integer,Integer> sum2 = (x,y) -> x*y;

    //Hvilket utgangspunkt brukes her?
    public final Integer zero2 = 1;

    //Bruk foldLeft med rett utgangspunkt og funksjon for addisjon for å få de samme resultatene
    //som over
    public Integer sumOfInts = ints.foldLeft( FunksjonerFasit.plus, zero1 );


    //Kombinasjonen med et utgangspunkt (zero) og en summerende (sum) funksjon kalles en Monoide
    //I fj finnes det mange definerte monoider, og man kan definere egne for vilkårlige typer.

    // Lovene for en monoide har vi satt opp:
    // 1) sum( zero , a) = sum( a, zero) = a
    // 2) sum ( a, sum(b, c)) = sum(sum(a,b(,c)

    //Definer zero og sum for string monoiden
    //Hvilket utgangspunkt bruker man for string concatenering?
    public final String zeroString = "";
    //Kan vi legge sammen to strenger?
    public static final F2<String, String, String> sumString = (one, other) -> one + other;

    //I functionaljava er en monoide definert med Monoid<A> klassen
    //Den inneholder en zero verdi og en sum funksjon
    public static final Monoid<String> strMonoid = Monoid.stringMonoid;


    //Definer zero og sum for List monoiden
    public static final <A> Monoid<List<A>> listMonoid(){
        return Monoid.monoid( (List<A> list1,List<A> list2)->list1.append( list2 ),List.<A>nil() );
    }




    //Diskusjon: Finnes det en monoid for Map?

    //Dersom vi har en fold metode på et objekt, kan vi uten å kjenne implementasjonen til typen transformere den til en annen type.

    //La oss fortsette med map
}
