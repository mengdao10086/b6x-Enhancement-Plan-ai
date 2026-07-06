package a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.PowerStatSession;
import com.omarea.ui.Tags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kk1 extends e80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<PowerStatSession, m42> f6615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zy0 f1648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f1649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f1650a;
    public final int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public kk1(Activity activity, x90 x90Var, int i, g82<? super PowerStatSession, m42> g82Var) {
        super(2131558616, x90Var.a());
        f92.d(activity, "activity");
        f92.d(x90Var, "themeMode");
        f92.d(g82Var, "callback");
        this.f1649a = activity;
        this.k = i;
        this.f6615a = g82Var;
        this.f1648a = zy0.e();
    }

    @Override // a.e80
    public void C1() {
        HashMap map = this.f1650a;
        if (map != null) {
            map.clear();
        }
    }

    @Override // a.e80, androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        zy0 zy0Var = this.f1648a;
        f92.c(zy0Var, "storage");
        ArrayList<PowerStatSession> arrayListK = zy0Var.k();
        f92.c(arrayListK, "sessions");
        if (arrayListK.size() > 1) {
            c52.n(arrayListK, new hk1());
        }
        View viewFindViewById = view.findViewById(t61.list_empty);
        f92.c(viewFindViewById, "view.findViewById<View>(R.id.list_empty)");
        viewFindViewById.setVisibility(arrayListK.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(t61.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Context context = recyclerView.getContext();
        f92.c(context, "context");
        Iterator<PowerStatSession> it = arrayListK.iterator();
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
        s11 s11Var = new s11(context, arrayListK, i);
        s11Var.I(new dk1(s11Var, this, arrayListK, view));
        s11Var.H(new ek1(s11Var, this, arrayListK, view));
        m42 m42Var = m42.f6769a;
        recyclerView.setAdapter(s11Var);
        i92 i92Var = new i92();
        i92Var.b = false;
        Tags tags = (Tags) view.findViewById(t61.tags);
        String[] strArr = {J(u61.power_all), "≤ 1H", "≤ 3H", "≤ 5H"};
        fj0 fj0VarB = tags.b(strArr, 0);
        fj0VarB.j(new gk1(fj0VarB, strArr, recyclerView, i92Var, this, arrayListK, view));
        View viewFindViewById2 = view.findViewById(t61.delete_confirm);
        View viewFindViewById3 = view.findViewById(t61.delete);
        viewFindViewById3.setOnClickListener(new ik1(i92Var, viewFindViewById3, viewFindViewById2));
        viewFindViewById2.setOnClickListener(new jk1(i92Var, viewFindViewById3, viewFindViewById2));
        recyclerView.setVisibility(arrayListK.isEmpty() ^ true ? 0 : 8);
    }

    @Override // a.e80, a.wk, androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        C1();
    }
}
