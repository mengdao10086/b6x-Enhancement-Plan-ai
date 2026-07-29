package t9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.flydigi.sdk.bluetooth.w;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
public interface i extends w {

    public static final class a {
        public static void a(@yt.k i iVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.a(iVar, device);
        }

        public static void b(@yt.k i iVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.b(iVar, device);
        }

        public static void c(@yt.k i iVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.c(iVar, device);
        }

        public static void d(@yt.k i iVar, @yt.k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.d(iVar, device);
        }

        public static void e(@yt.k i iVar, @yt.k BluetoothGatt gatt) {
            f0.p(gatt, "gatt");
            w.a.e(iVar, gatt);
        }

        public static void f(@yt.k i iVar, int i10) {
            w.a.f(iVar, i10);
        }

        public static void g(@yt.k i iVar, @yt.k byte[] tempHistory) {
            f0.p(tempHistory, "tempHistory");
        }
    }

    void F1(@yt.k WaspWingInfo waspWingInfo);

    void q2(@yt.k byte[] bArr);
}
