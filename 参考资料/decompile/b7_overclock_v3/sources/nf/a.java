package nf;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b[] f42080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f42082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42083d;

    public a(int i10, int i11) {
        b[] bVarArr = new b[i10];
        this.f42080a = bVarArr;
        int length = bVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f42080a[i12] = new b(((i11 + 4) * 17) + 1);
        }
        this.f42083d = i11 * 17;
        this.f42082c = i10;
        this.f42081b = -1;
    }

    public b a() {
        return this.f42080a[this.f42081b];
    }

    public byte[][] b() {
        return c(1, 1);
    }

    public byte[][] c(int i10, int i11) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f42082c * i11, this.f42083d * i10);
        int i12 = this.f42082c * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f42080a[i13 / i11].b(i10);
        }
        return bArr;
    }

    public void d(int i10, int i11, byte b10) {
        this.f42080a[i11].c(i10, b10);
    }

    public void e() {
        this.f42081b++;
    }
}
