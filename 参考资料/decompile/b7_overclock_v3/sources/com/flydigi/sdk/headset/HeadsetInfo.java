package com.flydigi.sdk.headset;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import cl.d;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import q9.g;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
@Keep
public final class HeadsetInfo implements Parcelable {

    @k
    private String address;
    private int batteryBox;
    private int batteryLeft;
    private int batteryRight;
    private boolean connected;

    @k
    private String deviceCode;

    @l
    private String deviceName;
    private int eqMode;

    @l
    private String firmwareBox;

    @l
    private String firmwareLeft;

    @l
    private String firmwareRight;
    private int latency;

    @k
    public static final a Companion = new a(null);

    @k
    public static final Parcelable.Creator<HeadsetInfo> CREATOR = new b();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final HeadsetInfo a(@k BluetoothDevice bluetoothDevice) {
            f0.p(bluetoothDevice, "bluetoothDevice");
            String address = bluetoothDevice.getAddress();
            f0.o(address, "bluetoothDevice.address");
            String name = bluetoothDevice.getName();
            g gVar = g.f47181a;
            String name2 = bluetoothDevice.getName();
            f0.o(name2, "bluetoothDevice.name");
            return new HeadsetInfo(address, name, true, gVar.a(name2), null, null, null, 0, 0, 0, 0, 0, 4080, null);
        }
    }

    public static final class b implements Parcelable.Creator<HeadsetInfo> {
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HeadsetInfo createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new HeadsetInfo(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HeadsetInfo[] newArray(int i10) {
            return new HeadsetInfo[i10];
        }
    }

    public HeadsetInfo(@k String address, @l String str, boolean z10, @k String deviceCode, @l String str2, @l String str3, @l String str4, int i10, int i11, int i12, int i13, int i14) {
        f0.p(address, "address");
        f0.p(deviceCode, "deviceCode");
        this.address = address;
        this.deviceName = str;
        this.connected = z10;
        this.deviceCode = deviceCode;
        this.firmwareLeft = str2;
        this.firmwareRight = str3;
        this.firmwareBox = str4;
        this.batteryLeft = i10;
        this.batteryRight = i11;
        this.batteryBox = i12;
        this.latency = i13;
        this.eqMode = i14;
    }

    @m
    @k
    public static final HeadsetInfo convertFromDevice(@k BluetoothDevice bluetoothDevice) {
        return Companion.a(bluetoothDevice);
    }

    @k
    public final String component1() {
        return this.address;
    }

    public final int component10() {
        return this.batteryBox;
    }

    public final int component11() {
        return this.latency;
    }

    public final int component12() {
        return this.eqMode;
    }

    @l
    public final String component2() {
        return this.deviceName;
    }

    public final boolean component3() {
        return this.connected;
    }

    @k
    public final String component4() {
        return this.deviceCode;
    }

    @l
    public final String component5() {
        return this.firmwareLeft;
    }

    @l
    public final String component6() {
        return this.firmwareRight;
    }

    @l
    public final String component7() {
        return this.firmwareBox;
    }

    public final int component8() {
        return this.batteryLeft;
    }

    public final int component9() {
        return this.batteryRight;
    }

    @k
    public final HeadsetInfo copy(@k String address, @l String str, boolean z10, @k String deviceCode, @l String str2, @l String str3, @l String str4, int i10, int i11, int i12, int i13, int i14) {
        f0.p(address, "address");
        f0.p(deviceCode, "deviceCode");
        return new HeadsetInfo(address, str, z10, deviceCode, str2, str3, str4, i10, i11, i12, i13, i14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeadsetInfo)) {
            return false;
        }
        HeadsetInfo headsetInfo = (HeadsetInfo) obj;
        return f0.g(this.address, headsetInfo.address) && f0.g(this.deviceName, headsetInfo.deviceName) && this.connected == headsetInfo.connected && f0.g(this.deviceCode, headsetInfo.deviceCode) && f0.g(this.firmwareLeft, headsetInfo.firmwareLeft) && f0.g(this.firmwareRight, headsetInfo.firmwareRight) && f0.g(this.firmwareBox, headsetInfo.firmwareBox) && this.batteryLeft == headsetInfo.batteryLeft && this.batteryRight == headsetInfo.batteryRight && this.batteryBox == headsetInfo.batteryBox && this.latency == headsetInfo.latency && this.eqMode == headsetInfo.eqMode;
    }

    @k
    public final String getAddress() {
        return this.address;
    }

    public final int getBatteryBox() {
        return this.batteryBox;
    }

    public final int getBatteryLeft() {
        return this.batteryLeft;
    }

    public final int getBatteryRight() {
        return this.batteryRight;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    @k
    public final String getDeviceCode() {
        return this.deviceCode;
    }

    @l
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getEqMode() {
        return this.eqMode;
    }

    @l
    public final String getFirmwareBox() {
        return this.firmwareBox;
    }

    @l
    public final String getFirmwareLeft() {
        return this.firmwareLeft;
    }

    @l
    public final String getFirmwareRight() {
        return this.firmwareRight;
    }

    public final int getLatency() {
        return this.latency;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = this.address.hashCode() * 31;
        String str = this.deviceName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.connected;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r12) * 31) + this.deviceCode.hashCode()) * 31;
        String str2 = this.firmwareLeft;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.firmwareRight;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.firmwareBox;
        return ((((((((((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.batteryLeft) * 31) + this.batteryRight) * 31) + this.batteryBox) * 31) + this.latency) * 31) + this.eqMode;
    }

    public final void setAddress(@k String str) {
        f0.p(str, "<set-?>");
        this.address = str;
    }

    public final void setBatteryBox(int i10) {
        this.batteryBox = i10;
    }

    public final void setBatteryLeft(int i10) {
        this.batteryLeft = i10;
    }

    public final void setBatteryRight(int i10) {
        this.batteryRight = i10;
    }

    public final void setConnected(boolean z10) {
        this.connected = z10;
    }

    public final void setDeviceCode(@k String str) {
        f0.p(str, "<set-?>");
        this.deviceCode = str;
    }

    public final void setDeviceName(@l String str) {
        this.deviceName = str;
    }

    public final void setEqMode(int i10) {
        this.eqMode = i10;
    }

    public final void setFirmwareBox(@l String str) {
        this.firmwareBox = str;
    }

    public final void setFirmwareLeft(@l String str) {
        this.firmwareLeft = str;
    }

    public final void setFirmwareRight(@l String str) {
        this.firmwareRight = str;
    }

    public final void setLatency(int i10) {
        this.latency = i10;
    }

    @k
    public String toString() {
        return "HeadsetInfo(address=" + this.address + ", deviceName=" + this.deviceName + ", connected=" + this.connected + ", deviceCode=" + this.deviceCode + ", firmwareLeft=" + this.firmwareLeft + ", firmwareRight=" + this.firmwareRight + ", firmwareBox=" + this.firmwareBox + ", batteryLeft=" + this.batteryLeft + ", batteryRight=" + this.batteryRight + ", batteryBox=" + this.batteryBox + ", latency=" + this.latency + ", eqMode=" + this.eqMode + ee.a.f26979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(this.address);
        out.writeString(this.deviceName);
        out.writeInt(this.connected ? 1 : 0);
        out.writeString(this.deviceCode);
        out.writeString(this.firmwareLeft);
        out.writeString(this.firmwareRight);
        out.writeString(this.firmwareBox);
        out.writeInt(this.batteryLeft);
        out.writeInt(this.batteryRight);
        out.writeInt(this.batteryBox);
        out.writeInt(this.latency);
        out.writeInt(this.eqMode);
    }

    public /* synthetic */ HeadsetInfo(String str, String str2, boolean z10, String str3, String str4, String str5, String str6, int i10, int i11, int i12, int i13, int i14, int i15, u uVar) {
        this(str, str2, (i15 & 4) != 0 ? false : z10, (i15 & 8) != 0 ? "all" : str3, (i15 & 16) != 0 ? null : str4, (i15 & 32) != 0 ? null : str5, (i15 & 64) != 0 ? null : str6, (i15 & 128) != 0 ? -1 : i10, (i15 & 256) != 0 ? -1 : i11, (i15 & 512) != 0 ? -1 : i12, (i15 & 1024) != 0 ? -1 : i13, (i15 & 2048) != 0 ? -1 : i14);
    }
}
