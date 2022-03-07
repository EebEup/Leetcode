package OFFER;

public class Offer17 {

    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder sb = new StringBuilder();
    public String printNumber(int len){
        num=new char[len];
        for(int i=1;i<=len;i++){
            dfs(i,0);
        }

        StringBuilder stringBuilder = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }


    void dfs(int len,int index){
        if(index==len){
            sb.append(new String(num)+',');
            return;
        }
        int start=0;
        if(index==0) start=1;
        for(int i=start;i<10;i++){
            num[index]=loop[i];
            dfs(len,index+1);
        }




    }
}
