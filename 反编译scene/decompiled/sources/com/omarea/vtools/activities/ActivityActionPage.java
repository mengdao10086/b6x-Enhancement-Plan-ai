package com.omarea.vtools.activities;

import a.b60;
import a.dd0;
import a.e71;
import a.eg0;
import a.f71;
import a.f92;
import a.g71;
import a.g91;
import a.ie0;
import a.m42;
import a.mc0;
import a.n92;
import a.o32;
import a.pc0;
import a.pf0;
import a.qb0;
import a.se0;
import a.u61;
import a.u90;
import a.yc0;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.PageMenuOption;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.RunnableNode;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityActionPage extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public eg0 f5090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PageNode f5093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<PageMenuOption> f5096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5097a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5098b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u90 f5091a = new u90(this, null, 2, null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f5092a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5095a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f5094a = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8468a = 65400;
    public final int b = 65300;

    public static final class a implements KrScriptActionHandler {
        public a() {
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void addToFavorites(ClickableNode clickableNode, KrScriptActionHandler.AddToFavoritesHandler addToFavoritesHandler) {
            PageNode pageNodeO;
            f92.d(clickableNode, "clickableNode");
            f92.d(addToFavoritesHandler, "addToFavoritesHandler");
            if (clickableNode instanceof PageNode) {
                pageNodeO = (PageNode) clickableNode;
            } else if (!(clickableNode instanceof RunnableNode)) {
                return;
            } else {
                pageNodeO = ActivityActionPage.o(ActivityActionPage.this);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(ActivityActionPage.this.getApplicationContext(), (Class<?>) ActivityActionPage.class));
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
            if (clickableNode instanceof RunnableNode) {
                intent.putExtra("autoRunItemId", clickableNode.getKey());
            }
            intent.putExtra("page", pageNodeO);
            addToFavoritesHandler.onAddToFavorites(clickableNode, intent);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void onActionCompleted(RunnableNode runnableNode) {
            f92.d(runnableNode, "runnableNode");
            if (runnableNode.getAutoFinish()) {
                if ((ActivityActionPage.this.f5095a.length() > 0) && f92.a(runnableNode.getKey(), ActivityActionPage.this.f5095a)) {
                    ActivityActionPage.this.finishAndRemoveTask();
                    return;
                }
            }
            if (runnableNode.getReloadPage()) {
                ActivityActionPage.this.D();
            }
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public void onSubPageClick(PageNode pageNode) {
            f92.d(pageNode, "pageNode");
            ActivityActionPage.this.j(pageNode);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public boolean openFileChooser(eg0 eg0Var) {
            f92.d(eg0Var, "fileSelectedInterface");
            return ActivityActionPage.this.z(eg0Var);
        }

        @Override // com.omarea.krscript.model.KrScriptActionHandler
        public boolean openParamsPage(ActionNode actionNode, View view, Runnable runnable) {
            f92.d(actionNode, "actionNode");
            f92.d(view, "view");
            f92.d(runnable, "onCompleted");
            return KrScriptActionHandler.DefaultImpls.openParamsPage(this, actionNode, view, runnable);
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityActionPage.this.f5091a.c();
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ActivityActionPage b;

        public c(ActivityActionPage activityActionPage) {
            this.b = activityActionPage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v27, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v30, types: [T, java.util.ArrayList] */
        @Override // java.lang.Runnable
        public final void run() {
            PageNode pageNodeO = ActivityActionPage.o(ActivityActionPage.this);
            if (pageNodeO.getBeforeRead().length() > 0) {
                ActivityActionPage activityActionPage = ActivityActionPage.this;
                String string = activityActionPage.getString(2131886980);
                f92.c(string, "getString(R.string.kr_page_before_load)");
                activityActionPage.H(string);
                yc0.c(this.b, pageNodeO.getBeforeRead(), ActivityActionPage.o(ActivityActionPage.this));
            }
            ActivityActionPage activityActionPage2 = ActivityActionPage.this;
            String string2 = activityActionPage2.getString(2131886983);
            f92.c(string2, "getString(R.string.kr_page_loading)");
            activityActionPage2.H(string2);
            n92 n92Var = new n92();
            n92Var.f6891a = null;
            if (pageNodeO.getPageConfigSh().length() > 0) {
                n92Var.f6891a = new pc0(ActivityActionPage.this, pageNodeO.getPageConfigSh(), pageNodeO).b();
            }
            if (((ArrayList) n92Var.f6891a) == null) {
                if (pageNodeO.getPageConfigPath().length() > 0) {
                    n92Var.f6891a = new mc0(ActivityActionPage.this, pageNodeO.getPageConfigPath(), pageNodeO.getPageConfigDir()).i();
                }
            }
            if (pageNodeO.getAfterRead().length() > 0) {
                ActivityActionPage activityActionPage3 = ActivityActionPage.this;
                String string3 = activityActionPage3.getString(2131886979);
                f92.c(string3, "getString(R.string.kr_page_after_load)");
                activityActionPage3.H(string3);
                yc0.c(this.b, pageNodeO.getAfterRead(), pageNodeO);
            }
            ArrayList arrayList = (ArrayList) n92Var.f6891a;
            if (arrayList != null && arrayList.size() != 0) {
                if (pageNodeO.getLoadSuccess().length() > 0) {
                    ActivityActionPage activityActionPage4 = ActivityActionPage.this;
                    String string4 = activityActionPage4.getString(2131886982);
                    f92.c(string4, "getString(R.string.kr_page_load_success)");
                    activityActionPage4.H(string4);
                    yc0.c(this.b, pageNodeO.getLoadSuccess(), pageNodeO);
                }
                ActivityActionPage.this.f5092a.post(new e71(n92Var, this));
                return;
            }
            if (pageNodeO.getLoadFail().length() > 0) {
                ActivityActionPage activityActionPage5 = ActivityActionPage.this;
                String string5 = activityActionPage5.getString(2131886981);
                f92.c(string5, "getString(R.string.kr_page_load_fail)");
                activityActionPage5.H(string5);
                yc0.c(this.b, pageNodeO.getLoadFail(), pageNodeO);
                ActivityActionPage.this.C();
            }
            ActivityActionPage.this.f5092a.post(new f71(this));
            ActivityActionPage.this.C();
            ActivityActionPage.this.finish();
        }
    }

    public static final class d implements eg0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageMenuOption f8472a;

        public d(PageMenuOption pageMenuOption) {
            this.f8472a = pageMenuOption;
        }

        @Override // a.eg0
        public String a() {
            if (this.f8472a.getSuffix().length() == 0) {
                return null;
            }
            return this.f8472a.getSuffix();
        }

        @Override // a.eg0
        public int b() {
            String type = this.f8472a.getType();
            int iHashCode = type.hashCode();
            if (iHashCode != -1268966290) {
                if (iHashCode == 3143036) {
                    type.equals("file");
                }
            } else if (type.equals("folder")) {
                return eg0.f5999a.b();
            }
            return eg0.f5999a.a();
        }

        @Override // a.eg0
        public String c() {
            if (this.f8472a.getMime().length() == 0) {
                return null;
            }
            return this.f8472a.getMime();
        }

        @Override // a.eg0
        public void d(String str) {
            if (str != null) {
                ActivityActionPage.this.f5092a.post(new g71(this, str));
            }
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f8473a = new e();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageMenuOption f8474a;

        public f(PageMenuOption pageMenuOption) {
            this.f8474a = pageMenuOption;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f8474a.getAutoFinish()) {
                ActivityActionPage.this.finish();
            } else if (this.f8474a.getReloadPage()) {
                ActivityActionPage.this.recreate();
            } else {
                this.f8474a.getUpdateBlocks();
            }
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5101a;

        public g(String str) {
            this.f5101a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityActionPage.this.f5091a.d(this.f5101a);
        }
    }

    public static final /* synthetic */ PageNode o(ActivityActionPage activityActionPage) {
        PageNode pageNode = activityActionPage.f5093a;
        if (pageNode != null) {
            return pageNode;
        }
        f92.m("currentPageConfig");
        throw null;
    }

    public final void A() {
        try {
            Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
            intent.putExtra("mode", ActivityFileSelector.f8644a.d());
            startActivityForResult(intent, this.b);
        } catch (Exception unused) {
            Toast.makeText(this, "启动内置文件选择器失败！", 0).show();
        }
    }

    public final String B(Uri uri) {
        try {
            return new b60().f(this, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void C() {
        this.f5092a.post(new b());
    }

    public final void D() {
        new Thread(new c(this)).start();
    }

    public final void E(PageMenuOption pageMenuOption) {
        z(new d(pageMenuOption));
    }

    public final void F(PageMenuOption pageMenuOption, HashMap<String, String> map) {
        f fVar = new f(pageMenuOption);
        boolean zA = getThemeMode().a();
        ie0 ie0Var = se0.f7388a;
        e eVar = e.f8473a;
        PageNode pageNode = this.f5093a;
        if (pageNode == null) {
            f92.m("currentPageConfig");
            throw null;
        }
        se0 se0VarA = ie0Var.a(pageMenuOption, eVar, fVar, pageNode.getPageHandlerSh(), map, zA);
        se0VarA.B1(getSupportFragmentManager(), "");
        se0VarA.z1(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r0.equals("exit") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0.equals("reload") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        recreate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r0.equals("finish") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r0.equals("refresh") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.equals("close") != false) goto L22;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(com.omarea.krscript.model.PageMenuOption r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getType()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1274442605: goto L3f;
                case -934641255: goto L33;
                case 3127582: goto L2a;
                case 3143036: goto L1e;
                case 94756344: goto L15;
                case 1085444827: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L4b
        Lc:
            java.lang.String r1 = "refresh"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            goto L3b
        L15:
            java.lang.String r1 = "close"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            goto L47
        L1e:
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            r3.E(r4)
            goto L67
        L2a:
            java.lang.String r1 = "exit"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            goto L47
        L33:
            java.lang.String r1 = "reload"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
        L3b:
            r3.recreate()
            goto L67
        L3f:
            java.lang.String r1 = "finish"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
        L47:
            r3.finish()
            goto L67
        L4b:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = r4.getKey()
            java.lang.String r2 = "state"
            r0.put(r2, r1)
            java.lang.String r1 = r4.getKey()
            java.lang.String r2 = "menu_id"
            r0.put(r2, r1)
            a.m42 r1 = a.m42.f6769a
            r3.F(r4, r0)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityActionPage.G(com.omarea.krscript.model.PageMenuOption):void");
    }

    public final void H(String str) {
        this.f5092a.post(new g(str));
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5097a == null) {
            this.f5097a = new HashMap();
        }
        View view = (View) this.f5097a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5097a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void j(PageNode pageNode) {
        f92.d(pageNode, "pageNode");
        o32.b(new o32(this), pageNode, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f A[PHI: r0 r1
  0x001f: PHI (r0v6 java.lang.String) = (r0v3 java.lang.String), (r0v9 java.lang.String) binds: [B:26:0x003e, B:13:0x001d] A[DONT_GENERATE, DONT_INLINE]
  0x001f: PHI (r1v2 a.eg0) = (r1v1 a.eg0), (r1v4 a.eg0) binds: [B:26:0x003e, B:13:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // a.cl, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            int r0 = r3.f8468a
            r1 = -1
            r2 = 0
            if (r4 != r0) goto L2b
            if (r6 == 0) goto L10
            if (r5 == r1) goto Lb
            goto L10
        Lb:
            android.net.Uri r0 = r6.getData()
            goto L11
        L10:
            r0 = r2
        L11:
            a.eg0 r1 = r3.f5090a
            if (r1 == 0) goto L28
            if (r0 == 0) goto L23
            java.lang.String r0 = r3.B(r0)
            a.eg0 r1 = r3.f5090a
            if (r1 == 0) goto L28
        L1f:
            r1.d(r0)
            goto L28
        L23:
            if (r1 == 0) goto L28
            r1.d(r2)
        L28:
            r3.f5090a = r2
            goto L41
        L2b:
            int r0 = r3.b
            if (r4 != r0) goto L41
            if (r6 == 0) goto L3b
            if (r5 == r1) goto L34
            goto L3b
        L34:
            java.lang.String r0 = "file"
            java.lang.String r0 = r6.getStringExtra(r0)
            goto L3c
        L3b:
            r0 = r2
        L3c:
            a.eg0 r1 = r3.f5090a
            if (r1 == 0) goto L28
            goto L1f
        L41:
            super.onActivityResult(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityActionPage.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle extras;
        PageNode pageNodeD;
        super.onCreate(bundle);
        setContentView(2131558428);
        setBackArrow();
        Intent intent = getIntent();
        f92.c(intent, "intent");
        if (intent.getExtras() != null && (extras = intent.getExtras()) != null && (extras.containsKey("page") || extras.containsKey("shortcutId"))) {
            String str = "";
            if (extras.containsKey("page")) {
                pageNodeD = (PageNode) extras.getSerializable("page");
            } else {
                pageNodeD = new dd0(this).d("" + extras.getString("shortcutId"));
            }
            if (pageNodeD != null) {
                if (extras.containsKey("autoRunItemId")) {
                    str = "" + extras.getString("autoRunItemId");
                }
                this.f5095a = str;
                if ((pageNodeD.getActivity().length() > 0) && new qb0(this, pageNodeD.getActivity()).b()) {
                    finish();
                    return;
                }
                if (pageNodeD.getOnlineHtmlPage().length() > 0) {
                    try {
                        Intent intent2 = new Intent(this, (Class<?>) ActionPageOnline.class);
                        intent2.addFlags(268435456);
                        intent2.putExtra("config", pageNodeD.getOnlineHtmlPage());
                        m42 m42Var = m42.f6769a;
                        startActivity(intent2);
                    } catch (Exception unused) {
                    }
                }
                if (pageNodeD.getTitle().length() > 0) {
                    setTitle(pageNodeD.getTitle());
                }
                this.f5093a = pageNodeD;
            } else {
                Toast.makeText(this, "页面信息无效", 0).show();
                finish();
            }
        }
        PageNode pageNode = this.f5093a;
        if (pageNode == null) {
            f92.m("currentPageConfig");
            throw null;
        }
        if (pageNode.getPageConfigPath().length() == 0) {
            PageNode pageNode2 = this.f5093a;
            if (pageNode2 == null) {
                f92.m("currentPageConfig");
                throw null;
            }
            if (pageNode2.getPageConfigSh().length() == 0) {
                setResult(2);
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f5096a == null) {
            Context applicationContext = getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            PageNode pageNode = this.f5093a;
            if (pageNode == null) {
                f92.m("currentPageConfig");
                throw null;
            }
            this.f5096a = new pf0(applicationContext, pageNode).a();
        }
        ArrayList<PageMenuOption> arrayList = this.f5096a;
        if (arrayList == null || menu == null) {
            return true;
        }
        f92.b(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArrayList<PageMenuOption> arrayList2 = this.f5096a;
            f92.b(arrayList2);
            PageMenuOption pageMenuOption = arrayList2.get(i);
            f92.c(pageMenuOption, "menuOptions!![i]");
            PageMenuOption pageMenuOption2 = pageMenuOption;
            if (pageMenuOption2.isFab()) {
                x(pageMenuOption2);
            } else {
                menu.add(-1, i, i, pageMenuOption2.getTitle());
            }
        }
        return true;
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        if (isTaskRoot()) {
            excludeFromRecent();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        ArrayList<PageMenuOption> arrayList = this.f5096a;
        if (arrayList == null) {
            return false;
        }
        f92.b(arrayList);
        PageMenuOption pageMenuOption = arrayList.get(menuItem.getItemId());
        f92.c(pageMenuOption, "menuOptions!![item.itemId]");
        G(pageMenuOption);
        return true;
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f5098b) {
            return;
        }
        D();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(com.omarea.krscript.model.PageMenuOption r7) {
        /*
            r6 = this;
            int r0 = a.t61.action_page_fab
            android.view.View r0 = r6._$_findCachedViewById(r0)
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r0
            r1 = 0
            r0.setVisibility(r1)
            a.c71 r2 = new a.c71
            r2.<init>(r6, r7)
            r0.setOnClickListener(r2)
            java.lang.String r2 = r7.getType()
            java.lang.String r3 = "file"
            boolean r2 = a.f92.a(r2, r3)
            r3 = 1
            if (r2 == 0) goto L38
            java.lang.String r2 = r7.getIconPath()
            int r2 = r2.length()
            if (r2 != 0) goto L2d
            r2 = r3
            goto L2e
        L2d:
            r2 = r1
        L2e:
            if (r2 == 0) goto L38
            r7 = 2131231021(0x7f08012d, float:1.8078111E38)
            android.graphics.drawable.Drawable r7 = r6.getDrawable(r7)
            goto L62
        L38:
            java.lang.String r2 = r7.getIconPath()
            int r2 = r2.length()
            if (r2 <= 0) goto L43
            goto L44
        L43:
            r3 = r1
        L44:
            r2 = 2131231020(0x7f08012c, float:1.807811E38)
            if (r3 == 0) goto L5e
            a.jc0 r3 = new a.jc0
            r3.<init>()
            android.content.Context r4 = r0.getContext()
            java.lang.String r5 = "context"
            a.f92.c(r4, r5)
            android.graphics.drawable.Drawable r7 = r3.d(r4, r7, r1)
            if (r7 == 0) goto L5e
            goto L62
        L5e:
            android.graphics.drawable.Drawable r7 = r6.getDrawable(r2)
        L62:
            r0.setImageDrawable(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityActionPage.x(com.omarea.krscript.model.PageMenuOption):void");
    }

    public final void y(String str) {
        try {
            Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
            intent.putExtra("extension", str);
            intent.putExtra("mode", ActivityFileSelector.f8644a.c());
            startActivityForResult(intent, this.b);
        } catch (Exception unused) {
            Toast.makeText(this, "启动内置文件选择器失败！", 0).show();
        }
    }

    public final boolean z(eg0 eg0Var) {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 2);
            Toast.makeText(this, getString(u61.kr_write_external_storage), 1).show();
            return false;
        }
        try {
            if (eg0Var.b() == eg0.f5999a.b()) {
                A();
            } else {
                String strA = eg0Var.a();
                if (strA == null || strA.length() == 0) {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    String strC = eg0Var.c();
                    if (strC == null) {
                        strC = "*/*";
                    }
                    intent.setType(strC);
                    intent.addCategory("android.intent.category.OPENABLE");
                    startActivityForResult(intent, this.f8468a);
                } else {
                    y(strA);
                }
            }
            this.f5090a = eg0Var;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
