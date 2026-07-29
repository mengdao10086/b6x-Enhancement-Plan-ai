package com.flydigi.device_manager.ui.driver_active.permission;

import com.blankj.utilcode.util.j1;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final f f14913a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final List<j> f14914b = CollectionsKt__CollectionsKt.E();

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> a() {
        return f14914b;
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> b() {
        String str = "Step1. " + j1.a().getString(R.string.device_driver_active_permission_enable_developer_option);
        String string = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_about_phone_oppo);
        f0.o(string, "getApp()\n               …t_click_about_phone_oppo)");
        String string2 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_version_info_oppo);
        f0.o(string2, "getApp()\n               …_click_version_info_oppo)");
        String string3 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_build_number_oppo);
        f0.o(string3, "getApp()\n               …_click_build_number_oppo)");
        return CollectionsKt__CollectionsKt.L(new j(str, string, R.drawable.device_driver_active_about_phone_oppo), new j("", string2, R.drawable.device_driver_active_version_info_oppo), new j("", string3, R.drawable.device_driver_active_build_number_oppo));
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> c() {
        String str = "Step2." + j1.a().getString(R.string.device_driver_active_permission_usb_debugable);
        String string = j1.a().getString(R.string.device_driver_active_permission_usb_debugging_content_common);
        f0.o(string, "getApp()\n               …debugging_content_common)");
        return s.k(new j(str, string, R.drawable.device_driver_active_usb_debugging_oppo));
    }
}
