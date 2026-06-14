package a;

import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ga0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(ha0 ha0Var, aa0 aa0Var, HashMap map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReceive");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        ha0Var.onReceive(aa0Var, map);
    }
}
