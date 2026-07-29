package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.community.CommunityProvider;
import com.flydigi.community.ui.article.ArticleDetailActivity;
import com.flydigi.community.ui.comment.detail.CommentDetailActivity;
import com.flydigi.community.ui.message.MessageCenterActivity;
import com.flydigi.community.ui.my.article.MyArticleActivity;
import com.flydigi.community.ui.my.config.MySharedConfigActivity;
import com.flydigi.community.ui.my.like.MyLikeArticleActivity;
import com.flydigi.community.ui.post.PostActivity;
import com.flydigi.community.ui.search.SearchActivity;
import com.flydigi.community.ui.topic.TopicListActivity;
import com.flydigi.community.ui.topic.detail.TopicDetailActivity;
import com.flydigi.data.DataConstant;
import i9.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$community implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.b.f31919d, RouteMeta.build(routeType, ArticleDetailActivity.class, a.b.f31919d, "community", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$community.1
            {
                put(a.b.f31931p, 10);
                put(DataConstant.COMMUNITY_MESSAGE_ID, 3);
                put("id", 3);
                put(DataConstant.COMMUNITY_ARTICLE_TYPE, 3);
                put(DataConstant.COMMUNITY_ARTICLE_SOURCE, 8);
                put(DataConstant.COMMUNITY_ARTICLE_LOCATE_COMMENT, 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.b.f31920e, RouteMeta.build(routeType, CommentDetailActivity.class, a.b.f31920e, "community", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$community.2
            {
                put(DataConstant.COMMUNITY_COMMENT_ID, 3);
                put(DataConstant.COMMUNITY_MESSAGE_ID, 3);
                put("id", 3);
                put(DataConstant.COMMUNITY_ARTICLE_AUTHOR_ID, 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.b.f31924i, RouteMeta.build(routeType, MyLikeArticleActivity.class, a.b.f31924i, "community", null, -1, 10000000));
        map.put(a.b.f31925j, RouteMeta.build(routeType, MessageCenterActivity.class, a.b.f31925j, "community", null, -1, 10000000));
        map.put(a.b.f31923h, RouteMeta.build(routeType, MyArticleActivity.class, a.b.f31923h, "community", null, -1, 10000000));
        map.put(a.b.f31922g, RouteMeta.build(routeType, MySharedConfigActivity.class, a.b.f31922g, "community", null, -1, 10000000));
        map.put(a.b.f31927l, RouteMeta.build(routeType, PostActivity.class, a.b.f31927l, "community", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$community.3
            {
                put(a.b.f31933r, 3);
                put(a.b.f31931p, 10);
                put(a.b.f31929n, 10);
                put("key_config", 10);
            }
        }, -1, 10000000));
        map.put(a.b.f31917b, RouteMeta.build(RouteType.PROVIDER, CommunityProvider.class, a.b.f31917b, "community", null, -1, Integer.MIN_VALUE));
        map.put(a.b.f31921f, RouteMeta.build(routeType, SearchActivity.class, a.b.f31921f, "community", null, -1, Integer.MIN_VALUE));
        map.put(a.b.f31918c, RouteMeta.build(routeType, TopicDetailActivity.class, a.b.f31918c, "community", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$community.4
            {
                put(a.b.f31929n, 10);
                put(DataConstant.COMMUNITY_ARTICLE_SOURCE, 8);
                put(a.b.f31930o, 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.b.f31926k, RouteMeta.build(routeType, TopicListActivity.class, a.b.f31926k, "community", null, -1, Integer.MIN_VALUE));
    }
}
