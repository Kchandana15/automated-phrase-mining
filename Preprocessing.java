
package topictracking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Preprocessing 
{
    String txt;
    String tab1[]={"ant","ement","ment","ent","able","ible","ic","ial","al","ance","ence","ition","ication","er","ion","ou","ism"};
    String tab2[]={"icate","ative","alize","iciti","ical","ful","ic","ition","ication","iest"};
    String tab3[]={"ic","","al","ic","ic","","","y","y","y"};
    
    ArrayList stpres=new ArrayList();
    Preprocessing(String g)
    {
        txt=g;
    }
    
    public String[] sentenceSegmentation()
    {
        Pattern pn=Pattern.compile("(?<=\\w[\\w\\)\\]][\\.\\?\\!]\\s)");
        Matcher matcher = pn.matcher(txt);
			
        String reg="(?<=\\w[\\w\\)\\]][\\.\\?\\!]\\s)";
        
         
                txt=txt.replace(",","");
                txt=txt.replace("\"","");
                txt=txt.replace("?","");
                txt=txt.replace("%","");
        
        txt=txt.replaceAll("[0-9]+","");
        String res[]=txt.split(reg);
            
        System.out.println("sg "+res.length);
        for(int i=0;i<res.length;i++)
           System.out.println("---- "+res[i].trim());
          
       return res;
    }
    
    public ArrayList normalization(String sg[])
    {
        ArrayList res=new ArrayList();
        // case folding
        
        String st1[]=sg;
        for(int i=0;i<st1.length;i++)
            st1[i]=st1[i].toLowerCase();
        
        
        // String tokenization
        
        for(int i=0;i<st1.length;i++)
        {
            System.out.println("sentence "+i);
             StringTokenizer stk = new StringTokenizer(st1[i]);
             while (stk.hasMoreTokens()) 
             {
                //System.out.println(stk.nextToken());
                String g=stk.nextToken();
                g=g.replace(".", "");
                g=g.replace(",","");
                g=g.replace("\"","");
                g=g.replace("?","");
                g=g.replace("%","");
                System.out.println(g);
                res.add(g);
             }
        }
        
        
        
        ArrayList<String> stp=new ArrayList<String>();
        Scanner scan1 = null;
        
        try
        {
            scan1 = new Scanner(new BufferedReader(new FileReader("stopwords.txt")));
            while (scan1.hasNext())
                stp.add(scan1.next());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        ArrayList wd=new ArrayList();
        for(int i=0;i<res.size();i++)
        {
            if(!(stp.contains(res.get(i))))
            {
                wd.add(res.get(i));
            }
        }
        stpres=wd;
        System.out.println("-------------");
        System.out.println(wd);
        
        // stemming 
        ArrayList stm=new ArrayList();
        for(int i=0;i<wd.size();i++)
        {
            String s1=wd.get(i).toString();
            int flag1=0;
            for(int j=0;j<tab1.length;j++)
            {
                if(s1.endsWith(tab1[j]))
                {
                    String s2=s1.replace(s1,s1.substring(0, s1.length()-tab1[j].length()));
                    //String s2=s1.replace(tab1[j],"");
                    stm.add(s2);
                    flag1=1;
                    break;
                }
            }
            int flag2=0;
            for(int j=0;j<tab2.length;j++)
            {
                if(s1.endsWith(tab2[j]))
                {
                    //String s2=s1.replace(s1, s1.substring(0, tab3[j].length()));
                    String s2=s1.replace(tab2[j],tab3[j]);
                    stm.add(s2);
                    flag2=1;
                    break;
                }
            }
            if(flag1==0 && flag2==0)
                stm.add(s1);
        }
        System.out.println(stm);
        return stm;
    }
    
    
}
