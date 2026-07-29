package q9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.flydigi.sdk.bluetooth.w;
import com.flydigi.sdk.headset.HeadsetInfo;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends w {

    public static final class a {
        public static /* synthetic */ void a(e eVar, HeadsetInfo headsetInfo, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEqModeGot");
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            eVar.P0(headsetInfo, z10);
        }

        public static void b(@k e eVar, @k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.a(eVar, device);
        }

        public static void c(@k e eVar, @k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.b(eVar, device);
        }

        public static void d(@k e eVar, @k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.c(eVar, device);
        }

        public static void e(@k e eVar, @k BluetoothDevice device) {
            f0.p(device, "device");
            w.a.d(eVar, device);
        }

        public static void f(@k e eVar, @k BluetoothGatt gatt) {
            f0.p(gatt, "gatt");
            w.a.e(eVar, gatt);
        }

        public static /* synthetic */ void g(e eVar, HeadsetInfo headsetInfo, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLatencyGot");
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            eVar.Z0(headsetInfo, z10);
        }

        public static void h(@k e eVar, int i10) {
            w.a.f(eVar, i10);
        }
    }

    void H2(@k HeadsetInfo headsetInfo);

    void N0(@k HeadsetInfo headsetInfo);

    void P0(@k HeadsetInfo headsetInfo, boolean z10);

    void Z0(@k HeadsetInfo headsetInfo, boolean z10);

    void o2(@l String str, @l String str2);

    void p(@k HeadsetInfo headsetInfo);
}
