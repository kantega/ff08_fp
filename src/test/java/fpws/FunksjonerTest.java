package fpws;

import fj.data.List;
import fj.test.Property;

import static fj.test.Arbitrary.arbInteger;
import static fj.test.Arbitrary.arbString;
import static fj.test.Property.prop;
import static fj.test.Property.property;
import static fpws.TasksChecker.currySafe;

public class FunksjonerTest {

    public static List<Task> tasks() {

        return List.list(
                Task.heading( "Funksjoner" ),
                Task.testFunc1( "negate", arbInteger, FunksjonOppgaver.negate, (Integer number) -> -number ),
                Task.testFunc2( "plus", arbInteger, arbInteger, currySafe( FunksjonOppgaver.plus ), (Integer n1, Integer n2) -> n1 + n2 ),
                Task.testFunc( "minus", FunksjonOppgaver.minus,property( arbInteger, arbInteger, (n1, n2) ->
                                prop( FunksjonOppgaver.minus.f( n1, n2 ) == n1 - n2 )
                ) ),
                Task.testFunc( "plusC",FunksjonOppgaver.plusC, property( arbInteger, arbInteger, (n1, n2) ->
                                prop( FunksjonOppgaver.plusC.f( n1 ).f( n2 ) == n1 + n2 )
                ) ),
                Task.testFunc( "strLength",FunksjonOppgaver.strLength, Property.property( arbString, (str) ->
                                prop( FunksjonOppgaver.strLength.f( str ) == str.length() )
                ) )
        );


    }




}
