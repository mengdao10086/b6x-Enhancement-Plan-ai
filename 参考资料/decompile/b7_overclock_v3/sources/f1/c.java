package f1;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import g.p0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f27919c;

    public c(@p0 a aVar, File file) {
        super(aVar);
        this.f27919c = file;
    }

    public static boolean w(File file) {
        File[] fileArrListFiles = file.listFiles();
        boolean zW = true;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    zW &= w(file2);
                }
                if (!file2.delete()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to delete ");
                    sb2.append(file2);
                    zW = false;
                }
            }
        }
        return zW;
    }

    public static String x(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return DfuBaseService.MIME_TYPE_OCTET_STREAM;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(iLastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : DfuBaseService.MIME_TYPE_OCTET_STREAM;
    }

    @Override // f1.a
    public boolean a() {
        return this.f27919c.canRead();
    }

    @Override // f1.a
    public boolean b() {
        return this.f27919c.canWrite();
    }

    @Override // f1.a
    @p0
    public a c(String str) {
        File file = new File(this.f27919c, str);
        if (file.isDirectory() || file.mkdir()) {
            return new c(this, file);
        }
        return null;
    }

    @Override // f1.a
    @p0
    public a d(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + j3.b.f36044h + extensionFromMimeType;
        }
        File file = new File(this.f27919c, str2);
        try {
            file.createNewFile();
            return new c(this, file);
        } catch (IOException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to createFile: ");
            sb2.append(e10);
            return null;
        }
    }

    @Override // f1.a
    public boolean e() {
        w(this.f27919c);
        return this.f27919c.delete();
    }

    @Override // f1.a
    public boolean f() {
        return this.f27919c.exists();
    }

    @Override // f1.a
    public String k() {
        return this.f27919c.getName();
    }

    @Override // f1.a
    @p0
    public String m() {
        if (this.f27919c.isDirectory()) {
            return null;
        }
        return x(this.f27919c.getName());
    }

    @Override // f1.a
    public Uri n() {
        return Uri.fromFile(this.f27919c);
    }

    @Override // f1.a
    public boolean o() {
        return this.f27919c.isDirectory();
    }

    @Override // f1.a
    public boolean q() {
        return this.f27919c.isFile();
    }

    @Override // f1.a
    public boolean r() {
        return false;
    }

    @Override // f1.a
    public long s() {
        return this.f27919c.lastModified();
    }

    @Override // f1.a
    public long t() {
        return this.f27919c.length();
    }

    @Override // f1.a
    public a[] u() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = this.f27919c.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                arrayList.add(new c(this, file));
            }
        }
        return (a[]) arrayList.toArray(new a[arrayList.size()]);
    }

    @Override // f1.a
    public boolean v(String str) {
        File file = new File(this.f27919c.getParentFile(), str);
        if (!this.f27919c.renameTo(file)) {
            return false;
        }
        this.f27919c = file;
        return true;
    }
}
