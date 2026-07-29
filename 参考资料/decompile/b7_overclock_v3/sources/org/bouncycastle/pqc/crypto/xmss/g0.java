package org.bouncycastle.pqc.crypto.xmss;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class g0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f45884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f45885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<XMSSNode> f45886c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f45887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m f45888b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<XMSSNode> f45889c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f45890d = null;

        public a(d0 d0Var) {
            this.f45887a = d0Var;
        }

        public g0 e() {
            return new g0(this);
        }

        public a f(List<XMSSNode> list) {
            this.f45889c = list;
            return this;
        }

        public a g(byte[] bArr) {
            this.f45890d = k0.d(bArr);
            return this;
        }

        public a h(m mVar) {
            this.f45888b = mVar;
            return this;
        }
    }

    public g0(a aVar) {
        List<XMSSNode> arrayList;
        d0 d0Var = aVar.f45887a;
        this.f45884a = d0Var;
        Objects.requireNonNull(d0Var, "params == null");
        int iH = d0Var.h();
        int iA = d0Var.i().e().a();
        int iB = d0Var.b();
        byte[] bArr = aVar.f45890d;
        if (bArr == null) {
            m mVar = aVar.f45888b;
            this.f45885b = mVar == null ? new m(d0Var.i().e(), (byte[][]) Array.newInstance((Class<?>) byte.class, iA, iH)) : mVar;
            arrayList = aVar.f45889c;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            } else if (arrayList.size() != iB) {
                throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
            }
        } else {
            if (bArr.length != (iA * iH) + (iB * iH)) {
                throw new IllegalArgumentException("signature has wrong size");
            }
            byte[][] bArr2 = new byte[iA][];
            int i10 = 0;
            for (int i11 = 0; i11 < iA; i11++) {
                bArr2[i11] = k0.i(bArr, i10, iH);
                i10 += iH;
            }
            this.f45885b = new m(this.f45884a.i().e(), bArr2);
            arrayList = new ArrayList<>();
            for (int i12 = 0; i12 < iB; i12++) {
                arrayList.add(new XMSSNode(i12, k0.i(bArr, i10, iH)));
                i10 += iH;
            }
        }
        this.f45886c = arrayList;
    }

    public List<XMSSNode> a() {
        return this.f45886c;
    }

    public d0 b() {
        return this.f45884a;
    }

    public m c() {
        return this.f45885b;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.j0
    public byte[] toByteArray() {
        int iH = this.f45884a.h();
        byte[] bArr = new byte[(this.f45884a.i().e().a() * iH) + (this.f45884a.b() * iH)];
        int i10 = 0;
        for (byte[] bArr2 : this.f45885b.a()) {
            k0.f(bArr, bArr2, i10);
            i10 += iH;
        }
        for (int i11 = 0; i11 < this.f45886c.size(); i11++) {
            k0.f(bArr, this.f45886c.get(i11).b(), i10);
            i10 += iH;
        }
        return bArr;
    }
}
