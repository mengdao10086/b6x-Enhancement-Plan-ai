package androidx.work;

import androidx.work.p;
import g.v0;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0007\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\b\u001a\u001d\u0010\t\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a5\u0010\f\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\b\u001a%\u0010\r\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0087\b¨\u0006\u000e"}, d2 = {"Landroidx/work/ListenableWorker;", i1.a.T4, "", "repeatInterval", "Ljava/util/concurrent/TimeUnit;", "repeatIntervalTimeUnit", "Landroidx/work/p$a;", "a", "Ljava/time/Duration;", "c", "flexTimeInterval", "flexTimeIntervalUnit", "b", "d", "work-runtime-ktx_release"}, k = 2, mv = {1, 5, 1})
public final class q {
    public static final /* synthetic */ <W extends ListenableWorker> p.a a(long j10, TimeUnit repeatIntervalTimeUnit) {
        f0.p(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        f0.y(4, i1.a.T4);
        return new p.a((Class<? extends ListenableWorker>) ListenableWorker.class, j10, repeatIntervalTimeUnit);
    }

    public static final /* synthetic */ <W extends ListenableWorker> p.a b(long j10, TimeUnit repeatIntervalTimeUnit, long j11, TimeUnit flexTimeIntervalUnit) {
        f0.p(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        f0.p(flexTimeIntervalUnit, "flexTimeIntervalUnit");
        f0.y(4, i1.a.T4);
        return new p.a(ListenableWorker.class, j10, repeatIntervalTimeUnit, j11, flexTimeIntervalUnit);
    }

    @v0(26)
    public static final /* synthetic */ <W extends ListenableWorker> p.a c(Duration repeatInterval) {
        f0.p(repeatInterval, "repeatInterval");
        f0.y(4, i1.a.T4);
        return new p.a(ListenableWorker.class, repeatInterval);
    }

    @v0(26)
    public static final /* synthetic */ <W extends ListenableWorker> p.a d(Duration repeatInterval, Duration flexTimeInterval) {
        f0.p(repeatInterval, "repeatInterval");
        f0.p(flexTimeInterval, "flexTimeInterval");
        f0.y(4, i1.a.T4);
        return new p.a((Class<? extends ListenableWorker>) ListenableWorker.class, repeatInterval, flexTimeInterval);
    }
}
