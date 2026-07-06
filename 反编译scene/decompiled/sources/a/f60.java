package a;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ZipOutputStream f856a;

    public f60(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "zipOutPath");
        this.f6078a = context;
        this.f855a = str;
        new HashSet();
        File file = new File(this.f855a);
        if (file.exists()) {
            file.delete();
        }
        this.f856a = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.f855a)));
    }

    public final void a(String str, InputStream inputStream) throws IOException {
        f92.d(str, "fileName");
        f92.d(inputStream, "content");
        this.f856a.putNextEntry(d(str));
        try {
            j72.b(inputStream, this.f856a, 0, 2, null);
            k72.a(inputStream, null);
            this.f856a.closeEntry();
        } finally {
        }
    }

    public final void b(String str, String str2) throws IOException {
        f92.d(str, "fileName");
        f92.d(str2, "content");
        this.f856a.putNextEntry(d(str));
        ZipOutputStream zipOutputStream = this.f856a;
        byte[] bytes = str2.getBytes(bb2.f5692a);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        zipOutputStream.write(bytes);
        this.f856a.closeEntry();
    }

    public final void c(String str, String str2) throws IOException {
        f92.d(str, "fileName");
        f92.d(str2, "sourceFilePath");
        File file = new File(str2);
        if (file.canRead()) {
            a(str, new FileInputStream(file));
            return;
        }
        String strD = c60.f5764a.d(this.f6078a, "zip_copy_temp");
        y60.f7952a.a(str2, strD);
        File file2 = new File(strD);
        FileInputStream fileInputStream = new FileInputStream(file2);
        a(str, fileInputStream);
        fileInputStream.close();
        file2.delete();
    }

    public final ZipEntry d(String str) {
        if (bc2.x(str, "/", false, 2, null)) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(1);
            f92.c(str, "(this as java.lang.String).substring(startIndex)");
        }
        return new ZipEntry(str);
    }

    public final boolean e() throws IOException {
        f();
        if (!e60.f698a.l(this.f855a)) {
            return false;
        }
        new File(this.f855a).delete();
        return true;
    }

    public final void f() throws IOException {
        b("META-INF/com/google/android/update-script", "#MAGISK");
        b("META-INF/com/google/android/update-binary", "#!/sbin/sh\n\n#################\n# Initialization\n#################\n\numask 022\n\n# echo before loading util_functions\nui_print() { echo \"$1\"; }\n\nrequire_new_magisk() {\n  ui_print \"*******************************\"\n  ui_print \" Please install Magisk v20.4+! \"\n  ui_print \"*******************************\"\n  exit 1\n}\n\n#########################\n# Load util_functions.sh\n#########################\n\nOUTFD=$2\nZIPFILE=$3\n\nmount /data 2>/dev/null\n\n[ -f /data/adb/magisk/util_functions.sh ] || require_new_magisk\n. /data/adb/magisk/util_functions.sh\n[ $MAGISK_VER_CODE -lt 20400 ] && require_new_magisk\n\ninstall_module\nexit 0\n");
        this.f856a.finish();
        this.f856a.close();
    }
}
