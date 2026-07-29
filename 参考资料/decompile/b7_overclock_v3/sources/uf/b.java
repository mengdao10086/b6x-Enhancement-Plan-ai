package uf;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;

/* JADX INFO: loaded from: classes7.dex */
public class b extends d {
    @Override // uf.d
    public boolean o4() {
        return true;
    }

    @Override // uf.d
    public boolean p4(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return true;
    }

    @Override // uf.d
    public sf.b q4() {
        return new sf.c(this);
    }

    @Override // uf.d
    public void u4(BluetoothDevice bluetoothDevice) {
        Intent intent = new Intent();
        intent.putExtra(d.I7, bluetoothDevice);
        setResult(-1, intent);
        finish();
    }
}
