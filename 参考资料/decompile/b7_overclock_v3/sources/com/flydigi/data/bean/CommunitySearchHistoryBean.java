package com.flydigi.data.bean;

import androidx.room.m1;
import androidx.room.u0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@u0(tableName = "community_search_history")
public final class CommunitySearchHistoryBean {

    @m1
    @k
    private final String keyword;
    private long timestamp;

    public CommunitySearchHistoryBean(@k String keyword, long j10) {
        f0.p(keyword, "keyword");
        this.keyword = keyword;
        this.timestamp = j10;
    }

    public static /* synthetic */ CommunitySearchHistoryBean copy$default(CommunitySearchHistoryBean communitySearchHistoryBean, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = communitySearchHistoryBean.keyword;
        }
        if ((i10 & 2) != 0) {
            j10 = communitySearchHistoryBean.timestamp;
        }
        return communitySearchHistoryBean.copy(str, j10);
    }

    @k
    public final String component1() {
        return this.keyword;
    }

    public final long component2() {
        return this.timestamp;
    }

    @k
    public final CommunitySearchHistoryBean copy(@k String keyword, long j10) {
        f0.p(keyword, "keyword");
        return new CommunitySearchHistoryBean(keyword, j10);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommunitySearchHistoryBean)) {
            return false;
        }
        CommunitySearchHistoryBean communitySearchHistoryBean = (CommunitySearchHistoryBean) obj;
        return f0.g(this.keyword, communitySearchHistoryBean.keyword) && this.timestamp == communitySearchHistoryBean.timestamp;
    }

    @k
    public final String getKeyword() {
        return this.keyword;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (this.keyword.hashCode() * 31) + a.a(this.timestamp);
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    @k
    public String toString() {
        return "CommunitySearchHistoryBean(keyword=" + this.keyword + ", timestamp=" + this.timestamp + ')';
    }
}
