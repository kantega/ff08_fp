package fpws;

import fj.data.List;

public class TasksChecker {

    public static void main(String[] args){
        List.list(
                Task.sequence(FunksjonerTest.tasks())
        );

    }

}
