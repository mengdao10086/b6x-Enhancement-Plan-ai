package com.omarea.krscript.model;

import a.bc2;
import a.f92;
import java.io.File;
import java.io.Serializable;
import java.util.UUID;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class NodeInfoBase implements Serializable {
    public final String currentPageConfigPath;
    public String desc;
    public String descSh;
    public final String index;
    public String key;
    public final String pageConfigDir;
    public String summary;
    public String summarySh;
    public String title;

    public NodeInfoBase(String str) {
        String parent;
        f92.d(str, "currentPageConfigPath");
        this.currentPageConfigPath = str;
        if (str.length() > 0) {
            parent = new File(this.currentPageConfigPath).getParent();
            f92.c(parent, "dir");
            if (bc2.x(parent, "file:/android_asset/", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("file:///android_asset/");
                String strSubstring = parent.substring(20);
                f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                parent = sb.toString();
            }
        } else {
            parent = "";
        }
        this.pageConfigDir = parent;
        this.key = "";
        String string = UUID.randomUUID().toString();
        f92.c(string, "UUID.randomUUID().toString()");
        this.index = string;
        this.title = "";
        this.desc = "";
        this.descSh = "";
        this.summary = "";
        this.summarySh = "";
    }

    public final String getCurrentPageConfigPath() {
        return this.currentPageConfigPath;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescSh() {
        return this.descSh;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPageConfigDir() {
        return this.pageConfigDir;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getSummarySh() {
        return this.summarySh;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDesc(String str) {
        f92.d(str, "<set-?>");
        this.desc = str;
    }

    public final void setDescSh(String str) {
        f92.d(str, "<set-?>");
        this.descSh = str;
    }

    public final void setKey(String str) {
        f92.d(str, "<set-?>");
        this.key = str;
    }

    public final void setSummary(String str) {
        f92.d(str, "<set-?>");
        this.summary = str;
    }

    public final void setSummarySh(String str) {
        f92.d(str, "<set-?>");
        this.summarySh = str;
    }

    public final void setTitle(String str) {
        f92.d(str, "<set-?>");
        this.title = str;
    }
}
