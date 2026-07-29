package com.flydigi.device_manager.ui.home;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.headset.HeadsetInfo;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public final class DeviceHomeViewModel extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final j0<Object> f15126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<Object> f15127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final j0<NoticeBean> f15128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final LiveData<NoticeBean> f15129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final b7.m f15130h;

    public DeviceHomeViewModel() {
        j0<Object> j0Var = new j0<>();
        this.f15126d = j0Var;
        this.f15127e = j0Var;
        j0<NoticeBean> j0Var2 = new j0<>();
        this.f15128f = j0Var2;
        this.f15129g = j0Var2;
        this.f15130h = new b7.m();
        t9.j.D(this);
        q9.f.u(this);
        k();
    }

    public static /* synthetic */ void s(DeviceHomeViewModel deviceHomeViewModel, HeadsetInfo headsetInfo, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        deviceHomeViewModel.q(headsetInfo, bool);
    }

    public static /* synthetic */ void t(DeviceHomeViewModel deviceHomeViewModel, WaspWingInfo waspWingInfo, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        deviceHomeViewModel.r(waspWingInfo, bool);
    }

    public static final void v(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @SuppressLint({"MissingPermission"})
    public final void k() {
        kotlinx.coroutines.j.f(y0.a(this), null, null, new DeviceHomeViewModel$checkDevice$1(this, null), 3, null);
    }

    @yt.k
    public final LiveData<NoticeBean> l() {
        return this.f15129g;
    }

    @yt.k
    public final LiveData<Object> m() {
        return this.f15127e;
    }

    public final void n(@yt.k NoticeBean noticeBean) {
        f0.p(noticeBean, "noticeBean");
        this.f15130h.w(noticeBean.getDeviceCode(), noticeBean);
    }

    public final void o(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        if (androidx.core.util.j.a(deviceInfo.getDeviceCode(), "all")) {
            return;
        }
        if (deviceInfo.isConnected()) {
            this.f15126d.o(deviceInfo.copy((536866815 & 1) != 0 ? deviceInfo.address : null, (536866815 & 2) != 0 ? deviceInfo.deviceName : null, (536866815 & 4) != 0 ? deviceInfo.deviceCode : null, (536866815 & 8) != 0 ? deviceInfo.chipType : 0, (536866815 & 16) != 0 ? deviceInfo.motionChipType : 0, (536866815 & 32) != 0 ? deviceInfo.deviceType : 0, (536866815 & 64) != 0 ? deviceInfo.deviceMode : 0, (536866815 & 128) != 0 ? deviceInfo.connectMode : 0, (536866815 & 256) != 0 ? deviceInfo.connectState : 0, (536866815 & 512) != 0 ? deviceInfo.mappingMode : 0, (536866815 & 1024) != 0 ? deviceInfo.usb0Device : 0, (536866815 & 2048) != 0 ? deviceInfo.usb1Device : 0, (536866815 & 4096) != 0 ? deviceInfo.firmwareVersion : null, (536866815 & 8192) != 0 ? deviceInfo.isSupportFlashplay : false, (536866815 & 16384) != 0 ? deviceInfo.isDriverConnected : false, (536866815 & 32768) != 0 ? deviceInfo.driverVersion : null, (536866815 & 65536) != 0 ? deviceInfo.battery : 0, (536866815 & 131072) != 0 ? deviceInfo.isSupportLinearButton : false, (536866815 & 262144) != 0 ? deviceInfo.isSupportMotion : false, (536866815 & 524288) != 0 ? deviceInfo.isSupportLunpan : false, (536866815 & 1048576) != 0 ? deviceInfo.isSupportLed : false, (536866815 & 2097152) != 0 ? deviceInfo.isSupportMotor : false, (536866815 & 4194304) != 0 ? deviceInfo.supportKeys : null, (536866815 & 8388608) != 0 ? deviceInfo.batteryLevelGap : null, (536866815 & 16777216) != 0 ? deviceInfo.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? deviceInfo.isSupportSwitch : false, (536866815 & 67108864) != 0 ? deviceInfo.switchChipVersion : null, (536866815 & 134217728) != 0 ? deviceInfo.isSupportTrigger : false, (536866815 & 268435456) != 0 ? deviceInfo.uuid : null));
            return;
        }
        if (!t9.j.g().isEmpty()) {
            this.f15126d.o(v5.a.j().k());
        } else if (!q9.f.h().isEmpty()) {
            this.f15126d.o(v5.a.j().i());
        } else if (this.f15126d.f() instanceof GamepadInfo) {
            this.f15126d.o(deviceInfo.copy((536866815 & 1) != 0 ? deviceInfo.address : null, (536866815 & 2) != 0 ? deviceInfo.deviceName : null, (536866815 & 4) != 0 ? deviceInfo.deviceCode : null, (536866815 & 8) != 0 ? deviceInfo.chipType : 0, (536866815 & 16) != 0 ? deviceInfo.motionChipType : 0, (536866815 & 32) != 0 ? deviceInfo.deviceType : 0, (536866815 & 64) != 0 ? deviceInfo.deviceMode : 0, (536866815 & 128) != 0 ? deviceInfo.connectMode : 0, (536866815 & 256) != 0 ? deviceInfo.connectState : 0, (536866815 & 512) != 0 ? deviceInfo.mappingMode : 0, (536866815 & 1024) != 0 ? deviceInfo.usb0Device : 0, (536866815 & 2048) != 0 ? deviceInfo.usb1Device : 0, (536866815 & 4096) != 0 ? deviceInfo.firmwareVersion : null, (536866815 & 8192) != 0 ? deviceInfo.isSupportFlashplay : false, (536866815 & 16384) != 0 ? deviceInfo.isDriverConnected : false, (536866815 & 32768) != 0 ? deviceInfo.driverVersion : null, (536866815 & 65536) != 0 ? deviceInfo.battery : 0, (536866815 & 131072) != 0 ? deviceInfo.isSupportLinearButton : false, (536866815 & 262144) != 0 ? deviceInfo.isSupportMotion : false, (536866815 & 524288) != 0 ? deviceInfo.isSupportLunpan : false, (536866815 & 1048576) != 0 ? deviceInfo.isSupportLed : false, (536866815 & 2097152) != 0 ? deviceInfo.isSupportMotor : false, (536866815 & 4194304) != 0 ? deviceInfo.supportKeys : null, (536866815 & 8388608) != 0 ? deviceInfo.batteryLevelGap : null, (536866815 & 16777216) != 0 ? deviceInfo.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? deviceInfo.isSupportSwitch : false, (536866815 & 67108864) != 0 ? deviceInfo.switchChipVersion : null, (536866815 & 134217728) != 0 ? deviceInfo.isSupportTrigger : false, (536866815 & 268435456) != 0 ? deviceInfo.uuid : null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r18.getConnected() != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(@yt.k com.flydigi.sdk.headset.HeadsetInfo r18, @yt.l java.lang.Boolean r19) {
        /*
            r17 = this;
            r0 = r17
            java.lang.String r1 = "deviceInfo"
            r2 = r18
            kotlin.jvm.internal.f0.p(r2, r1)
            java.lang.String r1 = r18.getDeviceCode()
            java.lang.String r3 = "all"
            boolean r1 = androidx.core.util.j.a(r1, r3)
            if (r1 == 0) goto L16
            return
        L16:
            o5.m r1 = o5.m.i()
            java.lang.String r3 = com.blankj.utilcode.util.e0.v(r18)
            java.lang.String r4 = "sp_device_connect_headset_info"
            r1.B(r4, r3)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r3 = r19
            boolean r1 = kotlin.jvm.internal.f0.g(r3, r1)
            if (r1 != 0) goto L96
            androidx.lifecycle.j0<java.lang.Object> r1 = r0.f15126d
            java.lang.Object r1 = r1.f()
            boolean r1 = r1 instanceof com.flydigi.device_manager.ui.home.o
            if (r1 != 0) goto L96
            androidx.lifecycle.j0<java.lang.Object> r1 = r0.f15126d
            java.lang.Object r1 = r1.f()
            boolean r1 = r1 instanceof com.flydigi.sdk.headset.HeadsetInfo
            if (r1 == 0) goto L47
            boolean r1 = r18.getConnected()
            if (r1 != 0) goto L96
        L47:
            androidx.lifecycle.j0<java.lang.Object> r1 = r0.f15126d
            java.lang.Object r1 = r1.f()
            boolean r1 = r1 instanceof com.flydigi.sdk.waspwing.WaspWingInfo
            if (r1 == 0) goto L6b
            androidx.lifecycle.j0<java.lang.Object> r1 = r0.f15126d
            java.lang.Object r1 = r1.f()
            java.lang.String r3 = "null cannot be cast to non-null type com.flydigi.sdk.waspwing.WaspWingInfo"
            kotlin.jvm.internal.f0.n(r1, r3)
            com.flydigi.sdk.waspwing.WaspWingInfo r1 = (com.flydigi.sdk.waspwing.WaspWingInfo) r1
            boolean r1 = r1.isConnected()
            if (r1 != 0) goto L6b
            boolean r1 = r18.getConnected()
            if (r1 == 0) goto L6b
            goto L96
        L6b:
            boolean r1 = r18.getConnected()
            if (r1 != 0) goto Lb1
            r1 = 0
            r2 = 1
            java.util.List r1 = m9.s.j(r1, r2, r1)
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto Lb1
            java.util.List r1 = t9.j.g()
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r2
            if (r1 == 0) goto Lb1
            androidx.lifecycle.j0<java.lang.Object> r1 = r0.f15126d
            v5.a r2 = v5.a.j()
            com.flydigi.sdk.waspwing.WaspWingInfo r2 = r2.k()
            r1.o(r2)
            goto Lb1
        L96:
            androidx.lifecycle.j0<java.lang.Object> r1 = r0.f15126d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 4095(0xfff, float:5.738E-42)
            r16 = 0
            r2 = r18
            com.flydigi.sdk.headset.HeadsetInfo r2 = com.flydigi.sdk.headset.HeadsetInfo.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1.o(r2)
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.home.DeviceHomeViewModel.q(com.flydigi.sdk.headset.HeadsetInfo, java.lang.Boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (r40.isConnected() != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(@yt.k com.flydigi.sdk.waspwing.WaspWingInfo r40, @yt.l java.lang.Boolean r41) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.home.DeviceHomeViewModel.r(com.flydigi.sdk.waspwing.WaspWingInfo, java.lang.Boolean):void");
    }

    public final void u(@yt.k final String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        z<R> zVarS0 = this.f15130h.e(deviceCode).s0(o5.l.d());
        final ik.l<NoticeBean, z1> lVar = new ik.l<NoticeBean, z1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeViewModel$updateNoticeIfNeed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(NoticeBean noticeBean) {
                noticeBean.setDeviceCode(deviceCode);
                this.f15128f.o(noticeBean);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(NoticeBean noticeBean) {
                b(noticeBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.home.m
            @Override // dj.g
            public final void accept(Object obj) {
                DeviceHomeViewModel.v(lVar, obj);
            }
        };
        final DeviceHomeViewModel$updateNoticeIfNeed$2 deviceHomeViewModel$updateNoticeIfNeed$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeViewModel$updateNoticeIfNeed$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.home.n
            @Override // dj.g
            public final void accept(Object obj) {
                DeviceHomeViewModel.w(deviceHomeViewModel$updateNoticeIfNeed$2, obj);
            }
        });
    }
}
