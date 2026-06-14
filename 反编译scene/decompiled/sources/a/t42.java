package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t42 extends g92 implements v72<Iterator<? extends Boolean>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean[] f7465a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t42(boolean[] zArr) {
        super(0);
        this.f7465a = zArr;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Iterator<Boolean> i() {
        return v82.a(this.f7465a);
    }
}
