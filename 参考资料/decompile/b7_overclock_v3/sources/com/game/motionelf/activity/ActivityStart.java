package com.game.motionelf.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.p;
import com.flydigi.base.widget.EditTextDialog;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.UnreadMessageBean;
import com.flydigi.data.event.BadgeEvent;
import com.flydigi.data.event.ExitAppEvent;
import com.flydigi.data.event.FZAccountLoginChangeEvent;
import com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog;
import com.flydigi.device_manager.ui.setting.AlphaGroupJoinSuccessDialog;
import com.flydigi.qiji.RouterCenterProvider;
import com.flydigi.qiji.ui.advertise.AdFragment;
import com.flydigi.qiji.ui.customer_service.CustomerServiceEvaluateDialogFragment;
import com.flydigi.qiji.ui.home.HomePresenter;
import com.flydigi.qiji.ui.home.a;
import com.flydigi.qiji.ui.home.m;
import com.game.motionelf.activity.ActivityStart;
import com.game.motionelf.activity.UserPolicyDialog;
import com.umeng.umlink.MobclickLink;
import com.umeng.umlink.UMLinkListener;
import i9.a;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import ll.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgeAnchor;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nActivityStart.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityStart.kt\ncom/game/motionelf/activity/ActivityStart\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,545:1\n1#2:546\n1855#3,2:547\n*S KotlinDebug\n*F\n+ 1 ActivityStart.kt\ncom/game/motionelf/activity/ActivityStart\n*L\n363#1:547,2\n*E\n"})
@Route(path = a.f.f31974c)
public final class ActivityStart extends p implements a.b, AdFragment.a {

    @k
    public static final a L7 = new a(null);

    @k
    public static final String M7 = "current_item";

    @k
    public final UMLinkListener E7 = new h();

    @k
    public final a.InterfaceC0166a F7 = new HomePresenter(this);
    public b9.a G7;
    public ml.a H7;
    public ml.a I7;
    public int J7;
    public boolean K2;
    public int K7;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b implements CustomerServiceEvaluateDialogFragment.b {
        public b() {
        }

        @Override // com.flydigi.qiji.ui.customer_service.CustomerServiceEvaluateDialogFragment.b
        public void dismiss() {
            ActivityStart.this.x4();
        }
    }

    public static final class c extends il.a {

        public static final class a implements c.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TextView f16431a;

            public a(TextView textView) {
                this.f16431a = textView;
            }

            @Override // ll.c.b
            public void a(int i10, int i11) {
                this.f16431a.setSelected(false);
            }

            @Override // ll.c.b
            public void b(int i10, int i11, float f10, boolean z10) {
            }

            @Override // ll.c.b
            public void c(int i10, int i11) {
                this.f16431a.setSelected(true);
            }

            @Override // ll.c.b
            public void d(int i10, int i11, float f10, boolean z10) {
            }
        }

        public c() {
        }

        public static final void j(ActivityStart this$0, int i10, Context context, View view) {
            f0.p(this$0, "this$0");
            f0.p(context, "$context");
            this$0.J7 = i10;
            ActivityStart.J4(this$0, null, 1, null);
            m.k(context, i10);
            if (a5.f.i().o()) {
                this$0.F7.f();
            }
            if (m.a(i10)) {
                ml.a aVar = this$0.I7;
                if (aVar == null) {
                    f0.S("mainCommunityView");
                    aVar = null;
                }
                if (aVar.getBadgeView() != null) {
                    ml.a aVar2 = this$0.I7;
                    if (aVar2 == null) {
                        f0.S("mainCommunityView");
                        aVar2 = null;
                    }
                    if (aVar2.getBadgeView().getVisibility() == 0) {
                        ml.a aVar3 = this$0.I7;
                        if (aVar3 == null) {
                            f0.S("mainCommunityView");
                            aVar3 = null;
                        }
                        aVar3.setBadgeView(null);
                        this$0.F7.X();
                    }
                }
            }
        }

        @Override // il.a
        public int a() {
            return m.h();
        }

        @Override // il.a
        @l
        public il.c b(@k Context context) {
            f0.p(context, "context");
            return null;
        }

        @Override // il.a
        @k
        public il.d c(@k final Context context, final int i10) {
            f0.p(context, "context");
            ml.a aVar = new ml.a(context);
            ll.c cVar = new ll.c(context);
            TextView textView = new TextView(context);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, m.f(i10), 0, 0);
            textView.setPadding(0, textView.getResources().getDimensionPixelOffset(R.dimen.qb_px_8), 0, 0);
            textView.setGravity(81);
            textView.setTextColor(h0.d.g(context, R.color.main_home_tab_text_selector));
            textView.setTextSize(0, textView.getResources().getDimensionPixelSize(R.dimen.sp_10));
            textView.setText(m.g(i10));
            if (i10 == m.c()) {
                textView.setVisibility(4);
            }
            cVar.setContentView(textView);
            aVar.setInnerPagerTitleView(cVar);
            if (i10 == a() - 1) {
                ActivityStart.this.H7 = aVar;
                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(b1.b(10.0f), b1.b(10.0f)));
                imageView.setImageResource(R.drawable.shape_red_dot_notice);
                aVar.setAutoCancelBadge(false);
                aVar.setXBadgeRule(new ml.b(BadgeAnchor.CENTER_X, b1.b(10.0f)));
                aVar.setYBadgeRule(new ml.b(BadgeAnchor.CONTENT_TOP, b1.b(10.0f)));
                o5.c.b(imageView, Boolean.FALSE, false, 2, null);
                aVar.setBadgeView(imageView);
            }
            if (m.a(i10)) {
                ActivityStart.this.I7 = aVar;
                ImageView imageView2 = new ImageView(context);
                imageView2.setLayoutParams(new FrameLayout.LayoutParams(b1.b(10.0f), b1.b(10.0f)));
                imageView2.setImageResource(R.drawable.shape_red_dot_notice);
                aVar.setAutoCancelBadge(false);
                aVar.setXBadgeRule(new ml.b(BadgeAnchor.CENTER_X, b1.b(10.0f)));
                aVar.setYBadgeRule(new ml.b(BadgeAnchor.CONTENT_TOP, b1.b(10.0f)));
                o5.c.b(imageView2, Boolean.FALSE, false, 2, null);
                aVar.setBadgeView(imageView2);
            }
            cVar.setOnPagerTitleChangeListener(new a(textView));
            final ActivityStart activityStart = ActivityStart.this;
            aVar.setOnClickListener(new View.OnClickListener() { // from class: w9.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActivityStart.c.j(activityStart, i10, context, view);
                }
            });
            return aVar;
        }
    }

    public static final class d implements PermissionUtils.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f16433b;

        public d(Bundle bundle) {
            this.f16433b = bundle;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.e
        public void a() {
            ActivityStart.this.F4(this.f16433b);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.e
        public void b() {
        }
    }

    @t0({"SMAP\nActivityStart.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityStart.kt\ncom/game/motionelf/activity/ActivityStart$onActivityBackPressed$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,545:1\n1#2:546\n*E\n"})
    public static final class e implements o.c {
        @Override // com.blankj.utilcode.util.o.c
        public void a(@l CharSequence charSequence, long j10) {
            if (charSequence != null) {
                com.flydigi.base.common.o.E(charSequence);
            }
        }

        @Override // com.blankj.utilcode.util.o.c
        public void dismiss() {
            tt.c.f().q(new ExitAppEvent(false));
        }
    }

    public static final class f implements UserPolicyDialog.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f16435b;

        public f(Bundle bundle) {
            this.f16435b = bundle;
        }

        @Override // com.game.motionelf.activity.UserPolicyDialog.c
        public void a() {
            o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_IS_USER_POLICY_ALLOWED, true);
            Intent intent = new Intent();
            intent.setAction(DataConstant.BROADCAST_RECEIVER_ACTION_REQUEST_POLICY);
            ActivityStart.this.sendBroadcast(intent);
            ActivityStart.this.D4(this.f16435b);
        }

        @Override // com.game.motionelf.activity.UserPolicyDialog.c
        public void cancel() {
            ActivityStart.this.K4();
        }
    }

    public static final class g implements AlphaGroupInvitationDialog.b {
        public g() {
        }

        @Override // com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog.b
        public void a() {
            ActivityStart.this.F7.U(true);
        }

        @Override // com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog.b
        public void b() {
            ActivityStart.this.F7.U(false);
        }
    }

    public static final class h implements UMLinkListener {
        @Override // com.umeng.umlink.UMLinkListener
        public void onError(@k String s10) {
            f0.p(s10, "s");
        }

        @Override // com.umeng.umlink.UMLinkListener
        public void onInstall(@k HashMap<String, String> install_params, @k Uri uri) {
            f0.p(install_params, "install_params");
            f0.p(uri, "uri");
        }

        @Override // com.umeng.umlink.UMLinkListener
        public void onLink(@k String path, @k HashMap<String, String> query_params) {
            f0.p(path, "path");
            f0.p(query_params, "query_params");
            if (path.length() == 0) {
                return;
            }
            Object objNavigation = h3.a.j().d(i9.a.f31903e).navigation();
            f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.qiji.RouterCenterProvider");
            ((RouterCenterProvider) objNavigation).o(path, query_params);
        }
    }

    public static final void A4(String sessionId, ActivityStart this_run, View view) {
        f0.p(this_run, "$this_run");
        CustomerServiceEvaluateDialogFragment.a aVar = CustomerServiceEvaluateDialogFragment.I8;
        f0.o(sessionId, "sessionId");
        CustomerServiceEvaluateDialogFragment customerServiceEvaluateDialogFragmentA = aVar.a(sessionId);
        customerServiceEvaluateDialogFragmentA.o6(this_run.new b());
        o5.a.t0(this_run.n3(), customerServiceEvaluateDialogFragmentA);
    }

    public static final void G4(ActivityStart this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.J7 = this$0.K7;
        J4(this$0, null, 1, null);
        m.k(this$0, this$0.J7);
    }

    public static /* synthetic */ void J4(ActivityStart activityStart, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        activityStart.I4(bool);
    }

    public static final void L4(DialogFragment obj) {
        f0.p(obj, "obj");
        obj.I5();
    }

    public static final void y4(final ActivityStart this$0, final String str, ViewStub viewStub, View view) {
        f0.p(this$0, "this$0");
        b9.c cVarA = b9.c.a(view);
        f0.o(cVarA, "bind(inflated)");
        o.r(cVarA.f9151c, new View.OnClickListener() { // from class: w9.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityStart.z4(view2);
            }
        });
        o.r(cVarA.f9152d, new View.OnClickListener() { // from class: w9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityStart.A4(str, this$0, view2);
            }
        });
    }

    public static final void z4(View view) {
        u9.b.p(0, "快捷入口", "support");
    }

    public final void B4(Intent intent) {
        if (TextUtils.equals(intent.getStringExtra("action"), DataConstant.KEY_ACTIVE_DRIVER)) {
            this.K2 = true;
            i9.b.d(this, DataConstant.REMOTE_ACTION_DRIVER_ACTIVE_REQUEST);
        } else {
            i9.b.d(this, DataConstant.REMOTE_ACTION_INIT);
        }
        MobclickLink.handleUMLinkURI(this, intent.getData(), this.E7);
    }

    public final boolean C4() {
        return o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false);
    }

    public final void D4(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            B4(intent);
        }
        if (com.blankj.utilcode.util.a.D().size() > 1 && this.K2) {
            finish();
        } else {
            com.flydigi.userBehavior.a.a().b(this, "App 启动");
            F4(bundle);
        }
    }

    public final void E4() {
        hl.a aVar = new hl.a(this);
        aVar.setAdjustMode(true);
        aVar.setAdapter(new c());
        b9.a aVar2 = this.G7;
        if (aVar2 == null) {
            f0.S("viewBinding");
            aVar2 = null;
        }
        aVar2.f9142c.setNavigator(aVar);
    }

    public final void F4(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 31 && h0.d.a(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            PermissionUtils.E("android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN").r(new d(bundle)).I();
            return;
        }
        b9.a aVar = this.G7;
        if (aVar == null) {
            f0.S("viewBinding");
            aVar = null;
        }
        o.r(aVar.f9144e, new View.OnClickListener() { // from class: w9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityStart.G4(this.f54610a, view);
            }
        });
        E4();
        boolean z10 = !getIntent().getBooleanExtra(a.f.f31981j, bundle != null);
        I4(Boolean.valueOf(z10));
        if (z10) {
            d0.a(n3(), AdFragment.f16079t8.a(), R.id.container_fragment);
            return;
        }
        b9.a aVar2 = this.G7;
        if (aVar2 == null) {
            f0.S("viewBinding");
            aVar2 = null;
        }
        MagicIndicator magicIndicator = aVar2.f9142c;
        f0.o(magicIndicator, "viewBinding.magicIndicator");
        Boolean bool = Boolean.TRUE;
        o5.c.b(magicIndicator, bool, false, 2, null);
        b9.a aVar3 = this.G7;
        if (aVar3 == null) {
            f0.S("viewBinding");
            aVar3 = null;
        }
        TextView textView = aVar3.f9144e;
        f0.o(textView, "viewBinding.tvDeviceManager");
        o5.c.b(textView, bool, false, 2, null);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.colorWindowBackground);
        }
    }

    public final void H4(int i10) {
        ml.a aVar = this.H7;
        if (aVar == null) {
            f0.S("mainAccountView");
            aVar = null;
        }
        View badge = aVar.getBadgeView();
        if (i10 > 0) {
            f0.o(badge, "badge");
            o5.c.b(badge, Boolean.TRUE, false, 2, null);
        } else {
            f0.o(badge, "badge");
            o5.c.b(badge, Boolean.FALSE, false, 2, null);
        }
    }

    @Override // com.flydigi.qiji.ui.home.a.b
    public void I0() {
        ml.a aVar = this.I7;
        if (aVar == null) {
            f0.S("mainCommunityView");
            aVar = null;
        }
        if (aVar.getBadgeView() != null) {
            ml.a aVar2 = this.I7;
            if (aVar2 == null) {
                f0.S("mainCommunityView");
                aVar2 = null;
            }
            View badgeView = aVar2.getBadgeView();
            f0.o(badgeView, "mainCommunityView.badgeView");
            o5.c.b(badgeView, Boolean.TRUE, false, 2, null);
        }
    }

    public final void I4(Boolean bool) {
        Fragment fragmentD = m.d(this.J7);
        Fragment fragmentA = d0.A(n3(), fragmentD.getClass());
        if (fragmentA == null) {
            List<Fragment> listE = m.e(this.J7);
            f0.o(listE, "getFragmentsExcludeCurrent(mCurrentPosition)");
            for (Fragment fragment : listE) {
                if (!fragment.u3()) {
                    d0.Q(fragment);
                }
            }
            d0.m(n3(), fragmentD, R.id.container_fragment, bool != null ? bool.booleanValue() : false);
        } else {
            m.j(this.J7, fragmentA);
            d0.V0(fragmentA, m.e(this.J7));
        }
        b9.a aVar = this.G7;
        b9.a aVar2 = null;
        if (aVar == null) {
            f0.S("viewBinding");
            aVar = null;
        }
        aVar.f9142c.c(this.J7);
        b9.a aVar3 = this.G7;
        if (aVar3 == null) {
            f0.S("viewBinding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f9144e.setSelected(this.J7 == this.K7);
    }

    public final void K4() {
        new FZDialog.a().t(getString(R.string.notice)).j(getString(R.string.app_user_info_access_policy_remind)).q(getString(R.string.app_back)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: w9.e
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ActivityStart.L4(dialogFragment);
            }
        }).a().Z5(n3(), EditTextDialog.G8);
    }

    @Override // com.flydigi.qiji.ui.home.a.b
    public void Z() {
        AlphaGroupInvitationDialog alphaGroupInvitationDialogA = AlphaGroupInvitationDialog.G8.a();
        alphaGroupInvitationDialogA.m6(new g());
        o5.a.t0(n3(), alphaGroupInvitationDialogA);
    }

    @Override // com.flydigi.base.common.c
    public boolean d4() {
        o.v(getString(R.string.app_will_exit_app), 1500L, new e());
        return true;
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.app_activity_home;
    }

    @Override // com.flydigi.base.common.p
    public void h4() {
        ku.b.g(this);
    }

    @Override // com.flydigi.qiji.ui.home.a.b
    public void j(@k UnreadMessageBean data) {
        f0.p(data, "data");
        H4(data.getTotal());
        tt.c.f().t(new BadgeEvent(data));
    }

    @Override // com.flydigi.qiji.ui.advertise.AdFragment.a
    public void k2() {
        d0.c0(d0.A(n3(), AdFragment.class));
        b9.a aVar = this.G7;
        if (aVar == null) {
            f0.S("viewBinding");
            aVar = null;
        }
        MagicIndicator magicIndicator = aVar.f9142c;
        f0.o(magicIndicator, "viewBinding.magicIndicator");
        Boolean bool = Boolean.TRUE;
        o5.c.b(magicIndicator, bool, false, 2, null);
        b9.a aVar2 = this.G7;
        if (aVar2 == null) {
            f0.S("viewBinding");
            aVar2 = null;
        }
        TextView textView = aVar2.f9144e;
        f0.o(textView, "viewBinding.tvDeviceManager");
        o5.c.b(textView, bool, false, 2, null);
        J4(this, null, 1, null);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.colorWindowBackground);
        }
    }

    @Override // com.flydigi.qiji.ui.home.a.b
    public void o1() {
        o5.a.t0(n3(), AlphaGroupJoinSuccessDialog.F8.a());
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        g4();
        m.i();
        int iC = m.c();
        this.K7 = iC;
        if (bundle != null) {
            iC = bundle.getInt(M7, iC);
        }
        this.J7 = iC;
        if (C4()) {
            D4(bundle);
            return;
        }
        UserPolicyDialog userPolicyDialogC6 = UserPolicyDialog.c6();
        userPolicyDialogC6.U5(false);
        userPolicyDialogC6.d6(new f(bundle));
        o5.a.t0(n3(), userPolicyDialogC6);
    }

    @tt.l
    public final void onEvent(@k FZAccountLoginChangeEvent event) {
        f0.p(event, "event");
        if (event.isLogin()) {
            return;
        }
        H4(0);
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@k Intent intent) {
        f0.p(intent, "intent");
        super.onNewIntent(intent);
        B4(intent);
        int intExtra = intent.getIntExtra(DataConstant.KEY_ROUTER_HOME_TAB_INDEX, -1);
        if (intExtra != -1) {
            this.J7 = intExtra;
            J4(this, null, 1, null);
        }
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        m.b(this);
        if (C4()) {
            Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
            f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation).e(getApplicationContext(), DataConstant.REMOTE_ACTION_START_GAME, "package_name", getApplicationContext().getPackageName());
            if (a5.f.i().o()) {
                if (!a5.f.i().n() && !o5.m.k(DataConstant.SP_APP).e(DataConstant.SP_APP_ALPHA_GROUP_INVITATION_SHOWN)) {
                    this.F7.l();
                }
                this.F7.f();
            }
            this.F7.g();
            x4();
        }
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(@k Bundle outState) {
        f0.p(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(M7, this.J7);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        b9.a aVarC = b9.a.c(getLayoutInflater());
        f0.o(aVarC, "inflate(layoutInflater)");
        this.G7 = aVarC;
        if (aVarC == null) {
            f0.S("viewBinding");
            aVarC = null;
        }
        setContentView(aVarC.getRoot());
    }

    public final void x4() {
        final String strQ = o5.m.k(DataConstant.SP_APP).q(DataConstant.SP_APP_CUSTOMER_SERVICE_SESSION_ID);
        if (!n0.x(strQ)) {
            b9.a aVar = this.G7;
            if (aVar == null) {
                f0.S("viewBinding");
                aVar = null;
            }
            ViewStub viewStub = aVar.f9143d;
            f0.o(viewStub, "viewBinding.stubCustomerServiceTip");
            o5.c.b(viewStub, Boolean.FALSE, false, 2, null);
            return;
        }
        b9.a aVar2 = this.G7;
        if (aVar2 == null) {
            f0.S("viewBinding");
            aVar2 = null;
        }
        aVar2.f9143d.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: w9.d
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                ActivityStart.y4(this.f54614a, strQ, viewStub2, view);
            }
        });
        b9.a aVar3 = this.G7;
        if (aVar3 == null) {
            f0.S("viewBinding");
            aVar3 = null;
        }
        ViewStub viewStub2 = aVar3.f9143d;
        f0.o(viewStub2, "viewBinding.stubCustomerServiceTip");
        o5.c.b(viewStub2, Boolean.TRUE, false, 2, null);
    }
}
