package m9;

import android.bluetooth.BluetoothDevice;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import com.flydigi.sdk.bluetooth.t;
import com.flydigi.sdk.gamepad.GamepadInfo;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends x0 implements com.flydigi.sdk.bluetooth.t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final j0<GamepadInfo> f40886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<GamepadInfo> f40887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final j0<GamepadInfo> f40888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final LiveData<GamepadInfo> f40889g;

    public u() {
        j0<GamepadInfo> j0Var = new j0<>();
        this.f40886d = j0Var;
        this.f40887e = j0Var;
        j0<GamepadInfo> j0Var2 = new j0<>();
        this.f40888f = j0Var2;
        this.f40889g = j0Var2;
        s.A(this);
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void N(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.b(this, bluetoothDevice);
        GamepadInfo gamepadInfoF = this.f40886d.f();
        if (gamepadInfoF != null) {
            if (androidx.core.util.j.a(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, gamepadInfoF.getAddress())) {
                gamepadInfoF.setConnectState(0);
                i(gamepadInfoF);
            }
        }
    }

    @Override // androidx.lifecycle.x0
    public void e() {
        super.e();
        s.i0(this);
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void e0(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.a(this, bluetoothDevice);
        GamepadInfo gamepadInfoF = this.f40886d.f();
        boolean z10 = false;
        if (gamepadInfoF != null && gamepadInfoF.isConnected()) {
            z10 = true;
        }
        if (z10 || bluetoothDevice == null) {
            return;
        }
        GamepadInfo gamepadInfo = new GamepadInfo();
        gamepadInfo.setConnectState(1);
        gamepadInfo.setAddress(bluetoothDevice.getAddress());
        String name = bluetoothDevice.getName();
        f0.o(name, "it.name");
        gamepadInfo.set_deviceName(name);
        i(gamepadInfo);
        this.f40888f.o(gamepadInfo);
    }

    @yt.k
    public final LiveData<GamepadInfo> g() {
        return this.f40889g;
    }

    @yt.k
    public final LiveData<GamepadInfo> h() {
        return this.f40887e;
    }

    public final void i(@yt.k GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "gamepadInfo");
        if (!(gamepadInfo.getDeviceCode().length() > 0) || androidx.core.util.j.a("all", gamepadInfo.getDeviceCode())) {
            return;
        }
        this.f40886d.o(gamepadInfo);
    }
}
