package cc;

import com.google.android.exoplayer2.offline.DownloadRequest;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10701i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10702j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10703k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10704l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10705m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10706n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10707o = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f10708p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f10709q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f10710r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadRequest f10711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s f10718h;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public c(DownloadRequest downloadRequest, int i10, long j10, long j11, long j12, int i11, int i12) {
        this(downloadRequest, i10, j10, j11, j12, i11, i12, new s());
    }

    public long a() {
        return this.f10718h.f10810a;
    }

    public float b() {
        return this.f10718h.f10811b;
    }

    public boolean c() {
        int i10 = this.f10712b;
        return i10 == 3 || i10 == 4;
    }

    public c(DownloadRequest downloadRequest, int i10, long j10, long j11, long j12, int i11, int i12, s sVar) {
        hd.a.g(sVar);
        hd.a.a((i12 == 0) == (i10 != 4));
        if (i11 != 0) {
            hd.a.a((i10 == 2 || i10 == 0) ? false : true);
        }
        this.f10711a = downloadRequest;
        this.f10712b = i10;
        this.f10713c = j10;
        this.f10714d = j11;
        this.f10715e = j12;
        this.f10716f = i11;
        this.f10717g = i12;
        this.f10718h = sVar;
    }
}
