package com.omarea.model;

import a.f92;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ZramMMStat {
    public boolean abnormal;
    public String origDataSize = "";
    public String comprDataSize = "";
    public String memUsed = "";
    public String memLimit = "";
    public String memUsedMax = "";

    public final boolean getAbnormal() {
        return this.abnormal;
    }

    public final String getComprDataSize() {
        return this.comprDataSize;
    }

    public final String getMemLimit() {
        return this.memLimit;
    }

    public final String getMemUsed() {
        return this.memUsed;
    }

    public final String getMemUsedMax() {
        return this.memUsedMax;
    }

    public final String getOrigDataSize() {
        return this.origDataSize;
    }

    public final void setAbnormal(boolean z) {
        this.abnormal = z;
    }

    public final void setComprDataSize(String str) {
        f92.d(str, "<set-?>");
        this.comprDataSize = str;
    }

    public final void setMemLimit(String str) {
        f92.d(str, "<set-?>");
        this.memLimit = str;
    }

    public final void setMemUsed(String str) {
        f92.d(str, "<set-?>");
        this.memUsed = str;
    }

    public final void setMemUsedMax(String str) {
        f92.d(str, "<set-?>");
        this.memUsedMax = str;
    }

    public final void setOrigDataSize(String str) {
        f92.d(str, "<set-?>");
        this.origDataSize = str;
    }
}
