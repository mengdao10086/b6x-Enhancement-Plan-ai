package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;
import yt.k;
import yt.l;
import zj.b;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
@v0(version = "1.3")
public abstract class ContinuationImpl extends BaseContinuationImpl {

    @l
    private final CoroutineContext _context;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public transient c<Object> f37766a;

    public ContinuationImpl(@l c<Object> cVar, @l CoroutineContext coroutineContext) {
        super(cVar);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.c
    @k
    public CoroutineContext b() {
        CoroutineContext coroutineContext = this._context;
        f0.m(coroutineContext);
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void u0() {
        c<?> cVar = this.f37766a;
        if (cVar != null && cVar != this) {
            CoroutineContext.a aVarC = b().c(d.f37759u2);
            f0.m(aVarC);
            ((d) aVarC).m(cVar);
        }
        this.f37766a = b.f58597a;
    }

    @k
    public final c<Object> v0() {
        c<Object> cVarZ = this.f37766a;
        if (cVarZ == null) {
            d dVar = (d) b().c(d.f37759u2);
            if (dVar == null || (cVarZ = dVar.z(this)) == null) {
                cVarZ = this;
            }
            this.f37766a = cVarZ;
        }
        return cVarZ;
    }

    public ContinuationImpl(@l c<Object> cVar) {
        this(cVar, cVar != null ? cVar.b() : null);
    }
}
