package wr;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import jn.b;
import org.bouncycastle.jcajce.util.c;
import org.bouncycastle.jcajce.util.d;
import org.bouncycastle.jcajce.util.g;
import org.bouncycastle.jcajce.util.i;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class a extends vr.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f54797b;

    public a(b bVar, d dVar) {
        super(bVar);
        new c();
        this.f54797b = dVar;
    }

    public a(byte[] bArr) {
        super(bArr);
        this.f54797b = new c();
    }

    public PublicKey j() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        try {
            c1 c1VarA = this.f53360a.y().A();
            return this.f54797b.b(c1VarA.x().x().L()).generatePublic(new X509EncodedKeySpec(c1VarA.getEncoded()));
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }

    public a k(String str) {
        return new a(this.f53360a, new g(str));
    }

    public a l(Provider provider) {
        return new a(this.f53360a, new i(provider));
    }
}
