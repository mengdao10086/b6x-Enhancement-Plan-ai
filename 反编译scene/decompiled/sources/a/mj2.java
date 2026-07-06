package a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class mj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f1940a = oi2.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static nj2 f1941a;
    public static final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f1942b;

    static {
        oi2.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f6816a = oi2.d("kotlinx.coroutines.scheduler.core.pool.size", ga2.b(mi2.a(), 2), 1, 0, 8, null);
        b = oi2.d("kotlinx.coroutines.scheduler.max.pool.size", ga2.f(mi2.a() * 128, f6816a, 2097150), 0, 2097150, 4, null);
        f1942b = TimeUnit.SECONDS.toNanos(oi2.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        f1941a = hj2.f6318a;
    }
}
