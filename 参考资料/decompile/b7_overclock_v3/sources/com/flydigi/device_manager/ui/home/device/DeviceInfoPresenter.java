package com.flydigi.device_manager.ui.home.device;

import android.content.Context;
import android.os.Environment;
import com.blankj.utilcode.util.n0;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.ui.home.device.x;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.HashMap;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public final class DeviceInfoPresenter implements x.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final x.b f15147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final b7.m f15148b;

    public DeviceInfoPresenter(@yt.k x.b view) {
        kotlin.jvm.internal.f0.p(view, "view");
        this.f15147a = view;
        this.f15148b = new b7.m();
    }

    public static final File k(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final String l(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final HashMap m(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (HashMap) tmp0.i(obj);
    }

    public static final String n(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final xi.e0 o(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final void p(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void q(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final String s(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    @Override // com.flydigi.device_manager.ui.home.device.x.a
    public void a(@yt.k Context context, @yt.k final String deviceCode, @yt.k final String firmwareVersion) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
        kotlin.jvm.internal.f0.p(firmwareVersion, "firmwareVersion");
        xi.z zVarM3 = xi.z.m3(context);
        final DeviceInfoPresenter$checkFirmwareVersion$disposable$1 deviceInfoPresenter$checkFirmwareVersion$disposable$1 = new ik.l<Context, File>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final File i(@yt.k Context it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return it2.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            }
        };
        xi.z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.device.f0
            @Override // dj.o
            public final Object apply(Object obj) {
                return DeviceInfoPresenter.k(deviceInfoPresenter$checkFirmwareVersion$disposable$1, obj);
            }
        });
        final DeviceInfoPresenter$checkFirmwareVersion$disposable$2 deviceInfoPresenter$checkFirmwareVersion$disposable$2 = new ik.l<File, String>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$2
            /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.String i(@yt.k java.io.File r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.f0.p(r3, r0)
                    boolean r0 = r3.exists()
                    java.lang.String r1 = "firmware_min_supported.json"
                    if (r0 == 0) goto L22
                    java.io.File r0 = new java.io.File
                    r0.<init>(r3, r1)
                    boolean r3 = r0.exists()
                    if (r3 == 0) goto L22
                    java.lang.String r3 = com.blankj.utilcode.util.a0.q(r0)
                    java.lang.String r0 = "readFile2String(file)"
                    kotlin.jvm.internal.f0.o(r3, r0)
                    goto L24
                L22:
                    java.lang.String r3 = ""
                L24:
                    boolean r0 = com.blankj.utilcode.util.n0.m(r3)
                    if (r0 == 0) goto L33
                    java.lang.String r3 = com.blankj.utilcode.util.s0.p(r1)
                    java.lang.String r0 = "readAssets2String(DataCo…H_FIRMWARE_MIN_SUPPORTED)"
                    kotlin.jvm.internal.f0.o(r3, r0)
                L33:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$2.i(java.io.File):java.lang.String");
            }
        };
        xi.z zVarA32 = zVarA3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.device.e0
            @Override // dj.o
            public final Object apply(Object obj) {
                return DeviceInfoPresenter.l(deviceInfoPresenter$checkFirmwareVersion$disposable$2, obj);
            }
        });
        final DeviceInfoPresenter$checkFirmwareVersion$disposable$3 deviceInfoPresenter$checkFirmwareVersion$disposable$3 = new ik.l<String, HashMap<String, String>>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$3

            public static final class a extends TypeToken<HashMap<String, String>> {
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> i(@yt.k String it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return (HashMap) com.blankj.utilcode.util.e0.i(it2, new a().getType());
            }
        };
        xi.z zVarA33 = zVarA32.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.device.d0
            @Override // dj.o
            public final Object apply(Object obj) {
                return DeviceInfoPresenter.m(deviceInfoPresenter$checkFirmwareVersion$disposable$3, obj);
            }
        });
        final ik.l<HashMap<String, String>, String> lVar = new ik.l<HashMap<String, String>, String>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k HashMap<String, String> it2) {
                String str;
                kotlin.jvm.internal.f0.p(it2, "it");
                return (!it2.containsKey(deviceCode) || (str = it2.get(deviceCode)) == null) ? "" : str;
            }
        };
        xi.z zVarA34 = zVarA33.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.device.c0
            @Override // dj.o
            public final Object apply(Object obj) {
                return DeviceInfoPresenter.n(lVar, obj);
            }
        });
        final ik.l<String, xi.e0<? extends String>> lVar2 = new ik.l<String, xi.e0<? extends String>>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends String> i(@yt.k String it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return n0.m(it2) ? this.this$0.r(deviceCode, it2) : xi.z.m3(it2);
            }
        };
        xi.z zVarB4 = zVarA34.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.home.device.a0
            @Override // dj.o
            public final Object apply(Object obj) {
                return DeviceInfoPresenter.o(lVar2, obj);
            }
        }).J5(lj.b.d()).b4(aj.a.c());
        final ik.l<String, z1> lVar3 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String it2) {
                if (n0.m(it2)) {
                    this.this$0.t().D0();
                    return;
                }
                kotlin.jvm.internal.f0.o(it2, "it");
                if (l9.c.b(it2, firmwareVersion)) {
                    this.this$0.t().D0();
                } else {
                    this.this$0.t().C0();
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.home.device.y
            @Override // dj.g
            public final void accept(Object obj) {
                DeviceInfoPresenter.p(lVar3, obj);
            }
        };
        final ik.l<Throwable, z1> lVar4 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$checkFirmwareVersion$disposable$7
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.t().D0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.home.device.z
            @Override // dj.g
            public final void accept(Object obj) {
                DeviceInfoPresenter.q(lVar4, obj);
            }
        });
    }

    public final xi.z<String> r(String str, final String str2) {
        xi.z<FirmwareInfoBean> zVarJ5 = this.f15148b.b(str).J5(lj.b.d());
        final ik.l<FirmwareInfoBean, String> lVar = new ik.l<FirmwareInfoBean, String>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceInfoPresenter$getLatestVersion$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k FirmwareInfoBean info) {
                kotlin.jvm.internal.f0.p(info, "info");
                return info.isPush == 1 ? info.version : str2;
            }
        };
        return zVarJ5.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.device.b0
            @Override // dj.o
            public final Object apply(Object obj) {
                return DeviceInfoPresenter.s(lVar, obj);
            }
        });
    }

    @yt.k
    public final x.b t() {
        return this.f15147a;
    }
}
