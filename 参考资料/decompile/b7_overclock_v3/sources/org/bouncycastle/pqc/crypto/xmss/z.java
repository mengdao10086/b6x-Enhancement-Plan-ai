package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g0;

/* JADX INFO: loaded from: classes6.dex */
public final class z implements j0, org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f45985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f45986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f45987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g0> f45988d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f45989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f45990b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f45991c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<g0> f45992d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f45993e = null;

        public b(w wVar) {
            this.f45989a = wVar;
        }

        public z f() {
            return new z(this);
        }

        public b g(long j10) {
            this.f45990b = j10;
            return this;
        }

        public b h(byte[] bArr) {
            this.f45991c = k0.d(bArr);
            return this;
        }

        public b i(List<g0> list) {
            this.f45992d = list;
            return this;
        }

        public b j(byte[] bArr) {
            this.f45993e = org.bouncycastle.util.a.p(bArr);
            return this;
        }
    }

    public z(b bVar) {
        w wVar = bVar.f45989a;
        this.f45985a = wVar;
        Objects.requireNonNull(wVar, "params == null");
        int iG = wVar.g();
        byte[] bArr = bVar.f45993e;
        if (bArr == null) {
            this.f45986b = bVar.f45990b;
            byte[] bArr2 = bVar.f45991c;
            if (bArr2 == null) {
                this.f45987c = new byte[iG];
            } else {
                if (bArr2.length != iG) {
                    throw new IllegalArgumentException("size of random needs to be equal to size of digest");
                }
                this.f45987c = bArr2;
            }
            List<g0> list = bVar.f45992d;
            this.f45988d = list == null ? new ArrayList<>() : list;
            return;
        }
        int iA = wVar.h().e().a();
        int iCeil = (int) Math.ceil(((double) wVar.a()) / 8.0d);
        int iA2 = ((wVar.a() / wVar.b()) + iA) * iG;
        if (bArr.length != iCeil + iG + (wVar.b() * iA2)) {
            throw new IllegalArgumentException("signature has wrong size");
        }
        long jB = k0.b(bArr, 0, iCeil);
        this.f45986b = jB;
        if (!k0.n(wVar.a(), jB)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        int i10 = iCeil + 0;
        this.f45987c = k0.i(bArr, i10, iG);
        this.f45988d = new ArrayList();
        for (int i11 = i10 + iG; i11 < bArr.length; i11 += iA2) {
            this.f45988d.add(new g0.a(this.f45985a.j()).g(k0.i(bArr, i11, iA2)).e());
        }
    }

    public long a() {
        return this.f45986b;
    }

    public byte[] b() {
        return k0.d(this.f45987c);
    }

    public List<g0> c() {
        return this.f45988d;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        int iG = this.f45985a.g();
        int iA = this.f45985a.h().e().a();
        int iCeil = (int) Math.ceil(((double) this.f45985a.a()) / 8.0d);
        int iA2 = ((this.f45985a.a() / this.f45985a.b()) + iA) * iG;
        byte[] bArr = new byte[iCeil + iG + (this.f45985a.b() * iA2)];
        k0.f(bArr, k0.t(this.f45986b, iCeil), 0);
        int i10 = iCeil + 0;
        k0.f(bArr, this.f45987c, i10);
        int i11 = i10 + iG;
        Iterator<g0> it2 = this.f45988d.iterator();
        while (it2.hasNext()) {
            k0.f(bArr, it2.next().toByteArray(), i11);
            i11 += iA2;
        }
        return bArr;
    }
}
