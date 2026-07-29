package q1;

import android.os.Bundle;
import androidx.lifecycle.d1;
import androidx.lifecycle.y;
import g.k0;
import g.n0;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import r1.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: q1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0540a<D> {
        @k0
        @n0
        c<D> a(int i10, @p0 Bundle bundle);

        @k0
        void b(@n0 c<D> cVar);

        @k0
        void c(@n0 c<D> cVar, D d10);
    }

    public static void c(boolean z10) {
        b.f47090d = z10;
    }

    @n0
    public static <T extends y & d1> a d(@n0 T t10) {
        return new b(t10, t10.O0());
    }

    @k0
    public abstract void a(int i10);

    @Deprecated
    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @p0
    public abstract <D> c<D> e(int i10);

    public boolean f() {
        return false;
    }

    @k0
    @n0
    public abstract <D> c<D> g(int i10, @p0 Bundle bundle, @n0 InterfaceC0540a<D> interfaceC0540a);

    public abstract void h();

    @k0
    @n0
    public abstract <D> c<D> i(int i10, @p0 Bundle bundle, @n0 InterfaceC0540a<D> interfaceC0540a);
}
