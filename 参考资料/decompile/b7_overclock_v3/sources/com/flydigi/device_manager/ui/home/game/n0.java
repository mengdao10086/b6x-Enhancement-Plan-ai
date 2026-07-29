package com.flydigi.device_manager.ui.home.game;

import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.ui.home.game.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class n0 implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p.b f15270a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ArticleForGame> f15274e = Collections.emptyList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b7.m f15271b = new b7.m();

    public n0(p.b bVar) {
        this.f15270a = bVar;
    }

    public static /* synthetic */ int g0(LocalGameBean localGameBean, LocalGameBean localGameBean2) {
        return Long.compare(localGameBean.f14331id, localGameBean2.f14331id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(List list) throws Exception {
        this.f15274e = list;
        this.f15270a.f0(list);
    }

    public static /* synthetic */ void i0(Throwable th2) throws Exception {
    }

    @Override // com.flydigi.device_manager.ui.home.game.p.a
    public void c0(List<LocalGameBean> list, int i10) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator() { // from class: com.flydigi.device_manager.ui.home.game.m0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n0.g0((LocalGameBean) obj, (LocalGameBean) obj2);
            }
        });
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sb2.append(((LocalGameBean) it2.next()).getStandardPackageName());
            sb2.append(ag.c.f654g);
        }
        if (sb2.length() <= 0) {
            return;
        }
        String strSubstring = sb2.substring(0, sb2.length() - 1);
        if (com.blankj.utilcode.util.n0.b(strSubstring, this.f15272c) && com.blankj.utilcode.util.n0.b(Integer.valueOf(i10), Integer.valueOf(this.f15273d))) {
            this.f15270a.f0(this.f15274e);
            return;
        }
        this.f15272c = strSubstring;
        this.f15273d = i10;
        this.f15271b.f(strSubstring, i10 != 0 ? i10 != 1 ? i10 != 2 ? 0 : 2 : 3 : 1).s0(o5.l.d()).F5(new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.k0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15265a.h0((List) obj);
            }
        }, new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.l0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                n0.i0((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.home.game.p.a
    public void d(@yt.k String str) {
        this.f15271b.d(str).J0(lj.b.d()).n0(lj.b.d()).F0();
    }

    @Override // com.flydigi.device_manager.ui.home.game.p.a
    public void u(@yt.k String str, int i10) {
        this.f15271b.u(str, i10).J0(lj.b.d()).n0(lj.b.d()).F0();
    }
}
