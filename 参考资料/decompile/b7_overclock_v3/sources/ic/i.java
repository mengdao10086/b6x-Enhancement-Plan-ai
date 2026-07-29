package ic;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import g.i1;
import g.p0;
import ic.j;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f32080h = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Format f32082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f32083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f32084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<d> f32085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f32086g;

    public static class b extends i implements hc.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @i1
        public final j.a f32087i;

        public b(long j10, Format format, String str, j.a aVar, @p0 List<d> list) {
            super(j10, format, str, aVar, list);
            this.f32087i = aVar;
        }

        @Override // hc.e
        public long a(long j10) {
            return this.f32087i.j(j10);
        }

        @Override // hc.e
        public long b(long j10, long j11) {
            return this.f32087i.h(j10, j11);
        }

        @Override // hc.e
        public long c(long j10, long j11) {
            return this.f32087i.d(j10, j11);
        }

        @Override // hc.e
        public long d(long j10, long j11) {
            return this.f32087i.f(j10, j11);
        }

        @Override // hc.e
        public h e(long j10) {
            return this.f32087i.k(this, j10);
        }

        @Override // hc.e
        public long f(long j10, long j11) {
            return this.f32087i.i(j10, j11);
        }

        @Override // hc.e
        public boolean g() {
            return this.f32087i.l();
        }

        @Override // hc.e
        public long h() {
            return this.f32087i.e();
        }

        @Override // hc.e
        public int i(long j10) {
            return this.f32087i.g(j10);
        }

        @Override // hc.e
        public int j(long j10, long j11) {
            return this.f32087i.c(j10, j11);
        }

        @Override // ic.i
        @p0
        public String k() {
            return null;
        }

        @Override // ic.i
        public hc.e l() {
            return this;
        }

        @Override // ic.i
        @p0
        public h m() {
            return null;
        }
    }

    public static class c extends i {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Uri f32088i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f32089j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        public final String f32090k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @p0
        public final h f32091l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @p0
        public final l f32092m;

        public c(long j10, Format format, String str, j.e eVar, @p0 List<d> list, @p0 String str2, long j11) {
            super(j10, format, str, eVar, list);
            this.f32088i = Uri.parse(str);
            h hVarC = eVar.c();
            this.f32091l = hVarC;
            this.f32090k = str2;
            this.f32089j = j11;
            this.f32092m = hVarC != null ? null : new l(new h(null, 0L, j11));
        }

        public static c r(long j10, Format format, String str, long j11, long j12, long j13, long j14, List<d> list, @p0 String str2, long j15) {
            return new c(j10, format, str, new j.e(new h(null, j11, (j12 - j11) + 1), 1L, 0L, j13, (j14 - j13) + 1), list, str2, j15);
        }

        @Override // ic.i
        @p0
        public String k() {
            return this.f32090k;
        }

        @Override // ic.i
        @p0
        public hc.e l() {
            return this.f32092m;
        }

        @Override // ic.i
        @p0
        public h m() {
            return this.f32091l;
        }
    }

    public static i o(long j10, Format format, String str, j jVar) {
        return p(j10, format, str, jVar, null);
    }

    public static i p(long j10, Format format, String str, j jVar, @p0 List<d> list) {
        return q(j10, format, str, jVar, list, null);
    }

    public static i q(long j10, Format format, String str, j jVar, @p0 List<d> list, @p0 String str2) {
        if (jVar instanceof j.e) {
            return new c(j10, format, str, (j.e) jVar, list, str2, -1L);
        }
        if (jVar instanceof j.a) {
            return new b(j10, format, str, (j.a) jVar, list);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @p0
    public abstract String k();

    @p0
    public abstract hc.e l();

    @p0
    public abstract h m();

    @p0
    public h n() {
        return this.f32086g;
    }

    public i(long j10, Format format, String str, j jVar, @p0 List<d> list) {
        this.f32081b = j10;
        this.f32082c = format;
        this.f32083d = str;
        this.f32085f = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f32086g = jVar.a(this);
        this.f32084e = jVar.b();
    }
}
