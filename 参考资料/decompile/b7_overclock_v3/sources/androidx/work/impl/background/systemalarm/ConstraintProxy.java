package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.NetworkType;
import androidx.work.l;
import java.util.Iterator;
import java.util.List;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ConstraintProxy extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8409a = l.f("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static void a(Context context, List<r> workSpecs) {
        Iterator<r> it2 = workSpecs.iterator();
        boolean zF = false;
        boolean zG = false;
        boolean zI = false;
        boolean z10 = false;
        while (it2.hasNext()) {
            androidx.work.b bVar = it2.next().f51850j;
            zF |= bVar.f();
            zG |= bVar.g();
            zI |= bVar.i();
            z10 |= bVar.b() != NetworkType.NOT_REQUIRED;
            if (zF && zG && zI && z10) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, zF, zG, zI, z10));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        l.c().a(f8409a, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(a.a(context));
    }
}
