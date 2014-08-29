package fpws;

import fj.data.List;
import fj.test.Property;
import fpws.fasit.FunksjonerFasit;

import static fj.Function.curry;
import static fj.test.Arbitrary.arbInteger;
import static fj.test.Arbitrary.arbString;
import static fj.test.Property.prop;
import static fj.test.Property.property;

public class FunksjonerTest {

    public static List<Task> tasks() {

        return List.list(
                Task.testFunc1( "negate", arbInteger, FunksjonerFasit.negate, (Integer number) -> -number ),
                Task.testFunc2( "plus", arbInteger, arbInteger, curry( FunksjonerFasit.plus ), (Integer n1, Integer n2) -> n1 + n2 ),
                Task.testFunc( "minus", property( arbInteger, arbInteger, (n1, n2) ->
                                prop( FunksjonerFasit.minus.f( n1, n2 ) == n1 - n2 )
                ) ),
                Task.testFunc( "plusC", property( arbInteger, arbInteger, (n1, n2) ->
                                prop( FunksjonerFasit.plusC.f( n1 ).f( n2 ) == n1 + n2 )
                ) ),
                Task.testFunc( "strLength", Property.property( arbString, (str) ->
                                prop( FunksjonerFasit.strLength.f( str ) == str.length() )
                ) )
        );


    }


}
