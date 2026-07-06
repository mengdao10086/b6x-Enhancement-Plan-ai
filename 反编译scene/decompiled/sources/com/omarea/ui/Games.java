package com.omarea.ui;

import a.b62;
import a.c31;
import a.d31;
import a.d70;
import a.d72;
import a.ec2;
import a.f92;
import a.fg2;
import a.h42;
import a.k82;
import a.kh0;
import a.m42;
import a.n92;
import a.oc2;
import a.p80;
import a.qc2;
import a.qe2;
import a.r62;
import a.ri0;
import a.s42;
import a.t61;
import a.t62;
import a.tw0;
import a.u42;
import a.u61;
import a.u90;
import a.v61;
import a.wd2;
import a.x62;
import a.xd2;
import a.y21;
import a.z21;
import a.z42;
import a.zz0;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class Games extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u90 f8391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z21 f4869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f4870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f4871a;

    @x62(c = "com.omarea.ui.Games$addAppDialog$1", f = "Games.kt", l = {263}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8392a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4873a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f4874b;
        public Object c;
        public Object d;
        public Object e;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = Games.this.new a(b62Var);
            aVar.f8392a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, java.util.ArrayList] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8392a;
                Context context = Games.this.getContext();
                f92.c(context, "context");
                ArrayList<AppInfo> arrayListH = new kh0(context, false, 2, null).h(null, true);
                Context context2 = Games.this.getContext();
                f92.c(context2, "context");
                String[] strArrC = new ri0(context2).c();
                ArrayList<AppInfo> arrayList = new ArrayList();
                for (Object obj2 : arrayListH) {
                    if (t62.a(!u42.k(strArrC, ((AppInfo) obj2).getPackageName())).booleanValue()) {
                        arrayList.add(obj2);
                    }
                }
                n92 n92Var = new n92();
                ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
                for (AppInfo appInfo : arrayList) {
                    d70.a aVar = new d70.a();
                    aVar.setAppName("" + appInfo.getAppName());
                    aVar.setPackageName("" + appInfo.getPackageName());
                    aVar.setSelected(false);
                    arrayList2.add(aVar);
                }
                n92Var.f6891a = new ArrayList(arrayList2);
                fg2 fg2VarC = qe2.c();
                y21 y21Var = new y21(this, n92Var, null);
                this.f4873a = wd2Var;
                this.f4874b = arrayListH;
                this.c = strArrC;
                this.d = arrayList;
                this.e = n92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, y21Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.ui.Games$loadData$1", f = "Games.kt", l = {166}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8393a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SharedPreferences f4875a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4877a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f4878b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public Object f4879c;
        public Object d;
        public Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SharedPreferences sharedPreferences, b62 b62Var) {
            super(2, b62Var);
            this.f4875a = sharedPreferences;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = Games.this.new b(this.f4875a, b62Var);
            bVar.f8393a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object[], java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, java.util.ArrayList] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.c;
            try {
                if (i == 0) {
                    h42.b(obj);
                    wd2 wd2Var = this.f8393a;
                    String string = this.f4875a.getString(Games.this.f4870a, "");
                    f92.b(string);
                    f92.c(string, "shortConfig.getString(sortDataKey, \"\")!!");
                    List listD0 = ec2.d0(string, new String[]{","}, false, 0, 6, null);
                    n92 n92Var = new n92();
                    Context context = Games.this.getContext();
                    f92.c(context, "context");
                    ?? C = new ri0(context).c();
                    n92Var.f6891a = C;
                    int length = C.length;
                    if (C.length > 1) {
                        s42.g(C, new d31(listD0, length));
                    }
                    Context context2 = Games.this.getContext();
                    f92.c(context2, "context");
                    kh0 kh0Var = new kh0(context2, false, 2, null);
                    n92 n92Var2 = new n92();
                    n92Var2.f6891a = new ArrayList();
                    for (String str : (String[]) n92Var.f6891a) {
                        AppInfo appInfoD = kh0Var.d(str);
                        if (appInfoD != null) {
                            ((ArrayList) n92Var2.f6891a).add(appInfoD);
                        }
                    }
                    fg2 fg2VarC = qe2.c();
                    c31 c31Var = new c31(this, n92Var2, n92Var, null);
                    this.f4877a = wd2Var;
                    this.f4878b = listD0;
                    this.f4879c = n92Var;
                    this.b = length;
                    this.d = kh0Var;
                    this.e = n92Var2;
                    this.c = 1;
                    if (oc2.g(fg2VarC, c31Var, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
            return m42.f6769a;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f8394a;

        public c(AppInfo appInfo) {
            this.f8394a = appInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = Games.this.getContext();
            f92.c(context, "context");
            new ri0(context).f(this.f8394a.getPackageName(), false);
            Games.this.r(this.f8394a);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ImageButton imageButton = (ImageButton) Games.this.a(t61.sort_confirm);
            f92.c(imageButton, "sort_confirm");
            imageButton.setVisibility(0);
            f92.c(view, "it");
            view.setVisibility(8);
            CheckBox checkBox = (CheckBox) Games.this.a(t61.lock);
            f92.c(checkBox, "lock");
            checkBox.setVisibility(8);
            Games.this.f4869a.d(true);
            RecyclerView recyclerView = (RecyclerView) Games.this.a(t61.games);
            f92.c(recyclerView, "games");
            RecyclerView.g adapter = recyclerView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppGrid2");
            }
            ((zz0) adapter).H(Games.this.f4869a.c());
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Games.this.f4869a.d(false);
            RecyclerView recyclerView = (RecyclerView) Games.this.a(t61.games);
            f92.c(recyclerView, "games");
            RecyclerView.g adapter = recyclerView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppGrid2");
            }
            zz0 zz0Var = (zz0) adapter;
            StringBuilder sb = new StringBuilder();
            for (AppInfo appInfo : zz0Var.D()) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(appInfo.getPackageName());
            }
            Games.this.getShortConfig().edit().clear().putString(Games.this.f4870a, sb.toString()).apply();
            zz0Var.H(Games.this.f4869a.c());
            ImageButton imageButton = (ImageButton) Games.this.a(t61.sort);
            f92.c(imageButton, "sort");
            imageButton.setVisibility(0);
            f92.c(view, "it");
            view.setVisibility(8);
            CheckBox checkBox = (CheckBox) Games.this.a(t61.lock);
            f92.c(checkBox, "lock");
            checkBox.setVisibility(0);
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            boolean zIsChecked = ((CompoundButton) view).isChecked();
            Scene.f4798a.k("games_visible", zIsChecked);
            RecyclerView recyclerView = (RecyclerView) Games.this.a(t61.games);
            f92.c(recyclerView, "games");
            recyclerView.setVisibility(zIsChecked ? 0 : 8);
            ImageButton imageButton = (ImageButton) Games.this.a(t61.sort);
            f92.c(imageButton, "sort");
            RecyclerView recyclerView2 = (RecyclerView) Games.this.a(t61.games);
            f92.c(recyclerView2, "games");
            imageButton.setVisibility(recyclerView2.getVisibility());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Games(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        this.f4869a = new z21();
        this.f4870a = "sorted_packages";
        s(context, attributeSet);
    }

    public static final /* synthetic */ u90 e(Games games) {
        u90 u90Var = games.f8391a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getShortConfig() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("apps_sort", 0);
        f92.c(sharedPreferences, "context.getSharedPrefere…t\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public View a(int i) {
        if (this.f4871a == null) {
            this.f4871a = new HashMap();
        }
        View view = (View) this.f4871a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f4871a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void k() {
        u90 u90Var = this.f8391a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(xd2.a(qe2.b()), null, null, new a(null), 3, null);
    }

    public final void l(ArrayList<String> arrayList) {
        if (arrayList.size() > 0) {
            Context context = getContext();
            f92.c(context, "context");
            new ri0(context).a(arrayList);
            o();
        }
    }

    public final void m(AppInfo appInfo) {
        n(appInfo.getPackageName());
    }

    public final void n(String str) {
        tw0.f3070a.f(str);
    }

    public final void o() {
        qc2.d(xd2.a(qe2.b()), null, null, new b(getShortConfig(), null), 3, null);
    }

    public final void p() {
        RecyclerView recyclerView = (RecyclerView) a(t61.games);
        zz0 zz0Var = (zz0) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (zz0Var != null) {
            zz0Var.i();
        }
    }

    public final void q(AppInfo appInfo) {
        p80.a aVar = p80.f2403a;
        Context context = getContext();
        f92.c(context, "context");
        String string = getContext().getString(u61.perf_game_remove);
        f92.c(string, "context.getString(R.string.perf_game_remove)");
        String string2 = getContext().getString(u61.perf_game_remove_desc);
        f92.c(string2, "context.getString(R.string.perf_game_remove_desc)");
        aVar.i(context, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new c(appInfo), (16 & 16) != 0 ? null : null);
    }

    public final void r(AppInfo appInfo) {
        RecyclerView recyclerView = (RecyclerView) a(t61.games);
        zz0 zz0Var = (zz0) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (zz0Var != null) {
            zz0Var.G(appInfo);
        }
    }

    public final void s(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.NavItem);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.NavItem)");
        LayoutInflater.from(context).inflate(2131558603, (ViewGroup) this, true);
        typedArrayObtainStyledAttributes.recycle();
        o();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        this.f8391a = new u90((Activity) context, null, 2, null);
        ((ImageButton) a(t61.sort)).setOnClickListener(new d());
        ((ImageButton) a(t61.sort_confirm)).setOnClickListener(new e());
        CheckBox checkBox = (CheckBox) a(t61.lock);
        f92.c(checkBox, "lock");
        checkBox.setChecked(Scene.f4798a.b("games_visible", true));
        ((CheckBox) a(t61.lock)).setOnClickListener(new f());
        RecyclerView recyclerView = (RecyclerView) a(t61.games);
        f92.c(recyclerView, "games");
        CheckBox checkBox2 = (CheckBox) a(t61.lock);
        f92.c(checkBox2, "lock");
        recyclerView.setVisibility(checkBox2.isChecked() ? 0 : 8);
        ImageButton imageButton = (ImageButton) a(t61.sort);
        f92.c(imageButton, "sort");
        RecyclerView recyclerView2 = (RecyclerView) a(t61.games);
        f92.c(recyclerView2, "games");
        imageButton.setVisibility(recyclerView2.getVisibility());
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        setAlpha(z ? 1.0f : 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(com.omarea.model.AppInfo r4) {
        /*
            r3 = this;
            java.lang.Boolean r0 = r4.enabled
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L15
            java.lang.Boolean r0 = r4.suspended
            java.lang.String r1 = "appInfo.suspended"
            a.f92.c(r0, r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L23
        L15:
            r3.m(r4)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r4.enabled = r0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.suspended = r0
            r3.p()
        L23:
            a.tw0$a r0 = a.tw0.f3070a
            a.tw0 r0 = r0.b()
            if (r0 == 0) goto L32
            java.lang.String r1 = r4.getPackageName()
            r0.F(r1)
        L32:
            a.x50 r0 = new a.x50
            android.content.Context r1 = r3.getContext()
            java.lang.String r2 = "this.context"
            a.f92.c(r1, r2)
            r0.<init>(r1)
            java.lang.String r4 = r4.getPackageName()
            r0.b(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.Games.t(com.omarea.model.AppInfo):void");
    }
}
