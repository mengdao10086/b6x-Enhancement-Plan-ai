package sf;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothAdapter f49827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rf.c f49828c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49826a = getClass().getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49829d = false;

    public a(Context context) {
        this.f49827b = qf.a.d(context);
    }

    @Override // sf.b
    public void a(rf.c cVar) {
        this.f49828c = cVar;
    }

    public BluetoothAdapter c() {
        return this.f49827b;
    }

    @Override // sf.b
    public void close() {
        this.f49828c = null;
    }

    public boolean d() {
        return this.f49829d;
    }

    public void e(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
        rf.c cVar = this.f49828c;
        if (cVar != null) {
            cVar.u2(bluetoothDevice, i10, bArr);
        }
    }

    public void f() {
        this.f49829d = false;
        rf.c cVar = this.f49828c;
        if (cVar != null) {
            cVar.h();
        }
    }

    public void g() {
        this.f49829d = true;
        rf.c cVar = this.f49828c;
        if (cVar != null) {
            cVar.U1();
        }
    }
}
