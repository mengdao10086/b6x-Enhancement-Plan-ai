package xh;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.widget.CheckView;
import com.zhihu.matisse.internal.ui.widget.MediaGrid;

/* JADX INFO: loaded from: classes5.dex */
public class a extends xh.d<RecyclerView.e0> implements MediaGrid.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f55320j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f55321k = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vh.c f55322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f55323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public th.c f55324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f55325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f55326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f55327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f55328i;

    /* JADX INFO: renamed from: xh.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0651a implements View.OnClickListener {
        public ViewOnClickListenerC0651a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getContext() instanceof f) {
                ((f) view.getContext()).C2();
            }
        }
    }

    public static class b extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f55330a;

        public b(View view) {
            super(view);
            this.f55330a = (TextView) view.findViewById(R.id.hint);
        }
    }

    public interface c {
        void onUpdate();
    }

    public static class d extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaGrid f55331a;

        public d(View view) {
            super(view);
            this.f55331a = (MediaGrid) view;
        }
    }

    public interface e {
        void l2(Album album, Item item, int i10);
    }

    public interface f {
        void C2();
    }

    public a(Context context, vh.c cVar, RecyclerView recyclerView) {
        super(null);
        this.f55324e = th.c.b();
        this.f55322c = cVar;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.item_placeholder});
        this.f55323d = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        this.f55327h = recyclerView;
    }

    @Override // com.zhihu.matisse.internal.ui.widget.MediaGrid.a
    public void e(ImageView imageView, Item item, RecyclerView.e0 e0Var) {
        if (!this.f55324e.f51314w) {
            z(item, e0Var);
            return;
        }
        e eVar = this.f55326g;
        if (eVar != null) {
            eVar.l2(null, item, e0Var.getAdapterPosition());
        }
    }

    @Override // com.zhihu.matisse.internal.ui.widget.MediaGrid.a
    public void g(CheckView checkView, Item item, RecyclerView.e0 e0Var) {
        z(item, e0Var);
    }

    @Override // xh.d
    public int m(int i10, Cursor cursor) {
        return Item.s(cursor).b() ? 1 : 2;
    }

    @Override // xh.d
    public void o(RecyclerView.e0 e0Var, Cursor cursor) {
        Drawable.ConstantState constantState;
        if (!(e0Var instanceof b)) {
            if (e0Var instanceof d) {
                d dVar = (d) e0Var;
                Item itemS = Item.s(cursor);
                dVar.f55331a.d(new MediaGrid.b(r(dVar.f55331a.getContext()), this.f55323d, this.f55324e.f51297f, e0Var));
                dVar.f55331a.a(itemS);
                dVar.f55331a.setOnMediaGridClickListener(this);
                w(itemS, dVar.f55331a);
                return;
            }
            return;
        }
        b bVar = (b) e0Var;
        Drawable[] compoundDrawables = bVar.f55330a.getCompoundDrawables();
        TypedArray typedArrayObtainStyledAttributes = e0Var.itemView.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.capture_textColor});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        for (int i10 = 0; i10 < compoundDrawables.length; i10++) {
            Drawable drawable = compoundDrawables[i10];
            if (drawable != null && (constantState = drawable.getConstantState()) != null) {
                Drawable drawableMutate = constantState.newDrawable().mutate();
                drawableMutate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                drawableMutate.setBounds(drawable.getBounds());
                compoundDrawables[i10] = drawableMutate;
            }
        }
        bVar.f55330a.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        if (i10 == 1) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_capture_item, viewGroup, false));
            bVar.itemView.setOnClickListener(new ViewOnClickListenerC0651a());
            return bVar;
        }
        if (i10 == 2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.media_grid_item, viewGroup, false));
        }
        return null;
    }

    public final boolean q(Context context, Item item) {
        th.b bVarJ = this.f55322c.j(item);
        th.b.a(context, bVarJ);
        return bVarJ == null;
    }

    public final int r(Context context) {
        if (this.f55328i == 0) {
            int iH3 = ((GridLayoutManager) this.f55327h.getLayoutManager()).H3();
            int dimensionPixelSize = (context.getResources().getDisplayMetrics().widthPixels - (context.getResources().getDimensionPixelSize(R.dimen.media_grid_spacing) * (iH3 - 1))) / iH3;
            this.f55328i = dimensionPixelSize;
            this.f55328i = (int) (dimensionPixelSize * this.f55324e.f51306o);
        }
        return this.f55328i;
    }

    public final void s() {
        notifyDataSetChanged();
        c cVar = this.f55325f;
        if (cVar != null) {
            cVar.onUpdate();
        }
    }

    public void t() {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f55327h.getLayoutManager();
        int iY2 = gridLayoutManager.y2();
        int iC2 = gridLayoutManager.C2();
        if (iY2 == -1 || iC2 == -1) {
            return;
        }
        Cursor cursorL = l();
        for (int i10 = iY2; i10 <= iC2; i10++) {
            RecyclerView.e0 e0VarG0 = this.f55327h.g0(iY2);
            if ((e0VarG0 instanceof d) && cursorL.moveToPosition(i10)) {
                w(Item.s(cursorL), ((d) e0VarG0).f55331a);
            }
        }
    }

    public void u(c cVar) {
        this.f55325f = cVar;
    }

    public void v(e eVar) {
        this.f55326g = eVar;
    }

    public final void w(Item item, MediaGrid mediaGrid) {
        if (!this.f55324e.f51297f) {
            if (this.f55322c.l(item)) {
                mediaGrid.setCheckEnabled(true);
                mediaGrid.setChecked(true);
                return;
            } else if (this.f55322c.m()) {
                mediaGrid.setCheckEnabled(false);
                mediaGrid.setChecked(false);
                return;
            } else {
                mediaGrid.setCheckEnabled(true);
                mediaGrid.setChecked(false);
                return;
            }
        }
        int iE = this.f55322c.e(item);
        if (iE > 0) {
            mediaGrid.setCheckEnabled(true);
            mediaGrid.setCheckedNum(iE);
        } else if (this.f55322c.m()) {
            mediaGrid.setCheckEnabled(false);
            mediaGrid.setCheckedNum(Integer.MIN_VALUE);
        } else {
            mediaGrid.setCheckEnabled(true);
            mediaGrid.setCheckedNum(iE);
        }
    }

    public void x() {
        this.f55325f = null;
    }

    public void y() {
        this.f55326g = null;
    }

    public final void z(Item item, RecyclerView.e0 e0Var) {
        if (this.f55324e.f51297f) {
            if (this.f55322c.e(item) != Integer.MIN_VALUE) {
                this.f55322c.r(item);
                s();
                return;
            } else {
                if (q(e0Var.itemView.getContext(), item)) {
                    this.f55322c.a(item);
                    s();
                    return;
                }
                return;
            }
        }
        if (this.f55322c.l(item)) {
            this.f55322c.r(item);
            s();
        } else if (q(e0Var.itemView.getContext(), item)) {
            this.f55322c.a(item);
            s();
        }
    }
}
