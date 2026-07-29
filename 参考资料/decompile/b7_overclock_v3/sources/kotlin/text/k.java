package kotlin.text;

import java.util.List;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public interface k {

    public static final class a {
        @yt.k
        public static b a(@yt.k k kVar) {
            return new b(kVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final k f38182a;

        public b(@yt.k k match) {
            f0.p(match, "match");
            this.f38182a = match;
        }

        @bk.f
        public final String a() {
            return k().b().get(1);
        }

        @bk.f
        public final String b() {
            return k().b().get(10);
        }

        @bk.f
        public final String c() {
            return k().b().get(2);
        }

        @bk.f
        public final String d() {
            return k().b().get(3);
        }

        @bk.f
        public final String e() {
            return k().b().get(4);
        }

        @bk.f
        public final String f() {
            return k().b().get(5);
        }

        @bk.f
        public final String g() {
            return k().b().get(6);
        }

        @bk.f
        public final String h() {
            return k().b().get(7);
        }

        @bk.f
        public final String i() {
            return k().b().get(8);
        }

        @bk.f
        public final String j() {
            return k().b().get(9);
        }

        @yt.k
        public final k k() {
            return this.f38182a;
        }

        @yt.k
        public final List<String> l() {
            return this.f38182a.b().subList(1, this.f38182a.b().size());
        }
    }

    @yt.k
    b a();

    @yt.k
    List<String> b();

    @yt.k
    i c();

    @yt.k
    qk.m d();

    @yt.k
    String getValue();

    @yt.l
    k next();
}
