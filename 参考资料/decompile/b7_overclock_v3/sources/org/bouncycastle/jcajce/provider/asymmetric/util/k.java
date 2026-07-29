package org.bouncycastle.jcajce.provider.asymmetric.util;

import gr.r;

/* JADX INFO: loaded from: classes7.dex */
public class k {
    public static r a(org.bouncycastle.crypto.h hVar, byte[] bArr) {
        if (hVar == null) {
            return new r(null, null, 128);
        }
        org.bouncycastle.crypto.f fVarD = hVar.d();
        return (fVarD.b().equals("DES") || fVarD.b().equals("RC2") || fVarD.b().equals("RC5-32") || fVarD.b().equals("RC5-64")) ? new r(null, null, 64, 64, bArr) : fVarD.b().equals("SKIPJACK") ? new r(null, null, 80, 80, bArr) : fVarD.b().equals("GOST28147") ? new r(null, null, 256, 256, bArr) : new r(null, null, 128, 128, bArr);
    }
}
