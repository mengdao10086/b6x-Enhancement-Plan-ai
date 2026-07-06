package a;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class zn {
    public static <T extends kn & yn> zn b(T t) {
        return new ao(t, t.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
