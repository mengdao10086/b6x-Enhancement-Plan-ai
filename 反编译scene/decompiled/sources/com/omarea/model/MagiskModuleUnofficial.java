package com.omarea.model;

import a.cy0;
import a.f92;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class MagiskModuleUnofficial extends cy0 implements Serializable {
    public long uploadTime;
    public String downloadUrl = "";
    public String detailUrl = "";
    public String detailContent = "";
    public String uid = "";

    public final String getDetailContent() {
        return this.detailContent;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getUid() {
        return this.uid;
    }

    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final void setDetailContent(String str) {
        f92.d(str, "<set-?>");
        this.detailContent = str;
    }

    public final void setDetailUrl(String str) {
        f92.d(str, "<set-?>");
        this.detailUrl = str;
    }

    public final void setDownloadUrl(String str) {
        f92.d(str, "<set-?>");
        this.downloadUrl = str;
    }

    public final void setUid(String str) {
        f92.d(str, "<set-?>");
        this.uid = str;
    }

    public final void setUploadTime(long j) {
        this.uploadTime = j;
    }
}
