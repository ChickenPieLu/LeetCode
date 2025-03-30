//Leetcode Problem No.3

public class Q3 {
    public int lengthOfLongestSubstring(String s){
        int maxLength = 1;
        while (maxLength<=s.length()){
            boolean det = false;
            for (int i = 0; i<=s.length()-maxLength;i++){
                if (stringValid(s.substring(i,i+maxLength))){
                    maxLength++;
                    det = true;
                    break;
                }
            }
            if (!det) break;
        }
        return maxLength-1;
    }

    public boolean stringValid(String s){
        if (s.length() <= 1) return true;
        String check = s.substring(0, 1);
        for (String c: s.substring(1).split("")){
            if (check.equals(c)) return false;
        }
        return stringValid(s.substring(1));
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
        Q3 test = new Q3();
        print(test.lengthOfLongestSubstring("pwwkew")+"");
    }
}
