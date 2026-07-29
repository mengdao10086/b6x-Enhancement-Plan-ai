package com.umeng.socialize;

/* JADX INFO: loaded from: classes5.dex */
public class SocializeException extends RuntimeException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f24497b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24498a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24499c;

    public SocializeException(int i10, String str) {
        super(str);
        this.f24498a = i10;
        this.f24499c = str;
    }

    public int getErrorCode() {
        return this.f24498a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f24499c;
    }

    public SocializeException(String str, Throwable th2) {
        super(str, th2);
        this.f24498a = 5000;
        this.f24499c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.f24498a = 5000;
        this.f24499c = str;
    }
}
