package t9;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.flydigi.sdk.bluetooth.AbstractBluetoothController;
import com.flydigi.sdk.bluetooth.u;
import hk.m;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import rx_activity_result2.RxActivityResult;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nWaspWingManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WaspWingManager.kt\ncom/flydigi/sdk/waspwing/WaspWingManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,346:1\n1#2:347\n*E\n"})
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.flydigi.sdk.waspwing.a f50991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public static Object f50992c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final j f50990a = new j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f50993d = -90;

    public static final class a implements u {
        @Override // com.flydigi.sdk.bluetooth.u
        public boolean a(@yt.l String str, int i10) {
            j jVar = j.f50990a;
            int iK = jVar.k();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deviceName:");
            sb2.append(str);
            sb2.append(",rssiDef:");
            sb2.append(iK);
            sb2.append(",rssi:");
            sb2.append(i10);
            if (i10 > jVar.k()) {
                if (str != null && k.a(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    @m
    public static final void C(@yt.k BluetoothGatt gatt) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        f0.p(gatt, "gatt");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.X1(gatt);
    }

    @m
    public static final void D(@yt.k Object obj) {
        f0.p(obj, "obj");
        f50992c = obj;
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.n0(obj);
    }

    @m
    public static final void E(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.o0(device);
    }

    @m
    public static final void F(@yt.k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.p0(deviceMac);
    }

    public static /* synthetic */ void L(j jVar, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = c.f50954c;
        }
        jVar.K(i10, str);
    }

    public static /* synthetic */ void N(j jVar, boolean z10, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = 0;
        }
        if ((i10 & 4) != 0) {
            num2 = 0;
        }
        jVar.M(z10, num, num2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void P(j jVar, int i10, Integer num, ArrayList arrayList, Integer num2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = 0;
        }
        if ((i11 & 4) != 0) {
            arrayList = null;
        }
        if ((i11 & 8) != 0) {
            num2 = 0;
        }
        jVar.O(i10, num, arrayList, num2);
    }

    public static /* synthetic */ void T(j jVar, Integer num, Integer num2, Integer num3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        if ((i10 & 2) != 0) {
            num2 = 0;
        }
        if ((i10 & 4) != 0) {
            num3 = 0;
        }
        jVar.S(num, num2, num3);
    }

    public static /* synthetic */ void a0(j jVar, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = c.f50954c;
        }
        jVar.Z(i10, str);
    }

    @m
    public static final void b() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.y();
    }

    @m
    @SuppressLint({"CheckResult"})
    public static final void b0(@yt.k Fragment fragment, int i10) {
        f0.p(fragment, "fragment");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.D0(fragment, i10);
    }

    @m
    public static final void c(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.U0(device);
    }

    @m
    @SuppressLint({"CheckResult"})
    public static final void c0(@yt.k androidx.fragment.app.g activity, int i10) {
        f0.p(activity, "activity");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.E0(activity, i10);
    }

    @m
    public static final void d(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.A(device);
    }

    @m
    public static final void d0() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.F0();
    }

    @m
    public static final void e() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.x1();
    }

    @m
    public static final void e0(@yt.k Object obj) {
        f0.p(obj, "obj");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.G0(obj);
    }

    @m
    @yt.k
    public static final List<BluetoothDevice> f() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.C();
    }

    @m
    @yt.k
    public static final List<BluetoothDevice> g() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return AbstractBluetoothController.G(aVar, null, 1, null);
    }

    @m
    @yt.l
    public static final BluetoothGatt h() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.A1();
    }

    @m
    @yt.l
    public static final BluetoothDevice i(@yt.k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.Q(deviceMac);
    }

    @m
    @yt.l
    public static final BluetoothDevice j(@yt.k String name) {
        f0.p(name, "name");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        Object obj = null;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        Iterator<T> it2 = aVar.C().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (androidx.core.util.j.a(((BluetoothDevice) next).getName(), name)) {
                obj = next;
                break;
            }
        }
        return (BluetoothDevice) obj;
    }

    @m
    public static final boolean l() {
        if (o()) {
            com.flydigi.sdk.waspwing.a aVar = f50991b;
            if (aVar == null) {
                f0.S("dataInteractionController");
                aVar = null;
            }
            if (aVar.S()) {
                return true;
            }
        }
        return false;
    }

    @m
    public static final void m(@yt.k Context context, @yt.l u uVar, boolean z10) {
        f0.p(context, "context");
        Context mContext = context.getApplicationContext();
        RxActivityResult.c((Application) context);
        l9.a aVar = l9.a.f39473a;
        aVar.g(z10);
        aVar.h(z10);
        if (uVar == null) {
            uVar = new a();
        }
        f0.o(mContext, "mContext");
        f50991b = new com.flydigi.sdk.waspwing.a(mContext, uVar);
    }

    public static /* synthetic */ void n(Context context, u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            uVar = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        m(context, uVar, z10);
    }

    @m
    public static final boolean o() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.T();
    }

    @m
    public static final boolean p() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.U();
    }

    @m
    public static final boolean q() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.A1() != null;
    }

    @m
    public static final boolean r(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.X(device);
    }

    @m
    public static final boolean s(@yt.l String str) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        return aVar.Y(str);
    }

    public static /* synthetic */ void w(j jVar, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = null;
        }
        if ((i10 & 2) != 0) {
            bool2 = null;
        }
        jVar.v(bool, bool2);
    }

    @m
    public static final void x(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        AbstractBluetoothController.i0(aVar, fragment, null, 2, null);
    }

    @m
    public static final void y(@yt.k androidx.fragment.app.g activity) {
        f0.p(activity, "activity");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        AbstractBluetoothController.j0(aVar, activity, null, 2, null);
    }

    @m
    public static final void z(@yt.k androidx.fragment.app.g activity) {
        f0.p(activity, "activity");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.q0(activity);
    }

    public final void A() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.n2();
    }

    public final void B() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.G1();
    }

    public final void G(int i10) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.o2(i10);
    }

    public final void H() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.p2();
    }

    public final void I() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.q2();
    }

    public final void J() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.r2();
    }

    public final void K(int i10, @yt.l String str) {
        if (f0.g(str, c.f50954c)) {
            l9.a aVar = l9.a.f39473a;
            if (!aVar.a() && i10 < 120) {
                i10 = 120;
            } else if (!aVar.a() && i10 > 255) {
                i10 = 255;
            }
        }
        com.flydigi.sdk.waspwing.a aVar2 = f50991b;
        if (aVar2 == null) {
            f0.S("dataInteractionController");
            aVar2 = null;
        }
        aVar2.t2(i10);
    }

    public final void M(boolean z10, @yt.l Integer num, @yt.l Integer num2) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.v2(z10, num, num2);
    }

    public final void O(int i10, @yt.l Integer num, @yt.l ArrayList<Integer> arrayList, @yt.l Integer num2) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.x2(i10, num, arrayList, num2);
    }

    public final void Q() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.z2();
    }

    public final void R() {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.A2();
    }

    public final void S(@yt.l Integer num, @yt.l Integer num2, @yt.l Integer num3) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.B2(num, num2, num3);
    }

    public final void U(int i10) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.D2(i10);
    }

    public final void V(int i10) {
        f50993d = i10;
    }

    public final void W(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.E2(i10, i11, i12, i13, i14, i15, i16);
    }

    public final void Y(@yt.k int[] intArrayOf) {
        f0.p(intArrayOf, "intArrayOf");
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.G2(intArrayOf);
    }

    public final void Z(int i10, @yt.l String str) {
        if (f0.g(str, c.f50954c)) {
            l9.a aVar = l9.a.f39473a;
            if (!aVar.a() && i10 < 120) {
                i10 = 120;
            } else if (!aVar.a() && i10 > 255) {
                i10 = 255;
            }
        }
        com.flydigi.sdk.waspwing.a aVar2 = f50991b;
        if (aVar2 == null) {
            f0.S("dataInteractionController");
            aVar2 = null;
        }
        aVar2.H2(i10);
    }

    public final void a(@yt.l byte[] bArr) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.t1(1, bArr);
    }

    public final void f0(int i10, @yt.l Integer num, @yt.l Integer num2, @yt.l Integer num3, @yt.l Integer num4, @yt.l Integer num5) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.I2(i10, num, num2, num3, num4, num5);
    }

    public final void h0(int i10) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.K2(i10);
    }

    public final int k() {
        return f50993d;
    }

    public final void t(boolean z10) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.i2(z10);
    }

    public final void u(boolean z10) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.j2(z10);
    }

    public final void v(@yt.l Boolean bool, @yt.l Boolean bool2) {
        com.flydigi.sdk.waspwing.a aVar = f50991b;
        if (aVar == null) {
            f0.S("dataInteractionController");
            aVar = null;
        }
        aVar.k2(bool, bool2);
    }
}
