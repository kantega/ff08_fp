package fpws.fasit;

import fj.F;
import fj.Ord;
import fj.data.Option;
import fj.data.TreeMap;

public class FlatMapFasit {


    //Lag en funksjon som parser en String til en Integer. Den skal returnere Some dersom parsingen var mulig
    //og None ellers

    public static final F<String, Option<Integer>> parseInt =
            (str) -> {
                try {
                    return Option.some( Integer.parseInt( str ) );

                } catch (Exception e) {
                    return Option.none();
                }
            };


    public static final Option<String> maybeNumber1 = Option.some( "1234" );

    public static final Option<String> maybeNumber2 = Option.some( "1234b" );


    //Bruk map for å parse strengene
    public static final Option<Option<Integer>> maybeMaybeNumber1 = maybeNumber1.map( parseInt );

    public static final Option<Option<Integer>> maybeMaybeNumber2 = maybeNumber2.map( parseInt );


    //Det finnes en funksjon join som slår sammen de ytterste lagene av Option
    public static final Option<Integer> maybeMaybeNumber1Flattened1 = Option.join( maybeMaybeNumber1 );

    public static final Option<Integer> maybeMaybeNumber1Flattened2 = Option.join( maybeMaybeNumber2 );

    //Det finnes en funksjon bind ligner veldig på map, med en viktig forskjell: funksjonen man putter inn
    //returnerer en kontainer av samme type. Det er først en map, og så en join

    //Join kalles ofte flatten, derfor kalles bind ofte for flatMap

    //Parse innholdet i strengene vha bind
    public static final Option<Integer> maybeLength1 = maybeNumber1.bind( parseInt );

    public static final Option<Integer> maybeLength2 = maybeNumber2.bind( parseInt );


    /*
    Hvorfor denne navneforvirringen? Hvorfor bruker fj når java 8 har funksjonelle interface?

    fj følger i større grad konvesjoner som brukes i litteraturen, og de kan vøre lurt å lære
    seg disse først som sist. Java har en kvasitilnærming, der man vil gjøre ting litt funksjonellt.
    Fordelen med java sin tilmærming er at det kan være enklere å følge når man tenker objektorientert,
    men det gjør det vanskeligere å anvende andre informasjonskilder.

    Dessuten er java litt sleppehndt med spesifikasjoner/lover, noe som er et viktig hjelpemiddel for å unngå bugs.

     */


    //Når får man egentlig en Option<String>?
    //fra et Map objekt.

    public static final TreeMap<String, String> treeMap =
            TreeMap
                    .<String,String>empty( Ord.stringOrd ) //Vi ser her bruken av en typeklasse Ord, som brukes til å sortere
                    .set( "first", "1234" )
                    .set( "second", "1234b" );


    //Siden vi ikke kan (og vil) bruke null returnerer get en option
    public static final Option<String> maybeNumber3 = treeMap.get("first");


}
