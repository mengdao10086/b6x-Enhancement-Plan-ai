package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import ee.a;
import g.n0;
import g.p0;
import gg.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* JADX INFO: loaded from: classes5.dex */
class SecureDfuImpl extends BaseCustomDfuImpl {
    public static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    public static final UUID DEFAULT_DFU_PACKET_UUID;
    public static final UUID DEFAULT_DFU_SERVICE_UUID;
    public static UUID DFU_CONTROL_POINT_UUID = null;
    public static UUID DFU_PACKET_UUID = null;
    public static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM;
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND;
    private static final byte[] OP_CODE_CREATE_DATA;
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE;
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT;
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    public class ObjectChecksum {
        public int CRC32;
        public int offset;

        private ObjectChecksum() {
        }
    }

    public class ObjectInfo extends ObjectChecksum {
        public int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    public class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public SecureBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            if (characteristic.getValue() == null || characteristic.getValue().length < 3) {
                SecureDfuImpl.this.loge("Empty response: " + parse(characteristic));
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.mError = 4104;
                secureDfuImpl.notifyLock();
                return;
            }
            if (characteristic.getIntValue(17, 0).intValue() != 96) {
                SecureDfuImpl.this.loge("Invalid response: " + parse(characteristic));
                SecureDfuImpl.this.mError = 4104;
            } else if (characteristic.getIntValue(17, 1).intValue() == 3) {
                int iIntValue = characteristic.getIntValue(20, 3).intValue();
                if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == characteristic.getIntValue(20, 7).intValue()) {
                    SecureDfuImpl.this.mProgressInfo.setBytesReceived(iIntValue);
                } else {
                    SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                    if (secureDfuImpl2.mFirmwareUploadInProgress) {
                        secureDfuImpl2.mFirmwareUploadInProgress = false;
                        secureDfuImpl2.notifyLock();
                        return;
                    }
                }
                handlePacketReceiptNotification(gatt, characteristic);
            } else if (!SecureDfuImpl.this.mRemoteErrorOccurred) {
                if (characteristic.getIntValue(17, 2).intValue() != 1) {
                    SecureDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(gatt, characteristic);
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        OP_CODE_CREATE_COMMAND = new byte[]{1, 1, 0, 0, 0, 0};
        OP_CODE_CREATE_DATA = new byte[]{1, 2, 0, 0, 0, 0};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{2, 0, 0};
        OP_CODE_CALCULATE_CHECKSUM = new byte[]{3};
        OP_CODE_EXECUTE = new byte[]{4};
        OP_CODE_SELECT_OBJECT = new byte[]{6, 0};
    }

    public SecureDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        super(intent, service);
        this.mBluetoothCallback = new SecureBluetoothCallback();
    }

    private int getStatusCode(final byte[] response, final int request) throws UnknownResponseException {
        if (response != null && response.length >= 3 && response[0] == 96 && response[1] == request && (response[2] == 1 || response[2] == 2 || response[2] == 3 || response[2] == 4 || response[2] == 5 || response[2] == 7 || response[2] == 8 || response[2] == 10 || response[2] == 11)) {
            return response[2];
        }
        throw new UnknownResponseException("Invalid response received", response, 96, request);
    }

    private ObjectChecksum readChecksum() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 3);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Receiving Checksum failed", statusCode);
        }
        ObjectChecksum objectChecksum = new ObjectChecksum();
        objectChecksum.offset = this.mControlPointCharacteristic.getIntValue(20, 3).intValue();
        objectChecksum.CRC32 = this.mControlPointCharacteristic.getIntValue(20, 7).intValue();
        return objectChecksum;
    }

    private ObjectInfo selectObject(final int type) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
        byte[] bArr = OP_CODE_SELECT_OBJECT;
        bArr[1] = (byte) type;
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 6);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Selecting object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Selecting object failed", statusCode);
        }
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.maxSize = this.mControlPointCharacteristic.getIntValue(20, 3).intValue();
        objectInfo.offset = this.mControlPointCharacteristic.getIntValue(20, 7).intValue();
        objectInfo.CRC32 = this.mControlPointCharacteristic.getIntValue(20, 11).intValue();
        return objectInfo;
    }

    private void sendFirmware(final BluetoothGatt gatt) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        String str;
        int i10;
        String str2;
        boolean z10;
        long j10;
        long j11;
        boolean z11;
        boolean z12;
        String str3;
        int i11 = this.mPacketsBeforeNotification;
        if (i11 > 0) {
            setPacketReceiptNotifications(i11);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i11 + a.f26979d);
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo objectInfoSelectObject = selectObject(2);
        Locale locale = Locale.US;
        logi(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mProgressInfo.setMaxObjectSizeInBytes(objectInfoSelectObject.maxSize);
        int i12 = this.mImageSizeInBytes;
        int i13 = objectInfoSelectObject.maxSize;
        int i14 = ((i12 + i13) - 1) / i13;
        int i15 = objectInfoSelectObject.offset;
        if (i15 > 0) {
            try {
                int i16 = i15 / i13;
                int i17 = i13 * i16;
                int i18 = i15 - i17;
                if (i18 == 0) {
                    i17 -= i13;
                } else {
                    i13 = i18;
                }
                int i19 = i17;
                if (i19 > 0) {
                    i10 = i16;
                    str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
                    this.mFirmwareStream.read(new byte[i19]);
                    this.mFirmwareStream.mark(objectInfoSelectObject.maxSize);
                } else {
                    str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
                    i10 = i16;
                }
                this.mFirmwareStream.read(new byte[i13]);
                long crc32 = ((ArchiveInputStream) this.mFirmwareStream).getCrc32();
                str2 = a.f26979d;
                if (((int) (crc32 & 4294967295L)) == objectInfoSelectObject.CRC32) {
                    logi(objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(objectInfoSelectObject.offset);
                    this.mProgressInfo.setBytesReceived(objectInfoSelectObject.offset);
                    if (i13 != objectInfoSelectObject.maxSize || objectInfoSelectObject.offset >= this.mImageSizeInBytes) {
                        z10 = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute();
                        this.mService.sendLogBroadcast(10, "Data object executed");
                    }
                } else {
                    logi(objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i19);
                    this.mProgressInfo.setBytesReceived(i19);
                    objectInfoSelectObject.offset = objectInfoSelectObject.offset - i13;
                    objectInfoSelectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + objectInfoSelectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + objectInfoSelectObject.offset + "...");
                }
                z10 = false;
            } catch (IOException e10) {
                loge("Error while reading firmware stream", e10);
                this.mService.terminateConnection(gatt, 4100);
                return;
            }
        } else {
            str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
            str2 = a.f26979d;
            this.mProgressInfo.setBytesSent(0);
            z10 = false;
            i10 = 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (objectInfoSelectObject.offset < this.mImageSizeInBytes) {
            int i20 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (z10) {
                    j11 = jElapsedRealtime;
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z11 = false;
                } else {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Creating Data object (Op Code = 1, Type = 2, Size = ");
                    sb2.append(availableObjectSizeIsBytes);
                    sb2.append(") (");
                    int i21 = i10 + 1;
                    sb2.append(i21);
                    sb2.append(fh.a.f28350w);
                    sb2.append(i14);
                    sb2.append(str2);
                    logi(sb2.toString());
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    DfuBaseService dfuBaseService = this.mService;
                    StringBuilder sb3 = new StringBuilder();
                    j11 = jElapsedRealtime;
                    sb3.append("Data object (");
                    sb3.append(i21);
                    sb3.append(fh.a.f28350w);
                    sb3.append(i14);
                    sb3.append(") created");
                    dfuBaseService.sendLogBroadcast(10, sb3.toString());
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                    z11 = z10;
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    Locale locale2 = Locale.US;
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    int bytesSent = this.mProgressInfo.getBytesSent() - checksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            this.mFirmwareStream.reset();
                            this.mFirmwareStream.read(new byte[objectInfoSelectObject.maxSize - bytesSent]);
                            this.mProgressInfo.setBytesSent(checksum.offset);
                            this.mPacketsBeforeNotification = 1;
                            setPacketReceiptNotifications(1);
                            DfuBaseService dfuBaseService2 = this.mService;
                            StringBuilder sb4 = new StringBuilder();
                            z12 = z11;
                            str3 = str;
                            sb4.append(str3);
                            sb4.append(1);
                            sb4.append(str2);
                            dfuBaseService2.sendLogBroadcast(10, sb4.toString());
                        } catch (IOException e11) {
                            loge("Error while reading firmware stream", e11);
                            this.mService.terminateConnection(gatt, 4100);
                            return;
                        }
                    } else {
                        z12 = z11;
                        str3 = str;
                    }
                    int crc322 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L);
                    if (crc322 != checksum.CRC32) {
                        String str4 = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc322), Integer.valueOf(checksum.CRC32));
                        if (i20 >= 3) {
                            loge(str4);
                            this.mService.sendLogBroadcast(20, str4);
                            this.mService.terminateConnection(gatt, DfuBaseService.ERROR_CRC_ERROR);
                            return;
                        }
                        i20++;
                        String str5 = str4 + String.format(locale2, " Retrying...(%d/%d)", Integer.valueOf(i20), 3);
                        logi(str5);
                        this.mService.sendLogBroadcast(15, str5);
                        try {
                            this.mFirmwareStream.reset();
                            this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                        } catch (IOException e12) {
                            loge("Error while resetting the firmware stream", e12);
                            this.mService.terminateConnection(gatt, 4100);
                            return;
                        }
                    } else if (bytesSent > 0) {
                        str = str3;
                        jElapsedRealtime = j11;
                        z10 = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute(this.mProgressInfo.isComplete());
                        this.mService.sendLogBroadcast(10, "Data object executed");
                        i10++;
                        this.mFirmwareStream.mark(0);
                        i20 = 1;
                    }
                    str = str3;
                    z10 = z12;
                    jElapsedRealtime = j11;
                } catch (DeviceDisconnectedException e13) {
                    loge("Disconnected while sending data");
                    throw e13;
                }
            }
            j10 = jElapsedRealtime;
        } else {
            j10 = jElapsedRealtime;
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Transfer of ");
        sb5.append(this.mProgressInfo.getBytesSent() - objectInfoSelectObject.offset);
        sb5.append(" bytes has taken ");
        long j12 = jElapsedRealtime2 - j10;
        sb5.append(j12);
        sb5.append(" ms");
        logi(sb5.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j12 + " ms");
    }

    private void sendInitPacket(@n0 final BluetoothGatt gatt, final boolean allowResume) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        boolean z10;
        boolean z11;
        int i10;
        IOException iOException;
        CRC32 crc32 = new CRC32();
        logi("Setting object to Command (Op Code = 6, Type = 1)");
        ObjectInfo objectInfoSelectObject = selectObject(1);
        Locale locale = Locale.US;
        int i11 = 3;
        logi(String.format(locale, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(locale, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        int i12 = this.mInitPacketSizeInBytes;
        if (!allowResume || (i10 = objectInfoSelectObject.offset) <= 0 || i10 > i12) {
            z10 = false;
            z11 = false;
        } else {
            try {
                byte[] bArr = new byte[i10];
                this.mInitPacketStream.read(bArr);
                crc32.update(bArr);
                if (objectInfoSelectObject.CRC32 == ((int) (crc32.getValue() & 4294967295L))) {
                    logi("Init packet CRC is the same");
                    if (objectInfoSelectObject.offset == this.mInitPacketSizeInBytes) {
                        logi("-> Whole Init packet was sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Received CRC match Init packet");
                            z10 = true;
                            z11 = false;
                        } catch (IOException e10) {
                            iOException = e10;
                            z10 = true;
                            z11 = false;
                            loge("Error while reading " + objectInfoSelectObject.offset + " bytes from the init packet stream", iOException);
                            try {
                                this.mInitPacketStream.reset();
                                crc32.reset();
                                objectInfoSelectObject.offset = 0;
                            } catch (IOException e11) {
                                loge("Error while resetting the init packet stream", e11);
                                this.mService.terminateConnection(gatt, 4100);
                                return;
                            }
                        }
                    } else {
                        logi("-> " + objectInfoSelectObject.offset + " bytes of Init packet were sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Resuming sending Init packet...");
                            z10 = false;
                            z11 = true;
                        } catch (IOException e12) {
                            iOException = e12;
                            z10 = false;
                            z11 = true;
                            loge("Error while reading " + objectInfoSelectObject.offset + " bytes from the init packet stream", iOException);
                            this.mInitPacketStream.reset();
                            crc32.reset();
                            objectInfoSelectObject.offset = 0;
                        }
                    }
                } else {
                    this.mInitPacketStream.reset();
                    crc32.reset();
                    objectInfoSelectObject.offset = 0;
                    z10 = false;
                    z11 = false;
                }
            } catch (IOException e13) {
                iOException = e13;
                z10 = false;
            }
        }
        if (!z10) {
            setPacketReceiptNotifications(0);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif disabled (Op Code = 2, Value = 0)");
            int i13 = 1;
            while (i13 <= i11) {
                if (!z11) {
                    logi("Creating Init packet object (Op Code = 1, Type = 1, Size = " + this.mInitPacketSizeInBytes + a.f26979d);
                    writeCreateRequest(1, this.mInitPacketSizeInBytes);
                    this.mService.sendLogBroadcast(10, "Command object created");
                }
                try {
                    logi("Sending " + (this.mInitPacketSizeInBytes - objectInfoSelectObject.offset) + " bytes of init packet...");
                    writeInitData(this.mPacketCharacteristic, crc32);
                    int value = (int) (crc32.getValue() & 4294967295L);
                    DfuBaseService dfuBaseService = this.mService;
                    Locale locale2 = Locale.US;
                    dfuBaseService.sendLogBroadcast(10, String.format(locale2, "Command object sent (CRC = %08X)", Integer.valueOf(value)));
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    if (value == checksum.CRC32) {
                        break;
                    }
                    i11 = 3;
                    if (i13 >= 3) {
                        loge("CRC does not match!");
                        this.mService.sendLogBroadcast(20, "CRC does not match!");
                        this.mService.terminateConnection(gatt, DfuBaseService.ERROR_CRC_ERROR);
                        return;
                    }
                    i13++;
                    logi("CRC does not match! Retrying...(" + i13 + fh.a.f28350w + 3 + a.f26979d);
                    this.mService.sendLogBroadcast(15, "CRC does not match! Retrying...(" + i13 + fh.a.f28350w + 3 + a.f26979d);
                    try {
                        objectInfoSelectObject.offset = 0;
                        objectInfoSelectObject.CRC32 = 0;
                        this.mInitPacketStream.reset();
                        crc32.reset();
                        z11 = false;
                    } catch (IOException e14) {
                        loge("Error while resetting the init packet stream", e14);
                        this.mService.terminateConnection(gatt, 4100);
                        return;
                    }
                } catch (DeviceDisconnectedException e15) {
                    loge("Disconnected while sending init packet");
                    throw e15;
                }
            }
        }
        logi("Executing init packet (Op Code = 4)");
        writeExecute();
        this.mService.sendLogBroadcast(10, "Command object executed");
    }

    private void setNumberOfPackets(@n0 final byte[] data, final int value) {
        data[1] = (byte) (value & 255);
        data[2] = (byte) ((value >> 8) & 255);
    }

    private void setObjectSize(@n0 final byte[] data, final int value) {
        data[2] = (byte) (value & 255);
        data[3] = (byte) ((value >> 8) & 255);
        data[4] = (byte) ((value >> 16) & 255);
        data[5] = (byte) ((value >> 24) & 255);
    }

    private void setPacketReceiptNotifications(final int number) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        logi("Sending the number of packets before notifications (Op Code = 2, Value = " + number + a.f26979d);
        byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
        setNumberOfPackets(bArr, number);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 2);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Sending the number of packets failed", statusCode);
        }
    }

    private void writeCreateRequest(final int type, final int size) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
        byte[] bArr = type == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
        setObjectSize(bArr, size);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 1);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Creating Command object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Creating Command object failed", statusCode);
        }
    }

    private void writeExecute() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 4);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Executing object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Executing object failed", statusCode);
        }
    }

    private void writeOpCode(@n0 final BluetoothGattCharacteristic characteristic, @n0 final byte[] value) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        writeOpCode(characteristic, value, false);
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

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl, no.nordicsemi.android.dfu.DfuService
    public boolean initialize(@n0 final Intent intent, @n0 final BluetoothGatt gatt, @FileType final int fileType, @n0 final InputStream firmwareStream, @p0 final InputStream initPacketStream) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (initPacketStream != null) {
            return super.initialize(intent, gatt, fileType, firmwareStream, initPacketStream);
        }
        this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
        this.mService.terminateConnection(gatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
        return false;
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

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(@n0 final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Secure DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, b.f29422c0);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        try {
            try {
                enableCCCD(this.mControlPointCharacteristic, 1);
                this.mService.sendLogBroadcast(10, "Notifications enabled");
                this.mService.waitFor(1000);
                boolean z10 = (intent.hasExtra(DfuBaseService.EXTRA_DISABLE_RESUME) && intent.getBooleanExtra(DfuBaseService.EXTRA_DISABLE_RESUME, false)) ? false : true;
                if (!z10) {
                    logi("Resume feature disabled. Performing fresh DFU");
                }
                try {
                    sendInitPacket(bluetoothGatt, z10);
                } catch (RemoteDfuException e10) {
                    if (this.mProgressInfo.isLastPart()) {
                        throw e10;
                    }
                    this.mRemoteErrorOccurred = false;
                    logw("Sending SD+BL failed. Trying to send App only");
                    this.mService.sendLogBroadcast(15, "Invalid system components. Trying to send application");
                    this.mFileType = 4;
                    ArchiveInputStream archiveInputStream = (ArchiveInputStream) this.mFirmwareStream;
                    archiveInputStream.setContentType(4);
                    byte[] applicationInit = archiveInputStream.getApplicationInit();
                    this.mInitPacketStream = new ByteArrayInputStream(applicationInit);
                    this.mInitPacketSizeInBytes = applicationInit.length;
                    int iApplicationImageSize = archiveInputStream.applicationImageSize();
                    this.mImageSizeInBytes = iApplicationImageSize;
                    this.mProgressInfo.init(iApplicationImageSize, 2, 2);
                    sendInitPacket(bluetoothGatt, false);
                }
                sendFirmware(bluetoothGatt);
                this.mProgressInfo.setProgress(-5);
                this.mService.waitUntilDisconnected();
                this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                finalize(intent, false);
            } catch (RemoteDfuException e11) {
                int errorNumber = e11.getErrorNumber() | 512;
                loge(e11.getMessage() + ": " + SecureDfuError.parse(errorNumber));
                this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", SecureDfuError.parse(errorNumber)));
                if (!(e11 instanceof RemoteDfuExtendedErrorException)) {
                    this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
                    return;
                }
                RemoteDfuExtendedErrorException remoteDfuExtendedErrorException = (RemoteDfuExtendedErrorException) e11;
                int extendedErrorNumber = remoteDfuExtendedErrorException.getExtendedErrorNumber() | 1024;
                loge("Extended Error details: " + SecureDfuError.parseExtendedError(extendedErrorNumber));
                this.mService.sendLogBroadcast(20, "Details: " + SecureDfuError.parseExtendedError(extendedErrorNumber) + " (Code = " + remoteDfuExtendedErrorException.getExtendedErrorNumber() + a.f26979d);
                this.mService.terminateConnection(bluetoothGatt, extendedErrorNumber | 8192);
            }
        } catch (UnknownResponseException e12) {
            loge(e12.getMessage());
            this.mService.sendLogBroadcast(20, e12.getMessage());
            this.mService.terminateConnection(bluetoothGatt, 4104);
        } catch (UploadAbortedException e13) {
            throw e13;
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeExecute(final boolean allowRetry) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        try {
            writeExecute();
        } catch (RemoteDfuException e10) {
            if (allowRetry && e10.getErrorNumber() == 5) {
                logw(e10.getMessage() + ": " + SecureDfuError.parse(b.f29422c0));
                if (this.mFileType == 1) {
                    logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
                }
                this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", SecureDfuError.parse(b.f29422c0)));
                logi("SD busy? Retrying...");
                logi("Executing data object (Op Code = 4)");
                writeExecute();
                return;
            }
            throw e10;
        }
    }
}
