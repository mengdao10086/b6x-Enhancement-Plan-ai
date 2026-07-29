package aa;

import aa.e;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.dhaval2404.colorpicker.R;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Objects;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rJ\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rH\u0016¨\u0006\u001c"}, d2 = {"Laa/e;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Laa/e$a;", "Lba/a;", "listener", "Lkotlin/z1;", SsManifestParser.e.J, "", "color", "t", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "colorShape", an.aB, "", "getItemCount", CommonNetImpl.POSITION, "o", "Landroid/view/ViewGroup;", androidx.constraintlayout.widget.d.V1, "viewType", "q", "holder", "p", "", "colors", "<init>", "(Ljava/util/List;)V", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class e extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final List<String> f340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public ColorShape f341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public ba.a f342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public String f343d;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Laa/e$a;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", CommonNetImpl.POSITION, "Lkotlin/z1;", j.f55230b, "Landroid/view/View;", "rootView", "<init>", "(Laa/e;Landroid/view/View;)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public final class a extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final View f344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CardView f345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f346c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k final e this$0, View rootView) {
            super(rootView);
            f0.p(this$0, "this$0");
            f0.p(rootView, "rootView");
            this.f346c = this$0;
            this.f344a = rootView;
            this.f345b = (CardView) rootView.findViewById(R.id.colorView);
            rootView.setOnClickListener(new View.OnClickListener() { // from class: aa.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.i(this$0, view);
                }
            });
        }

        public static final void i(e this$0, View view) {
            f0.p(this$0, "this$0");
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this$0.f340a.size()) {
                String strO = this$0.o(iIntValue);
                ba.a aVar = this$0.f342c;
                if (aVar == null) {
                    return;
                }
                aVar.a(Color.parseColor(strO), strO);
            }
        }

        public final void j(int i10) {
            String strO = this.f346c.o(i10);
            this.f344a.setTag(Integer.valueOf(i10));
            aa.a aVar = aa.a.f328a;
            CardView colorView = this.f345b;
            f0.o(colorView, "colorView");
            aVar.b(colorView, strO);
            CardView colorView2 = this.f345b;
            f0.o(colorView2, "colorView");
            aVar.c(colorView2, this.f346c.f341b);
        }
    }

    public e(@k List<String> colors) {
        f0.p(colors, "colors");
        this.f340a = colors;
        this.f341b = ColorShape.CIRCLE;
        this.f343d = "#E0E0E0";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return 10;
    }

    @k
    public final String o(int i10) {
        return i10 < this.f340a.size() ? this.f340a.get(i10) : this.f343d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@k a holder, int i10) {
        f0.p(holder, "holder");
        holder.j(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @k
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@k ViewGroup parent, int i10) {
        f0.p(parent, "parent");
        return new a(this, aa.a.f328a.a(parent));
    }

    public final void r(@k ba.a listener) {
        f0.p(listener, "listener");
        this.f342c = listener;
    }

    public final void s(@k ColorShape colorShape) {
        f0.p(colorShape, "colorShape");
        this.f341b = colorShape;
    }

    public final void t(@k String color) {
        f0.p(color, "color");
        this.f343d = color;
    }
}
