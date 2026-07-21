public class RqTest {
    public static void main(String[] args){

        Rq rq1 = new Rq("삭제?id=1");
        String action = rq1.getActionName();

        System.out.println(action);

        Rq rq2 = new Rq("수정?id=1");
        String action2 = rq2.getActionName();

        System.out.println(action2);
    }
}
