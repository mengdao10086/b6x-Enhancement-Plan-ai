package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class n implements org.bouncycastle.crypto.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f45765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f45766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LMSigParameters f45767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[][] f45768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f45769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f45770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public x[] f45771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile org.bouncycastle.crypto.s f45772h;

    public n(j jVar, LMSigParameters lMSigParameters, org.bouncycastle.crypto.s sVar, byte[] bArr, byte[][] bArr2) {
        this.f45766b = jVar;
        this.f45767c = lMSigParameters;
        this.f45772h = sVar;
        this.f45765a = bArr;
        this.f45768d = bArr2;
        this.f45769e = null;
        this.f45770f = null;
    }

    public n(k kVar, Object obj, org.bouncycastle.crypto.s sVar) {
        this.f45769e = kVar;
        this.f45770f = obj;
        this.f45772h = sVar;
        this.f45765a = null;
        this.f45766b = null;
        this.f45767c = null;
        this.f45768d = null;
    }

    public byte[] a() {
        return this.f45765a;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return this.f45772h.b();
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        return this.f45772h.c(bArr, i10);
    }

    public byte[][] d() {
        return this.f45768d;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f45772h.h();
    }

    public j i() {
        return this.f45766b;
    }

    public k j() {
        return this.f45769e;
    }

    public byte[] k() {
        byte[] bArr = new byte[34];
        this.f45772h.c(bArr, 0);
        this.f45772h = null;
        return bArr;
    }

    public LMSigParameters l() {
        return this.f45767c;
    }

    public Object m() {
        return this.f45770f;
    }

    public x[] n() {
        return this.f45771g;
    }

    public n o(x[] xVarArr) {
        this.f45771g = xVarArr;
        return this;
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f45772h.reset();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        this.f45772h.update(b10);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        this.f45772h.update(bArr, i10, i11);
    }
}
