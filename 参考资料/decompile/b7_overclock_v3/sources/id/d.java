package id;

import g.i1;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f32159g = 15;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @i1
    public static final long f32160h = 1000000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f32164d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f32166f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f32161a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f32162b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f32165e = ya.g.f56663b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f32168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f32169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f32170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f32171e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f32172f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean[] f32173g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f32174h;

        public static int c(long j10) {
            return (int) (j10 % 15);
        }

        public long a() {
            long j10 = this.f32171e;
            if (j10 == 0) {
                return 0L;
            }
            return this.f32172f / j10;
        }

        public long b() {
            return this.f32172f;
        }

        public boolean d() {
            long j10 = this.f32170d;
            if (j10 == 0) {
                return false;
            }
            return this.f32173g[c(j10 - 1)];
        }

        public boolean e() {
            return this.f32170d > 15 && this.f32174h == 0;
        }

        public void f(long j10) {
            long j11 = this.f32170d;
            if (j11 == 0) {
                this.f32167a = j10;
            } else if (j11 == 1) {
                long j12 = j10 - this.f32167a;
                this.f32168b = j12;
                this.f32172f = j12;
                this.f32171e = 1L;
            } else {
                long j13 = j10 - this.f32169c;
                int iC = c(j11);
                if (Math.abs(j13 - this.f32168b) <= 1000000) {
                    this.f32171e++;
                    this.f32172f += j13;
                    boolean[] zArr = this.f32173g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f32174h--;
                    }
                } else {
                    boolean[] zArr2 = this.f32173g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f32174h++;
                    }
                }
            }
            this.f32170d++;
            this.f32169c = j10;
        }

        public void g() {
            this.f32170d = 0L;
            this.f32171e = 0L;
            this.f32172f = 0L;
            this.f32174h = 0;
            Arrays.fill(this.f32173g, false);
        }
    }

    public long a() {
        return e() ? this.f32161a.a() : ya.g.f56663b;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f32161a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f32166f;
    }

    public long d() {
        return e() ? this.f32161a.b() : ya.g.f56663b;
    }

    public boolean e() {
        return this.f32161a.e();
    }

    public void f(long j10) {
        this.f32161a.f(j10);
        if (this.f32161a.e() && !this.f32164d) {
            this.f32163c = false;
        } else if (this.f32165e != ya.g.f56663b) {
            if (!this.f32163c || this.f32162b.d()) {
                this.f32162b.g();
                this.f32162b.f(this.f32165e);
            }
            this.f32163c = true;
            this.f32162b.f(j10);
        }
        if (this.f32163c && this.f32162b.e()) {
            a aVar = this.f32161a;
            this.f32161a = this.f32162b;
            this.f32162b = aVar;
            this.f32163c = false;
            this.f32164d = false;
        }
        this.f32165e = j10;
        this.f32166f = this.f32161a.e() ? 0 : this.f32166f + 1;
    }

    public void g() {
        this.f32161a.g();
        this.f32162b.g();
        this.f32163c = false;
        this.f32165e = ya.g.f56663b;
        this.f32166f = 0;
    }
}
