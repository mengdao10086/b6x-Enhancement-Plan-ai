package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class y42 extends x42 {
    public static final <T> ArrayList<T> c(T... tArr) {
        f92.d(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new p42(tArr, true));
    }

    public static final <T> Collection<T> d(T[] tArr) {
        f92.d(tArr, "$this$asCollection");
        return new p42(tArr, false);
    }

    public static final <T> List<T> e() {
        return k52.f6576a;
    }

    public static final ea2 f(Collection<?> collection) {
        f92.d(collection, "$this$indices");
        return new ea2(0, collection.size() - 1);
    }

    public static final <T> int g(List<? extends T> list) {
        f92.d(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> h(T... tArr) {
        f92.d(tArr, "elements");
        return tArr.length > 0 ? s42.b(tArr) : e();
    }

    public static final <T> List<T> i(T... tArr) {
        f92.d(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new p42(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> j(List<? extends T> list) {
        f92.d(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : x42.b(list.get(0)) : e();
    }

    public static final void k() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void l() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
