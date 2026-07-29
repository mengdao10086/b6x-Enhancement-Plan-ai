package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import ee.a;
import g.n0;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes5.dex */
abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    public boolean mFirmwareUploadInProgress;
    private boolean mInitPacketInProgress;
    public int mPacketsBeforeNotification;
    private int mPacketsSentSinceNotification;
    public boolean mRemoteErrorOccurred;

    public class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        public BaseCustomBluetoothCallback() {
            super();
        }

        public void handleNotification(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
            BaseCustomDfuImpl.this.mReceivedData = characteristic.getValue();
            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
        }

        public void handlePacketReceiptNotification(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
            if (!baseCustomDfuImpl.mFirmwareUploadInProgress) {
                handleNotification(gatt, characteristic);
                return;
            }
            BluetoothGattCharacteristic characteristic2 = gatt.getService(baseCustomDfuImpl.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                if (!baseCustomDfuImpl2.mAborted && baseCustomDfuImpl2.mError == 0 && !baseCustomDfuImpl2.mRemoteErrorOccurred && !baseCustomDfuImpl2.mResetRequestSent) {
                    boolean zIsComplete = baseCustomDfuImpl2.mProgressInfo.isComplete();
                    boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!zIsComplete && !zIsObjectComplete) {
                        int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                        BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                        byte[] bArr = baseCustomDfuImpl3.mBuffer;
                        if (availableObjectSizeIsBytes < bArr.length) {
                            bArr = new byte[availableObjectSizeIsBytes];
                        }
                        BaseCustomDfuImpl.this.writePacket(gatt, characteristic2, bArr, baseCustomDfuImpl3.mFirmwareStream.read(bArr));
                        return;
                    }
                    BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                    baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                    baseCustomDfuImpl4.notifyLock();
                    return;
                }
                baseCustomDfuImpl2.mFirmwareUploadInProgress = false;
                baseCustomDfuImpl2.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e10) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e10);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            if (status != 0) {
                BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
                if (baseCustomDfuImpl.mResetRequestSent) {
                    baseCustomDfuImpl.mRequestCompleted = true;
                } else {
                    baseCustomDfuImpl.loge("Characteristic write error: " + status);
                    BaseCustomDfuImpl.this.mError = status | 16384;
                }
            } else if (!characteristic.getUuid().equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                BaseCustomDfuImpl.this.mRequestCompleted = true;
            } else if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                BaseCustomDfuImpl.this.mInitPacketInProgress = false;
            } else {
                BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                if (baseCustomDfuImpl2.mFirmwareUploadInProgress) {
                    baseCustomDfuImpl2.mProgressInfo.addBytesSent(characteristic.getValue().length);
                    BaseCustomDfuImpl.access$108(BaseCustomDfuImpl.this);
                    BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                    boolean z10 = baseCustomDfuImpl3.mPacketsBeforeNotification > 0 && baseCustomDfuImpl3.mPacketsSentSinceNotification >= BaseCustomDfuImpl.this.mPacketsBeforeNotification;
                    boolean zIsComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                    boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (z10) {
                        return;
                    }
                    if (zIsComplete || zIsObjectComplete) {
                        BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                        baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                        baseCustomDfuImpl4.notifyLock();
                        return;
                    }
                    try {
                        BaseCustomDfuImpl.this.waitIfPaused();
                        BaseCustomDfuImpl baseCustomDfuImpl5 = BaseCustomDfuImpl.this;
                        if (!baseCustomDfuImpl5.mAborted && baseCustomDfuImpl5.mError == 0 && !baseCustomDfuImpl5.mRemoteErrorOccurred && !baseCustomDfuImpl5.mResetRequestSent) {
                            int availableObjectSizeIsBytes = baseCustomDfuImpl5.mProgressInfo.getAvailableObjectSizeIsBytes();
                            BaseCustomDfuImpl baseCustomDfuImpl6 = BaseCustomDfuImpl.this;
                            byte[] bArr = baseCustomDfuImpl6.mBuffer;
                            if (availableObjectSizeIsBytes < bArr.length) {
                                bArr = new byte[availableObjectSizeIsBytes];
                            }
                            BaseCustomDfuImpl.this.writePacket(gatt, characteristic, bArr, baseCustomDfuImpl6.mFirmwareStream.read(bArr));
                            return;
                        }
                        baseCustomDfuImpl5.mFirmwareUploadInProgress = false;
                        baseCustomDfuImpl5.mService.sendLogBroadcast(15, "Upload terminated");
                        BaseCustomDfuImpl.this.notifyLock();
                        return;
                    } catch (HexFileValidationException unused) {
                        BaseCustomDfuImpl.this.loge("Invalid HEX file");
                        BaseCustomDfuImpl.this.mError = 4099;
                    } catch (IOException e10) {
                        BaseCustomDfuImpl.this.loge("Error while reading the input stream", e10);
                        BaseCustomDfuImpl.this.mError = 4100;
                    }
                } else {
                    onPacketCharacteristicWrite(gatt, characteristic, status);
                }
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        public void onPacketCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
        }
    }

    public BaseCustomDfuImpl(@n0 final Intent intent, final DfuBaseService service) {
        super(intent, service);
        int i10 = 12;
        if (intent.hasExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED)) {
            boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, Build.VERSION.SDK_INT < 23);
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i10 = intExtra;
            }
            this.mPacketsBeforeNotification = booleanExtra ? i10 : 0;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(service);
        boolean z10 = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, Build.VERSION.SDK_INT < 23);
        try {
            int i11 = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, String.valueOf(12)));
            if (i11 >= 0 && i11 <= 65535) {
                i10 = i11;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = z10 ? i10 : 0;
    }

    public static /* synthetic */ int access$108(BaseCustomDfuImpl baseCustomDfuImpl) {
        int i10 = baseCustomDfuImpl.mPacketsSentSinceNotification;
        baseCustomDfuImpl.mPacketsSentSinceNotification = i10 + 1;
        return i10;
    }

    private void writeInitPacket(final BluetoothGattCharacteristic characteristic, final byte[] buffer, final int size) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (buffer.length != size) {
            byte[] bArr = new byte[size];
            System.arraycopy(buffer, 0, bArr, 0, size);
            buffer = bArr;
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mInitPacketInProgress = true;
        characteristic.setWriteType(1);
        characteristic.setValue(buffer);
        logi("Sending init packet (Value = " + parse(buffer) + a.f26979d);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + characteristic.getUuid() + a.f26979d);
        this.mGatt.writeCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mInitPacketInProgress || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Init DFU Parameters", this.mError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePacket(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final byte[] buffer, final int size) {
        if (size <= 0) {
            return;
        }
        if (buffer.length != size) {
            byte[] bArr = new byte[size];
            System.arraycopy(buffer, 0, bArr, 0, size);
            buffer = bArr;
        }
        characteristic.setWriteType(1);
        characteristic.setValue(buffer);
        gatt.writeCharacteristic(characteristic);
    }

    public void finalize(final Intent intent, final boolean forceRefresh) {
        boolean z10;
        boolean z11 = false;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        this.mService.refreshDeviceCache(this.mGatt, forceRefresh || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(2000);
                z10 = true;
            } else {
                z10 = false;
            }
            if (!booleanExtra2 || (this.mFileType & 4) <= 0) {
                z11 = z10;
            } else {
                createBond();
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            if (!z11) {
                this.mService.waitFor(1400);
            }
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, DfuBaseService.MIME_TYPE_ZIP);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_TYPE, 4);
        intent2.putExtra(DfuBaseService.EXTRA_PART_CURRENT, this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra(DfuBaseService.EXTRA_PARTS_TOTAL, this.mProgressInfo.getTotalParts());
        restartService(intent2, true);
    }

    public abstract UUID getControlPointCharacteristicUUID();

    public abstract UUID getDfuServiceUUID();

    public abstract UUID getPacketCharacteristicUUID();

    public void uploadFirmwareImage(final BluetoothGattCharacteristic packetCharacteristic) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mFirmwareUploadInProgress = true;
        this.mPacketsSentSinceNotification = 0;
        byte[] bArr = this.mBuffer;
        try {
            int i10 = this.mFirmwareStream.read(bArr);
            this.mService.sendLogBroadcast(1, "Sending firmware to characteristic " + packetCharacteristic.getUuid() + "...");
            writePacket(this.mGatt, packetCharacteristic, bArr, i10);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((!this.mFirmwareUploadInProgress || this.mReceivedData != null || !this.mConnected || this.mError != 0) && !this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    }
                }
            } catch (InterruptedException e10) {
                loge("Sleeping interrupted", e10);
            }
            if (!this.mConnected) {
                throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected");
            }
            if (this.mError != 0) {
                throw new DfuException("Uploading Firmware Image failed", this.mError);
            }
        } catch (HexFileValidationException unused) {
            throw new DfuException("HEX file not valid", 4099);
        } catch (IOException unused2) {
            throw new DfuException("Error while reading file", 4100);
        }
    }

    public void writeInitData(final BluetoothGattCharacteristic characteristic, final CRC32 crc32) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int i10 = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (i10 == -1) {
                    return;
                }
                writeInitPacket(characteristic, bArr, i10);
                if (crc32 != null) {
                    crc32.update(bArr, 0, i10);
                }
            }
        } catch (IOException e10) {
            loge("Error while reading Init packet file", e10);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }
}
