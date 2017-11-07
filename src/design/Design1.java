package design;

import java.util.ArrayList;
import java.util.List;

public class Design1 {
    public static void main(String[] args) {
        CheckerMachine checkerMachine = new CheckerMachine();
        Checker checker1 = new Checker() {
            @Override
            public void check(Person person) {

            }

            @Override
            public int getCheckResult() {
                return 0;
            }
        };
        Checker checker2 = new Checker() {
            @Override
            public void check(Person person) {

            }

            @Override
            public int getCheckResult() {
                return 0;
            }
        };
        Checker checker3 = new Checker() {
            @Override
            public void check(Person person) {

            }

            @Override
            public int getCheckResult() {
                return 0;
            }
        };
        Checker checker4 = new Checker() {
            @Override
            public void check(Person person) {

            }

            @Override
            public int getCheckResult() {
                return 0;
            }
        };
        checkerMachine.addChecker(checker1);
        checkerMachine.addChecker(checker2);
        checkerMachine.addChecker(checker3);
        checkerMachine.addChecker(checker4);
        checkerMachine.startCheck(new Person());
        System.out.println(checkerMachine.checkResult());
    }
}
interface Checker {
    int checking = 0;
    int check_success = 1;
    int check_fail = 2;
    void check(Person person);
    int getCheckResult();
}

class Person{}

class CheckerMachine{


    private List<Checker> checkerList = new ArrayList<>();
    public void addChecker(Checker checker){
        checkerList.add(checker);
    }


    public void startCheck(Person person){
        for (Checker checker : checkerList){
            checker.check(person);
        }
    }

    public int checkResult() {
        if (checkerList.isEmpty()) return Checker.check_fail;
        int checkResult = -1;
        for (Checker checker : checkerList) {
            if (checker.getCheckResult() == Checker.check_fail) return Checker.check_fail;
            if (checker.getCheckResult() == Checker.checking) checkResult = Checker.checking;
        }
       return checkResult == -1 ? Checker.check_success : checkResult;
    }
}



