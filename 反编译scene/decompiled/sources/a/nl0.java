package a;

import android.content.Context;
import android.os.Build;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mj0 f2109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2110a;

    public nl0(Context context) {
        f92.d(context, "context");
        this.f2110a = context;
        this.f2109a = new mj0(context);
    }

    public final String a() {
        if (!f6929a) {
            if (Build.VERSION.SDK_INT >= 30) {
                c();
            }
            d();
            c60.f5764a.k("categories.json", "categories.json", this.f2110a);
            new wr0().n(this.f2110a);
            if (!b() || !e()) {
                return null;
            }
            f6929a = true;
        }
        return c60.f5764a.d(this.f2110a, "up.sh");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011d A[Catch: Exception -> 0x019d, TryCatch #0 {Exception -> 0x019d, blocks: (B:3:0x0006, B:5:0x000c, B:16:0x0067, B:19:0x006e, B:21:0x0072, B:23:0x0085, B:28:0x00a2, B:29:0x00a9, B:15:0x005e, B:30:0x00b2, B:32:0x00d0, B:34:0x00ec, B:36:0x00fa, B:42:0x0106, B:51:0x0133, B:53:0x013f, B:55:0x016b, B:56:0x0172, B:48:0x011d, B:6:0x0024, B:12:0x0045), top: B:60:0x0006, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.nl0.b():boolean");
    }

    public final void c() {
        c60.f5764a.o(this.f2110a, h60.f6280a.a(this.f2110a, 2131820547), "daemon");
        String strB = h60.f6280a.b(this.f2110a, 2131820562);
        c60 c60Var = c60.f5764a;
        Context context = this.f2110a;
        Charset charset = bb2.f5692a;
        if (strB == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strB.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        c60Var.o(context, bytes, "up.sh");
        c60.f5764a.n(this.f2110a, "toolkit/busybox", true);
        String strB2 = h60.f6280a.b(this.f2110a, 2131820557);
        c60 c60Var2 = c60.f5764a;
        Context context2 = this.f2110a;
        Charset charset2 = bb2.f5692a;
        if (strB2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes2 = strB2.getBytes(charset2);
        f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
        c60Var2.o(context2, bytes2, "rish.sh");
        c60.f5764a.o(this.f2110a, h60.f6280a.a(this.f2110a, 2131820558), "rish_shizuku.dex");
    }

    public final boolean d() {
        try {
            String strB = h60.f6280a.b(this.f2110a, 2131820557);
            c60 c60Var = c60.f5764a;
            Charset charset = bb2.f5692a;
            if (strB == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = strB.getBytes(charset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            c60Var.l(bytes, "rish.sh", this.f2110a);
            f(c60.f5764a.d(this.f2110a, "rish.sh"));
            c60.f5764a.l(h60.f6280a.a(this.f2110a, 2131820558), "rish_shizuku.dex", this.f2110a);
            f(c60.f5764a.d(this.f2110a, "rish_shizuku.dex"));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean e() {
        try {
            String strB = h60.f6280a.b(this.f2110a, 2131820561);
            c60 c60Var = c60.f5764a;
            Charset charset = bb2.f5692a;
            if (strB == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = strB.getBytes(charset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            c60Var.l(bytes, "up.sh", this.f2110a);
            f(c60.f5764a.d(this.f2110a, "up.sh"));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void f(String str) {
        this.f2109a.a(str);
    }
}
