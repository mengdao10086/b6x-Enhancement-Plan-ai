package j2;

import android.view.View;
import android.view.ViewGroup;
import g.d0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    @p0
    public static <T extends View> T a(View view, @d0 int i10) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            T t10 = (T) viewGroup.getChildAt(i11).findViewById(i10);
            if (t10 != null) {
                return t10;
            }
        }
        return null;
    }
}
