package a;

import a.p80;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ActionParamInfo;
import com.omarea.krscript.model.AutoRunTask;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.GroupNode;
import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import com.omarea.krscript.model.PickerNode;
import com.omarea.krscript.model.SwitchNode;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fe0 extends Fragment implements jf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ed0 f6097a = new ed0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x90 f887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ze0 f888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AutoRunTask f889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public KrScriptActionHandler f890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<NodeInfoBase> f891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f892a;
    public boolean t;

    public static final /* synthetic */ u90 B1(fe0 fe0Var) {
        u90 u90Var = fe0Var.f886a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("progressBarDialog");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        this.f886a = new u90(clVarJ, null, 2, null);
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "this.context!!");
        this.f888a = new ze0(contextP, true, new GroupNode(""));
        if (this.f891a != null) {
            Context contextP2 = p();
            f92.b(contextP2);
            f92.c(contextP2, "this.context!!");
            ArrayList<NodeInfoBase> arrayList = this.f891a;
            f92.b(arrayList);
            ze0 ze0Var = this.f888a;
            if (ze0Var == null) {
                f92.m("rootGroup");
                throw null;
            }
            new of0(contextP2, arrayList, this, ze0Var);
            ze0 ze0Var2 = this.f888a;
            if (ze0Var2 == null) {
                f92.m("rootGroup");
                throw null;
            }
            View viewD = ze0Var2.d();
            View viewM = M();
            ScrollView scrollView = viewM != null ? (ScrollView) viewM.findViewById(mb0.kr_content) : null;
            if (scrollView != null) {
                scrollView.removeAllViews();
            }
            if (scrollView != null) {
                scrollView.addView(viewD);
            }
            R1(this.f889a);
        }
    }

    public final void I1(ActionNode actionNode, Runnable runnable) {
        String setState = actionNode.getSetState();
        if (setState != null) {
            if (actionNode.getParams() != null) {
                ArrayList<ActionParamInfo> params = actionNode.getParams();
                f92.b(params);
                if (params.size() > 0) {
                    Context contextP = p();
                    f92.b(contextP);
                    View viewInflate = LayoutInflater.from(contextP).inflate(nb0.kr_params_list, (ViewGroup) null);
                    if (viewInflate == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
                    }
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    Handler handler = new Handler();
                    u90 u90Var = this.f886a;
                    if (u90Var == null) {
                        f92.m("progressBarDialog");
                        throw null;
                    }
                    Context contextP2 = p();
                    f92.b(contextP2);
                    String string = contextP2.getString(ob0.onloading);
                    f92.c(string, "this.context!!.getString(R.string.onloading)");
                    u90Var.d(string);
                    new Thread(new od0(this, params, handler, actionNode, linearLayout, setState, runnable)).start();
                    return;
                }
            }
            J1(actionNode, setState, runnable, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J1(com.omarea.krscript.model.RunnableNode r12, java.lang.String r13, java.lang.Runnable r14, java.util.HashMap<java.lang.String, java.lang.String> r15) {
        /*
            r11 = this;
            android.content.Context r1 = r11.p()
            a.f92.b(r1)
            java.lang.String r0 = "context!!"
            a.f92.c(r1, r0)
            java.lang.String r0 = r12.getShell()
            com.omarea.krscript.model.RunnableNode$Companion r2 = com.omarea.krscript.model.RunnableNode.Companion
            java.lang.String r2 = r2.getShellModeBgTask()
            boolean r0 = a.f92.a(r0, r2)
            if (r0 == 0) goto L2c
            a.pd0 r6 = new a.pd0
            r6.<init>(r11, r12)
            a.bb0 r0 = a.eb0.f716a
            r2 = r13
            r3 = r15
            r4 = r12
            r5 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L9d
        L2c:
            java.lang.String r0 = r12.getShell()
            com.omarea.krscript.model.RunnableNode$Companion r2 = com.omarea.krscript.model.RunnableNode.Companion
            java.lang.String r2 = r2.getShellModeHidden()
            boolean r0 = a.f92.a(r0, r2)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L6f
            boolean r0 = r11.t
            if (r0 == 0) goto L50
            int r12 = a.ob0.kr_hidden_task_running
            java.lang.String r12 = r11.J(r12)
            android.widget.Toast r12 = android.widget.Toast.makeText(r1, r12, r3)
            r12.show()
            goto L9d
        L50:
            r11.t = r2
            a.u90 r0 = r11.f886a
            r3 = 0
            if (r0 == 0) goto L69
            a.u90.e(r0, r3, r2, r3)
            a.qd0 r6 = new a.qd0
            r6.<init>(r11, r12)
            a.hb0 r0 = a.jb0.f1520a
            r2 = r13
            r3 = r15
            r4 = r12
            r5 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L9d
        L69:
            java.lang.String r12 = "progressBarDialog"
            a.f92.m(r12)
            throw r3
        L6f:
            a.rd0 r7 = new a.rd0
            r7.<init>(r11, r12)
            a.x90 r0 = r11.f887a
            if (r0 == 0) goto L83
            a.f92.b(r0)
            boolean r0 = r0.a()
            if (r0 == 0) goto L83
            r10 = r2
            goto L84
        L83:
            r10 = r3
        L84:
            a.ie0 r4 = a.se0.f7388a
            r5 = r12
            r6 = r14
            r8 = r13
            r9 = r15
            a.se0 r12 = r4.a(r5, r6, r7, r8, r9, r10)
            r12.z1(r3)
            a.jl r13 = r11.u()
            a.f92.b(r13)
            java.lang.String r14 = ""
            r12.B1(r13, r14)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fe0.J1(com.omarea.krscript.model.RunnableNode, java.lang.String, java.lang.Runnable, java.util.HashMap):void");
    }

    public final String K1(String str, NodeInfoBase nodeInfoBase) {
        Context contextP = p();
        f92.b(contextP);
        String strC = yc0.c(contextP, str, nodeInfoBase);
        f92.c(strC, "ScriptEnvironmen.execute…hellScript, nodeInfoBase)");
        return strC;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<a.n30> L1(com.omarea.krscript.model.ActionParamInfo r11, com.omarea.krscript.model.NodeInfoBase r12) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fe0.L1(com.omarea.krscript.model.ActionParamInfo, com.omarea.krscript.model.NodeInfoBase):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0145 A[PHI: r2
  0x0145: PHI (r2v4 java.lang.String) = 
  (r2v3 java.lang.String)
  (r2v12 java.lang.String)
  (r2v12 java.lang.String)
  (r2v12 java.lang.String)
  (r2v12 java.lang.String)
 binds: [B:32:0x0143, B:23:0x0122, B:25:0x012a, B:27:0x0132, B:29:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0147 A[PHI: r2
  0x0147: PHI (r2v10 java.lang.String) = (r2v3 java.lang.String), (r2v12 java.lang.String) binds: [B:32:0x0143, B:29:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean M1(com.omarea.krscript.model.ClickableNode r17) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fe0.M1(com.omarea.krscript.model.ClickableNode):boolean");
    }

    public final void N1(PickerNode pickerNode, Runnable runnable) {
        ActionParamInfo actionParamInfo = new ActionParamInfo();
        actionParamInfo.setOptions(pickerNode.getOptions());
        actionParamInfo.setOptionsSh(pickerNode.getOptionsSh());
        actionParamInfo.setSeparator(pickerNode.getSeparator());
        Handler handler = new Handler();
        u90 u90Var = this.f886a;
        if (u90Var == null) {
            f92.m("progressBarDialog");
            throw null;
        }
        String strJ = J(ob0.kr_param_options_load);
        f92.c(strJ, "getString(R.string.kr_param_options_load)");
        u90Var.d(strJ);
        new Thread(new ce0(this, pickerNode, actionParamInfo, handler, runnable)).start();
    }

    public final void O1(PickerNode pickerNode, String str, Runnable runnable) {
        String setState = pickerNode.getSetState();
        if (setState != null) {
            J1(pickerNode, setState, runnable, new de0(str));
        }
    }

    public final void P1(ArrayList<NodeInfoBase> arrayList, KrScriptActionHandler krScriptActionHandler, AutoRunTask autoRunTask, x90 x90Var) {
        if (arrayList != null) {
            this.f891a = arrayList;
            this.f890a = krScriptActionHandler;
            this.f889a = autoRunTask;
            this.f887a = x90Var;
        }
    }

    public final void Q1(SwitchNode switchNode, boolean z, Runnable runnable) {
        String setState = switchNode.getSetState();
        if (setState != null) {
            J1(switchNode, setState, runnable, new ee0(z));
        }
    }

    public final void R1(AutoRunTask autoRunTask) {
        if (autoRunTask != null) {
            String key = autoRunTask.getKey();
            if (key == null || key.length() == 0) {
                return;
            }
            ze0 ze0Var = this.f888a;
            if (ze0Var == null) {
                f92.m("rootGroup");
                throw null;
            }
            String key2 = autoRunTask.getKey();
            f92.b(key2);
            autoRunTask.onCompleted(Boolean.valueOf(ze0Var.k(key2)));
        }
    }

    @Override // a.jf0
    public void a(SwitchNode switchNode, Runnable runnable) {
        p80.a aVar;
        cl clVarJ;
        String title;
        String warning;
        Runnable zd0Var;
        f92.d(switchNode, "item");
        f92.d(runnable, "onCompleted");
        if (M1(switchNode)) {
            boolean z = !switchNode.getChecked();
            if (switchNode.getConfirm()) {
                aVar = p80.f2403a;
                clVarJ = j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                title = switchNode.getTitle();
                warning = switchNode.getDesc();
                zd0Var = new yd0(this, switchNode, z, runnable);
            } else {
                if (!(switchNode.getWarning().length() > 0)) {
                    Q1(switchNode, z, runnable);
                    return;
                }
                aVar = p80.f2403a;
                clVarJ = j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                title = switchNode.getTitle();
                warning = switchNode.getWarning();
                zd0Var = new zd0(this, switchNode, z, runnable);
            }
            aVar.M(clVarJ, (16 & 2) != 0 ? "" : title, (16 & 4) != 0 ? "" : warning, (16 & 8) != 0 ? null : zd0Var, (16 & 16) != 0 ? null : null);
        }
    }

    @Override // a.jf0
    public void b(PickerNode pickerNode, Runnable runnable) {
        p80.a aVar;
        cl clVarJ;
        String title;
        String warning;
        Runnable xd0Var;
        f92.d(pickerNode, "item");
        f92.d(runnable, "onCompleted");
        if (M1(pickerNode)) {
            if (pickerNode.getConfirm()) {
                aVar = p80.f2403a;
                clVarJ = j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                title = pickerNode.getTitle();
                warning = pickerNode.getDesc();
                xd0Var = new wd0(this, pickerNode, runnable);
            } else {
                if (!(pickerNode.getWarning().length() > 0)) {
                    N1(pickerNode, runnable);
                    return;
                }
                aVar = p80.f2403a;
                clVarJ = j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                title = pickerNode.getTitle();
                warning = pickerNode.getWarning();
                xd0Var = new xd0(this, pickerNode, runnable);
            }
            aVar.M(clVarJ, (16 & 2) != 0 ? "" : title, (16 & 4) != 0 ? "" : warning, (16 & 8) != 0 ? null : xd0Var, (16 & 16) != 0 ? null : null);
        }
    }

    @Override // a.jf0
    public void c(PageNode pageNode, Runnable runnable) {
        f92.d(pageNode, "item");
        f92.d(runnable, "onCompleted");
        if (M1(pageNode)) {
            if (p() != null) {
                if (pageNode.getLink().length() > 0) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pageNode.getLink()));
                        intent.addFlags(268435456);
                        Context contextP = p();
                        if (contextP != null) {
                            contextP.startActivity(intent);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        Context contextP2 = p();
                        Context contextP3 = p();
                        Toast.makeText(contextP2, contextP3 != null ? contextP3.getString(ob0.kr_slice_activity_fail) : null, 0).show();
                        return;
                    }
                }
            }
            if (p() != null) {
                if (pageNode.getActivity().length() > 0) {
                    Context contextP4 = p();
                    f92.b(contextP4);
                    f92.c(contextP4, "context!!");
                    new qb0(contextP4, pageNode.getActivity()).b();
                    return;
                }
            }
            KrScriptActionHandler krScriptActionHandler = this.f890a;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.onSubPageClick(pageNode);
            }
        }
    }

    @Override // a.jf0
    public void d(ClickableNode clickableNode) {
        f92.d(clickableNode, "clickableNode");
        if (!(clickableNode.getKey().length() == 0)) {
            KrScriptActionHandler krScriptActionHandler = this.f890a;
            if (krScriptActionHandler != null) {
                krScriptActionHandler.addToFavorites(clickableNode, new vd0(this));
                return;
            }
            return;
        }
        p80.a aVar = p80.f2403a;
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        String strJ = J(ob0.kr_shortcut_create_fail);
        f92.c(strJ, "getString(R.string.kr_shortcut_create_fail)");
        String strJ2 = J(ob0.kr_ushortcut_nsupported);
        f92.c(strJ2, "getString(R.string.kr_ushortcut_nsupported)");
        p80.a.b(aVar, clVarJ, strJ, strJ2, null, 8, null);
    }

    @Override // a.jf0
    public void e(ActionNode actionNode, Runnable runnable) {
        p80.a aVar;
        cl clVarJ;
        String title;
        String warning;
        Runnable td0Var;
        ArrayList<ActionParamInfo> params;
        f92.d(actionNode, "item");
        f92.d(runnable, "onCompleted");
        if (M1(actionNode)) {
            if (actionNode.getConfirm()) {
                aVar = p80.f2403a;
                clVarJ = j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                title = actionNode.getTitle();
                warning = actionNode.getDesc();
                td0Var = new sd0(this, actionNode, runnable);
            } else {
                if (!(actionNode.getWarning().length() > 0) || (actionNode.getParams() != null && ((params = actionNode.getParams()) == null || params.size() != 0))) {
                    I1(actionNode, runnable);
                    return;
                }
                aVar = p80.f2403a;
                clVarJ = j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                title = actionNode.getTitle();
                warning = actionNode.getWarning();
                td0Var = new td0(this, actionNode, runnable);
            }
            aVar.M(clVarJ, (16 & 2) != 0 ? "" : title, (16 & 4) != 0 ? "" : warning, (16 & 8) != 0 ? null : td0Var, (16 & 16) != 0 ? null : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        return layoutInflater.inflate(nb0.kr_action_list_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        v1();
    }

    public void v1() {
        HashMap map = this.f892a;
        if (map != null) {
            map.clear();
        }
    }
}
