package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import g.n0;
import g.p0;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes5.dex */
interface DfuService extends DfuCallback {
    boolean initialize(@n0 final Intent intent, @n0 final BluetoothGatt gatt, @FileType final int fileType, @n0 final InputStream firmwareStream, @p0 final InputStream initPacketStream) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    boolean isClientCompatible(@n0 final Intent intent, @n0 final BluetoothGatt gatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    void performDfu(@n0 final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    void release();
}
