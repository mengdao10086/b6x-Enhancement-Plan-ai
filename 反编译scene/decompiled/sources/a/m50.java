package a;

import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m50 {
    public m50() {
    }

    public /* synthetic */ m50(b92 b92Var) {
        this();
    }

    public final n50 a(String str) {
        f92.d(str, "path");
        n50 n50VarG0 = e50.f677a.G0(str);
        if (n50VarG0 != null) {
            return n50VarG0;
        }
        n50 n50Var = new n50((b92) null);
        File file = new File(str);
        String name = file.getName();
        f92.c(name, "f.name");
        n50Var.k(name);
        String absolutePath = file.getAbsolutePath();
        f92.c(absolutePath, "f.absolutePath");
        n50Var.i(absolutePath);
        n50Var.j(false);
        return n50Var;
    }
}
