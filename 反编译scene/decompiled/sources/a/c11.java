package a;

import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c11 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l11 f5749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ File f316a;

    public c11(l11 l11Var, File file) {
        this.f5749a = l11Var;
        this.f316a = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        File parentFile = this.f316a.getParentFile();
        int i = 0;
        if (parentFile != null) {
            parentFile.getAbsolutePath();
            this.f5749a.f1717b = parentFile.exists() && parentFile.canRead();
        } else {
            this.f5749a.f1717b = false;
        }
        if (this.f316a.exists() && this.f316a.canRead()) {
            File[] fileArrListFiles = this.f316a.listFiles(new a11(this));
            while (i < fileArrListFiles.length) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < fileArrListFiles.length; i3++) {
                    if (fileArrListFiles[i3].isDirectory() && fileArrListFiles[i].isFile()) {
                        File file = fileArrListFiles[i];
                        fileArrListFiles[i] = fileArrListFiles[i3];
                        fileArrListFiles[i3] = file;
                    } else if (fileArrListFiles[i3].isDirectory() == fileArrListFiles[i].isDirectory() && fileArrListFiles[i3].getName().toLowerCase().compareTo(fileArrListFiles[i].getName().toLowerCase()) < 0) {
                        File file2 = fileArrListFiles[i];
                        fileArrListFiles[i] = fileArrListFiles[i3];
                        fileArrListFiles[i3] = file2;
                    }
                }
                i = i2;
            }
            this.f5749a.f1716a = fileArrListFiles;
        }
        this.f5749a.f1713a = this.f316a;
        this.f5749a.f1712a.post(new b11(this));
    }
}
