package a;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wx0 implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str != null && bc2.o(str, ".sh", false, 2, null);
    }
}
