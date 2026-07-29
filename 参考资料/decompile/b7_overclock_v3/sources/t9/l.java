package t9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import com.flydigi.sdk.bluetooth.t;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.internal.f0;
import t9.i;

/* JADX INFO: loaded from: classes3.dex */
public class l extends x0 implements i, t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final j0<WaspWingInfo> f50994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<WaspWingInfo> f50995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final j0<WaspWingInfo> f50996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final LiveData<WaspWingInfo> f50997g;

    public l() {
        j0<WaspWingInfo> j0Var = new j0<>();
        this.f50994d = j0Var;
        this.f50995e = j0Var;
        j0<WaspWingInfo> j0Var2 = new j0<>();
        this.f50996f = j0Var2;
        this.f50997g = j0Var2;
        j.D(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.b(this, bluetoothDevice);
    }

    @Override // t9.i
    public void F1(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        i(waspWingInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void N(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.b(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt gatt) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(gatt, "gatt");
        i.a.e(this, gatt);
        WaspWingInfo waspWingInfoF = this.f50994d.f();
        if (waspWingInfoF == null || (waspWingInfoCopy = waspWingInfoF.copy(((-1) & 1) != 0 ? waspWingInfoF.deviceName : null, ((-1) & 2) != 0 ? waspWingInfoF.address : null, ((-1) & 4) != 0 ? waspWingInfoF.isConnected : false, ((-1) & 8) != 0 ? waspWingInfoF.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfoF.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfoF.lightState : false, ((-1) & 64) != 0 ? waspWingInfoF.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfoF.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfoF.temperature : 0, ((-1) & 512) != 0 ? waspWingInfoF.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfoF.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfoF.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfoF.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfoF.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfoF.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfoF.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfoF.speed : 0, ((-1) & 131072) != 0 ? waspWingInfoF.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfoF.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfoF.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfoF.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfoF.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfoF.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfoF.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfoF.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfoF.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfoF.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfoF.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfoF.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfoF.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfoF.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfoF.uuid : null, (1 & 1) != 0 ? waspWingInfoF.quickSwitchRunMode : 0)) == null || !androidx.core.util.j.a(gatt.getDevice().getAddress(), waspWingInfoCopy.getAddress())) {
            return;
        }
        waspWingInfoCopy.setConnected(false);
        F1(waspWingInfoCopy.copy(((-1) & 1) != 0 ? waspWingInfoCopy.deviceName : null, ((-1) & 2) != 0 ? waspWingInfoCopy.address : null, ((-1) & 4) != 0 ? waspWingInfoCopy.isConnected : false, ((-1) & 8) != 0 ? waspWingInfoCopy.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfoCopy.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfoCopy.lightState : false, ((-1) & 64) != 0 ? waspWingInfoCopy.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfoCopy.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfoCopy.temperature : 0, ((-1) & 512) != 0 ? waspWingInfoCopy.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfoCopy.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfoCopy.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfoCopy.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfoCopy.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfoCopy.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfoCopy.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfoCopy.speed : 0, ((-1) & 131072) != 0 ? waspWingInfoCopy.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfoCopy.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfoCopy.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfoCopy.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfoCopy.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfoCopy.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfoCopy.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfoCopy.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfoCopy.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfoCopy.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfoCopy.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfoCopy.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfoCopy.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfoCopy.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfoCopy.uuid : null, (1 & 1) != 0 ? waspWingInfoCopy.quickSwitchRunMode : 0));
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.d(this, bluetoothDevice);
    }

    @Override // androidx.lifecycle.x0
    public void e() {
        super.e();
        j.e0(this);
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void e0(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        i.a.c(this, device);
        this.f50996f.o(new WaspWingInfo(device.getName(), device.getAddress(), true, c.f50952a.a(device.getName()), null, false, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, (byte) 0, null, false, false, false, false, null, 0, 0, false, null, null, 0, -16, 1, null));
    }

    @yt.k
    public final LiveData<WaspWingInfo> g() {
        return this.f50997g;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @yt.k
    public final LiveData<WaspWingInfo> h() {
        return this.f50995e;
    }

    public final void i(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        if (androidx.core.util.j.a(this.f50994d.f(), waspWingInfo)) {
            return;
        }
        this.f50994d.o(waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0));
    }

    public final void j(float f10) {
        WaspWingInfo waspWingInfoCopy;
        WaspWingInfo waspWingInfoF = this.f50994d.f();
        if (waspWingInfoF == null || (waspWingInfoCopy = waspWingInfoF.copy(((-1) & 1) != 0 ? waspWingInfoF.deviceName : null, ((-1) & 2) != 0 ? waspWingInfoF.address : null, ((-1) & 4) != 0 ? waspWingInfoF.isConnected : false, ((-1) & 8) != 0 ? waspWingInfoF.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfoF.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfoF.lightState : false, ((-1) & 64) != 0 ? waspWingInfoF.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfoF.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfoF.temperature : 0, ((-1) & 512) != 0 ? waspWingInfoF.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfoF.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfoF.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfoF.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfoF.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfoF.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfoF.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfoF.speed : 0, ((-1) & 131072) != 0 ? waspWingInfoF.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfoF.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfoF.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfoF.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfoF.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfoF.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfoF.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfoF.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfoF.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfoF.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfoF.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfoF.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfoF.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfoF.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfoF.uuid : null, (1 & 1) != 0 ? waspWingInfoF.quickSwitchRunMode : 0)) == null) {
            return;
        }
        if (f10 == 0.0f) {
            j.f50990a.W(1, (124 & 2) != 0 ? 0 : waspWingInfoCopy.getTargetTemperature(), (124 & 4) != 0 ? 0 : 4000, (124 & 8) != 0 ? 0 : 125, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
            return;
        }
        if (f10 == 1.0f) {
            j.f50990a.W(1, (124 & 2) != 0 ? 0 : waspWingInfoCopy.getTargetTemperature(), (124 & 4) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MIN, (124 & 8) != 0 ? 0 : 125, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
            return;
        }
        if (f10 == 2.0f) {
            j.f50990a.W(2, (124 & 2) != 0 ? 0 : waspWingInfoCopy.getTargetTemperature(), (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MAX, (124 & 32) != 0 ? 0 : 178, (124 & 64) == 0 ? 0 : 0);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    @Override // t9.i
    public void q2(@yt.k byte[] bArr) {
        i.a.g(this, bArr);
    }
}
