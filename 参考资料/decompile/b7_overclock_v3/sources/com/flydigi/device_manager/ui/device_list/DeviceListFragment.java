package com.flydigi.device_manager.ui.device_list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c7.k0;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.bean.DeviceListBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.device_list.DeviceListFragment;
import com.flydigi.device_manager.ui.device_list.f;
import eu.davidea.flexibleadapter.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDeviceListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceListFragment.kt\ncom/flydigi/device_manager/ui/device_list/DeviceListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,235:1\n1855#2:236\n1855#2:237\n1855#2,2:238\n1856#2:240\n1855#2:241\n1855#2,2:242\n1856#2:244\n1856#2:245\n*S KotlinDebug\n*F\n+ 1 DeviceListFragment.kt\ncom/flydigi/device_manager/ui/device_list/DeviceListFragment\n*L\n179#1:236\n185#1:237\n187#1:238,2\n185#1:240\n193#1:241\n196#1:242,2\n193#1:244\n179#1:245\n*E\n"})
public final class DeviceListFragment extends FZFragment implements f.b {

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public static final b f14823u8 = new b(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public a f14824o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<com.flydigi.device_manager.ui.device_list.a> f14825p8 = new eu.davidea.flexibleadapter.b<>(null, null);

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<? super ei.h<?>> f14826q8 = new eu.davidea.flexibleadapter.b<>(null, null);

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public int f14827r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public DeviceListPresenter f14828s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public k0 f14829t8;

    public interface a {
        void u1(int i10, @yt.k String str, @yt.k String str2);
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @yt.k
        public final DeviceListFragment a() {
            DeviceListFragment deviceListFragment = new DeviceListFragment();
            deviceListFragment.c5(androidx.core.os.e.a());
            return deviceListFragment;
        }
    }

    public static final class c implements b.z {
        public c() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.k View view, int i10) {
            f0.p(view, "view");
            int i11 = 0;
            if (i10 == -1) {
                return false;
            }
            boolean z10 = i10 > DeviceListFragment.this.f14827r8;
            DeviceListFragment.this.f14827r8 = i10;
            DeviceListFragment.this.f14825p8.M(i10);
            int itemCount = DeviceListFragment.this.f14826q8.getItemCount();
            if (itemCount >= 0) {
                while (true) {
                    ei.h hVarG2 = DeviceListFragment.this.f14826q8.g2(i11);
                    if (hVarG2 instanceof com.flydigi.device_manager.ui.device_list.b) {
                        com.flydigi.device_manager.ui.device_list.a aVar = (com.flydigi.device_manager.ui.device_list.a) DeviceListFragment.this.f14825p8.g2(i10);
                        k0 k0Var = null;
                        if (n0.b(aVar != null ? aVar.B() : null, ((com.flydigi.device_manager.ui.device_list.b) hVarG2).B())) {
                            int iD2 = DeviceListFragment.this.f14826q8.d2(hVarG2);
                            if (z10) {
                                iD2++;
                            }
                            k0 k0Var2 = DeviceListFragment.this.f14829t8;
                            if (k0Var2 == null) {
                                f0.S("viewBinding");
                            } else {
                                k0Var = k0Var2;
                            }
                            k0Var.f10169c.L1(iD2);
                        }
                    }
                    if (i11 == itemCount) {
                        break;
                    }
                    i11++;
                }
            }
            return true;
        }
    }

    public static final class d implements b.z {
        public d() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.k View view, int i10) {
            f0.p(view, "view");
            ei.h hVarG2 = DeviceListFragment.this.f14826q8.g2(i10);
            if (!(hVarG2 instanceof DeviceItem)) {
                return false;
            }
            a aVar = DeviceListFragment.this.f14824o8;
            if (aVar == null) {
                f0.S("callback");
                aVar = null;
            }
            DeviceItem deviceItem = (DeviceItem) hVarG2;
            int type = deviceItem.z().getType();
            String strL = d1.l(deviceItem.z().getDeviceType());
            f0.o(strL, "null2Length0(iFlexible.data.deviceType)");
            String deviceName = deviceItem.z().getDeviceName();
            f0.o(deviceName, "iFlexible.data.deviceName");
            aVar.u1(type, strL, deviceName);
            return false;
        }
    }

    public static final class e extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14832a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f14834c;

        public e(GridLayoutManager gridLayoutManager) {
            this.f14834c = gridLayoutManager;
        }

        public static final void e(DeviceListFragment this$0, int i10) {
            f0.p(this$0, "this$0");
            this$0.f14827r8 = i10;
            this$0.f14825p8.M(i10);
            this$0.f14825p8.notifyItemChanged(i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(@yt.k RecyclerView recyclerView, int i10) {
            f0.p(recyclerView, "recyclerView");
            super.a(recyclerView, i10);
            if (i10 == 0) {
                this.f14832a = false;
            } else {
                if (i10 != 1) {
                    return;
                }
                this.f14832a = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(@yt.k RecyclerView recyclerView, int i10, int i11) {
            f0.p(recyclerView, "recyclerView");
            super.b(recyclerView, i10, i11);
            if (!this.f14832a) {
                return;
            }
            ei.h hVarG2 = DeviceListFragment.this.f14826q8.g2(this.f14834c.y2());
            if (!(hVarG2 instanceof com.flydigi.device_manager.ui.device_list.b)) {
                return;
            }
            String strB = ((com.flydigi.device_manager.ui.device_list.b) hVarG2).B();
            final int i12 = 0;
            int itemCount = DeviceListFragment.this.f14825p8.getItemCount();
            if (itemCount < 0) {
                return;
            }
            while (true) {
                com.flydigi.device_manager.ui.device_list.a aVar = (com.flydigi.device_manager.ui.device_list.a) DeviceListFragment.this.f14825p8.g2(i12);
                if (aVar != null && n0.b(strB, aVar.B()) && DeviceListFragment.this.f14827r8 != i12) {
                    k0 k0Var = DeviceListFragment.this.f14829t8;
                    if (k0Var == null) {
                        f0.S("viewBinding");
                        k0Var = null;
                    }
                    RecyclerView recyclerView2 = k0Var.f10168b;
                    final DeviceListFragment deviceListFragment = DeviceListFragment.this;
                    recyclerView2.post(new Runnable() { // from class: com.flydigi.device_manager.ui.device_list.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeviceListFragment.e.e(deviceListFragment, i12);
                        }
                    });
                    return;
                }
                if (i12 == itemCount) {
                    return;
                } else {
                    i12++;
                }
            }
        }

        public final boolean d() {
            return this.f14832a;
        }

        public final void f(boolean z10) {
            this.f14832a = z10;
        }
    }

    public static final class f extends GridLayoutManager.c {
        public f() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            ei.h hVarG2 = DeviceListFragment.this.f14826q8.g2(i10);
            return ((hVarG2 instanceof com.flydigi.device_manager.ui.device_list.b) || (hVarG2 instanceof k)) ? 3 : 1;
        }
    }

    public static final void i6(DeviceListFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.f14825p8.M(0);
        this$0.f14825p8.notifyItemChanged(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof a) {
            this.f14824o8 = (a) context;
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_device_list;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        k0 k0VarD = k0.d(inflater, viewGroup, false);
        f0.o(k0VarD, "inflate(inflater, container, false)");
        this.f14829t8 = k0VarD;
        if (k0VarD == null) {
            f0.S("viewBinding");
            k0VarD = null;
        }
        LinearLayout root = k0VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    public final void g6() {
        this.f14825p8.J(1);
        this.f14825p8.P0(new c());
        k0 k0Var = this.f14829t8;
        if (k0Var == null) {
            f0.S("viewBinding");
            k0Var = null;
        }
        k0Var.f10168b.setAdapter(this.f14825p8);
    }

    public final void h6() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(X1(), 3);
        gridLayoutManager.R3(new f());
        k0 k0Var = this.f14829t8;
        k0 k0Var2 = null;
        if (k0Var == null) {
            f0.S("viewBinding");
            k0Var = null;
        }
        k0Var.f10169c.setLayoutManager(gridLayoutManager);
        this.f14826q8.P0(new d());
        k0 k0Var3 = this.f14829t8;
        if (k0Var3 == null) {
            f0.S("viewBinding");
            k0Var3 = null;
        }
        k0Var3.f10169c.setAdapter(this.f14826q8);
        k0 k0Var4 = this.f14829t8;
        if (k0Var4 == null) {
            f0.S("viewBinding");
        } else {
            k0Var2 = k0Var4;
        }
        k0Var2.f10169c.r(new e(gridLayoutManager));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        g6();
        h6();
        DeviceListPresenter deviceListPresenter = new DeviceListPresenter(this);
        this.f14828s8 = deviceListPresenter;
        deviceListPresenter.R();
    }

    @Override // com.flydigi.device_manager.ui.device_list.f.b
    public void r1(@yt.k List<? extends DeviceListBean.CategoryBean> categories) {
        f0.p(categories, "categories");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (DeviceListBean.CategoryBean categoryBean : categories) {
            if (categoryBean.getSections() != null && categoryBean.getSections().size() > 0) {
                String category = categoryBean.getCategory();
                f0.o(category, "it.category");
                arrayList.add(new com.flydigi.device_manager.ui.device_list.a(category));
                String category2 = categoryBean.getCategory();
                f0.o(category2, "it.category");
                arrayList2.add(new com.flydigi.device_manager.ui.device_list.b(category2));
                if (categoryBean.getSections().size() == 1) {
                    List<DeviceListBean.CategoryBean.SectionBean> sections = categoryBean.getSections();
                    f0.o(sections, "it.sections");
                    for (DeviceListBean.CategoryBean.SectionBean sectionBean : sections) {
                        if (sectionBean.getDevices() != null) {
                            List<DeviceListBean.CategoryBean.SectionBean.DeviceBean> devices = sectionBean.getDevices();
                            f0.o(devices, "section.devices");
                            Iterator<T> it2 = devices.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(new DeviceItem((DeviceListBean.CategoryBean.SectionBean.DeviceBean) it2.next()));
                            }
                        }
                    }
                } else {
                    List<DeviceListBean.CategoryBean.SectionBean> sections2 = categoryBean.getSections();
                    f0.o(sections2, "it.sections");
                    for (DeviceListBean.CategoryBean.SectionBean sectionBean2 : sections2) {
                        if (sectionBean2.getDevices() != null) {
                            String category3 = sectionBean2.getCategory();
                            f0.o(category3, "section.category");
                            arrayList2.add(new k(category3));
                            List<DeviceListBean.CategoryBean.SectionBean.DeviceBean> devices2 = sectionBean2.getDevices();
                            f0.o(devices2, "section.devices");
                            for (DeviceListBean.CategoryBean.SectionBean.DeviceBean deviceBean : devices2) {
                                String deviceType = deviceBean.getDeviceType();
                                if (!(deviceType == null || deviceType.length() == 0)) {
                                    arrayList2.add(new DeviceItem(deviceBean));
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f14825p8.I4(arrayList);
        this.f14826q8.I4(arrayList2);
        k0 k0Var = this.f14829t8;
        if (k0Var == null) {
            f0.S("viewBinding");
            k0Var = null;
        }
        k0Var.f10168b.post(new Runnable() { // from class: com.flydigi.device_manager.ui.device_list.g
            @Override // java.lang.Runnable
            public final void run() {
                DeviceListFragment.i6(this.f14846a);
            }
        });
    }
}
