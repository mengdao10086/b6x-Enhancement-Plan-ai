package a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ma2<T> implements pa2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<pa2<T>> f6788a;

    public ma2(pa2<? extends T> pa2Var) {
        f92.d(pa2Var, "sequence");
        this.f6788a = new AtomicReference<>(pa2Var);
    }

    @Override // a.pa2
    public Iterator<T> iterator() {
        pa2<T> andSet = this.f6788a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
