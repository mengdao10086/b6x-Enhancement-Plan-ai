package a;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g52<T> implements pa2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f6173a;

    public g52(Iterable iterable) {
        this.f6173a = iterable;
    }

    @Override // a.pa2
    public Iterator<T> iterator() {
        return this.f6173a.iterator();
    }
}
