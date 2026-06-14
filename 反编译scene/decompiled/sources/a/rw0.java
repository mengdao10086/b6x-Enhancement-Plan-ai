package a;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7336a;

    public rw0(Context context) {
        f92.d(context, "ctx");
        this.f7336a = context;
    }

    public static final /* synthetic */ String a(rw0 rw0Var, int i) {
        return rw0Var.d(i);
    }

    public final m30 b() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        List<l30> listC = c();
        String str = Build.MANUFACTURER;
        f92.c(str, "Build.MANUFACTURER");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return new m30((g82<? super l30, m42>[]) new g82[]{new gv0(this, listC), new jv0(this, listC), new ov0(this, listC), new tv0(this, listC), new yv0(this, listC), new dw0(this), new mw0(this, f92.a(lowerCase, "xiaomi") && jm0.f6525a.e() && Build.VERSION.SDK_INT > 34)});
    }

    public final List<l30> c() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Object next;
        Object next2;
        Object next3;
        ez0 ez0Var = new ez0();
        int iF = ez0Var.f();
        List<Display.Mode> listE = ez0Var.e();
        l30[] l30VarArr = new l30[4];
        l30 l30Var = new l30(new nw0(this, iF));
        if (iF <= 120) {
            l30Var = null;
        }
        l30VarArr[0] = l30Var;
        l30 l30Var2 = new l30(new ow0(this));
        Iterator<T> it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (u92.b(((Display.Mode) next).getRefreshRate()) == 120) {
                break;
            }
        }
        if (next == null) {
            l30Var2 = null;
        }
        l30VarArr[1] = l30Var2;
        l30 l30Var3 = new l30(new pw0(this));
        Iterator<T> it2 = listE.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (u92.b(((Display.Mode) next2).getRefreshRate()) == 90) {
                break;
            }
        }
        if (next2 == null) {
            l30Var3 = null;
        }
        l30VarArr[2] = l30Var3;
        l30 l30Var4 = new l30(new qw0(this));
        Iterator<T> it3 = listE.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
            if (u92.b(((Display.Mode) next3).getRefreshRate()) == 60) {
                break;
            }
        }
        l30VarArr[3] = next3 != null ? l30Var4 : null;
        return u42.l(l30VarArr);
    }

    public final String d(int i) {
        String string = this.f7336a.getString(i);
        f92.c(string, "ctx.getString(id)");
        return string;
    }
}
