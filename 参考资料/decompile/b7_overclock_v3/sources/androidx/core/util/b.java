package androidx.core.util;

import g.n0;
import g.p0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4709d = "AtomicFile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f4710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f4711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f4712c;

    public b(@n0 File file) {
        this.f4710a = file;
        this.f4711b = new File(file.getPath() + ".new");
        this.f4712c = new File(file.getPath() + ".bak");
    }

    public static void g(@n0 File file, @n0 File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to delete file which is a directory ");
            sb2.append(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Failed to rename ");
        sb3.append(file);
        sb3.append(" to ");
        sb3.append(file2);
    }

    public static boolean i(@n0 FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a() {
        this.f4710a.delete();
        this.f4711b.delete();
        this.f4712c.delete();
    }

    public void b(@p0 FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        i(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        if (this.f4711b.delete()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to delete new file ");
        sb2.append(this.f4711b);
    }

    public void c(@p0 FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        i(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused) {
        }
        g(this.f4711b, this.f4710a);
    }

    @n0
    public File d() {
        return this.f4710a;
    }

    @n0
    public FileInputStream e() throws FileNotFoundException {
        if (this.f4712c.exists()) {
            g(this.f4712c, this.f4710a);
        }
        if (this.f4711b.exists() && this.f4710a.exists() && !this.f4711b.delete()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to delete outdated new file ");
            sb2.append(this.f4711b);
        }
        return new FileInputStream(this.f4710a);
    }

    @n0
    public byte[] f() throws IOException {
        FileInputStream fileInputStreamE = e();
        try {
            byte[] bArr = new byte[fileInputStreamE.available()];
            int i10 = 0;
            while (true) {
                int i11 = fileInputStreamE.read(bArr, i10, bArr.length - i10);
                if (i11 <= 0) {
                    return bArr;
                }
                i10 += i11;
                int iAvailable = fileInputStreamE.available();
                if (iAvailable > bArr.length - i10) {
                    byte[] bArr2 = new byte[iAvailable + i10];
                    System.arraycopy(bArr, 0, bArr2, 0, i10);
                    bArr = bArr2;
                }
            }
        } finally {
            fileInputStreamE.close();
        }
    }

    @n0
    public FileOutputStream h() throws IOException {
        if (this.f4712c.exists()) {
            g(this.f4712c, this.f4710a);
        }
        try {
            return new FileOutputStream(this.f4711b);
        } catch (FileNotFoundException unused) {
            if (!this.f4711b.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.f4711b);
            }
            try {
                return new FileOutputStream(this.f4711b);
            } catch (FileNotFoundException e10) {
                throw new IOException("Failed to create new file " + this.f4711b, e10);
            }
        }
    }
}
