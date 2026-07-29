package com.flydigi.cyberfox.ui.upgrade;

import com.blankj.utilcode.util.d1;
import com.flydigi.cyberfox.ui.upgrade.a;
import com.flydigi.data.bean.FirmwareInfoBean;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFirmwarePresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwarePresenter.kt\ncom/flydigi/cyberfox/ui/upgrade/FirmwarePresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class FirmwarePresenter implements a.InterfaceC0153a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a.b f14268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final g6.d f14269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f14270c;

    public FirmwarePresenter(@yt.k a.b view) {
        f0.p(view, "view");
        this.f14268a = view;
        this.f14269b = new g6.d();
        this.f14270c = new io.reactivex.disposables.a();
    }

    public static final void d(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void e(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.cyberfox.ui.upgrade.a.InterfaceC0153a
    public void b(@yt.k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        z<R> zVarS0 = this.f14269b.b(deviceCode).s0(o5.l.d());
        final ik.l<FirmwareInfoBean, z1> lVar = new ik.l<FirmwareInfoBean, z1>() { // from class: com.flydigi.cyberfox.ui.upgrade.FirmwarePresenter$checkLatestFirmware$1
            {
                super(1);
            }

            public final void b(FirmwareInfoBean firmwareInfoBean) {
                if (d1.g(firmwareInfoBean.url)) {
                    this.this$0.f().i(null);
                } else {
                    this.this$0.f().i(firmwareInfoBean);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(FirmwareInfoBean firmwareInfoBean) {
                b(firmwareInfoBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.cyberfox.ui.upgrade.h
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.d(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.cyberfox.ui.upgrade.FirmwarePresenter$checkLatestFirmware$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f().i(null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14270c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.cyberfox.ui.upgrade.g
            @Override // dj.g
            public final void accept(Object obj) {
                FirmwarePresenter.e(lVar2, obj);
            }
        }));
    }

    @yt.k
    public final a.b f() {
        return this.f14268a;
    }
}
