package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends b0 {
    @bk.f
    public static final <T> T d(z<? extends T> zVar, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(zVar, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return zVar.getValue();
    }

    @yt.k
    public static final <T> z<T> e(T t10) {
        return new InitializedLazyImpl(t10);
    }
}
