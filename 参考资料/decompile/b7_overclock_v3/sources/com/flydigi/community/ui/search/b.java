package com.flydigi.community.ui.search;

import com.blankj.utilcode.util.n0;
import com.flydigi.community.ui.search.a;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.ArrayList;
import z5.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a.InterfaceC0145a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14046c = "deviceID";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f14047d = "deviceName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.b f14048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f14049b = new f();

    public b(a.b bVar) {
        this.f14048a = bVar;
    }

    @Override // com.flydigi.community.ui.search.a.InterfaceC0145a
    public int H(ArrayList<DeviceCategoryBean> arrayList) {
        return d0(arrayList, v5.a.j().d());
    }

    @Override // com.flydigi.community.ui.search.a.InterfaceC0145a
    public void Z() {
        this.f14049b.x();
    }

    public final int d0(ArrayList<DeviceCategoryBean> arrayList, GamepadInfo gamepadInfo) {
        if (gamepadInfo == null || n0.b(gamepadInfo.getDeviceCode(), "all")) {
            return 0;
        }
        for (DeviceCategoryBean deviceCategoryBean : arrayList) {
            if (deviceCategoryBean.b() == 1) {
                if (gamepadInfo.isGamepadWhole()) {
                    return deviceCategoryBean.b();
                }
            } else if (deviceCategoryBean.b() == 3) {
                if (gamepadInfo.isGamepadHalf()) {
                    return deviceCategoryBean.b();
                }
            } else if (deviceCategoryBean.b() == 2 && gamepadInfo.isGamepadKeyboard()) {
                return deviceCategoryBean.b();
            }
        }
        return 0;
    }
}
