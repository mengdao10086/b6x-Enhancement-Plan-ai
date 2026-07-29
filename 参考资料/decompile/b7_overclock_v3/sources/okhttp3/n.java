package okhttp3;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lokhttp3/n;", "", "Lokhttp3/u;", "url", "", "Lokhttp3/m;", "cookies", "Lkotlin/z1;", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f43924a = a.f43926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final n f43925b = new a.C0496a();

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lokhttp3/n$a;", "", "Lokhttp3/n;", "NO_COOKIES", "Lokhttp3/n;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f43926a = new a();

        /* JADX INFO: renamed from: okhttp3.n$a$a, reason: collision with other inner class name */
        @kotlin.d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lokhttp3/n$a$a;", "Lokhttp3/n;", "Lokhttp3/u;", "url", "", "Lokhttp3/m;", "cookies", "Lkotlin/z1;", "a", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0496a implements n {
            @Override // okhttp3.n
            public void a(@yt.k u url, @yt.k List<m> cookies) {
                kotlin.jvm.internal.f0.p(url, "url");
                kotlin.jvm.internal.f0.p(cookies, "cookies");
            }

            @Override // okhttp3.n
            @yt.k
            public List<m> b(@yt.k u url) {
                kotlin.jvm.internal.f0.p(url, "url");
                return CollectionsKt__CollectionsKt.E();
            }
        }
    }

    void a(@yt.k u uVar, @yt.k List<m> list);

    @yt.k
    List<m> b(@yt.k u uVar);
}
