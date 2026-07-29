package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.i;
import org.bouncycastle.util.a;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF2Key implements PBKDFKey {
    private final i converter;
    private final char[] password;

    public PBKDF2Key(char[] cArr, i iVar) {
        this.password = a.r(cArr);
        this.converter = iVar;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.converter.convert(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.converter.getType();
    }

    public char[] getPassword() {
        return this.password;
    }
}
