package fpws;

import fj.Effect;
import fj.F;
import fj.F2;
import fj.Show;
import fj.data.List;
import fj.test.Arbitrary;
import fj.test.CheckResult;
import fj.test.Property;

public interface Task {

    public static <A> Task writeValue(String name, A value, Show<A> show) {
        return () -> {
            if (value == null)
                printNI( name );
            else
                printTest( name, show.showS( value ) );
        };
    }

    public static <A, B> Task testFunc1(String name, Arbitrary<A> arb, F<A, B> func, F<A, B> property) {
        return () -> {
            if (func == null)
                printNI( name );
            else
                testFunc( name, Property.property( arb, (value) ->
                                Property.prop( func.f( value ) == property.f( value ) )
                ) );
        };
    }

    public static <A, B, C> Task testFunc2(String name, Arbitrary<A> arb1, Arbitrary<B> arb2, F<A, F<B, C>> func, F2<A, B, C> property) {
        return () -> {
            if (func == null)
                printNI( name );
            else
                testFunc( name, Property.property( arb1,arb2, (val1,val2) ->
                                Property.prop( func.f( val1 ).f( val2 ) == property.f( val1,val2 ) )
                ) );
        };
    }

    public static Task testFunc(String name, Property property) {
        return () -> {
            CheckResult result = property.check();
            printTest( name, CheckResult.summary( CheckResults.argReflectionShow() ).showS( result ) );
        };
    }


    public abstract void check();

    static void printTest(String name, String result) {
        System.out.println( " * " + name + " : " + result );
    }

    static void printNI(String name) {
        System.out.println( " * " + name + " : Not implemented..." );
    }

    public static Task sequence(List<Task> tasks) {
        return () ->
                tasks.foreach( new Effect<Task>() {
                    @Override public void e(Task task) {
                        task.check();
                    }
                } );
    }


}
