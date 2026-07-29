package com.flydigi.device_manager.ui.sync;

import android.os.Build;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.ConfigShareResult;
import com.flydigi.data.bean.ConfigUploadBean;
import com.flydigi.data.bean.LocalGameBean;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class SyncConfigViewModel$uploadConfigForShare$1$3 extends Lambda implements ik.l<ConfigUploadBean, xi.e0<? extends ConfigBean>> {
    public final /* synthetic */ SyncConfigViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncConfigViewModel$uploadConfigForShare$1$3(SyncConfigViewModel syncConfigViewModel) {
        super(1);
        this.this$0 = syncConfigViewModel;
    }

    public static final ConfigBean f(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (ConfigBean) tmp0.i(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ik.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final xi.e0<? extends ConfigBean> i(@yt.k final ConfigUploadBean configUploadBean) {
        kotlin.jvm.internal.f0.p(configUploadBean, "configUploadBean");
        h5.d dVar = (h5.d) m5.f0.i().k().g(h5.d.class);
        LocalGameBean localGameBean = (LocalGameBean) this.this$0.f15413d.f();
        String str = localGameBean != null ? localGameBean.localPackageName : null;
        String strValueOf = String.valueOf(configUploadBean.fid);
        String str2 = configUploadBean.title;
        String str3 = configUploadBean.url;
        String strValueOf2 = String.valueOf(configUploadBean.version);
        LocalGameBean localGameBean2 = (LocalGameBean) this.this$0.f15413d.f();
        xi.z zVarS0 = dVar.y(str, strValueOf, str2, str3, strValueOf2, localGameBean2 != null ? localGameBean2.name : null, configUploadBean.getGamepad(), Build.BRAND).s0(m5.c0.p()).s0(m5.c0.t());
        final SyncConfigViewModel syncConfigViewModel = this.this$0;
        final ik.l<ConfigShareResult, ConfigBean> lVar = new ik.l<ConfigShareResult, ConfigBean>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfigForShare$1$3.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ConfigBean i(@yt.k ConfigShareResult it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                ConfigBean configBean = new ConfigBean();
                ConfigUploadBean configUploadBean2 = configUploadBean;
                SyncConfigViewModel syncConfigViewModel2 = syncConfigViewModel;
                configBean.setId(it2.f14328id);
                configBean.setTitle(configUploadBean2.title);
                configBean.setManufacturer(com.blankj.utilcode.util.x.j());
                configBean.setModel(com.blankj.utilcode.util.x.k());
                LocalGameBean localGameBean3 = (LocalGameBean) syncConfigViewModel2.f15413d.f();
                configBean.setPackageName(localGameBean3 != null ? localGameBean3.localPackageName : null);
                LocalGameBean localGameBean4 = (LocalGameBean) syncConfigViewModel2.f15413d.f();
                configBean.setGameName(localGameBean4 != null ? localGameBean4.name : null);
                configBean.setDeviceName(configUploadBean2.getGamepad());
                configBean.setDeviceType(configUploadBean2.version);
                return configBean;
            }
        };
        return zVarS0.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.j1
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncConfigViewModel$uploadConfigForShare$1$3.f(lVar, obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d());
    }
}
