package a;

import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class q72 extends p72 {
    public static final String h(File file) {
        f92.d(file, "$this$extension");
        String name = file.getName();
        f92.c(name, "name");
        return ec2.l0(name, '.', "");
    }
}
