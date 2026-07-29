package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public interface o<T> extends kotlin.coroutines.c<T> {

    public static final class a {
        public static /* synthetic */ boolean a(o oVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return oVar.d(th2);
        }

        public static /* synthetic */ Object b(o oVar, Object obj, Object obj2, int i10, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i10 & 2) != 0) {
                obj2 = null;
            }
            return oVar.p(obj, obj2);
        }
    }

    void B(@yt.k ik.l<? super Throwable, kotlin.z1> lVar);

    @yt.l
    @y1
    Object J(@yt.k Throwable th2);

    @s1
    void K(@yt.k CoroutineDispatcher coroutineDispatcher, @yt.k Throwable th2);

    @s1
    void O(@yt.k CoroutineDispatcher coroutineDispatcher, T t10);

    @y1
    void Q();

    @s1
    void R(T t10, @yt.l ik.l<? super Throwable, kotlin.z1> lVar);

    boolean d(@yt.l Throwable th2);

    boolean isActive();

    boolean isCancelled();

    @y1
    void l0(@yt.k Object obj);

    boolean n();

    @yt.l
    @y1
    Object p(T t10, @yt.l Object obj);

    @yt.l
    @y1
    Object w(T t10, @yt.l Object obj, @yt.l ik.l<? super Throwable, kotlin.z1> lVar);
}
