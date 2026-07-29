package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class y extends v implements j0, org.bouncycastle.util.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f45977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f45979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f45980f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f45981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f45982b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f45983c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f45984d = null;

        public b(w wVar) {
            this.f45981a = wVar;
        }

        public y e() {
            return new y(this);
        }

        public b f(byte[] bArr) {
            this.f45984d = k0.d(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f45983c = k0.d(bArr);
            return this;
        }

        public b h(byte[] bArr) {
            this.f45982b = k0.d(bArr);
            return this;
        }
    }

    public y(b bVar) {
        super(false, bVar.f45981a.e());
        w wVar = bVar.f45981a;
        this.f45977c = wVar;
        Objects.requireNonNull(wVar, "params == null");
        int iG = wVar.g();
        byte[] bArr = bVar.f45984d;
        if (bArr != null) {
            if (bArr.length == iG + iG) {
                this.f45978d = 0;
                this.f45979e = k0.i(bArr, 0, iG);
                this.f45980f = k0.i(bArr, iG + 0, iG);
                return;
            } else {
                if (bArr.length != iG + 4 + iG) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f45978d = org.bouncycastle.util.o.a(bArr, 0);
                this.f45979e = k0.i(bArr, 4, iG);
                this.f45980f = k0.i(bArr, 4 + iG, iG);
                return;
            }
        }
        if (wVar.d() != null) {
            this.f45978d = wVar.d().a();
        } else {
            this.f45978d = 0;
        }
        byte[] bArr2 = bVar.f45982b;
        if (bArr2 == null) {
            this.f45979e = new byte[iG];
        } else {
            if (bArr2.length != iG) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f45979e = bArr2;
        }
        byte[] bArr3 = bVar.f45983c;
        if (bArr3 == null) {
            this.f45980f = new byte[iG];
        } else {
            if (bArr3.length != iG) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f45980f = bArr3;
        }
    }

    public w e() {
        return this.f45977c;
    }

    public byte[] f() {
        return k0.d(this.f45980f);
    }

    public byte[] g() {
        return k0.d(this.f45979e);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        byte[] bArr;
        int iG = this.f45977c.g();
        int i10 = this.f45978d;
        int i11 = 0;
        if (i10 != 0) {
            bArr = new byte[iG + 4 + iG];
            org.bouncycastle.util.o.h(i10, bArr, 0);
            i11 = 4;
        } else {
            bArr = new byte[iG + iG];
        }
        k0.f(bArr, this.f45979e, i11);
        k0.f(bArr, this.f45980f, i11 + iG);
        return bArr;
    }
}
