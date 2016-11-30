package com.example.android.miwok;

/**
 * Created by user10 on 11/11/2016.
 */

public class Word {
    //Default translation for the word
    private String mDefaultTranslation;
    //Miwok translation for the word
    private String mMiwokTranslation;
    //Image resource variable ID for the word
    private int mImageResourceID=NO_IMAGE_PROVIDED;
    //Has valid image
    private static  final int NO_IMAGE_PROVIDED=-1;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        //mXhosaTranslation=mXhosaTranslation;
        mImageResourceID=imageResourceID;
    }
    //Get the default translation of the word
    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    //Get the Miwok translation of the word
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }



    public int getmImageResourceID(){

        return mImageResourceID;
    }

    //Checks whether there the item has image

    public boolean hasImage(){

        return mImageResourceID!=NO_IMAGE_PROVIDED;
    }

}
