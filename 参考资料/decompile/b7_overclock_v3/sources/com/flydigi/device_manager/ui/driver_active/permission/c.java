package com.flydigi.device_manager.ui.driver_active.permission;

import com.blankj.utilcode.util.j1;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f14908a = new c();

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> a() {
        String str = "Step2." + j1.a().getString(R.string.device_driver_active_permission_usb_debugable_with_charging);
        String string = j1.a().getString(R.string.device_driver_active_permission_usb_debugging_with_charging_content_huawei);
        f0.o(string, "getApp()\n               …_charging_content_huawei)");
        return s.k(new j(str, string, R.drawable.device_driver_active_usb_debugging_with_charging_huawei));
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> b() {
        String str = "Step1. " + j1.a().getString(R.string.device_driver_active_permission_enable_developer_option);
        String string = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_about_phone_common);
        f0.o(string, "getApp()\n               …click_about_phone_common)");
        String string2 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_build_number_common);
        f0.o(string2, "getApp()\n               …lick_build_number_common)");
        return CollectionsKt__CollectionsKt.L(new j(str, string, R.drawable.device_driver_active_about_phone_huawei), new j("", string2, R.drawable.device_driver_active_build_number_huawei));
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> c() {
        String str = "Step3." + j1.a().getString(R.string.device_driver_active_permission_usb_debugable);
        String string = j1.a().getString(R.string.device_driver_active_permission_usb_debugging_content_huawei);
        f0.o(string, "getApp()\n               …debugging_content_huawei)");
        return s.k(new j(str, string, R.drawable.device_driver_active_usb_debugging_huawei));
    }
}
