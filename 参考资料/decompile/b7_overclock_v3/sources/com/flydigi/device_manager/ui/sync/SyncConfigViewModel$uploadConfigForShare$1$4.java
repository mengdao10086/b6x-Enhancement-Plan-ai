package com.flydigi.device_manager.ui.sync;

import com.flydigi.data.bean.ConfigBean;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public /* synthetic */ class SyncConfigViewModel$uploadConfigForShare$1$4 extends FunctionReferenceImpl implements ik.l<ConfigBean, z1> {
    public SyncConfigViewModel$uploadConfigForShare$1$4(Object obj) {
        super(1, obj, androidx.lifecycle.j0.class, "postValue", "postValue(Ljava/lang/Object;)V", 0);
    }

    public final void X0(@yt.l ConfigBean configBean) {
        ((androidx.lifecycle.j0) this.receiver).o(configBean);
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(ConfigBean configBean) {
        X0(configBean);
        return z1.f38230a;
    }
}
