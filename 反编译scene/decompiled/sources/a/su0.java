package a;

import android.app.Application;
import android.graphics.drawable.Drawable;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class su0 {
    public su0() {
    }

    public /* synthetic */ su0(b92 b92Var) {
        this();
    }

    public final void a() {
        wu0.c = null;
        wu0.f7823a = null;
    }

    public final String b() {
        return wu0.i;
    }

    public final String c() {
        return wu0.g;
    }

    public final String d() {
        if (q().a() == null) {
            ar0 ar0VarP = new wu0().p();
            String strK = ar0VarP != null ? ar0VarP.k() : null;
            if (strK == null || strK.length() == 0) {
                q().e();
            } else {
                q().c(bc2.x(strK, "/", false, 2, null) ? x60.f7856a.d(strK) : um0.f7612a.a(strK));
            }
        }
        String strA = q().a();
        return strA != null ? strA : "";
    }

    public final String e() {
        if (bv0.f5735a.a()) {
            return "SOURCE_OUTSIDE";
        }
        String strH = Scene.f4798a.h(hz0.f1282a.c0(), "UNKNOWN");
        if (!f92.a(strH, "SOURCE_SCENE_CUSTOM") && !new bv0().f()) {
            return "SOURCE_NONE";
        }
        f92.b(strH);
        return strH;
    }

    public final String f() {
        String strE = e();
        if (f92.a(strE, "SOURCE_OUTSIDE")) {
            ar0 ar0VarP = new wu0().p();
            String strH = ar0VarP != null ? ar0VarP.h() : null;
            if (!(strH == null || strH.length() == 0)) {
                return strH;
            }
            String strA = ar0VarP != null ? ar0VarP.a() : null;
            if (!(strA == null || strA.length() == 0)) {
                return strA;
            }
        }
        return r(strE);
    }

    public final String g() {
        return wu0.k;
    }

    public final Drawable h(String str) {
        Application applicationC;
        int i;
        f92.d(str, "mode");
        if (f92.a(str, wu0.f3480a.p())) {
            applicationC = Scene.f4798a.c();
            i = 2131231118;
        } else if (f92.a(str, wu0.f3480a.c())) {
            applicationC = Scene.f4798a.c();
            i = 2131231112;
        } else if (f92.a(str, wu0.f3480a.o())) {
            applicationC = Scene.f4798a.c();
            i = 2131231117;
        } else if (f92.a(str, wu0.f3480a.i())) {
            applicationC = Scene.f4798a.c();
            i = 2131231114;
        } else {
            if (!f92.a(str, wu0.f3480a.n())) {
                return null;
            }
            applicationC = Scene.f4798a.c();
            i = 2131231116;
        }
        return applicationC.getDrawable(i);
    }

    public final String i() {
        return wu0.f;
    }

    public final String j() {
        return wu0.j;
    }

    public final String k(String str) {
        String string;
        String str2;
        f92.d(str, "mode");
        if (f92.a(str, p())) {
            string = Scene.f4798a.c().getString(u61.powersave);
            str2 = "Scene.context.getString(R.string.powersave)";
        } else if (f92.a(str, o())) {
            string = Scene.f4798a.c().getString(u61.performance);
            str2 = "Scene.context.getString(R.string.performance)";
        } else if (f92.a(str, i())) {
            string = Scene.f4798a.c().getString(u61.fast);
            str2 = "Scene.context.getString(R.string.fast)";
        } else if (f92.a(str, c())) {
            string = Scene.f4798a.c().getString(u61.balance);
            str2 = "Scene.context.getString(R.string.balance)";
        } else if (f92.a(str, n())) {
            string = Scene.f4798a.c().getString(u61.pedestal);
            str2 = "Scene.context.getString(R.string.pedestal)";
        } else if (f92.a(str, j())) {
            string = Scene.f4798a.c().getString(u61.kepp_state);
            str2 = "Scene.context.getString(R.string.kepp_state)";
        } else if (f92.a(str, b())) {
            string = Scene.f4798a.c().getString(u61.uperf_auto);
            str2 = "Scene.context.getString(R.string.uperf_auto)";
        } else if (f92.a(str, "")) {
            string = Scene.f4798a.c().getString(u61.global_default);
            str2 = "Scene.context.getString(R.string.global_default)";
        } else {
            string = Scene.f4798a.c().getString(u61.unknown_mode);
            str2 = "Scene.context.getString(R.string.unknown_mode)";
        }
        f92.c(string, str2);
        return string;
    }

    public final String l() {
        tu0 tu0Var = (tu0) i52.C(wu0.f3482a);
        if (tu0Var != null) {
            return tu0Var.c();
        }
        return null;
    }

    public final String m() {
        tu0 tu0Var = (tu0) i52.C(wu0.f3482a);
        if (tu0Var != null) {
            return tu0Var.a();
        }
        return null;
    }

    public final String n() {
        return wu0.h;
    }

    public final String o() {
        return wu0.e;
    }

    public final String p() {
        return wu0.d;
    }

    public final dx0 q() {
        return wu0.f3478a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String r(java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.su0.r(java.lang.String):java.lang.String");
    }
}
