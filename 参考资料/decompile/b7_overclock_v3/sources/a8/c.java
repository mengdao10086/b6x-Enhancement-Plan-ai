package a8;

import android.view.View;
import com.flydigi.float_view.R;
import ei.h;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class c extends ei.c<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f300c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f301d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f303b;

    public static class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final w7.a f304g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f305h;

        public a(View view, eu.davidea.flexibleadapter.b bVar, int i10) {
            super(view, bVar);
            this.f305h = i10;
            w7.a aVarA = w7.a.a(view);
            this.f304g = aVarA;
            if (i10 == 2) {
                aVarA.f53952b.setImageResource(R.drawable.float_view_icon_selected_green_solid);
            } else {
                aVarA.f53952b.setImageResource(R.drawable.float_view_icon_selected_green_empty);
            }
        }

        @Override // gi.d
        public void q() {
            super.q();
            boolean zB = this.f29556c.B(getAdapterPosition());
            this.itemView.setActivated(zB);
            if (zB) {
                this.itemView.setBackgroundResource(R.color.lib_color_16);
                this.f304g.f53952b.setVisibility(0);
                this.f304g.f53954d.setTextColor(h0.d.f(this.itemView.getContext(), R.color.colorPrimary));
            } else {
                if (this.f305h == 2) {
                    this.itemView.setBackgroundResource(R.color.lib_color_13);
                } else {
                    this.itemView.setBackgroundResource(R.color.lib_color_12);
                }
                this.f304g.f53952b.setVisibility(4);
                this.f304g.f53954d.setTextColor(h0.d.f(this.itemView.getContext(), R.color.lib_color_10));
            }
        }
    }

    public c(int i10, int i11) {
        this.f302a = i10;
        this.f303b = i11;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(View view, eu.davidea.flexibleadapter.b<h> bVar) {
        return new a(view, bVar, this.f303b);
    }

    public int B() {
        return this.f302a;
    }

    public int C() {
        return this.f303b;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.floatview_item_common_select_name;
    }

    @Override // ei.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f302a == cVar.f302a && this.f303b == cVar.f303b;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<h> bVar, a aVar, int i10, List<Object> list) {
        if (2 == this.f303b) {
            aVar.f304g.f53954d.setText(n8.b.i(this.f302a));
        } else {
            aVar.f304g.f53954d.setText(this.f302a);
        }
        if (bVar.B(i10)) {
            aVar.itemView.setBackgroundResource(R.color.lib_color_16);
            aVar.f304g.f53952b.setVisibility(0);
            aVar.f304g.f53954d.setTextColor(h0.d.f(aVar.itemView.getContext(), R.color.colorPrimary));
        } else {
            if (this.f303b == 2) {
                aVar.itemView.setBackgroundResource(R.color.lib_color_13);
            } else {
                aVar.itemView.setBackgroundResource(R.color.lib_color_12);
            }
            aVar.f304g.f53952b.setVisibility(4);
            aVar.f304g.f53954d.setTextColor(h0.d.f(aVar.itemView.getContext(), R.color.lib_color_10));
        }
    }
}
