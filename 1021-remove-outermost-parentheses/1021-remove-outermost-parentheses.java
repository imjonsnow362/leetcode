class Solution {
    public String removeOuterParentheses(String S) {
        String res = "";
  // Stores the count of
  // opened parentheses
  int count = 0;
 
  // Traverse the string
  for (int c = 0;
           c < S.length(); c++)
  {
    // If opening parentheses is
    // encountered and their
    // count exceeds 0
    if (S.charAt(c) == '(' &&
        count++ > 0)
 
      // Include the character
      res += S.charAt(c);
 
    // If closing parentheses is
    // encountered and their
    // count is less than count
    // of opening parentheses
    if (S.charAt(c) == ')' &&
        count-- > 1)
 
      // Include the character
      res += S.charAt(c);
  }
 
  // Return the resultant string
  return res;
    }
}