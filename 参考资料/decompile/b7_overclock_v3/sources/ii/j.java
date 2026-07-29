package ii;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class j {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f32429j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.objectbox.flatbuffers.i f32430a = new io.objectbox.flatbuffers.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f32431b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f32432c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f32433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f32434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f32435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f32436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f32437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f32438i;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f32439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f32440b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Integer> f32441c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f32442d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f32443e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Integer f32444f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f32445g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Long f32446h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b f32447i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f32448j;

        public a(String str) {
            this.f32439a = str;
        }

        public void a() {
            b bVar = this.f32447i;
            if (bVar != null) {
                this.f32440b.add(Integer.valueOf(bVar.b()));
                this.f32447i = null;
            }
        }

        public final void b() {
            if (this.f32448j) {
                throw new IllegalStateException("Already finished");
            }
        }

        public j c() {
            b();
            a();
            this.f32448j = true;
            int iY = j.this.f32430a.y(this.f32439a);
            int iB = j.this.b(this.f32440b);
            int iB2 = this.f32441c.isEmpty() ? 0 : j.this.b(this.f32441c);
            oi.e.f0(j.this.f32430a);
            oi.e.B(j.this.f32430a, iY);
            oi.e.D(j.this.f32430a, iB);
            if (iB2 != 0) {
                oi.e.E(j.this.f32430a, iB2);
            }
            if (this.f32442d != null && this.f32443e != null) {
                oi.e.z(j.this.f32430a, oi.c.e(j.this.f32430a, r0.intValue(), this.f32443e.longValue()));
            }
            if (this.f32445g != null) {
                oi.e.A(j.this.f32430a, oi.c.e(j.this.f32430a, r0.intValue(), this.f32446h.longValue()));
            }
            if (this.f32444f != null) {
                oi.e.y(j.this.f32430a, r0.intValue());
            }
            j jVar = j.this;
            jVar.f32431b.add(Integer.valueOf(oi.e.H(jVar.f32430a)));
            return j.this;
        }

        public a d(int i10) {
            this.f32444f = Integer.valueOf(i10);
            return this;
        }

        public a e(int i10, long j10) {
            b();
            this.f32442d = Integer.valueOf(i10);
            this.f32443e = Long.valueOf(j10);
            return this;
        }

        public a f(int i10, long j10) {
            b();
            this.f32445g = Integer.valueOf(i10);
            this.f32446h = Long.valueOf(j10);
            return this;
        }

        public b g(String str, int i10) {
            return h(str, null, i10);
        }

        public b h(String str, @Nullable String str2, int i10) {
            return i(str, str2, null, i10);
        }

        public b i(String str, @Nullable String str2, @Nullable String str3, int i10) {
            b();
            a();
            b bVar = j.this.new b(str, str2, str3, i10);
            this.f32447i = bVar;
            return bVar;
        }

        public a j(String str, int i10, long j10, int i11, long j11) {
            b();
            a();
            int iY = j.this.f32430a.y(str);
            oi.g.J(j.this.f32430a);
            oi.g.z(j.this.f32430a, iY);
            oi.g.y(j.this.f32430a, oi.c.e(j.this.f32430a, i10, j10));
            oi.g.A(j.this.f32430a, oi.c.e(j.this.f32430a, i11, j11));
            this.f32441c.add(Integer.valueOf(oi.g.B(j.this.f32430a)));
            return this;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f32455f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f32456g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f32457h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f32458i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f32459j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f32460k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f32461l;

        public b(String str, @Nullable String str2, @Nullable String str3, int i10) {
            this.f32450a = i10;
            this.f32452c = j.this.f32430a.y(str);
            this.f32453d = str2 != null ? j.this.f32430a.y(str2) : 0;
            this.f32451b = str3 != null ? j.this.f32430a.y(str3) : 0;
        }

        public final void a() {
            if (this.f32455f) {
                throw new IllegalStateException("Already finished");
            }
        }

        public int b() {
            a();
            this.f32455f = true;
            oi.f.W(j.this.f32430a);
            oi.f.C(j.this.f32430a, this.f32452c);
            int i10 = this.f32453d;
            if (i10 != 0) {
                oi.f.E(j.this.f32430a, i10);
            }
            int i11 = this.f32451b;
            if (i11 != 0) {
                oi.f.G(j.this.f32430a, i11);
            }
            int i12 = this.f32454e;
            if (i12 != 0) {
                oi.f.D(j.this.f32430a, i12);
            }
            int i13 = this.f32457h;
            if (i13 != 0) {
                oi.f.z(j.this.f32430a, oi.c.e(j.this.f32430a, i13, this.f32458i));
            }
            int i14 = this.f32459j;
            if (i14 != 0) {
                oi.f.A(j.this.f32430a, oi.c.e(j.this.f32430a, i14, this.f32460k));
            }
            int i15 = this.f32461l;
            if (i15 > 0) {
                oi.f.B(j.this.f32430a, i15);
            }
            oi.f.F(j.this.f32430a, this.f32450a);
            int i16 = this.f32456g;
            if (i16 != 0) {
                oi.f.y(j.this.f32430a, i16);
            }
            return oi.f.H(j.this.f32430a);
        }

        public b c(int i10) {
            a();
            this.f32456g = i10;
            return this;
        }

        public b d(int i10, long j10) {
            a();
            this.f32457h = i10;
            this.f32458i = j10;
            return this;
        }

        public b e(int i10, long j10) {
            a();
            this.f32459j = i10;
            this.f32460k = j10;
            return this;
        }

        public b f(int i10) {
            a();
            this.f32461l = i10;
            return this;
        }

        public b g(String str) {
            a();
            this.f32454e = j.this.f32430a.y(str);
            return this;
        }
    }

    public byte[] a() {
        int iY = this.f32430a.y("default");
        int iB = b(this.f32431b);
        oi.d.o0(this.f32430a);
        oi.d.F(this.f32430a, iY);
        oi.d.E(this.f32430a, 2L);
        oi.d.G(this.f32430a, 1L);
        oi.d.y(this.f32430a, iB);
        if (this.f32433d != null) {
            oi.d.A(this.f32430a, oi.c.e(this.f32430a, r0.intValue(), this.f32434e.longValue()));
        }
        if (this.f32435f != null) {
            oi.d.B(this.f32430a, oi.c.e(this.f32430a, r0.intValue(), this.f32436g.longValue()));
        }
        if (this.f32437h != null) {
            oi.d.C(this.f32430a, oi.c.e(this.f32430a, r0.intValue(), this.f32438i.longValue()));
        }
        this.f32430a.G(oi.d.K(this.f32430a));
        return this.f32430a.d0();
    }

    public int b(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr[i10] = list.get(i10).intValue();
        }
        return this.f32430a.B(iArr);
    }

    public a c(String str) {
        return new a(str);
    }

    public j d(int i10, long j10) {
        this.f32433d = Integer.valueOf(i10);
        this.f32434e = Long.valueOf(j10);
        return this;
    }

    public j e(int i10, long j10) {
        this.f32435f = Integer.valueOf(i10);
        this.f32436g = Long.valueOf(j10);
        return this;
    }

    public j f(int i10, long j10) {
        this.f32437h = Integer.valueOf(i10);
        this.f32438i = Long.valueOf(j10);
        return this;
    }

    public j g(long j10) {
        this.f32432c = j10;
        return this;
    }
}
