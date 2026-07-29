package com.umeng.analytics.pro;

/* JADX INFO: loaded from: classes5.dex */
public final class ci extends cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f23466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23468c;

    public ci() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.cj
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cj
    public void b() throws ck {
    }

    @Override // com.umeng.analytics.pro.cj
    public void b(byte[] bArr, int i10, int i11) throws ck {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.cj
    public void c() {
    }

    public void c(byte[] bArr, int i10, int i11) {
        this.f23466a = bArr;
        this.f23467b = i10;
        this.f23468c = i10 + i11;
    }

    public void e() {
        this.f23466a = null;
    }

    @Override // com.umeng.analytics.pro.cj
    public byte[] f() {
        return this.f23466a;
    }

    @Override // com.umeng.analytics.pro.cj
    public int g() {
        return this.f23467b;
    }

    @Override // com.umeng.analytics.pro.cj
    public int h() {
        return this.f23468c - this.f23467b;
    }

    public ci(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.cj
    public int a(byte[] bArr, int i10, int i11) throws ck {
        int iH = h();
        if (i11 > iH) {
            i11 = iH;
        }
        if (i11 > 0) {
            System.arraycopy(this.f23466a, this.f23467b, bArr, i10, i11);
            a(i11);
        }
        return i11;
    }

    public ci(byte[] bArr, int i10, int i11) {
        c(bArr, i10, i11);
    }

    @Override // com.umeng.analytics.pro.cj
    public void a(int i10) {
        this.f23467b += i10;
    }
}
