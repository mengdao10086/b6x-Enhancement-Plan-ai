package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface k {

    public interface a {
        void c(boolean z10, char c10);

        boolean f();

        boolean g();

        h getItemData();

        void h(h hVar, int i10);

        void setCheckable(boolean z10);

        void setChecked(boolean z10);

        void setEnabled(boolean z10);

        void setIcon(Drawable drawable);

        void setTitle(CharSequence charSequence);
    }

    void e(e eVar);

    int getWindowAnimations();
}
