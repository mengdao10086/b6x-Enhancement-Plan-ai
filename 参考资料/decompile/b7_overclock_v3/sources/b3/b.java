package b3;

import android.bluetooth.BluetoothGattDescriptor;
import g.n0;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f9054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9055b;

    public b(@n0 UUID uuid, int i10) {
        this.f9054a = uuid;
        this.f9055b = i10;
    }

    public BluetoothGattDescriptor a() {
        return new BluetoothGattDescriptor(this.f9054a, this.f9055b);
    }
}
