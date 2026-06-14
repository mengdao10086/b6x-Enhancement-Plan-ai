package a;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class va2<T> implements Iterable<T>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pa2 f7675a;

    public va2(pa2 pa2Var) {
        this.f7675a = pa2Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f7675a.iterator();
    }
}
