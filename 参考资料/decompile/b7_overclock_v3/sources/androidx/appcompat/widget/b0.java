package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.j;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface b0 {
    void a(Menu menu, j.a aVar);

    boolean e();

    void f();

    boolean g();

    CharSequence getTitle();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    boolean l();

    void m(SparseArray<Parcelable> sparseArray);

    void n(int i10);

    void o();

    void p(SparseArray<Parcelable> sparseArray);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setLogo(int i10);

    void setUiOptions(int i10);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
