package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

     public static int lengthOfLongestSubstringUsingSet(String s) {
         int ans=0,i=0,j=0;
         int n=s.length();
         Set<Character> set = new HashSet<>();
         while(i<n && j<n){
             if(set.contains(s.charAt(j))){
                 set.remove(s.charAt(i++));
             }else{
                 set.add(s.charAt(j++));
                 ans=Math.max(ans,j-i);
             }
         }
         return ans;
     }
    public static int lengthOfLongestSubstring(String s) {
        int ans=0;
        int n=s.length();
        int[] index = new int[128];
        for(int j=0,i=0;j<n;j++){
            i=Math.max(index[s.charAt(j)],i);
            ans=Math.max(ans,j-i+1);
            index[s.charAt(j)]=j+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcd"));
    }
}
