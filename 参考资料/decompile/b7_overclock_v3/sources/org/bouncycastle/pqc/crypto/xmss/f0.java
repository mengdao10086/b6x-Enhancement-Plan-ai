package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class f0 extends r implements j0, org.bouncycastle.util.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d0 f45869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f45870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f45871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f45872j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f45873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f45874b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f45875c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f45876d = null;

        public b(d0 d0Var) {
            this.f45873a = d0Var;
        }

        public f0 e() {
            return new f0(this);
        }

        public b f(byte[] bArr) {
            this.f45876d = k0.d(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f45875c = k0.d(bArr);
            return this;
        }

        public b h(byte[] bArr) {
            this.f45874b = k0.d(bArr);
            return this;
        }
    }

    public f0(b bVar) {
        super(false, bVar.f45873a.f());
        d0 d0Var = bVar.f45873a;
        this.f45869g = d0Var;
        Objects.requireNonNull(d0Var, "params == null");
        int iH = d0Var.h();
        byte[] bArr = bVar.f45876d;
        if (bArr != null) {
            if (bArr.length == iH + iH) {
                this.f45870h = 0;
                this.f45871i = k0.i(bArr, 0, iH);
                this.f45872j = k0.i(bArr, iH + 0, iH);
                return;
            } else {
                if (bArr.length != iH + 4 + iH) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f45870h = org.bouncycastle.util.o.a(bArr, 0);
                this.f45871i = k0.i(bArr, 4, iH);
                this.f45872j = k0.i(bArr, 4 + iH, iH);
                return;
            }
        }
        if (d0Var.e() != null) {
            this.f45870h = d0Var.e().a();
        } else {
            this.f45870h = 0;
        }
        byte[] bArr2 = bVar.f45874b;
        if (bArr2 == null) {
            this.f45871i = new byte[iH];
        } else {
            if (bArr2.length != iH) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f45871i = bArr2;
        }
        byte[] bArr3 = bVar.f45875c;
        if (bArr3 == null) {
            this.f45872j = new byte[iH];
        } else {
            if (bArr3.length != iH) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f45872j = bArr3;
        }
    }

    public d0 e() {
        return this.f45869g;
    }

    public byte[] f() {
        return k0.d(this.f45872j);
    }

    public byte[] g() {
        return k0.d(this.f45871i);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        byte[] bArr;
        int iH = this.f45869g.h();
        int i10 = this.f45870h;
        int i11 = 0;
        if (i10 != 0) {
            bArr = new byte[iH + 4 + iH];
            org.bouncycastle.util.o.h(i10, bArr, 0);
            i11 = 4;
        } else {
            bArr = new byte[iH + iH];
        }
        k0.f(bArr, this.f45871i, i11);
        k0.f(bArr, this.f45872j, i11 + iH);
        return bArr;
    }
}
