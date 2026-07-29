package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import ee.a;
import g.n0;
import g.p0;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes5.dex */
class LegacyDfuImpl extends BaseCustomDfuImpl {
    public static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    public static final UUID DEFAULT_DFU_PACKET_UUID;
    public static final UUID DEFAULT_DFU_SERVICE_UUID;
    public static final UUID DEFAULT_DFU_VERSION_UUID;
    public static UUID DFU_CONTROL_POINT_UUID = null;
    public static UUID DFU_PACKET_UUID = null;
    public static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    public static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public LegacyBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            if (characteristic.getIntValue(17, 0).intValue() == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(characteristic.getIntValue(20, 1).intValue());
                handlePacketReceiptNotification(gatt, characteristic);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if (characteristic.getIntValue(17, 2).intValue() != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(gatt, characteristic);
            }
            LegacyDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        public void onPacketCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }
    }

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    public LegacyDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        super(intent, service);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    private int getStatusCode(@p0 final byte[] response, final int request) throws UnknownResponseException {
        if (response == null || response.length != 3 || response[0] != 16 || response[1] != request || response[2] < 1 || response[2] > 6) {
            throw new UnknownResponseException("Invalid response received", response, 16, request);
        }
        return response[2];
    }

    private int readVersion(@p0 final BluetoothGattCharacteristic characteristic) {
        if (characteristic != null) {
            return characteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void resetAndRestart(@n0 final BluetoothGatt gatt, @n0 final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = gatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(gatt, !((service == null || service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(gatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }

    private void setNumberOfPackets(@n0 final byte[] data, final int value) {
        data[1] = (byte) (value & 255);
        data[2] = (byte) ((value >> 8) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeImageSize(@g.n0 final android.bluetooth.BluetoothGattCharacteristic r5, final int r6) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            r4 = this;
            r0 = 0
            r4.mReceivedData = r0
            r0 = 0
            r4.mError = r0
            r1 = 1
            r4.mImageSizeInProgress = r1
            r5.setWriteType(r1)
            r2 = 4
            byte[] r2 = new byte[r2]
            r5.setValue(r2)
            r2 = 20
            r5.setValue(r6, r2, r0)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Writing to characteristic "
            r2.append(r3)
            java.util.UUID r3 = r5.getUuid()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.sendLogBroadcast(r1, r2)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "gatt.writeCharacteristic("
            r1.append(r2)
            java.util.UUID r2 = r5.getUuid()
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.sendLogBroadcast(r0, r1)
            android.bluetooth.BluetoothGatt r6 = r4.mGatt
            r6.writeCharacteristic(r5)
            java.lang.Object r5 = r4.mLock     // Catch: java.lang.InterruptedException -> L77
            monitor-enter(r5)     // Catch: java.lang.InterruptedException -> L77
        L58:
            boolean r6 = r4.mImageSizeInProgress     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L68
            boolean r6 = r4.mConnected     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L68
            int r6 = r4.mError     // Catch: java.lang.Throwable -> L74
            if (r6 != 0) goto L68
            boolean r6 = r4.mAborted     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L6c
        L68:
            boolean r6 = r4.mPaused     // Catch: java.lang.Throwable -> L74
            if (r6 == 0) goto L72
        L6c:
            java.lang.Object r6 = r4.mLock     // Catch: java.lang.Throwable -> L74
            r6.wait()     // Catch: java.lang.Throwable -> L74
            goto L58
        L72:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L74
            goto L7d
        L74:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L74
            throw r6     // Catch: java.lang.InterruptedException -> L77
        L77:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.loge(r6, r5)
        L7d:
            boolean r5 = r4.mAborted
            if (r5 != 0) goto L9c
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L94
            int r5 = r4.mError
            if (r5 != 0) goto L8a
            return
        L8a:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r6 = "Unable to write Image Size"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        L94:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to write Image Size: device disconnected"
            r5.<init>(r6)
            throw r5
        L9c:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.writeImageSize(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    private void writeOpCode(@n0 final BluetoothGattCharacteristic characteristic, @n0 final byte[] value) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        writeOpCode(characteristic, value, value[0] == 6 || value[0] == 5);
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@n0 final Intent intent, @n0 final BluetoothGatt gatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = gatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        return characteristic2 != null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:159|36|37|(6:169|38|39|164|40|41)|(3:174|43|44)(12:47|(5:50|51|162|52|53)|80|98|(4:100|(1:102)(1:103)|104|(1:106)(2:107|108))|(1:116)(1:115)|(1:118)|119|172|120|121|(2:123|(4:125|(1:127)(1:128)|129|179)(2:130|131))(2:132|133))|67|68|166|69|(1:178)(2:74|(2:76|77)(12:78|(2:81|82)|80|98|(0)|(4:110|112|114|116)(0)|(0)|119|172|120|121|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0650, code lost:
    
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException(r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0651, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0653, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0666, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0304, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x030b, code lost:
    
        if (r0.getErrorNumber() != 3) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0310, code lost:
    
        r28.mRemoteErrorOccurred = false;
        logw("DFU target does not support DFU v.2");
        r28.mService.sendLogBroadcast(15, "DFU target does not support DFU v.2");
        r28.mService.sendLogBroadcast(1, "Switching to DFU v.1");
        logi("Resending Start DFU command (Op Code = 1)");
        writeOpCode(r28.mControlPointCharacteristic, no.nordicsemi.android.dfu.LegacyDfuImpl.OP_CODE_START_DFU_V1);
        r28.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1)");
        logi("Sending application image size to DFU Packet: " + r28.mImageSizeInBytes + " bytes");
        writeImageSize(r28.mPacketCharacteristic, r28.mImageSizeInBytes);
        r28.mService.sendLogBroadcast(10, "Firmware image size sent (" + r28.mImageSizeInBytes + " bytes)");
        r3 = readNotificationResponse();
        r5 = getStatusCode(r3, 1);
        r4 = r28.mService;
        r7 = new java.lang.StringBuilder();
        r7.append("Response received (Op Code = ");
        r7.append((int) r3[1]);
        r3 = ", Status = ";
        r7.append(r3);
        r7.append(r5);
        r7.append(ee.a.f26979d);
        r4.sendLogBroadcast(10, r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03ab, code lost:
    
        if (r5 == 2) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03ad, code lost:
    
        resetAndRestart(r14, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03b0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03b2, code lost:
    
        if (r5 == 1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03b4, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03b9 A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:87:0x0306, B:91:0x0310, B:93:0x03ad, B:98:0x03b5, B:100:0x03b9, B:102:0x03c4, B:104:0x0434, B:107:0x0463, B:108:0x046a, B:103:0x0407, B:110:0x046d, B:118:0x047d, B:119:0x04bb, B:120:0x04da, B:121:0x04ed, B:123:0x054b, B:125:0x05ff, B:129:0x062e, B:130:0x0633, B:131:0x063a, B:132:0x063b, B:133:0x0642, B:135:0x0644, B:136:0x064a, B:116:0x0479, B:137:0x064b, B:138:0x0650, B:139:0x0651, B:140:0x0652), top: B:161:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0479 A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:87:0x0306, B:91:0x0310, B:93:0x03ad, B:98:0x03b5, B:100:0x03b9, B:102:0x03c4, B:104:0x0434, B:107:0x0463, B:108:0x046a, B:103:0x0407, B:110:0x046d, B:118:0x047d, B:119:0x04bb, B:120:0x04da, B:121:0x04ed, B:123:0x054b, B:125:0x05ff, B:129:0x062e, B:130:0x0633, B:131:0x063a, B:132:0x063b, B:133:0x0642, B:135:0x0644, B:136:0x064a, B:116:0x0479, B:137:0x064b, B:138:0x0650, B:139:0x0651, B:140:0x0652), top: B:161:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x047d A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:87:0x0306, B:91:0x0310, B:93:0x03ad, B:98:0x03b5, B:100:0x03b9, B:102:0x03c4, B:104:0x0434, B:107:0x0463, B:108:0x046a, B:103:0x0407, B:110:0x046d, B:118:0x047d, B:119:0x04bb, B:120:0x04da, B:121:0x04ed, B:123:0x054b, B:125:0x05ff, B:129:0x062e, B:130:0x0633, B:131:0x063a, B:132:0x063b, B:133:0x0642, B:135:0x0644, B:136:0x064a, B:116:0x0479, B:137:0x064b, B:138:0x0650, B:139:0x0651, B:140:0x0652), top: B:161:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x054b A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:87:0x0306, B:91:0x0310, B:93:0x03ad, B:98:0x03b5, B:100:0x03b9, B:102:0x03c4, B:104:0x0434, B:107:0x0463, B:108:0x046a, B:103:0x0407, B:110:0x046d, B:118:0x047d, B:119:0x04bb, B:120:0x04da, B:121:0x04ed, B:123:0x054b, B:125:0x05ff, B:129:0x062e, B:130:0x0633, B:131:0x063a, B:132:0x063b, B:133:0x0642, B:135:0x0644, B:136:0x064a, B:116:0x0479, B:137:0x064b, B:138:0x0650, B:139:0x0651, B:140:0x0652), top: B:161:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x063b A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:87:0x0306, B:91:0x0310, B:93:0x03ad, B:98:0x03b5, B:100:0x03b9, B:102:0x03c4, B:104:0x0434, B:107:0x0463, B:108:0x046a, B:103:0x0407, B:110:0x046d, B:118:0x047d, B:119:0x04bb, B:120:0x04da, B:121:0x04ed, B:123:0x054b, B:125:0x05ff, B:129:0x062e, B:130:0x0633, B:131:0x063a, B:132:0x063b, B:133:0x0642, B:135:0x0644, B:136:0x064a, B:116:0x0479, B:137:0x064b, B:138:0x0650, B:139:0x0651, B:140:0x0652), top: B:161:0x0306 }] */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void performDfu(@g.n0 final android.content.Intent r29) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            Method dump skipped, instruction units count: 1802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeImageSize(@n0 final BluetoothGattCharacteristic characteristic, final int softDeviceImageSize, final int bootloaderImageSize, final int appImageSize) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        characteristic.setWriteType(1);
        characteristic.setValue(new byte[12]);
        characteristic.setValue(softDeviceImageSize, 20, 0);
        characteristic.setValue(bootloaderImageSize, 20, 4);
        characteristic.setValue(appImageSize, 20, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + characteristic.getUuid() + a.f26979d);
        this.mGatt.writeCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Sizes", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
        throw new UploadAbortedException();
    }
}
