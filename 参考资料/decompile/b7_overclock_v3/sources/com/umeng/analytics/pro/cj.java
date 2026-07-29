package com.umeng.analytics.pro;

/* JADX INFO: loaded from: classes5.dex */
public abstract class cj {
    public abstract int a(byte[] bArr, int i10, int i11) throws ck;

    public void a(int i10) {
    }

    public abstract boolean a();

    public abstract void b() throws ck;

    public void b(byte[] bArr) throws ck {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i10, int i11) throws ck;

    public abstract void c();

    public int d(byte[] bArr, int i10, int i11) throws ck {
        int i12 = 0;
        while (i12 < i11) {
            int iA = a(bArr, i10 + i12, i11 - i12);
            if (iA <= 0) {
                throw new ck("Cannot read. Remote side has closed. Tried to read " + i11 + " bytes, but only got " + i12 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i12 += iA;
        }
        return i12;
    }

    public void d() throws ck {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
