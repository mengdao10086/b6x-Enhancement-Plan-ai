package nd;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.i0;
import g.n0;
import g.q;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends com.google.android.material.navigation.a {
    public a(@n0 Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.a
    @q
    public int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.a
    @i0
    public int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }
}
