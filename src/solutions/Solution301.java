package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution301 {
    List strings=new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s){
        int lremove=0;
        int rremove=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lremove++;
            }
            else if(s.charAt(i)==')'){
                if(lremove==0){
                    rremove++;
                }
                lremove--;
            }
        }
        dfs(s,lremove,rremove,0);
        return strings;

    }

    void dfs(String s,int l,int r,int index){
        if(l==0&&r==0){
            strings.add(s);
            return;
        }


        for(int i=index;i<s.length();i++){
            if(i!=0&&s.charAt(i)==s.charAt(i-1)) continue;
            if(l+r>s.length()-i){
                return;
            }
            if(l>0&&s.charAt(i)=='('){
                dfs(s.substring(0,i)+s.substring(i+1),l-1,r,i);
            }
            else if(r>0&&s.charAt(i)==')'){
                dfs(s.substring(0,i)+s.substring(i+1),l,r-1,i);
            }


        }

    }


    boolean isVavid(String s){
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                ans++;
            }
            else if(s.charAt(i)==')'){
                ans--;
                if(ans<0) return false;
            }
        }
        return ans==0;



    }


}
