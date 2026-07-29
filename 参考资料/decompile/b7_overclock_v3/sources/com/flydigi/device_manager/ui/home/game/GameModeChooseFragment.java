package com.flydigi.device_manager.ui.home.game;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import kotlin.Pair;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nGaameModeChooseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GaameModeChooseFragment.kt\ncom/flydigi/device_manager/ui/home/game/GameModeChooseFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,194:1\n1#2:195\n*E\n"})
public final class GameModeChooseFragment extends BaseDialogFragment {

    @yt.k
    public static final a I8 = new a(null);
    public static final int J8 = 0;
    public static final int K8 = 1;

    @yt.k
    public static final String L8 = "key_game";

    @yt.k
    public static final String M8 = "key_game_mode";
    public int E8;

    @yt.l
    public b F8;

    @yt.l
    public String G8;
    public c7.x H8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final GameModeChooseFragment a(@yt.k String packageName, int i10) {
            kotlin.jvm.internal.f0.p(packageName, "packageName");
            GameModeChooseFragment gameModeChooseFragment = new GameModeChooseFragment();
            gameModeChooseFragment.c5(androidx.core.os.e.b(new Pair(GameModeChooseFragment.L8, packageName), new Pair(GameModeChooseFragment.M8, Integer.valueOf(i10))));
            return gameModeChooseFragment;
        }
    }

    public interface b {
        void a(int i10, @yt.k String str);
    }

    @hk.m
    @yt.k
    public static final GameModeChooseFragment m6(@yt.k String str, int i10) {
        return I8.a(str, i10);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void o6(GameModeChooseFragment this$0, View view) {
        b bVar;
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        c7.x xVar = this$0.H8;
        c7.x xVar2 = null;
        if (xVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar = null;
        }
        if (xVar.f10552f.isSelected() && o5.m.k(DataConstant.SP_APP).f(DataConstant.SP_APP_KEY_SHOW_NATIVE_GAME_MODE_NOTICE, true)) {
            this$0.u6();
            return;
        }
        String str = this$0.G8;
        if (str != null && (bVar = this$0.F8) != null) {
            c7.x xVar3 = this$0.H8;
            if (xVar3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                xVar2 = xVar3;
            }
            bVar.a(xVar2.f10552f.isSelected() ? 1 : 0, str);
        }
        this$0.e6();
    }

    public static final void p6(GameModeChooseFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.e6();
    }

    public static final void q6(GameModeChooseFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Object tag = view.getTag();
        kotlin.jvm.internal.f0.n(tag, "null cannot be cast to non-null type kotlin.String");
        this$0.E8 = Integer.parseInt((String) tag);
        view.setSelected(true);
        c7.x xVar = this$0.H8;
        if (xVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar = null;
        }
        xVar.f10552f.setSelected(false);
    }

    public static final void r6(GameModeChooseFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Object tag = view.getTag();
        kotlin.jvm.internal.f0.n(tag, "null cannot be cast to non-null type kotlin.String");
        this$0.E8 = Integer.parseInt((String) tag);
        c7.x xVar = this$0.H8;
        if (xVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar = null;
        }
        xVar.f10551e.setSelected(false);
        view.setSelected(true);
    }

    public static final void s6(View view) {
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, o5.p.d() ? com.flydigi.device_manager.o.f14473q : com.flydigi.device_manager.o.f14474r).navigation();
    }

    public static final void v6(GameModeChooseFragment this$0, DialogFragment dialogFragment) {
        b bVar;
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.n(dialogFragment, "null cannot be cast to non-null type com.flydigi.base.widget.FZDialog");
        if (((FZDialog) dialogFragment).s6()) {
            o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_APP_KEY_SHOW_NATIVE_GAME_MODE_NOTICE, false);
        }
        String str = this$0.G8;
        if (str != null && (bVar = this$0.F8) != null) {
            bVar.a(1, str);
        }
        dialogFragment.I5();
        this$0.e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.G8 = bundleT1 != null ? bundleT1.getString(L8) : null;
        Bundle bundleT12 = T1();
        this.E8 = bundleT12 != null ? bundleT12.getInt(M8) : 0;
        W5(1, 0);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        c7.x xVarD = c7.x.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(xVarD, "inflate(inflater, container, false)");
        this.H8 = xVarD;
        if (xVarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVarD = null;
        }
        FrameLayout root = xVarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_dialog_game_mode_choose;
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
        kotlin.jvm.internal.f0.o(attributes, "it.attributes");
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        Dialog dialogL5;
        Window window;
        super.h4();
        if (L5() == null || (dialogL5 = L5()) == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(R.style.dialog_anim_enter_bottom);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        c7.x xVar = this.H8;
        c7.x xVar2 = null;
        if (xVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar = null;
        }
        com.blankj.utilcode.util.o.r(xVar.f10548b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.game.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameModeChooseFragment.o6(this.f15252a, view2);
            }
        });
        c7.x xVar3 = this.H8;
        if (xVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar3 = null;
        }
        com.blankj.utilcode.util.o.r(xVar3.f10549c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.game.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameModeChooseFragment.p6(this.f15246a, view2);
            }
        });
        c7.x xVar4 = this.H8;
        if (xVar4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar4 = null;
        }
        com.blankj.utilcode.util.o.r(xVar4.f10551e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.game.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameModeChooseFragment.q6(this.f15249a, view2);
            }
        });
        c7.x xVar5 = this.H8;
        if (xVar5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            xVar5 = null;
        }
        com.blankj.utilcode.util.o.r(xVar5.f10552f, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.game.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameModeChooseFragment.r6(this.f15254a, view2);
            }
        });
        int i10 = this.E8;
        if (i10 == 0) {
            c7.x xVar6 = this.H8;
            if (xVar6 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                xVar6 = null;
            }
            xVar6.f10551e.setSelected(true);
            c7.x xVar7 = this.H8;
            if (xVar7 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                xVar7 = null;
            }
            xVar7.f10552f.setSelected(false);
        } else if (i10 == 1) {
            c7.x xVar8 = this.H8;
            if (xVar8 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                xVar8 = null;
            }
            xVar8.f10551e.setSelected(false);
            c7.x xVar9 = this.H8;
            if (xVar9 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                xVar9 = null;
            }
            xVar9.f10552f.setSelected(true);
        }
        c7.x xVar10 = this.H8;
        if (xVar10 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            xVar2 = xVar10;
        }
        com.blankj.utilcode.util.o.r(xVar2.f10550d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.game.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameModeChooseFragment.s6(view2);
            }
        });
    }

    @yt.l
    public final b n6() {
        return this.F8;
    }

    public final void t6(@yt.l b bVar) {
        this.F8 = bVar;
    }

    public final void u6() {
        o5.a.t0(U1(), new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_game_gamepad_native_mode_notice)).s(true).b(Boolean.FALSE).q(c3(R.string.device_just_know)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.h
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                GameModeChooseFragment.v6(this.f15258a, dialogFragment);
            }
        }).a());
    }
}
