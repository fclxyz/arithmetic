package com.fclxyz.arithmetic;


/**
 * 给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，从编码字符串中每次读取一个字符，并采取以下步骤：
 * <p>
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "leet2code3", K = 10
 * 输出："o"
 * 解释：
 * 解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
 * 字符串中的第 10 个字母是 "o"。
 * 示例 2：
 * <p>
 * 输入：S = "ha22", K = 5
 * 输出："h"
 * 解释：
 * 解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
 * 示例 3：
 * <p>
 * 输入：S = "a2345678999999999999999", K = 1
 * 输出："a"
 * 解释：
 * 解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= S.length <= 100
 * S 只包含小写字母与数字 2 到 9 。
 * S 以字母开头。
 * 1 <= K <= 10^9
 * 解码后的字符串保证少于 2^63 个字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decoded-string-at-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeAtIndex {
    public static void main(String[] args) {
        System.out.println(solution("leet2code3", 10));
    }

    private static char solution(String string, int index) {
        char result = 0;
        StringBuffer lastWord = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= '2' && c <= '9') {
                String lastString = lastWord.toString();

                for (int j = 1; j < Integer.valueOf(String.valueOf(c)); j++) {
                    lastWord.append(lastString);
                }
            } else {
                lastWord.append(c);
            }

            if (index <= lastWord.length()) {
                return lastWord.charAt(index - 1);
            }
        }

        return result;
    }
}
