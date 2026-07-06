package a;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sa2<T> implements pa2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f7378a;

    public sa2(Iterator it) {
        this.f7378a = it;
    }

    @Override // a.pa2
    public Iterator<T> iterator() {
        return this.f7378a;
    }
}
