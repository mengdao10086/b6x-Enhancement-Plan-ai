package vh;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.g;
import java.lang.ref.WeakReference;
import q1.a;

/* JADX INFO: loaded from: classes5.dex */
public class a implements a.InterfaceC0540a<Cursor> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f53161f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f53162g = "state_current_selection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f53163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1.a f53164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0620a f53165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f53167e;

    /* JADX INFO: renamed from: vh.a$a, reason: collision with other inner class name */
    public interface InterfaceC0620a {
        void Q();

        void j1(Cursor cursor);
    }

    @Override // q1.a.InterfaceC0540a
    public r1.c<Cursor> a(int i10, Bundle bundle) {
        Context context = this.f53163a.get();
        if (context == null) {
            return null;
        }
        this.f53167e = false;
        return uh.a.e0(context);
    }

    @Override // q1.a.InterfaceC0540a
    public void b(r1.c<Cursor> cVar) {
        if (this.f53163a.get() == null) {
            return;
        }
        this.f53165c.Q();
    }

    public int d() {
        return this.f53166d;
    }

    public void e() {
        this.f53164b.g(1, null, this);
    }

    public void f(g gVar, InterfaceC0620a interfaceC0620a) {
        this.f53163a = new WeakReference<>(gVar);
        this.f53164b = gVar.o3();
        this.f53165c = interfaceC0620a;
    }

    public void g() {
        q1.a aVar = this.f53164b;
        if (aVar != null) {
            aVar.a(1);
        }
        this.f53165c = null;
    }

    @Override // q1.a.InterfaceC0540a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(r1.c<Cursor> cVar, Cursor cursor) {
        if (this.f53163a.get() == null || this.f53167e) {
            return;
        }
        this.f53167e = true;
        this.f53165c.j1(cursor);
    }

    public void i(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f53166d = bundle.getInt(f53162g);
    }

    public void j(Bundle bundle) {
        bundle.putInt(f53162g, this.f53166d);
    }

    public void k(int i10) {
        this.f53166d = i10;
    }
}
