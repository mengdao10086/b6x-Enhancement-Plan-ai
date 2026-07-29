package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: loaded from: classes5.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24220a = "idmd5";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24221b;

    public d(Context context) {
        super("idmd5");
        this.f24221b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f24221b);
    }
}
