package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import g.n0;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes5.dex */
class ExperimentalButtonlessDfuImpl extends ButtonlessDfuImpl {
    public static final UUID DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
    public static final UUID DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
    public static UUID EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
    public static UUID EXPERIMENTAL_BUTTONLESS_DFU_UUID;
    private BluetoothGattCharacteristic mButtonlessDfuCharacteristic;

    static {
        UUID uuid = new UUID(-8196551313441075360L, -6937650605005804976L);
        DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8196551313441075360L, -6937650605005804976L);
        DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID = uuid2;
        EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = uuid;
        EXPERIMENTAL_BUTTONLESS_DFU_UUID = uuid2;
    }

    public ExperimentalButtonlessDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        super(intent, service);
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl
    public BluetoothGattCharacteristic getButtonlessDfuCharacteristic() {
        return this.mButtonlessDfuCharacteristic;
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl
    public int getResponseType() {
        return 1;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@n0 final Intent intent, @n0 final BluetoothGatt gatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = gatt.getService(EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(EXPERIMENTAL_BUTTONLESS_DFU_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mButtonlessDfuCharacteristic = characteristic;
        return true;
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl, no.nordicsemi.android.dfu.DfuService
    public void performDfu(@n0 final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logi("Experimental buttonless service found -> SDK 12.x");
        super.performDfu(intent);
    }

    @Override // no.nordicsemi.android.dfu.ButtonlessDfuImpl
    public boolean shouldScanForBootloader() {
        return true;
    }
}
