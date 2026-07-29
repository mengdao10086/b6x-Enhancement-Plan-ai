package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24218a = "idfa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24219b;

    public c(Context context) {
        super(f24218a);
        this.f24219b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f24219b);
    }
}
