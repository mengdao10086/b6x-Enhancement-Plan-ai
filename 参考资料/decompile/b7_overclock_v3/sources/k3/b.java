package k3;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.t0;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.bluetooth.t;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateItem;
import g.n0;
import g.p0;
import h0.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import m9.e;
import m9.h;
import m9.r;
import m9.s;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class b implements m, t, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f36985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GamepadInfo f36986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f36987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f36988d = new Runnable() { // from class: k3.a
        @Override // java.lang.Runnable
        public final void run() {
            this.f36984a.v();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36990f;

    public interface a {
        void A(byte[] bArr);

        void a(GamepadInfo gamepadInfo);

        void l();

        void q(GamepadInfo gamepadInfo);

        void r(byte[] bArr, byte[] bArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context) {
        if (context instanceof a) {
            this.f36985a = (a) context;
        }
        HandlerThread handlerThread = new HandlerThread("BluetoothClient");
        handlerThread.start();
        this.f36987c = new Handler(handlerThread.getLooper());
        s.A(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@k BluetoothDevice bluetoothDevice) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onGattConnectTimeout:");
        sb2.append(bluetoothDevice.getName());
        sb2.append(ee.a.f26978c);
        sb2.append(bluetoothDevice.getAddress());
        sb2.append(ee.a.f26979d);
        GamepadInfo gamepadInfo = this.f36986b;
        if (gamepadInfo != null) {
            gamepadInfo.setConnectState(0);
            a aVar = this.f36985a;
            if (aVar != null) {
                aVar.q(this.f36986b);
            }
        }
    }

    @Override // m9.r
    public void B0(boolean z10, @k Pair<Float, Float> pair) {
    }

    @Override // m9.r
    public void B1(@n0 byte[] bArr, @n0 byte[] bArr2) {
        a aVar;
        if (this.f36986b.isDriverMode() || this.f36986b.isGamepadHalf()) {
            byte[] bArr3 = this.f36989e;
            if (bArr3 == null || !Arrays.equals(bArr3, bArr2) || m9.b.d(bArr) || m9.b.w(Integer.valueOf(this.f36986b.getDeviceType()), bArr) || m9.b.Q(Integer.valueOf(this.f36986b.getDeviceType()), bArr) || (this.f36986b.isSupportLunpan() && m9.b.c0(Integer.valueOf(this.f36986b.getDeviceType()), bArr))) {
                this.f36989e = Arrays.copyOf(bArr2, bArr2.length);
                this.f36990f = 3;
            } else {
                this.f36990f--;
            }
            if (this.f36990f <= 0 || (aVar = this.f36985a) == null) {
                return;
            }
            aVar.r(bArr, bArr2);
        }
    }

    @Override // m9.r
    public void H(@n0 byte[] bArr) {
    }

    @Override // m9.r
    public void I2(@n0 GamepadInfo gamepadInfo) {
        this.f36986b = gamepadInfo;
        a aVar = this.f36985a;
        if (aVar != null) {
            aVar.q(gamepadInfo);
        }
    }

    @Override // m9.r
    public void M0(boolean z10, @k Pair<Float, Float> pair) {
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void N(@p0 BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGattK = s.k();
        if (bluetoothGattK != null) {
            O2(bluetoothGattK);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(BluetoothGatt bluetoothGatt) {
        GamepadInfo gamepadInfo;
        if (bluetoothGatt.getDevice() == null || (gamepadInfo = this.f36986b) == null) {
            return;
        }
        gamepadInfo.setConnectState(0);
        a aVar = this.f36985a;
        if (aVar != null) {
            aVar.a(this.f36986b);
            this.f36985a.q(this.f36986b);
        }
        d();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        this.f36987c.removeCallbacks(this.f36988d);
        if (z10) {
            d();
        }
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
    }

    @Override // m9.r
    public void R2(Pair<Integer, Integer> pair) {
    }

    @Override // m9.r
    public void U() {
        a aVar = this.f36985a;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@k BluetoothDevice bluetoothDevice) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onGattConnecting:");
        sb2.append(bluetoothDevice.getName());
        sb2.append(ee.a.f26978c);
        sb2.append(bluetoothDevice.getAddress());
        sb2.append(ee.a.f26979d);
        GamepadInfo gamepadInfo = this.f36986b;
        if (gamepadInfo != null) {
            gamepadInfo.setConnectState(1);
            a aVar = this.f36985a;
            if (aVar != null) {
                aVar.q(this.f36986b);
            }
        }
    }

    @Override // m9.r
    public void Z1(boolean z10, @k Pair<Float, Float> pair) {
    }

    @Override // m9.r
    public void a2(@n0 byte[] bArr) {
        a aVar = this.f36985a;
        if (aVar != null) {
            aVar.A(bArr);
        }
    }

    public void b() {
        GamepadInfo gamepadInfo = this.f36986b;
        if (gamepadInfo == null || gamepadInfo.isDisconnected()) {
            d();
            if (this.f36986b == null) {
                this.f36986b = v5.a.j().d();
            }
            this.f36985a.q(this.f36986b);
            return;
        }
        BluetoothDevice bluetoothDeviceM = com.blankj.utilcode.util.n0.x(this.f36986b.getAddress()) ? s.m(this.f36986b.getAddress()) : null;
        if (bluetoothDeviceM == null || !s.u(bluetoothDeviceM)) {
            s.f();
        } else {
            e();
        }
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
    }

    public final boolean c(byte[] bArr) {
        for (int i10 = 3; i10 < 18; i10++) {
            if (bArr[i10] != -1) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        this.f36987c.removeCallbacks(this.f36988d);
        this.f36987c.postDelayed(this.f36988d, 1000L);
    }

    public void e() {
        s.D();
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void e0(@p0 BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT < 30 || !t0.B() || !bluetoothDevice.getName().toLowerCase().contains(h.f40777t)) {
            d();
            return;
        }
        if (this.f36986b == null) {
            this.f36986b = v5.a.j().d();
        }
        this.f36986b.set_deviceName(bluetoothDevice.getName());
        s.d(bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@k BluetoothDevice bluetoothDevice) {
    }

    public void f(byte b10) {
        s.E(b10);
    }

    public void g(int i10) {
        s.O(i10);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@k BluetoothDevice bluetoothDevice) {
    }

    public void h() {
        s.G();
    }

    public void i(byte[] bArr) {
        s.I(bArr, Boolean.FALSE);
    }

    public void j() {
        s.S(true);
    }

    public void k() {
        s.P();
    }

    @Override // m9.r
    public void k0() {
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
    }

    public void m() {
        s.Q();
    }

    @Override // m9.r
    public void m2(int i10) {
        this.f36986b.setDeviceMode(i10);
        a aVar = this.f36985a;
        if (aVar != null) {
            aVar.q(this.f36986b);
        }
    }

    public void n() {
        s.Y();
    }

    @Override // m9.r
    public void n0(@n0 List<Integer> list) {
    }

    public void o() {
        s.X();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        d();
    }

    public void r() {
        s.Z();
    }

    public void s() {
        s.a0(0);
    }

    public void t() {
        s.a0(3);
    }

    public void u() {
        s.a0(1);
    }

    @Override // m9.r
    public void u0(@p0 BluetoothDevice bluetoothDevice, @n0 GamepadInfo gamepadInfo) {
        this.f36987c.removeCallbacks(this.f36988d);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onGattConnected:");
        sb2.append(gamepadInfo);
        if (this.f36985a != null) {
            if (gamepadInfo.isGamepadHalf() && gamepadInfo.isFlashplayMode() && u9.b.e(true) && !u9.b.e(false)) {
                gamepadInfo.setMappingMode(0);
            }
            if (!com.blankj.utilcode.util.n0.b(Boolean.valueOf(this.f36986b.isConnected()), Boolean.valueOf(gamepadInfo.isConnected()))) {
                this.f36985a.a(gamepadInfo);
            }
            this.f36985a.q(gamepadInfo);
        }
        this.f36986b = gamepadInfo;
    }

    public final void v() {
        if (s.k() != null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 30 && d.a(j1.a(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            d();
            return;
        }
        List<BluetoothDevice> listI = s.i(Boolean.TRUE);
        if (!com.blankj.utilcode.util.n0.z(listI)) {
            d();
            return;
        }
        if (this.f36986b == null) {
            this.f36986b = v5.a.j().d();
        }
        this.f36986b.set_deviceName(listI.get(0).getName());
        s.d(listI.get(0));
    }

    public void w(List<byte[]> list) {
        ArrayList arrayList = new ArrayList();
        for (byte[] bArr : list) {
            if (e.q(bArr) && c(bArr)) {
                arrayList.add(bArr);
            }
        }
        s.H(arrayList, Boolean.TRUE);
    }

    public void x() {
        s.j0();
    }

    public void y(boolean z10, List<CFGVibrateItem> list) {
        byte[] bArr = new byte[20];
        Arrays.fill(bArr, (byte) -1);
        bArr[0] = 85;
        bArr[1] = 0;
        bArr[2] = 1;
        bArr[3] = z10 ? (byte) 1 : (byte) 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            CFGVibrateItem cFGVibrateItem = list.get(i10);
            int i11 = (i10 * 5) + 4;
            bArr[i11] = (byte) o9.b.b(cFGVibrateItem.getKeyId());
            if (cFGVibrateItem.getTriggerType() != null) {
                bArr[i11 + 1] = cFGVibrateItem.getTriggerType().byteValue();
            }
            if (cFGVibrateItem.getStrong() != null) {
                bArr[i11 + 2] = cFGVibrateItem.getStrong().byteValue();
            }
            if (cFGVibrateItem.getPeriod() != null) {
                bArr[i11 + 3] = cFGVibrateItem.getPeriod().byteValue();
            }
            if (cFGVibrateItem.getPosition() != null) {
                bArr[i11 + 4] = cFGVibrateItem.getPosition().byteValue();
            }
        }
        bArr[19] = 0;
        for (int i12 = 0; i12 < 19; i12++) {
            bArr[19] = (byte) (bArr[19] + bArr[i12]);
        }
        bArr[19] = (byte) (bArr[19] & 255);
        s.I(bArr, Boolean.FALSE);
    }

    @Override // m9.r
    public void z0(int i10, int i11) {
    }
}
