package hq;

import cs.o;
import gm.y;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import org.bouncycastle.jcajce.util.g;
import org.bouncycastle.jcajce.util.i;

/* JADX INFO: loaded from: classes5.dex */
public class a implements iq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECPrivateKey f31398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fq.a f31399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f31400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f31401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f31402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f31403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f31404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f31405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f31406i;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.bouncycastle.jcajce.util.d f31407a = new org.bouncycastle.jcajce.util.c();

        /* JADX WARN: Multi-variable type inference failed */
        public a a(PrivateKey privateKey) {
            return new a((ECPrivateKey) privateKey, null, this.f31407a);
        }

        public a b(PrivateKey privateKey, fq.a aVar) {
            return new a((ECPrivateKey) privateKey, aVar, this.f31407a);
        }

        public b c(String str) {
            this.f31407a = new g(str);
            return this;
        }

        public b d(Provider provider) {
            this.f31407a = new i(provider);
            return this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(java.security.interfaces.ECPrivateKey r3, fq.a r4, org.bouncycastle.jcajce.util.d r5) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq.a.<init>(java.security.interfaces.ECPrivateKey, fq.a, org.bouncycastle.jcajce.util.d):void");
    }

    @Override // iq.b
    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f31404g);
    }

    @Override // iq.b
    public OutputStream b() {
        return this.f31401d.b();
    }

    @Override // iq.b
    public fq.a c() {
        return this.f31399b;
    }

    @Override // iq.b
    public boolean d() {
        return this.f31402e == null;
    }

    @Override // iq.b
    public zn.b e() {
        return this.f31400c;
    }

    @Override // iq.b
    public byte[] getSignature() {
        byte[] bArrC = this.f31401d.c();
        try {
            Signature signatureA = this.f31406i.a(this.f31405h);
            signatureA.initSign(this.f31398a);
            signatureA.update(bArrC, 0, bArrC.length);
            signatureA.update(this.f31401d.c());
            return signatureA.sign();
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }
}
