package a;

import a.p80;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final np0 f7137a = new np0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mj0 f2446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2447a;

    public pp0(Context context) {
        f92.d(context, "context");
        this.f2447a = context;
        this.f2446a = new mj0(context);
    }

    public final void a(Runnable runnable) {
        f92.d(runnable, "next");
        String strD = c60.f5764a.d(this.f2447a, "busybox");
        if (!new File(strD).exists()) {
            c60 c60Var = c60.f5764a;
            AssetManager assets = this.f2447a.getAssets();
            f92.c(assets, "context.assets");
            if (!f92.a(c60Var.j(assets, "toolkit/busybox", "busybox", this.f2447a), strD)) {
                return;
            }
        }
        if (f7137a.a() || b()) {
            runnable.run();
            return;
        }
        p80.a aVar = p80.f2403a;
        Context context = this.f2447a;
        String string = context.getString(u61.busybox_nonsupport);
        f92.c(string, "context.getString(R.string.busybox_nonsupport)");
        aVar.a(context, "", string, op0.f7044a).i(false);
    }

    public final boolean b() {
        if (!c() && !f7137a.a()) {
            String[] strArr = Build.SUPPORTED_ABIS;
            f92.c(strArr, "Build.SUPPORTED_ABIS");
            String strX = u42.x(strArr, " ", null, null, 0, null, null, 62, null);
            Locale locale = Locale.getDefault();
            f92.c(locale, "Locale.getDefault()");
            if (strX == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strX.toLowerCase(locale);
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!ec2.C(lowerCase, "arm", false, 2, null)) {
                return false;
            }
            String string = this.f2447a.getString(u61.config_toolkit_install_path);
            f92.c(string, "context.getString(R.stri…fig_toolkit_install_path)");
            String strD = c60.f5764a.d(this.f2447a, string);
            String str = string + "/busybox";
            String strD2 = c60.f5764a.d(this.f2447a, str);
            if (!new File(strD2).exists()) {
                c60 c60Var = c60.f5764a;
                AssetManager assets = this.f2447a.getAssets();
                f92.c(assets, "context.assets");
                if (!f92.a(c60Var.j(assets, "toolkit/busybox", str, this.f2447a), strD2)) {
                    return false;
                }
                this.f2446a.a(strD2);
                return true;
            }
            String strM = c60.f5764a.m("addin/install_busybox.sh", string + "/install_busybox.sh", this.f2447a);
            if (strM != null) {
                s60.f7366a.a("sh " + strM + ' ' + strD);
            }
        }
        return true;
    }

    public final boolean c() {
        if (f7137a.a()) {
            return true;
        }
        String string = this.f2447a.getString(u61.config_toolkit_install_path);
        f92.c(string, "context.getString(R.stri…fig_toolkit_install_path)");
        String strD = c60.f5764a.d(this.f2447a, string);
        if (new File(strD + "/md5sum").exists()) {
            if (new File(strD + "/busybox_1_34_1").exists()) {
                return true;
            }
        }
        return false;
    }
}
