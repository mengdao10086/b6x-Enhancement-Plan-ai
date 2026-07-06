package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class db2 implements pa2<ea2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k82<CharSequence, Integer, d42<Integer, Integer>> f543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f544a;
    public final int b;

    /* JADX WARN: Multi-variable type inference failed */
    public db2(CharSequence charSequence, int i, int i2, k82<? super CharSequence, ? super Integer, d42<Integer, Integer>> k82Var) {
        f92.d(charSequence, "input");
        f92.d(k82Var, "getNextMatch");
        this.f544a = charSequence;
        this.f5881a = i;
        this.b = i2;
        this.f543a = k82Var;
    }

    @Override // a.pa2
    public Iterator<ea2> iterator() {
        return new cb2(this);
    }
}
