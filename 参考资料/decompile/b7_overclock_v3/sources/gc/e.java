package gc;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import ed.x;
import g.p0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements Loader.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29163a = ec.j.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f29164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f29165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Format f29166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f29167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final Object f29168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f29169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f29170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x f29171i;

    public e(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, int i10, Format format, int i11, @p0 Object obj, long j10, long j11) {
        this.f29171i = new x(aVar);
        this.f29164b = (com.google.android.exoplayer2.upstream.b) hd.a.g(bVar);
        this.f29165c = i10;
        this.f29166d = format;
        this.f29167e = i11;
        this.f29168f = obj;
        this.f29169g = j10;
        this.f29170h = j11;
    }

    public final long a() {
        return this.f29171i.u();
    }

    public final long d() {
        return this.f29170h - this.f29169g;
    }

    public final Map<String, List<String>> e() {
        return this.f29171i.w();
    }

    public final Uri f() {
        return this.f29171i.v();
    }
}
