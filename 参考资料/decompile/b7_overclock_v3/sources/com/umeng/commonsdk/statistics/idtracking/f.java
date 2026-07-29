package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: loaded from: classes5.dex */
public class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24234a = "imei";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24235b;

    public f(Context context) {
        super("imei");
        this.f24235b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f24235b);
    }
}
