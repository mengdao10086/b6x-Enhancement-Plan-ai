package a;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h52<T> extends g92 implements v72<Iterator<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f6278a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h52(Iterable iterable) {
        super(0);
        this.f6278a = iterable;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Iterator<T> i() {
        return this.f6278a.iterator();
    }
}
