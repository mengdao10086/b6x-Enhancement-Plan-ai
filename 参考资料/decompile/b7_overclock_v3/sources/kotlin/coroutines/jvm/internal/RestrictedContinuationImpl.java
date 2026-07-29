package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(@l c<Object> cVar) {
        super(cVar);
        if (cVar != null) {
            if (!(cVar.b() == EmptyCoroutineContext.f37755a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.c
    @k
    public CoroutineContext b() {
        return EmptyCoroutineContext.f37755a;
    }
}
