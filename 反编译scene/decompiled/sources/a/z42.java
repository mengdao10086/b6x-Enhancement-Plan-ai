package a;

import java.util.Collection;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class z42 extends y42 {
    public static final <T> int m(Iterable<? extends T> iterable, int i) {
        f92.d(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
