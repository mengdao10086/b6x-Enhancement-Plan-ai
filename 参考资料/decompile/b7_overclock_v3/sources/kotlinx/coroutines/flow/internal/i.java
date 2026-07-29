package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@y1
public interface i<T> extends kotlinx.coroutines.flow.e<T> {

    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.e a(i iVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i11 & 1) != 0) {
                coroutineContext = EmptyCoroutineContext.f37755a;
            }
            if ((i11 & 2) != 0) {
                i10 = -3;
            }
            if ((i11 & 4) != 0) {
                bufferOverflow = BufferOverflow.SUSPEND;
            }
            return iVar.c(coroutineContext, i10, bufferOverflow);
        }
    }

    @yt.k
    kotlinx.coroutines.flow.e<T> c(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow);
}
