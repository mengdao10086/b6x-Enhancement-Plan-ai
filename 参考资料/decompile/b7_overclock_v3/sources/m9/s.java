package m9;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.flydigi.sdk.bluetooth.AbstractBluetoothController;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionController;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import rx_activity_result2.RxActivityResult;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nGamepadManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GamepadManager.kt\ncom/flydigi/sdk/gamepad/GamepadManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,337:1\n1#2:338\n*E\n"})
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final s f40882a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static p f40883b;

    public static final class a implements com.flydigi.sdk.bluetooth.u {
        @Override // com.flydigi.sdk.bluetooth.u
        public boolean a(@yt.l String str, int i10) {
            return t.s(str, null, 2, null);
        }
    }

    @hk.m
    public static final void A(@yt.k Object obj) {
        f0.p(obj, "obj");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.n0(obj);
    }

    @hk.m
    public static final void B(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.o0(device);
    }

    @hk.m
    public static final void C(@yt.k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.p0(deviceMac);
    }

    @hk.m
    public static final void D() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.o2();
    }

    @hk.m
    public static final void E(byte b10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.p2(b10);
    }

    @hk.m
    public static final void F(int i10, int i11, int i12) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.q2(i10, i11, i12);
    }

    @hk.m
    public static final void G() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.s2();
    }

    @hk.m
    public static final void H(@yt.k List<byte[]> bytes, @yt.l Boolean bool) {
        f0.p(bytes, "bytes");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        AbstractDataInteractionController.O0(pVar, bytes, bool, null, 4, null);
    }

    @hk.m
    public static final void I(@yt.k byte[] bytes, @yt.l Boolean bool) {
        f0.p(bytes, "bytes");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.N0(bytes, bool);
    }

    public static /* synthetic */ void J(List list, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        H(list, bool);
    }

    public static /* synthetic */ void K(byte[] bArr, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        I(bArr, bool);
    }

    @hk.m
    public static final void L(boolean z10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.u2(z10);
    }

    public static /* synthetic */ void M(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        L(z10);
    }

    @hk.m
    public static final void N() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.w2();
    }

    @hk.m
    public static final void O(int i10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.r2(i10);
    }

    @hk.m
    public static final void P() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.x2();
    }

    @hk.m
    public static final void Q() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.y2();
    }

    @hk.m
    public static final void S(boolean z10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.z2(z10);
    }

    public static /* synthetic */ void T(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        S(z10);
    }

    @hk.m
    public static final void U() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.B2();
    }

    @hk.m
    public static final void V() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.C2();
    }

    @hk.m
    public static final void W() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.D2();
    }

    @hk.m
    public static final void X() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.E2();
    }

    @hk.m
    public static final void Y() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.G2();
    }

    @hk.m
    public static final void Z() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.H2();
    }

    @hk.m
    public static final void a0(int i10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.I2(i10);
    }

    @hk.m
    public static final void b0() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.F2();
    }

    @hk.m
    public static final void c() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.y();
    }

    @hk.m
    @SuppressLint({"CheckResult"})
    public static final void c0(@yt.k Fragment fragment, int i10) {
        f0.p(fragment, "fragment");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.D0(fragment, i10);
    }

    @hk.m
    public static final void d(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.U0(device);
    }

    @hk.m
    @SuppressLint({"CheckResult"})
    public static final void d0(@yt.k androidx.fragment.app.g activity, int i10) {
        f0.p(activity, "activity");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.E0(activity, i10);
    }

    @hk.m
    public static final void e(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.A(device);
    }

    @hk.m
    public static final void e0() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.F0();
    }

    @hk.m
    public static final void f() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.y1();
    }

    @hk.m
    public static final void f0(int i10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.J2(i10);
    }

    @hk.m
    @yt.k
    public static final List<BluetoothDevice> g() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.C();
    }

    @hk.m
    public static final void g0(@yt.k byte[] color, int i10) {
        f0.p(color, "color");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.K2(color, i10);
    }

    @hk.m
    public static final void h0(byte b10, boolean z10) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.L2(b10, z10);
    }

    @hk.m
    @yt.k
    public static final List<BluetoothDevice> i(@yt.l Boolean bool) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.F(bool);
    }

    @hk.m
    public static final void i0(@yt.k Object obj) {
        f0.p(obj, "obj");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.G0(obj);
    }

    public static /* synthetic */ List j(Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        return i(bool);
    }

    @hk.m
    public static final void j0() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.N2();
    }

    @hk.m
    @yt.l
    public static final BluetoothGatt k() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.A1();
    }

    @hk.m
    public static final void l() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.g2();
    }

    @hk.m
    @yt.l
    public static final BluetoothDevice m(@yt.k String deviceMac) {
        f0.p(deviceMac, "deviceMac");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.Q(deviceMac);
    }

    @hk.m
    @yt.l
    public static final BluetoothDevice n(@yt.k String name) {
        f0.p(name, "name");
        p pVar = f40883b;
        Object obj = null;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        Iterator<T> it2 = pVar.C().iterator();
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

    @hk.m
    public static final void o() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.h2();
    }

    @hk.m
    public static final boolean p() {
        p pVar = f40883b;
        p pVar2 = null;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        if (pVar.T()) {
            p pVar3 = f40883b;
            if (pVar3 == null) {
                f0.S("dataInteractionController");
            } else {
                pVar2 = pVar3;
            }
            if (pVar2.S()) {
                return true;
            }
        }
        return false;
    }

    @hk.m
    public static final void q(@yt.k Context context, @yt.l com.flydigi.sdk.bluetooth.u uVar, boolean z10) {
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
        f40883b = new p(mContext, uVar);
    }

    public static /* synthetic */ void r(Context context, com.flydigi.sdk.bluetooth.u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            uVar = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        q(context, uVar, z10);
    }

    @hk.m
    public static final boolean s() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.T();
    }

    @hk.m
    public static final boolean t() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.U();
    }

    @hk.m
    public static final boolean u(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        return pVar.X(device);
    }

    @hk.m
    public static final void v(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        AbstractBluetoothController.i0(pVar, fragment, null, 2, null);
    }

    @hk.m
    public static final void w(@yt.k androidx.fragment.app.g activity) {
        f0.p(activity, "activity");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        AbstractBluetoothController.j0(pVar, activity, null, 2, null);
    }

    @hk.m
    public static final void x(@yt.k androidx.fragment.app.g activity) {
        f0.p(activity, "activity");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.q0(activity);
    }

    @hk.m
    public static final void y() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.G1();
    }

    @hk.m
    public static final void z(@yt.k BluetoothGatt gatt) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        f0.p(gatt, "gatt");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.X1(gatt);
    }

    public final void R(@yt.k List<j9.b> packs) {
        f0.p(packs, "packs");
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.J0(packs);
    }

    public final void a(int i10, @yt.l byte[] bArr) {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.t1(i10, bArr);
    }

    public final void b() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.S0();
    }

    public final void h() {
        p pVar = f40883b;
        if (pVar == null) {
            f0.S("dataInteractionController");
            pVar = null;
        }
        pVar.f2();
    }
}
