package com.flydigi.device_manager.ui.device_list;

import android.os.Environment;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.s0;
import com.flydigi.data.bean.DeviceListBean;
import com.flydigi.device_manager.ui.device_list.f;
import ik.l;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import o5.p;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public final class DeviceListPresenter implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final f.b f14836a;

    public DeviceListPresenter(@yt.k f.b view) {
        f0.p(view, "view");
        this.f14836a = view;
    }

    public static final void g0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void h0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.device_manager.ui.device_list.f.a
    public void R() {
        final File file = new File(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), p.b() + "_devices.json");
        List<DeviceListBean.CategoryBean> listE = CollectionsKt__CollectionsKt.E();
        boolean z10 = true;
        if (file.exists()) {
            String strQ = a0.q(file);
            if (!d1.g(strQ)) {
                DeviceListBean deviceListBean = (DeviceListBean) m5.f0.i().h().fromJson(strQ, DeviceListBean.class);
                version = Objects.equals(deviceListBean.getAppVersion(), com.blankj.utilcode.util.d.C()) ? deviceListBean.getVersion() : 0L;
                listE = deviceListBean.getCategories();
                f0.o(listE, "deviceListBean.categories");
                z10 = false;
            }
        }
        if (z10) {
            String strP = s0.p("product_list.json");
            if (!d1.g(strP)) {
                DeviceListBean deviceListBean2 = (DeviceListBean) m5.f0.i().h().fromJson(strP, DeviceListBean.class);
                version = deviceListBean2.getVersion();
                listE = deviceListBean2.getCategories();
                f0.o(listE, "deviceListBean.categories");
            }
        }
        this.f14836a.r1(listE);
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).s(version).s0(c0.p()).s0(o5.l.d());
        final l<DeviceListBean, z1> lVar = new l<DeviceListBean, z1>() { // from class: com.flydigi.device_manager.ui.device_list.DeviceListPresenter$getDeviceList$disposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(DeviceListBean deviceListBean3) {
                if (deviceListBean3.getVersion() != version) {
                    String json = m5.f0.i().h().toJson(deviceListBean3);
                    f0.o(deviceListBean3.getCategories(), "it.categories");
                    if (!r1.isEmpty()) {
                        b0.m(file);
                        a0.T(file, json);
                        f.b bVar = this.f14836a;
                        List<DeviceListBean.CategoryBean> categories = deviceListBean3.getCategories();
                        f0.o(categories, "it.categories");
                        bVar.r1(categories);
                    }
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(DeviceListBean deviceListBean3) {
                b(deviceListBean3);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.device_list.j
            @Override // dj.g
            public final void accept(Object obj) {
                DeviceListPresenter.g0(lVar, obj);
            }
        };
        final DeviceListPresenter$getDeviceList$disposable$2 deviceListPresenter$getDeviceList$disposable$2 = new l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.device_list.DeviceListPresenter$getDeviceList$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.device_list.i
            @Override // dj.g
            public final void accept(Object obj) {
                DeviceListPresenter.h0(deviceListPresenter$getDeviceList$disposable$2, obj);
            }
        });
    }
}
