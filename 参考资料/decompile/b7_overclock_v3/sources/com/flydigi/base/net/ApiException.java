package com.flydigi.base.net;

/* JADX INFO: loaded from: classes2.dex */
public class ApiException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13376a = -101;
    private final int code;

    public ApiException(int i10, String str) {
        super(str);
        this.code = i10;
    }

    public int a() {
        return this.code;
    }
}
