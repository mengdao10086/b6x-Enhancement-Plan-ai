package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ta2 extends ra2 {
    public static final <T> pa2<T> a(Iterator<? extends T> it) {
        f92.d(it, "$this$asSequence");
        return b(new sa2(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> pa2<T> b(pa2<? extends T> pa2Var) {
        f92.d(pa2Var, "$this$constrainOnce");
        return pa2Var instanceof ma2 ? pa2Var : new ma2(pa2Var);
    }

    public static final <T> pa2<T> c(v72<? extends T> v72Var, g82<? super T, ? extends T> g82Var) {
        f92.d(v72Var, "seedFunction");
        f92.d(g82Var, "nextFunction");
        return new oa2(v72Var, g82Var);
    }
}
