package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.j;
import com.google.android.exoplayer2.upstream.k;
import com.google.common.base.Charsets;
import com.google.common.math.LongMath;
import ec.x;
import ed.u;
import ed.z;
import g.p0;
import gb.r;
import hd.k0;
import hd.t;
import hd.u0;
import hd.w;
import ic.i;
import ic.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ya.r0;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class DashMediaSource extends com.google.android.exoplayer2.source.a {
    public static final long E7 = 30000;

    @Deprecated
    public static final long F7 = 30000;
    public static final String G7 = "DashMediaSource";
    public static final long H7 = 5000;
    public static final long I7 = 5000000;
    public static final String J7 = "DashMediaSource";
    public IOException A;
    public Handler B;
    public v0.f C;
    public long C1;
    public long C2;
    public Uri D;
    public ic.b K0;
    public long K1;
    public int K2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v0 f17616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f17617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a.InterfaceC0197a f17618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a.InterfaceC0184a f17619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ec.d f17620k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Uri f17621k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f17622k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f17623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j f17624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f17625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m.a f17626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final k.a<? extends ic.b> f17627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e f17628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Object f17629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SparseArray<com.google.android.exoplayer2.source.dash.b> f17630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f17631t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f17632u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d.b f17633v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public long f17634v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f17635v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f17636w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.google.android.exoplayer2.upstream.a f17637x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Loader f17638y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @p0
    public z f17639z;

    public static final class Factory implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0184a f17640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final a.InterfaceC0197a f17641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r f17643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ec.d f17644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public j f17645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17646g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f17647h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public k.a<? extends ic.b> f17648i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<StreamKey> f17649j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        public Object f17650k;

        public Factory(a.InterfaceC0197a interfaceC0197a) {
            this(new c.a(interfaceC0197a), interfaceC0197a);
        }

        public static /* synthetic */ com.google.android.exoplayer2.drm.c o(com.google.android.exoplayer2.drm.c cVar, v0 v0Var) {
            return cVar;
        }

        @Override // ec.x
        public int[] e() {
            return new int[]{0};
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public DashMediaSource h(Uri uri) {
            return c(new v0.c().F(uri).B(w.f31187h0).E(this.f17650k).a());
        }

        public DashMediaSource l(ic.b bVar) {
            return m(bVar, new v0.c().F(Uri.EMPTY).z("DashMediaSource").B(w.f31187h0).C(this.f17649j).E(this.f17650k).a());
        }

        public DashMediaSource m(ic.b bVar, v0 v0Var) {
            ic.b bVarA = bVar;
            hd.a.a(!bVarA.f32035d);
            v0.g gVar = v0Var.f57132b;
            List<StreamKey> list = (gVar == null || gVar.f57187e.isEmpty()) ? this.f17649j : v0Var.f57132b.f57187e;
            if (!list.isEmpty()) {
                bVarA = bVarA.a(list);
            }
            ic.b bVar2 = bVarA;
            v0.g gVar2 = v0Var.f57132b;
            boolean z10 = gVar2 != null;
            v0 v0VarA = v0Var.a().B(w.f31187h0).F(z10 ? v0Var.f57132b.f57183a : Uri.EMPTY).E(z10 && gVar2.f57190h != null ? v0Var.f57132b.f57190h : this.f17650k).y(v0Var.f57133c.f57178a != ya.g.f56663b ? v0Var.f57133c.f57178a : this.f17646g).C(list).a();
            return new DashMediaSource(v0VarA, bVar2, null, null, this.f17640a, this.f17644e, this.f17643d.a(v0VarA), this.f17645f, this.f17647h, null);
        }

        @Override // ec.x
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public DashMediaSource c(v0 v0Var) {
            v0 v0VarA = v0Var;
            hd.a.g(v0VarA.f57132b);
            k.a cVar = this.f17648i;
            if (cVar == null) {
                cVar = new ic.c();
            }
            List<StreamKey> list = v0VarA.f57132b.f57187e.isEmpty() ? this.f17649j : v0VarA.f57132b.f57187e;
            k.a zVar = !list.isEmpty() ? new cc.z(cVar, list) : cVar;
            v0.g gVar = v0VarA.f57132b;
            boolean z10 = gVar.f57190h == null && this.f17650k != null;
            boolean z11 = gVar.f57187e.isEmpty() && !list.isEmpty();
            boolean z12 = v0VarA.f57133c.f57178a == ya.g.f56663b && this.f17646g != ya.g.f56663b;
            if (z10 || z11 || z12) {
                v0.c cVarA = v0Var.a();
                if (z10) {
                    cVarA.E(this.f17650k);
                }
                if (z11) {
                    cVarA.C(list);
                }
                if (z12) {
                    cVarA.y(this.f17646g);
                }
                v0VarA = cVarA.a();
            }
            v0 v0Var2 = v0VarA;
            return new DashMediaSource(v0Var2, null, this.f17641b, zVar, this.f17640a, this.f17644e, this.f17643d.a(v0Var2), this.f17645f, this.f17647h, null);
        }

        public Factory p(@p0 ec.d dVar) {
            if (dVar == null) {
                dVar = new ec.f();
            }
            this.f17644e = dVar;
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Factory d(@p0 HttpDataSource.b bVar) {
            if (!this.f17642c) {
                ((com.google.android.exoplayer2.drm.a) this.f17643d).c(bVar);
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Factory g(@p0 final com.google.android.exoplayer2.drm.c cVar) {
            if (cVar == null) {
                f(null);
            } else {
                f(new r() { // from class: hc.d
                    @Override // gb.r
                    public final com.google.android.exoplayer2.drm.c a(v0 v0Var) {
                        return DashMediaSource.Factory.o(cVar, v0Var);
                    }
                });
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Factory f(@p0 r rVar) {
            if (rVar != null) {
                this.f17643d = rVar;
                this.f17642c = true;
            } else {
                this.f17643d = new com.google.android.exoplayer2.drm.a();
                this.f17642c = false;
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public Factory a(@p0 String str) {
            if (!this.f17642c) {
                ((com.google.android.exoplayer2.drm.a) this.f17643d).d(str);
            }
            return this;
        }

        public Factory u(long j10) {
            this.f17647h = j10;
            return this;
        }

        @Deprecated
        public Factory v(long j10, boolean z10) {
            this.f17646g = z10 ? j10 : ya.g.f56663b;
            if (!z10) {
                u(j10);
            }
            return this;
        }

        @Override // ec.x
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public Factory i(@p0 j jVar) {
            if (jVar == null) {
                jVar = new com.google.android.exoplayer2.upstream.g();
            }
            this.f17645f = jVar;
            return this;
        }

        public Factory x(@p0 k.a<? extends ic.b> aVar) {
            this.f17648i = aVar;
            return this;
        }

        @Override // ec.x
        @Deprecated
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public Factory b(@p0 List<StreamKey> list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f17649j = list;
            return this;
        }

        @Deprecated
        public Factory z(@p0 Object obj) {
            this.f17650k = obj;
            return this;
        }

        public Factory(a.InterfaceC0184a interfaceC0184a, @p0 a.InterfaceC0197a interfaceC0197a) {
            this.f17640a = (a.InterfaceC0184a) hd.a.g(interfaceC0184a);
            this.f17641b = interfaceC0197a;
            this.f17643d = new com.google.android.exoplayer2.drm.a();
            this.f17645f = new com.google.android.exoplayer2.upstream.g();
            this.f17646g = ya.g.f56663b;
            this.f17647h = 30000L;
            this.f17644e = new ec.f();
            this.f17649j = Collections.emptyList();
        }
    }

    public class a implements k0.b {
        public a() {
        }

        @Override // hd.k0.b
        public void a(IOException iOException) {
            DashMediaSource.this.a0(iOException);
        }

        @Override // hd.k0.b
        public void b() {
            DashMediaSource.this.b0(k0.h());
        }
    }

    public static final class b extends x1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f17654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f17655e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f17656f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f17657g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f17658h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ic.b f17659i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final v0 f17660j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        public final v0.f f17661k;

        public b(long j10, long j11, long j12, int i10, long j13, long j14, long j15, ic.b bVar, v0 v0Var, @p0 v0.f fVar) {
            hd.a.i(bVar.f32035d == (fVar != null));
            this.f17652b = j10;
            this.f17653c = j11;
            this.f17654d = j12;
            this.f17655e = i10;
            this.f17656f = j13;
            this.f17657g = j14;
            this.f17658h = j15;
            this.f17659i = bVar;
            this.f17660j = v0Var;
            this.f17661k = fVar;
        }

        public static boolean u(ic.b bVar) {
            return bVar.f32035d && bVar.f32036e != ya.g.f56663b && bVar.f32033b == ya.g.f56663b;
        }

        @Override // ya.x1
        public int b(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.f17655e) >= 0 && iIntValue < i()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // ya.x1
        public x1.b g(int i10, x1.b bVar, boolean z10) {
            hd.a.c(i10, 0, i());
            return bVar.p(z10 ? this.f17659i.d(i10).f32066a : null, z10 ? Integer.valueOf(this.f17655e + i10) : null, 0, this.f17659i.g(i10), ya.g.c(this.f17659i.d(i10).f32067b - this.f17659i.d(0).f32067b) - this.f17656f);
        }

        @Override // ya.x1
        public int i() {
            return this.f17659i.e();
        }

        @Override // ya.x1
        public Object m(int i10) {
            hd.a.c(i10, 0, i());
            return Integer.valueOf(this.f17655e + i10);
        }

        @Override // ya.x1
        public x1.c o(int i10, x1.c cVar, long j10) {
            hd.a.c(i10, 0, 1);
            long jT = t(j10);
            Object obj = x1.c.f57238r;
            v0 v0Var = this.f17660j;
            ic.b bVar = this.f17659i;
            return cVar.i(obj, v0Var, bVar, this.f17652b, this.f17653c, this.f17654d, true, u(bVar), this.f17661k, jT, this.f17657g, 0, i() - 1, this.f17656f);
        }

        @Override // ya.x1
        public int q() {
            return 1;
        }

        public final long t(long j10) {
            hc.e eVarL;
            long j11 = this.f17658h;
            if (!u(this.f17659i)) {
                return j11;
            }
            if (j10 > 0) {
                j11 += j10;
                if (j11 > this.f17657g) {
                    return ya.g.f56663b;
                }
            }
            long j12 = this.f17656f + j11;
            long jG = this.f17659i.g(0);
            int i10 = 0;
            while (i10 < this.f17659i.e() - 1 && j12 >= jG) {
                j12 -= jG;
                i10++;
                jG = this.f17659i.g(i10);
            }
            ic.f fVarD = this.f17659i.d(i10);
            int iA = fVarD.a(2);
            return (iA == -1 || (eVarL = fVarD.f32068c.get(iA).f32028c.get(0).l()) == null || eVarL.i(jG) == 0) ? j11 : (j11 + eVarL.a(eVarL.f(j12, jG))) - j12;
        }
    }

    public final class c implements d.b {
        public c() {
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void a() {
            DashMediaSource.this.U();
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void b(long j10) {
            DashMediaSource.this.T(j10);
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public static final class d implements k.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f17663a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)).readLine();
            try {
                Matcher matcher = f17663a.matcher(line);
                if (!matcher.matches()) {
                    throw new ParserException("Couldn't parse timestamp: " + line);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(com.google.android.material.datepicker.r.f20160a));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j10 = com.google.android.material.badge.a.f19590u.equals(matcher.group(4)) ? 1L : -1L;
                    long j11 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= j10 * ((((j11 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e10) {
                throw new ParserException(e10);
            }
        }
    }

    public final class e implements Loader.b<k<ic.b>> {
        public e() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(k<ic.b> kVar, long j10, long j11, boolean z10) {
            DashMediaSource.this.V(kVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(k<ic.b> kVar, long j10, long j11) {
            DashMediaSource.this.W(kVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c t(k<ic.b> kVar, long j10, long j11, IOException iOException, int i10) {
            return DashMediaSource.this.X(kVar, j10, j11, iOException, i10);
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public final class f implements u {
        public f() {
        }

        @Override // ed.u
        public void a() throws IOException {
            DashMediaSource.this.f17638y.a();
            c();
        }

        @Override // ed.u
        public void b(int i10) throws IOException {
            DashMediaSource.this.f17638y.b(i10);
            c();
        }

        public final void c() throws IOException {
            if (DashMediaSource.this.A != null) {
                throw DashMediaSource.this.A;
            }
        }
    }

    public final class g implements Loader.b<k<Long>> {
        public g() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(k<Long> kVar, long j10, long j11, boolean z10) {
            DashMediaSource.this.V(kVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(k<Long> kVar, long j10, long j11) {
            DashMediaSource.this.Y(kVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c t(k<Long> kVar, long j10, long j11, IOException iOException, int i10) {
            return DashMediaSource.this.Z(kVar, j10, j11, iOException);
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public static final class h implements k.a<Long> {
        public h() {
        }

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(u0.Y0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        r0.a("goog.exo.dash");
    }

    public /* synthetic */ DashMediaSource(v0 v0Var, ic.b bVar, a.InterfaceC0197a interfaceC0197a, k.a aVar, a.InterfaceC0184a interfaceC0184a, ec.d dVar, com.google.android.exoplayer2.drm.c cVar, j jVar, long j10, a aVar2) {
        this(v0Var, bVar, interfaceC0197a, aVar, interfaceC0184a, dVar, cVar, jVar, j10);
    }

    public static long L(ic.f fVar, long j10, long j11) {
        long jC = ya.g.c(fVar.f32067b);
        boolean zP = P(fVar);
        int i10 = 0;
        long jMin = Long.MAX_VALUE;
        int i11 = 0;
        while (i11 < fVar.f32068c.size()) {
            ic.a aVar = fVar.f32068c.get(i11);
            List<i> list = aVar.f32028c;
            if ((!zP || aVar.f32027b != 3) && !list.isEmpty()) {
                hc.e eVarL = list.get(i10).l();
                if (eVarL == null) {
                    return jC + j10;
                }
                int iJ = eVarL.j(j10, j11);
                if (iJ == 0) {
                    return jC;
                }
                long jC2 = (eVarL.c(j10, j11) + ((long) iJ)) - 1;
                jMin = Math.min(jMin, eVarL.a(jC2) + jC + eVarL.b(jC2, j10));
            }
            i11++;
            i10 = 0;
        }
        return jMin;
    }

    public static long M(ic.f fVar, long j10, long j11) {
        long jC = ya.g.c(fVar.f32067b);
        boolean zP = P(fVar);
        long jMax = jC;
        for (int i10 = 0; i10 < fVar.f32068c.size(); i10++) {
            ic.a aVar = fVar.f32068c.get(i10);
            List<i> list = aVar.f32028c;
            if ((!zP || aVar.f32027b != 3) && !list.isEmpty()) {
                hc.e eVarL = list.get(0).l();
                if (eVarL == null || eVarL.j(j10, j11) == 0) {
                    return jC;
                }
                jMax = Math.max(jMax, eVarL.a(eVarL.c(j10, j11)) + jC);
            }
        }
        return jMax;
    }

    public static long N(ic.b bVar, long j10) {
        hc.e eVarL;
        int iE = bVar.e() - 1;
        ic.f fVarD = bVar.d(iE);
        long jC = ya.g.c(fVarD.f32067b);
        long jG = bVar.g(iE);
        long jC2 = ya.g.c(j10);
        long jC3 = ya.g.c(bVar.f32032a);
        long jC4 = ya.g.c(5000L);
        for (int i10 = 0; i10 < fVarD.f32068c.size(); i10++) {
            List<i> list = fVarD.f32068c.get(i10).f32028c;
            if (!list.isEmpty() && (eVarL = list.get(0).l()) != null) {
                long jD = ((jC3 + jC) + eVarL.d(jG, jC2)) - jC2;
                if (jD < jC4 - 100000 || (jD > jC4 && jD < jC4 + 100000)) {
                    jC4 = jD;
                }
            }
        }
        return LongMath.divide(jC4, 1000L, RoundingMode.CEILING);
    }

    public static boolean P(ic.f fVar) {
        for (int i10 = 0; i10 < fVar.f32068c.size(); i10++) {
            int i11 = fVar.f32068c.get(i10).f32027b;
            if (i11 == 1 || i11 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean Q(ic.f fVar) {
        for (int i10 = 0; i10 < fVar.f32068c.size(); i10++) {
            hc.e eVarL = fVar.f32068c.get(i10).f32028c.get(0).l();
            if (eVarL == null || eVarL.g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        c0(false);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        this.f17639z = zVar;
        this.f17623l.f();
        if (this.f17617h) {
            c0(false);
            return;
        }
        this.f17637x = this.f17618i.a();
        this.f17638y = new Loader("Loader:DashMediaSource");
        this.B = u0.z();
        j0();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void E() {
        this.f17622k1 = false;
        this.f17637x = null;
        Loader loader = this.f17638y;
        if (loader != null) {
            loader.l();
            this.f17638y = null;
        }
        this.f17634v1 = 0L;
        this.C1 = 0L;
        this.K0 = this.f17617h ? this.K0 : null;
        this.D = this.f17621k0;
        this.A = null;
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.B = null;
        }
        this.K1 = ya.g.f56663b;
        this.f17635v2 = 0;
        this.C2 = ya.g.f56663b;
        this.K2 = 0;
        this.f17630s.clear();
        this.f17623l.release();
    }

    public final long O() {
        return Math.min((this.f17635v2 - 1) * 1000, 5000);
    }

    public final void S() {
        k0.j(this.f17638y, new a());
    }

    public void T(long j10) {
        long j11 = this.C2;
        if (j11 == ya.g.f56663b || j11 < j10) {
            this.C2 = j10;
        }
    }

    public void U() {
        this.B.removeCallbacks(this.f17632u);
        j0();
    }

    public void V(k<?> kVar, long j10, long j11) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        this.f17624m.d(kVar.f19268a);
        this.f17626o.q(jVar, kVar.f19270c);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W(com.google.android.exoplayer2.upstream.k<ic.b> r19, long r20, long r22) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.W(com.google.android.exoplayer2.upstream.k, long, long):void");
    }

    public Loader.c X(k<ic.b> kVar, long j10, long j11, IOException iOException, int i10) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        long jA = this.f17624m.a(new j.a(jVar, new ec.k(kVar.f19270c), iOException, i10));
        Loader.c cVarI = jA == ya.g.f56663b ? Loader.f19042k : Loader.i(false, jA);
        boolean z10 = !cVarI.c();
        this.f17626o.x(jVar, kVar.f19270c, iOException, z10);
        if (z10) {
            this.f17624m.d(kVar.f19268a);
        }
        return cVarI;
    }

    public void Y(k<Long> kVar, long j10, long j11) {
        ec.j jVar = new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a());
        this.f17624m.d(kVar.f19268a);
        this.f17626o.t(jVar, kVar.f19270c);
        b0(kVar.e().longValue() - j10);
    }

    public Loader.c Z(k<Long> kVar, long j10, long j11, IOException iOException) {
        this.f17626o.x(new ec.j(kVar.f19268a, kVar.f19269b, kVar.f(), kVar.d(), j10, j11, kVar.a()), kVar.f19270c, iOException, true);
        this.f17624m.d(kVar.f19268a);
        a0(iOException);
        return Loader.f19041j;
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.a aVar, ed.b bVar, long j10) {
        int iIntValue = ((Integer) aVar.f26856a).intValue() - this.K2;
        m.a aVarY = y(aVar, this.K0.d(iIntValue).f32067b);
        com.google.android.exoplayer2.source.dash.b bVar2 = new com.google.android.exoplayer2.source.dash.b(this.K2 + iIntValue, this.K0, iIntValue, this.f17619j, this.f17639z, this.f17623l, v(aVar), this.f17624m, aVarY, this.K1, this.f17636w, bVar, this.f17620k, this.f17633v);
        this.f17630s.put(bVar2.f17669a, bVar2);
        return bVar2;
    }

    public final void a0(IOException iOException) {
        t.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        c0(true);
    }

    public final void b0(long j10) {
        this.K1 = j10;
        c0(true);
    }

    public final void c0(boolean z10) {
        ic.f fVar;
        long j10;
        long j11;
        for (int i10 = 0; i10 < this.f17630s.size(); i10++) {
            int iKeyAt = this.f17630s.keyAt(i10);
            if (iKeyAt >= this.K2) {
                this.f17630s.valueAt(i10).M(this.K0, iKeyAt - this.K2);
            }
        }
        ic.f fVarD = this.K0.d(0);
        int iE = this.K0.e() - 1;
        ic.f fVarD2 = this.K0.d(iE);
        long jG = this.K0.g(iE);
        long jC = ya.g.c(u0.j0(this.K1));
        long jM = M(fVarD, this.K0.g(0), jC);
        long jL = L(fVarD2, jG, jC);
        boolean z11 = this.K0.f32035d && !Q(fVarD2);
        if (z11) {
            long j12 = this.K0.f32037f;
            if (j12 != ya.g.f56663b) {
                jM = Math.max(jM, jL - ya.g.c(j12));
            }
        }
        long j13 = jL - jM;
        ic.b bVar = this.K0;
        if (bVar.f32035d) {
            hd.a.i(bVar.f32032a != ya.g.f56663b);
            long jC2 = (jC - ya.g.c(this.K0.f32032a)) - jM;
            k0(jC2, j13);
            long jD = this.K0.f32032a + ya.g.d(jM);
            long jC3 = jC2 - ya.g.c(this.C.f57178a);
            long jMin = Math.min(5000000L, j13 / 2);
            j10 = jD;
            j11 = jC3 < jMin ? jMin : jC3;
            fVar = fVarD;
        } else {
            fVar = fVarD;
            j10 = ya.g.f56663b;
            j11 = 0;
        }
        long jC4 = jM - ya.g.c(fVar.f32067b);
        ic.b bVar2 = this.K0;
        D(new b(bVar2.f32032a, j10, this.K1, this.K2, jC4, j13, j11, bVar2, this.f17616g, bVar2.f32035d ? this.C : null));
        if (this.f17617h) {
            return;
        }
        this.B.removeCallbacks(this.f17632u);
        if (z11) {
            this.B.postDelayed(this.f17632u, N(this.K0, u0.j0(this.K1)));
        }
        if (this.f17622k1) {
            j0();
            return;
        }
        if (z10) {
            ic.b bVar3 = this.K0;
            if (bVar3.f32035d) {
                long j14 = bVar3.f32036e;
                if (j14 != ya.g.f56663b) {
                    if (j14 == 0) {
                        j14 = 5000;
                    }
                    h0(Math.max(0L, (this.f17634v1 + j14) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public void d0(Uri uri) {
        synchronized (this.f17629r) {
            this.D = uri;
            this.f17621k0 = uri;
        }
    }

    public final void e0(n nVar) {
        String str = nVar.f32130a;
        if (u0.c(str, "urn:mpeg:dash:utc:direct:2014") || u0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            f0(nVar);
            return;
        }
        if (u0.c(str, "urn:mpeg:dash:utc:http-iso:2014") || u0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            g0(nVar, new d());
            return;
        }
        if (u0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || u0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            g0(nVar, new h(null));
        } else if (u0.c(str, "urn:mpeg:dash:utc:ntp:2014") || u0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            S();
        } else {
            a0(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void f0(n nVar) {
        try {
            b0(u0.Y0(nVar.f32131b) - this.C1);
        } catch (ParserException e10) {
            a0(e10);
        }
    }

    public final void g0(n nVar, k.a<Long> aVar) {
        i0(new k(this.f17637x, Uri.parse(nVar.f32131b), 5, aVar), new g(this, null), 1);
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return ((v0.g) u0.k(this.f17616g.f57132b)).f57190h;
    }

    public final void h0(long j10) {
        this.B.postDelayed(this.f17631t, j10);
    }

    public final <T> void i0(k<T> kVar, Loader.b<k<T>> bVar, int i10) {
        this.f17626o.z(new ec.j(kVar.f19268a, kVar.f19269b, this.f17638y.n(kVar, bVar, i10)), kVar.f19270c);
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f17616g;
    }

    public final void j0() {
        Uri uri;
        this.B.removeCallbacks(this.f17631t);
        if (this.f17638y.j()) {
            return;
        }
        if (this.f17638y.k()) {
            this.f17622k1 = true;
            return;
        }
        synchronized (this.f17629r) {
            uri = this.D;
        }
        this.f17622k1 = false;
        i0(new k(this.f17637x, uri, 4, this.f17627p), this.f17628q, this.f17624m.f(4));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k0(long r15, long r17) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.k0(long, long):void");
    }

    @Override // com.google.android.exoplayer2.source.l
    public void n() throws IOException {
        this.f17636w.a();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(com.google.android.exoplayer2.source.k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.I();
        this.f17630s.remove(bVar.f17669a);
    }

    public DashMediaSource(v0 v0Var, @p0 ic.b bVar, @p0 a.InterfaceC0197a interfaceC0197a, @p0 k.a<? extends ic.b> aVar, a.InterfaceC0184a interfaceC0184a, ec.d dVar, com.google.android.exoplayer2.drm.c cVar, j jVar, long j10) {
        this.f17616g = v0Var;
        this.C = v0Var.f57133c;
        this.D = ((v0.g) hd.a.g(v0Var.f57132b)).f57183a;
        this.f17621k0 = v0Var.f57132b.f57183a;
        this.K0 = bVar;
        this.f17618i = interfaceC0197a;
        this.f17627p = aVar;
        this.f17619j = interfaceC0184a;
        this.f17623l = cVar;
        this.f17624m = jVar;
        this.f17625n = j10;
        this.f17620k = dVar;
        boolean z10 = bVar != null;
        this.f17617h = z10;
        a aVar2 = null;
        this.f17626o = x(null);
        this.f17629r = new Object();
        this.f17630s = new SparseArray<>();
        this.f17633v = new c(this, aVar2);
        this.C2 = ya.g.f56663b;
        this.K1 = ya.g.f56663b;
        if (!z10) {
            this.f17628q = new e(this, aVar2);
            this.f17636w = new f();
            this.f17631t = new Runnable() { // from class: hc.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30936a.j0();
                }
            };
            this.f17632u = new Runnable() { // from class: hc.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30937a.R();
                }
            };
            return;
        }
        hd.a.i(true ^ bVar.f32035d);
        this.f17628q = null;
        this.f17631t = null;
        this.f17632u = null;
        this.f17636w = new u.a();
    }
}
