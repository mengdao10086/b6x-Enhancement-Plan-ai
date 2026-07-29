package com.arialyy.aria.core.inf;

/* JADX INFO: loaded from: classes2.dex */
public enum ReceiverType {
    DOWNLOAD(1, "download"),
    UPLOAD(2, "upload");

    public String name;
    public int type;

    ReceiverType(int i10, String str) {
        this.type = i10;
        this.name = str;
    }
}
