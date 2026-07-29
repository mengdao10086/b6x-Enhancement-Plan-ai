package org.bouncycastle.crypto.util;

/* JADX INFO: loaded from: classes5.dex */
public class q extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f44762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f44763e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f44765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f44766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f44767d = 16;

        public b(int i10, int i11, int i12) {
            if (i10 <= 1 || !f(i10)) {
                throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
            }
            this.f44764a = i10;
            this.f44765b = i11;
            this.f44766c = i12;
        }

        public static boolean f(int i10) {
            return (i10 & (i10 + (-1))) == 0;
        }

        public q e() {
            return new q(this);
        }

        public b g(int i10) {
            this.f44767d = i10;
            return this;
        }
    }

    public q(b bVar) {
        super(in.c.M);
        this.f44760b = bVar.f44764a;
        this.f44761c = bVar.f44765b;
        this.f44762d = bVar.f44766c;
        this.f44763e = bVar.f44767d;
    }

    public int b() {
        return this.f44761c;
    }

    public int c() {
        return this.f44760b;
    }

    public int d() {
        return this.f44762d;
    }

    public int e() {
        return this.f44763e;
    }
}
