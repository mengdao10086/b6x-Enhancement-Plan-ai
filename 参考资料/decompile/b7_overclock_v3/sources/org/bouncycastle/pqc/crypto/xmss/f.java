package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.o;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f45862h = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f45864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f45865g;

    public static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f45866e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f45867f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f45868g;

        public b() {
            super(1);
            this.f45866e = 0;
            this.f45867f = 0;
            this.f45868g = 0;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.o.a
        public o e() {
            return new f(this);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.o.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b f() {
            return this;
        }

        public b n(int i10) {
            this.f45866e = i10;
            return this;
        }

        public b o(int i10) {
            this.f45867f = i10;
            return this;
        }

        public b p(int i10) {
            this.f45868g = i10;
            return this;
        }
    }

    public f(b bVar) {
        super(bVar);
        this.f45863e = bVar.f45866e;
        this.f45864f = bVar.f45867f;
        this.f45865g = bVar.f45868g;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.o
    public byte[] e() {
        byte[] bArrE = super.e();
        org.bouncycastle.util.o.h(this.f45863e, bArrE, 16);
        org.bouncycastle.util.o.h(this.f45864f, bArrE, 20);
        org.bouncycastle.util.o.h(this.f45865g, bArrE, 24);
        return bArrE;
    }

    public int f() {
        return this.f45863e;
    }

    public int g() {
        return this.f45864f;
    }

    public int h() {
        return this.f45865g;
    }
}
