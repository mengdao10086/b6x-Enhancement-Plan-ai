package com.efs.sdk.base.core.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f12884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12885c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12886d = "none";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12887e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12888f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12889g = 1;

    public a(String str, byte b10) {
        this.f12884b = (byte) 2;
        this.f12883a = str;
        if (b10 <= 0 || 3 < b10) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b10)));
        }
        this.f12884b = b10;
    }
}
