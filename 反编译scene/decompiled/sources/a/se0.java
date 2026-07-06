package a;

import a.p80;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class se0 extends wk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ie0 f7388a = new ie0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RunnableNode f2882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<String, String> f2883a;
    public Runnable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public HashMap f2884b;
    public View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Runnable f2885c;
    public String d;
    public int i;
    public boolean y;

    public static final /* synthetic */ Runnable F1(se0 se0Var) {
        Runnable runnable = se0Var.b;
        if (runnable != null) {
            return runnable;
        }
        f92.m("onExit");
        throw null;
    }

    public void C1() {
        HashMap map = this.f2884b;
        if (map != null) {
            map.clear();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        Dialog dialogX1;
        Window window;
        f92.d(view, "view");
        super.D0(view, bundle);
        cl clVarJ = j();
        if (clVarJ == null || (dialogX1 = x1()) == null || (window = dialogX1.getWindow()) == null) {
            return;
        }
        p80.f2403a.K(window, clVarJ);
    }

    public View D1(int i) {
        if (this.f2884b == null) {
            this.f2884b = new HashMap();
        }
        View view = (View) this.f2884b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewM = M();
        if (viewM == null) {
            return null;
        }
        View viewFindViewById = viewM.findViewById(i);
        this.f2884b.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void O1() {
        try {
            v1();
        } catch (Exception unused) {
        }
    }

    public final ShellHandlerBase P1(RunnableNode runnableNode) {
        n92 n92Var = new n92();
        n92Var.f6891a = null;
        ((ImageButton) D1(mb0.btn_hide)).setOnClickListener(new oe0(this));
        ((Button) D1(mb0.btn_exit)).setOnClickListener(new pe0(this, n92Var));
        ((Button) D1(mb0.btn_copy)).setOnClickListener(new qe0(this));
        if (runnableNode.getInterruptable()) {
            ImageButton imageButton = (ImageButton) D1(mb0.btn_hide);
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            Button button = (Button) D1(mb0.btn_exit);
            if (button != null) {
                button.setVisibility(0);
            }
        } else {
            ImageButton imageButton2 = (ImageButton) D1(mb0.btn_hide);
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
            }
            Button button2 = (Button) D1(mb0.btn_exit);
            if (button2 != null) {
                button2.setVisibility(8);
            }
        }
        if (runnableNode.getTitle().length() == 0) {
            TextView textView = (TextView) D1(mb0.title);
            f92.c(textView, "title");
            textView.setVisibility(8);
        } else {
            TextView textView2 = (TextView) D1(mb0.title);
            f92.c(textView2, "title");
            textView2.setText(runnableNode.getTitle());
        }
        if (runnableNode.getDesc().length() == 0) {
            TextView textView3 = (TextView) D1(mb0.desc);
            f92.c(textView3, "desc");
            textView3.setVisibility(8);
        } else {
            TextView textView4 = (TextView) D1(mb0.desc);
            f92.c(textView4, "desc");
            textView4.setText(runnableNode.getDesc());
        }
        ProgressBar progressBar = (ProgressBar) D1(mb0.action_progress);
        f92.c(progressBar, "action_progress");
        progressBar.setIndeterminate(true);
        re0 re0Var = new re0(this, runnableNode, n92Var);
        TextView textView5 = (TextView) D1(mb0.shell_output);
        f92.c(textView5, "shell_output");
        ProgressBar progressBar2 = (ProgressBar) D1(mb0.action_progress);
        f92.c(progressBar2, "action_progress");
        return new ne0(re0Var, textView5, progressBar2);
    }

    @Override // a.wk, androidx.fragment.app.Fragment
    public void Y(Bundle bundle) {
        super.Y(bundle);
        RunnableNode runnableNode = this.f2882a;
        if (runnableNode == null) {
            v1();
            return;
        }
        if (runnableNode != null) {
            if (runnableNode.getReloadPage()) {
                ImageButton imageButton = (ImageButton) D1(mb0.btn_hide);
                f92.c(imageButton, "btn_hide");
                imageButton.setVisibility(8);
            }
            ShellHandlerBase shellHandlerBaseP1 = P1(runnableNode);
            bd0 bd0Var = new bd0();
            cl clVarJ = j();
            String str = this.d;
            if (str == null) {
                f92.m("script");
                throw null;
            }
            Runnable runnable = this.b;
            if (runnable != null) {
                bd0Var.a(clVarJ, runnableNode, str, runnable, this.f2883a, shellHandlerBaseP1);
            } else {
                f92.m("onExit");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        View viewInflate = layoutInflater.inflate(nb0.kr_dialog_log, viewGroup);
        f92.c(viewInflate, "inflater.inflate(R.layou…kr_dialog_log, container)");
        this.c = viewInflate;
        if (viewInflate != null) {
            return viewInflate;
        }
        f92.m("currentView");
        throw null;
    }

    @Override // a.wk, androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        C1();
    }

    @Override // a.wk, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        f92.d(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Runnable runnable = this.f2885c;
        if (runnable != null) {
            runnable.run();
        }
        this.f2885c = null;
        cl clVarJ = j();
        if (clVarJ != null) {
            p80.a aVar = p80.f2403a;
            f92.c(clVarJ, "this");
            aVar.L(clVarJ);
        }
    }

    @Override // a.wk
    public Dialog y1(Bundle bundle) {
        cl clVarJ = j();
        f92.b(clVarJ);
        int i = this.i;
        if (i == 0) {
            i = pb0.kr_full_screen_dialog_light;
        }
        return new Dialog(clVarJ, i);
    }
}
