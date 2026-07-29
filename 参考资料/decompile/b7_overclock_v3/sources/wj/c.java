package wj;

import kotlin.contracts.InvocationKind;
import kotlin.u;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@bk.b
@v0(version = "1.3")
@f
public interface c {

    public static final class a {
        public static /* synthetic */ wj.a a(c cVar, u uVar, InvocationKind invocationKind, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i10 & 2) != 0) {
                invocationKind = InvocationKind.UNKNOWN;
            }
            return cVar.d(uVar, invocationKind);
        }
    }

    @bk.b
    @k
    g a();

    @bk.b
    @k
    g b(@l Object obj);

    @bk.b
    @k
    h c();

    @bk.b
    @k
    <R> wj.a d(@k u<? extends R> uVar, @k InvocationKind invocationKind);
}
