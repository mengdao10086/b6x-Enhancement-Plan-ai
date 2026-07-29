package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.v0;
import kotlin.z1;
import yj.b;
import yt.k;
import yt.l;
import zj.e;
import zj.f;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public abstract class BaseContinuationImpl implements c<Object>, zj.c, Serializable {

    @l
    private final c<Object> completion;

    public BaseContinuationImpl(@l c<Object> cVar) {
        this.completion = cVar;
    }

    @Override // zj.c
    @l
    public StackTraceElement D() {
        return e.e(this);
    }

    @k
    public c<z1> M(@l Object obj, @k c<?> completion) {
        f0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @k
    public c<z1> T(@k c<?> completion) {
        f0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @l
    public final c<Object> W() {
        return this.completion;
    }

    @l
    public abstract Object q0(@k Object obj);

    @Override // zj.c
    @l
    public zj.c r() {
        c<Object> cVar = this.completion;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }

    @k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object objD = D();
        if (objD == null) {
            objD = getClass().getName();
        }
        sb2.append(objD);
        return sb2.toString();
    }

    public void u0() {
    }

    @Override // kotlin.coroutines.c
    public final void x(@k Object obj) {
        Object objQ0;
        c<Object> cVar = this;
        while (true) {
            f.b(cVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) cVar;
            c<Object> cVar2 = baseContinuationImpl.completion;
            f0.m(cVar2);
            try {
                objQ0 = baseContinuationImpl.q0(obj);
            } catch (Throwable th2) {
                Result.a aVar = Result.f37633a;
                obj = Result.b(u0.a(th2));
            }
            if (objQ0 == b.h()) {
                return;
            }
            Result.a aVar2 = Result.f37633a;
            obj = Result.b(objQ0);
            baseContinuationImpl.u0();
            if (!(cVar2 instanceof BaseContinuationImpl)) {
                cVar2.x(obj);
                return;
            }
            cVar = cVar2;
        }
    }
}
