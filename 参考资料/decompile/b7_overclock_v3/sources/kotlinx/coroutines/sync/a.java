package kotlinx.coroutines.sync;

import kotlin.DeprecationLevel;
import kotlin.k;
import kotlin.z1;
import kotlinx.coroutines.selects.g;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public interface a {

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.a$a, reason: collision with other inner class name */
    public static final class C0438a {
        @k(level = DeprecationLevel.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ Object b(a aVar, Object obj, kotlin.coroutines.c cVar, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            return aVar.e(obj, cVar);
        }

        public static /* synthetic */ boolean c(a aVar, Object obj, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            return aVar.b(obj);
        }

        public static /* synthetic */ void d(a aVar, Object obj, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            aVar.f(obj);
        }
    }

    boolean b(@l Object obj);

    boolean c();

    @l
    Object e(@l Object obj, @yt.k kotlin.coroutines.c<? super z1> cVar);

    void f(@l Object obj);

    boolean g(@yt.k Object obj);

    @yt.k
    g<Object, a> h();
}
