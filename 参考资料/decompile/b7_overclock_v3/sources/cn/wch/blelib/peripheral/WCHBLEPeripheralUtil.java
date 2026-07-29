package cn.wch.blelib.peripheral;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import cn.wch.blelib.exception.BLEPeripheralException;
import com.blankj.utilcode.util.i0;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import e3.b;
import e3.c;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@v0(api = 21)
public class WCHBLEPeripheralUtil {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static WCHBLEPeripheralUtil f11075m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothManager f11076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothLeAdvertiser f11077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdvertiseCallback f11078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGattServer f11079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d3.a f11080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11081f = 10000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NOTIFY_STATE f11082g = NOTIFY_STATE.STATE_PREPARE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11083h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11084i = 23;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11085j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11086k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BluetoothGattServerCallback f11087l = new a();

    public enum NOTIFY_STATE {
        STATE_PREPARE,
        STATE_SUCCESS,
        STATE_FAIL
    }

    public class a extends BluetoothGattServerCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i10, int i11, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicReadRequest(bluetoothDevice, i10, i11, bluetoothGattCharacteristic);
            c.a(String.format("onCharacteristicReadRequest：device name = %s, address = %s,char = %s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), bluetoothGattCharacteristic.getUuid().toString()));
            c.a(String.format("onCharacteristicReadRequest：requestId = %s, offset = %s", Integer.valueOf(i10), Integer.valueOf(i11)));
            if (WCHBLEPeripheralUtil.this.f11080e != null) {
                WCHBLEPeripheralUtil.this.f11080e.c(bluetoothDevice, i10, i11, bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i10, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10, boolean z11, int i11, byte[] bArr) {
            c.a(String.format(Locale.getDefault(), "onCharacteristicWriteRequest(%d):%s,%s,%s,%s,%s,%s,%s,%s", Integer.valueOf(bArr.length), bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i10), bluetoothGattCharacteristic.getUuid(), Boolean.valueOf(z10), Boolean.valueOf(z11), Integer.valueOf(i11), b.a(bArr)));
            bluetoothGattCharacteristic.setValue(bArr);
            if (WCHBLEPeripheralUtil.this.f11080e != null) {
                WCHBLEPeripheralUtil.this.f11080e.b(bluetoothDevice, i10, bluetoothGattCharacteristic, z10, z11, i11, bArr);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i10, int i11) {
            c.a("onConnectionStateChange status=" + i10 + "->" + i11);
            if (i11 == 0) {
                WCHBLEPeripheralUtil.this.f11086k = false;
                if (WCHBLEPeripheralUtil.this.f11080e != null) {
                    WCHBLEPeripheralUtil.this.f11080e.f(bluetoothDevice);
                    return;
                }
                return;
            }
            if (i11 == 2) {
                WCHBLEPeripheralUtil.this.f11086k = true;
                WCHBLEPeripheralUtil.j().g(bluetoothDevice, false);
                if (WCHBLEPeripheralUtil.this.f11080e != null) {
                    WCHBLEPeripheralUtil.this.f11080e.e(bluetoothDevice);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i10, int i11, BluetoothGattDescriptor bluetoothGattDescriptor) {
            c.a(String.format("onDescriptorReadRequest:%s,%s,%s,%s,%s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i10), Integer.valueOf(i11), bluetoothGattDescriptor.getUuid()));
            if (WCHBLEPeripheralUtil.this.f11080e != null) {
                WCHBLEPeripheralUtil.this.f11080e.a(bluetoothDevice, i10, i11, bluetoothGattDescriptor);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i10, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z10, boolean z11, int i11, byte[] bArr) {
            c.a(String.format("onDescriptorWriteRequest:%s,%s,%s,%s,%s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i10), Integer.valueOf(i11), bluetoothGattDescriptor.getUuid()));
            c.a("onDescriptorWriteRequest:" + b.a(bArr));
            bluetoothGattDescriptor.setValue(bArr);
            if (WCHBLEPeripheralUtil.this.f11080e != null) {
                WCHBLEPeripheralUtil.this.f11080e.d(bluetoothDevice, i10, bluetoothGattDescriptor, z10, z11, i11, bArr);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i10, boolean z10) {
            c.a(String.format("onExecuteWrite:%s,%s,%s,%s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i10), Boolean.valueOf(z10)));
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onMtuChanged(BluetoothDevice bluetoothDevice, int i10) {
            c.a(String.format("onMtuChanged:%s,%s,%s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i10)));
            WCHBLEPeripheralUtil.this.f11084i = i10;
            if (WCHBLEPeripheralUtil.this.f11080e != null) {
                WCHBLEPeripheralUtil.this.f11080e.g(bluetoothDevice, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onNotificationSent(BluetoothDevice bluetoothDevice, int i10) {
            c.a(String.format("onNotificationSent:%s,%s,%s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i10)));
            if (i10 == 0) {
                WCHBLEPeripheralUtil.this.f11082g = NOTIFY_STATE.STATE_SUCCESS;
            } else {
                WCHBLEPeripheralUtil.this.f11082g = NOTIFY_STATE.STATE_FAIL;
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onServiceAdded(int i10, BluetoothGattService bluetoothGattService) {
            c.a("onServiceAdded " + bluetoothGattService.getUuid().toString() + i0.f11861z + i10);
        }
    }

    public static WCHBLEPeripheralUtil j() {
        if (f11075m == null) {
            f11075m = new WCHBLEPeripheralUtil();
        }
        return f11075m;
    }

    public void e() {
        AdvertiseCallback advertiseCallback;
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f11077b;
        if (bluetoothLeAdvertiser == null || (advertiseCallback = this.f11078c) == null) {
            return;
        }
        bluetoothLeAdvertiser.stopAdvertising(advertiseCallback);
        this.f11078c = null;
    }

    public void f() {
        BluetoothGattServer bluetoothGattServer = this.f11079d;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.close();
            this.f11079d = null;
        }
        this.f11086k = false;
    }

    public boolean g(BluetoothDevice bluetoothDevice, boolean z10) {
        BluetoothGattServer bluetoothGattServer = this.f11079d;
        if (bluetoothGattServer == null) {
            return false;
        }
        return bluetoothGattServer.connect(bluetoothDevice, z10);
    }

    public void h(@n0 BluetoothDevice bluetoothDevice) {
        BluetoothGattServer bluetoothGattServer;
        if (bluetoothDevice == null || (bluetoothGattServer = this.f11079d) == null) {
            return;
        }
        bluetoothGattServer.cancelConnection(bluetoothDevice);
    }

    public BluetoothGattServer i() {
        return this.f11079d;
    }

    public int k() {
        return this.f11084i;
    }

    public void l(Application application) throws BLEPeripheralException {
        if (BluetoothAdapter.getDefaultAdapter() == null) {
            throw new BLEPeripheralException("BluetoothAdapter is null");
        }
        if (!BluetoothAdapter.getDefaultAdapter().isMultipleAdvertisementSupported()) {
            throw new BLEPeripheralException("该设备不支持广播功能");
        }
        if (this.f11077b == null) {
            this.f11077b = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
        }
        this.f11076a = (BluetoothManager) application.getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
    }

    public boolean m() {
        return this.f11086k;
    }

    public boolean n(UUID uuid, UUID uuid2) throws BLEPeripheralException {
        c.a("isNotifyEnabled");
        if (i() == null) {
            throw new BLEPeripheralException("gattServer is null");
        }
        BluetoothGattService service = i().getService(uuid);
        if (service == null) {
            throw new BLEPeripheralException("service don't exist");
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        if (characteristic == null) {
            throw new BLEPeripheralException("characteristic don't exist");
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (descriptor == null) {
            throw new BLEPeripheralException("this characteristic don't contain 00002902-0000-1000-8000-00805f9b34fb descriptor");
        }
        c.a("descriptor :" + b.a(descriptor.getValue()));
        return Arrays.equals(descriptor.getValue(), BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    }

    public int o(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10, @n0 byte[] bArr, int i10) {
        int iMin = Math.min(bArr.length, i10);
        this.f11083h = false;
        int iK = k() - 3;
        int i11 = iMin / iK;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            byte[] bArr2 = new byte[iK];
            System.arraycopy(bArr, i13 * iK, bArr2, 0, iK);
            if (!p(bluetoothDevice, bluetoothGattCharacteristic, z10, bArr2)) {
                return i12;
            }
            i12 += iK;
            if (i13 == i11 - 1 && iMin % iK == 0) {
                break;
            }
        }
        int i14 = iMin % iK;
        byte[] bArr3 = new byte[i14];
        if (i14 == 0) {
            return i12;
        }
        System.arraycopy(bArr, i11 * iK, bArr3, 0, i14);
        if (!p(bluetoothDevice, bluetoothGattCharacteristic, z10, bArr3)) {
            return i12;
        }
        c.a("final write " + i14);
        return i12 + i14;
    }

    public boolean p(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10, @n0 byte[] bArr) {
        if (this.f11083h || this.f11079d == null || bluetoothDevice == null || bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 16) == 0) {
            return false;
        }
        c.a(String.format(Locale.getDefault(), "notifyCharacteristicChanged(%d)：%s", Integer.valueOf(bArr.length), b.a(bArr)));
        this.f11082g = NOTIFY_STATE.STATE_PREPARE;
        if (bluetoothGattCharacteristic.setValue(bArr) && this.f11079d.notifyCharacteristicChanged(bluetoothDevice, bluetoothGattCharacteristic, z10)) {
            return q(10000);
        }
        return false;
    }

    public boolean q(int i10) {
        while (i10 > 0) {
            NOTIFY_STATE notify_state = this.f11082g;
            if (notify_state == NOTIFY_STATE.STATE_SUCCESS) {
                return true;
            }
            if (notify_state == NOTIFY_STATE.STATE_FAIL) {
                return false;
            }
            i10--;
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        c.a("notify wait Timeout!");
        return false;
    }

    public void r(@n0 Context context, @p0 ArrayList<BluetoothGattService> arrayList) throws BLEPeripheralException {
        if (this.f11079d != null) {
            throw new BLEPeripheralException("BluetoothGattServer is running,invoke closeGattServer() first");
        }
        BluetoothManager bluetoothManager = this.f11076a;
        if (bluetoothManager != null) {
            BluetoothGattServer bluetoothGattServerOpenGattServer = bluetoothManager.openGattServer(context, this.f11087l);
            this.f11079d = bluetoothGattServerOpenGattServer;
            if (bluetoothGattServerOpenGattServer == null) {
                throw new BLEPeripheralException("BluetoothGattServer is null");
            }
            if (bluetoothGattServerOpenGattServer != null) {
                Iterator<BluetoothGattService> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.f11079d.addService(it2.next());
                }
            }
        }
    }

    public boolean s(BluetoothDevice bluetoothDevice, int i10, int i11, int i12, byte[] bArr) {
        if (this.f11079d == null) {
            return false;
        }
        c.a("sendResponse");
        return this.f11079d.sendResponse(bluetoothDevice, i10, i11, i12, bArr);
    }

    public void t(d3.a aVar) {
        this.f11080e = aVar;
    }

    public void u(@n0 AdvertiseSettings advertiseSettings, @n0 AdvertiseData advertiseData, @p0 AdvertiseData advertiseData2, @n0 AdvertiseCallback advertiseCallback) throws BLEPeripheralException {
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f11077b;
        if (bluetoothLeAdvertiser == null) {
            throw new BLEPeripheralException("BluetoothLeAdvertiser is null");
        }
        this.f11078c = advertiseCallback;
        if (advertiseData2 == null) {
            bluetoothLeAdvertiser.startAdvertising(advertiseSettings, advertiseData, advertiseCallback);
        } else {
            bluetoothLeAdvertiser.startAdvertising(advertiseSettings, advertiseData, advertiseData2, advertiseCallback);
        }
    }

    public void v() throws BLEPeripheralException {
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f11077b;
        if (bluetoothLeAdvertiser == null) {
            throw new BLEPeripheralException("BluetoothLeAdvertiser is null");
        }
        AdvertiseCallback advertiseCallback = this.f11078c;
        if (advertiseCallback == null) {
            throw new BLEPeripheralException("AdvertiseCallback is null");
        }
        bluetoothLeAdvertiser.stopAdvertising(advertiseCallback);
        this.f11078c = null;
    }

    public void w() {
        this.f11083h = true;
    }
}
