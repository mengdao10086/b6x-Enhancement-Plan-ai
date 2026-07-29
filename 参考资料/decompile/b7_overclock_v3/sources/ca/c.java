package ca;

import android.widget.Button;
import com.github.dhaval2404.colorpicker.R;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Landroidx/appcompat/app/e;", "Lkotlin/z1;", "a", "colorpicker_release"}, k = 2, mv = {1, 5, 1})
public final class c {
    public static final void a(@k androidx.appcompat.app.e eVar) {
        f0.p(eVar, "<this>");
        int iF = h0.d.f(eVar.getContext(), R.color.positiveButtonTextColor);
        Button buttonL = eVar.l(-1);
        if (buttonL != null) {
            buttonL.setTextColor(iF);
        }
        int iF2 = h0.d.f(eVar.getContext(), R.color.negativeButtonTextColor);
        Button buttonL2 = eVar.l(-2);
        if (buttonL2 == null) {
            return;
        }
        buttonL2.setTextColor(iF2);
    }
}
