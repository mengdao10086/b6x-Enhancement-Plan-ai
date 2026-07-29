package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class AtomicFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f24728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f24729b;

    public AtomicFile(File file) {
        this.f24728a = file;
        this.f24729b = new File(file.getPath() + ".bak");
    }

    private static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i10 = fileInputStream2.read(bArr);
                        if (i10 <= 0) {
                            fileInputStream2.close();
                            fileOutputStream.close();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("comsum time:");
                            sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i10);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i10);
                        sb3.append("");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public void delete() {
        this.f24728a.delete();
        this.f24729b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f24728a.delete();
                this.f24729b.renameTo(this.f24728a);
            } catch (IOException e10) {
                SLog.error(UmengText.CACHE.CACHEFILE, e10);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f24729b.delete();
            } catch (IOException e10) {
                SLog.error(UmengText.CACHE.CACHEFILE, e10);
            }
        }
    }

    public File getBaseFile() {
        return this.f24728a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f24729b.exists()) {
            this.f24728a.delete();
            this.f24729b.renameTo(this.f24728a);
        }
        return new FileInputStream(this.f24728a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream fileInputStreamOpenRead = openRead();
        try {
            byte[] bArr = new byte[fileInputStreamOpenRead.available()];
            int i10 = 0;
            while (true) {
                int i11 = fileInputStreamOpenRead.read(bArr, i10, bArr.length - i10);
                if (i11 <= 0) {
                    return bArr;
                }
                i10 += i11;
                int iAvailable = fileInputStreamOpenRead.available();
                if (iAvailable > bArr.length - i10) {
                    byte[] bArr2 = new byte[iAvailable + i10];
                    System.arraycopy(bArr, 0, bArr2, 0, i10);
                    bArr = bArr2;
                }
            }
        } finally {
            fileInputStreamOpenRead.close();
        }
    }

    public FileOutputStream startWrite(boolean z10) throws Throwable {
        if (this.f24728a.exists()) {
            if (this.f24729b.exists()) {
                this.f24728a.delete();
            } else if (this.f24728a.renameTo(this.f24729b)) {
                a(this.f24729b, this.f24728a);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Couldn't rename file ");
                sb2.append(this.f24728a);
                sb2.append(" to backup file ");
                sb2.append(this.f24729b);
            }
        }
        try {
            return new FileOutputStream(this.f24728a, z10);
        } catch (FileNotFoundException e10) {
            if (!this.f24728a.getParentFile().mkdirs()) {
                SLog.error(UmengText.CACHE.CACHEFILE, e10);
            }
            try {
                return new FileOutputStream(this.f24728a, z10);
            } catch (FileNotFoundException unused) {
                SLog.error(UmengText.CACHE.CACHEFILE, e10);
                return null;
            }
        }
    }

    public static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e10) {
            SLog.error(UmengText.CACHE.CACHEFILE, e10);
            return false;
        }
    }
}
