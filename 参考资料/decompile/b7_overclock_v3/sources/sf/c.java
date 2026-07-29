package sf;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes7.dex */
public class c extends sf.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f49830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f49831f;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "android.bluetooth.adapter.action.DISCOVERY_FINISHED":
                    c.this.f();
                    break;
                case "android.bluetooth.adapter.action.DISCOVERY_STARTED":
                    c.this.g();
                    break;
                case "android.bluetooth.device.action.FOUND":
                    c.this.e((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) -100), null);
                    break;
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f49831f = new a();
        this.f49830e = context;
        h();
    }

    @Override // sf.a, sf.b
    public void a(rf.c cVar) {
        super.a(cVar);
        if (d()) {
            return;
        }
        c().startDiscovery();
    }

    @Override // sf.b
    public void b() {
        if (d()) {
            c().cancelDiscovery();
        }
    }

    @Override // sf.a, sf.b
    public void close() {
        this.f49830e.unregisterReceiver(this.f49831f);
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        this.f49830e.registerReceiver(this.f49831f, intentFilter);
    }
}
