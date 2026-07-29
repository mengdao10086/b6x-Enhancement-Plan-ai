package com.flydigi.community.ui.message;

import com.flydigi.community.ui.message.c;
import com.flydigi.data.bean.UnreadMessageBean;
import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class MessagePresenter implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final c.b f13904a;

    public MessagePresenter(@k c.b mView) {
        f0.p(mView, "mView");
        this.f13904a = mView;
    }

    public static final void i0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void k0(MessagePresenter this$0, Object obj) {
        f0.p(this$0, "this$0");
        this$0.f();
    }

    public static final void l0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.message.c.a
    public void f() {
        z zVarS0 = ((x5.a) m5.f0.i().k().g(x5.a.class)).j(a5.f.i().l()).s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final l<UnreadMessageBean, z1> lVar = new l<UnreadMessageBean, z1>() { // from class: com.flydigi.community.ui.message.MessagePresenter$getUnReadMessageCount$disposable$1
            {
                super(1);
            }

            public final void b(UnreadMessageBean it2) {
                c.b bVar = this.this$0.f13904a;
                f0.o(it2, "it");
                bVar.j(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(UnreadMessageBean unreadMessageBean) {
                b(unreadMessageBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.message.g
            @Override // dj.g
            public final void accept(Object obj) {
                MessagePresenter.i0(lVar, obj);
            }
        };
        final MessagePresenter$getUnReadMessageCount$disposable$2 messagePresenter$getUnReadMessageCount$disposable$2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.message.MessagePresenter$getUnReadMessageCount$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.message.f
            @Override // dj.g
            public final void accept(Object obj) {
                MessagePresenter.j0(messagePresenter$getUnReadMessageCount$disposable$2, obj);
            }
        });
    }

    @Override // com.flydigi.community.ui.message.c.a
    public void q(int i10) {
        z zVarS0 = ((x5.a) m5.f0.i().k().g(x5.a.class)).q(i10).J5(lj.b.d()).b4(lj.b.d()).s0(c0.p()).s0(c0.t());
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.message.d
            @Override // dj.g
            public final void accept(Object obj) {
                MessagePresenter.k0(this.f13925a, obj);
            }
        };
        final MessagePresenter$setMessageRead$disposable$2 messagePresenter$setMessageRead$disposable$2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.message.MessagePresenter$setMessageRead$disposable$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.message.e
            @Override // dj.g
            public final void accept(Object obj) {
                MessagePresenter.l0(messagePresenter$setMessageRead$disposable$2, obj);
            }
        });
    }
}
