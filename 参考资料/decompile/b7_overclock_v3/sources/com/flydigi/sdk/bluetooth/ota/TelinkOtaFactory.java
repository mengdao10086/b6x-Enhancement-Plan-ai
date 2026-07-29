package com.flydigi.sdk.bluetooth.ota;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import j9.b;
import java.util.List;
import java.util.UUID;
import k9.c;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;
import kotlin.v1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class TelinkOtaFactory implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final TelinkOtaFactory f16306b = new TelinkOtaFactory();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16307c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16308d = 65281;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16309e = 65282;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16310f = 65286;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16311g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static BluetoothGattService f16312h;

    public enum OtaResult {
        OTA_RESULT_OTA_DATA_PACKET_SEQ_ERR(1),
        OTA_RESULT_OTA_PACKET_INVALID(2),
        OTA_RESULT_OTA_DATA_CRC_ERR(3),
        OTA_RESULT_OTA_WRITE_FLASH_ERR(4),
        OTA_RESULT_OTA_DATA_UNCOMPLETE(5),
        OTA_RESULT_OTA_FLOW_ERR(6),
        OTA_RESULT_OTA_FW_CHECK_ERR(7),
        OTA_RESULT_OTA_VERSION_COMPARE_ERR(8),
        OTA_RESULT_OTA_PDU_LEN_ERR(9),
        OTA_RESULT_OTA_FIRMWARE_MARK_ERR(10),
        OTA_RESULT_OTA_FW_SIZE_ERR(11),
        OTA_RESULT_OTA_DATA_PACKET_TIMEOUT(12),
        OTA_RESULT_OTA_TIMEOUT(13),
        OTA_RESULT_OTA_FAIL_DUE_TO_CONNECTION_TERMINATE(14);

        OtaResult(int i10) {
        }
    }

    public static /* synthetic */ byte[] s(TelinkOtaFactory telinkOtaFactory, int i10, byte[] bArr, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bArr = null;
        }
        return telinkOtaFactory.r(i10, bArr);
    }

    @Override // k9.c
    @k
    public Pair<UUID, b> a(@k byte[] total, int i10) {
        f0.p(total, "total");
        int length = total.length;
        int iQ = length % q() == 0 ? length / q() : (int) Math.floor((length / q()) + 1);
        int iQ2 = i10 + 1 == iQ ? length - (q() * i10) : q();
        int iQ3 = iQ2 == q() ? q() + 4 : (iQ2 % q() == 0 ? iQ2 : ((iQ2 / q()) + 1) * q()) + 4;
        byte[] bArr = new byte[iQ3];
        for (int i11 = 0; i11 < iQ3; i11++) {
            bArr[i11] = -1;
        }
        System.arraycopy(total, q() * i10, bArr, 2, iQ2);
        v(bArr, i10);
        u(bArr, t(bArr));
        return new Pair<>(f16306b.h(), new b(h(), bArr, Integer.valueOf(i10), Integer.valueOf(iQ), Boolean.FALSE, null, 5L, 32, null));
    }

    @Override // k9.c
    @l
    public BluetoothGattCharacteristic b(@l UUID uuid) {
        BluetoothGattService bluetoothGattService = f16312h;
        if (bluetoothGattService == null) {
            return null;
        }
        if (uuid == null) {
            uuid = h();
        }
        return bluetoothGattService.getCharacteristic(uuid);
    }

    @Override // k9.c
    @l
    public Byte c(@k byte[] value) {
        f0.p(value, "value");
        if (m(value)) {
            return Byte.valueOf(value[2]);
        }
        return null;
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<byte[]>> d(@l byte[] bArr) {
        return new Pair<>(h(), s.k(s(this, f16308d, null, 2, null)));
    }

    @Override // k9.c
    public boolean e(@k byte[] value) {
        f0.p(value, "value");
        return false;
    }

    @Override // k9.c
    @k
    public UUID f() {
        UUID uuidFromString = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")");
        return uuidFromString;
    }

    @Override // k9.c
    @l
    public Pair<BluetoothGattCharacteristic, BluetoothGattCharacteristic> g(int i10, @k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        BluetoothGattService service = gatt.getService(j());
        if (service == null) {
            return null;
        }
        TelinkOtaFactory telinkOtaFactory = f16306b;
        f16312h = service;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(telinkOtaFactory.h());
        gatt.setCharacteristicNotification(characteristic, true);
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(telinkOtaFactory.f());
        if (descriptor != null) {
            f0.o(descriptor, "getDescriptor(descriptorUUID)");
            descriptor.setValue(new byte[]{1, 0});
            gatt.writeDescriptor(descriptor);
        }
        return new Pair<>(characteristic, characteristic);
    }

    @Override // k9.c
    @k
    public UUID h() {
        UUID uuidFromString = UUID.fromString("00010203-0405-0607-0809-0a0b0c0d2b12");
        f0.o(uuidFromString, "fromString(\"00010203-0405-0607-0809-0a0b0c0d2b12\")");
        return uuidFromString;
    }

    @Override // k9.c
    public boolean i(@k byte[] value) {
        f0.p(value, "value");
        return m(value) && value[2] == 0;
    }

    @Override // k9.c
    @k
    public UUID j() {
        UUID uuidFromString = UUID.fromString("00010203-0405-0607-0809-0a0b0c0d1912");
        f0.o(uuidFromString, "fromString(\"00010203-0405-0607-0809-0a0b0c0d1912\")");
        return uuidFromString;
    }

    @Override // k9.c
    public boolean k(@k byte[] command) {
        f0.p(command, "command");
        return command.length == 6 && command[0] == 2 && command[1] == -1;
    }

    @Override // k9.c
    public boolean l(@k UUID first) {
        f0.p(first, "first");
        return false;
    }

    @Override // k9.c
    public boolean m(@k byte[] value) {
        f0.p(value, "value");
        return value.length == 4 && value[0] == 6 && value[1] == -1;
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<b>> n(int i10) {
        UUID uuidH = h();
        UUID uuidH2 = h();
        int i11 = ~i10;
        return new Pair<>(uuidH, s.k(new b(uuidH2, r(f16309e, new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255)}), null, null, null, null, null, 124, null)));
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<byte[]>> o() {
        return new Pair<>(h(), CollectionsKt__CollectionsKt.E());
    }

    @Override // k9.c
    public boolean p(@k byte[] value) {
        f0.p(value, "value");
        return true;
    }

    @Override // k9.c
    public int q() {
        return f16307c;
    }

    public final byte[] r(int i10, byte[] bArr) {
        if (bArr == null) {
            return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
        }
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = (byte) (i10 & 255);
        bArr2[1] = (byte) ((i10 >> 8) & 255);
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public final int t(byte[] bArr) {
        int length = bArr.length - 2;
        short[] sArr = {0, -24575};
        int i10 = 65535;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = bArr[i11];
            for (int i13 = 0; i13 < 8; i13++) {
                i10 = (sArr[(i10 ^ i12) & 1] & v1.f38215d) ^ (i10 >> 1);
                i12 >>= 1;
            }
        }
        return i10;
    }

    public final void u(byte[] bArr, int i10) {
        int length = bArr.length - 2;
        bArr[length] = (byte) (i10 & 255);
        bArr[length + 1] = (byte) ((i10 >> 8) & 255);
    }

    public final void v(byte[] bArr, int i10) {
        bArr[0] = (byte) (i10 & 255);
        bArr[1] = (byte) ((i10 >> 8) & 255);
    }
}
