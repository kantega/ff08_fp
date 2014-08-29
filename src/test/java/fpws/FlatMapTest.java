package fpws;

import fj.Show;
import fj.data.List;
import fj.data.Option;
import fj.test.Arbitrary;
import fj.test.Property;

public class FlatMapTest {

    public static List<Task> tasks() {
        /*

    public static final F<String, Option<Integer>> parseInt =
            null;
    public static final Option<String> maybeNumber1 = Option.some( "1234" );
    public static final Option<String> maybeNumber2 = Option.some( "1234b" );
    public static final Option<Option<Integer>> maybeMaybeNumber1 = null;
    public static final Option<Option<Integer>> maybeMaybeNumber2 = null;
    public static final Option<Integer> maybeMaybeNumber1Flattened1 = null;
    public static final Option<Integer> maybeMaybeNumber1Flattened2 = null;
    public static final Option<Integer> maybeLength1 = null;
    public static final Option<Integer> maybeLength2 = null;


        public static final Option<String> maybeNumber3 = null;
         */
        return List.list(
                Task.heading( "Flatmap" ),
                Task.testFunc(
                        "parseInt",
                        FlatMapOppgaver.parseInt,
                        Property.property( Arbitrary.arbEither( Arbitrary.arbInteger, Arbitrary.arbString ), (either) ->
                                either.either(
                                        (num) -> Property.prop( FlatMapOppgaver.parseInt.f( String.valueOf( num ) ).equals( Option.some( num ) ) ),
                                        (str) -> Property.prop( FlatMapOppgaver.parseInt.f( String.valueOf( str ) ).equals( Option.none() ) ) ) )
                ),
                Task.assertValue( "maybeMaybeNumber1",FlatMapOppgaver.maybeMaybeNumber1,(mmn)->mmn.equals( Option.some(Option.some(1234)) ), Show.anyShow() ),
                Task.assertValue( "maybeMaybeNumber2",FlatMapOppgaver.maybeMaybeNumber2,(mmn)->mmn.equals( Option.some(Option.none()) ), Show.anyShow() ),
                Task.assertValue( "maybeMaybeNumber1Flattened1",FlatMapOppgaver.maybeMaybeNumber1Flattened1,(mmn)->mmn.equals( Option.some(1234) ), Show.anyShow() ),
                Task.assertValue( "maybeMaybeNumber1Flattened2",FlatMapOppgaver.maybeMaybeNumber1Flattened2,(mmn)->mmn.equals( Option.none() ), Show.anyShow() ),
                Task.assertValue( "maybeLength1",FlatMapOppgaver.maybeLength1,(mmn)->mmn.equals( Option.some(1234) ), Show.anyShow() ),
                Task.assertValue( "maybeLength2",FlatMapOppgaver.maybeLength2,(mmn)->mmn.equals( Option.none() ), Show.anyShow() )


        );


    }
}
