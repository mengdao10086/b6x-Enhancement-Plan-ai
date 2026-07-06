package a;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n42<E> extends g92 implements g82<E, CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o42 f6874a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n42(o42 o42Var) {
        super(1);
        this.f6874a = o42Var;
    }

    @Override // a.g82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CharSequence f(E e) {
        return e == this.f6874a ? "(this Collection)" : String.valueOf(e);
    }
}
