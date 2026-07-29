package j8;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import eu.davidea.flexibleadapter.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w7.e0;

/* JADX INFO: loaded from: classes7.dex */
public class b extends y7.b implements View.OnClickListener, a8.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e0 f36191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<ArrayList<Integer>> f36192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.collection.a<Integer, j8.a> f36193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CFGSubPropertyMacro f36194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f36195t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f36196u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final eu.davidea.flexibleadapter.b<a8.c> f36197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final eu.davidea.flexibleadapter.b<a8.c> f36198w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f36199x;

    public class a implements b.z {
        public a() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(View view, int i10) {
            if (i10 == -1) {
                return false;
            }
            b.this.f36197v.M(i10);
            ArrayList arrayList = (ArrayList) b.this.f36192q.get(i10);
            b.this.f36198w.I4(b.this.H(arrayList, 2));
            b.this.f36198w.M(0);
            b.this.I(((Integer) arrayList.get(0)).intValue());
            return true;
        }
    }

    /* JADX INFO: renamed from: j8.b$b, reason: collision with other inner class name */
    public class C0409b implements b.z {
        public C0409b() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(View view, int i10) {
            if (i10 == -1) {
                return false;
            }
            b.this.f36198w.M(i10);
            b bVar = b.this;
            bVar.I(((a8.c) bVar.f36198w.g2(i10)).B());
            return true;
        }
    }

    public b(Context context, Handler handler, CFGSubPropertyMacro cFGSubPropertyMacro, String str, GamepadInfo gamepadInfo) {
        super(context, null, handler, gamepadInfo);
        this.f36192q = new ArrayList<>();
        this.f36193r = new androidx.collection.a<>();
        this.f36197v = new eu.davidea.flexibleadapter.b<>(null, new a());
        this.f36198w = new eu.davidea.flexibleadapter.b<>(null, new C0409b());
        this.f36199x = null;
        this.f36194s = cFGSubPropertyMacro;
        this.f36195t = str;
    }

    public final void G() {
        if (this.f36193r.get(Integer.valueOf(this.f36196u)) == null) {
            return;
        }
        CFGSubPropertyMacro cFGSubPropertyMacroC = this.f36193r.get(Integer.valueOf(this.f36196u)).c();
        cFGSubPropertyMacroC.setWaitTime(this.f36191p.f54057j.getValue());
        cFGSubPropertyMacroC.setDuration(this.f36191p.f54056i.getValue());
        l();
        Message message = new Message();
        message.what = 101;
        message.obj = cFGSubPropertyMacroC;
        this.f56482e.sendMessage(message);
    }

    public final List<a8.c> H(ArrayList<Integer> arrayList, int i10) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new a8.c(it2.next().intValue(), i10));
        }
        return arrayList2;
    }

    public final void I(int i10) {
        View view = this.f36199x;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.f36193r.get(Integer.valueOf(i10)) == null) {
            K(i10, null);
        }
        if (this.f36193r.get(Integer.valueOf(i10)) != null) {
            PropertyLinearLayout propertyLinearLayoutD = this.f36193r.get(Integer.valueOf(i10)).d();
            this.f36199x = propertyLinearLayoutD;
            propertyLinearLayoutD.setVisibility(0);
        }
        this.f36196u = i10;
    }

    public void J(CFGSubPropertyMacro cFGSubPropertyMacro, String str) {
        this.f36194s = cFGSubPropertyMacro;
        this.f36195t = str;
        if (this.f36191p == null) {
            n();
            return;
        }
        L();
        this.f36191p.f54060m.setText(str + this.f56478a.getString(R.string.floatview_property_key_title));
        this.f36191p.f54057j.setValue(cFGSubPropertyMacro.getWaitTime());
        this.f36191p.f54056i.setValue(cFGSubPropertyMacro.getDuration());
        int iB = a8.d.b(cFGSubPropertyMacro, this.f56484g);
        K(iB, cFGSubPropertyMacro);
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < this.f36192q.size() && (i11 == -1 || i12 == -1); i13++) {
            ArrayList<Integer> arrayList = this.f36192q.get(i13);
            int i14 = 0;
            while (true) {
                if (i14 >= arrayList.size()) {
                    break;
                }
                if (iB == arrayList.get(i14).intValue()) {
                    i11 = i13;
                    i12 = i14;
                    break;
                }
                i14++;
            }
        }
        if (i11 == -1 && i12 == -1) {
            i12 = 0;
        } else {
            i10 = i11;
        }
        this.f36196u = iB;
        this.f36197v.n();
        this.f36198w.n();
        this.f36197v.m(i10);
        this.f36197v.notifyDataSetChanged();
        this.f36198w.I4(H(this.f36192q.get(i10), 2));
        this.f36198w.m(i12);
        I(iB);
    }

    public final void K(int i10, CFGSubPropertyMacro cFGSubPropertyMacro) {
        j8.a aVarA = a8.d.a(i10, this.f56478a, this.f56484g);
        if (cFGSubPropertyMacro != null) {
            aVarA.f(cFGSubPropertyMacro);
        }
        PropertyLinearLayout propertyLinearLayoutD = aVarA.d();
        propertyLinearLayoutD.setId(i10);
        this.f36199x = propertyLinearLayoutD;
        this.f36191p.f54049b.addView(propertyLinearLayoutD);
        this.f36193r.put(Integer.valueOf(i10), aVarA);
    }

    public final void L() {
        for (int i10 = 0; i10 < this.f36193r.values().size(); i10++) {
            this.f36193r.o(i10).g();
            this.f36193r.o(i10).d().setVisibility(8);
        }
        this.f36191p.f54057j.U();
        this.f36191p.f54056i.U();
    }

    @Override // a8.b
    public void e(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<ArrayList<Integer>> arrayList3) {
        this.f36192q.addAll(arrayList3);
        this.f36197v.I4(H(arrayList, 1));
        this.f36198w.I4(H(arrayList2, 2));
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_property_submacro;
    }

    @Override // y7.b
    public void n() {
        e0 e0VarA = e0.a(this.f56479b);
        this.f36191p = e0VarA;
        o.r(e0VarA.f54058k, this);
        o.r(this.f36191p.f54059l, this);
        this.f36197v.J(1);
        this.f36198w.J(1);
        this.f36191p.f54053f.setAdapter(this.f36197v);
        this.f36191p.f54054g.setAdapter(this.f36198w);
        a8.d.c(this.f56484g, this);
        J(this.f36194s, this.f36195t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e0 e0Var = this.f36191p;
        if (view == e0Var.f54058k) {
            l();
            this.f56482e.sendEmptyMessage(111);
        } else if (view == e0Var.f54059l) {
            G();
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
