import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(solution139.wordBreak("leetcode", list));

    }
}
