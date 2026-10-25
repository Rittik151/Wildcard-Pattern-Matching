im

class Wildcard_Pattern_Matching {
     Boolean[][] dp;

    boolean solve(String s, String p, int i, int j) {

        if (dp[i][j] != null) return dp[i][j];

        if (i == s.length() && j == p.length())
            return dp[i][j] = true;

        if (j == p.length())
            return dp[i][j] = false;

        if (i == s.length()) {

            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        char pc = p.charAt(j);

        if (pc == s.charAt(i) || pc == '?') {
            return dp[i][j] = solve(s, p, i + 1, j + 1);
        }

        if (pc == '*') {

            return dp[i][j] = solve(s, p, i, j + 1) || solve(s, p, i + 1, j);
        }

        return dp[i][j] = false;
    }
    public boolean wildCard(String txt, String pat) {
        // code here
        dp=new Boolean[txt.length()+1][pat.length()+1];
        return solve(txt,pat,0,0);
    }
}