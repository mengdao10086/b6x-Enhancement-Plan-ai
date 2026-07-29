package com.flydigi.device_manager.ui.connection;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Environment;
import com.blankj.utilcode.util.e0;
import com.blankj.utilcode.util.n0;
import com.flydigi.device_manager.ui.connection.a;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public final class ConnectPresenter implements a.InterfaceC0154a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a.b f14520a;

    public ConnectPresenter(@yt.k a.b view) {
        f0.p(view, "view");
        this.f14520a = view;
    }

    public static final File h(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final String i(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final HashMap j(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (HashMap) tmp0.i(obj);
    }

    public static final String k(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final void l(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void m(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.device_manager.ui.connection.a.InterfaceC0154a
    public void a(@yt.k Context context, @yt.k final BluetoothDevice device, @yt.l final GamepadInfo gamepadInfo) {
        f0.p(context, "context");
        f0.p(device, "device");
        z zVarM3 = z.m3(context);
        final ConnectPresenter$checkFirmwareVersion$disposable$1 connectPresenter$checkFirmwareVersion$disposable$1 = new ik.l<Context, File>() { // from class: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final File i(@yt.k Context it2) {
                f0.p(it2, "it");
                return it2.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            }
        };
        z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.connection.f
            @Override // dj.o
            public final Object apply(Object obj) {
                return ConnectPresenter.h(connectPresenter$checkFirmwareVersion$disposable$1, obj);
            }
        });
        final ConnectPresenter$checkFirmwareVersion$disposable$2 connectPresenter$checkFirmwareVersion$disposable$2 = new ik.l<File, String>() { // from class: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$2
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
                throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$2.i(java.io.File):java.lang.String");
            }
        };
        z zVarA32 = zVarA3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.connection.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return ConnectPresenter.i(connectPresenter$checkFirmwareVersion$disposable$2, obj);
            }
        });
        final ConnectPresenter$checkFirmwareVersion$disposable$3 connectPresenter$checkFirmwareVersion$disposable$3 = new ik.l<String, HashMap<String, String>>() { // from class: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$3

            public static final class a extends TypeToken<HashMap<String, String>> {
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> i(@yt.k String it2) {
                f0.p(it2, "it");
                return (HashMap) e0.i(it2, new a().getType());
            }
        };
        z zVarA33 = zVarA32.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.connection.g
            @Override // dj.o
            public final Object apply(Object obj) {
                return ConnectPresenter.j(connectPresenter$checkFirmwareVersion$disposable$3, obj);
            }
        });
        final ik.l<HashMap<String, String>, String> lVar = new ik.l<HashMap<String, String>, String>() { // from class: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k HashMap<String, String> it2) {
                String strI;
                String str;
                f0.p(it2, "it");
                GamepadInfo gamepadInfo2 = gamepadInfo;
                if (gamepadInfo2 == null || (strI = m9.t.m(gamepadInfo2)) == null) {
                    strI = m9.t.i(device.getName());
                }
                return (!it2.containsKey(strI) || (str = it2.get(strI)) == null) ? "" : str;
            }
        };
        z zVarA34 = zVarA33.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.connection.d
            @Override // dj.o
            public final Object apply(Object obj) {
                return ConnectPresenter.k(lVar, obj);
            }
        });
        final ik.l<String, z1> lVar2 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String it2) {
                String firmwareVersion;
                if (n0.m(it2)) {
                    this.this$0.n().X0(device);
                    return;
                }
                f0.o(it2, "it");
                GamepadInfo gamepadInfo2 = gamepadInfo;
                if (gamepadInfo2 == null || (firmwareVersion = gamepadInfo2.getFirmwareVersion()) == null) {
                    firmwareVersion = "";
                }
                if (l9.c.b(it2, firmwareVersion)) {
                    this.this$0.n().X0(device);
                } else {
                    this.this$0.n().J0(device, it2, gamepadInfo);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.connection.b
            @Override // dj.g
            public final void accept(Object obj) {
                ConnectPresenter.l(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.connection.ConnectPresenter$checkFirmwareVersion$disposable$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.n().X0(device);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarA34.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.connection.c
            @Override // dj.g
            public final void accept(Object obj) {
                ConnectPresenter.m(lVar3, obj);
            }
        });
    }

    @yt.k
    public final a.b n() {
        return this.f14520a;
    }
}
