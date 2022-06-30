import org.junit.Test;

import java.util.Arrays;

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
        System.out.println(closeStrings("byiwbiibwhyyyibybmbyjiembbbybiyhjbfdmuiiyebbqhbijibbifybbybwmbbyddyyibdiupybbmiymfimvijwypiufywybhbhbjyyyymyyyifwbwuyiybbbbjyjwmduvibfzbmbfyfjpyywiiyuyjbbyhwywbwibbyybiybbwjbfjebymiffyifyijbfiyibibyfbymfkwfbjjhiqiipjmyembwbjijuiuydimwjyeidubdwmdjdijjidyidwbbuwfybmybwyhyfyydbbujzjjuwybibdhiuyfbyjhdbuybybbuyfdlubiimjibijywyiyypbiybbpwywbmvuwuiyiwfbiwdbjiiibiwdiiibiimyfwwbybmjwbfyibixdmuybbdbfyewbyifuubmybbyibibyjwbbibbbwufdbbydifybmbyibidiuybbiuiidjmyuddzvyybyuibjhbbysefjbjmiidbfidybfbyyiybdbubiyhbfdbbbbibwwbmdiwydjbeymmqbihubpjyiuuhibidjidjyhbuhdiybjbidbjdbmddiubiiufymjbuuiwbbubyeeijefuwbyejiybybypyyhbdpbfwhjjbdwbiyiwybbfbiwymwdbbbbiiibbwmdydiuwddhbywbehbyfbizybmyhyiedyibbbmuyjimbyivfejqywdjbybubibyjdmdwbdbmmbjubuiubbbwhbbyhbymhihmdbhubjybdyuibbifbbbhbibybfbjyyjbffiybuemiiwhdbyjebbjyihiwbbyuifiydiybbibubfbifybbyhiiuhbbbbzidbwubwbhbiyybbbyhybyiihijhubfybyzdijbmfuoijiybyyyiubwbbyyyyjjujiyjbjedjdjwwbbyiduyfybyyudbydwiijbbjwybjmiyyyjbubwbcbjyybbmdmwbbjibbwwymbdbmiybiibbhmybybeibifyjybybejdibbbfmbybwyqjdwyibybwmdjbbjhfiyfuubbbfpwybyhjbbyybequyuywyyybjbyyiybwhhbiyiwbfyuyiwyfbjyhibyiiybiwbbjejibdyibbyyudyewypwyyyedfbpbbwyuyjmueyibijyjmyfujydiiyiwibiwuwimbwdyzeyfbfbzwydbbyiwudwjwbybbbjyybyjbbyfyybbiubbmbbibdimyiyybjffybmebbbfbjbuimyjfdbyjiwyyidybijiimwijyyibijdyjbbmeyubmdiwubiwwjfbwybbwihiiwbfuipmbiyebbwhyjfifbuwvdyybdyymfyifjiewmyiydbudbbubbyyiyimbjmwbjhiwfybyhwbibhwfwijmjbmbbebbyibbjbijdhffbdadwddifwbhjdybibwuymyyjbybdywbuebwwiyeymwymyuybyjbwyhimiyimwbzijwwdbhbyffjuybwhfbiibfiwhubyijbhwyuybbemfhfdbtymiyybjjbbyfmhyiymjiibbbdywfjwbbjbyiijubywdffjwmhdwijybwbmidyuyuyibbibibbhuiuibbzbyiwyeijdiebbdbwfbjiyibyifiiyeybbfdbibzbzbbyyfbbjyqmibbmbbiifdbwbbyjibmbyydibdhbbbyyibibyybdmymubjbybwfbuiyburybwbibhbhdjuiiiyufewjbiyjyyybiubizbyhbhyyiyibibbbhyjfijbyjmyybiiiyjbybjbjdduiwywdbumymibyybbbjwuifbbiwddbdddbjbjbdeijjqijiyjydjbiybybyibwhwyefbbyfbdybbdbbyhbywyymdbiybiihiywyjfbwwbdfhqhyuuhiwybbbibmybuyiyweyiiybbibwbhwfybyywjmybmjyieuufnjenbyzuyfimeyiydibmidmybiyfuiuwybbijbjibfyubbefdjziyejibbibhibyyjjwfyjemyhbhwyyiydiyybydmwmbzyfqwbjibjimfyhiuufbyhbmiyfyyyifebfbbbhbifbyidbdbbbwyybebiuubymiyyiiybfyijdiibbpymdmmibyfwufyyjbbumyduyyfyjiiyydbbyyyyfyyiwubbybiidewewiwbbjbbyiibffbubmwdybmwijyigbybymidwfyydyyjifjuybjybibnifjbyibyweyibbmjirbybuvwwuhimywujiymyebjbbhdumeyuiyy",
                "dikaziirmizqhrdkzikkiazirzviiiiaraikviiairimrdzihiziiizszizzizkiaimhaazdavmaaajlimrikzvhiiiikiizziikrijaiaimzaakizzmrakiziairzaraazraikraaidmihzjizsarzaizismirzsvaazkzsiiziivaaiikivsiiizmzaizrizzzzizikzmkiivijmiiiirvjiziisadrzizjssdiiijzrakqizizkvsazzzkaddmkivairuazsrqjrazzaijkrmzmdsivzddjziimikimmzsazhazjakzvzvzkriirzijmvavaiijurzafziavkrizizjkijzamadzivazzjaakjvavukkiiksizrvgvivivazkmaiijaivrdaskdmsriaizardaikasairakzvmkdsahdiziiiviiihzaavkzvazrizmsarzmikmjkaizifrrkkzmazdsmivvivaiviiizsacaamkzrsdzzaikmizmrzvzjjakazkzzzmzrzijazizimkrikzkiizzzhiizadirdiazdasviarzkirvsaizrisdazszhzziazizrdaziraasdiariaiizkmshumzzadrjaiiiizzsdjaziajziiszdzzsrrsrzzdsiqaihiridizdmadzekmrkismrbrziikrmmizizhrvmjvjzziahikiaajazsdaaikazzdrvjishakmdzajaajhjjivzzrzjaiikirimzijhjzizzzdzziiizazaazahrrzdaszvaavajzkradhhamviijzmkzjizahvksakrszzhisdiikrrzkkimarzizizhorzisrrizruaaijizaizhjizzraissiziarjirjamajadaiiiviaizizmvaazhzraimimvvaiazzkibzasikajkavaavmizzizzadiijajkiiiakikiksmdjzdzzmziikajjzzkzzziazjiairdaiiivisiazzzhdamhmzshrdiziziaazvzsaikrkizhaizrmzarzrzaadviavivdjiiavmziaazkkirddvihkiaiqziiiaijrzkazvazamzizizzsmikiiikddirjjizmrzzmvmzzijmkiivjiimriaidsazaidriakjajziikazaskahzazihrdiiiflzzddkidkzuzijmhzzidihzizidmiqaairmjdadrramaiiijrmaiaiiarjiiiidzmsazmahmjazijihkaiarkazirzazaiakjdvrivhrzazamaaiivzliiqijizzzjzaimzmmhiajimzkikjzikmakviizmijihzdiizizizzrivadaviaiiiiidvziaizzrisrfkirvizjzaidzjjrapkakzrzvvmaimzdidadrjumzaazjuhhziizkddzzrkiiimajmrsazazizdakmiasvkzmazrflkzzaiizhivdzdmvdairzimrrvrzisklzvrkjrkjdzdhzaziiidmiznixjaksiizviiiazzaizkzvizzkhdisvizjasziarzjlikizaidiramzjiamvdaraadrimiaikzaddzzdvaiirdariizriaaizziaizirmizdzizizzzivkakvikiizhiszvkdikiizimkmaiiiirmiiaaywszaiiziiviuzimiaajzzzmakvazvrmsaizaskramsrirzizirrimksvrsjzakavviziirjdfzvidaarmiizriikriarizzrajdzkzdziaiiviaidrsziakikkmiairaaziiiijjiaaiqazihiizziziidzqiiikzkamimiazvzadadzhdzzakvazzzrrkiimsazriiiijariiivzhdzhkarrsimaarzaizijlzdzazvkzazizmmkzqrzmaziziadvziidziiziizvzirizivijaiiaadszduivvkajrazdlimzjisijiqjiaisiabzmzitziraakvakkidmmqikvaiikjjikikjizzaaazizaijsqzvimjzvurmmkzriisdaivkzfmvdzzkazzdkjzkjiviirzrvmajziijmzizmuahikiijrivmaraivdadmirzravazaiimmiiqadzsvrirkzdjavksdlaiivirzlazaiadrjmiirvizizkzzkszizikaghvzmiiqzdmiqhvazmzhikairazkkiivmkjzraiiijaiukrzivjzazidkriziszizkzvarzmmaaiivhmuzmikzadz"));
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
}
