package ec;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicLong f26837h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f26838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f26839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f26840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f26841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f26842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f26843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f26844g;

    public j(long j10, com.google.android.exoplayer2.upstream.b bVar, long j11) {
        this(j10, bVar, bVar.f19092a, Collections.emptyMap(), j11, 0L, 0L);
    }

    public static long a() {
        return f26837h.getAndIncrement();
    }

    public j(long j10, com.google.android.exoplayer2.upstream.b bVar, Uri uri, Map<String, List<String>> map, long j11, long j12, long j13) {
        this.f26838a = j10;
        this.f26839b = bVar;
        this.f26840c = uri;
        this.f26841d = map;
        this.f26842e = j11;
        this.f26843f = j12;
        this.f26844g = j13;
    }
}
