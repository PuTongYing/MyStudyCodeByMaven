package CodeExercise.Leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 小蔡
 * @Date: 2023/12/13 21:24
 * @description: 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 *      1 <= s.length <= 1000
 *      s 仅由数字和英文字母组成
 */
public class Leecode_005 {
    /**
     * 解法1-动态规划
     * 时间复杂度：O(n²）,其中n是字符串的长度。动态规划的状态总数为O(n²),对于每个状态，我们需要转移的时间为O(1)。
     * 空间复杂度：O(n²）,即存储动态规划状态需要的空间。
     * 解题思路：
     * 对于一个字串而言，如果它是回文串，并且长度大于2，那么将它首位的两个字母去除之后，它依然是个回文串。例如对于字符串"ababa"，如果我们已经知道"bab"是回文串，
     * 那么"ababa"一定是回文串，这是因为它的首尾两个字母都是"a"。
     * 根据这样的思路，我们就可以用动态规划的方法解决本题，我们用P(i,j)表示字符串s的第i到j个字母组成的串(下文表示成s[i,j])是否为回文串:
     *      P(i,j) = true,  如果字串Si···Sj是回文串
     *               false, 其他情况
     *      其他情况:
     *              1-s[i,j] 本身不是一个回文串；
     *              2-i>j，此时 s[i,j]s[i, j]s[i,j] 本身不合法。
     * 那么我们就可以写出动态规划的状态转移方程：
     *      P(i,j)=P(i+1,j−1)∧(Si==Sj)
     * 也就是说，只有 s[i+1:j−1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j] 才会是回文串。
     * 上文的所有讨论是建立在子串长度大于 2 的前提之上的，我们还需要考虑动态规划中的边界条件，即子串的长度为 1 或 2。对于长度为 1 的子串，它显然是个回文串；对于长度为 2 的子串，
     * 只要它的两个字母相同，它就是一个回文串。因此我们就可以写出动态规划的边界条件：
     *      P(i,i) = true
     *      P(i,i+1) = (Si == Si+1)
     * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i,j)=true,中 j−i+1（即子串长度）的最大值。
     */
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        int maxLen = 1;
//        int begin = 0;
//        // dp[i][j] 表示 s[i..j] 是否是回文串
//        boolean[][] dp = new boolean[len][len];
//        // 初始化：所有长度为 1 的子串都是回文串
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        char[] charArray = s.toCharArray();
//        // 递推开始
//        // 先枚举子串长度
//        for (int L = 2; L <= len; L++) {
//            // 枚举左边界，左边界的上限设置可以宽松一些
//            for (int i = 0; i < len; i++) {
//                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
//                int j = L + i - 1;
//                // 如果右边界越界，就可以退出当前循环
//                if (j >= len) {
//                    break;
//                }
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }

    /**
     * 解法2-中心扩展算法
     * 时间复杂度：O(n²),其中 n 是字符串的长度。长度为 1 和 2 的回文中心分别有 n 和 n−1 个，每个回文中心最多会向外扩展 O(n) 次。
     * 空间复杂度：O(1)。
     * 方法二的本质即为：我们枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。我们对所有的长度求出最大值，即可得到最终的答案。
     */
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public int expandAroundCenter(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return right - left - 1;
//    }

    /**
     * 解法3-Manacher算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 解题思路：
     * 臂长，表示中心扩展算法向外扩展的长度。eg:如果一个位置的最大回文字符串长度为2*length+1,其臂长为length。
     * 当在位置 i 开始进行中心拓展时，我们可以先找到 i 关于 j 的对称点 2 * j - i。那么如果点 2 * j - i 的臂长等于 n，我们就可以知道，点 i 的臂长至少为 min(j + length - i, n)。
     * 那么我们就可以直接跳过 i 到 i + min(j + length - i, n) 这部分，从 i + min(j + length - i, n) + 1 开始拓展。
     * 我们只需要在中心扩展法的过程中记录右臂在最右边的回文字符串，将其中心作为 j，在计算过程中就能最大限度地避免重复计算。
     * 那么现在还有一个问题：如何处理长度为偶数的回文字符串呢？
     * 我们可以通过一个特别的操作将奇偶数的情况统一起来：我们向字符串的头尾以及每两个字符中间添加一个特殊字符 #，比如字符串 aaba 处理后会变成 #a#a#b#a#。
     * 那么原先长度为偶数的回文字符串 aa 会变成长度为奇数的回文字符串 #a#a#，
     * 而长度为奇数的回文字符串 aba 会变成长度仍然为奇数的回文字符串 #a#b#a#，我们就不需要再考虑长度为偶数的回文字符串了。
     */
//    public String longestPalindrome(String s) {
//        int start = 0, end = -1;
//        StringBuffer t = new StringBuffer("#");
//        for (int i = 0; i < s.length(); ++i) {
//            t.append(s.charAt(i));
//            t.append('#');
//        }
//        t.append('#');
//        s = t.toString();
//
//        List<Integer> arm_len = new ArrayList<Integer>();
//        int right = -1, j = -1;
//        for (int i = 0; i < s.length(); ++i) {
//            int cur_arm_len;
//            if (right >= i) {
//                int i_sym = j * 2 - i;
//                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
//                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
//            } else {
//                cur_arm_len = expand(s, i, i);
//            }
//            arm_len.add(cur_arm_len);
//            if (i + cur_arm_len > right) {
//                j = i;
//                right = i + cur_arm_len;
//            }
//            if (cur_arm_len * 2 + 1 > end - start) {
//                start = i - cur_arm_len;
//                end = i + cur_arm_len;
//            }
//        }
//        StringBuffer ans = new StringBuffer();
//        for (int i = start; i <= end; ++i) {
//            if (s.charAt(i) != '#') {
//                ans.append(s.charAt(i));
//            }
//        }
//        return ans.toString();
//    }
//
//    public int expand(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return (right - left - 2) / 2;
//    }
}
