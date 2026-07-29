package b3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f9056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<BluetoothGattCharacteristic> f9058c = new ArrayList<>();

    public c(UUID uuid, int i10) {
        this.f9056a = uuid;
        this.f9057b = i10;
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f9058c.add(bluetoothGattCharacteristic);
    }

    public void b(Collection<BluetoothGattCharacteristic> collection) {
        this.f9058c.addAll(collection);
    }

    public BluetoothGattService c() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(this.f9056a, this.f9057b);
        Iterator<BluetoothGattCharacteristic> it2 = this.f9058c.iterator();
        while (it2.hasNext()) {
            bluetoothGattService.addCharacteristic(it2.next());
        }
        return bluetoothGattService;
    }
}
