package com.flydigi.community.ui.comment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.KeyboardUtils;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.community.R;
import kotlin.Pair;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class InputDialogFragment extends BaseDialogFragment {

    @yt.k
    public static final a I8 = new a(null);

    @yt.k
    public static final String J8 = "key_text";
    public y5.g E8;

    @yt.l
    public String F8;

    @yt.l
    public Boolean G8 = Boolean.FALSE;
    public b H8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ InputDialogFragment b(a aVar, CharSequence charSequence, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charSequence = null;
            }
            return aVar.a(charSequence);
        }

        @yt.k
        public final InputDialogFragment a(@yt.l CharSequence charSequence) {
            InputDialogFragment inputDialogFragment = new InputDialogFragment();
            inputDialogFragment.c5(androidx.core.os.e.b(new Pair(InputDialogFragment.J8, charSequence)));
            return inputDialogFragment;
        }
    }

    public interface b {
        void S0(@yt.k String str);

        void W0(@yt.k String str);
    }

    public static final void j6(InputDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        KeyboardUtils.k(this$0.i6().f56331b);
        b bVar = this$0.H8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.S0(this$0.i6().f56331b.getText().toString());
        this$0.e6();
    }

    public static final boolean k6(InputDialogFragment this$0, TextView textView, int i10, KeyEvent keyEvent) {
        f0.p(this$0, "this$0");
        if (i10 != 4) {
            return false;
        }
        KeyboardUtils.k(this$0.i6().f56331b);
        b bVar = this$0.H8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.W0(this$0.i6().f56331b.getText().toString());
        return true;
    }

    public static /* synthetic */ void o6(InputDialogFragment inputDialogFragment, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        inputDialogFragment.n6(str, bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.H8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        W5(2, R.style.DialogTheme);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        y5.g gVarD = y5.g.d(inflater, viewGroup, false);
        f0.o(gVarD, "inflate(inflater, container, false)");
        l6(gVarD);
        ConstraintLayout constraintLayoutB = i6().getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        KeyboardUtils.k(i6().f56331b);
        super.R3();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.community_dialog_input_text;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        Window window;
        super.f4();
        Dialog dialogL5 = L5();
        if (dialogL5 == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        f0.o(attributes, "it.attributes");
        attributes.width = -1;
        attributes.height = -1;
        window.setSoftInputMode(16);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        L5();
    }

    @yt.k
    public final y5.g i6() {
        y5.g gVar = this.E8;
        if (gVar != null) {
            return gVar;
        }
        f0.S("viewBinding");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j4(@yt.k android.view.View r4, @yt.l android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.f0.p(r4, r0)
            super.j4(r4, r5)
            y5.g r4 = r3.i6()
            android.widget.EditText r4 = r4.f56331b
            com.blankj.utilcode.util.KeyboardUtils.s(r4)
            y5.g r4 = r3.i6()
            androidx.constraintlayout.widget.ConstraintLayout r4 = r4.getRoot()
            com.flydigi.community.ui.comment.v r5 = new com.flydigi.community.ui.comment.v
            r5.<init>()
            com.blankj.utilcode.util.o.r(r4, r5)
            android.os.Bundle r4 = r3.T1()
            java.lang.String r5 = "key_text"
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L3e
            java.lang.String r4 = r4.getString(r5)
            if (r4 == 0) goto L3e
            int r4 = r4.length()
            if (r4 <= 0) goto L39
            r4 = 1
            goto L3a
        L39:
            r4 = 0
        L3a:
            if (r4 != r0) goto L3e
            r4 = 1
            goto L3f
        L3e:
            r4 = 0
        L3f:
            if (r4 == 0) goto L56
            y5.g r4 = r3.i6()
            android.widget.EditText r4 = r4.f56331b
            android.os.Bundle r2 = r3.T1()
            if (r2 == 0) goto L52
            java.lang.String r5 = r2.getString(r5)
            goto L53
        L52:
            r5 = 0
        L53:
            r4.setText(r5)
        L56:
            y5.g r4 = r3.i6()
            android.widget.EditText r4 = r4.f56331b
            java.lang.Boolean r5 = r3.G8
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.f0.g(r5, r2)
            if (r5 == 0) goto L7d
            java.lang.String r5 = r3.F8
            if (r5 == 0) goto L76
            int r2 = com.flydigi.community.R.string.community_reply_to
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.String r5 = r3.d3(r2, r0)
            if (r5 != 0) goto L83
        L76:
            int r5 = com.flydigi.community.R.string.community_say_something
            java.lang.String r5 = r3.c3(r5)
            goto L83
        L7d:
            int r5 = com.flydigi.community.R.string.community_say_something
            java.lang.String r5 = r3.c3(r5)
        L83:
            r4.setHint(r5)
            y5.g r4 = r3.i6()
            android.widget.EditText r4 = r4.f56331b
            com.flydigi.community.ui.comment.w r5 = new com.flydigi.community.ui.comment.w
            r5.<init>()
            r4.setOnEditorActionListener(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.community.ui.comment.InputDialogFragment.j4(android.view.View, android.os.Bundle):void");
    }

    public final void l6(@yt.k y5.g gVar) {
        f0.p(gVar, "<set-?>");
        this.E8 = gVar;
    }

    public final void m6() {
        Dialog dialogL5 = L5();
        if (dialogL5 != null) {
            dialogL5.show();
        }
        KeyboardUtils.s(i6().f56331b);
    }

    public final void n6(@yt.l String str, @yt.l Boolean bool) {
        this.F8 = str;
        this.G8 = bool;
    }
}
