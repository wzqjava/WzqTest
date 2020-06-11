package com.example.autoopendd.MMKV;

import android.content.Context;

/**
 * share本地类
 */
public enum SPType {

    EM_LOGIN("EM_LOGIN", Context.MODE_PRIVATE),
    EM_NOTIFY("EM_NOTIFY", Context.MODE_PRIVATE),
    EM_GONGLI("EM_GONGLI", Context.MODE_PRIVATE),
    EM_LOGIN_INFO("EM_LOGIN_INFO", Context.MODE_PRIVATE),
    EM_DIARY_TEMP("EM_DIARY_TEMP", Context.MODE_PRIVATE),
    EM_MYDIARY_TEMP("EM_MYDIARY_TEMP", Context.MODE_PRIVATE),
    EM_READPASS("EM_READPASS", Context.MODE_PRIVATE),
    EM_STEALGOLD("EM_STEALGOLD", Context.MODE_PRIVATE),
    EM_PARENTINFO("EM_PARENTINFO", Context.MODE_PRIVATE),
    EM_MAILMSG("EM_MAILMSG", Context.MODE_PRIVATE),
    EM_TEACMSG("EM_TEACMSG", Context.MODE_PRIVATE),
    EM_CAMPAIGNMSG("EM_CAMPAIGNMSG", Context.MODE_PRIVATE),
    EM_RANKMSG("EM_RANKMSG", Context.MODE_PRIVATE),
    EM_CURRENTSTORY("EM_CURRENTSTORY", Context.MODE_PRIVATE),
    EM_VIDEOCATEGORY("EM_VIDEOCATEGORY", Context.MODE_PRIVATE),
    EM_FIRSTLISTENER("EM_FIRSTLISTENER", Context.MODE_PRIVATE),
    EM_FIRSTSPOKENLISTENER("EM_FIRSTSPOKENLISTENER", Context.MODE_PRIVATE),
    EM_READSPOKENPASS("EM_READSPOKENPASS", Context.MODE_PRIVATE),
    EM_ISDUB("EM_ISDUB", Context.MODE_PRIVATE),
    EM_READCAMPAIGN("EM_READCAMPAIGN", Context.MODE_PRIVATE),
    EM_REPAIR("EM_REPAIR", Context.MODE_PRIVATE),
    READING_MODEL("READING_MODEL", Context.MODE_PRIVATE),
    EM_LASTBOOKID("EM_LASTBOOKID", Context.MODE_PRIVATE),
    EM_H5VERSION("EM_H5VERSION", Context.MODE_PRIVATE),
    EM_WORDCHECK("EM_WORDCHECK", Context.MODE_PRIVATE),
    EM_SPUTIL("SpUtil", Context.MODE_PRIVATE);

    SPType(String key, int mode) {
        this.key = key;
        this.mode = mode;
    }

    private String key;
    private int mode;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

}
