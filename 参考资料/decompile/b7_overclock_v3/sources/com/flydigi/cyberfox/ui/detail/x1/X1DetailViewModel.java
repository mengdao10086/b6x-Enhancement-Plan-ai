package com.flydigi.cyberfox.ui.detail.x1;

import android.bluetooth.BluetoothDevice;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import com.blankj.utilcode.util.n0;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.sdk.headset.HeadsetInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nX1DetailViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 X1DetailViewModel.kt\ncom/flydigi/cyberfox/ui/detail/x1/X1DetailViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n288#2,2:75\n1#3:77\n*S KotlinDebug\n*F\n+ 1 X1DetailViewModel.kt\ncom/flydigi/cyberfox/ui/detail/x1/X1DetailViewModel\n*L\n35#1:75,2\n*E\n"})
public final class X1DetailViewModel extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final j0<HeadsetInfo> f14238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<HeadsetInfo> f14239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final j0<Boolean> f14240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final j0<FirmwareInfoBean> f14241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final g6.d f14242h;

    public X1DetailViewModel() {
        j0<HeadsetInfo> j0Var = new j0<>();
        this.f14238d = j0Var;
        this.f14239e = j0Var;
        this.f14240f = new j0<>(Boolean.FALSE);
        this.f14241g = new j0<>();
        g6.d dVar = new g6.d();
        this.f14242h = dVar;
        z<R> zVarS0 = dVar.b(q9.c.f47168e).s0(o5.l.d());
        final ik.l<FirmwareInfoBean, z1> lVar = new ik.l<FirmwareInfoBean, z1>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailViewModel.1
            {
                super(1);
            }

            public final void b(FirmwareInfoBean firmwareInfoBean) {
                X1DetailViewModel.this.o().o(firmwareInfoBean);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(FirmwareInfoBean firmwareInfoBean) {
                b(firmwareInfoBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.cyberfox.ui.detail.x1.q
            @Override // dj.g
            public final void accept(Object obj) {
                X1DetailViewModel.i(lVar, obj);
            }
        };
        final AnonymousClass2 anonymousClass2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailViewModel.2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.cyberfox.ui.detail.x1.p
            @Override // dj.g
            public final void accept(Object obj) {
                X1DetailViewModel.j(anonymousClass2, obj);
            }
        });
    }

    public static final void i(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static /* synthetic */ void l(X1DetailViewModel x1DetailViewModel, BluetoothDevice bluetoothDevice, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bluetoothDevice = null;
        }
        x1DetailViewModel.k(bluetoothDevice);
    }

    public final void k(@yt.l BluetoothDevice bluetoothDevice) {
        List<BluetoothDevice> listH = q9.f.h();
        if (!listH.isEmpty()) {
            Iterator<T> it2 = listH.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (n0.b(((BluetoothDevice) next).getName(), q9.a.f47159d)) {
                    obj = next;
                    break;
                }
            }
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) obj;
            if (bluetoothDevice2 != null) {
                q9.f.b(bluetoothDevice2);
            }
        } else {
            if (!n0.b(bluetoothDevice != null ? bluetoothDevice.getName() : null, q9.a.f47159d)) {
                this.f14238d.o(new HeadsetInfo("", q9.a.f47159d, false, q9.c.f47168e, null, null, null, -1, -1, -1, -1, -1, 112, null));
            } else if (bluetoothDevice != null) {
                q9.f.b(bluetoothDevice);
            }
        }
    }

    @yt.k
    public final j0<Boolean> m() {
        return this.f14240f;
    }

    @yt.k
    public final LiveData<HeadsetInfo> n() {
        return this.f14239e;
    }

    @yt.k
    public final j0<FirmwareInfoBean> o() {
        return this.f14241g;
    }

    public final void q(boolean z10) {
        HeadsetInfo headsetInfoF = this.f14238d.f();
        if (headsetInfoF != null) {
            headsetInfoF.setConnected(z10);
            this.f14238d.o(headsetInfoF);
        }
        this.f14240f.o(Boolean.valueOf(z10));
    }

    public final void r(@yt.k HeadsetInfo data) {
        f0.p(data, "data");
        this.f14238d.o(data);
        this.f14240f.o(Boolean.valueOf(data.getConnected()));
    }
}
