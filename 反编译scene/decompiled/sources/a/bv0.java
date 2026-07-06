package a;

import android.app.Application;
import com.omarea.Scene;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zu0 f5735a = new zu0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Application f303a = Scene.f4798a.c();

    public static /* synthetic */ void j(bv0 bv0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        bv0Var.i(z);
    }

    public final void d() {
        File[] fileArrListFiles;
        Iterator it = y42.c("/fas-params", "/features", "/objects", "/charge").iterator();
        while (it.hasNext()) {
            File file = new File(c60.f5764a.c(this.f303a) + ((String) it.next()));
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    file2.delete();
                }
            }
        }
    }

    public final void e() {
        File[] fileArrListFiles = new File(c60.f5764a.c(this.f303a)).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                f92.c(file, "it");
                String name = file.getName();
                f92.c(name, "name");
                if ((bc2.o(name, ".json", false, 2, null) && (bc2.x(name, "manifest", false, 2, null) || bc2.x(name, "profile_init", false, 2, null) || bc2.x(name, "profile", false, 2, null) || bc2.x(name, "_", false, 2, null))) || ((bc2.o(name, ".sh", false, 2, null) && (bc2.x(name, "powercfg", false, 2, null) || bc2.x(name, "_", false, 2, null))) || (bc2.o(name, ".CONF", false, 2, null) && (bc2.x(name, "DDR_", false, 2, null) || bc2.x(name, "FAS_", false, 2, null) || bc2.x(name, "L3_", false, 2, null) || bc2.x(name, "FPS_", false, 2, null))))) {
                    new File(file.getAbsolutePath()).delete();
                }
            }
        }
        wu0.f3480a.a();
        e50.f677a.P0("version-update");
    }

    public final boolean f() {
        return new File(c60.f5764a.d(this.f303a, "profile.json")).exists();
    }

    public final void g(g30 g30Var, boolean z) {
        f92.d(g30Var, "json");
        e();
        c60 c60Var = c60.f5764a;
        String strA = g30Var.A(2);
        f92.c(strA, "json.toString(2)");
        Charset charset = bb2.f5692a;
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strA.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        c60Var.l(bytes, "profile.json", this.f303a);
        c60.f5764a.k(z ? "custom_fas.json" : "custom.json", "manifest.json", this.f303a);
        c60 c60Var2 = c60.f5764a;
        byte[] bytes2 = "exit 0".getBytes(bb2.f5692a);
        f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
        c60Var2.l(bytes2, "powercfg.sh", this.f303a);
        j(this, false, 1, null);
    }

    public final void h() {
        e();
        String strA = new zq0(false).a();
        c60 c60Var = c60.f5764a;
        Charset charset = bb2.f5692a;
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strA.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        c60Var.l(bytes, "profile.json", this.f303a);
        if (y60.f7952a.d("/data/powercfg.json")) {
            c60 c60Var2 = c60.f5764a;
            String strI = y60.f7952a.i("/data/powercfg.json");
            Charset charset2 = bb2.f5692a;
            if (strI == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes2 = strI.getBytes(charset2);
            f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
            c60Var2.l(bytes2, "manifest.json", this.f303a);
        } else {
            c60.f5764a.k("outside.json", "manifest.json", this.f303a);
        }
        c60 c60Var3 = c60.f5764a;
        byte[] bytes3 = "sh /data/powercfg.sh \"$@\"".getBytes(bb2.f5692a);
        f92.c(bytes3, "(this as java.lang.String).getBytes(charset)");
        c60Var3.l(bytes3, "powercfg.sh", this.f303a);
        j(this, false, 1, null);
    }

    public final void i(boolean z) {
        if (z || !new File(c60.f5764a.d(this.f303a, "threads.json")).exists()) {
            qc2.d(xd2.a(qe2.b()), null, null, new av0(this, "threads.json", null), 3, null);
        }
    }

    public final void k() {
        ar0 ar0VarP = new wu0().p();
        if (ar0VarP != null) {
            if (ar0VarP.g().length() > 0) {
                List<String> listD0 = ec2.d0(ar0VarP.g(), new String[]{","}, false, 0, 6, null);
                ArrayList arrayList = new ArrayList(z42.m(listD0, 10));
                for (String str : listD0) {
                    if (str == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    arrayList.add(ec2.r0(str).toString());
                }
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (((String) obj).length() > 0) {
                        arrayList2.add(obj);
                    }
                }
                for (String str2 : arrayList2) {
                    if (y60.f7952a.c("/data/adb/modules/" + str2)) {
                        y60.f7952a.l("/data/adb/modules/" + str2 + "/disable", " ");
                    }
                }
            }
        }
        y60.f7952a.b("/data/powercfg.sh");
        y60.f7952a.b("/data/powercfg.json");
        y60.f7952a.b("/data/powercfg-base.sh");
    }
}
