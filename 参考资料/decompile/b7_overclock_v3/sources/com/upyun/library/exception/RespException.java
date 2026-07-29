package com.upyun.library.exception;

/* JADX INFO: loaded from: classes5.dex */
public class RespException extends UpYunException {
    private int code;

    public RespException(int i10, String str) {
        super(str);
        this.code = i10;
    }

    public int a() {
        return this.code;
    }
}
