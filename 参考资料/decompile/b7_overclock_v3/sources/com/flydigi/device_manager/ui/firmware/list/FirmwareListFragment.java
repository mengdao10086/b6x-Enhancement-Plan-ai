package com.flydigi.device_manager.ui.firmware.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.e;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.firmware.a;
import com.yqritc.recyclerviewflexibledivider.a;
import ei.h;
import hk.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.t;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwareListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareListFragment.kt\ncom/flydigi/device_manager/ui/firmware/list/FirmwareListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1549#2:125\n1620#2,3:126\n1#3:129\n*S KotlinDebug\n*F\n+ 1 FirmwareListFragment.kt\ncom/flydigi/device_manager/ui/firmware/list/FirmwareListFragment\n*L\n77#1:125\n77#1:126,3\n*E\n"})
public final class FirmwareListFragment extends FZRecyclerViewFragment implements a.b {

    @k
    public static final a A8 = new a(null);

    @k
    public static final String B8 = "key_device_code";

    @k
    public static final String C8 = "key_device_address";

    @k
    public static final String D8 = "key_chip_type";

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @l
    public String f15021w8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public a.InterfaceC0156a f15023y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public b f15024z8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @l
    public String f15020v8 = "all";

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public int f15022x8 = -1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final FirmwareListFragment a(@k String deviceCode, @l String str, int i10) {
            f0.p(deviceCode, "deviceCode");
            FirmwareListFragment firmwareListFragment = new FirmwareListFragment();
            firmwareListFragment.c5(e.b(new Pair("key_device_code", deviceCode), new Pair("key_device_address", str), new Pair("key_chip_type", Integer.valueOf(i10))));
            return firmwareListFragment;
        }
    }

    public interface b {
        void l(@k FirmwareInfoBean firmwareInfoBean, @l String str, int i10);
    }

    @m
    @k
    public static final FirmwareListFragment j6(@k String str, @l String str2, int i10) {
        return A8.a(str, str2, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f15024z8 = (b) context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K3(@yt.l android.os.Bundle r4) {
        /*
            r3 = this;
            super.K3(r4)
            android.os.Bundle r4 = r3.T1()
            java.lang.String r0 = "all"
            if (r4 == 0) goto L13
            java.lang.String r1 = "key_device_code"
            java.lang.String r4 = r4.getString(r1)
            if (r4 != 0) goto L14
        L13:
            r4 = r0
        L14:
            r3.f15020v8 = r4
            android.os.Bundle r4 = r3.T1()
            if (r4 == 0) goto L23
            java.lang.String r1 = "key_device_address"
            java.lang.String r4 = r4.getString(r1)
            goto L24
        L23:
            r4 = 0
        L24:
            r3.f15021w8 = r4
            android.os.Bundle r4 = r3.T1()
            if (r4 == 0) goto L33
            java.lang.String r1 = "key_chip_type"
            int r4 = r4.getInt(r1)
            goto L34
        L33:
            r4 = -1
        L34:
            r3.f15022x8 = r4
            java.lang.String r4 = r3.f15020v8
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L48
            int r4 = r4.length()
            if (r4 != 0) goto L44
            r4 = 1
            goto L45
        L44:
            r4 = 0
        L45:
            if (r4 != r1) goto L48
            goto L49
        L48:
            r1 = 0
        L49:
            if (r1 != 0) goto L53
            java.lang.String r4 = r3.f15020v8
            boolean r4 = com.blankj.utilcode.util.n0.b(r4, r0)
            if (r4 == 0) goto L5c
        L53:
            androidx.fragment.app.g r4 = r3.w1()
            if (r4 == 0) goto L5c
            r4.finishAffinity()
        L5c:
            com.flydigi.device_manager.ui.firmware.FirmwarePresenter r4 = new com.flydigi.device_manager.ui.firmware.FirmwarePresenter
            r4.<init>(r3)
            r3.f15023y8 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.firmware.list.FirmwareListFragment.K3(android.os.Bundle):void");
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@k View view, int i10) {
        f0.p(view, "view");
        h hVarG2 = this.f13331r8.g2(i10);
        if (!(hVarG2 instanceof FirmwareItem) || view.getId() != R.id.tv_install) {
            return false;
        }
        b bVar = this.f15024z8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        FirmwareInfoBean firmwareInfoBeanZ = ((FirmwareItem) hVarG2).z();
        f0.o(firmwareInfoBeanZ, "item.data");
        bVar.l(firmwareInfoBeanZ, this.f15021w8, this.f15022x8);
        return true;
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void T0() {
        this.f13329p8.m(false);
        W5(c3(R.string.net_state_error), -1);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void W0() {
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void Y0(@k List<? extends FirmwareInfoBean> data) {
        f0.p(data, "data");
        ArrayList arrayList = new ArrayList(t.Y(data, 10));
        Iterator<T> it2 = data.iterator();
        while (it2.hasNext()) {
            arrayList.add(new FirmwareItem((FirmwareInfoBean) it2.next()));
        }
        this.f13331r8.I4(arrayList);
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return Integer.MAX_VALUE;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    @l
    public RecyclerView.n g6() {
        return new a.C0280a(X1()).l(R.color.color_000000_a04).y();
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void i(@k FirmwareInfoBean data) {
        f0.p(data, "data");
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        view.setBackgroundResource(R.color.white);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void o0() {
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        String str = this.f15020v8;
        if (str != null) {
            a.InterfaceC0156a interfaceC0156a = this.f15023y8;
            if (interfaceC0156a == null) {
                f0.S("mPresenter");
                interfaceC0156a = null;
            }
            interfaceC0156a.a(str);
        }
    }
}
