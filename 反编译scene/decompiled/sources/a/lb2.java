package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lb2 extends g92 implements v72<gb2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nb2 f6690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CharSequence f1782a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lb2(nb2 nb2Var, CharSequence charSequence, int i) {
        super(0);
        this.f6690a = nb2Var;
        this.f1782a = charSequence;
        this.b = i;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final gb2 i() {
        return this.f6690a.b(this.f1782a, this.b);
    }
}
