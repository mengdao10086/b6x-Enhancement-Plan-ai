package a;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a11 implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c11 f5558a;

    public a11(c11 c11Var) {
        this.f5558a = c11Var;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return this.f5558a.f5749a.c ? file.isDirectory() : file.exists() && (!file.isFile() || this.f5558a.f5749a.f1715a == null || this.f5558a.f5749a.f1715a.isEmpty() || file.getName().endsWith(this.f5558a.f5749a.f1715a));
    }
}
