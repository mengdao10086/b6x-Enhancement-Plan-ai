package v4;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f52683a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j10) {
        return (b() - j10) * f52683a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
