package a;

import android.os.Build;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fm0 f6221a = new fm0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1040a = "settings put system bench_mark_mode ";

    public final boolean b(boolean z) {
        kl0 kl0Var = new kl0();
        ArrayList<String[]> arrayListF = kl0Var.f();
        int i = 0;
        if (!jm0.f6525a.e()) {
            if (!jm0.f6525a.d()) {
                return false;
            }
            vm0.c();
            f92.c(arrayListF, "clusters");
            for (String[] strArr : arrayListF) {
                f92.c(strArr, "cluster");
                Object objN = u42.n(strArr);
                f92.c(objN, "cluster.first()");
                int iL = kl0Var.l(Integer.parseInt((String) objN));
                vm0.e(i, iL);
                if (z) {
                    vm0.f(i, 1000000);
                } else {
                    vm0.f(i, iL);
                }
                i++;
            }
            f1039a = true;
            if (d()) {
                s60.f7366a.a(this.f1040a + " 1");
            }
            return true;
        }
        ul0.j();
        ul0.f();
        ul0.r();
        ul0.t();
        ul0.u(false);
        if (z) {
            ul0.g(false);
            ul0.b(false);
        } else {
            ul0.b(true);
        }
        f92.c(arrayListF, "clusters");
        for (String[] strArr2 : arrayListF) {
            f92.c(strArr2, "cluster");
            Object objN2 = u42.n(strArr2);
            f92.c(objN2, "cluster.first()");
            int iL2 = kl0Var.l(Integer.parseInt((String) objN2));
            ul0.m(i, iL2);
            if (z) {
                ul0.n(i, 1000000);
            } else {
                ul0.n(i, iL2);
            }
            i++;
        }
        if (d()) {
            s60.f7366a.a(this.f1040a + " 1");
        }
        f1039a = true;
        return true;
    }

    public final boolean c() {
        if (jm0.f6525a.e()) {
            ul0.j();
            ul0.s(0);
            ul0.g(true);
            if (d()) {
                s60.f7366a.a(this.f1040a + " 0");
            }
            f1039a = false;
            return true;
        }
        if (!jm0.f6525a.d()) {
            return false;
        }
        vm0.c();
        if (d()) {
            s60.f7366a.a(this.f1040a + " 0");
        }
        f1039a = false;
        return true;
    }

    public final boolean d() {
        String str = Build.MANUFACTURER;
        f92.c(str, "Build.MANUFACTURER");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return f92.a(lowerCase, "vivo") || f92.a(lowerCase, "iqoo");
    }

    public final boolean e() {
        return jm0.f6525a.d() || jm0.f6525a.e();
    }

    public final boolean f() {
        return y60.f7952a.d("/data/local/tmp/scene-experimental") && e() && f92.a(Build.PRODUCT, "PD2509") && f92.a(Build.MODEL, "V2509A");
    }
}
