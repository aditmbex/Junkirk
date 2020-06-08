package com.example.junkirk;

import android.net.Uri;

import java.util.ArrayList;

public class MembersData {
    private static String HunsImgUrl = getURLForResource(R.drawable.hanss);
    private static String AnneImgUrl = getURLForResource(R.drawable.anne);
    public static String VinaImgUrl = getURLForResource(R.drawable.vina);
    public static String JnkImgUrl = getURLForResource(R.drawable.junkirklogo);
    public static String PndImgUrl = getURLForResource(R.drawable.pandapetualang);
    private static String[][] data = new String[][]{
            {"Anne Shakka", "Saya hanya suka menulis, itu saja.",AnneImgUrl,"https://annebercerita.blogspot.com/"},
            {"Cahyo Susmawanto", "Guru sejarah Stella Duce Yogyakarta", "https://yt3.ggpht.com/a/AATXAJxNziCqYqo31Yepw3rJ6fsJPXqx2du30kHiuA=s100-c-k-c0xffffffff-no-rj-mo","https://www.youtube.com/channel/UCk1dWJtqUiVtgZc_DTWkMPQ"},
            {"Claudius Hans", "Ngomyang untuk penyegaran",HunsImgUrl,"https://salvatorefaida.blogspot.com/"},
            {"Ervina Rete", "Ketika negara api datang menyerang kamu mau apa?",VinaImgUrl,"https://panateaa.wordpress.com/"},
            {"Emmanuel Kurniawan", "Saya adalah pengelana yang mampir ke dunia ini tanpa sengaja", "https://jurnalnoel.files.wordpress.com/2011/02/ktp.jpg","https://jurnalnoel.wordpress.com/"},
            {"Padmo Adi", "Hidup adalah tragi-komedi!!!", "https://2.bp.blogspot.com/-e0gqhhIL-uc/VGJD0E9F05I/AAAAAAAAAeo/mHli6VrrxpY/s113/IMG-20141025-WA0003.jpg","https://www.sarang-kalong.com/"},
            {"Petualangan Panda", "Bertualang, berdagang untuk anda", PndImgUrl,"https://petualanganpanda.wordpress.com/"},
            {"Junkirk", "Tentang Junkirk", JnkImgUrl,"https://junkirk.wordpress.com/"},
    };

    static ArrayList<Members> getListData(){
        ArrayList<Members> list = new ArrayList<>();
        for (String[] aData : data){
            Members members = new Members();
            members.setName(aData[0]);
            members.setFrom(aData[1]);
            members.setPhoto(aData[2]);
            members.setUrl(aData[3]);

            list.add(members);
        }
        return list;
    }

    public static String getURLForResource(int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }
}
