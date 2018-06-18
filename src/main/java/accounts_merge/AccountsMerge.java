package accounts_merge;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AccountsMerge {

//    Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
//
//            Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
//
//    After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
//
//            Example 1:
//    Input:
//    accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
//    Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//    Explanation:
//    The first and third John's are the same person as they have the common email "johnsmith@mail.com".
//    The second John and Mary are different people as none of their email addresses are used by other accounts.
//    We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
//            ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
//    Note:
//
//    The length of accounts will be in the range [1, 1000].
//    The length of accounts[i] will be in the range [1, 10].
//    The length of accounts[i][j] will be in the range [1, 30].
    // Insert your Solution class here
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, List<String>> map = new HashMap<>();

            for (List<String> account: accounts) {
                List<String> accountFound = null;
                for(String email: account.subList(1, account.size())) {
                    if (map.containsKey(email)) {
                        accountFound = map.get(email);
                        break;
                    }
                }
                if (accountFound != null) {
                    for(String email: account.subList(1, account.size())) {
                        if (!map.containsKey(email)) {
                            accountFound.add(email);
                            map.put(email, accountFound);
                        }
                    }
                }
                else {
                    for(String email: account.subList(1, account.size())) {
                        map.put(email, account);
                    }
                }
            }
            Set<List<String>> set = new HashSet<>();
            for (String e: map.keySet()) {
                List<String> a = map.get(e);
                if (!set.contains(a)) {
                    Collections.sort(a.subList(1, a.size()));
                    set.add(map.get(e));
                }
            }
            return new ArrayList<>(set);
        }
    }
    public static class UnitTest {
        @Test
        public void testAccountsMerge() {
            Solution s = new AccountsMerge().new Solution();
//            [["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]

            ArrayList<List<String>> accounts = new ArrayList<>();
//            accounts.add(new ArrayList<>(Arrays.asList("Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co")));
            accounts.add(new ArrayList<>(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co")));
            accounts.add(new ArrayList<>(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co")));
//            accounts.add(new ArrayList<>(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co")));
//            accounts.add(new ArrayList<>(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co")));
            assertEquals(s.accountsMerge(accounts), null);
        }
    }
}

