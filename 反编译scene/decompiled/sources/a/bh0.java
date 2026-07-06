package a;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ch0 f5705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PackageInfo f273a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ wd2 f274b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh0(PackageInfo packageInfo, b62 b62Var, ch0 ch0Var, wd2 wd2Var) {
        super(2, b62Var);
        this.f273a = packageInfo;
        this.f5705a = ch0Var;
        this.f274b = wd2Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        bh0 bh0Var = new bh0(this.f273a, b62Var, this.f5705a, this.f274b);
        bh0Var.f272a = (wd2) obj;
        return bh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((bh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws PackageManager.NameNotFoundException {
        Object objE;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        long j = this.f5705a.f5792a.f5900a.j(this.f273a.packageName);
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfo = this.f273a;
            f92.c(packageInfo, "pkg");
            objE = t62.f(packageInfo.getLongVersionCode());
        } else {
            objE = t62.e(this.f273a.versionCode);
        }
        if (!(objE instanceof Long) || j != ((Long) objE).longValue()) {
            PackageInfo packageInfo2 = this.f5705a.f5792a.f561a.getPackageInfo(this.f273a.packageName, this.f5705a.c);
            this.f5705a.f5792a.f5900a.f(this.f273a.packageName);
            ActivityInfo[] activityInfoArr = packageInfo2.activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    CharSequence charSequenceLoadLabel = activityInfo.loadLabel(this.f5705a.f5792a.f561a);
                    f92.c(charSequenceLoadLabel, "activity.loadLabel(packageManager)");
                    this.f5705a.f5792a.f5900a.a(activityInfo, "" + charSequenceLoadLabel);
                }
            }
            this.f5705a.f5792a.f5900a.i(this.f273a.packageName);
            ServiceInfo[] serviceInfoArr = packageInfo2.services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    this.f5705a.f5792a.f5900a.d(serviceInfo);
                }
            }
            this.f5705a.f5792a.f5900a.g(this.f273a.packageName);
            ProviderInfo[] providerInfoArr = packageInfo2.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    this.f5705a.f5792a.f5900a.b(providerInfo);
                }
            }
            this.f5705a.f5792a.f5900a.h(this.f273a.packageName);
            ActivityInfo[] activityInfoArr2 = packageInfo2.receivers;
            if (activityInfoArr2 != null) {
                for (ActivityInfo activityInfo2 : activityInfoArr2) {
                    this.f5705a.f5792a.f5900a.c(activityInfo2);
                }
            }
            this.f5705a.f5792a.f5900a.o(this.f273a);
        }
        return m42.f6769a;
    }
}
