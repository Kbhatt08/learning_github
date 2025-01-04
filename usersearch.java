import java.util.Arrays;

public class usersearch {
    
    public static void main(String[] args) {
        
        boolean ans=searchpalindrome("maddom");
        long starttime=System.nanoTime();
        System.out.println("output palindrome is "+ans + " in "+(System.nanoTime()-starttime)+"ns");
    }
    public static boolean searchpalindrome(String str){

        for(int i=0; i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}
