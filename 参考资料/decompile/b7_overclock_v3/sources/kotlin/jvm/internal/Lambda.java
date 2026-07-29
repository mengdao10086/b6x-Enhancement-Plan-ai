package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Lambda<R> implements b0<R>, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.b0
    public int h() {
        return this.arity;
    }

    @yt.k
    public String toString() {
        String strX = n0.x(this);
        f0.o(strX, "renderLambdaToString(this)");
        return strX;
    }
}
