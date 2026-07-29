package s2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f extends c<Boolean> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f49439i = l.f("StorageNotLowTracker");

    public f(@n0 Context context, @n0 w2.a taskExecutor) {
        super(context, taskExecutor);
    }

    @Override // s2.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // s2.c
    public void h(Context context, @n0 Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        l.c().a(f49439i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            d(Boolean.FALSE);
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            d(Boolean.TRUE);
        }
    }

    @Override // s2.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.f49427b.registerReceiver(null, g());
        if (intentRegisterReceiver == null || intentRegisterReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = intentRegisterReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return Boolean.TRUE;
        }
        return null;
    }
}
