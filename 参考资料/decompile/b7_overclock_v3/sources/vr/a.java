package vr;

import cs.h;
import gm.c0;
import gm.j;
import gm.u1;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import jn.b;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.g;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f53360a;

    public a(b bVar) {
        this.f53360a = bVar;
    }

    public a(byte[] bArr) {
        this.f53360a = b.x(bArr);
    }

    public String a() {
        return this.f53360a.y().x().d();
    }

    public PublicKey b(String str) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        c1 c1VarA = this.f53360a.y().A();
        try {
            return KeyFactory.getInstance(c1VarA.x().x().L(), str).generatePublic(new X509EncodedKeySpec(new u1(c1VarA).L()));
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }

    public jn.a c() {
        return this.f53360a.y();
    }

    public c1 d() {
        return this.f53360a.y().A();
    }

    public boolean e(h hVar) throws OperatorCreationException, IOException {
        cs.g gVarA = hVar.a(this.f53360a.A());
        OutputStream outputStreamB = gVarA.b();
        this.f53360a.y().u(outputStreamB, j.f29713a);
        outputStreamB.close();
        return gVarA.verify(this.f53360a.z().L());
    }

    public c0 f() {
        return this.f53360a.b();
    }

    public b g() {
        return this.f53360a;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return g().getEncoded();
    }

    public boolean h() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        return i(null);
    }

    public boolean i(String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        String strL = this.f53360a.A().x().L();
        Signature signature = str == null ? Signature.getInstance(strL) : Signature.getInstance(strL, str);
        signature.initVerify(b(str));
        try {
            signature.update(this.f53360a.y().getEncoded());
            return signature.verify(this.f53360a.z().H());
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }
}
