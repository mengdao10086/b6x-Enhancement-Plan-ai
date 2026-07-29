package com.tencent.open.utils;

/* JADX INFO: loaded from: classes5.dex */
public final class m implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22836a;

    public m(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i10 = this.f22836a;
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 & 65280) >> 8)};
    }

    public int b() {
        return this.f22836a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof m) && this.f22836a == ((m) obj).b();
    }

    public int hashCode() {
        return this.f22836a;
    }

    public m(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 1] << 8) & 65280;
        this.f22836a = i11;
        this.f22836a = i11 + (bArr[i10] & 255);
    }

    public m(int i10) {
        this.f22836a = i10;
    }
}
