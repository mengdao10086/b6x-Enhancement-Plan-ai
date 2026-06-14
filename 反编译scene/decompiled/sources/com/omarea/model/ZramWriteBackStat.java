package com.omarea.model;

import a.f92;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ZramWriteBackStat {
    public int backReads;
    public int backWrites;
    public int backed;
    public String backingDev = "";

    public final int getBackReads() {
        return this.backReads;
    }

    public final int getBackWrites() {
        return this.backWrites;
    }

    public final int getBacked() {
        return this.backed;
    }

    public final String getBackingDev() {
        return this.backingDev;
    }

    public final void setBackReads(int i) {
        this.backReads = i;
    }

    public final void setBackWrites(int i) {
        this.backWrites = i;
    }

    public final void setBacked(int i) {
        this.backed = i;
    }

    public final void setBackingDev(String str) {
        f92.d(str, "<set-?>");
        this.backingDev = str;
    }
}
