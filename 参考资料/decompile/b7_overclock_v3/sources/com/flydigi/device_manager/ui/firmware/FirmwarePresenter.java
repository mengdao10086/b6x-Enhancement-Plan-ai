package com.flydigi.device_manager.ui.firmware;

import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.ui.firmware.a;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwarePresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwarePresenter.kt\ncom/flydigi/device_manager/ui/firmware/FirmwarePresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
public final class FirmwarePresenter implements a.InterfaceC0156a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a.b f14950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final b7.m f14951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f14952c;

    public FirmwarePresenter(@yt.k a.b view) {
        f0.p(view, "view");
        this.f14950a = view;
        this.f14951b = new b7.m();
        this.f14952c = new io.reactivex.disposables.a();
    }

    public static final void h(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void i(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void k(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.InterfaceC0156a
    public void a(@yt.k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        z<R> zVarS0 = this.f14951b.a(deviceCode).s0(o5.l.d());
        final ik.l<List<FirmwareInfoBean>, z1> lVar = new ik.l<List<FirmwareInfoBean>, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwarePresenter$getFirmwareList$1
            {
                super(1);
            }

            public final void b(List<FirmwareInfoBean> it2) {
                a.b bVarM = this.this$0.m();
                f0.o(it2, "it");
                bVarM.Y0(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<FirmwareInfoBean> list) {
                b(list);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.b
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.k(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwarePresenter$getFirmwareList$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.m().T0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14952c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.c
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.l(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.InterfaceC0156a
    public void b(@yt.k String deviceCode, @yt.l final String str) {
        f0.p(deviceCode, "deviceCode");
        z<R> zVarS0 = this.f14951b.b(deviceCode).s0(o5.l.d());
        final ik.l<io.reactivex.disposables.b, z1> lVar = new ik.l<io.reactivex.disposables.b, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwarePresenter$checkLatestFirmware$1
            {
                super(1);
            }

            public final void b(io.reactivex.disposables.b bVar) {
                this.this$0.m().o0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(io.reactivex.disposables.b bVar) {
                b(bVar);
                return z1.f38230a;
            }
        };
        z zVarZ1 = zVarS0.Z1(new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.e
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.h(lVar, obj);
            }
        });
        final ik.l<FirmwareInfoBean, z1> lVar2 = new ik.l<FirmwareInfoBean, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwarePresenter$checkLatestFirmware$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(FirmwareInfoBean it2) {
                String str2 = str;
                if (str2 != null) {
                    FirmwarePresenter firmwarePresenter = this;
                    String str3 = it2.version;
                    f0.o(str3, "it.version");
                    if (l9.c.b(str3, str2)) {
                        firmwarePresenter.m().W0();
                        return;
                    }
                }
                a.b bVarM = this.m();
                f0.o(it2, "it");
                bVarM.i(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(FirmwareInfoBean firmwareInfoBean) {
                b(firmwareInfoBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.f
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.i(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.firmware.FirmwarePresenter$checkLatestFirmware$3
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.m().W0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14952c.b(zVarZ1.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.firmware.d
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.j(lVar3, obj);
            }
        }));
    }

    @yt.k
    public final a.b m() {
        return this.f14950a;
    }
}
