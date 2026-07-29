package org.bouncycastle.util;

import zo.i0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static char[] f46042b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f46043a;

    public h(byte[] bArr) {
        this(bArr, 160);
    }

    public h(byte[] bArr, int i10) {
        this.f46043a = b(bArr, i10);
    }

    public h(byte[] bArr, boolean z10) {
        if (z10) {
            this.f46043a = c(bArr);
        } else {
            this.f46043a = a(bArr);
        }
    }

    public static byte[] a(byte[] bArr) {
        return b(bArr, 160);
    }

    public static byte[] b(byte[] bArr, int i10) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be a multiple of 8");
        }
        j0 j0Var = new j0(256);
        j0Var.update(bArr, 0, bArr.length);
        int i11 = i10 / 8;
        byte[] bArr2 = new byte[i11];
        j0Var.f(bArr2, 0, i11);
        return bArr2;
    }

    public static byte[] c(byte[] bArr) {
        i0 i0Var = new i0(160);
        i0Var.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[i0Var.h()];
        i0Var.c(bArr2, 0);
        return bArr2;
    }

    public byte[] d() {
        return a.p(this.f46043a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            return a.g(((h) obj).f46043a, this.f46043a);
        }
        return false;
    }

    public int hashCode() {
        return a.s0(this.f46043a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 != this.f46043a.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(":");
            }
            stringBuffer.append(f46042b[(this.f46043a[i10] >>> 4) & 15]);
            stringBuffer.append(f46042b[this.f46043a[i10] & 15]);
        }
        return stringBuffer.toString();
    }
}
