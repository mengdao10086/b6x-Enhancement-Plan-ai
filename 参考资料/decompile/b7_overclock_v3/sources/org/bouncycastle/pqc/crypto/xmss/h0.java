package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g0;

/* JADX INFO: loaded from: classes6.dex */
public final class h0 extends g0 implements j0, org.bouncycastle.util.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f45896e;

    public static class b extends g0.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d0 f45897e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f45898f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f45899g;

        public b(d0 d0Var) {
            super(d0Var);
            this.f45898f = 0;
            this.f45899g = null;
            this.f45897e = d0Var;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.g0.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public h0 e() {
            return new h0(this);
        }

        public b l(int i10) {
            this.f45898f = i10;
            return this;
        }

        public b m(byte[] bArr) {
            this.f45899g = k0.d(bArr);
            return this;
        }

        public b n(byte[] bArr) {
            Objects.requireNonNull(bArr, "signature == null");
            int iH = this.f45897e.h();
            int iA = this.f45897e.i().e().a();
            int iB = this.f45897e.b() * iH;
            this.f45898f = org.bouncycastle.util.o.a(bArr, 0);
            this.f45899g = k0.i(bArr, 4, iH);
            g(k0.i(bArr, 4 + iH, (iA * iH) + iB));
            return this;
        }
    }

    public h0(b bVar) {
        super(bVar);
        this.f45895d = bVar.f45898f;
        int iH = b().h();
        byte[] bArr = bVar.f45899g;
        if (bArr == null) {
            this.f45896e = new byte[iH];
        } else {
            if (bArr.length != iH) {
                throw new IllegalArgumentException("size of random needs to be equal to size of digest");
            }
            this.f45896e = bArr;
        }
    }

    public int d() {
        return this.f45895d;
    }

    public byte[] e() {
        return k0.d(this.f45896e);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.g0, org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        int iH = b().h();
        byte[] bArr = new byte[iH + 4 + (b().i().e().a() * iH) + (b().b() * iH)];
        org.bouncycastle.util.o.h(this.f45895d, bArr, 0);
        k0.f(bArr, this.f45896e, 4);
        int i10 = 4 + iH;
        for (byte[] bArr2 : c().a()) {
            k0.f(bArr, bArr2, i10);
            i10 += iH;
        }
        for (int i11 = 0; i11 < a().size(); i11++) {
            k0.f(bArr, a().get(i11).b(), i10);
            i10 += iH;
        }
        return bArr;
    }
}
