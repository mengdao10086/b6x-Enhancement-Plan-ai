package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f45921a;

    public l(j jVar, byte[][] bArr) {
        Objects.requireNonNull(jVar, "params == null");
        Objects.requireNonNull(bArr, "publicKey == null");
        if (k0.m(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        }
        if (bArr.length != jVar.a()) {
            throw new IllegalArgumentException("wrong publicKey size");
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2.length != jVar.f()) {
                throw new IllegalArgumentException("wrong publicKey format");
            }
        }
        this.f45921a = k0.e(bArr);
    }

    public byte[][] a() {
        return k0.e(this.f45921a);
    }
}
