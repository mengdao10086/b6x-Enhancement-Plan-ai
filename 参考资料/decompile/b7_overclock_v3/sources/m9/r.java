package m9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.flydigi.sdk.bluetooth.w;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
public interface r extends com.flydigi.sdk.bluetooth.w {

    @t0({"SMAP\nGamepadGattCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GamepadGattCallback.kt\ncom/flydigi/sdk/gamepad/GamepadGattCallback$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,118:1\n1855#2,2:119\n*S KotlinDebug\n*F\n+ 1 GamepadGattCallback.kt\ncom/flydigi/sdk/gamepad/GamepadGattCallback$DefaultImpls\n*L\n40#1:119,2\n*E\n"})
    public static final class a {
        public static void a(@yt.k r rVar, @yt.k byte[] value) {
            f0.p(value, "value");
        }

        public static void b(@yt.k r rVar) {
        }

        public static void c(@yt.k r rVar, @yt.k GamepadInfo deviceInfo) {
            f0.p(deviceInfo, "deviceInfo");
        }

        public static void d(@yt.k r rVar, int i10) {
        }

        public static void e(@yt.k r rVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.a(rVar, device);
        }

        public static void f(@yt.k r rVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.b(rVar, device);
        }

        public static void g(@yt.k r rVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.c(rVar, device);
        }

        public static void h(@yt.k r rVar, @yt.l BluetoothDevice bluetoothDevice, @yt.k GamepadInfo gamepadInfo) {
            f0.p(gamepadInfo, "gamepadInfo");
            l9.a.e(rVar.getClass().getSimpleName() + " 已连接设备：" + gamepadInfo);
        }

        public static void i(@yt.k r rVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.d(rVar, device);
        }

        public static void j(@yt.k r rVar, @yt.k BluetoothGatt gatt) {
            f0.p(gatt, "gatt");
            w.a.e(rVar, gatt);
        }

        public static void k(@yt.k r rVar, boolean z10, @yt.k Pair<Float, Float> joystick) {
            f0.p(joystick, "joystick");
            if (l9.a.f39473a.b()) {
                l9.a.e("左摇杆: isMoving=" + z10 + " x=" + joystick.f() + " y=" + joystick.h());
            }
        }

        public static void l(@yt.k r rVar, boolean z10, @yt.k Pair<Float, Float> joystick) {
            f0.p(joystick, "joystick");
            if (l9.a.f39473a.b()) {
                l9.a.e("右摇杆: isMoving=" + z10 + " x=" + joystick.f() + " y=" + joystick.h());
            }
        }

        public static void m(@yt.k r rVar, boolean z10, @yt.k Pair<Float, Float> joystick) {
            f0.p(joystick, "joystick");
            if (l9.a.f39473a.b()) {
                l9.a.e("轮盘: isMoving=" + z10 + " x=" + joystick.f() + " y=" + joystick.h());
            }
        }

        public static void n(@yt.k r rVar, @yt.k List<Integer> keyList) {
            f0.p(keyList, "keyList");
            if (l9.a.f39473a.b()) {
                Iterator<T> it2 = keyList.iterator();
                while (it2.hasNext()) {
                    l9.a.e("识别到按键：" + ((Number) it2.next()).intValue());
                }
            }
        }

        public static void o(@yt.k r rVar, int i10, int i11) {
            if (l9.a.f39473a.b()) {
                l9.a.e("LT按键线性值：" + i10);
                l9.a.e("RT按键线性值：" + i11);
            }
        }

        public static void p(@yt.k r rVar, @yt.l Pair<Integer, Integer> pair) {
            if (!l9.a.f39473a.b() || pair == null) {
                return;
            }
            l9.a.e("体感数据: x=" + pair.f() + " y=" + pair.h());
        }

        public static void q(@yt.k r rVar) {
        }

        public static void r(@yt.k r rVar, int i10) {
            w.a.f(rVar, i10);
        }

        public static void s(@yt.k r rVar, @yt.k byte[] value) {
            f0.p(value, "value");
        }

        public static void t(@yt.k r rVar, @yt.k byte[] bluetoothData, @yt.k byte[] socketData) {
            f0.p(bluetoothData, "bluetoothData");
            f0.p(socketData, "socketData");
        }
    }

    void B0(boolean z10, @yt.k Pair<Float, Float> pair);

    void B1(@yt.k byte[] bArr, @yt.k byte[] bArr2);

    void H(@yt.k byte[] bArr);

    void I2(@yt.k GamepadInfo gamepadInfo);

    void M0(boolean z10, @yt.k Pair<Float, Float> pair);

    void R2(@yt.l Pair<Integer, Integer> pair);

    void U();

    void Z1(boolean z10, @yt.k Pair<Float, Float> pair);

    void a2(@yt.k byte[] bArr);

    void k0();

    void m2(int i10);

    void n0(@yt.k List<Integer> list);

    void u0(@yt.l BluetoothDevice bluetoothDevice, @yt.k GamepadInfo gamepadInfo);

    void z0(int i10, int i11);
}
