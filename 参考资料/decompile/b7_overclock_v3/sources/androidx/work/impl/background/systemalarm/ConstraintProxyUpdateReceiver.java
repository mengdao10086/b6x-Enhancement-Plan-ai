package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.l;
import g.n0;
import g.p0;
import l2.i;
import v2.e;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8410a = l.f("ConstrntProxyUpdtRecvr");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8411b = "androidx.work.impl.background.systemalarm.UpdateProxies";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8412c = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8413d = "KEY_BATTERY_CHARGING_PROXY_ENABLED";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8414e = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8415f = "KEY_NETWORK_STATE_PROXY_ENABLED";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f8416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f8418c;

        public a(final Intent val$intent, final Context val$context, final BroadcastReceiver.PendingResult val$pendingResult) {
            this.f8416a = val$intent;
            this.f8417b = val$context;
            this.f8418c = val$pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean booleanExtra = this.f8416a.getBooleanExtra(ConstraintProxyUpdateReceiver.f8412c, false);
                boolean booleanExtra2 = this.f8416a.getBooleanExtra(ConstraintProxyUpdateReceiver.f8413d, false);
                boolean booleanExtra3 = this.f8416a.getBooleanExtra(ConstraintProxyUpdateReceiver.f8414e, false);
                boolean booleanExtra4 = this.f8416a.getBooleanExtra(ConstraintProxyUpdateReceiver.f8415f, false);
                l.c().a(ConstraintProxyUpdateReceiver.f8410a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                e.c(this.f8417b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                e.c(this.f8417b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                e.c(this.f8417b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                e.c(this.f8417b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f8418c.finish();
            }
        }
    }

    public static Intent a(Context context, boolean batteryNotLowProxyEnabled, boolean batteryChargingProxyEnabled, boolean storageNotLowProxyEnabled, boolean networkStateProxyEnabled) {
        Intent intent = new Intent(f8411b);
        intent.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
        intent.putExtra(f8412c, batteryNotLowProxyEnabled).putExtra(f8413d, batteryChargingProxyEnabled).putExtra(f8414e, storageNotLowProxyEnabled).putExtra(f8415f, networkStateProxyEnabled);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@n0 final Context context, @p0 final Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (f8411b.equals(action)) {
            i.H(context).O().c(new a(intent, context, goAsync()));
        } else {
            l.c().a(f8410a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
        }
    }
}
