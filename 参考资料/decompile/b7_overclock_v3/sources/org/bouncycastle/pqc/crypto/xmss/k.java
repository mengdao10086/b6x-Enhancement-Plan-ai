package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f45917a;

    public k(j jVar, byte[][] bArr) {
        Objects.requireNonNull(jVar, "params == null");
        Objects.requireNonNull(bArr, "privateKey == null");
        if (k0.m(bArr)) {
            throw new NullPointerException("privateKey byte array == null");
        }
        if (bArr.length != jVar.a()) {
            throw new IllegalArgumentException("wrong privateKey format");
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2.length != jVar.f()) {
                throw new IllegalArgumentException("wrong privateKey format");
            }
        }
        this.f45917a = k0.e(bArr);
    }

    public byte[][] a() {
        return k0.e(this.f45917a);
    }
}
