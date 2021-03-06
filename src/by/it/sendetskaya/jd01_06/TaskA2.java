package by.it.sendetskaya.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String []words={};
    private static int[]count={};

        public static void main(String[] args) {

            Pattern pattern=Pattern.compile("[А-Яа-яЁё]+");
            Matcher matcher=pattern.matcher(Poem.text);
            //StringBuilder sb=new StringBuilder(Poem.text);
            while (matcher.find()){
                //System.out.println(matcher.group());
                String word=matcher.group();
                processWord(word);
            }
            print();
        }

        private static void processWord(String word)
        {
            for (int i = 0; i < words.length; i++) {
                if(word.equals(words[i])) {
                    count[i]++;
                    return;
                }
            }

            words=Arrays.copyOf(words,words.length+1);
            count=Arrays.copyOf(count,count.length+1);
            words[words.length-1]=word;
            count[count.length-1]=1;
        }

        private  static void print()
        {
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]+"="+count[i]);

            }
        }

}
