package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.o;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f45829h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f45830i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f45832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f45833g;

    public static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f45834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f45835f;

        public b() {
            super(2);
            this.f45834e = 0;
            this.f45835f = 0;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.o.a
        public o e() {
            return new d(this);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.o.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public b f() {
            return this;
        }

        public b m(int i10) {
            this.f45834e = i10;
            return this;
        }

        public b n(int i10) {
            this.f45835f = i10;
            return this;
        }
    }

    public d(b bVar) {
        super(bVar);
        this.f45831e = 0;
        this.f45832f = bVar.f45834e;
        this.f45833g = bVar.f45835f;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.o
    public byte[] e() {
        byte[] bArrE = super.e();
        org.bouncycastle.util.o.h(this.f45831e, bArrE, 16);
        org.bouncycastle.util.o.h(this.f45832f, bArrE, 20);
        org.bouncycastle.util.o.h(this.f45833g, bArrE, 24);
        return bArrE;
    }

    public int f() {
        return this.f45831e;
    }

    public int g() {
        return this.f45832f;
    }

    public int h() {
        return this.f45833g;
    }
}
