package a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class x42 {
    public static final <T> Object[] a(T[] tArr, boolean z) {
        f92.d(tArr, "$this$copyToArrayOfAny");
        if (z && f92.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        f92.c(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <T> List<T> b(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        f92.c(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }
}
