package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@c2(markerClass = {q.class})
@kotlin.coroutines.g
@v0(version = "1.7")
public abstract class i<T, R> {
    public i() {
    }

    public /* synthetic */ i(kotlin.jvm.internal.u uVar) {
        this();
    }

    @yt.l
    public abstract Object a(T t10, @yt.k kotlin.coroutines.c<? super R> cVar);

    @yt.l
    public abstract <U, S> Object c(@yt.k g<U, S> gVar, U u6, @yt.k kotlin.coroutines.c<? super S> cVar);

    @k(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @t0(expression = "this.callRecursive(value)", imports = {}))
    @yt.k
    public final Void e(@yt.k g<?, ?> gVar, @yt.l Object obj) {
        kotlin.jvm.internal.f0.p(gVar, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
