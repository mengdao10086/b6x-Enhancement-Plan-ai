package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface j {

    public interface a {
        void b(@n0 e eVar, boolean z10);

        boolean c(@n0 e eVar);
    }

    void b(e eVar, boolean z10);

    void c(boolean z10);

    boolean e();

    boolean f(e eVar, h hVar);

    boolean g(e eVar, h hVar);

    int getId();

    void h(a aVar);

    void i(Context context, e eVar);

    void j(Parcelable parcelable);

    boolean l(m mVar);

    k m(ViewGroup viewGroup);

    Parcelable n();
}
