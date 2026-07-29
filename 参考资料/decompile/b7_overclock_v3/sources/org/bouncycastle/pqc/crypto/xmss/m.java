package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[][] f45922a;

    public m(j jVar, byte[][] bArr) {
        Objects.requireNonNull(jVar, "params == null");
        Objects.requireNonNull(bArr, "signature == null");
        if (k0.m(bArr)) {
            throw new NullPointerException("signature byte array == null");
        }
        if (bArr.length != jVar.a()) {
            throw new IllegalArgumentException("wrong signature size");
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2.length != jVar.f()) {
                throw new IllegalArgumentException("wrong signature format");
            }
        }
        this.f45922a = k0.e(bArr);
    }

    public byte[][] a() {
        return k0.e(this.f45922a);
    }
}
