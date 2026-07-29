package com.google.zxing.qrcode.encoder;

import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f21666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21668c;

    public b(int i10, int i11) {
        this.f21666a = (byte[][]) Array.newInstance((Class<?>) byte.class, i11, i10);
        this.f21667b = i10;
        this.f21668c = i11;
    }

    public void a(byte b10) {
        for (byte[] bArr : this.f21666a) {
            Arrays.fill(bArr, b10);
        }
    }

    public byte b(int i10, int i11) {
        return this.f21666a[i11][i10];
    }

    public byte[][] c() {
        return this.f21666a;
    }

    public int d() {
        return this.f21668c;
    }

    public int e() {
        return this.f21667b;
    }

    public void f(int i10, int i11, byte b10) {
        this.f21666a[i11][i10] = b10;
    }

    public void g(int i10, int i11, int i12) {
        this.f21666a[i11][i10] = (byte) i12;
    }

    public void h(int i10, int i11, boolean z10) {
        this.f21666a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f21667b * 2 * this.f21668c) + 2);
        for (int i10 = 0; i10 < this.f21668c; i10++) {
            byte[] bArr = this.f21666a[i10];
            for (int i11 = 0; i11 < this.f21667b; i11++) {
                byte b10 = bArr[i11];
                if (b10 == 0) {
                    sb2.append(" 0");
                } else if (b10 != 1) {
                    sb2.append(GlideException.a.f12263d);
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
