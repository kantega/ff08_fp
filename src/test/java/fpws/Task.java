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

    public static Task heading(String name){
        return ()->
            System.out.println("---- "+name+" ----");

    }

    public static <A> Task assertValue(String name, A value, F<A,Boolean> predicate, Show<A> show){
        return () -> {
            if(value==null)
                printNI( name );
            else if(predicate.f(value))
                printTest( name,"The value "+show.showS( value )+" is correct" );
            else
                printTest(name,"The value "+show.showS( value )+" is not correct");
        };
    }

    public static <A> Task writeValue(String name, A value, Show<A> show) {
        return () -> {
            if (value == null)
                printNI( name );
            else
                printTest( name, show.showS( value ) );
        };
    }

    public static <A, B> Task testFunc1(String name, Arbitrary<A> arb, F<A, B> func, F<A, B> property) {
        return () ->
                testFunc( name, func, Property.property( arb, (value) ->
                                Property.prop( func.f( value ).equals( property.f( value ) ) )
                ) ).check();

    }

    public static <A, B, C> Task testFunc2(String name, Arbitrary<A> arb1, Arbitrary<B> arb2, F<A, F<B, C>> func, F2<A, B, C> property) {
        return () ->
                testFunc( name, func, Property.property( arb1, arb2, (val1, val2) ->
                                Property.prop( func.f( val1 ).f( val2 ).equals( property.f( val1, val2 ) ) )
                ) ).check();

    }

    public static Task testFunc(String name, Object func, Property property) {
        return () -> {
            if (func == null)
                printNI( name );
            else {
                CheckResult result = property.check();
                printTest( name, CheckResult.summary( CheckResults.argReflectionShow() ).showS( result ) );
            }
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
