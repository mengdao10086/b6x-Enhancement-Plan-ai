package a;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2565a;
    public String b;
    public String c;

    public qc0(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "parentDir");
        this.f7198a = context;
        this.c = str;
        this.f2565a = "file:///android_asset/";
        this.b = "";
    }

    public final InputStream a(String str) {
        String strF = f(this.c, str);
        try {
            try {
                int length = this.f2565a.length();
                if (strF == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = strF.substring(length);
                f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                InputStream inputStreamOpen = this.f7198a.getAssets().open(strSubstring);
                this.b = strF;
                return inputStreamOpen;
            } catch (Exception unused) {
                InputStream inputStreamOpen2 = this.f7198a.getAssets().open(str);
                this.b = this.f2565a + str;
                return inputStreamOpen2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public final InputStream b(String str) {
        if (this.c.length() > 0) {
            String strF = f(this.c, str);
            File file = new File(strF);
            if (file.exists() && file.canRead()) {
                String absolutePath = file.getAbsolutePath();
                f92.c(absolutePath, "absolutePath");
                this.b = absolutePath;
                return new FileInputStream(file);
            }
            InputStream inputStreamG = g(strF);
            if (inputStreamG != null) {
                return inputStreamG;
            }
        }
        String absolutePath2 = new File(f(c60.f5764a.c(this.f7198a), str)).getAbsolutePath();
        File file2 = new File(absolutePath2);
        if (file2.exists() && file2.canRead()) {
            String absolutePath3 = file2.getAbsolutePath();
            f92.c(absolutePath3, "absolutePath");
            this.b = absolutePath3;
            return new FileInputStream(file2);
        }
        f92.c(absolutePath2, "privatePath");
        InputStream inputStreamG2 = g(absolutePath2);
        if (inputStreamG2 != null) {
            return inputStreamG2;
        }
        return null;
    }

    public final String c() {
        return this.b;
    }

    public final InputStream d(String str) {
        try {
            if (!bc2.x(str, "/", false, 2, null)) {
                return ((this.c.length() > 0) && bc2.x(this.c, this.f2565a, false, 2, null)) ? a(str) : b(str);
            }
            this.b = str;
            File file = new File(str);
            return (file.exists() && file.canRead()) ? new FileInputStream(file) : g(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final InputStream e(String str) {
        f92.d(str, "filePath");
        try {
            if (!bc2.x(str, this.f2565a, false, 2, null)) {
                return d(str);
            }
            this.b = str;
            AssetManager assets = this.f7198a.getAssets();
            String strSubstring = str.substring(this.f2565a.length());
            f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return assets.open(strSubstring);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String f(String str, String str2) {
        String strSubstring;
        String strSubstring2 = str;
        boolean zX = bc2.x(strSubstring2, this.f2565a, false, 2, null);
        if (zX) {
            int length = this.f2565a.length();
            if (strSubstring2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring2 = strSubstring2.substring(length);
            f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        }
        ArrayList arrayList = new ArrayList(ec2.d0(strSubstring2, new String[]{"/"}, false, 0, 6, null));
        if (bc2.x(str2, "../", false, 2, null) && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList(ec2.d0(str2, new String[]{"/"}, false, 0, 6, null));
            while (true) {
                String str3 = (String) i52.C(arrayList2);
                if (str3 == null || !f92.a(str3, "..") || arrayList.size() <= 0) {
                    break;
                }
                arrayList.remove(arrayList.size() - 1);
                arrayList2.remove(0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(zX ? this.f2565a : "");
            sb.append(i52.H(arrayList, "/", null, null, 0, null, null, 62, null));
            return f(sb.toString(), i52.H(arrayList2, "/", null, null, 0, null, null, 62, null));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(zX ? this.f2565a : "");
        if (!(strSubstring2.length() == 0) && !bc2.o(strSubstring2, "/", false, 2, null)) {
            strSubstring2 = strSubstring2 + "/";
        }
        sb2.append(strSubstring2);
        if (!bc2.x(str2, "./", false, 2, null)) {
            strSubstring = str2;
        } else {
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(2);
            f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        sb2.append(strSubstring);
        return sb2.toString();
    }

    public final InputStream g(String str) {
        if (!y60.f7952a.d(str)) {
            return null;
        }
        File file = new File(c60.f5764a.d(this.f7198a, "kr-script"));
        if (!file.exists()) {
            file.mkdirs();
        }
        String strD = c60.f5764a.d(this.f7198a, "kr-script/outside_file.cache");
        String strA = new fb0(this.f7198a).a();
        s60.f7366a.a("cp -f \"" + str + "\" \"" + strD + "\"\nchmod 777 \"" + strD + "\"\nchown " + strA + ':' + strA + " \"" + strD + "\"\n");
        File file2 = new File(strD);
        if (file2.exists() && file2.canRead()) {
            return new FileInputStream(file2);
        }
        return null;
    }
}
