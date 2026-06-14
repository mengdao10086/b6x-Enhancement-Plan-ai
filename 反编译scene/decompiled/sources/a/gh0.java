package a;

import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.AppInfoLoader$loadAppBasicInfo$1", f = "AppInfoLoader.kt", l = {}, m = "invokeSuspend")
public final class gh0 extends d72 implements k82<wd2, b62<? super eh0>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0 f6206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1012a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh0(ih0 ih0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f6206a = ih0Var;
        this.f1012a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gh0 gh0Var = new gh0(this.f6206a, this.f1012a, b62Var);
        gh0Var.f1011a = (wd2) obj;
        return gh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super eh0> b62Var) {
        return ((gh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Drawable drawableG;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        String str = this.f1012a;
        try {
            PackageInfo packageInfo = this.f6206a.h().getPackageInfo(this.f1012a, 0);
            str = "" + packageInfo.applicationInfo.loadLabel(this.f6206a.h());
            drawableG = packageInfo.applicationInfo.loadIcon(this.f6206a.h());
        } catch (Exception unused) {
            drawableG = this.f6206a.g(this.f1012a);
        }
        return new eh0(str, drawableG);
    }
}
