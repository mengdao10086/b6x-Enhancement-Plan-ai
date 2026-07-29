package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class x extends v implements j0, org.bouncycastle.util.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f45959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f45960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f45961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f45962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f45963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f45964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile BDSStateMap f45965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f45966j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f45967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f45968b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f45969c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f45970d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f45971e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f45972f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f45973g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BDSStateMap f45974h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f45975i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public d0 f45976j = null;

        public b(w wVar) {
            this.f45967a = wVar;
        }

        public x k() {
            return new x(this);
        }

        public b l(BDSStateMap bDSStateMap) {
            if (bDSStateMap.b() == 0) {
                this.f45974h = new BDSStateMap(bDSStateMap, (1 << this.f45967a.a()) - 1);
            } else {
                this.f45974h = bDSStateMap;
            }
            return this;
        }

        public b m(long j10) {
            this.f45968b = j10;
            return this;
        }

        public b n(long j10) {
            this.f45969c = j10;
            return this;
        }

        public b o(byte[] bArr) {
            this.f45975i = k0.d(bArr);
            this.f45976j = this.f45967a.j();
            return this;
        }

        public b p(byte[] bArr) {
            this.f45972f = k0.d(bArr);
            return this;
        }

        public b q(byte[] bArr) {
            this.f45973g = k0.d(bArr);
            return this;
        }

        public b r(byte[] bArr) {
            this.f45971e = k0.d(bArr);
            return this;
        }

        public b s(byte[] bArr) {
            this.f45970d = k0.d(bArr);
            return this;
        }
    }

    public x(b bVar) {
        super(true, bVar.f45967a.e());
        w wVar = bVar.f45967a;
        this.f45959c = wVar;
        Objects.requireNonNull(wVar, "params == null");
        int iG = wVar.g();
        byte[] bArr = bVar.f45975i;
        if (bArr != null) {
            Objects.requireNonNull(bVar.f45976j, "xmss == null");
            int iA = wVar.a();
            int i10 = (iA + 7) / 8;
            this.f45964h = k0.b(bArr, 0, i10);
            if (!k0.n(iA, this.f45964h)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            int i11 = i10 + 0;
            this.f45960d = k0.i(bArr, i11, iG);
            int i12 = i11 + iG;
            this.f45961e = k0.i(bArr, i12, iG);
            int i13 = i12 + iG;
            this.f45962f = k0.i(bArr, i13, iG);
            int i14 = i13 + iG;
            this.f45963g = k0.i(bArr, i14, iG);
            int i15 = i14 + iG;
            try {
                this.f45965i = ((BDSStateMap) k0.g(k0.i(bArr, i15, bArr.length - i15), BDSStateMap.class)).i(bVar.f45976j.g());
                return;
            } catch (IOException e10) {
                throw new IllegalArgumentException(e10.getMessage(), e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalArgumentException(e11.getMessage(), e11);
            }
        }
        this.f45964h = bVar.f45968b;
        byte[] bArr2 = bVar.f45970d;
        if (bArr2 == null) {
            this.f45960d = new byte[iG];
        } else {
            if (bArr2.length != iG) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f45960d = bArr2;
        }
        byte[] bArr3 = bVar.f45971e;
        if (bArr3 == null) {
            this.f45961e = new byte[iG];
        } else {
            if (bArr3.length != iG) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f45961e = bArr3;
        }
        byte[] bArr4 = bVar.f45972f;
        if (bArr4 == null) {
            this.f45962f = new byte[iG];
        } else {
            if (bArr4.length != iG) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f45962f = bArr4;
        }
        byte[] bArr5 = bVar.f45973g;
        if (bArr5 == null) {
            this.f45963g = new byte[iG];
        } else {
            if (bArr5.length != iG) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f45963g = bArr5;
        }
        BDSStateMap bDSStateMap = bVar.f45974h;
        if (bDSStateMap == null) {
            bDSStateMap = (!k0.n(wVar.a(), bVar.f45968b) || bArr4 == null || bArr2 == null) ? new BDSStateMap(bVar.f45969c + 1) : new BDSStateMap(wVar, bVar.f45968b, bArr4, bArr2);
        }
        this.f45965i = bDSStateMap;
        if (bVar.f45969c >= 0 && bVar.f45969c != this.f45965i.b()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public long V() {
        long jB;
        synchronized (this) {
            jB = (this.f45965i.b() - g()) + 1;
        }
        return jB;
    }

    public x e(int i10) {
        x xVarK;
        if (i10 < 1) {
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (this) {
            long j10 = i10;
            if (j10 > V()) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
            xVarK = new b(this.f45959c).s(this.f45960d).r(this.f45961e).p(this.f45962f).q(this.f45963g).m(g()).l(new BDSStateMap(this.f45965i, (g() + j10) - 1)).k();
            for (int i11 = 0; i11 != i10; i11++) {
                n();
            }
        }
        return xVarK;
    }

    public BDSStateMap f() {
        return this.f45965i;
    }

    public long g() {
        return this.f45964h;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public x h() {
        x xVarE;
        synchronized (this) {
            xVarE = e(1);
        }
        return xVarE;
    }

    public w i() {
        return this.f45959c;
    }

    public byte[] j() {
        return k0.d(this.f45962f);
    }

    public byte[] k() {
        return k0.d(this.f45963g);
    }

    public byte[] l() {
        return k0.d(this.f45961e);
    }

    public byte[] m() {
        return k0.d(this.f45960d);
    }

    public x n() {
        synchronized (this) {
            if (g() < this.f45965i.b()) {
                this.f45965i.h(this.f45959c, this.f45964h, this.f45962f, this.f45960d);
                this.f45964h++;
            } else {
                this.f45964h = this.f45965i.b() + 1;
                this.f45965i = new BDSStateMap(this.f45965i.b());
            }
            this.f45966j = false;
        }
        return this;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        byte[] bArrB;
        synchronized (this) {
            int iG = this.f45959c.g();
            int iA = (this.f45959c.a() + 7) / 8;
            byte[] bArr = new byte[iA + iG + iG + iG + iG];
            k0.f(bArr, k0.t(this.f45964h, iA), 0);
            int i10 = iA + 0;
            k0.f(bArr, this.f45960d, i10);
            int i11 = i10 + iG;
            k0.f(bArr, this.f45961e, i11);
            int i12 = i11 + iG;
            k0.f(bArr, this.f45962f, i12);
            k0.f(bArr, this.f45963g, i12 + iG);
            try {
                bArrB = org.bouncycastle.util.a.B(bArr, k0.s(this.f45965i));
            } catch (IOException e10) {
                throw new IllegalStateException("error serializing bds state: " + e10.getMessage(), e10);
            }
        }
        return bArrB;
    }
}
