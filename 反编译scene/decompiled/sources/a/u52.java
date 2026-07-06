package a;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class u52 {
    public static final <T> Set<T> a(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        f92.c(setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }
}
