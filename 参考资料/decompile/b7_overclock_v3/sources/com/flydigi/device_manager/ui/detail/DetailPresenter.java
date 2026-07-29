package com.flydigi.device_manager.ui.detail;

import android.os.Environment;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.device_manager.ui.detail.c;
import java.io.File;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public final class DetailPresenter implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final c.b f14580a;

    public DetailPresenter(@yt.k c.b view) {
        kotlin.jvm.internal.f0.p(view, "view");
        this.f14580a = view;
    }

    public static final void f0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void g0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @yt.k
    public final c.b h0() {
        return this.f14580a;
    }

    @Override // com.flydigi.device_manager.ui.detail.c.a
    public void x(@yt.k String deviceCode) {
        kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
        if (androidx.core.util.j.a(deviceCode, m9.h.f40766i)) {
            deviceCode = m9.h.f40765h;
        }
        final File file = new File(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), o5.p.b() + '_' + deviceCode + "_device_detail.json");
        final long version = 0;
        if (file.exists()) {
            String strQ = com.blankj.utilcode.util.a0.q(file);
            if (!d1.g(strQ)) {
                DeviceDetailBean detailBean = (DeviceDetailBean) m5.f0.i().h().fromJson(strQ, DeviceDetailBean.class);
                version = detailBean.getVersion();
                c.b bVar = this.f14580a;
                kotlin.jvm.internal.f0.o(detailBean, "detailBean");
                bVar.v(detailBean);
            }
        }
        xi.z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).v(deviceCode, version).s0(m5.c0.p()).s0(o5.l.d());
        final ik.l<DeviceDetailBean, z1> lVar = new ik.l<DeviceDetailBean, z1>() { // from class: com.flydigi.device_manager.ui.detail.DetailPresenter$getDetail$disposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.k DeviceDetailBean response) {
                kotlin.jvm.internal.f0.p(response, "response");
                if (version == 0 || response.getVersion() != version) {
                    String json = m5.f0.i().h().toJson(response);
                    com.blankj.utilcode.util.b0.m(file);
                    com.blankj.utilcode.util.a0.T(file, json);
                    this.h0().v(response);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(DeviceDetailBean deviceDetailBean) {
                b(deviceDetailBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.detail.d
            @Override // dj.g
            public final void accept(Object obj) {
                DetailPresenter.f0(lVar, obj);
            }
        };
        final DetailPresenter$getDetail$disposable$2 detailPresenter$getDetail$disposable$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.detail.DetailPresenter$getDetail$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.detail.e
            @Override // dj.g
            public final void accept(Object obj) {
                DetailPresenter.g0(detailPresenter$getDetail$disposable$2, obj);
            }
        });
    }
}
