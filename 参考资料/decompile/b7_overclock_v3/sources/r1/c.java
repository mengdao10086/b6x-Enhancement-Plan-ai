package r1;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.f;
import g.k0;
import g.n0;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class c<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f47708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0550c<D> f47709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b<D> f47710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f47711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f47712e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47713f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f47714g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f47715h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47716i = false;

    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            c.this.p();
        }
    }

    public interface b<D> {
        void a(@n0 c<D> cVar);
    }

    /* JADX INFO: renamed from: r1.c$c, reason: collision with other inner class name */
    public interface InterfaceC0550c<D> {
        void a(@n0 c<D> cVar, @p0 D d10);
    }

    public c(@n0 Context context) {
        this.f47711d = context.getApplicationContext();
    }

    public boolean A() {
        boolean z10 = this.f47715h;
        this.f47715h = false;
        this.f47716i |= z10;
        return z10;
    }

    @k0
    public void B(@n0 InterfaceC0550c<D> interfaceC0550c) {
        InterfaceC0550c<D> interfaceC0550c2 = this.f47709b;
        if (interfaceC0550c2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0550c2 != interfaceC0550c) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f47709b = null;
    }

    @k0
    public void C(@n0 b<D> bVar) {
        b<D> bVar2 = this.f47710c;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (bVar2 != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f47710c = null;
    }

    @k0
    public void a() {
        this.f47713f = true;
        n();
    }

    @k0
    public boolean b() {
        return o();
    }

    public void c() {
        this.f47716i = false;
    }

    @n0
    public String d(@p0 D d10) {
        StringBuilder sb2 = new StringBuilder(64);
        f.a(d10, sb2);
        sb2.append(zc.a.f58317e);
        return sb2.toString();
    }

    @k0
    public void e() {
        b<D> bVar = this.f47710c;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @k0
    public void f(@p0 D d10) {
        InterfaceC0550c<D> interfaceC0550c = this.f47709b;
        if (interfaceC0550c != null) {
            interfaceC0550c.a(this, d10);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f47708a);
        printWriter.print(" mListener=");
        printWriter.println(this.f47709b);
        if (this.f47712e || this.f47715h || this.f47716i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f47712e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f47715h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f47716i);
        }
        if (this.f47713f || this.f47714g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f47713f);
            printWriter.print(" mReset=");
            printWriter.println(this.f47714g);
        }
    }

    @k0
    public void h() {
        q();
    }

    @n0
    public Context i() {
        return this.f47711d;
    }

    public int j() {
        return this.f47708a;
    }

    public boolean k() {
        return this.f47713f;
    }

    public boolean l() {
        return this.f47714g;
    }

    public boolean m() {
        return this.f47712e;
    }

    @k0
    public void n() {
    }

    @k0
    public boolean o() {
        return false;
    }

    @k0
    public void p() {
        if (this.f47712e) {
            h();
        } else {
            this.f47715h = true;
        }
    }

    @k0
    public void q() {
    }

    @k0
    public void r() {
    }

    @k0
    public void s() {
    }

    @k0
    public void t() {
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        f.a(this, sb2);
        sb2.append(" id=");
        sb2.append(this.f47708a);
        sb2.append(zc.a.f58317e);
        return sb2.toString();
    }

    @k0
    public void u(int i10, @n0 InterfaceC0550c<D> interfaceC0550c) {
        if (this.f47709b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f47709b = interfaceC0550c;
        this.f47708a = i10;
    }

    @k0
    public void v(@n0 b<D> bVar) {
        if (this.f47710c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f47710c = bVar;
    }

    @k0
    public void w() {
        r();
        this.f47714g = true;
        this.f47712e = false;
        this.f47713f = false;
        this.f47715h = false;
        this.f47716i = false;
    }

    public void x() {
        if (this.f47716i) {
            p();
        }
    }

    @k0
    public final void y() {
        this.f47712e = true;
        this.f47714g = false;
        this.f47713f = false;
        s();
    }

    @k0
    public void z() {
        this.f47712e = false;
        t();
    }
}
