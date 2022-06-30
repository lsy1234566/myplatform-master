package com.lsy.study;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.20
 */

public class LeetCode {


    /**
     * 1657. 确定两个字符串是否接近
     * word1 和 word2 仅包含小写英文字母
     */
    @Test
    public void t1() {
        //"abc"
        //"bca"
        //"a"
        //"aa"
        //"cabbba"
        //"abbccc"
        //"abbzccca"
        //"babzzczc"
        //"uau"
        //"ssx"
        System.out.println(closeStrings("asfdsafsd",
                "asfdsafsd"));
    }

    public boolean closeStrings(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 != length2) return false;
        short[] b1 = new short[26];
        short[] b2 = new short[26];
        for (int i = 0; i < length1; i++) {
            b1['z' - word1.charAt(i)]++;
            b2['z' - word2.charAt(i)]++;
        }
        for (int i = 0; i < 26; i++) {
            if ((b1[i] == 0 && b2[i] == 0) || (b1[i] > 0 && b2[i] > 0)) continue;
            return false;
        }

        Arrays.sort(b1);
        Arrays.sort(b2);
        for (int i = 0; i < 26; i++) {
            if (b1[i] != b2[i]) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void t2() {

        int[] nums = {3, 2, 20, 1, 1, 3};
        int x = 10;
        System.out.println(minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {

        int n = nums.length;
        int left = 0, right = 0;
        int maxLength = -1;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];
        }
        int count = sum - x;
        if (count < 0) {
            return -1;
        }
        int sumNums = 0;
        while (right < n) {

            sumNums += nums[right];
            while (sumNums > count) {

                sumNums -= nums[left];
                left++;
            }
            if (sumNums == count) {

                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        if (maxLength == -1) return -1;
        else return n - maxLength;
    }

    /**
     * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，
     * 并用字符本身替换掉所有这些特殊的字符实体。
     */
    @Test
    public void t3() {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }

    public String entityParser(String text) {
        if (text == null || text.length() < 4) return text;
        Map<String, String> match = getMap();
        StringBuilder result = new StringBuilder();
        char[] arr = text.toCharArray();
        int k = 0, n = text.length();
        while (k < n) {
            int begin = -1;
            while (k < n && arr[k] != '&') result.append(arr[k++]);
            begin = k;
            while (k < n && arr[k] != ';') k++;

            //begin==n,则结束
            if (begin == n) break;
                //k==n,则表示没有找到';',直接拼接
            else if (k == n) result.append(text, begin, k);
            else {
                //是否与能在match中找到对应的转换字符，若能则转换并拼接
                //否则，直接拼接
                String element = match.get(text.substring(begin, k + 1));
                if (element == null) result.append(text, begin, k + 1);
                else result.append(element);
            }
            k++;
        }
        return result.toString();
    }

    public Map<String, String> getMap() {
        Map<String, String> result = new HashMap();
        result.put("&quot;", "\"");
        result.put("&apos;", "\'");
        result.put("&amp;", "&");
        result.put("&gt;", ">");
        result.put("&lt;", "<");
        result.put("&frasl;", "/");
        return result;
    }


    /**
     * 给 N x 3 网格图涂色的方案数
     */
    @Test
    public void t4() {
        System.out.println(numOfWays(11));
    }

    public int numOfWays(int n) {
        // 预处理出所有满足条件的 type
        List<Integer> types = new ArrayList<Integer>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (i != j && j != k) {
                        // 只要相邻的颜色不相同就行
                        // 将其以十进制的形式存储
                        types.add(i * 9 + j * 3 + k);
                    }
                }
            }
        }
        int typeCnt = types.size();
        // 预处理出所有可以作为相邻行的 type 对
        int[][] related = new int[typeCnt][typeCnt];
        for (int i = 0; i < typeCnt; ++i) {
            // 得到 types[i] 三个位置的颜色
            int x1 = types.get(i) / 9, x2 = types.get(i) / 3 % 3, x3 = types.get(i) % 3;
            for (int j = 0; j < typeCnt; ++j) {
                // 得到 types[j] 三个位置的颜色
                int y1 = types.get(j) / 9, y2 = types.get(j) / 3 % 3, y3 = types.get(j) % 3;
                // 对应位置不同色，才能作为相邻的行
                if (x1 != y1 && x2 != y2 && x3 != y3) {
                    related[i][j] = 1;
                }
            }
        }
        // 递推数组
        int[][] f = new int[n + 1][typeCnt];
        // 边界情况，第一行可以使用任何 type
        for (int i = 0; i < typeCnt; ++i) {
            f[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < typeCnt; ++j) {
                for (int k = 0; k < typeCnt; ++k) {
                    // f[i][j] 等于所有 f[i - 1][k] 的和
                    // 其中 k 和 j 可以作为相邻的行
                    if (related[k][j] != 0) {
                        f[i][j] += f[i - 1][k];
                        f[i][j] %= 1000000007;
                    }
                }
            }
        }
        // 最终所有的 f[n][...] 之和即为答案
        int ans = 0;
        for (int i = 0; i < typeCnt; ++i) {
            ans += f[n][i];
            ans %= 1000000007;
        }
        return ans;
    }

    //990. 等式方程的可满足性
    @Test
    public void t5() {
        String[] str = {"a==b", "b==f", "c==d", "d==f", "a!=d"};
        System.out.println(equationsPossible(str));
    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            char c1 = equation.charAt(0);
            char c2 = equation.charAt(3);
            char express = equation.charAt(1);
            if (express == '=') {
                union(parent, 'z' - c1, 'z' - c2);
            }
        }
        for (String equation : equations) {
            char c1 = equation.charAt(0);
            char c2 = equation.charAt(3);
            char express = equation.charAt(1);
            if (express == '!') {
                if (find(parent, 'z' - c1) == find(parent, 'z' - c2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    private void union(int[] parent, int i, int i1) {
        parent[find(parent, i)] = find(parent, i1);
    }


    //991. 坏了的计算器

    @Test
    public void t6() {
        System.out.println(brokenCalc(3, 10));
    }

    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }
        return ans + X - Y;
    }

    @Test
    public void t7() {
//        for (int i = 1; i < 110; i++) {
//            for (int i1 = 1; i1 < 11; i1++) {
//                System.out.print(i1 * i * 6);
//                System.out.print("|");
//            }
//            System.out.println();
//        }
        int[] nums = {6, 10, 15};
        System.out.println(isGoodArray(nums));
    }

    public boolean isGoodArray(int[] nums) {
        int len = nums.length, res = nums[0];
        for (int i = 1; i < len; i++) {
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    public void t8() {
//        System.out.println(permutation("nums"));
        String str3 = "1234";
        combine(str3.toCharArray(), 0, str3.length());
    }

    public static void combine(char[] str, int start, int end) {

        if (start == end) {
            System.out.println(str);
        } else {
            for(int j=start;j<end;j++){
                if (str[start] == str[j] && start!=j) continue;  //不同位置的相同字符不交换，避免重复
                swap(str,start,j);
                combine(str,start+1,end);//递归
                swap(str,start,j);  //还原字符串，为下一for循环准备

            }
        }

    }

    public static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }


    @Test
    public void t9(){

        int[][] ints = new int[3][3];
        ints[0][0]=2;ints[1][0]=1;ints[2][0]=2;
        ints[0][1]=5;ints[1][1]=3;ints[2][1]=22;
        ints[0][2]=1;ints[1][2]=1;ints[2][2]=1;


        int i = minCost(ints);
    }
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        for (int j = 0; j < 3; j++) {
            dp[j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] dpNew = new int[3];
            for (int j = 0; j < 3; j++) {
                dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = dpNew;
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    @Test
    public void t10(){
        wiggleSort(new int[]{5,6,7,1,1,1});
    }
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

}

