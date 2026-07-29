package com.bumptech.glide.load;

import g.p0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12165a = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i10) {
        this("Http request failed", i10);
    }

    public int a() {
        return this.statusCode;
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i10) {
        this(str, i10, null);
    }

    public HttpException(String str, int i10, @p0 Throwable th2) {
        super(str + ", status code: " + i10, th2);
        this.statusCode = i10;
    }
}
