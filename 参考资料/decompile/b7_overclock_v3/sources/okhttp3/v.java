package okhttp3;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0002\u0007\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lokhttp3/v;", "", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "b", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final b f43981b = b.f43982a;

    @kotlin.d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0013\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0015"}, d2 = {"Lokhttp3/v$a;", "", "Lokhttp3/b0;", i1.a.f31577d5, SocialConstants.TYPE_REQUEST, "Lokhttp3/d0;", "e", "Lokhttp3/i;", "f", "Lokhttp3/e;", f0.v.E0, "", "h", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "d", "b", "g", "c", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        @yt.k
        b0 T();

        @yt.k
        a a(int i10, @yt.k TimeUnit timeUnit);

        int b();

        int c();

        @yt.k
        e call();

        @yt.k
        a d(int i10, @yt.k TimeUnit timeUnit);

        @yt.k
        d0 e(@yt.k b0 b0Var) throws IOException;

        @yt.l
        i f();

        @yt.k
        a g(int i10, @yt.k TimeUnit timeUnit);

        int h();
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\n\u001a\u00020\t2#\b\u0004\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lokhttp3/v$b;", "", "Lkotlin/Function1;", "Lokhttp3/v$a;", "Lkotlin/n0;", "name", "chain", "Lokhttp3/d0;", "block", "Lokhttp3/v;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f43982a = new b();

        @kotlin.d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lokhttp3/v$a;", "it", "Lokhttp3/d0;", "intercept", "(Lokhttp3/v$a;)Lokhttp3/d0;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        public static final class a implements v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ik.l<a, d0> f43983a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(ik.l<? super a, d0> lVar) {
                this.f43983a = lVar;
            }

            @Override // okhttp3.v
            @yt.k
            public final d0 intercept(@yt.k a it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return this.f43983a.i(it2);
            }
        }

        @yt.k
        public final v a(@yt.k ik.l<? super a, d0> block) {
            kotlin.jvm.internal.f0.p(block, "block");
            return new a(block);
        }
    }

    @yt.k
    d0 intercept(@yt.k a aVar) throws IOException;
}
