package com.lwb.learn.programmingexam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true){
            String str = input.next();
            if(str.equals("END")){
                break;
            }
            list.add(str);
        }
        HashMap<String,String> res = method1(list);
        ArrayList<String> list1 = new ArrayList<>();
        for(String s : list){
            if(!res.containsKey(s)){list1.add(s);}
        }
        if(list1.size()==0){
            System.out.println("None");
        }else{
            for(String s : list1){
                System.out.println(s);
            }
        }
    }

    public static HashMap<String,String> method1(ArrayList<String> list){
        HashMap<String,String> res = new HashMap<>();
        int n = list.size();
        for(int i=0;i<n;i++){
            int x = method2(list.get(i));
            for(int j=0;j<n;j++){
                if(j==i) continue;
                if(x==method2(list.get(j))){
                    res.put(list.get(i), "1");
                }
            }
        }
        return res;
    }

    public static int method2(String s){
        String[] strs = s.split("#");
        int base = Integer.valueOf(strs[0]);
        int res = 0;
        char[] a = strs[1].toCharArray();
        int n = a.length;
        for(int i=0;i<n;i++){
            int temp = Integer.valueOf(String.valueOf(a[i]))*(int)Math.pow(base, n-i-1);
            res = res + temp;
        }
        return res;
    }

}

