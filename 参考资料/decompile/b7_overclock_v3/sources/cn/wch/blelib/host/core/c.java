package cn.wch.blelib.host.core;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f11066e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11068b = 15000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11069c = 10;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f11070d = 1000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11071e = 1000;

        public b(String str) {
            this.f11067a = str;
        }

        public c c() {
            return new c(this);
        }

        public b d(long j10) {
            this.f11068b = j10;
            return this;
        }

        public b e(long j10) {
            this.f11070d = j10;
            return this;
        }

        public b f(long j10) {
            this.f11071e = j10;
            return this;
        }
    }

    public long a() {
        return this.f11063b;
    }

    public String b() {
        return this.f11062a;
    }

    public int c() {
        return this.f11064c;
    }

    public long d() {
        return this.f11065d;
    }

    public long e() {
        return this.f11066e;
    }

    public c(b bVar) {
        this.f11062a = bVar.f11067a;
        this.f11063b = bVar.f11068b;
        this.f11064c = 11;
        this.f11065d = bVar.f11070d;
        this.f11066e = bVar.f11071e;
    }
}
