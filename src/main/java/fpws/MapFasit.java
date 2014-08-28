package fpws;

import fj.Monoid;
import fj.data.List;

import static fpws.FunksjonsFasit.strLength;

public class MapFasit {

    //Map brukes for å endre innholdet i en container type

    //La oss prøve med String, og se om vi kan gjøre litt av de samme operasjonen
    public static final List<String> strings = List.list( "This", "is", "a", "list", "of", "String", "s" );

    //Transformer listen over strenger om til en liste der hvert element er lengden på strengen
    public static final List<Integer> lengths = strings.map(strLength);

    //Vi kan bruke closure-syntax for enkelhets skyld:
    public static final List<Integer> lengths2 = strings.map(s -> s.length());

    //Vi kan også referere til metoden direkte fra klassen ved å bruke ::
    public static final List<Integer> lengths3 = strings.map(String::length);

    //Legg sammen alle strengene i listen.
    //Finn summen av lengden av stringene i listen på to måter.

    public static final Integer listStringLength1 = strings.foldLeft( Monoid.stringMonoid.sum(),Monoid.stringMonoid.zero() ).length();
    public static final Integer listStringLength2 = strings.map(strLength).foldLeft( Monoid.intAdditionMonoid.sum(),Monoid.intAdditionMonoid.zero() );

    //Alle typer med funksjonen map() kalles funktorer.
    //Vi ser nå at vi kan definere typer utifra egenskapene dens i tillegg til den semantiske betydningen.

    //Pause
}
