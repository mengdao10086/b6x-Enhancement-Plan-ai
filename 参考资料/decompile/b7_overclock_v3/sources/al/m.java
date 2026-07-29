package al;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.internal.t0;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import qk.v;

/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f755g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f756h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f749a = r0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public static final long f750b = t0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public static final int f751c = t0.e("kotlinx.coroutines.scheduler.core.pool.size", v.u(r0.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    public static final int f752d = t0.e("kotlinx.coroutines.scheduler.max.pool.size", CoroutineScheduler.f38971v, 0, CoroutineScheduler.f38971v, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    public static final long f753e = TimeUnit.SECONDS.toNanos(t0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.k
    public static h f754f = f.f739a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final j f757i = new k(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final j f758j = new k(1);

    public static final boolean a(@yt.k i iVar) {
        return iVar.f746b.M0() == 1;
    }
}
