package a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class c52 extends b52 {
    public static final <T> void n(List<T> list, Comparator<? super T> comparator) {
        f92.d(list, "$this$sortWith");
        f92.d(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
