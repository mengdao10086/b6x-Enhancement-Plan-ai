package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.z1;
import kotlinx.coroutines.channels.j;

/* JADX INFO: loaded from: classes5.dex */
public final class i {
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ g a(int i10) {
        return d(i10, null, null, 6, null);
    }

    @yt.k
    public static final <E> g<E> b(int i10, @yt.k BufferOverflow bufferOverflow, @yt.l ik.l<? super E, z1> lVar) {
        g<E> bufferedChannel;
        if (i10 != -2) {
            if (i10 == -1) {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new n(1, BufferOverflow.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i10 != 0) {
                return i10 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i10, lVar) : new n(i10, bufferOverflow, lVar) : new BufferedChannel(Integer.MAX_VALUE, lVar);
            }
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(0, lVar) : new n<>(1, bufferOverflow, lVar);
        } else {
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(g.f38366y2.a(), lVar) : new n<>(1, bufferOverflow, lVar);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ g c(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return a(i10);
    }

    public static /* synthetic */ g d(int i10, BufferOverflow bufferOverflow, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return b(i10, bufferOverflow, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T e(@yt.k Object obj, @yt.k ik.l<? super Throwable, ? extends T> lVar) {
        return obj instanceof j.c ? lVar.i(j.f(obj)) : obj;
    }

    @yt.k
    public static final <T> Object f(@yt.k Object obj, @yt.k ik.l<? super Throwable, z1> lVar) {
        if (obj instanceof j.a) {
            lVar.i(j.f(obj));
        }
        return obj;
    }

    @yt.k
    public static final <T> Object g(@yt.k Object obj, @yt.k ik.l<? super Throwable, z1> lVar) {
        if (obj instanceof j.c) {
            lVar.i(j.f(obj));
        }
        return obj;
    }

    @yt.k
    public static final <T> Object h(@yt.k Object obj, @yt.k ik.l<? super T, z1> lVar) {
        if (!(obj instanceof j.c)) {
            lVar.i(obj);
        }
        return obj;
    }
}
