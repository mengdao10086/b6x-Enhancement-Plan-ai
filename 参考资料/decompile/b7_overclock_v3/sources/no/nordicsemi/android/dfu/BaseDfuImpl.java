package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import ee.a;
import g.f0;
import g.n0;
import g.p0;
import g.v0;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;

/* JADX INFO: loaded from: classes5.dex */
abstract class BaseDfuImpl implements DfuService {
    public static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    public static final int NOTIFICATIONS = 1;
    private static final String TAG = "DfuImpl";
    public boolean mAborted;
    private int mCurrentMtu;
    public int mError;
    public int mFileType;
    public InputStream mFirmwareStream;
    public BluetoothGatt mGatt;
    public int mImageSizeInBytes;
    public int mInitPacketSizeInBytes;
    public InputStream mInitPacketStream;
    public boolean mPaused;
    public DfuProgressInfo mProgressInfo;
    public boolean mRequestCompleted;
    public boolean mResetRequestSent;
    public DfuBaseService mService;
    public static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    public static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public final Object mLock = new Object();
    public byte[] mReceivedData = null;
    public byte[] mBuffer = new byte[20];
    public boolean mConnected = true;

    public class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        public BaseBluetoothGattCallback() {
        }

        private String phyToString(final int phy) {
            if (phy == 1) {
                return "LE 1M";
            }
            if (phy == 2) {
                return "LE 2M";
            }
            if (phy == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + phy + a.f26979d;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            if (status == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                BaseDfuImpl.this.mReceivedData = characteristic.getValue();
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge("Characteristic read error: " + status);
                BaseDfuImpl.this.mError = status | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final int status) {
            if (status != 0) {
                BaseDfuImpl.this.loge("Descriptor read error: " + status);
                BaseDfuImpl.this.mError = status | 16384;
            } else if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(descriptor.getUuid())) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from descr." + descriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(descriptor));
                if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(descriptor.getCharacteristic().getUuid())) {
                    BaseDfuImpl.this.mRequestCompleted = true;
                } else {
                    BaseDfuImpl.this.loge("Unknown descriptor read");
                }
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final int status) {
            if (status != 0) {
                BaseDfuImpl.this.loge("Descriptor write error: " + status);
                BaseDfuImpl.this.mError = status | 16384;
            } else if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(descriptor.getUuid())) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Data written to descr." + descriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(descriptor));
                if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(descriptor.getCharacteristic().getUuid())) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(1, "Indications enabled for " + descriptor.getCharacteristic().getUuid());
                } else {
                    BaseDfuImpl.this.mService.sendLogBroadcast(1, "Notifications enabled for " + descriptor.getCharacteristic().getUuid());
                }
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.DfuCallback.DfuGattCallback
        public void onDisconnected() {
            BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
            baseDfuImpl.mConnected = false;
            baseDfuImpl.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(final BluetoothGatt gatt, final int mtu, final int status) {
            if (status == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: " + mtu);
                int i10 = mtu + (-3);
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                if (i10 > baseDfuImpl.mBuffer.length) {
                    baseDfuImpl.mBuffer = new byte[i10];
                }
                baseDfuImpl.logi("MTU changed to: " + mtu);
            } else {
                BaseDfuImpl.this.logw("Changing MTU failed: " + status + " (mtu: " + mtu + a.f26979d);
                if (status == 4 && BaseDfuImpl.this.mCurrentMtu > 23) {
                    int i11 = BaseDfuImpl.this.mCurrentMtu - 3;
                    BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
                    if (i11 > baseDfuImpl2.mBuffer.length) {
                        baseDfuImpl2.mBuffer = new byte[baseDfuImpl2.mCurrentMtu - 3];
                        BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                    }
                }
            }
            BaseDfuImpl baseDfuImpl3 = BaseDfuImpl.this;
            baseDfuImpl3.mRequestCompleted = true;
            baseDfuImpl3.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(final BluetoothGatt gatt, final int txPhy, final int rxPhy, final int status) {
            if (status != 0) {
                BaseDfuImpl.this.logw("Updating PHY failed: " + status + " (txPhy: " + txPhy + ", rxPhy: " + rxPhy + a.f26979d);
                return;
            }
            BaseDfuImpl.this.mService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(txPhy) + ", RX: " + phyToString(rxPhy) + a.f26979d);
            BaseDfuImpl.this.logi("PHY updated (TX: " + phyToString(txPhy) + ", RX: " + phyToString(rxPhy) + a.f26979d);
        }

        public String parse(final BluetoothGattCharacteristic characteristic) {
            return parse(characteristic.getValue());
        }

        public String parse(final BluetoothGattDescriptor descriptor) {
            return parse(descriptor.getValue());
        }

        private String parse(final byte[] data) {
            int length;
            if (data == null || (length = data.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = data[i10] & 255;
                int i12 = i10 * 3;
                cArr[i12] = BaseDfuImpl.HEX_ARRAY[i11 >>> 4];
                cArr[i12 + 1] = BaseDfuImpl.HEX_ARRAY[i11 & 15];
                if (i10 != length - 1) {
                    cArr[i12 + 2] = '-';
                }
            }
            return new String(cArr);
        }
    }

    public BaseDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        this.mService = service;
        this.mProgressInfo = service.mProgressInfo;
    }

    private boolean createBondApi18(@n0 final BluetoothDevice device) {
        try {
            Method method = device.getClass().getMethod("createBond", new Class[0]);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(device, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isServiceChangedCCCDEnabled() throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.isServiceChangedCCCDEnabled():boolean");
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    public boolean createBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 12) {
            return true;
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
        boolean zCreateBond = device.createBond();
        try {
            synchronized (this.mLock) {
                while (!this.mRequestCompleted && !this.mAborted) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        return zCreateBond;
    }

    public void enableCCCD(@n0 final BluetoothGattCharacteristic characteristic, final int type) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGatt bluetoothGatt = this.mGatt;
        String str = type == 1 ? "notifications" : "indications";
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
        boolean z10 = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
        if (z10) {
            return;
        }
        logi("Enabling " + str + "...");
        this.mService.sendLogBroadcast(1, "Enabling " + str + " for " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.setCharacteristicNotification(" + characteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(characteristic, true);
        descriptor.setValue(type == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        DfuBaseService dfuBaseService = this.mService;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("gatt.writeDescriptor(");
        sb2.append(descriptor.getUuid());
        sb2.append(type == 1 ? ", value=0x01-00)" : ", value=0x02-00)");
        dfuBaseService.sendLogBroadcast(0, sb2.toString());
        bluetoothGatt.writeDescriptor(descriptor);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (!z10) {
                        if (!this.mConnected || this.mError != 0) {
                        }
                        this.mLock.wait();
                        z10 = descriptor.getValue() == null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
                    }
                    if (!this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                    if (descriptor.getValue() == null) {
                    }
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mError == 0) {
            return;
        }
        throw new DfuException("Unable to set " + str + " state", this.mError);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean initialize(@n0 final Intent intent, @n0 final BluetoothGatt gatt, final int fileType, @n0 final InputStream firmwareStream, @p0 final InputStream initPacketStream) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        int iAvailable;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.mGatt = gatt;
        this.mFileType = fileType;
        this.mFirmwareStream = firmwareStream;
        this.mInitPacketStream = initPacketStream;
        int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PART_CURRENT, 1);
        int intExtra2 = intent.getIntExtra(DfuBaseService.EXTRA_PARTS_TOTAL, 1);
        this.mCurrentMtu = intent.getIntExtra(DfuBaseService.EXTRA_CURRENT_MTU, 23);
        if (fileType > 4) {
            logw("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.mService.sendLogBroadcast(15, "Sending system components");
            int i10 = this.mFileType & (-5);
            this.mFileType = i10;
            ((ArchiveInputStream) this.mFirmwareStream).setContentType(i10);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.mService.sendLogBroadcast(15, "Sending application");
        }
        int iAvailable2 = 0;
        if (initPacketStream != null) {
            try {
                if (initPacketStream.markSupported()) {
                    initPacketStream.reset();
                }
                iAvailable = initPacketStream.available();
            } catch (Exception unused) {
                iAvailable = 0;
            }
        } else {
            iAvailable = 0;
        }
        this.mInitPacketSizeInBytes = iAvailable;
        try {
            if (firmwareStream.markSupported()) {
                if (firmwareStream instanceof ArchiveInputStream) {
                    ((ArchiveInputStream) firmwareStream).fullReset();
                } else {
                    firmwareStream.reset();
                }
            }
            iAvailable2 = firmwareStream.available();
        } catch (Exception unused2) {
        }
        this.mImageSizeInBytes = iAvailable2;
        this.mProgressInfo.init(iAvailable2, intExtra, intExtra2);
        if (gatt.getDevice().getBondState() == 12 && (service = gatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID)) != null && (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) != null) {
            if (!isServiceChangedCCCDEnabled()) {
                enableCCCD(characteristic, 2);
            }
            this.mService.sendLogBroadcast(10, "Service Changed indications enabled");
        }
        return true;
    }

    public boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    public void loge(final String message) {
    }

    public void loge(final String message, final Throwable e10) {
    }

    public void logi(final String message) {
        boolean z10 = DfuBaseService.DEBUG;
    }

    public void logw(final String message) {
        boolean z10 = DfuBaseService.DEBUG;
    }

    public void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(final int state) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    public String parse(@p0 final byte[] data) {
        int length;
        if (data == null || (length = data.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = data[i10] & 255;
            int i12 = i10 * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
            if (i10 != length - 1) {
                cArr[i12 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    public byte[] readNotificationResponse() throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData != null || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        }
        if (this.mError == 0) {
            return this.mReceivedData;
        }
        throw new DfuException("Unable to write Op Code", this.mError);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void release() {
        this.mService = null;
    }

    public boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean zBooleanValue = false;
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            zBooleanValue = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e10) {
                loge("Sleeping interrupted", e10);
            }
        } catch (Exception unused) {
        }
        return zBooleanValue;
    }

    @v0(api = 21)
    public void requestMtu(@f0(from = 0, to = 517) final int mtu) throws UploadAbortedException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Requesting new MTU...");
        this.mService.sendLogBroadcast(0, "gatt.requestMtu(" + mtu + a.f26979d);
        if (this.mGatt.requestMtu(mtu)) {
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
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
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            }
        }
    }

    public void restartService(@n0 final Intent intent, final boolean scanForBootloader) {
        String strSearchFor;
        if (scanForBootloader) {
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader...");
            strSearchFor = BootloaderScannerFactory.getScanner().searchFor(this.mGatt.getDevice().getAddress());
            logi("Scanning for new address finished with: " + strSearchFor);
            if (strSearchFor != null) {
                this.mService.sendLogBroadcast(5, "DFU Bootloader found with address " + strSearchFor);
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            strSearchFor = null;
        }
        if (strSearchFor != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, strSearchFor);
        }
        intent.putExtra(DfuBaseService.EXTRA_DFU_ATTEMPT, 0);
        this.mService.startService(intent);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    public void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
    }

    public void writeOpCode(@n0 final BluetoothGattCharacteristic characteristic, @n0 final byte[] value, final boolean reset) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mRequestCompleted = false;
        this.mResetRequestSent = reset;
        characteristic.setWriteType(2);
        characteristic.setValue(value);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + characteristic.getUuid() + a.f26979d);
        this.mGatt.writeCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        boolean z10 = this.mResetRequestSent;
        if (!z10 && !this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code " + ((int) value[0]) + ": device disconnected");
        }
        if (z10 || this.mError == 0) {
            return;
        }
        throw new DfuException("Unable to write Op Code " + ((int) value[0]), this.mError);
    }
}
