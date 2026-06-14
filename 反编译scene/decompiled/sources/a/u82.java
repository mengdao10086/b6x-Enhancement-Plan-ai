package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class u82 {
    public static final <T> Iterator<T> a(T[] tArr) {
        f92.d(tArr, "array");
        return new t82(tArr);
    }
}
