package aa;

import aa.c;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.dhaval2404.colorpicker.R;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import xf.j;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u001c\u0010\u0017\u001a\u00020\u00052\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u001d"}, d2 = {"Laa/c;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Laa/c$a;", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "colorShape", "Lkotlin/z1;", "v", "", "color", "w", "", "tickColorPerCard", "x", an.aB, "", CommonNetImpl.POSITION, SsManifestParser.e.J, "getItemCount", "Landroid/view/ViewGroup;", androidx.constraintlayout.widget.d.V1, "viewType", "u", "holder", "t", "", "colors", "<init>", "(Ljava/util/List;)V", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class c extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final List<String> f330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public String f332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public ColorShape f333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f334e;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Laa/c$a;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", CommonNetImpl.POSITION, "Lkotlin/z1;", j.f55230b, "Landroid/view/View;", "rootView", "<init>", "(Laa/c;Landroid/view/View;)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public final class a extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final View f335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CardView f336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f338d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k final c this$0, View rootView) {
            super(rootView);
            f0.p(this$0, "this$0");
            f0.p(rootView, "rootView");
            this.f338d = this$0;
            this.f335a = rootView;
            this.f336b = (CardView) rootView.findViewById(R.id.colorView);
            this.f337c = (AppCompatImageView) rootView.findViewById(R.id.checkIcon);
            rootView.setOnClickListener(new View.OnClickListener() { // from class: aa.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.a.i(this$0, view);
                }
            });
        }

        public static final void i(c this$0, View view) {
            f0.p(this$0, "this$0");
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) tag).intValue();
            String strR = this$0.r(iIntValue);
            int iIndexOf = this$0.f330a.indexOf(this$0.f332c);
            this$0.f332c = strR;
            this$0.notifyItemChanged(iIndexOf);
            this$0.notifyItemChanged(iIntValue);
        }

        public final void j(int i10) {
            String strR = this.f338d.r(i10);
            this.f335a.setTag(Integer.valueOf(i10));
            aa.a aVar = aa.a.f328a;
            CardView colorView = this.f336b;
            f0.o(colorView, "colorView");
            aVar.b(colorView, strR);
            CardView colorView2 = this.f336b;
            f0.o(colorView2, "colorView");
            aVar.c(colorView2, this.f338d.f333d);
            boolean zG = f0.g(strR, this.f338d.f332c);
            AppCompatImageView checkIcon = this.f337c;
            f0.o(checkIcon, "checkIcon");
            ca.e.a(checkIcon, zG);
            boolean zF = this.f338d.f331b;
            if (this.f338d.f334e) {
                ca.b bVar = ca.b.f10676a;
                zF = ca.b.f(strR);
            }
            this.f337c.setColorFilter(zF ? -1 : -16777216);
        }
    }

    public c(@k List<String> colors) {
        int i10;
        f0.p(colors, "colors");
        this.f330a = colors;
        this.f332c = "";
        this.f333d = ColorShape.CIRCLE;
        if ((colors instanceof Collection) && colors.isEmpty()) {
            i10 = 0;
        } else {
            i10 = 0;
            for (String str : colors) {
                ca.b bVar = ca.b.f10676a;
                if (ca.b.f(str) && (i10 = i10 + 1) < 0) {
                    CollectionsKt__CollectionsKt.V();
                }
            }
        }
        this.f331b = i10 * 2 >= this.f330a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f330a.size();
    }

    @k
    public final String r(int i10) {
        return this.f330a.get(i10);
    }

    @k
    public final String s() {
        return this.f332c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@k a holder, int i10) {
        f0.p(holder, "holder");
        holder.j(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @k
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@k ViewGroup parent, int i10) {
        f0.p(parent, "parent");
        return new a(this, aa.a.f328a.a(parent));
    }

    public final void v(@k ColorShape colorShape) {
        f0.p(colorShape, "colorShape");
        this.f333d = colorShape;
    }

    public final void w(@k String color) {
        f0.p(color, "color");
        this.f332c = color;
    }

    public final void x(boolean z10) {
        this.f334e = z10;
    }
}
