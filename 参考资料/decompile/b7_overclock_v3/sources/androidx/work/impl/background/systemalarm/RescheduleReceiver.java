package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.l;
import l2.i;

/* JADX INFO: loaded from: classes2.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8420a = l.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        l.c().a(f8420a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT < 23) {
            context.startService(a.e(context));
            return;
        }
        try {
            i.H(context).T(goAsync());
        } catch (IllegalStateException e10) {
            l.c().b(f8420a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
        }
    }
}
