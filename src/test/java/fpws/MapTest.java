package fpws;

import fj.Monoid;
import fj.Show;
import fj.data.List;

public class MapTest {

    public static List<Task> tasks() {
        /*

    public static final List<Integer> lengths = null;
    public static final List<Integer> lengths2 = null;
    public static final List<Integer> lengths3 = null;
    public static final Integer listStringLength1 = null;
    public static final Integer listStringLength2 = null;
    public static final Option<String> maybeString = Option.some( "foo" );
    public static final Option<Integer> maybeLength = null;
         */
        return List.list(
                Task.heading( "Map" ),
                Task.assertValue( "lengths", MapOppgaver.lengths, (list) -> list.equals( MapOppgaver.strings.map( String::length ) ), Show.listShow( Show.intShow ) ),
                Task.assertValue( "lengths2", MapOppgaver.lengths2, (list) -> list.equals( MapOppgaver.strings.map( String::length ) ), Show.listShow( Show.intShow ) ),
                Task.assertValue( "lengths3", MapOppgaver.lengths3, (list) -> list.equals( MapOppgaver.strings.map( String::length ) ), Show.listShow( Show.intShow ) ),
                Task.assertValue( "listStringLength1", MapOppgaver.listStringLength1, (list) -> list.equals( MapOppgaver.strings.foldLeft( Monoid.stringMonoid.sum(), Monoid.stringMonoid.zero() ).length() ), Show.intShow ),
                Task.assertValue( "listStringLength2", MapOppgaver.listStringLength2, (list) -> list.equals( MapOppgaver.strings.foldLeft( Monoid.stringMonoid.sum(), Monoid.stringMonoid.zero() ).length() ), Show.intShow ),
                Task.assertValue("maybeLength",MapOppgaver.maybeLength,(opt)->opt.equals( MapOppgaver.maybeString.map(String::length) ),Show.optionShow( Show.intShow ))
        );
    }

}
