package ya;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f57266e = "WakeLockManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f57267f = "ExoPlayer:WakeLockManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.p0
    public final PowerManager f57268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public PowerManager.WakeLock f57269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57271d;

    public y1(Context context) {
        this.f57268a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z10) {
        if (z10 && this.f57269b == null) {
            PowerManager powerManager = this.f57268a;
            if (powerManager == null) {
                hd.t.n(f57266e, "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, f57267f);
                this.f57269b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f57270c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f57271d = z10;
        c();
    }

    @SuppressLint({"WakelockTimeout"})
    public final void c() {
        PowerManager.WakeLock wakeLock = this.f57269b;
        if (wakeLock == null) {
            return;
        }
        if (this.f57270c && this.f57271d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
