package com.flydigi.qiji.ui.home;

import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ChangeUserGroupData;
import com.flydigi.data.bean.CheckAlphaGroupInvitationData;
import com.flydigi.data.bean.CommunityRedDotData;
import com.flydigi.data.bean.UnreadMessageBean;
import com.flydigi.qiji.ui.home.a;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import xi.z;

/* JADX INFO: loaded from: classes3.dex */
public final class HomePresenter implements a.InterfaceC0166a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a.b f16119a;

    public HomePresenter(@yt.k a.b mView) {
        f0.p(mView, "mView");
        this.f16119a = mView;
    }

    public static final void o0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void p0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void q0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void r0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void s0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void t0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void u0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void v0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void x0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.qiji.ui.home.a.InterfaceC0166a
    public void U(final boolean z10) {
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).q(z10 ? 1 : 2).s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final ik.l<ChangeUserGroupData, z1> lVar = new ik.l<ChangeUserGroupData, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$joinAlphaGroup$disposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ChangeUserGroupData changeUserGroupData) {
                a5.f.i().y(changeUserGroupData.getGroupId());
                o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_APP_ALPHA_GROUP_INVITATION_SHOWN, true);
                if (z10) {
                    this.f16119a.o1();
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ChangeUserGroupData changeUserGroupData) {
                b(changeUserGroupData);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.home.f
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.w0(lVar, obj);
            }
        };
        final HomePresenter$joinAlphaGroup$disposable$2 homePresenter$joinAlphaGroup$disposable$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$joinAlphaGroup$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.home.e
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.x0(homePresenter$joinAlphaGroup$disposable$2, obj);
            }
        });
    }

    @Override // com.flydigi.qiji.ui.home.a.InterfaceC0166a
    public void X() {
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).m("").s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final ik.l<CommunityRedDotData, z1> lVar = new ik.l<CommunityRedDotData, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$dismissCommunityRedDot$disposable$1
            {
                super(1);
            }

            public final void b(CommunityRedDotData communityRedDotData) {
                if (communityRedDotData.isShouldShow()) {
                    this.this$0.f16119a.I0();
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CommunityRedDotData communityRedDotData) {
                b(communityRedDotData);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.home.k
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.s0(lVar, obj);
            }
        };
        final HomePresenter$dismissCommunityRedDot$disposable$2 homePresenter$dismissCommunityRedDot$disposable$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$dismissCommunityRedDot$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.home.d
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.t0(homePresenter$dismissCommunityRedDot$disposable$2, obj);
            }
        });
    }

    @Override // com.flydigi.qiji.ui.home.a.InterfaceC0166a
    public void f() {
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).j(a5.f.i().l()).s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final ik.l<UnreadMessageBean, z1> lVar = new ik.l<UnreadMessageBean, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$getUnReadMessageCount$disposable$1
            {
                super(1);
            }

            public final void b(UnreadMessageBean it2) {
                a.b bVar = this.this$0.f16119a;
                f0.o(it2, "it");
                bVar.j(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(UnreadMessageBean unreadMessageBean) {
                b(unreadMessageBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.home.g
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.u0(lVar, obj);
            }
        };
        final HomePresenter$getUnReadMessageCount$disposable$2 homePresenter$getUnReadMessageCount$disposable$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$getUnReadMessageCount$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.home.b
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.v0(homePresenter$getUnReadMessageCount$disposable$2, obj);
            }
        });
    }

    @Override // com.flydigi.qiji.ui.home.a.InterfaceC0166a
    public void g() {
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).g().s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final ik.l<CommunityRedDotData, z1> lVar = new ik.l<CommunityRedDotData, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$checkCommunityRedDot$disposable$1
            {
                super(1);
            }

            public final void b(CommunityRedDotData communityRedDotData) {
                if (communityRedDotData.isShouldShow()) {
                    this.this$0.f16119a.I0();
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CommunityRedDotData communityRedDotData) {
                b(communityRedDotData);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.home.h
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.q0(lVar, obj);
            }
        };
        final HomePresenter$checkCommunityRedDot$disposable$2 homePresenter$checkCommunityRedDot$disposable$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$checkCommunityRedDot$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.home.i
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.r0(homePresenter$checkCommunityRedDot$disposable$2, obj);
            }
        });
    }

    @Override // com.flydigi.qiji.ui.home.a.InterfaceC0166a
    public void l() {
        z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).l().s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final ik.l<CheckAlphaGroupInvitationData, z1> lVar = new ik.l<CheckAlphaGroupInvitationData, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$checkAlphaGroupInvitation$disposable$1
            {
                super(1);
            }

            public final void b(CheckAlphaGroupInvitationData checkAlphaGroupInvitationData) {
                if (checkAlphaGroupInvitationData.isShouldShow()) {
                    this.this$0.f16119a.Z();
                } else {
                    o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_APP_ALPHA_GROUP_INVITATION_SHOWN, true);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CheckAlphaGroupInvitationData checkAlphaGroupInvitationData) {
                b(checkAlphaGroupInvitationData);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.home.c
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.o0(lVar, obj);
            }
        };
        final HomePresenter$checkAlphaGroupInvitation$disposable$2 homePresenter$checkAlphaGroupInvitation$disposable$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.home.HomePresenter$checkAlphaGroupInvitation$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.home.j
            @Override // dj.g
            public final void accept(Object obj) {
                HomePresenter.p0(homePresenter$checkAlphaGroupInvitation$disposable$2, obj);
            }
        });
    }
}
