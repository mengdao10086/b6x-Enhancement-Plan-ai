package vh;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.g;
import com.zhihu.matisse.internal.entity.Album;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;
import q1.a;

/* JADX INFO: loaded from: classes5.dex */
public class b implements a.InterfaceC0540a<Cursor> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f53168d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f53169e = "args_album";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f53170f = "args_enable_capture";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f53171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1.a f53172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f53173c;

    public interface a {
        void G2(Cursor cursor);

        void L1();
    }

    @Override // q1.a.InterfaceC0540a
    public r1.c<Cursor> a(int i10, Bundle bundle) {
        Album album;
        Context context = this.f53171a.get();
        if (context == null || (album = (Album) bundle.getParcelable(f53169e)) == null) {
            return null;
        }
        boolean z10 = false;
        if (album.s() && bundle.getBoolean(f53170f, false)) {
            z10 = true;
        }
        return uh.b.f0(context, album, z10);
    }

    @Override // q1.a.InterfaceC0540a
    public void b(r1.c<Cursor> cVar) {
        if (this.f53171a.get() == null) {
            return;
        }
        this.f53173c.L1();
    }

    public void d(@p0 Album album) {
        e(album, false);
    }

    public void e(@p0 Album album, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f53169e, album);
        bundle.putBoolean(f53170f, z10);
        this.f53172b.g(2, bundle, this);
    }

    public void f(@n0 g gVar, @n0 a aVar) {
        this.f53171a = new WeakReference<>(gVar);
        this.f53172b = gVar.o3();
        this.f53173c = aVar;
    }

    public void g() {
        q1.a aVar = this.f53172b;
        if (aVar != null) {
            aVar.a(2);
        }
        this.f53173c = null;
    }

    @Override // q1.a.InterfaceC0540a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(r1.c<Cursor> cVar, Cursor cursor) {
        if (this.f53171a.get() == null) {
            return;
        }
        this.f53173c.G2(cursor);
    }
}
