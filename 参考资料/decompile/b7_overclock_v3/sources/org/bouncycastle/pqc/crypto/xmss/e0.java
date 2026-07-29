package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: loaded from: classes6.dex */
public final class e0 extends r implements j0, org.bouncycastle.util.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d0 f45847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f45848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f45849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f45850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f45851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile BDS f45852l;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f45853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f45854b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f45855c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f45856d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f45857e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f45858f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f45859g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BDS f45860h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f45861i = null;

        public b(d0 d0Var) {
            this.f45853a = d0Var;
        }

        public e0 j() {
            return new e0(this);
        }

        public b k(BDS bds) {
            this.f45860h = bds;
            return this;
        }

        public b l(int i10) {
            this.f45854b = i10;
            return this;
        }

        public b m(int i10) {
            this.f45855c = i10;
            return this;
        }

        public b n(byte[] bArr) {
            this.f45861i = k0.d(bArr);
            return this;
        }

        public b o(byte[] bArr) {
            this.f45858f = k0.d(bArr);
            return this;
        }

        public b p(byte[] bArr) {
            this.f45859g = k0.d(bArr);
            return this;
        }

        public b q(byte[] bArr) {
            this.f45857e = k0.d(bArr);
            return this;
        }

        public b r(byte[] bArr) {
            this.f45856d = k0.d(bArr);
            return this;
        }
    }

    public e0(b bVar) {
        super(true, bVar.f45853a.f());
        d0 d0Var = bVar.f45853a;
        this.f45847g = d0Var;
        Objects.requireNonNull(d0Var, "params == null");
        int iH = d0Var.h();
        byte[] bArr = bVar.f45861i;
        if (bArr != null) {
            int iB = d0Var.b();
            int iA = org.bouncycastle.util.o.a(bArr, 0);
            if (!k0.n(iB, iA)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.f45848h = k0.i(bArr, 4, iH);
            int i10 = 4 + iH;
            this.f45849i = k0.i(bArr, i10, iH);
            int i11 = i10 + iH;
            this.f45850j = k0.i(bArr, i11, iH);
            int i12 = i11 + iH;
            this.f45851k = k0.i(bArr, i12, iH);
            int i13 = i12 + iH;
            try {
                BDS bds = (BDS) k0.g(k0.i(bArr, i13, bArr.length - i13), BDS.class);
                if (bds.c() != iA) {
                    throw new IllegalStateException("serialized BDS has wrong index");
                }
                this.f45852l = bds.q(bVar.f45853a.g());
                return;
            } catch (IOException e10) {
                throw new IllegalArgumentException(e10.getMessage(), e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalArgumentException(e11.getMessage(), e11);
            }
        }
        byte[] bArr2 = bVar.f45856d;
        if (bArr2 == null) {
            this.f45848h = new byte[iH];
        } else {
            if (bArr2.length != iH) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f45848h = bArr2;
        }
        byte[] bArr3 = bVar.f45857e;
        if (bArr3 == null) {
            this.f45849i = new byte[iH];
        } else {
            if (bArr3.length != iH) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f45849i = bArr3;
        }
        byte[] bArr4 = bVar.f45858f;
        if (bArr4 == null) {
            this.f45850j = new byte[iH];
        } else {
            if (bArr4.length != iH) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f45850j = bArr4;
        }
        byte[] bArr5 = bVar.f45859g;
        if (bArr5 == null) {
            this.f45851k = new byte[iH];
        } else {
            if (bArr5.length != iH) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f45851k = bArr5;
        }
        BDS bds2 = bVar.f45860h;
        this.f45852l = bds2 == null ? (bVar.f45854b >= (1 << d0Var.b()) + (-2) || bArr4 == null || bArr2 == null) ? new BDS(d0Var, (1 << d0Var.b()) - 1, bVar.f45854b) : new BDS(d0Var, bArr4, bArr2, (g) new g.b().e(), bVar.f45854b) : bds2;
        if (bVar.f45855c >= 0 && bVar.f45855c != this.f45852l.d()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public long V() {
        long jD;
        synchronized (this) {
            jD = (this.f45852l.d() - g()) + 1;
        }
        return jD;
    }

    public e0 e(int i10) {
        e0 e0VarJ;
        if (i10 < 1) {
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (this) {
            long j10 = i10;
            if (j10 > V()) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
            e0VarJ = new b(this.f45847g).r(this.f45848h).q(this.f45849i).o(this.f45850j).p(this.f45851k).l(g()).k(this.f45852l.p((this.f45852l.c() + i10) - 1, this.f45847g.g())).j();
            if (j10 == V()) {
                this.f45852l = new BDS(this.f45847g, this.f45852l.d(), g() + i10);
            } else {
                g gVar = (g) new g.b().e();
                for (int i11 = 0; i11 != i10; i11++) {
                    this.f45852l = this.f45852l.f(this.f45850j, this.f45848h, gVar);
                }
            }
        }
        return e0VarJ;
    }

    public BDS f() {
        return this.f45852l;
    }

    public int g() {
        return this.f45852l.c();
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public e0 h() {
        e0 e0VarE;
        synchronized (this) {
            e0VarE = e(1);
        }
        return e0VarE;
    }

    public d0 i() {
        return this.f45847g;
    }

    public byte[] j() {
        return k0.d(this.f45850j);
    }

    public byte[] k() {
        return k0.d(this.f45851k);
    }

    public byte[] l() {
        return k0.d(this.f45849i);
    }

    public byte[] m() {
        return k0.d(this.f45848h);
    }

    public e0 n() {
        synchronized (this) {
            this.f45852l = this.f45852l.c() < this.f45852l.d() ? this.f45852l.f(this.f45850j, this.f45848h, (g) new g.b().e()) : new BDS(this.f45847g, this.f45852l.d(), this.f45852l.d() + 1);
        }
        return this;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        byte[] bArrB;
        synchronized (this) {
            int iH = this.f45847g.h();
            byte[] bArr = new byte[iH + 4 + iH + iH + iH];
            org.bouncycastle.util.o.h(this.f45852l.c(), bArr, 0);
            k0.f(bArr, this.f45848h, 4);
            int i10 = 4 + iH;
            k0.f(bArr, this.f45849i, i10);
            int i11 = i10 + iH;
            k0.f(bArr, this.f45850j, i11);
            k0.f(bArr, this.f45851k, i11 + iH);
            try {
                bArrB = org.bouncycastle.util.a.B(bArr, k0.s(this.f45852l));
            } catch (IOException e10) {
                throw new RuntimeException("error serializing bds state: " + e10.getMessage());
            }
        }
        return bArrB;
    }
}
