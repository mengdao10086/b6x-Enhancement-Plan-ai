package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class x52 implements i62 {
    public final j62<?> key;

    public x52(j62<?> j62Var) {
        f92.d(j62Var, "key");
        this.key = j62Var;
    }

    @Override // a.l62
    public <R> R fold(R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        f92.d(k82Var, "operation");
        return (R) h62.a(this, r, k82Var);
    }

    @Override // a.i62, a.l62
    public <E extends i62> E get(j62<E> j62Var) {
        f92.d(j62Var, "key");
        return (E) h62.b(this, j62Var);
    }

    @Override // a.i62
    public j62<?> getKey() {
        return this.key;
    }

    @Override // a.l62
    public l62 minusKey(j62<?> j62Var) {
        f92.d(j62Var, "key");
        return h62.c(this, j62Var);
    }

    @Override // a.l62
    public l62 plus(l62 l62Var) {
        f92.d(l62Var, "context");
        return h62.d(this, l62Var);
    }
}
