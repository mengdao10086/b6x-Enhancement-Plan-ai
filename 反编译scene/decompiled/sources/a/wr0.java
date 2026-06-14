package a;

import android.content.Context;
import com.omarea.Scene;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vr0 f7816a = new vr0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z32 f3475a = a42.a(ur0.f7624a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rx0 f3476a = new rx0(Scene.f4798a.c(), "features/fas_blacklist.conf");
    public final rx0 b = new rx0(Scene.f4798a.c(), "features/fas_whitelist.conf");
    public final rx0 c = new rx0(Scene.f4798a.c(), "features/fas_fps_offset.conf");
    public final rx0 d = new rx0(Scene.f4798a.c(), "features/fas_middle_offset.conf");
    public final rx0 e = new rx0(Scene.f4798a.c(), "FAS_OFFSET.CONF");

    public final Set<String> b() {
        Set<String> setC = this.f3476a.c();
        f92.c(setC, "blackListFile.keys");
        return setC;
    }

    public final Set<String> c() {
        if (i()) {
            return d();
        }
        String[] strArrC = new ri0(Scene.f4798a.c()).c();
        Set<String> setB = b();
        ArrayList arrayList = new ArrayList();
        for (String str : strArrC) {
            if (!setB.contains(str)) {
                arrayList.add(str);
            }
        }
        return i52.b0(arrayList);
    }

    public final Set<String> d() {
        if (!this.b.a()) {
            String[] stringArray = Scene.f4798a.c().getResources().getStringArray(s61.config_fas_whitelist);
            f92.c(stringArray, "Scene.context.resources.…ray.config_fas_whitelist)");
            for (String str : stringArray) {
                this.b.j(str, true);
            }
        }
        Set<String> setC = this.b.c();
        f92.c(setC, "whiteListFile.exists().r…teListFile.keys\n        }");
        return setC;
    }

    public final rx0 e() {
        return this.f3476a;
    }

    public final int f(String str) {
        f92.d(str, "app");
        Integer numJ = ac2.j(this.c.d(str, "0"));
        if (numJ != null) {
            return numJ.intValue();
        }
        return 0;
    }

    public final Integer g(String str) {
        f92.d(str, "app");
        Double dI = zb2.i(this.d.d(str, this.e.d(str, "")));
        if (dI == null) {
            dI = null;
        }
        if (dI != null) {
            return Integer.valueOf((int) (dI.doubleValue() * ((double) 100)));
        }
        return null;
    }

    public final boolean h() {
        return !u42.k(new String[]{"cliffs", "kalama", "cape", "waipio"}, jm0.f6525a.a());
    }

    public final boolean i() {
        return !f92.a(Scene.f4798a.h(hz0.f1282a.x(), ""), "lp");
    }

    public final rx0 j() {
        return this.b;
    }

    public final boolean k(String str) {
        f92.d(str, "app");
        return i() ? m(str) : !l(str);
    }

    public final boolean l(String str) {
        return this.f3476a.b(str, false);
    }

    public final boolean m(String str) {
        return d().contains(str);
    }

    public final void n(Context context) {
        f92.d(context, "context");
        if (!new File(c60.f5764a.d(context, "features/fas_whitelist.conf")).exists()) {
            c60.f5764a.m("fas_whitelist.txt", "features/fas_whitelist.conf", context);
        }
        if (!new File(c60.f5764a.d(context, "features/fas_blacklist.conf")).exists()) {
            c60.f5764a.m("fas_blacklist.txt", "features/fas_blacklist.conf", context);
        }
        if (new File(c60.f5764a.d(context, "features/fas_fps_offset.conf")).exists()) {
            return;
        }
        c60.f5764a.m("fas_fps_offset.txt", "features/fas_fps_offset.conf", context);
    }

    public final boolean o() {
        boolean z = f92.a(Scene.f4798a.h(hz0.f1282a.x(), ""), "lp") && p();
        ar0 ar0VarP = new wu0().p();
        Boolean boolE = ar0VarP != null ? ar0VarP.e() : null;
        if ((z && (!f92.a(boolE, Boolean.FALSE))) || f92.a(boolE, Boolean.TRUE)) {
            return f7816a.b().length() > 0;
        }
        return false;
    }

    public final boolean p() {
        return f92.a(wu0.f3480a.e(), "SOURCE_SCENE_ONLINE");
    }

    public final void q(String str, boolean z) {
        f92.d(str, "app");
        if (i()) {
            s(str, z);
        } else {
            r(str, !z);
        }
    }

    public final void r(String str, boolean z) {
        if (z) {
            this.f3476a.j(str, true);
        } else {
            this.f3476a.h(str);
        }
    }

    public final void s(String str, boolean z) {
        if (z) {
            this.b.j(str, true);
        } else {
            this.b.h(str);
        }
    }

    public final void t(String str, int i) {
        f92.d(str, "app");
        if (i == 0) {
            this.c.h(str);
        } else {
            this.c.k(str, String.valueOf(i));
        }
    }

    public final void u(String str, int i) {
        f92.d(str, "app");
        if (i != 0) {
            this.d.k(str, String.valueOf(((double) i) / 100.0d));
        } else {
            this.d.h(str);
            this.e.h(str);
        }
    }
}
