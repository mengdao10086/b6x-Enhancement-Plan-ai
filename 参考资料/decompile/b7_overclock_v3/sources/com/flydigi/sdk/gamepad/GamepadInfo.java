package com.flydigi.sdk.gamepad;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.core.util.j;
import cl.d;
import com.flydigi.sdk.bluetooth.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m9.h;
import m9.q;
import m9.t;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
@Keep
public final class GamepadInfo implements Parcelable {

    @k
    public static final Parcelable.Creator<GamepadInfo> CREATOR = new a();

    @k
    private String _deviceName;

    @l
    private String address;
    private int battery;

    @k
    private List<Integer> batteryLevelGap;
    private int chipType;
    private int connectMode;
    private int connectState;

    @k
    private String deviceCode;
    private int deviceMode;

    @l
    private String deviceName;
    private int deviceType;

    @l
    private String driverVersion;

    @l
    private String firmwareVersion;
    private boolean ipType;
    private boolean isDriverConnected;
    private boolean isSupportFlashplay;
    private boolean isSupportLed;
    private boolean isSupportLinearButton;
    private boolean isSupportLunpan;
    private boolean isSupportMotion;
    private boolean isSupportMotor;
    private boolean isSupportSwitch;
    private boolean isSupportTrigger;
    private int mappingMode;
    private int motionChipType;

    @k
    private List<Integer> supportKeys;

    @l
    private String switchChipVersion;
    private int usb0Device;
    private int usb1Device;

    @l
    private String uuid;

    public static final class a implements Parcelable.Creator<GamepadInfo> {
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GamepadInfo createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            int i15 = parcel.readInt();
            int i16 = parcel.readInt();
            int i17 = parcel.readInt();
            int i18 = parcel.readInt();
            String string4 = parcel.readString();
            boolean z10 = parcel.readInt() != 0;
            boolean z11 = parcel.readInt() != 0;
            String string5 = parcel.readString();
            int i19 = parcel.readInt();
            boolean z12 = parcel.readInt() != 0;
            boolean z13 = parcel.readInt() != 0;
            boolean z14 = parcel.readInt() != 0;
            boolean z15 = parcel.readInt() != 0;
            boolean z16 = parcel.readInt() != 0;
            int i20 = parcel.readInt();
            boolean z17 = z10;
            ArrayList arrayList = new ArrayList(i20);
            int i21 = 0;
            while (i21 != i20) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
                i21++;
                i20 = i20;
            }
            int i22 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i22);
            int i23 = 0;
            while (i23 != i22) {
                arrayList2.add(Integer.valueOf(parcel.readInt()));
                i23++;
                i22 = i22;
            }
            return new GamepadInfo(string, string2, string3, i10, i11, i12, i13, i14, i15, i16, i17, i18, string4, z17, z11, string5, i19, z12, z13, z14, z15, z16, arrayList, arrayList2, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GamepadInfo[] newArray(int i10) {
            return new GamepadInfo[i10];
        }
    }

    public GamepadInfo(@l String str, @l String str2, @k String deviceCode, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, @l String str3, boolean z10, boolean z11, @l String str4, int i19, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, @k List<Integer> supportKeys, @k List<Integer> batteryLevelGap, boolean z17, boolean z18, @l String str5, boolean z19, @l String str6) {
        f0.p(deviceCode, "deviceCode");
        f0.p(supportKeys, "supportKeys");
        f0.p(batteryLevelGap, "batteryLevelGap");
        this.address = str;
        this.deviceName = str2;
        this.deviceCode = deviceCode;
        this.chipType = i10;
        this.motionChipType = i11;
        this.deviceType = i12;
        this.deviceMode = i13;
        this.connectMode = i14;
        this.connectState = i15;
        this.mappingMode = i16;
        this.usb0Device = i17;
        this.usb1Device = i18;
        this.firmwareVersion = str3;
        this.isSupportFlashplay = z10;
        this.isDriverConnected = z11;
        this.driverVersion = str4;
        this.battery = i19;
        this.isSupportLinearButton = z12;
        this.isSupportMotion = z13;
        this.isSupportLunpan = z14;
        this.isSupportLed = z15;
        this.isSupportMotor = z16;
        this.supportKeys = supportKeys;
        this.batteryLevelGap = batteryLevelGap;
        this.ipType = z17;
        this.isSupportSwitch = z18;
        this.switchChipVersion = str5;
        this.isSupportTrigger = z19;
        this.uuid = str6;
        this._deviceName = "";
    }

    public static /* synthetic */ void get_deviceName$annotations() {
    }

    @l
    public final String component1() {
        return this.address;
    }

    public final int component10() {
        return this.mappingMode;
    }

    public final int component11() {
        return this.usb0Device;
    }

    public final int component12() {
        return this.usb1Device;
    }

    @l
    public final String component13() {
        return this.firmwareVersion;
    }

    public final boolean component14() {
        return this.isSupportFlashplay;
    }

    public final boolean component15() {
        return this.isDriverConnected;
    }

    @l
    public final String component16() {
        return this.driverVersion;
    }

    public final int component17() {
        return this.battery;
    }

    public final boolean component18() {
        return this.isSupportLinearButton;
    }

    public final boolean component19() {
        return this.isSupportMotion;
    }

    @l
    public final String component2() {
        return this.deviceName;
    }

    public final boolean component20() {
        return this.isSupportLunpan;
    }

    public final boolean component21() {
        return this.isSupportLed;
    }

    public final boolean component22() {
        return this.isSupportMotor;
    }

    @k
    public final List<Integer> component23() {
        return this.supportKeys;
    }

    @k
    public final List<Integer> component24() {
        return this.batteryLevelGap;
    }

    public final boolean component25() {
        return this.ipType;
    }

    public final boolean component26() {
        return this.isSupportSwitch;
    }

    @l
    public final String component27() {
        return this.switchChipVersion;
    }

    public final boolean component28() {
        return this.isSupportTrigger;
    }

    @l
    public final String component29() {
        return this.uuid;
    }

    @k
    public final String component3() {
        return this.deviceCode;
    }

    public final int component4() {
        return this.chipType;
    }

    public final int component5() {
        return this.motionChipType;
    }

    public final int component6() {
        return this.deviceType;
    }

    public final int component7() {
        return this.deviceMode;
    }

    public final int component8() {
        return this.connectMode;
    }

    public final int component9() {
        return this.connectState;
    }

    public final boolean containKey(int i10) {
        return isGamepadKeyboard() || this.supportKeys.contains(Integer.valueOf(i10));
    }

    @k
    public final GamepadInfo copy(@l String str, @l String str2, @k String deviceCode, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, @l String str3, boolean z10, boolean z11, @l String str4, int i19, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, @k List<Integer> supportKeys, @k List<Integer> batteryLevelGap, boolean z17, boolean z18, @l String str5, boolean z19, @l String str6) {
        f0.p(deviceCode, "deviceCode");
        f0.p(supportKeys, "supportKeys");
        f0.p(batteryLevelGap, "batteryLevelGap");
        return new GamepadInfo(str, str2, deviceCode, i10, i11, i12, i13, i14, i15, i16, i17, i18, str3, z10, z11, str4, i19, z12, z13, z14, z15, z16, supportKeys, batteryLevelGap, z17, z18, str5, z19, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GamepadInfo)) {
            return false;
        }
        GamepadInfo gamepadInfo = (GamepadInfo) obj;
        return f0.g(this.address, gamepadInfo.address) && f0.g(this.deviceName, gamepadInfo.deviceName) && f0.g(this.deviceCode, gamepadInfo.deviceCode) && this.chipType == gamepadInfo.chipType && this.motionChipType == gamepadInfo.motionChipType && this.deviceType == gamepadInfo.deviceType && this.deviceMode == gamepadInfo.deviceMode && this.connectMode == gamepadInfo.connectMode && this.connectState == gamepadInfo.connectState && this.mappingMode == gamepadInfo.mappingMode && this.usb0Device == gamepadInfo.usb0Device && this.usb1Device == gamepadInfo.usb1Device && f0.g(this.firmwareVersion, gamepadInfo.firmwareVersion) && this.isSupportFlashplay == gamepadInfo.isSupportFlashplay && this.isDriverConnected == gamepadInfo.isDriverConnected && f0.g(this.driverVersion, gamepadInfo.driverVersion) && this.battery == gamepadInfo.battery && this.isSupportLinearButton == gamepadInfo.isSupportLinearButton && this.isSupportMotion == gamepadInfo.isSupportMotion && this.isSupportLunpan == gamepadInfo.isSupportLunpan && this.isSupportLed == gamepadInfo.isSupportLed && this.isSupportMotor == gamepadInfo.isSupportMotor && f0.g(this.supportKeys, gamepadInfo.supportKeys) && f0.g(this.batteryLevelGap, gamepadInfo.batteryLevelGap) && this.ipType == gamepadInfo.ipType && this.isSupportSwitch == gamepadInfo.isSupportSwitch && f0.g(this.switchChipVersion, gamepadInfo.switchChipVersion) && this.isSupportTrigger == gamepadInfo.isSupportTrigger && f0.g(this.uuid, gamepadInfo.uuid);
    }

    @l
    public final String getAddress() {
        return this.address;
    }

    public final int getBattery() {
        return this.battery;
    }

    public final int getBatteryLevel() {
        int i10 = this.deviceType;
        if (i10 == 48 || i10 == 50) {
            return 5;
        }
        int i11 = this.battery;
        if (i11 == 0 || i11 == 255 || this.batteryLevelGap.isEmpty()) {
            return 0;
        }
        if ((this.battery & 255) <= this.batteryLevelGap.get(0).intValue()) {
            return 1;
        }
        if ((this.battery & 255) <= this.batteryLevelGap.get(1).intValue()) {
            return 2;
        }
        if ((this.battery & 255) <= this.batteryLevelGap.get(2).intValue()) {
            return 3;
        }
        return (this.battery & 255) <= this.batteryLevelGap.get(3).intValue() ? 4 : 5;
    }

    @k
    public final List<Integer> getBatteryLevelGap() {
        return this.batteryLevelGap;
    }

    public final int getChipType() {
        return this.chipType;
    }

    public final int getConnectMode() {
        return this.connectMode;
    }

    public final int getConnectState() {
        return this.connectState;
    }

    @k
    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final int getDeviceMode() {
        return this.deviceMode;
    }

    @l
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    @l
    public final String getDriverVersion() {
        return this.driverVersion;
    }

    @l
    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final boolean getIpType() {
        return this.ipType;
    }

    @k
    public final String getKrlyDeviceCode() {
        if (j.a(this.deviceCode, h.B)) {
            return "chdfuf1p";
        }
        if (j.a(this.deviceCode, h.f40780w)) {
            return "chdfuf3";
        }
        return v.f16329e + this.deviceCode;
    }

    public final int getMappingMode() {
        return this.mappingMode;
    }

    public final int getMotionChipType() {
        return this.motionChipType;
    }

    @k
    public final String getReadableConnectMode() {
        int i10 = this.connectMode;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "未知连接方式" : "dfu" : "系统连接" : "大厅连接";
    }

    @k
    public final String getReadableDeviceMode() {
        int i10 = this.deviceMode;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "未知类型" : "单手手柄" : "键鼠" : "双手手柄";
    }

    @k
    public final String getReadableMappingMode() {
        int i10 = this.mappingMode;
        return i10 != 0 ? i10 != 1 ? i10 != 3 ? i10 != 4 ? "未知" : "iOS智连模式" : "Android智连模式Q" : "Android智连模式" : "传统模式";
    }

    @k
    public final List<Integer> getSupportKeys() {
        return this.supportKeys;
    }

    @l
    public final String getSwitchChipVersion() {
        return this.switchChipVersion;
    }

    public final int getUsb0Device() {
        return this.usb0Device;
    }

    public final int getUsb1Device() {
        return this.usb1Device;
    }

    @l
    public final String getUuid() {
        return this.uuid;
    }

    @k
    public final String get_deviceName() {
        return this._deviceName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.address;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceName;
        int iHashCode2 = (((((((((((((((((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.deviceCode.hashCode()) * 31) + this.chipType) * 31) + this.motionChipType) * 31) + this.deviceType) * 31) + this.deviceMode) * 31) + this.connectMode) * 31) + this.connectState) * 31) + this.mappingMode) * 31) + this.usb0Device) * 31) + this.usb1Device) * 31;
        String str3 = this.firmwareVersion;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z10 = this.isSupportFlashplay;
        ?? r22 = z10;
        if (z10) {
            r22 = 1;
        }
        int i10 = (iHashCode3 + r22) * 31;
        boolean z11 = this.isDriverConnected;
        ?? r23 = z11;
        if (z11) {
            r23 = 1;
        }
        int i11 = (i10 + r23) * 31;
        String str4 = this.driverVersion;
        int iHashCode4 = (((i11 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.battery) * 31;
        boolean z12 = this.isSupportLinearButton;
        ?? r24 = z12;
        if (z12) {
            r24 = 1;
        }
        int i12 = (iHashCode4 + r24) * 31;
        boolean z13 = this.isSupportMotion;
        ?? r25 = z13;
        if (z13) {
            r25 = 1;
        }
        int i13 = (i12 + r25) * 31;
        boolean z14 = this.isSupportLunpan;
        ?? r26 = z14;
        if (z14) {
            r26 = 1;
        }
        int i14 = (i13 + r26) * 31;
        boolean z15 = this.isSupportLed;
        ?? r27 = z15;
        if (z15) {
            r27 = 1;
        }
        int i15 = (i14 + r27) * 31;
        boolean z16 = this.isSupportMotor;
        ?? r28 = z16;
        if (z16) {
            r28 = 1;
        }
        int iHashCode5 = (((((i15 + r28) * 31) + this.supportKeys.hashCode()) * 31) + this.batteryLevelGap.hashCode()) * 31;
        boolean z17 = this.ipType;
        ?? r29 = z17;
        if (z17) {
            r29 = 1;
        }
        int i16 = (iHashCode5 + r29) * 31;
        boolean z18 = this.isSupportSwitch;
        ?? r210 = z18;
        if (z18) {
            r210 = 1;
        }
        int i17 = (i16 + r210) * 31;
        String str5 = this.switchChipVersion;
        int iHashCode6 = (i17 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z19 = this.isSupportTrigger;
        int i18 = (iHashCode6 + (z19 ? 1 : z19)) * 31;
        String str6 = this.uuid;
        return i18 + (str6 != null ? str6.hashCode() : 0);
    }

    public final boolean isConnected() {
        return this.connectState == 2;
    }

    public final boolean isConnecting() {
        return this.connectState == 1;
    }

    public final boolean isDisconnected() {
        return this.connectState == 0;
    }

    public final boolean isDriverConnected() {
        return this.isDriverConnected;
    }

    public final boolean isDriverMode() {
        return this.mappingMode == 0;
    }

    public final boolean isFlashplayMode() {
        int i10 = this.mappingMode;
        return i10 == 1 || i10 == 3 || i10 == 4;
    }

    public final boolean isGamepadHalf() {
        return this.deviceMode == 2;
    }

    public final boolean isGamepadKeyboard() {
        return this.deviceMode == 1;
    }

    public final boolean isGamepadWhole() {
        return this.deviceMode == 0;
    }

    public final boolean isIosFlashplayMode() {
        return this.mappingMode == 4;
    }

    public final boolean isQFlashplayMode() {
        return this.mappingMode == 3;
    }

    public final boolean isSupportFlashplay() {
        return this.isSupportFlashplay;
    }

    public final boolean isSupportLed() {
        return this.isSupportLed;
    }

    public final boolean isSupportLinearButton() {
        return this.isSupportLinearButton;
    }

    public final boolean isSupportLunpan() {
        return this.isSupportLunpan;
    }

    public final boolean isSupportMotion() {
        return this.isSupportMotion;
    }

    public final boolean isSupportMotor() {
        return this.isSupportMotor;
    }

    public final boolean isSupportSwitch() {
        return this.isSupportSwitch;
    }

    public final boolean isSupportTrigger() {
        return this.isSupportTrigger;
    }

    public final boolean isSystemConnect() {
        return this.connectMode == 1;
    }

    public final void reset() {
        this.connectState = 0;
        this.deviceType = 0;
        this.deviceMode = -1;
        this.connectMode = 1;
        this.mappingMode = -1;
        this.firmwareVersion = null;
        this.chipType = -1;
        this.motionChipType = 0;
        this.isSupportFlashplay = false;
        this.usb0Device = 0;
        this.usb1Device = 0;
        this.battery = -1;
        this.isSupportLinearButton = false;
        this.isSupportMotion = false;
        this.isSupportLunpan = false;
        this.isSupportMotor = false;
        this.isSupportLed = false;
        this.switchChipVersion = null;
        this.uuid = null;
    }

    public final void setAddress(@l String str) {
        this.address = str;
    }

    public final void setBattery(int i10) {
        this.battery = i10;
    }

    public final void setBatteryLevelGap(@k List<Integer> list) {
        f0.p(list, "<set-?>");
        this.batteryLevelGap = list;
    }

    public final void setChipType(int i10) {
        this.chipType = i10;
    }

    public final void setConnectMode(int i10) {
        this.connectMode = i10;
    }

    public final void setConnectState(int i10) {
        this.connectState = i10;
    }

    public final void setDeviceCode(@k String str) {
        f0.p(str, "<set-?>");
        this.deviceCode = str;
    }

    public final void setDeviceMode(int i10) {
        this.deviceMode = i10;
    }

    public final void setDeviceName(@l String str) {
        this.deviceName = str;
    }

    public final void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public final void setDriverConnected(boolean z10) {
        this.isDriverConnected = z10;
    }

    public final void setDriverVersion(@l String str) {
        this.driverVersion = str;
    }

    public final void setFirmwareVersion(@l String str) {
        this.firmwareVersion = str;
    }

    public final void setIpType(boolean z10) {
        this.ipType = z10;
    }

    public final void setMappingMode(int i10) {
        this.mappingMode = i10;
    }

    public final void setMotionChipType(int i10) {
        this.motionChipType = i10;
    }

    public final void setSupportFlashplay(boolean z10) {
        this.isSupportFlashplay = z10;
    }

    public final void setSupportKeys(@k List<Integer> list) {
        f0.p(list, "<set-?>");
        this.supportKeys = list;
    }

    public final void setSupportLed(boolean z10) {
        this.isSupportLed = z10;
    }

    public final void setSupportLinearButton(boolean z10) {
        this.isSupportLinearButton = z10;
    }

    public final void setSupportLunpan(boolean z10) {
        this.isSupportLunpan = z10;
    }

    public final void setSupportMotion(boolean z10) {
        this.isSupportMotion = z10;
    }

    public final void setSupportMotor(boolean z10) {
        this.isSupportMotor = z10;
    }

    public final void setSupportSwitch(boolean z10) {
        this.isSupportSwitch = z10;
    }

    public final void setSupportTrigger(boolean z10) {
        this.isSupportTrigger = z10;
    }

    public final void setSwitchChipVersion(@l String str) {
        this.switchChipVersion = str;
    }

    public final void setUsb0Device(int i10) {
        this.usb0Device = i10;
    }

    public final void setUsb1Device(int i10) {
        this.usb1Device = i10;
    }

    public final void setUuid(@l String str) {
        this.uuid = str;
    }

    public final void set_deviceName(@k String value) {
        f0.p(value, "value");
        this._deviceName = value;
        this.deviceName = value;
        q.z(this, t.k(value), -1, 0, 8, null);
    }

    @k
    public String toString() {
        return "GamepadInfo(address=" + this.address + ", deviceName=" + this.deviceName + ", deviceCode=" + this.deviceCode + ", chipType=" + this.chipType + ", motionChipType=" + this.motionChipType + ", deviceType=" + this.deviceType + ", deviceMode=" + this.deviceMode + ", connectMode=" + this.connectMode + ", connectState=" + this.connectState + ", mappingMode=" + this.mappingMode + ", usb0Device=" + this.usb0Device + ", usb1Device=" + this.usb1Device + ", firmwareVersion=" + this.firmwareVersion + ", isSupportFlashplay=" + this.isSupportFlashplay + ", isDriverConnected=" + this.isDriverConnected + ", driverVersion=" + this.driverVersion + ", battery=" + this.battery + ", isSupportLinearButton=" + this.isSupportLinearButton + ", isSupportMotion=" + this.isSupportMotion + ", isSupportLunpan=" + this.isSupportLunpan + ", isSupportLed=" + this.isSupportLed + ", isSupportMotor=" + this.isSupportMotor + ", supportKeys=" + this.supportKeys + ", batteryLevelGap=" + this.batteryLevelGap + ", ipType=" + this.ipType + ", isSupportSwitch=" + this.isSupportSwitch + ", switchChipVersion=" + this.switchChipVersion + ", isSupportTrigger=" + this.isSupportTrigger + ", uuid=" + this.uuid + ee.a.f26979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(this.address);
        out.writeString(this.deviceName);
        out.writeString(this.deviceCode);
        out.writeInt(this.chipType);
        out.writeInt(this.motionChipType);
        out.writeInt(this.deviceType);
        out.writeInt(this.deviceMode);
        out.writeInt(this.connectMode);
        out.writeInt(this.connectState);
        out.writeInt(this.mappingMode);
        out.writeInt(this.usb0Device);
        out.writeInt(this.usb1Device);
        out.writeString(this.firmwareVersion);
        out.writeInt(this.isSupportFlashplay ? 1 : 0);
        out.writeInt(this.isDriverConnected ? 1 : 0);
        out.writeString(this.driverVersion);
        out.writeInt(this.battery);
        out.writeInt(this.isSupportLinearButton ? 1 : 0);
        out.writeInt(this.isSupportMotion ? 1 : 0);
        out.writeInt(this.isSupportLunpan ? 1 : 0);
        out.writeInt(this.isSupportLed ? 1 : 0);
        out.writeInt(this.isSupportMotor ? 1 : 0);
        List<Integer> list = this.supportKeys;
        out.writeInt(list.size());
        Iterator<Integer> it2 = list.iterator();
        while (it2.hasNext()) {
            out.writeInt(it2.next().intValue());
        }
        List<Integer> list2 = this.batteryLevelGap;
        out.writeInt(list2.size());
        Iterator<Integer> it3 = list2.iterator();
        while (it3.hasNext()) {
            out.writeInt(it3.next().intValue());
        }
        out.writeInt(this.ipType ? 1 : 0);
        out.writeInt(this.isSupportSwitch ? 1 : 0);
        out.writeString(this.switchChipVersion);
        out.writeInt(this.isSupportTrigger ? 1 : 0);
        out.writeString(this.uuid);
    }

    public /* synthetic */ GamepadInfo(String str, String str2, String str3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str4, boolean z10, boolean z11, String str5, int i19, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, List list, List list2, boolean z17, boolean z18, String str6, boolean z19, String str7, int i20, u uVar) {
        this((i20 & 1) != 0 ? null : str, (i20 & 2) != 0 ? null : str2, (i20 & 4) != 0 ? "all" : str3, (i20 & 8) != 0 ? -1 : i10, (i20 & 16) != 0 ? 0 : i11, (i20 & 32) != 0 ? 0 : i12, (i20 & 64) != 0 ? -1 : i13, (i20 & 128) != 0 ? 1 : i14, (i20 & 256) != 0 ? 0 : i15, (i20 & 512) != 0 ? -1 : i16, (i20 & 1024) != 0 ? 0 : i17, (i20 & 2048) != 0 ? 0 : i18, (i20 & 4096) != 0 ? null : str4, (i20 & 8192) != 0 ? false : z10, (i20 & 16384) != 0 ? false : z11, (32768 & i20) != 0 ? null : str5, (65536 & i20) != 0 ? 0 : i19, (131072 & i20) != 0 ? false : z12, (262144 & i20) != 0 ? false : z13, (524288 & i20) != 0 ? false : z14, (1048576 & i20) != 0 ? false : z15, (2097152 & i20) != 0 ? false : z16, (4194304 & i20) != 0 ? CollectionsKt__CollectionsKt.E() : list, (8388608 & i20) != 0 ? CollectionsKt__CollectionsKt.E() : list2, (16777216 & i20) != 0 ? false : z17, (33554432 & i20) != 0 ? false : z18, (67108864 & i20) != 0 ? null : str6, (i20 & 134217728) != 0 ? false : z19, str7);
    }

    public GamepadInfo() {
        this(null, null, "all", 0, 0, 0, -1, 1, 0, -1, 0, 0, null, false, false, null, -1, false, false, false, false, false, CollectionsKt__CollectionsKt.E(), CollectionsKt__CollectionsKt.E(), false, false, null, false, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GamepadInfo(@k String deviceCode) {
        this(null, null, deviceCode, -1, 0, 0, -1, 1, 0, -1, 0, 0, null, false, false, null, -1, false, false, false, false, false, CollectionsKt__CollectionsKt.E(), CollectionsKt__CollectionsKt.E(), false, false, null, false, null);
        f0.p(deviceCode, "deviceCode");
    }
}
