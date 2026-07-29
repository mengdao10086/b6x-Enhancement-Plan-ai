package s2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b extends c<Boolean> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f49420i = l.f("BatteryNotLowTracker");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f49421j = 0.15f;

    public b(@n0 Context context, @n0 w2.a taskExecutor) {
        super(context, taskExecutor);
    }

    @Override // s2.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // s2.c
    public void h(Context context, @n0 Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        l.c().a(f49420i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            d(Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            d(Boolean.FALSE);
        }
    }

    @Override // s2.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.f49427b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(intentRegisterReceiver.getIntExtra("status", -1) == 1 || ((float) intentRegisterReceiver.getIntExtra(UMTencentSSOHandler.LEVEL, -1)) / ((float) intentRegisterReceiver.getIntExtra("scale", -1)) > 0.15f);
        }
        l.c().b(f49420i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
