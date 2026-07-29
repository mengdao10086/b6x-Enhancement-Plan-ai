package com.flydigi.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceInfo implements Cloneable, Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new a();
    public String A;
    public String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f16190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f16193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List<Integer> f16199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<Integer> f16200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f16201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16202z;

    public class a implements Parcelable.Creator<DeviceInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    }

    public DeviceInfo() {
        this.f16177a = null;
        this.f16178b = null;
        this.f16179c = null;
        this.f16180d = "all";
        this.f16181e = 0;
        this.f16182f = -1;
        this.f16183g = 0;
        this.f16184h = 1;
        this.f16185i = 1;
        this.f16186j = 0;
        this.f16187k = -1;
        this.f16188l = 0;
        this.f16189m = 0;
        this.f16190n = null;
        this.f16191o = false;
        this.f16192p = false;
        this.f16193q = null;
        this.f16194r = 0;
        this.f16195s = false;
        this.f16196t = false;
        this.f16197u = false;
        this.f16198v = false;
        this.f16199w = new ArrayList();
        this.f16200x = new ArrayList();
        this.f16201y = false;
        this.f16202z = false;
        this.A = null;
        this.B = null;
    }

    public static DeviceInfo a(GamepadInfo gamepadInfo) {
        DeviceInfo deviceInfo = new DeviceInfo("all");
        if (gamepadInfo != null) {
            deviceInfo.f16177a = gamepadInfo.getAddress();
            deviceInfo.f16178b = gamepadInfo.getDeviceName();
            deviceInfo.f16180d = gamepadInfo.getDeviceCode();
            deviceInfo.f16181e = gamepadInfo.getDeviceType();
            deviceInfo.f16182f = gamepadInfo.getDeviceMode();
            deviceInfo.f16183g = gamepadInfo.getChipType();
            deviceInfo.f16185i = gamepadInfo.getConnectMode();
            deviceInfo.f16186j = gamepadInfo.getConnectState();
            deviceInfo.f16187k = gamepadInfo.getMappingMode();
            deviceInfo.f16188l = gamepadInfo.getUsb0Device();
            deviceInfo.f16189m = gamepadInfo.getUsb1Device();
            deviceInfo.f16190n = gamepadInfo.getFirmwareVersion();
            deviceInfo.f16191o = gamepadInfo.isSupportFlashplay();
            deviceInfo.f16192p = gamepadInfo.isDriverConnected();
            deviceInfo.f16193q = gamepadInfo.getDriverVersion();
            deviceInfo.f16194r = gamepadInfo.getBattery();
            deviceInfo.f16195s = gamepadInfo.isSupportLinearButton();
            deviceInfo.f16196t = gamepadInfo.isSupportMotion();
            deviceInfo.f16197u = gamepadInfo.isSupportLunpan();
            deviceInfo.f16198v = gamepadInfo.isSupportLed();
            deviceInfo.f16199w = gamepadInfo.getSupportKeys();
            deviceInfo.f16200x = gamepadInfo.getBatteryLevelGap();
            deviceInfo.f16184h = gamepadInfo.getMotionChipType();
            deviceInfo.f16201y = gamepadInfo.getIpType();
            deviceInfo.f16202z = gamepadInfo.isSupportSwitch();
            deviceInfo.A = gamepadInfo.getSwitchChipVersion();
            deviceInfo.B = gamepadInfo.getUuid();
        }
        return deviceInfo;
    }

    public static GamepadInfo b(DeviceInfo deviceInfo) {
        GamepadInfo gamepadInfo = new GamepadInfo("all");
        if (deviceInfo != null) {
            gamepadInfo.setAddress(deviceInfo.f16177a);
            gamepadInfo.setDeviceName(deviceInfo.f16178b);
            gamepadInfo.setDeviceCode(deviceInfo.f16180d);
            gamepadInfo.setDeviceType(deviceInfo.f16181e);
            gamepadInfo.setChipType(deviceInfo.f16183g);
            gamepadInfo.setDeviceMode(deviceInfo.f16182f);
            gamepadInfo.setConnectMode(deviceInfo.f16185i);
            gamepadInfo.setConnectState(deviceInfo.f16186j);
            gamepadInfo.setMappingMode(deviceInfo.f16187k);
            gamepadInfo.setUsb0Device(deviceInfo.f16188l);
            gamepadInfo.setUsb1Device(deviceInfo.f16189m);
            gamepadInfo.setFirmwareVersion(deviceInfo.f16190n);
            gamepadInfo.setSupportFlashplay(deviceInfo.f16191o);
            gamepadInfo.setDriverConnected(deviceInfo.f16192p);
            gamepadInfo.setDriverVersion(deviceInfo.f16193q);
            gamepadInfo.setBattery(deviceInfo.f16194r);
            gamepadInfo.setSupportLinearButton(deviceInfo.f16195s);
            gamepadInfo.setSupportMotion(deviceInfo.f16196t);
            gamepadInfo.setSupportLunpan(deviceInfo.f16197u);
            gamepadInfo.setSupportLed(deviceInfo.f16198v);
            gamepadInfo.setSupportKeys(deviceInfo.f16199w);
            gamepadInfo.setBatteryLevelGap(deviceInfo.f16200x);
            gamepadInfo.setMotionChipType(deviceInfo.f16184h);
            gamepadInfo.setIpType(deviceInfo.f16201y);
            gamepadInfo.setSwitchChipVersion(deviceInfo.A);
            gamepadInfo.setSupportSwitch(deviceInfo.f16202z);
            gamepadInfo.setUuid(deviceInfo.B);
        }
        return gamepadInfo;
    }

    public void A0(String str) {
        this.f16180d = str;
    }

    public void B0(int i10) {
        this.f16182f = i10;
    }

    public int C() {
        return this.f16185i;
    }

    public void C0(String str) {
        this.f16178b = str;
    }

    public void D0(int i10) {
        this.f16181e = i10;
    }

    public void E0(boolean z10) {
        this.f16192p = z10;
    }

    public int F() {
        return this.f16186j;
    }

    public void F0(String str) {
        this.f16193q = str;
    }

    public void G0(String str) {
        this.f16190n = str;
    }

    public void H0(boolean z10) {
        this.f16201y = z10;
    }

    public void I0(int i10) {
        this.f16187k = i10;
    }

    public void J0(int i10) {
        this.f16184h = i10;
    }

    public void K0(String str) {
        this.f16179c = str;
    }

    public void L0(boolean z10) {
        this.f16191o = z10;
    }

    public void M0(List<Integer> list) {
        this.f16199w = list;
    }

    public void N0(boolean z10) {
        this.f16198v = z10;
    }

    public void O0(boolean z10) {
        this.f16195s = z10;
    }

    public void P0(boolean z10) {
        this.f16197u = z10;
    }

    public void Q0(boolean z10) {
        this.f16196t = z10;
    }

    public void R0(boolean z10) {
        this.f16202z = z10;
    }

    public String S() {
        return this.f16180d;
    }

    public void S0(String str) {
        this.A = str;
    }

    public void T0(int i10) {
        this.f16188l = i10;
    }

    public void U0(int i10) {
        this.f16189m = i10;
    }

    public int V() {
        return this.f16182f;
    }

    public void V0(String str) {
        this.B = str;
    }

    public String Y() {
        return this.f16178b;
    }

    public int a0() {
        return this.f16181e;
    }

    public String c0() {
        return this.f16193q;
    }

    public String d0() {
        return this.f16190n;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f16177a;
    }

    public int e0() {
        return this.f16187k;
    }

    public int f0() {
        return this.f16184h;
    }

    public int g() {
        return this.f16194r;
    }

    public String g0() {
        return this.f16179c;
    }

    public List<Integer> h0() {
        return this.f16199w;
    }

    public String i0() {
        return this.A;
    }

    public List<Integer> j() {
        return this.f16200x;
    }

    public int j0() {
        return this.f16188l;
    }

    public int k0() {
        return this.f16189m;
    }

    public String l0() {
        return this.B;
    }

    public boolean m0() {
        return this.f16192p;
    }

    public boolean n0() {
        return this.f16201y;
    }

    public boolean o0() {
        return this.f16191o;
    }

    public boolean p0() {
        return this.f16198v;
    }

    public boolean q0() {
        return this.f16195s;
    }

    public boolean r0() {
        return this.f16197u;
    }

    public int s() {
        return this.f16183g;
    }

    public boolean s0() {
        return this.f16196t;
    }

    public boolean t0() {
        return this.f16202z;
    }

    public void u0(String str) {
        this.f16177a = str;
    }

    public void v0(int i10) {
        this.f16194r = i10;
    }

    public void w0(List<Integer> list) {
        this.f16200x = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f16177a);
        parcel.writeString(this.f16178b);
        parcel.writeString(this.f16179c);
        parcel.writeString(this.f16180d);
        parcel.writeInt(this.f16181e);
        parcel.writeInt(this.f16182f);
        parcel.writeInt(this.f16183g);
        parcel.writeInt(this.f16184h);
        parcel.writeInt(this.f16185i);
        parcel.writeInt(this.f16186j);
        parcel.writeInt(this.f16187k);
        parcel.writeInt(this.f16188l);
        parcel.writeInt(this.f16189m);
        parcel.writeString(this.f16190n);
        parcel.writeByte(this.f16191o ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f16192p ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f16193q);
        parcel.writeInt(this.f16194r);
        parcel.writeByte(this.f16195s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f16196t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f16197u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f16198v ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f16199w);
        parcel.writeList(this.f16200x);
        parcel.writeByte(this.f16201y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f16202z ? (byte) 1 : (byte) 0);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }

    public void x0(int i10) {
        this.f16183g = i10;
    }

    public void y0(int i10) {
        this.f16185i = i10;
    }

    public void z0(int i10) {
        this.f16186j = i10;
    }

    public DeviceInfo(String str) {
        this.f16177a = null;
        this.f16178b = null;
        this.f16179c = null;
        this.f16180d = "all";
        this.f16181e = 0;
        this.f16182f = -1;
        this.f16183g = 0;
        this.f16184h = 1;
        this.f16185i = 1;
        this.f16186j = 0;
        this.f16187k = -1;
        this.f16188l = 0;
        this.f16189m = 0;
        this.f16190n = null;
        this.f16191o = false;
        this.f16192p = false;
        this.f16193q = null;
        this.f16194r = 0;
        this.f16195s = false;
        this.f16196t = false;
        this.f16197u = false;
        this.f16198v = false;
        this.f16199w = new ArrayList();
        this.f16200x = new ArrayList();
        this.f16201y = false;
        this.f16202z = false;
        this.A = null;
        this.B = null;
        this.f16180d = str;
    }

    public DeviceInfo(Parcel parcel) {
        this.f16177a = null;
        this.f16178b = null;
        this.f16179c = null;
        this.f16180d = "all";
        this.f16181e = 0;
        this.f16182f = -1;
        this.f16183g = 0;
        this.f16184h = 1;
        this.f16185i = 1;
        this.f16186j = 0;
        this.f16187k = -1;
        this.f16188l = 0;
        this.f16189m = 0;
        this.f16190n = null;
        this.f16191o = false;
        this.f16192p = false;
        this.f16193q = null;
        this.f16194r = 0;
        this.f16195s = false;
        this.f16196t = false;
        this.f16197u = false;
        this.f16198v = false;
        this.f16199w = new ArrayList();
        this.f16200x = new ArrayList();
        this.f16201y = false;
        this.f16202z = false;
        this.A = null;
        this.B = null;
        this.f16177a = parcel.readString();
        this.f16178b = parcel.readString();
        this.f16179c = parcel.readString();
        this.f16180d = parcel.readString();
        this.f16181e = parcel.readInt();
        this.f16182f = parcel.readInt();
        this.f16183g = parcel.readInt();
        this.f16184h = parcel.readInt();
        this.f16185i = parcel.readInt();
        this.f16186j = parcel.readInt();
        this.f16187k = parcel.readInt();
        this.f16188l = parcel.readInt();
        this.f16189m = parcel.readInt();
        this.f16190n = parcel.readString();
        this.f16191o = parcel.readByte() != 0;
        this.f16192p = parcel.readByte() != 0;
        this.f16193q = parcel.readString();
        this.f16194r = parcel.readInt();
        this.f16195s = parcel.readByte() != 0;
        this.f16196t = parcel.readByte() != 0;
        this.f16197u = parcel.readByte() != 0;
        this.f16198v = parcel.readByte() != 0;
        parcel.readList(this.f16199w, Integer.class.getClassLoader());
        parcel.readList(this.f16200x, Integer.class.getClassLoader());
        this.f16201y = parcel.readByte() != 0;
        this.f16202z = parcel.readByte() != 0;
        this.A = parcel.readString();
        this.B = parcel.readString();
    }
}
