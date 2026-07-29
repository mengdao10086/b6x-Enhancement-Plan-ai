package com.flydigi.community.ui.search.result;

import com.flydigi.community.ui.search.result.b;
import com.flydigi.data.bean.community.ArticleList;
import dj.g;
import dj.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o5.l;
import z5.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.InterfaceC0148b f14082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f14083b = new f();

    public c(b.InterfaceC0148b interfaceC0148b) {
        this.f14082a = interfaceC0148b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(List list) throws Exception {
        this.f14082a.A1(0, new ArrayList<>(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Throwable th2) throws Exception {
        this.f14082a.A1(0, new ArrayList<>());
    }

    public static /* synthetic */ Iterable k0(ArticleList articleList) throws Exception {
        return Collections.singleton(articleList.getList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(int i10, List list) throws Exception {
        this.f14082a.A1(i10, new ArrayList<>(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Throwable th2) throws Exception {
        this.f14082a.m(th2);
    }

    @Override // com.flydigi.community.ui.search.result.b.a
    public void e(int i10, int i11, String str, final int i12, int i13) {
        this.f14083b.e(i10, i11, str, i12, i13).z2(new o() { // from class: c6.n
            @Override // dj.o
            public final Object apply(Object obj) {
                return com.flydigi.community.ui.search.result.c.k0((ArticleList) obj);
            }
        }).s0(l.d()).F5(new g() { // from class: c6.m
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9775a.l0(i12, (List) obj);
            }
        }, new g() { // from class: c6.k
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9773a.m0((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.community.ui.search.result.b.a
    public void o() {
        this.f14083b.r(false).A3(b6.o.f9096a).s0(l.d()).F5(new g() { // from class: c6.l
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9774a.i0((List) obj);
            }
        }, new g() { // from class: c6.j
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9772a.j0((Throwable) obj);
            }
        });
    }
}
