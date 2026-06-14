package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w01 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v01 f7739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<g50> f3319a;
    public v01 b;

    public final class a extends c61 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f7740a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f3320b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w01 w01Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final View O() {
            return this.b;
        }

        public final TextView P() {
            return this.f3320b;
        }

        public final TextView Q() {
            return this.f7740a;
        }

        public final void R(View view) {
            this.b = view;
        }

        public final void S(TextView textView) {
            this.f3320b = textView;
        }

        public final void T(TextView textView) {
            this.f7740a = textView;
        }
    }

    public w01(Context context, ArrayList<g50> arrayList) {
        f92.d(context, "context");
        f92.d(arrayList, "items");
        this.f3318a = context;
        this.f3319a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "viewHolder");
        g50 g50VarZ = z(i);
        TextView textViewQ = aVar.Q();
        f92.b(textViewQ);
        textViewQ.setText(g50VarZ.b());
        TextView textViewP = aVar.P();
        f92.b(textViewP);
        textViewP.setText(g50VarZ.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f3318a).inflate(2131558625, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.T((TextView) viewInflate.findViewById(2131361824));
        aVar.S((TextView) viewInflate.findViewById(t61.ItemText));
        aVar.R(viewInflate.findViewById(t61.action_delete));
        View viewO = aVar.O();
        if (viewO != null) {
            viewO.setOnClickListener(new x01(this, aVar));
        }
        ((RecyclerView.d0) aVar).f4387a.setOnClickListener(new y01(this, aVar));
        return aVar;
    }

    public final void C(int i) {
        this.f3319a.remove(i);
        l(i);
    }

    public final void D(v01 v01Var) {
        this.f7739a = v01Var;
    }

    public final void E(v01 v01Var) {
        this.b = v01Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f3319a.size();
    }

    public final g50 z(int i) {
        g50 g50Var = this.f3319a.get(i);
        f92.c(g50Var, "items[position]");
        return g50Var;
    }
}
