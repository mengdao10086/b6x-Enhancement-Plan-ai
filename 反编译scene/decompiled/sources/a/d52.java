package a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class d52 extends c52 {
    public static final <T> boolean o(Collection<? super T> collection, Iterable<? extends T> iterable) {
        f92.d(collection, "$this$addAll");
        f92.d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean p(Collection<? super T> collection, T[] tArr) {
        f92.d(collection, "$this$addAll");
        f92.d(tArr, "elements");
        return collection.addAll(s42.b(tArr));
    }

    public static final <T> T q(List<T> list) {
        f92.d(list, "$this$removeLast");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(y42.g(list));
    }
}
