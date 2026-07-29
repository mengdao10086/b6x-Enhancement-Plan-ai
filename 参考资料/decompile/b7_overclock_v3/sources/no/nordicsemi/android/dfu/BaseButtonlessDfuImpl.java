package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import g.n0;
import no.nordicsemi.android.dfu.BaseDfuImpl;

/* JADX INFO: loaded from: classes5.dex */
abstract class BaseButtonlessDfuImpl extends BaseDfuImpl {
    private final ButtonlessBluetoothCallback mBluetoothCallback;

    public class ButtonlessBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        public ButtonlessBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            BaseButtonlessDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
            BaseButtonlessDfuImpl.this.mReceivedData = characteristic.getValue();
            BaseButtonlessDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            BaseButtonlessDfuImpl baseButtonlessDfuImpl = BaseButtonlessDfuImpl.this;
            baseButtonlessDfuImpl.mRequestCompleted = true;
            baseButtonlessDfuImpl.notifyLock();
        }
    }

    public BaseButtonlessDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        super(intent, service);
        this.mBluetoothCallback = new ButtonlessBluetoothCallback();
    }

    public void finalize(@n0 final Intent intent, final boolean forceRefresh, final boolean scanForBootloader) {
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        this.mService.refreshDeviceCache(this.mGatt, forceRefresh || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12 && (intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false) || !booleanExtra)) {
            removeBond();
            this.mService.waitFor(2000);
        }
        logi("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, scanForBootloader);
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }
}
