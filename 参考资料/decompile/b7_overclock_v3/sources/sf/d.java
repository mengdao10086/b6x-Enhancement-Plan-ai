package sf;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class d extends sf.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BluetoothAdapter.LeScanCallback f49833e;

    public class a implements BluetoothAdapter.LeScanCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
            d.this.e(bluetoothDevice, i10, bArr);
        }
    }

    public d(Context context) {
        super(context);
        this.f49833e = new a();
    }

    @Override // sf.a, sf.b
    public void a(rf.c cVar) {
        if (d()) {
            return;
        }
        if (c().startLeScan(this.f49833e)) {
            g();
        } else {
            f();
        }
    }

    @Override // sf.b
    public void b() {
        if (d()) {
            c().stopLeScan(this.f49833e);
            f();
        }
    }

    @Override // sf.a, sf.b
    public void close() {
    }
}
