package com.flydigi.device_manager.ui.driver_active.permission;

import com.blankj.utilcode.util.j1;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final o f14936a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final List<j> f14937b = CollectionsKt__CollectionsKt.E();

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> a() {
        return f14937b;
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> b() {
        String str = "Step1. " + j1.a().getString(R.string.device_driver_active_permission_enable_developer_option);
        String string = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_my_device_miui);
        f0.o(string, "getApp()\n               …ent_click_my_device_miui)");
        String string2 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_about_phone_miui);
        f0.o(string2, "getApp()\n               …t_click_about_phone_miui)");
        String string3 = j1.a().getString(R.string.device_driver_active_permission_enable_developer_option_content_click_build_number_miui);
        f0.o(string3, "getApp()\n               …_click_build_number_miui)");
        return CollectionsKt__CollectionsKt.L(new j(str, string, R.drawable.device_driver_active_my_device_miui), new j("", string2, R.drawable.device_driver_active_about_phone_miui), new j("", string3, R.drawable.device_driver_active_build_number_miui));
    }

    @Override // com.flydigi.device_manager.ui.driver_active.permission.d
    @yt.k
    public List<j> c() {
        String str = "Step2." + j1.a().getString(R.string.device_driver_active_permission_usb_debugable);
        String string = j1.a().getString(R.string.device_driver_active_permission_usb_debugging_content_miui);
        f0.o(string, "getApp()\n               …b_debugging_content_miui)");
        return s.k(new j(str, string, R.drawable.device_driver_active_usb_debugging_miui));
    }
}
