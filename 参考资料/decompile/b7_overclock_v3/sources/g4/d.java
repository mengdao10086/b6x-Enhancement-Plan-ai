package g4;

import android.graphics.Bitmap;
import g.i1;
import g.p0;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i1
    public static final Bitmap.Config f29027e = Bitmap.Config.RGB_565;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap.Config f29030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f29031d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f29033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap.Config f29034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f29035d;

        public a(int i10) {
            this(i10, i10);
        }

        public d a() {
            return new d(this.f29032a, this.f29033b, this.f29034c, this.f29035d);
        }

        public Bitmap.Config b() {
            return this.f29034c;
        }

        public a c(@p0 Bitmap.Config config) {
            this.f29034c = config;
            return this;
        }

        public a d(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.f29035d = i10;
            return this;
        }

        public a(int i10, int i11) {
            this.f29035d = 1;
            if (i10 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i11 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.f29032a = i10;
            this.f29033b = i11;
        }
    }

    public d(int i10, int i11, Bitmap.Config config, int i12) {
        this.f29030c = (Bitmap.Config) m.e(config, "Config must not be null");
        this.f29028a = i10;
        this.f29029b = i11;
        this.f29031d = i12;
    }

    public Bitmap.Config a() {
        return this.f29030c;
    }

    public int b() {
        return this.f29029b;
    }

    public int c() {
        return this.f29031d;
    }

    public int d() {
        return this.f29028a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f29029b == dVar.f29029b && this.f29028a == dVar.f29028a && this.f29031d == dVar.f29031d && this.f29030c == dVar.f29030c;
    }

    public int hashCode() {
        return (((((this.f29028a * 31) + this.f29029b) * 31) + this.f29030c.hashCode()) * 31) + this.f29031d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f29028a + ", height=" + this.f29029b + ", config=" + this.f29030c + ", weight=" + this.f29031d + '}';
    }
}
