package com.flydigi.sdk.waspwing;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import cl.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import hk.m;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v0;
import t9.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
@Keep
public final class WaspWingInfo implements Parcelable {
    public static final int COLD_LEVEL_POWER_SAVING_B7 = 104;
    public static final int COLD_LEVEL_STANDARD_B7 = 149;
    public static final int COLD_LEVEL_STRONGEST_B7 = 250;
    public static final int COLD_LEVEL_STRONG_B7 = 155;
    public static final int DEFAULT_COLD_LEVEL = 115;
    public static final int DEFAULT_COLD_LEVEL_OVERCLOCK_MAX = 134;
    public static final int DEFAULT_COLD_LEVEL_OVERCLOCK_MIDDLE = 153;
    public static final int DEFAULT_COLD_LEVEL_OVERCLOCK_MIN = 173;
    public static final int DEFAULT_WIND_LEVEL_MAX = 77;
    public static final int DEFAULT_WIND_LEVEL_MIDDLE = 95;
    public static final int DEFAULT_WIND_LEVEL_MIN = 115;
    public static final int DEFAULT_WIND_LEVEL_OVERCLOCK_MAX = 77;
    public static final int DEFAULT_WIND_LEVEL_OVERCLOCK_MIDDLE = 95;
    public static final int DEFAULT_WIND_LEVEL_OVERCLOCK_MIN = 134;
    public static final int EXPERIMENTAL_RUN_MODE_COLD_LEVEL = 230;
    public static final int EXPERIMENTAL_RUN_MODE_WIND_LEVEL = 5700;
    public static final int LED_OFF = 0;
    public static final int LED_ON = 1;
    public static final int SPEED_MAX = 255;
    public static final int SPEED_MAX_B5 = 115;
    public static final int SPEED_MIN_B3 = 120;
    public static final int SPEED_MIN_B5 = 57;
    public static final int TEMPERATURE_MIDDLE = 18;
    public static final int TEMPERATURE_MIN = 16;
    public static final int WIND_LEVEL_MAX = 5500;
    public static final int WIND_LEVEL_MIN = 4500;

    @l
    private String address;
    private int coldLevel;
    private int coldLevelOverclock;
    private boolean coldProtection;
    private boolean coldProtectionEnabled;
    private int coldRunLevel;

    @k
    private String deviceCode;

    @l
    private String deviceName;

    @l
    private Integer experimentalRunModeValue;

    @l
    private String firmwareVersion;
    private boolean hotProtection;
    private boolean hotProtectionEnabled;
    private byte hotSurfaceTemperature;
    private int ipType;
    private boolean isConnected;
    private boolean isExperimentalRunModeOn;

    @l
    private LedData ledData;
    private int ledType;
    private boolean lightState;
    private int modeCustom;
    private boolean overClockUsable;
    private int overClockUsableLevel;
    private int quickSwitchRunMode;
    private int runMode;
    private int speed;
    private int targetTemperature;

    @k
    private byte[] tempHistories;
    private int temperature;
    private int temperatureDecimal;

    @l
    private String uuid;
    private int windLevel;
    private int windLevelOverclock;
    private int windRunLevel;

    @k
    public static final a Companion = new a(null);

    @k
    public static final Parcelable.Creator<WaspWingInfo> CREATOR = new b();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final WaspWingInfo a(@k BluetoothDevice bluetoothDevice) {
            f0.p(bluetoothDevice, "bluetoothDevice");
            WaspWingInfo waspWingInfo = new WaspWingInfo(null, null, false, null, null, false, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, (byte) 0, null, false, false, false, false, null, 0, 0, false, null, null, 0, -1, 1, null);
            waspWingInfo.setConnected(true);
            waspWingInfo.setDeviceName(bluetoothDevice.getName());
            waspWingInfo.setAddress(bluetoothDevice.getAddress());
            waspWingInfo.setDeviceCode(c.f50952a.a(bluetoothDevice.getName()));
            return waspWingInfo;
        }
    }

    public static final class b implements Parcelable.Creator<WaspWingInfo> {
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WaspWingInfo createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new WaspWingInfo(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte(), parcel.readInt() == 0 ? null : LedData.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.createByteArray(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WaspWingInfo[] newArray(int i10) {
            return new WaspWingInfo[i10];
        }
    }

    public WaspWingInfo() {
        this(null, null, false, null, null, false, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, (byte) 0, null, false, false, false, false, null, 0, 0, false, null, null, 0, -1, 1, null);
    }

    public WaspWingInfo(@l String str, @l String str2, boolean z10, @k String deviceCode, @l String str3, boolean z11, int i10, int i11, int i12, int i13, int i14, int i15, boolean z12, int i16, int i17, int i18, int i19, int i20, int i21, int i22, byte b10, @l LedData ledData, boolean z13, boolean z14, boolean z15, boolean z16, @k byte[] tempHistories, int i23, int i24, boolean z17, @l Integer num, @l String str4, int i25) {
        f0.p(deviceCode, "deviceCode");
        f0.p(tempHistories, "tempHistories");
        this.deviceName = str;
        this.address = str2;
        this.isConnected = z10;
        this.deviceCode = deviceCode;
        this.firmwareVersion = str3;
        this.lightState = z11;
        this.windLevel = i10;
        this.coldLevel = i11;
        this.temperature = i12;
        this.temperatureDecimal = i13;
        this.runMode = i14;
        this.targetTemperature = i15;
        this.overClockUsable = z12;
        this.overClockUsableLevel = i16;
        this.windLevelOverclock = i17;
        this.coldLevelOverclock = i18;
        this.speed = i19;
        this.windRunLevel = i20;
        this.coldRunLevel = i21;
        this.ledType = i22;
        this.hotSurfaceTemperature = b10;
        this.ledData = ledData;
        this.coldProtection = z13;
        this.hotProtection = z14;
        this.hotProtectionEnabled = z15;
        this.coldProtectionEnabled = z16;
        this.tempHistories = tempHistories;
        this.ipType = i23;
        this.modeCustom = i24;
        this.isExperimentalRunModeOn = z17;
        this.experimentalRunModeValue = num;
        this.uuid = str4;
        this.quickSwitchRunMode = i25;
    }

    @m
    @k
    public static final WaspWingInfo convertFromDevice(@k BluetoothDevice bluetoothDevice) {
        return Companion.a(bluetoothDevice);
    }

    @l
    public final String component1() {
        return this.deviceName;
    }

    public final int component10() {
        return this.temperatureDecimal;
    }

    public final int component11() {
        return this.runMode;
    }

    public final int component12() {
        return this.targetTemperature;
    }

    public final boolean component13() {
        return this.overClockUsable;
    }

    public final int component14() {
        return this.overClockUsableLevel;
    }

    public final int component15() {
        return this.windLevelOverclock;
    }

    public final int component16() {
        return this.coldLevelOverclock;
    }

    public final int component17() {
        return this.speed;
    }

    public final int component18() {
        return this.windRunLevel;
    }

    public final int component19() {
        return this.coldRunLevel;
    }

    @l
    public final String component2() {
        return this.address;
    }

    public final int component20() {
        return this.ledType;
    }

    public final byte component21() {
        return this.hotSurfaceTemperature;
    }

    @l
    public final LedData component22() {
        return this.ledData;
    }

    public final boolean component23() {
        return this.coldProtection;
    }

    public final boolean component24() {
        return this.hotProtection;
    }

    public final boolean component25() {
        return this.hotProtectionEnabled;
    }

    public final boolean component26() {
        return this.coldProtectionEnabled;
    }

    @k
    public final byte[] component27() {
        return this.tempHistories;
    }

    public final int component28() {
        return this.ipType;
    }

    public final int component29() {
        return this.modeCustom;
    }

    public final boolean component3() {
        return this.isConnected;
    }

    public final boolean component30() {
        return this.isExperimentalRunModeOn;
    }

    @l
    public final Integer component31() {
        return this.experimentalRunModeValue;
    }

    @l
    public final String component32() {
        return this.uuid;
    }

    public final int component33() {
        return this.quickSwitchRunMode;
    }

    @k
    public final String component4() {
        return this.deviceCode;
    }

    @l
    public final String component5() {
        return this.firmwareVersion;
    }

    public final boolean component6() {
        return this.lightState;
    }

    public final int component7() {
        return this.windLevel;
    }

    public final int component8() {
        return this.coldLevel;
    }

    public final int component9() {
        return this.temperature;
    }

    @k
    public final WaspWingInfo copy(@l String str, @l String str2, boolean z10, @k String deviceCode, @l String str3, boolean z11, int i10, int i11, int i12, int i13, int i14, int i15, boolean z12, int i16, int i17, int i18, int i19, int i20, int i21, int i22, byte b10, @l LedData ledData, boolean z13, boolean z14, boolean z15, boolean z16, @k byte[] tempHistories, int i23, int i24, boolean z17, @l Integer num, @l String str4, int i25) {
        f0.p(deviceCode, "deviceCode");
        f0.p(tempHistories, "tempHistories");
        return new WaspWingInfo(str, str2, z10, deviceCode, str3, z11, i10, i11, i12, i13, i14, i15, z12, i16, i17, i18, i19, i20, i21, i22, b10, ledData, z13, z14, z15, z16, tempHistories, i23, i24, z17, num, str4, i25);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WaspWingInfo)) {
            return false;
        }
        WaspWingInfo waspWingInfo = (WaspWingInfo) obj;
        return f0.g(this.deviceName, waspWingInfo.deviceName) && f0.g(this.address, waspWingInfo.address) && this.isConnected == waspWingInfo.isConnected && f0.g(this.deviceCode, waspWingInfo.deviceCode) && f0.g(this.firmwareVersion, waspWingInfo.firmwareVersion) && this.lightState == waspWingInfo.lightState && this.windLevel == waspWingInfo.windLevel && this.coldLevel == waspWingInfo.coldLevel && this.temperature == waspWingInfo.temperature && this.temperatureDecimal == waspWingInfo.temperatureDecimal && this.runMode == waspWingInfo.runMode && this.targetTemperature == waspWingInfo.targetTemperature && this.overClockUsable == waspWingInfo.overClockUsable && this.overClockUsableLevel == waspWingInfo.overClockUsableLevel && this.windLevelOverclock == waspWingInfo.windLevelOverclock && this.coldLevelOverclock == waspWingInfo.coldLevelOverclock && this.speed == waspWingInfo.speed && this.windRunLevel == waspWingInfo.windRunLevel && this.coldRunLevel == waspWingInfo.coldRunLevel && this.ledType == waspWingInfo.ledType && this.hotSurfaceTemperature == waspWingInfo.hotSurfaceTemperature && f0.g(this.ledData, waspWingInfo.ledData) && this.coldProtection == waspWingInfo.coldProtection && this.hotProtection == waspWingInfo.hotProtection && this.hotProtectionEnabled == waspWingInfo.hotProtectionEnabled && this.coldProtectionEnabled == waspWingInfo.coldProtectionEnabled && f0.g(this.tempHistories, waspWingInfo.tempHistories) && this.ipType == waspWingInfo.ipType && this.modeCustom == waspWingInfo.modeCustom && this.isExperimentalRunModeOn == waspWingInfo.isExperimentalRunModeOn && f0.g(this.experimentalRunModeValue, waspWingInfo.experimentalRunModeValue) && f0.g(this.uuid, waspWingInfo.uuid) && this.quickSwitchRunMode == waspWingInfo.quickSwitchRunMode;
    }

    @l
    public final String getAddress() {
        return this.address;
    }

    public final int getColdLevel() {
        return this.coldLevel;
    }

    public final int getColdLevelOverclock() {
        return this.coldLevelOverclock;
    }

    public final boolean getColdProtection() {
        return this.coldProtection;
    }

    public final boolean getColdProtectionEnabled() {
        return this.coldProtectionEnabled;
    }

    public final int getColdRunLevel() {
        return this.coldRunLevel;
    }

    @k
    public final String getDeviceCode() {
        return this.deviceCode;
    }

    @l
    public final String getDeviceName() {
        return this.deviceName;
    }

    @l
    public final Integer getExperimentalRunModeValue() {
        return this.experimentalRunModeValue;
    }

    @l
    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final boolean getHotProtection() {
        return this.hotProtection;
    }

    public final boolean getHotProtectionEnabled() {
        return this.hotProtectionEnabled;
    }

    public final byte getHotSurfaceTemperature() {
        return this.hotSurfaceTemperature;
    }

    public final int getIpType() {
        return this.ipType;
    }

    @l
    public final LedData getLedData() {
        return this.ledData;
    }

    public final int getLedType() {
        return this.ledType;
    }

    public final boolean getLightState() {
        return this.lightState;
    }

    public final int getModeCustom() {
        return this.modeCustom;
    }

    public final boolean getOverClockUsable() {
        return this.overClockUsable;
    }

    public final int getOverClockUsableLevel() {
        return this.overClockUsableLevel;
    }

    public final int getQuickSwitchRunMode() {
        return this.quickSwitchRunMode;
    }

    @k
    public final String getReadableCold() {
        int i10 = this.coldLevel;
        return i10 != 0 ? i10 != 19 ? i10 != 38 ? i10 != 57 ? i10 != 77 ? i10 != 95 ? i10 != 115 ? i10 != 134 ? i10 != 153 ? i10 != 173 ? String.valueOf(i10) : "5.5V" : "5.0V" : "4.5V" : "4.0V" : "3.5V" : "3.0V" : "2.5V" : "2.0V" : "1.5V" : "--";
    }

    @k
    public final String getReadableLevel(int i10) {
        v0 v0Var = v0.f37964a;
        String str = String.format("%.2fV", Arrays.copyOf(new Object[]{Double.valueOf(((((double) (i10 - 19)) * 0.5d) / ((double) 19)) + 1.5d)}, 1));
        f0.o(str, "format(format, *args)");
        return str;
    }

    @k
    public final String getReadableWind() {
        int i10 = this.windLevel;
        return i10 != 0 ? i10 != 57 ? i10 != 77 ? i10 != 95 ? i10 != 115 ? i10 != 134 ? String.valueOf(i10) : "4.5V" : "4.0V" : "3.5V" : "3.0V" : "2.5V" : "--";
    }

    public final int getRealColdLevel() {
        return (this.runMode == 0 && this.overClockUsable) ? this.coldLevelOverclock : this.coldLevel;
    }

    public final int getRealWindLevel() {
        return (this.runMode == 0 && this.overClockUsable) ? this.windLevelOverclock : this.windLevel;
    }

    public final int getRunMode() {
        return this.runMode;
    }

    public final float getRunModeSmartLevel() {
        int i10 = this.targetTemperature;
        if (i10 == 18 && this.windLevel == 77 && this.coldLevel == 115 && this.windLevelOverclock == 77 && this.coldLevelOverclock == 134) {
            return 0.0f;
        }
        if (i10 == 16 && this.windLevel == 95 && this.coldLevel == 115 && this.windLevelOverclock == 95 && this.coldLevelOverclock == 153) {
            return 1.0f;
        }
        return (i10 == 16 && this.windLevel == 115 && this.coldLevel == 115 && this.windLevelOverclock == 134 && this.coldLevelOverclock == 173) ? 2.0f : -1.0f;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final int getTargetTemperature() {
        return this.targetTemperature;
    }

    @k
    public final byte[] getTempHistories() {
        return this.tempHistories;
    }

    public final int getTemperature() {
        return this.temperature;
    }

    public final int getTemperatureDecimal() {
        return this.temperatureDecimal;
    }

    @l
    public final String getUuid() {
        return this.uuid;
    }

    public final int getWindLevel() {
        return this.windLevel;
    }

    public final int getWindLevelOverclock() {
        return this.windLevelOverclock;
    }

    public final int getWindRunLevel() {
        return this.windRunLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.deviceName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.address;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z10 = this.isConnected;
        ?? r22 = z10;
        if (z10) {
            r22 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r22) * 31) + this.deviceCode.hashCode()) * 31;
        String str3 = this.firmwareVersion;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z11 = this.lightState;
        ?? r23 = z11;
        if (z11) {
            r23 = 1;
        }
        int i10 = (((((((((((((iHashCode4 + r23) * 31) + this.windLevel) * 31) + this.coldLevel) * 31) + this.temperature) * 31) + this.temperatureDecimal) * 31) + this.runMode) * 31) + this.targetTemperature) * 31;
        boolean z12 = this.overClockUsable;
        ?? r24 = z12;
        if (z12) {
            r24 = 1;
        }
        int i11 = (((((((((((((((((i10 + r24) * 31) + this.overClockUsableLevel) * 31) + this.windLevelOverclock) * 31) + this.coldLevelOverclock) * 31) + this.speed) * 31) + this.windRunLevel) * 31) + this.coldRunLevel) * 31) + this.ledType) * 31) + this.hotSurfaceTemperature) * 31;
        LedData ledData = this.ledData;
        int iHashCode5 = (i11 + (ledData == null ? 0 : ledData.hashCode())) * 31;
        boolean z13 = this.coldProtection;
        ?? r25 = z13;
        if (z13) {
            r25 = 1;
        }
        int i12 = (iHashCode5 + r25) * 31;
        boolean z14 = this.hotProtection;
        ?? r26 = z14;
        if (z14) {
            r26 = 1;
        }
        int i13 = (i12 + r26) * 31;
        boolean z15 = this.hotProtectionEnabled;
        ?? r27 = z15;
        if (z15) {
            r27 = 1;
        }
        int i14 = (i13 + r27) * 31;
        boolean z16 = this.coldProtectionEnabled;
        ?? r28 = z16;
        if (z16) {
            r28 = 1;
        }
        int iHashCode6 = (((((((i14 + r28) * 31) + Arrays.hashCode(this.tempHistories)) * 31) + this.ipType) * 31) + this.modeCustom) * 31;
        boolean z17 = this.isExperimentalRunModeOn;
        int i15 = (iHashCode6 + (z17 ? 1 : z17)) * 31;
        Integer num = this.experimentalRunModeValue;
        int iHashCode7 = (i15 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.uuid;
        return ((iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.quickSwitchRunMode;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isExperimentalRunModeOn() {
        return this.isExperimentalRunModeOn;
    }

    public final void setAddress(@l String str) {
        this.address = str;
    }

    public final void setColdLevel(int i10) {
        this.coldLevel = i10;
    }

    public final void setColdLevelOverclock(int i10) {
        this.coldLevelOverclock = i10;
    }

    public final void setColdProtection(boolean z10) {
        this.coldProtection = z10;
    }

    public final void setColdProtectionEnabled(boolean z10) {
        this.coldProtectionEnabled = z10;
    }

    public final void setColdRunLevel(int i10) {
        this.coldRunLevel = i10;
    }

    public final void setConnected(boolean z10) {
        this.isConnected = z10;
    }

    public final void setDeviceCode(@k String str) {
        f0.p(str, "<set-?>");
        this.deviceCode = str;
    }

    public final void setDeviceName(@l String str) {
        this.deviceName = str;
    }

    public final void setExperimentalRunModeOn(boolean z10) {
        this.isExperimentalRunModeOn = z10;
    }

    public final void setExperimentalRunModeValue(@l Integer num) {
        this.experimentalRunModeValue = num;
    }

    public final void setFirmwareVersion(@l String str) {
        this.firmwareVersion = str;
    }

    public final void setHotProtection(boolean z10) {
        this.hotProtection = z10;
    }

    public final void setHotProtectionEnabled(boolean z10) {
        this.hotProtectionEnabled = z10;
    }

    public final void setHotSurfaceTemperature(byte b10) {
        this.hotSurfaceTemperature = b10;
    }

    public final void setIpType(int i10) {
        this.ipType = i10;
    }

    public final void setLedData(@l LedData ledData) {
        this.ledData = ledData;
    }

    public final void setLedType(int i10) {
        this.ledType = i10;
    }

    public final void setLightState(boolean z10) {
        this.lightState = z10;
    }

    public final void setModeCustom(int i10) {
        this.modeCustom = i10;
    }

    public final void setOverClockUsable(boolean z10) {
        this.overClockUsable = true;
    }

    public final void setOverClockUsableLevel(int i10) {
        this.overClockUsableLevel = i10;
    }

    public final void setQuickSwitchRunMode(int i10) {
        this.quickSwitchRunMode = i10;
    }

    public final void setRunMode(int i10) {
        this.runMode = i10;
    }

    public final void setSpeed(int i10) {
        this.speed = i10;
    }

    public final void setTargetTemperature(int i10) {
        this.targetTemperature = i10;
    }

    public final void setTempHistories(@k byte[] bArr) {
        f0.p(bArr, "<set-?>");
        this.tempHistories = bArr;
    }

    public final void setTemperature(int i10) {
        this.temperature = i10;
    }

    public final void setTemperatureDecimal(int i10) {
        this.temperatureDecimal = i10;
    }

    public final void setUuid(@l String str) {
        this.uuid = str;
    }

    public final void setWindLevel(int i10) {
        this.windLevel = i10;
    }

    public final void setWindLevelOverclock(int i10) {
        this.windLevelOverclock = i10;
    }

    public final void setWindRunLevel(int i10) {
        this.windRunLevel = i10;
    }

    @k
    public String toString() {
        String str = this.deviceName;
        String str2 = this.address;
        boolean z10 = this.isConnected;
        String str3 = this.deviceCode;
        String str4 = this.firmwareVersion;
        boolean z11 = this.lightState;
        int i10 = this.windLevel;
        int i11 = this.coldLevel;
        int i12 = this.temperature;
        int i13 = this.temperatureDecimal;
        int i14 = this.runMode;
        int i15 = this.targetTemperature;
        boolean z12 = this.overClockUsable;
        int i16 = this.overClockUsableLevel;
        int i17 = this.windLevelOverclock;
        int i18 = this.coldLevelOverclock;
        int i19 = this.speed;
        int i20 = this.windRunLevel;
        int i21 = this.coldRunLevel;
        int i22 = this.ledType;
        byte b10 = this.hotSurfaceTemperature;
        return "WaspWingInfo(deviceName=" + str + ", address=" + str2 + ", isConnected=" + z10 + ", deviceCode=" + str3 + ", firmwareVersion=" + str4 + ", lightState=" + z11 + ", windLevel=" + i10 + ", coldLevel=" + i11 + ", temperature=" + i12 + ", temperatureDecimal=" + i13 + ", runMode=" + i14 + ", targetTemperature=" + i15 + ", overClockUsable=" + z12 + ", overClockUsableLevel=" + i16 + ", windLevelOverclock=" + i17 + ", coldLevelOverclock=" + i18 + ", speed=" + i19 + ", windRunLevel=" + i20 + ", coldRunLevel=" + i21 + ", ledType=" + i22 + ", hotSurfaceTemperature=" + ((int) b10) + ", ledData=" + this.ledData + ", coldProtection=" + this.coldProtection + ", hotProtection=" + this.hotProtection + ", hotProtectionEnabled=" + this.hotProtectionEnabled + ", coldProtectionEnabled=" + this.coldProtectionEnabled + ", tempHistories=" + Arrays.toString(this.tempHistories) + ", ipType=" + this.ipType + ", modeCustom=" + this.modeCustom + ", isExperimentalRunModeOn=" + this.isExperimentalRunModeOn + ", experimentalRunModeValue=" + this.experimentalRunModeValue + ", uuid=" + this.uuid + ", quickSwitchRunMode=" + this.quickSwitchRunMode + ee.a.f26979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(this.deviceName);
        out.writeString(this.address);
        out.writeInt(this.isConnected ? 1 : 0);
        out.writeString(this.deviceCode);
        out.writeString(this.firmwareVersion);
        out.writeInt(this.lightState ? 1 : 0);
        out.writeInt(this.windLevel);
        out.writeInt(this.coldLevel);
        out.writeInt(this.temperature);
        out.writeInt(this.temperatureDecimal);
        out.writeInt(this.runMode);
        out.writeInt(this.targetTemperature);
        out.writeInt(this.overClockUsable ? 1 : 0);
        out.writeInt(this.overClockUsableLevel);
        out.writeInt(this.windLevelOverclock);
        out.writeInt(this.coldLevelOverclock);
        out.writeInt(this.speed);
        out.writeInt(this.windRunLevel);
        out.writeInt(this.coldRunLevel);
        out.writeInt(this.ledType);
        out.writeByte(this.hotSurfaceTemperature);
        LedData ledData = this.ledData;
        if (ledData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            ledData.writeToParcel(out, i10);
        }
        out.writeInt(this.coldProtection ? 1 : 0);
        out.writeInt(this.hotProtection ? 1 : 0);
        out.writeInt(this.hotProtectionEnabled ? 1 : 0);
        out.writeInt(this.coldProtectionEnabled ? 1 : 0);
        out.writeByteArray(this.tempHistories);
        out.writeInt(this.ipType);
        out.writeInt(this.modeCustom);
        out.writeInt(this.isExperimentalRunModeOn ? 1 : 0);
        Integer num = this.experimentalRunModeValue;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.uuid);
        out.writeInt(this.quickSwitchRunMode);
    }

    /* JADX INFO: renamed from: 获取当前电压, reason: contains not printable characters */
    public final String m6() {
        return getReadableLevel(getColdRunLevel());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WaspWingInfo(String str, String str2, boolean z10, String str3, String str4, boolean z11, int i10, int i11, int i12, int i13, int i14, int i15, boolean z12, int i16, int i17, int i18, int i19, int i20, int i21, int i22, byte b10, LedData ledData, boolean z13, boolean z14, boolean z15, boolean z16, byte[] bArr, int i23, int i24, boolean z17, Integer num, String str5, int i25, int i26, int i27, u uVar) {
        int i28;
        int i29;
        byte[] bArr2;
        String str6 = (i26 & 1) != 0 ? null : str;
        String str7 = (i26 & 2) != 0 ? null : str2;
        boolean z18 = (i26 & 4) != 0 ? false : z10;
        String str8 = (i26 & 8) != 0 ? "all" : str3;
        String str9 = (i26 & 16) != 0 ? null : str4;
        boolean z19 = (i26 & 32) != 0 ? false : z11;
        int i30 = (i26 & 64) != 0 ? 0 : i10;
        int i31 = (i26 & 128) != 0 ? 0 : i11;
        int i32 = (i26 & 256) != 0 ? 0 : i12;
        int i33 = (i26 & 512) != 0 ? 0 : i13;
        int i34 = (i26 & 1024) != 0 ? 1 : i14;
        int i35 = (i26 & 2048) != 0 ? 0 : i15;
        boolean z20 = (i26 & 4096) != 0 ? false : z12;
        int i36 = (i26 & 8192) != 0 ? 0 : i16;
        int i37 = (i26 & 16384) != 0 ? 0 : i17;
        int i38 = (i26 & 32768) != 0 ? 0 : i18;
        int i39 = (i26 & 65536) != 0 ? 0 : i19;
        int i40 = (i26 & 131072) != 0 ? 0 : i20;
        int i41 = (i26 & 262144) != 0 ? 0 : i21;
        int i42 = (i26 & 524288) != 0 ? 0 : i22;
        byte b11 = (i26 & 1048576) != 0 ? (byte) 0 : b10;
        LedData ledData2 = (i26 & 2097152) != 0 ? null : ledData;
        boolean z21 = (i26 & 4194304) != 0 ? true : z13;
        boolean z22 = (i26 & 8388608) != 0 ? true : z14;
        boolean z23 = (i26 & 16777216) != 0 ? false : z15;
        boolean z24 = (i26 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? false : z16;
        if ((i26 & 67108864) != 0) {
            i28 = i37;
            i29 = i36;
            bArr2 = new byte[0];
        } else {
            i28 = i37;
            i29 = i36;
            bArr2 = bArr;
        }
        this(str6, str7, z18, str8, str9, z19, i30, i31, i32, i33, i34, i35, z20, i29, i28, i38, i39, i40, i41, i42, b11, ledData2, z21, z22, z23, z24, bArr2, (134217728 & i26) != 0 ? 0 : i23, (i26 & 268435456) != 0 ? 0 : i24, (i26 & 536870912) != 0 ? false : z17, (i26 & 1073741824) != 0 ? 0 : num, (i26 & Integer.MIN_VALUE) != 0 ? null : str5, (i27 & 1) != 0 ? -1 : i25);
    }
}
