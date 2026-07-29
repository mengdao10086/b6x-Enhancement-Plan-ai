package com.flydigi.community.ui.search.history;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.base.common.n;
import com.flydigi.community.ui.search.history.HistoryPresenter;
import com.flydigi.community.ui.search.history.a;
import com.flydigi.data.bean.HotSearchKeyword;
import com.flydigi.data.bean.community.ArticleBean;
import dj.c;
import dj.g;
import dj.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import o5.l;
import xi.j;
import xi.z;
import z5.f;

/* JADX INFO: loaded from: classes2.dex */
public class HistoryPresenter implements a.InterfaceC0146a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14063a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.b f14064b;

    public HistoryPresenter(a.b bVar) {
        this.f14064b = bVar;
    }

    public static /* synthetic */ HotSearchPageBean h0(List list, List list2) throws Exception {
        return new HotSearchPageBean(list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(HotSearchPageBean hotSearchPageBean) throws Exception {
        this.f14064b.u(hotSearchPageBean.hotKeywords);
        this.f14064b.W1(hotSearchPageBean.articleBeans);
    }

    public static /* synthetic */ void j0(Throwable th2) throws Exception {
        n.a(th2.getMessage());
    }

    public static /* synthetic */ void k0(Throwable th2) throws Exception {
    }

    @Override // com.flydigi.community.ui.search.history.a.InterfaceC0146a
    public void M() {
        z.S7(i(), o(), new c() { // from class: b6.i
            @Override // dj.c
            public final Object apply(Object obj, Object obj2) {
                return HistoryPresenter.h0((List) obj, (List) obj2);
            }
        }).s0(l.d()).F5(new g() { // from class: b6.k
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9092a.i0((HistoryPresenter.HotSearchPageBean) obj);
            }
        }, new g() { // from class: b6.m
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                HistoryPresenter.j0((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.community.ui.search.history.a.InterfaceC0146a
    public z<List<String>> i() {
        return this.f14063a.w(false).A3(new o() { // from class: b6.n
            @Override // dj.o
            public final Object apply(Object obj) {
                return ((HotSearchKeyword) obj).getKeywordList();
            }
        });
    }

    @Override // com.flydigi.community.ui.search.history.a.InterfaceC0146a
    public void k(String str) {
        this.f14063a.k(str).F0();
    }

    @Override // com.flydigi.community.ui.search.history.a.InterfaceC0146a
    public void n() {
        j<R> jVarX0 = this.f14063a.n().x0(l.e());
        final a.b bVar = this.f14064b;
        Objects.requireNonNull(bVar);
        jVarX0.g6(new g() { // from class: b6.j
            @Override // dj.g
            public final void accept(Object obj) {
                bVar.i2((List) obj);
            }
        }, new g() { // from class: b6.l
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                HistoryPresenter.k0((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.community.ui.search.history.a.InterfaceC0146a
    public z<List<ArticleBean>> o() {
        return this.f14063a.r(false).A3(b6.o.f9096a);
    }

    @Override // com.flydigi.community.ui.search.history.a.InterfaceC0146a
    public void s() {
        this.f14063a.s().F0();
    }

    public static class HotSearchPageBean implements Parcelable, Serializable {
        public static final Parcelable.Creator<HotSearchPageBean> CREATOR = new a();
        private final List<ArticleBean> articleBeans;
        private final List<String> hotKeywords;

        public class a implements Parcelable.Creator<HotSearchPageBean> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HotSearchPageBean createFromParcel(Parcel parcel) {
                return new HotSearchPageBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public HotSearchPageBean[] newArray(int i10) {
                return new HotSearchPageBean[i10];
            }
        }

        public HotSearchPageBean(List<String> list, List<ArticleBean> list2) {
            this.hotKeywords = list;
            this.articleBeans = list2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeStringList(this.hotKeywords);
            parcel.writeList(this.articleBeans);
        }

        public HotSearchPageBean(Parcel parcel) {
            this.hotKeywords = parcel.createStringArrayList();
            ArrayList arrayList = new ArrayList();
            this.articleBeans = arrayList;
            parcel.readList(arrayList, ArticleBean.class.getClassLoader());
        }
    }
}
