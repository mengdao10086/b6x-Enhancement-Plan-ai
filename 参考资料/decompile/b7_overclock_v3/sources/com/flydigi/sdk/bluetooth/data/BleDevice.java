package com.flydigi.sdk.bluetooth.data;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
public final class BleDevice implements Parcelable {

    @k
    public static final Parcelable.Creator<BleDevice> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final BluetoothDevice f16266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public String f16267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public byte[] f16269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f16270e;

    public static final class a implements Parcelable.Creator<BleDevice> {
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BleDevice createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new BleDevice((BluetoothDevice) parcel.readParcelable(BleDevice.class.getClassLoader()), parcel.readString(), parcel.readInt(), parcel.createByteArray(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BleDevice[] newArray(int i10) {
            return new BleDevice[i10];
        }
    }

    public BleDevice(@k BluetoothDevice device, @l String str, int i10, @l byte[] bArr, long j10) {
        f0.p(device, "device");
        this.f16266a = device;
        this.f16267b = str;
        this.f16268c = i10;
        this.f16269d = bArr;
        this.f16270e = j10;
    }

    public static /* synthetic */ BleDevice z(BleDevice bleDevice, BluetoothDevice bluetoothDevice, String str, int i10, byte[] bArr, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bluetoothDevice = bleDevice.f16266a;
        }
        if ((i11 & 2) != 0) {
            str = bleDevice.f16267b;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            i10 = bleDevice.f16268c;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            bArr = bleDevice.f16269d;
        }
        byte[] bArr2 = bArr;
        if ((i11 & 16) != 0) {
            j10 = bleDevice.f16270e;
        }
        return bleDevice.s(bluetoothDevice, str2, i12, bArr2, j10);
    }

    @l
    public final byte[] C() {
        return this.f16269d;
    }

    @k
    public final BluetoothDevice F() {
        return this.f16266a;
    }

    @l
    public final String M() {
        return this.f16267b;
    }

    public final int S() {
        return this.f16268c;
    }

    public final long T() {
        return this.f16270e;
    }

    public final void U(@l byte[] bArr) {
        this.f16269d = bArr;
    }

    public final void V(@l String str) {
        this.f16267b = str;
    }

    public final void W(int i10) {
        this.f16268c = i10;
    }

    public final void X(long j10) {
        this.f16270e = j10;
    }

    @k
    public final BluetoothDevice a() {
        return this.f16266a;
    }

    @l
    public final String b() {
        return this.f16267b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f16268c;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDevice)) {
            return false;
        }
        BleDevice bleDevice = (BleDevice) obj;
        return f0.g(this.f16266a, bleDevice.f16266a) && f0.g(this.f16267b, bleDevice.f16267b) && this.f16268c == bleDevice.f16268c && f0.g(this.f16269d, bleDevice.f16269d) && this.f16270e == bleDevice.f16270e;
    }

    @l
    public final byte[] g() {
        return this.f16269d;
    }

    public int hashCode() {
        int iHashCode = this.f16266a.hashCode() * 31;
        String str = this.f16267b;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f16268c) * 31;
        byte[] bArr = this.f16269d;
        return ((iHashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + com.flydigi.data.bean.a.a(this.f16270e);
    }

    public final long j() {
        return this.f16270e;
    }

    @k
    public final BleDevice s(@k BluetoothDevice device, @l String str, int i10, @l byte[] bArr, long j10) {
        f0.p(device, "device");
        return new BleDevice(device, str, i10, bArr, j10);
    }

    @k
    public String toString() {
        return "BleDevice(device=" + this.f16266a + ", deviceName=" + this.f16267b + ", rssi=" + this.f16268c + ", bytes=" + Arrays.toString(this.f16269d) + ", timestampNanos=" + this.f16270e + ee.a.f26979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeParcelable(this.f16266a, i10);
        out.writeString(this.f16267b);
        out.writeInt(this.f16268c);
        out.writeByteArray(this.f16269d);
        out.writeLong(this.f16270e);
    }

    public /* synthetic */ BleDevice(BluetoothDevice bluetoothDevice, String str, int i10, byte[] bArr, long j10, int i11, u uVar) {
        this(bluetoothDevice, (i11 & 2) != 0 ? null : str, i10, (i11 & 8) != 0 ? null : bArr, j10);
    }
}
