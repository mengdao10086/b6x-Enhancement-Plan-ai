package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: loaded from: classes5.dex */
public class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24243a = "serial";

    public i() {
        super(f24243a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getSerial();
    }
}
