//Given a list of accounts where each element accounts[i] is a list of strings, 
//where the first element accounts[i][0] is a name, and the rest of the elements 
//are emails representing emails of the account. 
//
// Now, we would like to merge these accounts. Two accounts definitely belong 
//to the same person if there is some common email to both accounts. Note that even 
//if two accounts have the same name, they may belong to different people as 
//people could have the same name. A person can have any number of accounts initially, 
//but all of their accounts definitely have the same name. 
//
// After merging the accounts, return the accounts in the following format: the 
//first element of each account is the name, and the rest of the elements are 
//emails in sorted order. The accounts themselves can be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],[
//"John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John",
//"johnnybravo@mail.com"]]
//Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.
//com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//Explanation:
//The first and second John's are the same person as they have the common email 
//"johnsmith@mail.com".
//The third John and Mary are different people as none of their email addresses 
//are used by other accounts.
//We could return these lists in any order, for example the answer [['Mary', 
//'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
//['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] 
//would still be accepted.
// 
//
// Example 2: 
//
// 
//Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
//"Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
//"Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@
//m.co","Fern1@m.co","Fern0@m.co"]]
//Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.
//co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.
//co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co",
//"Fern1@m.co","Fern5@m.co"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= accounts.length <= 1000 
// 2 <= accounts[i].length <= 10 
// 1 <= accounts[i][j] <= 30 
// accounts[i][0] consists of English letters. 
// accounts[i][j] (for j > 0) is a valid email. 
// 
// Related Topics Array String Depth-First Search Breadth-First Search Union 
//Find 👍 3801 👎 684


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    int[] p;

    public UnionFind(int N) {
        this.p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            x = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = find(b);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int N = accounts.size();
        Map<String, Integer> email2Id = new HashMap<>();
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (email2Id.containsKey(email)) {
                    uf.union(i, email2Id.get(email));
                } else {
                    email2Id.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> id2emails = new HashMap<>();
        for (int i = 0; i < N; i++) {
            List<String> account = accounts.get(i);
            int cid = uf.find(i);
            Set<String> set = id2emails.getOrDefault(cid, new HashSet<>());
            for (int j = 1; j < account.size(); j++) {
                set.add(account.get(j));
            }
            id2emails.put(cid, set);
        }

        List<List<String>> res = new ArrayList<>();
        for (Integer cid : id2emails.keySet()) {
            String name = accounts.get(cid).get(0);
            List<String> account = new ArrayList<>();

            account.add("");
            account.addAll(id2emails.get(cid));
            Collections.sort(account);

            account.set(0, name);
            res.add(account);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
