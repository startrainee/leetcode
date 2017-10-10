package design;

import java.util.ArrayDeque;
import java.util.Queue;

public class Design1 {
    public static void main(String[] args) {
        ExamineManager examineManager = new ExamineManager();
        Examiner examiner1 = person -> false;
        Examiner examiner2 = person -> true;
        Examiner examiner3 = person -> false;
        Examiner examiner4 = person -> true;
        examineManager.addExaminer(examiner1);
        examineManager.addExaminer(examiner2);
        examineManager.addExaminer(examiner3);
        examineManager.addExaminer(examiner4);
        System.out.println(examineManager.examineResult(new Person()));
    }
}
interface Examiner {
    boolean examine(Person person);
}
class Person{}
class ExamineManager{
    private Queue<Examiner> examiners = new ArrayDeque<>();
    public void addExaminer(Examiner examiner){
        examiners.add(examiner);
    }
    public boolean examineResult(Person person){
        if(examiners.isEmpty()) return false;
       while (!examiners.isEmpty()){
           if(!examiners.poll().examine(person)) return false;
       }
       return true;
    }
}



