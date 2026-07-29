package com.flydigi.device_manager.ui.detail.waspwing.b7;

import androidx.lifecycle.k0;
import com.blankj.utilcode.util.d1;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class n {

    public static final class a implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f14735a;

        public a(ik.l function) {
            f0.p(function, "function");
            this.f14735a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f14735a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f14735a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof kotlin.jvm.internal.a0)) {
                return f0.g(a(), ((kotlin.jvm.internal.a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    @yt.k
    public static final String a(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "<this>");
        if (!waspWingInfo.getLightState()) {
            String strD = d1.d(R.string.device_waspwing_led_type_close);
            f0.o(strD, "getString(R.string.device_waspwing_led_type_close)");
            return strD;
        }
        int ledType = waspWingInfo.getLedType();
        if (ledType == 3) {
            String strD2 = d1.d(R.string.device_waspwing_led_type_circle);
            f0.o(strD2, "getString(R.string.devic…waspwing_led_type_circle)");
            return strD2;
        }
        if (ledType == 4) {
            String strD3 = d1.d(R.string.device_waspwing_led_type_change);
            f0.o(strD3, "getString(R.string.devic…waspwing_led_type_change)");
            return strD3;
        }
        if (ledType == 5) {
            String strD4 = d1.d(R.string.device_waspwing_led_type_breath);
            f0.o(strD4, "getString(R.string.devic…waspwing_led_type_breath)");
            return strD4;
        }
        if (ledType == 6) {
            String strD5 = d1.d(R.string.device_waspwing_led_type_gradient);
            f0.o(strD5, "getString(R.string.devic…spwing_led_type_gradient)");
            return strD5;
        }
        if (ledType == 11) {
            String strD6 = d1.d(R.string.device_waspwing_led_type_always);
            f0.o(strD6, "getString(R.string.devic…waspwing_led_type_always)");
            return strD6;
        }
        if (ledType != 12) {
            return "";
        }
        String strD7 = d1.d(R.string.device_waspwing_led_type_circle_smart);
        f0.o(strD7, "getString(R.string.devic…ng_led_type_circle_smart)");
        return strD7;
    }
}
