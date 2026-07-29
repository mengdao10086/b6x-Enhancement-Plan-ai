package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.crypto.i;
import org.bouncycastle.util.a;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF2KeyWithParameters extends PBKDF2Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PBKDF2KeyWithParameters(char[] cArr, i iVar, byte[] bArr, int i10) {
        super(cArr, iVar);
        this.salt = a.p(bArr);
        this.iterationCount = i10;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.salt;
    }
}
