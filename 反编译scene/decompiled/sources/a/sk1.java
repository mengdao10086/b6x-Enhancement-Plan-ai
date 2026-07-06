package a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.ChargeStatSession;
import com.omarea.ui.Tags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sk1 extends e80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<ChargeStatSession, m42> f7409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx0 f2900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f2901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f2902a;
    public final int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public sk1(Activity activity, x90 x90Var, int i, g82<? super ChargeStatSession, m42> g82Var) {
        super(2131558616, x90Var.a());
        f92.d(activity, "activity");
        f92.d(x90Var, "themeMode");
        f92.d(g82Var, "callback");
        this.f2901a = activity;
        this.k = i;
        this.f7409a = g82Var;
        this.f2900a = qx0.d();
    }

    @Override // a.e80
    public void C1() {
        HashMap map = this.f2902a;
        if (map != null) {
            map.clear();
        }
    }

    @Override // a.e80, androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        qx0 qx0Var = this.f2900a;
        f92.c(qx0Var, "storage");
        ArrayList<ChargeStatSession> arrayListH = qx0Var.h();
        f92.c(arrayListH, "sessions");
        if (arrayListH.size() > 1) {
            c52.n(arrayListH, new pk1());
        }
        View viewFindViewById = view.findViewById(t61.list_empty);
        f92.c(viewFindViewById, "view.findViewById<View>(R.id.list_empty)");
        viewFindViewById.setVisibility(arrayListH.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(t61.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Context context = recyclerView.getContext();
        f92.c(context, "context");
        Iterator<ChargeStatSession> it = arrayListH.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().session == this.k) {
                    break;
                } else {
                    i++;
                }
            }
        }
        r01 r01Var = new r01(context, arrayListH, i);
        r01Var.H(new lk1(r01Var, this, arrayListH, view));
        r01Var.G(new mk1(r01Var, this, arrayListH, view));
        m42 m42Var = m42.f6769a;
        recyclerView.setAdapter(r01Var);
        i92 i92Var = new i92();
        i92Var.b = false;
        Tags tags = (Tags) view.findViewById(t61.tags);
        String[] strArr = {J(u61.power_all), "≤ 20%", "≤ 50%", "≤ 80%"};
        fj0 fj0VarB = tags.b(strArr, 0);
        fj0VarB.j(new ok1(fj0VarB, strArr, recyclerView, i92Var, this, arrayListH, view));
        View viewFindViewById2 = view.findViewById(t61.delete_confirm);
        View viewFindViewById3 = view.findViewById(t61.delete);
        viewFindViewById3.setOnClickListener(new qk1(i92Var, viewFindViewById3, viewFindViewById2));
        viewFindViewById2.setOnClickListener(new rk1(i92Var, viewFindViewById3, viewFindViewById2));
        recyclerView.setVisibility(arrayListH.isEmpty() ^ true ? 0 : 8);
    }

    @Override // a.e80, a.wk, androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        C1();
    }
}
