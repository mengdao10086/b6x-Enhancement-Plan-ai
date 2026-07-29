package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import ee.a;
import g.n0;
import j3.b;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes5.dex */
class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    public static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    public static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    public static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    public LegacyButtonlessDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        super(intent, service);
    }

    private String getVersionFeatures(final int version) {
        return version != 0 ? version != 1 ? version != 5 ? version != 6 ? version != 7 ? version != 8 ? "Unknown version" : "Bootloader from SDK 9.0 or newer. Signature supported" : "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet" : "Bootloader from SDK 8.0 or newer. Bond sharing supported" : "Bootloader from SDK 7.0 or newer. No bond sharing" : "Application with Legacy buttonless update from SDK 7.0 or newer" : "Bootloader from SDK 6.1 or older";
    }

    private int readVersion(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (characteristic == null) {
            return 0;
        }
        this.mReceivedData = null;
        this.mError = 0;
        logi("Reading DFU version number...");
        this.mService.sendLogBroadcast(1, "Reading DFU version number...");
        characteristic.setValue((byte[]) null);
        this.mService.sendLogBroadcast(0, "gatt.readCharacteristic(" + characteristic.getUuid() + a.f26979d);
        gatt.readCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (((this.mRequestCompleted && characteristic.getValue() != null) || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mRequestCompleted = false;
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mError == 0) {
            return characteristic.getIntValue(18, 0).intValue();
        }
        throw new DfuException("Unable to read version number", this.mError);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@n0 final Intent intent, @n0 final BluetoothGatt gatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        int version;
        BluetoothGattService service = gatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            version = readVersion(gatt, characteristic2);
            this.mVersion = version;
            int i10 = version & 15;
            int i11 = version >> 8;
            logi("Version number read: " + i11 + b.f36044h + i10 + " -> " + getVersionFeatures(version));
            DfuBaseService dfuBaseService = this.mService;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Version number read: ");
            sb2.append(i11);
            sb2.append(b.f36044h);
            sb2.append(i10);
            dfuBaseService.sendLogBroadcast(10, sb2.toString());
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            version = 0;
        }
        boolean booleanExtra = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        boolean z10 = gatt.getServices().size() > 3;
        if (version == 0 && z10) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return version == 1 || (!booleanExtra && version == 0 && z10);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(@n0 final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mService.waitFor(1000);
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGatt bluetoothGatt = this.mGatt;
        BluetoothGattService service = bluetoothGatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Starting service that will connect to the DFU bootloader");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, this.mVersion == 0);
    }
}
