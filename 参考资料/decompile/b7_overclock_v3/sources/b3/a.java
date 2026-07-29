package b3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import g.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f9050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<BluetoothGattDescriptor> f9053d = new ArrayList<>();

    public a(@n0 UUID uuid, int i10, int i11) {
        this.f9050a = uuid;
        this.f9051b = i10;
        this.f9052c = i11;
    }

    public void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.f9053d.add(bluetoothGattDescriptor);
    }

    public void b(Collection<BluetoothGattDescriptor> collection) {
        this.f9053d.addAll(collection);
    }

    public BluetoothGattCharacteristic c() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(this.f9050a, this.f9051b, this.f9052c);
        Iterator<BluetoothGattDescriptor> it2 = this.f9053d.iterator();
        while (it2.hasNext()) {
            bluetoothGattCharacteristic.addDescriptor(it2.next());
        }
        return bluetoothGattCharacteristic;
    }
}
