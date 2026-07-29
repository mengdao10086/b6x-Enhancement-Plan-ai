package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public interface d<T> extends h, b, g {

    public static final class a {
        @v0(version = "1.3")
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

        @v0(version = "1.1")
        public static /* synthetic */ void g() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void h() {
        }

        @v0(version = "1.4")
        public static /* synthetic */ void i() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void j() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void k() {
        }

        @v0(version = "1.1")
        public static /* synthetic */ void l() {
        }

        @v0(version = "1.5")
        public static /* synthetic */ void m() {
        }
    }

    @yt.k
    List<d<? extends T>> D();

    boolean I();

    boolean J();

    @yt.l
    String K();

    @yt.k
    List<r> M();

    @yt.l
    T O();

    boolean P0();

    boolean W();

    @yt.l
    KVisibility d();

    boolean equals(@yt.l Object obj);

    boolean f();

    @yt.k
    List<s> getTypeParameters();

    int hashCode();

    boolean isOpen();

    boolean k();

    boolean l0();

    @Override // kotlin.reflect.h
    @yt.k
    Collection<c<?>> n();

    @yt.l
    String p();

    @yt.k
    Collection<d<?>> r();

    @yt.k
    Collection<i<T>> x();

    @v0(version = "1.1")
    boolean x0(@yt.l Object obj);

    boolean z();
}
