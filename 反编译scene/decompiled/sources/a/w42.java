package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class w42 implements Iterator<Boolean>, s92 {
    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean next() {
        return Boolean.valueOf(b());
    }

    public abstract boolean b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
