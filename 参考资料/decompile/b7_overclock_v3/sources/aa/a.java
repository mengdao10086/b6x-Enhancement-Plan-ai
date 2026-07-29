package aa;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.github.dhaval2404.colorpicker.R;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Laa/a;", "", "Landroid/view/ViewGroup;", androidx.constraintlayout.widget.d.V1, "Landroid/view/View;", "a", "Landroidx/cardview/widget/CardView;", "cardView", "", "hexColor", "Lkotlin/z1;", "b", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "colorShape", "c", "<init>", "()V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f328a = new a();

    @k
    public final View a(@k ViewGroup parent) {
        f0.p(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_material_color_picker, parent, false);
        f0.o(viewInflate, "inflater.inflate(\n            R.layout.adapter_material_color_picker,\n            parent,\n            false\n        )");
        return viewInflate;
    }

    public final void b(@k CardView cardView, @k String hexColor) {
        f0.p(cardView, "cardView");
        f0.p(hexColor, "hexColor");
        cardView.setCardBackgroundColor(Color.parseColor(hexColor));
    }

    public final void c(@k CardView cardView, @k ColorShape colorShape) {
        f0.p(cardView, "cardView");
        f0.p(colorShape, "colorShape");
        if (colorShape == ColorShape.SQAURE) {
            cardView.setRadius(cardView.getContext().getResources().getDimension(R.dimen.color_card_square_radius));
        }
    }
}
