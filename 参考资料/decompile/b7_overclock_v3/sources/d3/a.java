package d3;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a(BluetoothDevice bluetoothDevice, int i10, int i11, BluetoothGattDescriptor bluetoothGattDescriptor);

    void b(BluetoothDevice bluetoothDevice, int i10, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10, boolean z11, int i11, byte[] bArr);

    void c(BluetoothDevice bluetoothDevice, int i10, int i11, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void d(BluetoothDevice bluetoothDevice, int i10, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z10, boolean z11, int i11, byte[] bArr);

    void e(BluetoothDevice bluetoothDevice);

    void f(BluetoothDevice bluetoothDevice);

    void g(BluetoothDevice bluetoothDevice, int i10);
}
