package com.example.tsf_bank;

public class Itemsincard {
    private int imageres;
    private String txt1;
    private String txt2;

    public Itemsincard(int images ,String text1,String text2){
          imageres = images;
          txt1 = text1;
          txt2 = text2;

    }
    public int getImageres(){
        return imageres;
    }
    public String getTxt1(){
        return txt1;
    }
    public String getTxt2(){
        return txt2;
    }
}

