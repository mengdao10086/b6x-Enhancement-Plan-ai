package org.bouncycastle.pqc.crypto.xmss;

/* JADX INFO: loaded from: classes6.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f45929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45931d;

    public static abstract class a<T extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f45933b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f45934c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f45935d = 0;

        public a(int i10) {
            this.f45932a = i10;
        }

        public abstract o e();

        public abstract T f();

        public T g(int i10) {
            this.f45935d = i10;
            return (T) f();
        }

        public T h(int i10) {
            this.f45933b = i10;
            return (T) f();
        }

        public T i(long j10) {
            this.f45934c = j10;
            return (T) f();
        }
    }

    public o(a aVar) {
        this.f45928a = aVar.f45933b;
        this.f45929b = aVar.f45934c;
        this.f45930c = aVar.f45932a;
        this.f45931d = aVar.f45935d;
    }

    public final int a() {
        return this.f45931d;
    }

    public final int b() {
        return this.f45928a;
    }

    public final long c() {
        return this.f45929b;
    }

    public final int d() {
        return this.f45930c;
    }

    public byte[] e() {
        byte[] bArr = new byte[32];
        org.bouncycastle.util.o.h(this.f45928a, bArr, 0);
        org.bouncycastle.util.o.z(this.f45929b, bArr, 4);
        org.bouncycastle.util.o.h(this.f45930c, bArr, 12);
        org.bouncycastle.util.o.h(this.f45931d, bArr, 28);
        return bArr;
    }
}
