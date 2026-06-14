package a;

import android.util.Base64;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y60 f7952a = new y60();

    public final boolean a(String str, String str2) {
        f92.d(str, "src");
        f92.d(str2, "dst");
        e50 e50Var = e50.f677a;
        return !f92.a(e50.j1(e50Var, "copy", str + ':' + str2, null, 4, null), "error");
    }

    public final void b(String str) {
        f92.d(str, "path");
        if (str.length() > 0) {
            s60.f7366a.a("rm -rf \"" + str + '\"');
        }
    }

    public final boolean c(String str) {
        f92.d(str, "path");
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return e50.f677a.U(str);
    }

    public final boolean d(String str) {
        f92.d(str, "path");
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return e50.f0(e50.f677a, str, false, 2, null);
    }

    public final boolean e(String str) {
        f92.d(str, "path");
        return e50.f677a.e0(str, true);
    }

    public final long f(String str) {
        f92.d(str, "path");
        return e50.f677a.g0(str);
    }

    public final boolean g(String str) {
        f92.d(str, "path");
        return new File(str).exists() || e50.f677a.H0(str);
    }

    public final ArrayList<n50> h(String str) {
        ArrayList<n50> arrayListA;
        f92.d(str, "path");
        o50 o50VarJ0 = e50.J0(e50.f677a, str, null, 2, null);
        return (o50VarJ0 == null || (arrayListA = o50VarJ0.a()) == null) ? new ArrayList<>() : arrayListA;
    }

    public final String i(String str) {
        f92.d(str, "path");
        return x60.f7856a.d(str);
    }

    public final byte[] j(String str) {
        f92.d(str, "path");
        try {
            return o72.b(new File(str));
        } catch (Exception unused) {
            byte[] bArrDecode = Base64.decode(e50.f677a.i1("read-bytes", str, 20000L), 11);
            f92.c(bArrDecode, "Base64.decode(result, Ba…DDING or Base64.URL_SAFE)");
            return bArrDecode;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HashMap<String, String> k(String str) {
        f92.d(str, "path");
        g30 g30VarK0 = e50.f677a.K0(str);
        HashMap<String, String> map = new HashMap<>();
        if (g30VarK0 != null) {
            Iterator<String> itK = g30VarK0.k();
            f92.c(itK, "tree.keys()");
            while (itK.hasNext()) {
                String next = itK.next();
                Object objB = g30VarK0.b(next);
                if (objB instanceof String) {
                    map.put(str + '/' + next, objB);
                }
            }
        }
        return map;
    }

    public final boolean l(String str, String str2) {
        f92.d(str, "path");
        f92.d(str2, "text");
        try {
            o72.g(new File(str), str2, null, 2, null);
            return true;
        } catch (Exception unused) {
            return e50.f677a.v1(str, str2);
        }
    }
}
