package Day42;

class Solution_ {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] digitToLetters = {
            "",     
            "",     
            "abc",   
            "def",  
            "ghi",  
            "jkl", 
            "mno", 
            "pqrs", 
            "tuv",  
            "wxyz"  
        };
        
        backtrack(result, digits, digitToLetters, new StringBuilder(), 0);
        return result;
    }
    
    private void backtrack(List<String> result, String digits, String[] digitToLetters, StringBuilder current, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digits, digitToLetters, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
