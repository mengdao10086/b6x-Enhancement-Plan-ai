package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.o;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f45877h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f45879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f45880g;

    public static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f45881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f45882f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f45883g;

        public b() {
            super(0);
            this.f45881e = 0;
            this.f45882f = 0;
            this.f45883g = 0;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.o.a
        public o e() {
            return new g(this);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.o.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b f() {
            return this;
        }

        public b n(int i10) {
            this.f45882f = i10;
            return this;
        }

        public b o(int i10) {
            this.f45883g = i10;
            return this;
        }

        public b p(int i10) {
            this.f45881e = i10;
            return this;
        }
    }

    public g(b bVar) {
        super(bVar);
        this.f45878e = bVar.f45881e;
        this.f45879f = bVar.f45882f;
        this.f45880g = bVar.f45883g;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.o
    public byte[] e() {
        byte[] bArrE = super.e();
        org.bouncycastle.util.o.h(this.f45878e, bArrE, 16);
        org.bouncycastle.util.o.h(this.f45879f, bArrE, 20);
        org.bouncycastle.util.o.h(this.f45880g, bArrE, 24);
        return bArrE;
    }

    public int f() {
        return this.f45879f;
    }

    public int g() {
        return this.f45880g;
    }

    public int h() {
        return this.f45878e;
    }
}
