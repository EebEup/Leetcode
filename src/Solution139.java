import java.util.List;

public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {


        return f(s,wordDict);
    }
    boolean f(String s,List<String> wordDict){
        if(s.length()==0||wordDict.contains(s)) return true;

        for(int i=1;i<s.length();i++){
            String substring = s.substring(0, i);
            if(wordDict.contains(substring)){
                if(f(s.substring(i,s.length()),wordDict)){
                    return true;
                }
            }
        }




        return  false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        if(s==null)return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0]=true;
        for (int i=1;i<s.length();i++){
           for(int j=0;j<s.length();j++){
               if(dp[j]&&wordDict.contains(s.substring(j,i))){
                   dp[i]=true;
                   break;
               }


           }
       }

        return dp[s.length()];

    }




}


