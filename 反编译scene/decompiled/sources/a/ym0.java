package a;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ym0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xm0 f7994a = new xm0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f3747a = null;
    public static final String k = "/data/swap_config.conf";
    public static final String l = "/data/adb/modules/scene_swap_controller/scripts/alive_benchmark.sh";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3748a = "swap";
    public final String b = "swap_size";
    public final String c = "swap_priority";
    public final String d = "swap_use_loop";
    public final String e = "zram";
    public final String f = "zram_size";
    public final String g = "comp_algorithm";
    public final String h = "swappiness";
    public final String i = "extra_free_kbytes";
    public final String j = "watermark_scale_factor";

    public final boolean b() {
        Boolean boolValueOf;
        if (f3747a == null) {
            if (y60.f7952a.d(k)) {
                String strA = um0.f7612a.a("vtools.swap.controller");
                boolValueOf = Boolean.valueOf(f92.a(strA, "magisk") || f92.a(strA, "module"));
            } else {
                boolValueOf = Boolean.FALSE;
            }
            f3747a = boolValueOf;
        }
        Boolean bool = f3747a;
        f92.b(bool);
        return bool.booleanValue();
    }

    public final int c() {
        String strA = um0.f7612a.a("vtools.swap.module");
        if (f92.a(strA, "error")) {
            return Integer.MAX_VALUE;
        }
        if (f92.a(strA, "")) {
            return 0;
        }
        try {
            return Integer.parseInt(strA);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final String d(List<String> list, String str) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (bc2.x((String) next, str + '=', false, 2, null)) {
                obj = next;
                break;
            }
        }
        String str2 = (String) obj;
        return str2 != null ? str2.subSequence(str.length() + 1, str2.length()).toString() : "";
    }

    public final void e(SharedPreferences sharedPreferences) {
        f92.d(sharedPreferences, "spf");
        if (b()) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            List<String> listD0 = ec2.d0(y60.f7952a.i("/data/swap_config.conf"), new String[]{"\n"}, false, 0, 6, null);
            try {
                editorEdit.putBoolean(hz0.f1282a.s0(), f92.a(d(listD0, this.f3748a), "true"));
                editorEdit.putInt(hz0.f1282a.v0(), Integer.parseInt(d(listD0, this.b)));
                editorEdit.putInt(hz0.f1282a.u0(), Integer.parseInt(d(listD0, this.c)));
                editorEdit.putBoolean(hz0.f1282a.w0(), f92.a(d(listD0, this.d), "true"));
            } catch (Exception unused) {
            }
            try {
                editorEdit.putBoolean(hz0.f1282a.y0(), f92.a(d(listD0, this.e), "true"));
                editorEdit.putInt(hz0.f1282a.z0(), Integer.parseInt(d(listD0, this.f)));
                editorEdit.putString(hz0.f1282a.p0(), d(listD0, this.g));
            } catch (Exception unused2) {
            }
            try {
                editorEdit.putInt(hz0.f1282a.t0(), Integer.parseInt(d(listD0, this.h)));
                editorEdit.putInt(hz0.f1282a.r0(), Integer.parseInt(d(listD0, this.i)));
            } catch (Exception unused3) {
            }
            try {
                editorEdit.putInt(hz0.f1282a.x0(), Integer.parseInt(d(listD0, this.j)));
            } catch (Exception unused4) {
            }
            editorEdit.apply();
        }
    }

    public final void f(SharedPreferences sharedPreferences) {
        f92.d(sharedPreferences, "spf");
        Object[] array = ec2.d0(y60.f7952a.i(k), new String[]{"\n"}, false, 0, 6, null).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        if (strArr.length > 1) {
            g(strArr, this.f3748a, Boolean.valueOf(sharedPreferences.getBoolean(hz0.f1282a.s0(), false)));
            g(strArr, this.b, Integer.valueOf(sharedPreferences.getInt(hz0.f1282a.v0(), 0)));
            g(strArr, this.c, Integer.valueOf(sharedPreferences.getInt(hz0.f1282a.u0(), 0)));
            g(strArr, this.d, Boolean.valueOf(sharedPreferences.getBoolean(hz0.f1282a.w0(), false)));
            g(strArr, this.e, Boolean.valueOf(sharedPreferences.getBoolean(hz0.f1282a.y0(), false)));
            g(strArr, this.f, Integer.valueOf(sharedPreferences.getInt(hz0.f1282a.z0(), 0)));
            g(strArr, this.g, "" + sharedPreferences.getString(hz0.f1282a.p0(), "lzo"));
            g(strArr, this.h, Integer.valueOf(sharedPreferences.getInt(hz0.f1282a.t0(), 100)));
            g(strArr, this.i, Integer.valueOf(sharedPreferences.getInt(hz0.f1282a.r0(), 29615)));
            g(strArr, this.j, Integer.valueOf(sharedPreferences.getInt(hz0.f1282a.x0(), 100)));
            y60.f7952a.l(k, u42.x(strArr, "\n", null, null, 0, null, null, 62, null));
        }
    }

    public final boolean g(String[] strArr, String str, Object obj) {
        String str2 = str + '=';
        String str3 = str2 + obj;
        int i = 0;
        for (String str4 : strArr) {
            if (bc2.x(str4, str2, false, 2, null)) {
                strArr[i] = str3;
                return true;
            }
            i++;
        }
        return false;
    }
}
