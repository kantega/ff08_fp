package fpws;

import fj.F;
import fj.F2;
import fj.data.List;

import static fj.Function.curry;

public class TasksChecker {

    public static void main(String[] args) {
        Task.sequence( List.list(
                Task.sequence( FunksjonerTest.tasks() ),
                Task.sequence( FoldTest.tasks() ),
                Task.sequence( MapTest.tasks() )
        ) ).check();

    }

    public static <A, B, C> F<A, F<B, C>> currySafe(F2<A, B, C> f) {
        if (f == null)
            return null;
        else
            return curry( f );
    }
}
