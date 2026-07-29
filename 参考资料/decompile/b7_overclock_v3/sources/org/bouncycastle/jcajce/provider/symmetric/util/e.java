package org.bouncycastle.jcajce.provider.symmetric.util;

import gm.y;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.jcajce.provider.symmetric.util.d;

/* JADX INFO: loaded from: classes5.dex */
public class e extends ar.d implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f45246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f45248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f45249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f45250g;

    public e(String str, y yVar, boolean z10, int i10, int i11, int i12, int i13) {
        super(str, yVar);
        this.f45246c = z10;
        this.f45247d = i10;
        this.f45248e = i11;
        this.f45249f = i12;
        this.f45250g = i13;
    }

    @Override // ar.d, javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PBEKeySpec)) {
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
        PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
        if (pBEKeySpec.getSalt() == null) {
            return new BCPBEKey(this.f8862a, this.f8863b, this.f45247d, this.f45248e, this.f45249f, this.f45250g, pBEKeySpec, null);
        }
        return new BCPBEKey(this.f8862a, this.f8863b, this.f45247d, this.f45248e, this.f45249f, this.f45250g, pBEKeySpec, this.f45246c ? d.a.f(pBEKeySpec, this.f45247d, this.f45248e, this.f45249f, this.f45250g) : d.a.d(pBEKeySpec, this.f45247d, this.f45248e, this.f45249f));
    }
}
