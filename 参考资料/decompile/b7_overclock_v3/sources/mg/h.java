package mg;

import android.view.View;
import androidx.annotation.RestrictTo;
import g.l;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public interface h extends sg.f {
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void b(@n0 j jVar, int i10, int i11);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void f(float f10, int i10, int i11);

    @n0
    ng.b getSpinnerStyle();

    @n0
    View getView();

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void i(@n0 j jVar, int i10, int i11);

    boolean j();

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    int l(@n0 j jVar, boolean z10);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void n(@n0 i iVar, int i10, int i11);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void r(boolean z10, float f10, int i10, int i11, int i12);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void setPrimaryColors(@l int... iArr);
}
