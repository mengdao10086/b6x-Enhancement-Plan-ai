package com.flydigi.community.ui.search.history;

import com.flydigi.base.common.k;
import com.flydigi.base.common.m;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import com.flydigi.data.bean.community.ArticleBean;
import java.util.List;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.flydigi.community.ui.search.history.a$a, reason: collision with other inner class name */
    public interface InterfaceC0146a extends k {
        void M();

        z<List<String>> i();

        void k(String str);

        void n();

        z<List<ArticleBean>> o();

        void s();
    }

    public interface b extends m {
        void W1(List<ArticleBean> list);

        void i2(List<CommunitySearchHistoryBean> list);

        void u(List<String> list);
    }
}
