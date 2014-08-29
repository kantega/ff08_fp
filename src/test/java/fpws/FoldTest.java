package fpws;

import fj.*;
import fj.data.List;
import fj.test.Property;

import static fj.test.Arbitrary.arbInteger;
import static fj.test.Arbitrary.arbString;
import static fpws.TasksChecker.currySafe;

public class FoldTest {

    public static List<Task>  tasks(){
        /*
    public static final List<Integer> ints = null;
    public static final Integer sumOfList1 = null;

    public static final Integer sumOfList2 = null;
    public final Integer zero1 = null;
    public final F2<Integer,Integer,Integer> sum2 = null;
    public final Integer zero2 = null;
    public Integer sumOfInts = null;

    public final String zeroString = "";
    public static final F2<String, String, String> sumString = null;

    public static final Monoid<String> strMonoid = Monoid.stringMonoid;


    public static final <A> Monoid<List<A>> listMonoid(){
        return null;
    }
         */
        return List.list(
                Task.heading( "Fold" ),
                Task.writeValue( "ints",FoldOppgaver.ints, Show.listShow( Show.intShow ) ),
                Task.assertValue( "sumOfList1",FoldOppgaver.sumOfList1,(length)->FoldOppgaver.ints.foldLeft( Monoid.intAdditionMonoid.sum(),Monoid.intAdditionMonoid.zero() ).equals(length),Show.intShow ),
                Task.assertValue( "sumOfList2",FoldOppgaver.sumOfList2,(length)->FoldOppgaver.ints.foldLeft( Monoid.intAdditionMonoid.sum(),Monoid.intAdditionMonoid.zero() ).equals(length),Show.intShow ),
                Task.assertValue( "zero1",FoldOppgaver.zero1,(value)->value.equals( 0 ),Show.intShow ),
                Task.testFunc2( "sum2", arbInteger,arbInteger,currySafe(FoldOppgaver.sum2),(Integer x,Integer y)->x*y ),
                Task.assertValue( "zero1",FoldOppgaver.zero2,(value)->value.equals( 1 ),Show.intShow ),
                Task.assertValue( "sumOfInts",FoldOppgaver.sumOfInts,(value)->value.equals( FoldOppgaver.sumOfList1 ),Show.intShow ),
                Task.assertValue( "zeroString",FoldOppgaver.zeroString,(value)->value.equals( "" ),Show.stringShow ),
                Task.testFunc2( "sumString",arbString,arbString,currySafe(FoldOppgaver.sumString),(String one, String other)->one+other ),
                Task.assertValue( "listMonoid.zero",FoldOppgaver.listMonoid(), (Monoid<?> m)->m.zero().equals( List.nil() ), Show.<Monoid<?>>showS( (m)->"Monoid(zero="+m.zero().toString()+")" )),
                Task.testFunc( "listMonoid.sum", FoldOppgaver.listMonoid(), Property.property(arbString,arbString,arbString,(str1,str2,str3)->{
                            F2<List<String>,List<String>,List<String>> sum = Function.uncurryF2(FoldOppgaver.<String>listMonoid().sum());
                            List<String> list1 = List.single( str1 );
                            List<String> list2 = List.single( str2 );
                            List<String> list3 = List.single( str3 );

                            return Property.prop(sum.f( list1,sum.f(list2,list3) ).equals( sum.f(sum.f(list1,list2),list3) ));
                        }
                ) )

        );
    }
}
