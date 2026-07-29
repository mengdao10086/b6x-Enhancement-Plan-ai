package pi;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class c {
    public static <T> void a(Set<a<T>> set, a<T> aVar) {
        if (set != null) {
            for (a<T> aVar2 : set) {
                if (aVar2.equals(aVar)) {
                    set.remove(aVar2);
                } else if (aVar2 instanceof h) {
                    a<T> aVarA = aVar2;
                    while (aVarA instanceof h) {
                        aVarA = ((h) aVarA).a();
                    }
                    if (aVarA == null || aVarA.equals(aVar)) {
                        set.remove(aVar2);
                    }
                }
            }
        }
    }
}
