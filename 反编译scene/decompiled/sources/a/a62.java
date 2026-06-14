package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a62 implements l62, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i62 f5574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l62 f34a;

    public a62(l62 l62Var, i62 i62Var) {
        f92.d(l62Var, "left");
        f92.d(i62Var, "element");
        this.f34a = l62Var;
        this.f5574a = i62Var;
    }

    public final boolean c(i62 i62Var) {
        return f92.a(get(i62Var.getKey()), i62Var);
    }

    public final boolean e(a62 a62Var) {
        while (c(a62Var.f5574a)) {
            l62 l62Var = a62Var.f34a;
            if (!(l62Var instanceof a62)) {
                if (l62Var != null) {
                    return c((i62) l62Var);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            a62Var = (a62) l62Var;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a62) {
                a62 a62Var = (a62) obj;
                if (a62Var.f() != f() || !a62Var.e(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int f() {
        int i = 2;
        a62 a62Var = this;
        while (true) {
            l62 l62Var = a62Var.f34a;
            if (!(l62Var instanceof a62)) {
                l62Var = null;
            }
            a62Var = (a62) l62Var;
            if (a62Var == null) {
                return i;
            }
            i++;
        }
    }

    @Override // a.l62
    public <R> R fold(R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        f92.d(k82Var, "operation");
        return k82Var.d((Object) this.f34a.fold(r, k82Var), this.f5574a);
    }

    @Override // a.l62
    public <E extends i62> E get(j62<E> j62Var) {
        f92.d(j62Var, "key");
        a62 a62Var = this;
        while (true) {
            E e = (E) a62Var.f5574a.get(j62Var);
            if (e != null) {
                return e;
            }
            l62 l62Var = a62Var.f34a;
            if (!(l62Var instanceof a62)) {
                return (E) l62Var.get(j62Var);
            }
            a62Var = (a62) l62Var;
        }
    }

    public int hashCode() {
        return this.f34a.hashCode() + this.f5574a.hashCode();
    }

    @Override // a.l62
    public l62 minusKey(j62<?> j62Var) {
        f92.d(j62Var, "key");
        if (this.f5574a.get(j62Var) != null) {
            return this.f34a;
        }
        l62 l62VarMinusKey = this.f34a.minusKey(j62Var);
        return l62VarMinusKey == this.f34a ? this : l62VarMinusKey == m62.f6776a ? this.f5574a : new a62(l62VarMinusKey, this.f5574a);
    }

    @Override // a.l62
    public l62 plus(l62 l62Var) {
        f92.d(l62Var, "context");
        return g62.a(this, l62Var);
    }

    public String toString() {
        return "[" + ((String) fold("", z52.f8039a)) + "]";
    }
}
