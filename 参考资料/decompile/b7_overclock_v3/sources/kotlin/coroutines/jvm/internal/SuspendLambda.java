package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.v0;
import yt.k;
import yt.l;
import zj.j;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public abstract class SuspendLambda extends ContinuationImpl implements b0<Object>, j {
    private final int arity;

    public SuspendLambda(int i10, @l c<Object> cVar) {
        super(cVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.b0
    public int h() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public String toString() {
        if (W() != null) {
            return super.toString();
        }
        String strW = n0.w(this);
        f0.o(strW, "renderLambdaToString(this)");
        return strW;
    }

    public SuspendLambda(int i10) {
        this(i10, null);
    }
}
