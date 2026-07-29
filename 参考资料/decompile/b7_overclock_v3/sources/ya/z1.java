package ya;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f57276e = "WifiLockManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f57277f = "ExoPlayer:WifiLockManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.p0
    public final WifiManager f57278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public WifiManager.WifiLock f57279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57281d;

    public z1(Context context) {
        this.f57278a = (WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
    }

    public void a(boolean z10) {
        if (z10 && this.f57279b == null) {
            WifiManager wifiManager = this.f57278a;
            if (wifiManager == null) {
                hd.t.n(f57276e, "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, f57277f);
                this.f57279b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f57280c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f57281d = z10;
        c();
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = this.f57279b;
        if (wifiLock == null) {
            return;
        }
        if (this.f57280c && this.f57281d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
