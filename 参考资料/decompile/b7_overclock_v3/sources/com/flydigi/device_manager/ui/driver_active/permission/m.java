package com.flydigi.device_manager.ui.driver_active.permission;

import com.blankj.utilcode.util.j1;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final m f14932a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final List<j> f14933b = CollectionsKt__CollectionsKt.E();

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> a() {
        return f14933b;
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> b() {
        String str = "Step1. " + j1.a().getString(R.string.device_driver_active_permission_enable_developer_option);
        String string = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_about_phone_common);
        f0.o(string, "getApp()\n               …click_about_phone_common)");
        String string2 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_software_info_samsung);
        f0.o(string2, "getApp()\n               …ck_software_info_samsung)");
        String string3 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_build_number_samsung);
        f0.o(string3, "getApp()\n               …ick_build_number_samsung)");
        return CollectionsKt__CollectionsKt.L(new j(str, string, R.drawable.device_driver_active_about_phone_samsung), new j("", string2, R.drawable.device_driver_active_software_info_samsung), new j("", string3, R.drawable.device_driver_active_build_number_samsung));
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> c() {
        String str = "Step2." + j1.a().getString(R.string.device_driver_active_permission_usb_debugable);
        String string = j1.a().getString(R.string.device_driver_active_permission_usb_debugging_content_common);
        f0.o(string, "getApp()\n               …debugging_content_common)");
        return s.k(new j(str, string, R.drawable.device_driver_active_usb_debugging_samsung));
    }
}
