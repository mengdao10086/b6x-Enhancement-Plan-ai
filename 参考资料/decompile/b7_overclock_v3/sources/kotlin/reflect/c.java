package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public interface c<R> extends b {

    public static final class a {
        @bk.g
        public static /* synthetic */ void a() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void e() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @v0(version = "1.3")
        public static /* synthetic */ void g() {
        }
    }

    @yt.k
    r F0();

    R O0(@yt.k Object... objArr);

    R R(@yt.k Map<KParameter, ? extends Object> map);

    @yt.k
    List<KParameter> b();

    @yt.l
    KVisibility d();

    boolean f();

    @yt.k
    String getName();

    @yt.k
    List<s> getTypeParameters();

    boolean isOpen();

    boolean k();

    boolean m();
}
