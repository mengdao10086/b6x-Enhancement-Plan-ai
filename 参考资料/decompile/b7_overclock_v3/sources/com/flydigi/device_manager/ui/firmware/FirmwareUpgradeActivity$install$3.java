package com.flydigi.device_manager.ui.firmware;

import com.blankj.utilcode.util.b0;
import com.flydigi.base.common.o;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import i9.a;
import java.io.File;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m9.s;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareUpgradeActivity$install$3 implements g0<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirmwareUpgradeActivity f14954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirmwareInfoBean f14955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14956c;

    public FirmwareUpgradeActivity$install$3(FirmwareUpgradeActivity firmwareUpgradeActivity, FirmwareInfoBean firmwareInfoBean, int i10) {
        this.f14954a = firmwareUpgradeActivity;
        this.f14955b = firmwareInfoBean;
        this.f14956c = i10;
    }

    public static final void f(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void g(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void h(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void i(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // xi.g0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onNext(@yt.k File file) {
        String address;
        String address2;
        f0.p(file, "file");
        this.f14955b.file = file;
        GamepadInfo gamepadInfoO4 = this.f14954a.o4();
        if (!(gamepadInfoO4 != null && gamepadInfoO4.isConnected())) {
            this.f14954a.E0();
            this.f14954a.J4(file, this.f14956c);
            return;
        }
        int i10 = this.f14956c;
        if (i10 == 1 || i10 == 3) {
            this.f14954a.E0();
            this.f14954a.J4(file, this.f14956c);
            return;
        }
        if (i10 == 2) {
            GamepadInfo gamepadInfoO42 = this.f14954a.o4();
            if (gamepadInfoO42 == null || (address2 = gamepadInfoO42.getAddress()) == null) {
                return;
            }
            final FirmwareUpgradeActivity firmwareUpgradeActivity = this.f14954a;
            final FirmwareInfoBean firmwareInfoBean = this.f14955b;
            final int i11 = this.f14956c;
            firmwareUpgradeActivity.R7 = true;
            firmwareUpgradeActivity.x(firmwareUpgradeActivity.getString(R.string.device_mode_switching), false);
            z zVarM3 = z.m3(address2);
            final ik.l<String, z1> lVar = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwareUpgradeActivity$install$3$onNext$1$1
                {
                    super(1);
                }

                public final void b(String str) {
                    Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
                    f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
                    ((IRemoteProvider) objNavigation).l(firmwareUpgradeActivity, DataConstant.REMOTE_ACTION_SWITCH_MODE_DFU);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(String str) {
                    b(str);
                    return z1.f38230a;
                }
            };
            z zVarB4 = zVarM3.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.j
                @Override // dj.g
                public final void accept(Object obj) {
                    FirmwareUpgradeActivity$install$3.f(lVar, obj);
                }
            }).x1(5000L, TimeUnit.MILLISECONDS).J5(lj.b.a()).b4(lj.b.a());
            final ik.l<String, z1> lVar2 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwareUpgradeActivity$install$3$onNext$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(String str) {
                    File file2 = firmwareInfoBean.file;
                    if (file2 != null) {
                        FirmwareUpgradeActivity firmwareUpgradeActivity2 = firmwareUpgradeActivity;
                        int i12 = i11;
                        firmwareUpgradeActivity2.E0();
                        if (b0.g0(file2)) {
                            firmwareUpgradeActivity2.J4(file2, i12);
                        }
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(String str) {
                    b(str);
                    return z1.f38230a;
                }
            };
            zVarB4.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.k
                @Override // dj.g
                public final void accept(Object obj) {
                    FirmwareUpgradeActivity$install$3.g(lVar2, obj);
                }
            });
            return;
        }
        GamepadInfo gamepadInfoO43 = this.f14954a.o4();
        if (!(gamepadInfoO43 != null && gamepadInfoO43.isSupportFlashplay())) {
            this.f14954a.E0();
            this.f14954a.I4();
            return;
        }
        GamepadInfo gamepadInfoO44 = this.f14954a.o4();
        if (gamepadInfoO44 == null || (address = gamepadInfoO44.getAddress()) == null) {
            return;
        }
        final FirmwareUpgradeActivity firmwareUpgradeActivity2 = this.f14954a;
        firmwareUpgradeActivity2.x(firmwareUpgradeActivity2.getString(R.string.device_mode_switching), false);
        z zVarM32 = z.m3(address);
        final ik.l<String, z1> lVar3 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwareUpgradeActivity$install$3$onNext$2$1
            {
                super(1);
            }

            public final void b(String str) {
                Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
                f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
                ((IRemoteProvider) objNavigation).l(firmwareUpgradeActivity2, DataConstant.REMOTE_ACTION_SWITCH_MODE_DFU);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        z zVarX1 = zVarM32.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.l
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareUpgradeActivity$install$3.h(lVar3, obj);
            }
        }).x1(5000L, TimeUnit.MILLISECONDS);
        final FirmwareUpgradeActivity$install$3$onNext$2$2 firmwareUpgradeActivity$install$3$onNext$2$2 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwareUpgradeActivity$install$3$onNext$2$2
            public final void b(String address3) {
                f0.o(address3, "address");
                s.C(address3);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        zVarX1.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.m
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwareUpgradeActivity$install$3.i(firmwareUpgradeActivity$install$3$onNext$2$2, obj);
            }
        }).J5(lj.b.a()).b4(lj.b.a()).D5();
    }

    @Override // xi.g0
    public void onComplete() {
    }

    @Override // xi.g0
    public void onError(@yt.k Throwable throwable1) {
        String string;
        f0.p(throwable1, "throwable1");
        if ((throwable1 instanceof NoRouteToHostException) || (throwable1 instanceof UnknownHostException) || (throwable1 instanceof SocketTimeoutException) || (throwable1 instanceof SSLException)) {
            string = this.f14954a.getString(R.string.net_state_error);
        } else {
            string = throwable1.getMessage();
            if (string == null) {
                string = this.f14954a.getString(R.string.net_state_error);
                f0.o(string, "getString(R.string.net_state_error)");
            }
        }
        f0.o(string, "if (throwable1 is NoRout…                        }");
        o.E(string);
        this.f14954a.E0();
    }

    @Override // xi.g0
    public void onSubscribe(@yt.k io.reactivex.disposables.b d10) {
        f0.p(d10, "d");
        FirmwareUpgradeActivity firmwareUpgradeActivity = this.f14954a;
        firmwareUpgradeActivity.x(firmwareUpgradeActivity.getString(R.string.device_firmware_upgrade_firmware_downloading), false);
    }
}
