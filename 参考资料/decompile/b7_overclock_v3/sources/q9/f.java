package q9;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.core.util.j;
import androidx.fragment.app.Fragment;
import com.flydigi.sdk.bluetooth.AbstractBluetoothController;
import com.flydigi.sdk.bluetooth.u;
import hk.m;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import rx_activity_result2.RxActivityResult;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nHeadsetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeadsetManager.kt\ncom/flydigi/sdk/headset/HeadsetManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final f f47178a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static s9.e f47179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static Object f47180c;

    public static final class a implements u {
        @Override // com.flydigi.sdk.bluetooth.u
        public boolean a(@l String str, int i10) {
            return i10 > -65 && q9.a.f47156a.a(str);
        }
    }

    @m
    @SuppressLint({"CheckResult"})
    public static final void F(@k Fragment fragment, int i10) {
        f0.p(fragment, "fragment");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.D0(fragment, i10);
        }
    }

    @m
    @SuppressLint({"CheckResult"})
    public static final void G(@k androidx.fragment.app.g activity, int i10) {
        f0.p(activity, "activity");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.E0(activity, i10);
        }
    }

    @m
    @l
    public static final z1 H() {
        s9.e eVar = f47179b;
        if (eVar == null) {
            return null;
        }
        eVar.F0();
        return z1.f38230a;
    }

    @m
    public static final void I(@k Object obj) {
        f0.p(obj, "obj");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.G0(obj);
        }
    }

    @m
    public static final void a() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.y();
        }
    }

    @m
    public static final void b(@k BluetoothDevice device) {
        f0.p(device, "device");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.U0(device);
        }
    }

    @m
    @l
    public static final z1 c(@k BluetoothDevice device) {
        f0.p(device, "device");
        s9.e eVar = f47179b;
        if (eVar == null) {
            return null;
        }
        eVar.A(device);
        return z1.f38230a;
    }

    @m
    public static final void d() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.l1();
        }
    }

    @m
    @k
    public static final List<BluetoothDevice> g() {
        List<BluetoothDevice> listC;
        s9.e eVar = f47179b;
        return (eVar == null || (listC = eVar.C()) == null) ? CollectionsKt__CollectionsKt.E() : listC;
    }

    @m
    @k
    public static final List<BluetoothDevice> h() {
        List<BluetoothDevice> listF;
        s9.e eVar = f47179b;
        return (eVar == null || (listF = eVar.F(Boolean.TRUE)) == null) ? CollectionsKt__CollectionsKt.E() : listF;
    }

    @m
    @l
    public static final BluetoothDevice i(@k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        s9.e eVar = f47179b;
        if (eVar != null) {
            return eVar.Q(deviceMac);
        }
        return null;
    }

    @m
    @l
    public static final BluetoothDevice j(@k String name) {
        List<BluetoothDevice> listC;
        f0.p(name, "name");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.C();
        }
        s9.e eVar2 = f47179b;
        Object obj = null;
        if (eVar2 == null || (listC = eVar2.C()) == null) {
            return null;
        }
        Iterator<T> it2 = listC.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (j.a(((BluetoothDevice) next).getName(), name)) {
                obj = next;
                break;
            }
        }
        return (BluetoothDevice) obj;
    }

    @m
    public static final boolean k() {
        s9.e eVar = f47179b;
        if (eVar != null && eVar.T()) {
            s9.e eVar2 = f47179b;
            if (eVar2 != null && eVar2.S()) {
                return true;
            }
        }
        return false;
    }

    @m
    public static final void l(@k Context context, @l u uVar, boolean z10) {
        f0.p(context, "context");
        Context mContext = context.getApplicationContext();
        RxActivityResult.c((Application) context);
        l9.a.f39473a.g(z10);
        if (uVar == null) {
            uVar = new a();
        }
        f0.o(mContext, "mContext");
        f47179b = new s9.e(mContext, uVar);
    }

    public static /* synthetic */ void m(Context context, u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            uVar = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        l(context, uVar, z10);
    }

    @m
    @l
    public static final Boolean n() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            return Boolean.valueOf(eVar.T());
        }
        return null;
    }

    @m
    @l
    public static final Boolean o() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            return Boolean.valueOf(eVar.U());
        }
        return null;
    }

    @m
    public static final boolean p(@k BluetoothDevice device) {
        f0.p(device, "device");
        s9.e eVar = f47179b;
        return eVar != null && eVar.X(device);
    }

    @m
    public static final boolean q(@k String address) {
        f0.p(address, "address");
        s9.e eVar = f47179b;
        return eVar != null && eVar.X(i(address));
    }

    @m
    public static final void r(@k Fragment fragment) {
        f0.p(fragment, "fragment");
        s9.e eVar = f47179b;
        if (eVar != null) {
            AbstractBluetoothController.i0(eVar, fragment, null, 2, null);
        }
    }

    @m
    public static final void s(@k androidx.fragment.app.g activity) {
        f0.p(activity, "activity");
        s9.e eVar = f47179b;
        if (eVar != null) {
            AbstractBluetoothController.j0(eVar, activity, null, 2, null);
        }
    }

    @m
    public static final void t(@k androidx.fragment.app.g activity) {
        f0.p(activity, "activity");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.q0(activity);
        }
    }

    @m
    public static final void u(@k Object obj) {
        f0.p(obj, "obj");
        f47180c = obj;
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.n0(obj);
        }
    }

    @m
    @l
    public static final z1 v(@k BluetoothDevice device) {
        f0.p(device, "device");
        s9.e eVar = f47179b;
        if (eVar == null) {
            return null;
        }
        eVar.o0(device);
        return z1.f38230a;
    }

    @m
    @l
    public static final z1 w(@k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        s9.e eVar = f47179b;
        if (eVar == null) {
            return null;
        }
        eVar.p0(deviceMac);
        return z1.f38230a;
    }

    public final void A() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.E1();
        }
    }

    public final void B() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.F1();
        }
    }

    public final void C() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.G1();
        }
    }

    public final void D(int i10) {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.H1(i10);
        }
    }

    public final void E(int i10) {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.I1(i10);
        }
    }

    public final int e(@l BluetoothDevice bluetoothDevice) {
        s9.e eVar = f47179b;
        if (eVar != null) {
            return eVar.v1(bluetoothDevice);
        }
        return -1;
    }

    public final void f(@k String address) {
        f0.p(address, "address");
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.v1(i(address));
        }
    }

    public final void x() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.B1();
        }
    }

    public final void y() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.C1();
        }
    }

    public final void z() {
        s9.e eVar = f47179b;
        if (eVar != null) {
            eVar.D1();
        }
    }
}
