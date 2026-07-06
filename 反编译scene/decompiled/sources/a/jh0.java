package a;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jh0 implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jh0 f6509a = new jh0();

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        f92.c(file, "name");
        String strH = q72.h(file);
        if (strH == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strH.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        return f92.a(lowerCase, "apk");
    }
}
