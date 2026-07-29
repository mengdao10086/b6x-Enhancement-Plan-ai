package com.permissionx.guolindev.request;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import bg.c;
import f.b;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bE\u0010FJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0006J\b\u0010#\u001a\u00020\u0006H\u0016R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R.\u00103\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 0*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010/0/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u00105\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00030\u00030.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00102R\"\u00108\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u000106060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00102R\"\u0010:\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u000106060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00102R\"\u0010<\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u000106060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00102R\"\u0010>\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u000106060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00102R\"\u0010@\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u000106060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00102R\"\u0010B\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00030\u00030.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00102R\"\u0010D\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u000106060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00102¨\u0006G"}, d2 = {"Lcom/permissionx/guolindev/request/InvisibleFragment;", "Landroidx/fragment/app/Fragment;", "", "", "", "grantResults", "Lkotlin/z1;", "f6", "granted", t9.c.f50957f, "h6", "i6", "e6", "d6", "g6", "c6", "Y5", "Lkotlin/Function0;", "callback", "j6", "Lcom/permissionx/guolindev/request/t;", "permissionBuilder", "", "permissions", "Lcom/permissionx/guolindev/request/b;", "chainTask", "w6", "l6", "y6", "A6", "s6", "q6", "v6", "o6", "Z5", "P3", "Landroid/os/Handler;", "c8", "Landroid/os/Handler;", "handler", "d8", "Lcom/permissionx/guolindev/request/t;", "pb", "e8", "Lcom/permissionx/guolindev/request/b;", "task", "Landroidx/activity/result/g;", "", "kotlin.jvm.PlatformType", "f8", "Landroidx/activity/result/g;", "requestNormalPermissionLauncher", "g8", "requestBackgroundLocationLauncher", "Landroid/content/Intent;", "h8", "requestSystemAlertWindowLauncher", "i8", "requestWriteSettingsLauncher", "j8", "requestManageExternalStorageLauncher", "k8", "requestInstallPackagesLauncher", "l8", "requestNotificationLauncher", "m8", "requestBodySensorsBackgroundLauncher", "n8", "forwardToSettingsLauncher", "<init>", "()V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class InvisibleFragment extends Fragment {

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    @yt.k
    public final Handler f22087c8 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public t f22088d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public b f22089e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<String[]> f22090f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<String> f22091g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f22092h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f22093i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f22094j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f22095k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f22096l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<String> f22097m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f22098n8;

    public InvisibleFragment() {
        androidx.activity.result.g<String[]> gVarP1 = P1(new b.k(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.m
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.t6(this.f22115a, (Map) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.f22090f8 = gVarP1;
        androidx.activity.result.g<String> gVarP12 = P1(new b.l(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.l
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.m6(this.f22114a, (Boolean) obj);
            }
        });
        f0.o(gVarP12, "registerForActivityResul…)\n            }\n        }");
        this.f22091g8 = gVarP12;
        androidx.activity.result.g<Intent> gVarP13 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.g
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.x6(this.f22109a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP13, "registerForActivityResul…)\n            }\n        }");
        this.f22092h8 = gVarP13;
        androidx.activity.result.g<Intent> gVarP14 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.f
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.z6(this.f22108a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP14, "registerForActivityResul…)\n            }\n        }");
        this.f22093i8 = gVarP14;
        androidx.activity.result.g<Intent> gVarP15 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.h
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.r6(this.f22110a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP15, "registerForActivityResul…)\n            }\n        }");
        this.f22094j8 = gVarP15;
        androidx.activity.result.g<Intent> gVarP16 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.i
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.p6(this.f22111a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP16, "registerForActivityResul…)\n            }\n        }");
        this.f22095k8 = gVarP16;
        androidx.activity.result.g<Intent> gVarP17 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.j
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.u6(this.f22112a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP17, "registerForActivityResul…)\n            }\n        }");
        this.f22096l8 = gVarP17;
        androidx.activity.result.g<String> gVarP18 = P1(new b.l(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.k
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.n6(this.f22113a, (Boolean) obj);
            }
        });
        f0.o(gVarP18, "registerForActivityResul…)\n            }\n        }");
        this.f22097m8 = gVarP18;
        androidx.activity.result.g<Intent> gVarP19 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.permissionx.guolindev.request.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.a6(this.f22107a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP19, "registerForActivityResul…)\n            }\n        }");
        this.f22098n8 = gVarP19;
    }

    public static final void a6(InvisibleFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        if (this$0.Y5()) {
            b bVar = this$0.f22089e8;
            t tVar = null;
            if (bVar == null) {
                f0.S("task");
                bVar = null;
            }
            t tVar2 = this$0.f22088d8;
            if (tVar2 == null) {
                f0.S("pb");
            } else {
                tVar = tVar2;
            }
            bVar.V(new ArrayList(tVar.f22149p));
        }
    }

    public static final void k6(ik.a callback) {
        f0.p(callback, "$callback");
        callback.o();
    }

    public static final void m6(final InvisibleFragment this$0, final Boolean bool) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestBackgroundLocationLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                InvisibleFragment invisibleFragment = this.this$0;
                Boolean granted = bool;
                f0.o(granted, "granted");
                invisibleFragment.b6(granted.booleanValue());
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void n6(final InvisibleFragment this$0, final Boolean bool) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestBodySensorsBackgroundLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                InvisibleFragment invisibleFragment = this.this$0;
                Boolean granted = bool;
                f0.o(granted, "granted");
                invisibleFragment.c6(granted.booleanValue());
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void p6(final InvisibleFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestInstallPackagesLauncher$1$1
            {
                super(0);
            }

            public final void b() {
                this.this$0.d6();
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void r6(final InvisibleFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestManageExternalStorageLauncher$1$1
            {
                super(0);
            }

            public final void b() {
                this.this$0.e6();
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void t6(final InvisibleFragment this$0, final Map map) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestNormalPermissionLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                InvisibleFragment invisibleFragment = this.this$0;
                Map<String, Boolean> grantResults = map;
                f0.o(grantResults, "grantResults");
                invisibleFragment.f6(grantResults);
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void u6(final InvisibleFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestNotificationLauncher$1$1
            {
                super(0);
            }

            public final void b() {
                this.this$0.g6();
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void x6(final InvisibleFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestSystemAlertWindowLauncher$1$1
            {
                super(0);
            }

            public final void b() {
                this.this$0.h6();
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public static final void z6(final InvisibleFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        this$0.j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestWriteSettingsLauncher$1$1
            {
                super(0);
            }

            public final void b() {
                this.this$0.i6();
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public final void A6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(R4())) {
            i6();
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + P4().getPackageName()));
        this.f22093i8.b(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        if (Y5()) {
            t tVar = this.f22088d8;
            if (tVar == null) {
                f0.S("pb");
                tVar = null;
            }
            Dialog dialog = tVar.f22139f;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        }
    }

    public final boolean Y5() {
        return (this.f22088d8 == null || this.f22089e8 == null) ? false : true;
    }

    public final void Z5() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", P4().getPackageName(), null));
        this.f22098n8.b(intent);
    }

    public final void b6(final boolean z10) {
        if (Y5()) {
            j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestBackgroundLocationPermissionResult$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x00dd  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void b() {
                    /*
                        Method dump skipped, instruction units count: 319
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment$onRequestBackgroundLocationPermissionResult$1.b():void");
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    public final void c6(final boolean z10) {
        if (Y5()) {
            j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x00dd  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void b() {
                    /*
                        Method dump skipped, instruction units count: 319
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1.b():void");
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    public final void d6() {
        if (Y5()) {
            j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestInstallPackagesPermissionResult$1
                {
                    super(0);
                }

                public final void b() {
                    b bVar = null;
                    if (Build.VERSION.SDK_INT < 26) {
                        b bVar2 = this.this$0.f22089e8;
                        if (bVar2 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar2;
                        }
                        bVar.U();
                        return;
                    }
                    if (this.this$0.P4().getPackageManager().canRequestPackageInstalls()) {
                        b bVar3 = this.this$0.f22089e8;
                        if (bVar3 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar3;
                        }
                        bVar.U();
                        return;
                    }
                    t tVar = this.this$0.f22088d8;
                    if (tVar == null) {
                        f0.S("pb");
                        tVar = null;
                    }
                    if (tVar.f22151r == null) {
                        t tVar2 = this.this$0.f22088d8;
                        if (tVar2 == null) {
                            f0.S("pb");
                            tVar2 = null;
                        }
                        if (tVar2.f22152s == null) {
                            return;
                        }
                    }
                    t tVar3 = this.this$0.f22088d8;
                    if (tVar3 == null) {
                        f0.S("pb");
                        tVar3 = null;
                    }
                    if (tVar3.f22152s != null) {
                        t tVar4 = this.this$0.f22088d8;
                        if (tVar4 == null) {
                            f0.S("pb");
                            tVar4 = null;
                        }
                        cg.b bVar4 = tVar4.f22152s;
                        f0.m(bVar4);
                        b bVar5 = this.this$0.f22089e8;
                        if (bVar5 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar5;
                        }
                        bVar4.a(bVar.W(), kotlin.collections.s.k(x.f22161f), false);
                        return;
                    }
                    t tVar5 = this.this$0.f22088d8;
                    if (tVar5 == null) {
                        f0.S("pb");
                        tVar5 = null;
                    }
                    cg.a aVar = tVar5.f22151r;
                    f0.m(aVar);
                    b bVar6 = this.this$0.f22089e8;
                    if (bVar6 == null) {
                        f0.S("task");
                    } else {
                        bVar = bVar6;
                    }
                    aVar.a(bVar.W(), kotlin.collections.s.k(x.f22161f));
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    public final void e6() {
        if (Y5()) {
            j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestManageExternalStoragePermissionResult$1
                {
                    super(0);
                }

                public final void b() {
                    b bVar = null;
                    if (Build.VERSION.SDK_INT < 30) {
                        b bVar2 = this.this$0.f22089e8;
                        if (bVar2 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar2;
                        }
                        bVar.U();
                        return;
                    }
                    if (Environment.isExternalStorageManager()) {
                        b bVar3 = this.this$0.f22089e8;
                        if (bVar3 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar3;
                        }
                        bVar.U();
                        return;
                    }
                    t tVar = this.this$0.f22088d8;
                    if (tVar == null) {
                        f0.S("pb");
                        tVar = null;
                    }
                    if (tVar.f22151r == null) {
                        t tVar2 = this.this$0.f22088d8;
                        if (tVar2 == null) {
                            f0.S("pb");
                            tVar2 = null;
                        }
                        if (tVar2.f22152s == null) {
                            return;
                        }
                    }
                    t tVar3 = this.this$0.f22088d8;
                    if (tVar3 == null) {
                        f0.S("pb");
                        tVar3 = null;
                    }
                    if (tVar3.f22152s != null) {
                        t tVar4 = this.this$0.f22088d8;
                        if (tVar4 == null) {
                            f0.S("pb");
                            tVar4 = null;
                        }
                        cg.b bVar4 = tVar4.f22152s;
                        f0.m(bVar4);
                        b bVar5 = this.this$0.f22089e8;
                        if (bVar5 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar5;
                        }
                        bVar4.a(bVar.W(), kotlin.collections.s.k(y.f22163f), false);
                        return;
                    }
                    t tVar5 = this.this$0.f22088d8;
                    if (tVar5 == null) {
                        f0.S("pb");
                        tVar5 = null;
                    }
                    cg.a aVar = tVar5.f22151r;
                    f0.m(aVar);
                    b bVar6 = this.this$0.f22089e8;
                    if (bVar6 == null) {
                        f0.S("task");
                    } else {
                        bVar = bVar6;
                    }
                    aVar.a(bVar.W(), kotlin.collections.s.k(y.f22163f));
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01df, code lost:
    
        if ((!r9.f22148o.isEmpty()) != false) goto L124;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f6(java.util.Map<java.lang.String, java.lang.Boolean> r9) {
        /*
            Method dump skipped, instruction units count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.f6(java.util.Map):void");
    }

    public final void g6() {
        if (Y5()) {
            j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestNotificationPermissionResult$1
                {
                    super(0);
                }

                public final void b() {
                    b bVar = null;
                    if (Build.VERSION.SDK_INT < 26) {
                        b bVar2 = this.this$0.f22089e8;
                        if (bVar2 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar2;
                        }
                        bVar.U();
                        return;
                    }
                    if (bg.c.a(this.this$0.R4())) {
                        b bVar3 = this.this$0.f22089e8;
                        if (bVar3 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar3;
                        }
                        bVar.U();
                        return;
                    }
                    t tVar = this.this$0.f22088d8;
                    if (tVar == null) {
                        f0.S("pb");
                        tVar = null;
                    }
                    if (tVar.f22151r == null) {
                        t tVar2 = this.this$0.f22088d8;
                        if (tVar2 == null) {
                            f0.S("pb");
                            tVar2 = null;
                        }
                        if (tVar2.f22152s == null) {
                            return;
                        }
                    }
                    t tVar3 = this.this$0.f22088d8;
                    if (tVar3 == null) {
                        f0.S("pb");
                        tVar3 = null;
                    }
                    if (tVar3.f22152s != null) {
                        t tVar4 = this.this$0.f22088d8;
                        if (tVar4 == null) {
                            f0.S("pb");
                            tVar4 = null;
                        }
                        cg.b bVar4 = tVar4.f22152s;
                        f0.m(bVar4);
                        b bVar5 = this.this$0.f22089e8;
                        if (bVar5 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar5;
                        }
                        bVar4.a(bVar.W(), kotlin.collections.s.k(c.a.f9430a), false);
                        return;
                    }
                    t tVar5 = this.this$0.f22088d8;
                    if (tVar5 == null) {
                        f0.S("pb");
                        tVar5 = null;
                    }
                    cg.a aVar = tVar5.f22151r;
                    f0.m(aVar);
                    b bVar6 = this.this$0.f22089e8;
                    if (bVar6 == null) {
                        f0.S("task");
                    } else {
                        bVar = bVar6;
                    }
                    aVar.a(bVar.W(), kotlin.collections.s.k(c.a.f9430a));
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    public final void h6() {
        if (Y5()) {
            b bVar = null;
            if (Build.VERSION.SDK_INT < 23) {
                b bVar2 = this.f22089e8;
                if (bVar2 == null) {
                    f0.S("task");
                } else {
                    bVar = bVar2;
                }
                bVar.U();
                return;
            }
            if (Settings.canDrawOverlays(R4())) {
                b bVar3 = this.f22089e8;
                if (bVar3 == null) {
                    f0.S("task");
                } else {
                    bVar = bVar3;
                }
                bVar.U();
                return;
            }
            t tVar = this.f22088d8;
            if (tVar == null) {
                f0.S("pb");
                tVar = null;
            }
            if (tVar.f22151r == null) {
                t tVar2 = this.f22088d8;
                if (tVar2 == null) {
                    f0.S("pb");
                    tVar2 = null;
                }
                if (tVar2.f22152s == null) {
                    return;
                }
            }
            t tVar3 = this.f22088d8;
            if (tVar3 == null) {
                f0.S("pb");
                tVar3 = null;
            }
            if (tVar3.f22152s != null) {
                t tVar4 = this.f22088d8;
                if (tVar4 == null) {
                    f0.S("pb");
                    tVar4 = null;
                }
                cg.b bVar4 = tVar4.f22152s;
                f0.m(bVar4);
                b bVar5 = this.f22089e8;
                if (bVar5 == null) {
                    f0.S("task");
                } else {
                    bVar = bVar5;
                }
                bVar4.a(bVar.W(), kotlin.collections.s.k("android.permission.SYSTEM_ALERT_WINDOW"), false);
                return;
            }
            t tVar5 = this.f22088d8;
            if (tVar5 == null) {
                f0.S("pb");
                tVar5 = null;
            }
            cg.a aVar = tVar5.f22151r;
            f0.m(aVar);
            b bVar6 = this.f22089e8;
            if (bVar6 == null) {
                f0.S("task");
            } else {
                bVar = bVar6;
            }
            aVar.a(bVar.W(), kotlin.collections.s.k("android.permission.SYSTEM_ALERT_WINDOW"));
        }
    }

    public final void i6() {
        if (Y5()) {
            j6(new ik.a<z1>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestWriteSettingsPermissionResult$1
                {
                    super(0);
                }

                public final void b() {
                    b bVar = null;
                    if (Build.VERSION.SDK_INT < 23) {
                        b bVar2 = this.this$0.f22089e8;
                        if (bVar2 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar2;
                        }
                        bVar.U();
                        return;
                    }
                    if (Settings.System.canWrite(this.this$0.R4())) {
                        b bVar3 = this.this$0.f22089e8;
                        if (bVar3 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar3;
                        }
                        bVar.U();
                        return;
                    }
                    t tVar = this.this$0.f22088d8;
                    if (tVar == null) {
                        f0.S("pb");
                        tVar = null;
                    }
                    if (tVar.f22151r == null) {
                        t tVar2 = this.this$0.f22088d8;
                        if (tVar2 == null) {
                            f0.S("pb");
                            tVar2 = null;
                        }
                        if (tVar2.f22152s == null) {
                            return;
                        }
                    }
                    t tVar3 = this.this$0.f22088d8;
                    if (tVar3 == null) {
                        f0.S("pb");
                        tVar3 = null;
                    }
                    if (tVar3.f22152s != null) {
                        t tVar4 = this.this$0.f22088d8;
                        if (tVar4 == null) {
                            f0.S("pb");
                            tVar4 = null;
                        }
                        cg.b bVar4 = tVar4.f22152s;
                        f0.m(bVar4);
                        b bVar5 = this.this$0.f22089e8;
                        if (bVar5 == null) {
                            f0.S("task");
                        } else {
                            bVar = bVar5;
                        }
                        bVar4.a(bVar.W(), kotlin.collections.s.k("android.permission.WRITE_SETTINGS"), false);
                        return;
                    }
                    t tVar5 = this.this$0.f22088d8;
                    if (tVar5 == null) {
                        f0.S("pb");
                        tVar5 = null;
                    }
                    cg.a aVar = tVar5.f22151r;
                    f0.m(aVar);
                    b bVar6 = this.this$0.f22089e8;
                    if (bVar6 == null) {
                        f0.S("task");
                    } else {
                        bVar = bVar6;
                    }
                    aVar.a(bVar.W(), kotlin.collections.s.k("android.permission.WRITE_SETTINGS"));
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    public final void j6(final ik.a<z1> aVar) {
        this.f22087c8.post(new Runnable() { // from class: com.permissionx.guolindev.request.n
            @Override // java.lang.Runnable
            public final void run() {
                InvisibleFragment.k6(aVar);
            }
        });
    }

    public final void l6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        this.f22091g8.b(u.f22155f);
    }

    public final void o6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        this.f22097m8.b(v.f22157f);
    }

    public final void q6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            d6();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(Uri.parse("package:" + P4().getPackageName()));
        this.f22095k8.b(intent);
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public final void s6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            e6();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.parse("package:" + P4().getPackageName()));
        if (intent.resolveActivity(P4().getPackageManager()) == null) {
            intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        this.f22094j8.b(intent);
    }

    public final void v6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            d6();
            return;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", P4().getPackageName());
        this.f22096l8.b(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void w6(@yt.k t permissionBuilder, @yt.k Set<String> permissions, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(permissions, "permissions");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        androidx.activity.result.g<String[]> gVar = this.f22090f8;
        Object[] array = permissions.toArray(new String[0]);
        f0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        gVar.b(array);
    }

    public final void y6(@yt.k t permissionBuilder, @yt.k b chainTask) {
        f0.p(permissionBuilder, "permissionBuilder");
        f0.p(chainTask, "chainTask");
        this.f22088d8 = permissionBuilder;
        this.f22089e8 = chainTask;
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(R4())) {
            h6();
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + P4().getPackageName()));
        this.f22092h8.b(intent);
    }
}
