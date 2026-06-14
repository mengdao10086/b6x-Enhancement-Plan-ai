package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wa2 extends ua2 {
    public static final <T> Iterable<T> d(pa2<? extends T> pa2Var) {
        f92.d(pa2Var, "$this$asIterable");
        return new va2(pa2Var);
    }

    public static final <T, R> pa2<R> e(pa2<? extends T> pa2Var, g82<? super T, ? extends R> g82Var) {
        f92.d(pa2Var, "$this$map");
        f92.d(g82Var, "transform");
        return new ya2(pa2Var, g82Var);
    }

    public static final <T, C extends Collection<? super T>> C f(pa2<? extends T> pa2Var, C c) {
        f92.d(pa2Var, "$this$toCollection");
        f92.d(c, "destination");
        Iterator<? extends T> it = pa2Var.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> List<T> g(pa2<? extends T> pa2Var) {
        f92.d(pa2Var, "$this$toList");
        return y42.j(h(pa2Var));
    }

    public static final <T> List<T> h(pa2<? extends T> pa2Var) {
        f92.d(pa2Var, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        f(pa2Var, arrayList);
        return arrayList;
    }
}
