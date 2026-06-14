package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class k62 extends g92 implements k82<l62, i62, l62> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k62 f6578a = new k62();

    public k62() {
        super(2);
    }

    @Override // a.k82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final l62 d(l62 l62Var, i62 i62Var) {
        f92.d(l62Var, "acc");
        f92.d(i62Var, "element");
        l62 l62VarMinusKey = l62Var.minusKey(i62Var.getKey());
        if (l62VarMinusKey == m62.f6776a) {
            return i62Var;
        }
        e62 e62Var = (e62) l62VarMinusKey.get(e62.f5972a);
        if (e62Var == null) {
            return new a62(l62VarMinusKey, i62Var);
        }
        l62 l62VarMinusKey2 = l62VarMinusKey.minusKey(e62.f5972a);
        return l62VarMinusKey2 == m62.f6776a ? new a62(i62Var, e62Var) : new a62(new a62(l62VarMinusKey2, i62Var), e62Var);
    }
}
