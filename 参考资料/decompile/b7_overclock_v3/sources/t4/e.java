package t4;

import com.bumptech.glide.load.DataSource;
import t4.f;

/* JADX INFO: loaded from: classes2.dex */
public class e<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<?> f50875a = new e<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g<?> f50876b = new a();

    public static class a<R> implements g<R> {
        @Override // t4.g
        public f<R> a(DataSource dataSource, boolean z10) {
            return e.f50875a;
        }
    }

    public static <R> f<R> b() {
        return f50875a;
    }

    public static <R> g<R> c() {
        return (g<R>) f50876b;
    }

    @Override // t4.f
    public boolean a(Object obj, f.a aVar) {
        return false;
    }
}
