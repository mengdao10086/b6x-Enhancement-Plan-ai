package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m62 implements l62, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m62 f6776a = new m62();

    @Override // a.l62
    public <R> R fold(R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        f92.d(k82Var, "operation");
        return r;
    }

    @Override // a.l62
    public <E extends i62> E get(j62<E> j62Var) {
        f92.d(j62Var, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // a.l62
    public l62 minusKey(j62<?> j62Var) {
        f92.d(j62Var, "key");
        return this;
    }

    @Override // a.l62
    public l62 plus(l62 l62Var) {
        f92.d(l62Var, "context");
        return l62Var;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
