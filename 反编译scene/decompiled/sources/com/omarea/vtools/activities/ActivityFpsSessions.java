package com.omarea.vtools.activities;

import a.b62;
import a.co0;
import a.d42;
import a.d72;
import a.e50;
import a.f01;
import a.f92;
import a.g91;
import a.gb1;
import a.h42;
import a.hf2;
import a.hz0;
import a.ib1;
import a.jm0;
import a.k82;
import a.kb1;
import a.kh0;
import a.lb1;
import a.lh0;
import a.m42;
import a.mb1;
import a.p80;
import a.py0;
import a.py1;
import a.q92;
import a.qc2;
import a.qe2;
import a.qf2;
import a.r62;
import a.t61;
import a.tj0;
import a.u61;
import a.u90;
import a.v41;
import a.w41;
import a.wd2;
import a.x42;
import a.x62;
import a.xd2;
import a.z42;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import com.omarea.model.FpsWatchSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityFpsSessions extends g91 implements v41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8679a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f5281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qf2 f5282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5283a;
    public boolean b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f8680a;

        public a(AppInfo appInfo) {
            this.f8680a = appInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u90 u90Var = new u90(ActivityFpsSessions.this, null, 2, null);
            u90.e(u90Var, null, 1, null);
            qc2.d(xd2.a(qe2.b()), null, null, new gb1(u90Var, null, this), 3, null);
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityFpsSessions.this.z();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f8682a;

        public c(List list) {
            this.f8682a = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            co0 co0Var = new co0();
            Iterator it = this.f8682a.iterator();
            while (it.hasNext()) {
                co0Var.y((String) it.next());
            }
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFpsSessions$loadData$1", f = "ActivityFpsSessions.kt", l = {287, 297}, m = "invokeSuspend")
    public static final class d extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8683a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5286a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5287b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ boolean f5288b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z, b62 b62Var) {
            super(2, b62Var);
            this.f5288b = z;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d dVar = ActivityFpsSessions.this.new d(this.f5288b, b62Var);
            dVar.f8683a = (wd2) obj;
            return dVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((d) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:23:0x0121, B:26:0x0137], limit reached: 34 */
        /* JADX WARN: Path cross not found for [B:26:0x0137, B:23:0x0121], limit reached: 34 */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0121  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
        /* JADX WARN: Type inference failed for: r7v2, types: [T, java.util.ArrayList] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0107 -> B:21:0x0113). Please report as a decompilation issue!!! */
        @Override // a.s62
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 369
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFpsSessions.d.j(java.lang.Object):java.lang.Object");
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View viewInflate = LayoutInflater.from(ActivityFpsSessions.this).inflate(2131558514, (ViewGroup) null);
            CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.auto_upload);
            CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.upload_history);
            p80.a aVar = p80.f2403a;
            ActivityFpsSessions activityFpsSessions = ActivityFpsSessions.this;
            f92.c(viewInflate, "view");
            p80.b bVarT = p80.a.t(aVar, activityFpsSessions, viewInflate, false, 4, null);
            f92.c(compoundButton, "autoUpload");
            compoundButton.setChecked(hz0.f1282a.d());
            viewInflate.findViewById(2131362069).setOnClickListener(new ib1(bVarT));
            viewInflate.findViewById(2131362070).setOnClickListener(new kb1(this, compoundButton, compoundButton2, bVarT));
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (f92.a(e50.f677a.y0(), "basic")) {
                p80.a aVar = p80.f2403a;
                ActivityFpsSessions activityFpsSessions = ActivityFpsSessions.this;
                String string = activityFpsSessions.getString(u61.fps_adb_root_require);
                f92.c(string, "getString(R.string.fps_adb_root_require)");
                p80.a.C(aVar, activityFpsSessions, string, null, 4, null);
                return;
            }
            boolean z = !f92.a(py1.f7160a.a(), Boolean.TRUE);
            f92.c(view, "it");
            if (!z) {
                view.setRotation(0.0f);
                new py1(ActivityFpsSessions.this.getContext()).y(true);
                return;
            }
            view.setRotation(45.0f);
            new py1(ActivityFpsSessions.this.getContext()).C();
            p80.a aVar2 = p80.f2403a;
            ActivityFpsSessions activityFpsSessions2 = ActivityFpsSessions.this;
            String string2 = activityFpsSessions2.getContext().getString(u61.fps_tip);
            f92.c(string2, "context.getString(R.string.fps_tip)");
            p80.a.C(aVar2, activityFpsSessions2, string2, null, 4, null);
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFpsSessions.this.A();
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFpsSessions.this.z();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFpsSessions$uploadLocalData$1", f = "ActivityFpsSessions.kt", l = {}, m = "invokeSuspend")
    public static final class i extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8688a;
        public int b;

        public i(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            i iVar = ActivityFpsSessions.this.new i(b62Var);
            iVar.f8688a = (wd2) obj;
            return iVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((i) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            int i;
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            co0 co0Var = new co0();
            Iterator<FpsWatchSession> it = ActivityFpsSessions.o(ActivityFpsSessions.this).b0().iterator();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                FpsWatchSession next = it.next();
                Long l = next.sessionId;
                if (next.beginTime.longValue() > 1774972800000L) {
                    String str = next.cloudId;
                    if (str != null && str.length() != 0) {
                        z = false;
                    }
                    if (z && (i = next.duration) > 60 && i <= 3600) {
                        py0 py0VarO = ActivityFpsSessions.o(ActivityFpsSessions.this);
                        f92.c(l, "sessionId");
                        d42<String, String> d42VarB = co0Var.B(py0VarO.g(l.longValue()));
                        if (d42VarB != null) {
                            i3++;
                            ActivityFpsSessions.o(ActivityFpsSessions.this).c0(l.longValue(), d42VarB.c());
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (i2 <= 0 || i3 != 0) {
                ActivityFpsSessions.this.B(true);
            } else {
                Scene.c.p(Scene.f4798a, "数据上传失败，功能暂未开放", 0, 2, null);
            }
            return m42.f6769a;
        }
    }

    public static /* synthetic */ void C(ActivityFpsSessions activityFpsSessions, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        activityFpsSessions.B(z);
    }

    public static final /* synthetic */ py0 o(ActivityFpsSessions activityFpsSessions) {
        py0 py0Var = activityFpsSessions.f5281a;
        if (py0Var != null) {
            return py0Var;
        }
        f92.m("fpsWatchStore");
        throw null;
    }

    public final void A() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_apps_list);
        f92.c(recyclerView, "chart_apps_list");
        f01 f01Var = (f01) recyclerView.getAdapter();
        if (f01Var != null) {
            f01Var.G(true);
            this.b = true;
            ImageView imageView = (ImageView) _$_findCachedViewById(t61.chart_delete_confirm);
            f92.c(imageView, "chart_delete_confirm");
            imageView.setVisibility(0);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(t61.chart_add);
            f92.c(imageView2, "chart_add");
            imageView2.setVisibility(8);
            ImageView imageView3 = (ImageView) _$_findCachedViewById(t61.chart_delete);
            f92.c(imageView3, "chart_delete");
            imageView3.setVisibility(8);
        }
    }

    public final void B(boolean z) {
        if (isDestroyed()) {
            return;
        }
        qc2.d(hf2.f6309a, qe2.b(), null, new d(z, null), 2, null);
    }

    public final void D(int i2) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
        f92.c(recyclerView, "chart_sessions");
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.fps.AdapterSessions");
        }
        w41 w41Var = (w41) adapter;
        FpsWatchSession fpsWatchSessionB = w41Var.B(i2);
        py0 py0Var = this.f5281a;
        if (py0Var == null) {
            f92.m("fpsWatchStore");
            throw null;
        }
        Long l = fpsWatchSessionB.sessionId;
        f92.c(l, "item.sessionId");
        py0Var.d(l.longValue());
        String str = fpsWatchSessionB.cloudId;
        if (!(str == null || str.length() == 0)) {
            y(x42.b(fpsWatchSessionB.cloudId));
        }
        w41Var.E(i2);
        this.f8679a = w41Var.e();
    }

    public final void E(String str) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
        f92.c(recyclerView, "chart_sessions");
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.fps.AdapterSessions");
        }
        ((w41) adapter).A(str);
    }

    public final void F(ArrayList<FpsWatchSession> arrayList) {
        if (arrayList.size() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(t61.chart_sessions_empty);
            if (textView != null) {
                textView.setVisibility(8);
            }
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
            f92.c(recyclerView, "chart_sessions");
            recyclerView.setVisibility(0);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
            if (recyclerView2 != null) {
                w41 w41Var = new w41(getContext(), arrayList);
                w41Var.G(this);
                w41Var.H(new lb1(this));
                m42 m42Var = m42.f6769a;
                recyclerView2.setAdapter(w41Var);
            }
            kh0 kh0Var = new kh0(getContext(), false, 2, null);
            ArrayList<String> arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList(z42.m(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(((FpsWatchSession) it.next()).packageName);
            }
            ArrayList<String> arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                String str = (String) obj;
                if ((f92.a(str, "android") ^ true) && str != null) {
                    arrayList4.add(obj);
                }
            }
            for (String str2 : arrayList4) {
                if (!arrayList2.contains(str2)) {
                    arrayList2.add(str2);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            AppInfo appInfo = new AppInfo();
            appInfo.setPackageName("android");
            m42 m42Var2 = m42.f6769a;
            arrayList5.add(appInfo);
            for (String str3 : arrayList2) {
                AppInfo appInfoD = kh0Var.d(str3);
                if (appInfoD == null) {
                    appInfoD = new AppInfo();
                    appInfoD.setPackageName(str3);
                    m42 m42Var3 = m42.f6769a;
                }
                arrayList5.add(appInfoD);
            }
            ((RecyclerView) _$_findCachedViewById(t61.chart_apps_list)).setLayoutManager(new GridLayoutManager(getContext(), arrayList5.size()));
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(t61.chart_apps_list);
            f92.c(recyclerView3, "chart_apps_list");
            f01 f01Var = new f01(getContext(), arrayList5);
            f01Var.H(new mb1(this));
            m42 m42Var4 = m42.f6769a;
            recyclerView3.setAdapter(f01Var);
        } else {
            RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
            f92.c(recyclerView4, "chart_sessions");
            recyclerView4.setVisibility(8);
            TextView textView2 = (TextView) _$_findCachedViewById(t61.chart_sessions_empty);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        this.f8679a = arrayList.size();
    }

    public final void G() {
        this.f5282a = qc2.d(xd2.a(qe2.b()), null, null, new i(null), 3, null);
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5283a == null) {
            this.f5283a = new HashMap();
        }
        View view = (View) this.f5283a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5283a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.v41
    public void b(int i2) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
        f92.c(recyclerView, "chart_sessions");
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.fps.AdapterSessions");
        }
        FpsWatchSession fpsWatchSessionB = ((w41) adapter).B(i2);
        Intent intent = new Intent(getContext(), (Class<?>) ActivityFpsSession.class);
        Long l = fpsWatchSessionB.sessionId;
        f92.c(l, "item.sessionId");
        intent.putExtra("sessionId", l.longValue());
        intent.putExtra("appName", fpsWatchSessionB.appName);
        intent.putExtra("packageName", fpsWatchSessionB.packageName);
        Long l2 = fpsWatchSessionB.beginTime;
        f92.c(l2, "item.beginTime");
        intent.putExtra("beginTime", l2.longValue());
        m42 m42Var = m42.f6769a;
        startActivity(intent);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558450);
        setBackArrow();
        this.f5281a = new py0(this);
        ((ImageView) _$_findCachedViewById(t61.module_settings)).setOnClickListener(new e());
        TextView textView = (TextView) _$_findCachedViewById(t61.chart_platform);
        f92.c(textView, "chart_platform");
        String strA = jm0.f6525a.a();
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strA.toUpperCase();
        f92.c(upperCase, "(this as java.lang.String).toUpperCase()");
        textView.setText(upperCase);
        TextView textView2 = (TextView) _$_findCachedViewById(t61.chart_phone);
        f92.c(textView2, "chart_phone");
        String strA2 = new lh0().a();
        if (strA2 == null) {
            strA2 = Build.MODEL;
        }
        textView2.setText(strA2);
        TextView textView3 = (TextView) _$_findCachedViewById(t61.chart_os);
        f92.c(textView3, "chart_os");
        textView3.setText(tj0.f7508a.c(Build.VERSION.SDK_INT));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_sessions);
        f92.c(recyclerView, "chart_sessions");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((ImageView) _$_findCachedViewById(t61.chart_add)).setOnClickListener(new f());
        ((ImageView) _$_findCachedViewById(t61.chart_delete)).setOnClickListener(new g());
        ((ImageView) _$_findCachedViewById(t61.chart_delete_confirm)).setOnClickListener(new h());
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().w();
        setTitle(u61.menu_fps_chart);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        ImageView imageView = (ImageView) _$_findCachedViewById(t61.chart_add);
        f92.c(imageView, "chart_add");
        imageView.setRotation(f92.a(py1.f7160a.a(), Boolean.TRUE) ? 45.0f : 0.0f);
        C(this, false, 1, null);
    }

    public final void x(AppInfo appInfo) {
        String appName;
        if (f92.a(appInfo.getPackageName(), "android")) {
            appName = getString(u61.fps_all_apps);
            f92.c(appName, "getString(R.string.fps_all_apps)");
        } else {
            appName = appInfo.getAppName().length() > 0 ? appInfo.getAppName() : appInfo.getPackageName();
        }
        p80.a aVar = p80.f2403a;
        String string = getString(u61.fps_delete);
        f92.c(string, "getString(R.string.fps_delete)");
        q92 q92Var = q92.f7191a;
        String string2 = getString(u61.fps_delete_desc);
        f92.c(string2, "getString(R.string.fps_delete_desc)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{appName}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        aVar.i(this, string, str, new a(appInfo), new b());
    }

    public final void y(List<String> list) {
        p80.f2403a.i(this, (16 & 2) != 0 ? "" : "从云端删除", (16 & 4) != 0 ? "" : "是否同时从云端（SCENE数据共享中心）删除这些记录？", (16 & 8) != 0 ? null : new c(list), (16 & 16) != 0 ? null : null).i(false);
    }

    public final void z() {
        this.b = false;
        ImageView imageView = (ImageView) _$_findCachedViewById(t61.chart_delete);
        f92.c(imageView, "chart_delete");
        imageView.setVisibility(0);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(t61.chart_add);
        f92.c(imageView2, "chart_add");
        imageView2.setVisibility(0);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(t61.chart_delete_confirm);
        f92.c(imageView3, "chart_delete_confirm");
        imageView3.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.chart_apps_list);
        f92.c(recyclerView, "chart_apps_list");
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppIconList");
        }
        ((f01) adapter).G(false);
    }
}
