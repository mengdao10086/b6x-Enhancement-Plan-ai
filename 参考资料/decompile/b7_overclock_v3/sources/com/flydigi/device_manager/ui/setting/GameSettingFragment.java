package com.flydigi.device_manager.ui.setting;

import a5.f;
import android.app.AppOpsManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.o;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.base.widget.action_item.ActionItemSwitch;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ChangeUserGroupData;
import com.flydigi.data.event.ExitAppEvent;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog;
import com.flydigi.device_manager.ui.setting.GameSettingFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import dj.g;
import g.p0;
import i9.a;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;
import m5.c0;
import m5.f0;
import m9.h;
import o5.l;
import o5.m;
import o5.p;
import q7.d;
import t7.j;
import tt.c;
import xi.b0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class GameSettingFragment extends BaseGamepadFragment {
    public boolean A8;
    public ActionItemNormal B8;
    public ActionItemNormal C8;
    public ActionItemSwitch D8;
    public ActionItemSwitch E8;
    public ActionItemSwitch F8;
    public ActionItemNormal G8;
    public boolean H8;
    public boolean I8;

    public class a implements AlphaGroupInvitationDialog.b {
        public a() {
        }

        @Override // com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog.b
        public void a() {
            GameSettingFragment.this.Y6(true);
        }

        @Override // com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog.b
        public void b() {
            GameSettingFragment.this.Y6(false);
        }
    }

    public class b extends m5.a<Object> {
        public b() {
        }

        @Override // m5.a, xi.g0
        public void onComplete() {
            GameSettingFragment.this.E0();
            o.E(GameSettingFragment.this.c3(R.string.device_finish_clean));
            c.f().t(new ExitAppEvent(false));
        }

        @Override // m5.a, xi.g0
        public void onError(Throwable th2) {
            super.onError(th2);
            c.f().t(new ExitAppEvent(false));
        }

        @Override // m5.a, xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            GameSettingFragment gameSettingFragment = GameSettingFragment.this;
            gameSettingFragment.x(gameSettingFragment.c3(R.string.device_cleaing), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z6(boolean z10, ChangeUserGroupData changeUserGroupData) throws Exception {
        f.i().y(changeUserGroupData.getGroupId());
        B7();
        if (z10) {
            o1();
        }
    }

    public static /* synthetic */ void a7(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b7(View view) {
        this.A8 = true;
        o5.f.j(R4(), new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c7(View view) {
        if (n6()) {
            h3.a.j().d(a.d.f31960p).withString("package_name", "com.tencent.tmgp.pubgmhd").navigation();
        } else {
            o.E(c3(R.string.device_please_connect_gamepad));
        }
    }

    public static /* synthetic */ void d7(boolean z10) {
        m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e7(boolean z10) {
        m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_KEY_USE_COMPATIBLE_DRIVER, z10);
        m.l(DataConstant.SP_FLOAT, 2).H(DataConstant.SP_FLOAT_KEY_DRIVER_VERSION_RELEASED);
        this.H8 = true;
        z7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f7(View view) {
        A7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g7() {
        E0();
        o.E(c3(R.string.device_save_success));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h7(View view) {
        x(c3(R.string.device_saving_config), false);
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(this.f13317d8, DataConstant.REMOTE_ACTION_WRITE_CONFIG_TO_FLASH);
        G5().postDelayed(new Runnable() { // from class: q7.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f47141a.g7();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i7(View view) {
        if (o5.f.g(X1())) {
            return;
        }
        o.E(c3(R.string.device_dev_setting_open_failed_notice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j7(View view) {
        z7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k7(View view) {
        if (f.i().n()) {
            y7();
        } else {
            Z();
        }
    }

    public static /* synthetic */ void l7(boolean z10) {
        m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, z10);
    }

    public static /* synthetic */ void m7(boolean z10) {
        m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_KEY_CAST_ASSIST, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n7(ChangeUserGroupData changeUserGroupData) throws Exception {
        f.i().y(changeUserGroupData.getGroupId());
        m.k(DataConstant.SP_APP).F(DataConstant.SP_APP_ALPHA_GROUP_INVITATION_SHOWN, true);
        B7();
    }

    public static /* synthetic */ void o7(Throwable th2) throws Exception {
    }

    public static /* synthetic */ boolean p7(File file, String str) {
        return !Objects.equals(file.getAbsolutePath() + fh.a.f28350w + str, e6.a.f26664f);
    }

    public static /* synthetic */ void q7(boolean z10, b0 b0Var) throws Exception {
        String[] list;
        n.d();
        n.c();
        n.g();
        n.f();
        n.h();
        f.i().t();
        m.i().b(true);
        m.k(DataConstant.SP_MAIN).b(true);
        m.k(DataConstant.SP_APP).b(true);
        m.l(DataConstant.SP_FLOAT, 2).b(true);
        m.k(DataConstant.SP_ACCOUNT).b(true);
        com.blankj.utilcode.util.b0.q(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
        com.blankj.utilcode.util.b0.q(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
        j1.a().getSharedPreferences("NewbieGuide", 0).edit().clear().apply();
        File file = new File(DataConstant.DIRECTORY_PUBLIC);
        if (z10) {
            com.blankj.utilcode.util.b0.o(file);
        } else if (file.isDirectory() && (list = file.list(new FilenameFilter() { // from class: q7.n
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                return GameSettingFragment.p7(file2, str);
            }
        })) != null) {
            for (String str : list) {
                com.blankj.utilcode.util.b0.p(file.getAbsolutePath() + fh.a.f28350w + str);
            }
        }
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r7(DialogFragment dialogFragment) {
        v7();
        dialogFragment.I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s7(DialogFragment dialogFragment) {
        dialogFragment.I5();
        w7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t7(DialogFragment dialogFragment) {
        dialogFragment.I5();
        w7();
    }

    public static GameSettingFragment u7() {
        return new GameSettingFragment();
    }

    public final void A7() {
        j jVar = new j(H1());
        jVar.G(new j.a() { // from class: q7.q
            @Override // t7.j.a
            public final void a(boolean z10) {
                this.f47143a.x7(z10);
            }
        });
        jVar.show();
    }

    public final void B7() {
        d.a(this.G8);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_game_setting;
    }

    public final void Y6(final boolean z10) {
        ((h5.d) f0.i().k().g(h5.d.class)).q(z10 ? 1 : 2).s0(c0.p()).s0(c0.t()).s0(l.d()).F5(new g() { // from class: q7.k
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f47136a.Z6(z10, (ChangeUserGroupData) obj);
            }
        }, new g() { // from class: q7.l
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                GameSettingFragment.a7((Throwable) obj);
            }
        });
    }

    public final void Z() {
        AlphaGroupInvitationDialog alphaGroupInvitationDialogI6 = AlphaGroupInvitationDialog.i6();
        alphaGroupInvitationDialogI6.m6(new a());
        o5.a.t0(U1(), alphaGroupInvitationDialogI6);
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        if (this.A8) {
            this.A8 = false;
            if (Build.VERSION.SDK_INT >= 22) {
                if (((AppOpsManager) R4().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), R4().getPackageName()) == 0) {
                    ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(R4(), DataConstant.REMOTE_ACTION_CHECK_APP_USAGE);
                }
            }
        }
        this.D8.U(m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false));
        this.E8.U(m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_KEY_CAST_ASSIST, true));
        this.F8.U(m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, 0) == 1);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        com.flydigi.userBehavior.a.a().b(H1(), "功能设置");
        ActionItemNormal actionItemNormal = (ActionItemNormal) F5(R.id.action_open_app_stats_usage);
        if (Build.VERSION.SDK_INT >= 22) {
            actionItemNormal.setVisibility(0);
            com.blankj.utilcode.util.o.r(actionItemNormal, new View.OnClickListener() { // from class: q7.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f47130a.b7(view2);
                }
            });
        }
        ActionItemNormal actionItemNormal2 = (ActionItemNormal) F5(R.id.action_pubg_native_support_mode);
        this.C8 = actionItemNormal2;
        com.blankj.utilcode.util.o.r(actionItemNormal2, new View.OnClickListener() { // from class: q7.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f47147a.c7(view2);
            }
        });
        com.blankj.utilcode.util.o.r((ActionItemNormal) F5(R.id.action_rest_game_center), new View.OnClickListener() { // from class: q7.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f47148a.f7(view2);
            }
        });
        ActionItemNormal actionItemNormal3 = (ActionItemNormal) F5(R.id.action_write_config_to_flash);
        this.B8 = actionItemNormal3;
        com.blankj.utilcode.util.o.r(actionItemNormal3, new View.OnClickListener() { // from class: q7.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f47145a.h7(view2);
            }
        });
        ActionItemNormal actionItemNormal4 = (ActionItemNormal) F5(R.id.action_open_usb_debug);
        com.blankj.utilcode.util.o.r(actionItemNormal4, new View.OnClickListener() { // from class: q7.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f47146a.i7(view2);
            }
        });
        com.blankj.utilcode.util.o.r((ActionItemNormal) F5(R.id.action_quit_key_mapping), new View.OnClickListener() { // from class: q7.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f47142a.j7(view2);
            }
        });
        if (v5.c.f()) {
            actionItemNormal4.setVisibility(8);
            this.B8.setVisibility(8);
            this.C8.setVisibility(8);
            actionItemNormal.setVisibility(8);
        } else if (p.d()) {
            this.C8.setVisibility(0);
        } else {
            this.C8.setVisibility(8);
        }
        ActionItemNormal actionItemNormal5 = (ActionItemNormal) F5(R.id.action_quit_alpha_group);
        this.G8 = actionItemNormal5;
        com.blankj.utilcode.util.o.r(actionItemNormal5, new View.OnClickListener() { // from class: q7.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f47149a.k7(view2);
            }
        });
        B7();
        ActionItemSwitch actionItemSwitch = (ActionItemSwitch) F5(R.id.action_hide_float_view);
        this.D8 = actionItemSwitch;
        actionItemSwitch.setOnCheckedChangeListener(new ActionItemSwitch.b() { // from class: q7.g
            @Override // com.flydigi.base.widget.action_item.ActionItemSwitch.b
            public final void a(boolean z10) {
                GameSettingFragment.l7(z10);
            }
        });
        ActionItemSwitch actionItemSwitch2 = (ActionItemSwitch) F5(R.id.action_cast_assist);
        this.E8 = actionItemSwitch2;
        actionItemSwitch2.setOnCheckedChangeListener(new ActionItemSwitch.b() { // from class: q7.h
            @Override // com.flydigi.base.widget.action_item.ActionItemSwitch.b
            public final void a(boolean z10) {
                GameSettingFragment.m7(z10);
            }
        });
        ActionItemSwitch actionItemSwitch3 = (ActionItemSwitch) F5(R.id.action_pad_support);
        this.F8 = actionItemSwitch3;
        actionItemSwitch3.setOnCheckedChangeListener(new ActionItemSwitch.b() { // from class: q7.i
            @Override // com.flydigi.base.widget.action_item.ActionItemSwitch.b
            public final void a(boolean z10) {
                GameSettingFragment.d7(z10);
            }
        });
        ActionItemSwitch actionItemSwitch4 = (ActionItemSwitch) F5(R.id.action_driver_compatible);
        actionItemSwitch4.setOnCheckedChangeListener(new ActionItemSwitch.b() { // from class: q7.f
            @Override // com.flydigi.base.widget.action_item.ActionItemSwitch.b
            public final void a(boolean z10) {
                this.f47131a.e7(z10);
            }
        });
        actionItemSwitch4.U(m.l(DataConstant.SP_FLOAT, 2).e(DataConstant.SP_FLOAT_KEY_USE_COMPATIBLE_DRIVER));
        if (v5.c.e()) {
            return;
        }
        actionItemSwitch4.U(true);
        actionItemSwitch4.setEnabled(false);
    }

    public final void o1() {
        o5.a.t0(U1(), AlphaGroupJoinSuccessDialog.h6());
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@k GamepadInfo gamepadInfo) {
        ActionItemNormal actionItemNormal;
        if (gamepadInfo.isConnected()) {
            if (!v5.c.f() && !n0.b(gamepadInfo.getFirmwareVersion(), m9.k.f40826l) && !n0.b(gamepadInfo.getFirmwareVersion(), m9.k.f40827m) && (actionItemNormal = this.B8) != null) {
                actionItemNormal.setVisibility((n6() && gamepadInfo.isFlashplayMode()) ? 0 : 8);
            }
            if (n0.b(gamepadInfo.getDeviceCode(), h.f40768k) || !p.d()) {
                this.C8.setVisibility(8);
            } else {
                this.C8.setVisibility(0);
            }
        }
        if (this.I8) {
            this.I8 = false;
            if (!gamepadInfo.isDriverConnected() || this.H8) {
                c.f().q(new ExitAppEvent(true));
            }
        }
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void t6(boolean z10) {
        if (this.I8) {
            this.I8 = false;
            if (z10 || this.H8) {
                c.f().q(new ExitAppEvent(true));
            } else {
                E0();
                o.E(c3(R.string.device_driver_not_running));
            }
        }
    }

    public final void v7() {
        ((h5.d) f0.i().k().g(h5.d.class)).q(0).s0(c0.p()).s0(c0.t()).s0(l.d()).F5(new g() { // from class: q7.j
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f47135a.n7((ChangeUserGroupData) obj);
            }
        }, new g() { // from class: q7.m
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                GameSettingFragment.o7((Throwable) obj);
            }
        });
    }

    public final void w7() {
        x(c3(R.string.device_prepare_exit_mapping_and_service), false);
        this.I8 = true;
        m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_MAIN_TCPIP_HAVE_ABLE_TO_ACTIVE, false);
        m.l(DataConstant.SP_FLOAT, 2).H(DataConstant.SP_FLOAT_KEY_DRIVER_VERSION_RELEASED);
        if (o6()) {
            ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(this.f13317d8, DataConstant.REMOTE_ACTION_KILL_DRIVER);
        } else {
            com.flydigi.base.common.n.a("flydigitestdata 驱动未连接 尝试主动连接并退出");
            ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(this.f13317d8, DataConstant.REMOTE_ACTION_TRY_CONNECT_THEN_KILL_DRIVER);
        }
    }

    public final void x7(final boolean z10) {
        z.r1(new xi.c0() { // from class: q7.r
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                GameSettingFragment.q7(z10, b0Var);
            }
        }).s0(c0.t()).s0(l.d()).s0(y1()).c(new b());
    }

    public final void y7() {
        new FZDialog.a().t(c3(R.string.device_quit_alpha_group_msg)).d(c3(R.string.device_reject_and_quit)).g(c3(R.string.device_continue_experience)).b(Boolean.TRUE).e(R.color.color_000000_a30).c(new FZDialog.c() { // from class: q7.x
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                this.f47150a.r7(dialogFragment);
            }
        }).f(b6.c.f9082a).u(L2(), "quit_alpha_group");
    }

    public final void z7() {
        FZDialog.a aVar = new FZDialog.a();
        aVar.t(c3(R.string.device_delete_key_mapping)).j(c3(R.string.device_quit_key_mapping_notice)).b(Boolean.TRUE);
        if (this.H8) {
            aVar.q(c3(R.string.device_quit_keymapping)).p(new FZDialog.c() { // from class: q7.y
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    this.f47151a.s7(dialogFragment);
                }
            });
        } else {
            aVar.g(c3(R.string.device_quit_keymapping)).f(new FZDialog.c() { // from class: q7.z
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    this.f47152a.t7(dialogFragment);
                }
            }).d(c3(R.string.cancel)).c(b6.c.f9082a);
        }
        aVar.u(L2(), "quit_mapping");
    }
}
