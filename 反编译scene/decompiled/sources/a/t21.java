package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t21 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<in0> f2943a;

    public class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f7458a;
        public TextView b;
        public TextView c;
        public TextView d;

        public a(t21 t21Var, View view) {
            super(view);
            this.f7458a = (TextView) view.findViewById(t61.thread_load);
            this.b = (TextView) view.findViewById(t61.thread_pid);
            this.c = (TextView) view.findViewById(t61.item_cpus);
            this.d = (TextView) view.findViewById(t61.item_comm);
        }
    }

    public t21(Context context, ArrayList<in0> arrayList) {
        this.f7457a = context;
        this.f2943a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f2943a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        in0 in0Var = this.f2943a.get(i);
        aVar.f7458a.setText("" + in0Var.d());
        aVar.b.setText("" + in0Var.e());
        aVar.c.setText(in0Var.b());
        aVar.d.setText(in0Var.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(this.f7457a).inflate(2131558640, viewGroup, false));
    }

    public void z(ArrayList<in0> arrayList) {
        this.f2943a = arrayList;
        i();
    }
}
