package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.flydigi.data.bean.GameConfigDownloadBean;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class b1 extends y7.b implements View.OnClickListener {
    public final int[] A;
    public int B;
    public final String C;
    public final CFGPropertyMacro D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f15581p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f15582q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f15583r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f15584s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ListView f15585t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ListView f15586u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y7.c f15587v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public y7.c f15588w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f15589x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<String> f15590y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList<CFGPropertyMacro> f15591z;

    public b1(Context context, Handler handler, CFGPropertyMacro cFGPropertyMacro, String str, GamepadInfo gamepadInfo) {
        super(context, null, handler, gamepadInfo);
        this.f15589x = new ArrayList();
        this.f15590y = new ArrayList();
        this.f15591z = new ArrayList<>();
        this.A = new int[]{R.string.floatview_recommend_config};
        this.B = -1;
        this.D = cFGPropertyMacro;
        this.C = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ArrayList P(File file) throws Exception {
        return v5.f.a(file, this.f56484g.getDeviceMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(ArrayList arrayList) throws Exception {
        v5.e.b().c(this.C, arrayList);
    }

    public static /* synthetic */ void S(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(GameConfigDownloadBean gameConfigDownloadBean) throws Exception {
        if (com.blankj.utilcode.util.d1.g(gameConfigDownloadBean.url)) {
            this.f15583r.setText(this.f56478a.getString(R.string.floatview_current_game_no_recommend_macro));
        } else {
            N(gameConfigDownloadBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(Throwable th2) throws Exception {
        this.f15583r.setText(this.f56478a.getString(R.string.net_state_error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        ListView listView = this.f15586u;
        listView.performItemClick(listView.getAdapter().getView(0, null, null), 0, this.f15586u.getItemIdAtPosition(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(AdapterView adapterView, View view, int i10, long j10) {
        this.f15587v.c(i10);
        if (this.f15590y.size() > 0) {
            this.f15586u.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.z0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15748a.V();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(AdapterView adapterView, View view, int i10, long j10) {
        this.B = i10;
        this.f15588w.c(i10);
        if (this.f15591z.get(i10).desc.length() > 0) {
            this.f15584s.setText(this.f15591z.get(i10).desc);
        } else {
            this.f15584s.setText(this.f56478a.getString(R.string.macro_no_desc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        ListView listView = this.f15585t;
        listView.performItemClick(listView.getAdapter().getView(0, null, null), 0, this.f15585t.getItemIdAtPosition(0));
    }

    public final void N(GameConfigDownloadBean gameConfigDownloadBean) throws IOException {
        e6.z.F(gameConfigDownloadBean.url).A3(new dj.o() { // from class: com.flydigi.float_view.ui.config.y0
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f15717a.P((File) obj);
            }
        }).Y1(new dj.g() { // from class: com.flydigi.float_view.ui.config.v0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15708a.Q((ArrayList) obj);
            }
        }).s0(o5.l.d()).F5(new dj.g() { // from class: com.flydigi.float_view.ui.config.w0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15711a.R((ArrayList) obj);
            }
        }, new dj.g() { // from class: com.flydigi.float_view.ui.config.x0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                b1.S((Throwable) obj);
            }
        });
    }

    public final void O() {
        ArrayList<CFGPropertyMacro> arrayListA = v5.e.b().a(this.C);
        if (arrayListA == null || arrayListA.size() == 0) {
            ((h5.b) m5.f0.i().k().g(h5.b.class)).b(this.C).s0(o5.l.d()).s0(m5.c0.p()).F5(new dj.g() { // from class: com.flydigi.float_view.ui.config.t0
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f15702a.T((GameConfigDownloadBean) obj);
                }
            }, new dj.g() { // from class: com.flydigi.float_view.ui.config.u0
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f15705a.U((Throwable) obj);
                }
            });
        } else {
            R(arrayListA);
        }
    }

    public final void Z() {
        for (int i10 : this.A) {
            this.f15589x.add(this.f56478a.getString(i10));
        }
        this.f15587v.notifyDataSetChanged();
        O();
    }

    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final void R(ArrayList<CFGPropertyMacro> arrayList) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.f15590y.add(arrayList.get(i10).title);
            this.f15591z.add(arrayList.get(i10));
        }
        this.f15588w.notifyDataSetChanged();
        this.f15585t.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.a1
            @Override // java.lang.Runnable
            public final void run() {
                this.f15562a.Y();
            }
        });
        if (this.f15590y.size() > 0) {
            this.f15583r.setVisibility(8);
        } else {
            this.f15583r.setVisibility(0);
        }
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_import_macro;
    }

    @Override // y7.b
    public void n() {
        this.f15581p = (TextView) this.f56479b.findViewById(R.id.tv_cancel);
        this.f15582q = (TextView) this.f56479b.findViewById(R.id.tv_ok);
        this.f15581p.setOnClickListener(this);
        this.f15582q.setOnClickListener(this);
        this.f15583r = (TextView) this.f56479b.findViewById(R.id.tv_config_null_1);
        this.f15584s = (TextView) this.f56479b.findViewById(R.id.tv_desc);
        this.f15585t = (ListView) this.f56479b.findViewById(R.id.listview_1);
        this.f15586u = (ListView) this.f56479b.findViewById(R.id.listview_2);
        this.f15587v = new y7.c(this.f56478a, this.f15585t, this.f15589x, 1);
        this.f15588w = new y7.c(this.f56478a, this.f15586u, this.f15590y, 2);
        this.f15585t.setAdapter((ListAdapter) this.f15587v);
        this.f15586u.setAdapter((ListAdapter) this.f15588w);
        this.f15585t.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.flydigi.float_view.ui.config.q0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f15691a.W(adapterView, view, i10, j10);
            }
        });
        this.f15586u.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.flydigi.float_view.ui.config.s0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f15698a.X(adapterView, view, i10, j10);
            }
        });
        this.f56479b.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15694a.Z();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f15581p) {
            this.f56482e.sendEmptyMessage(2);
            h();
            return;
        }
        if (view == this.f15582q) {
            int i10 = this.B;
            if (i10 == -1 || this.f15591z.get(i10) == null || this.f15591z.get(this.B).macro_keys.size() <= 0) {
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_current_not_select_any_macro));
                return;
            }
            Message message = new Message();
            message.what = 3;
            CFGPropertyMacro cFGPropertyMacroCopy = this.f15591z.get(this.B).copy();
            CFGPropertyMacro cFGPropertyMacro = this.D;
            cFGPropertyMacroCopy.key_id = cFGPropertyMacro.key_id;
            cFGPropertyMacroCopy.key = cFGPropertyMacro.key;
            cFGPropertyMacroCopy.comboKeySecond = cFGPropertyMacro.comboKeySecond;
            cFGPropertyMacroCopy.comboKeyFirst = cFGPropertyMacro.comboKeyFirst;
            message.obj = cFGPropertyMacroCopy;
            this.f56482e.sendMessage(message);
            h();
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
