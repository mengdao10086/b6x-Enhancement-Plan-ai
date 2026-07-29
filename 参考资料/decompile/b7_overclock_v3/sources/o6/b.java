package o6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes7.dex */
public class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f42774a;

    public interface a {
        void a();

        void b();
    }

    public b(a aVar) {
        this.f42774a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra == 10) {
                this.f42774a.b();
            } else if (intExtra == 12) {
                this.f42774a.a();
            }
        }
    }
}
