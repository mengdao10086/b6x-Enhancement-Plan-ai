package ya;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l.a f56764s = new l.a(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1 f56765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l.a f56766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f56767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f56768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.p0
    public final ExoPlaybackException f56769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f56770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TrackGroupArray f56771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ad.k f56772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Metadata> f56773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l.a f56774j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f56775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f56776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h1 f56777m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f56778n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f56779o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f56780p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f56781q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f56782r;

    public g1(x1 x1Var, l.a aVar, long j10, int i10, @g.p0 ExoPlaybackException exoPlaybackException, boolean z10, TrackGroupArray trackGroupArray, ad.k kVar, List<Metadata> list, l.a aVar2, boolean z11, int i11, h1 h1Var, long j11, long j12, long j13, boolean z12, boolean z13) {
        this.f56765a = x1Var;
        this.f56766b = aVar;
        this.f56767c = j10;
        this.f56768d = i10;
        this.f56769e = exoPlaybackException;
        this.f56770f = z10;
        this.f56771g = trackGroupArray;
        this.f56772h = kVar;
        this.f56773i = list;
        this.f56774j = aVar2;
        this.f56775k = z11;
        this.f56776l = i11;
        this.f56777m = h1Var;
        this.f56780p = j11;
        this.f56781q = j12;
        this.f56782r = j13;
        this.f56778n = z12;
        this.f56779o = z13;
    }

    public static g1 k(ad.k kVar) {
        x1 x1Var = x1.f57231a;
        l.a aVar = f56764s;
        return new g1(x1Var, aVar, g.f56663b, 1, null, false, TrackGroupArray.f17501d, kVar, ImmutableList.of(), aVar, false, 0, h1.f56784d, 0L, 0L, 0L, false, false);
    }

    public static l.a l() {
        return f56764s;
    }

    @g.j
    public g1 a(boolean z10) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, this.f56769e, z10, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 b(l.a aVar) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, aVar, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 c(l.a aVar, long j10, long j11, long j12, TrackGroupArray trackGroupArray, ad.k kVar, List<Metadata> list) {
        return new g1(this.f56765a, aVar, j11, this.f56768d, this.f56769e, this.f56770f, trackGroupArray, kVar, list, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, j12, j10, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 d(boolean z10) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, z10, this.f56779o);
    }

    @g.j
    public g1 e(boolean z10, int i10) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, z10, i10, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 f(@g.p0 ExoPlaybackException exoPlaybackException) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, exoPlaybackException, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 g(h1 h1Var) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, h1Var, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 h(int i10) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, i10, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }

    @g.j
    public g1 i(boolean z10) {
        return new g1(this.f56765a, this.f56766b, this.f56767c, this.f56768d, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, z10);
    }

    @g.j
    public g1 j(x1 x1Var) {
        return new g1(x1Var, this.f56766b, this.f56767c, this.f56768d, this.f56769e, this.f56770f, this.f56771g, this.f56772h, this.f56773i, this.f56774j, this.f56775k, this.f56776l, this.f56777m, this.f56780p, this.f56781q, this.f56782r, this.f56778n, this.f56779o);
    }
}
