package com.flydigi.community.ui.post;

import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.TopicBean;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface s {

    public interface a extends com.flydigi.base.common.k {
        void a0(@yt.k String str, @yt.k ArrayList<ContentAddBean> arrayList, @yt.l TopicBean topicBean, @yt.l ConfigBean configBean);

        void v(int i10, @yt.k String str, @yt.k ArrayList<ContentAddBean> arrayList, @yt.l TopicBean topicBean, @yt.l ConfigBean configBean);

        void w();

        void y(@yt.k ConfigBean configBean);
    }

    public interface b extends com.flydigi.base.common.m {
        void D(@yt.k ArticleBean articleBean);

        void F0();

        void H0();

        void J1(boolean z10);

        void N1();

        boolean Q0();

        void Q1(boolean z10);

        void a1(@yt.k ArrayList<TopicBean> arrayList);

        void h1();

        void h2(@yt.k Throwable th2);
    }
}
