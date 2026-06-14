package a;

import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class v52 extends u52 {
    public static final <T> Set<T> b() {
        return m52.f6772a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        f92.d(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        return size != 0 ? size != 1 ? set : u52.a(set.iterator().next()) : b();
    }

    public static final <T> Set<T> d(T... tArr) {
        f92.d(tArr, "elements");
        return tArr.length > 0 ? u42.M(tArr) : b();
    }
}
