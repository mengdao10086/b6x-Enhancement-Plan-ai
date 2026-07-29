package x5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.flydigi.community.ui.search.result.ResultFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.data.bean.HotSearchKeyword;
import com.flydigi.data.bean.MyMessageBean;
import com.flydigi.data.bean.MyPublishedArticlesBean;
import com.flydigi.data.bean.UnreadMessageBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ArticleList;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.CommentDetailBean;
import com.flydigi.data.bean.community.CommentListBean;
import com.flydigi.data.bean.community.LikeArticleBean;
import com.flydigi.data.bean.community.LikeCommentBean;
import com.flydigi.data.bean.community.MyLikeArticleBean;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.data.bean.community.TopicListBean;
import com.tencent.connect.common.Constants;
import java.util.List;
import nu.c;
import nu.e;
import nu.f;
import nu.o;
import nu.t;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @f("https://bbsnew.flydigi.com//api/Comment/getList")
    z<BaseResponse<CommentListBean>> A(@t("id") int i10, @t("uid") String str, @t("sort") String str2, @t("page") int i11, @t("page_size") int i12);

    @f("https://bbsnew.flydigi.com//api/v3/Archives/detail")
    z<BaseResponse<ArticleBean>> a(@t("id") int i10, @t(DataConstant.COMMUNITY_MESSAGE_ID) int i11);

    @f("https://bbsnew.flydigi.com//api/Comment/detail")
    z<BaseResponse<CommentDetailBean>> b(@t("comment_id") int i10, @t("page") int i11, @t("page_size") int i12, @t(DataConstant.COMMUNITY_MESSAGE_ID) int i13);

    @o("https://bbsnew.flydigi.com//api/v3/Archives/addShare")
    @e
    z<BaseResponse<Object>> c(@c("id") int i10);

    @f("https://bbsnew.flydigi.com//api/topic/getDetail")
    z<BaseResponse<TopicBean>> d(@t("topic_id") int i10);

    @o("https://bbsnew.flydigi.com//api/v3/Archives/like")
    @e
    z<BaseResponse<LikeArticleBean>> f(@c("id") int i10);

    @f("https://bbsnew.flydigi.com//api/v3/Archives/getList")
    z<BaseResponse<ArticleList>> g(@t("topic_id") int i10, @t("type") int i11, @t("page") int i12, @t("pageSize") int i13);

    @f("https://bbsnew.flydigi.com//api/Banner/index")
    z<BaseResponse<List<BannerBean>>> h(@t(Constants.PARAM_PLATFORM) String str);

    @f("https://bbsnew.flydigi.com//api/Search/hotKeyword")
    z<BaseResponse<HotSearchKeyword>> i();

    @f("https://bbsnew.flydigi.com//api/v1/Home/getMessageNum")
    z<BaseResponse<UnreadMessageBean>> j(@t("uid") String str);

    @f("https://bbsnew.flydigi.com//api/v3/home/archives")
    z<BaseResponse<MyPublishedArticlesBean>> l(@t("type") int i10, @t("page") int i11, @t("pageSize") int i12);

    @f("https://bbsnew.flydigi.com//api/v3/home/archives/liked")
    z<BaseResponse<MyLikeArticleBean>> m(@t("page") int i10, @t("pageSize") int i11);

    @o("https://bbsnew.flydigi.com//api/Comment/del")
    @e
    z<BaseResponse<Object>> n(@c("id") int i10);

    @o("https://bbsnew.flydigi.com//api/v3/Archives/add")
    @e
    z<BaseResponse<ArticleBean>> o(@c("content") String str, @c("image") String str2, @c("video_file") String str3, @c("video_index_id") int i10, @c("topic_ids") String str4, @c("cfg_id") int i11, @c("cfg_name") String str5, @c("game_name") String str6, @c("gamepad") String str7, @c("gamepad_type") String str8, @c(Constants.PARAM_MODEL_NAME) String str9);

    @o("https://bbsnew.flydigi.com//api/v3/Archives/delete")
    @e
    z<BaseResponse<Object>> p(@c("ids") String str);

    @o("https://bbsnew.flydigi.com//api/v1/Home/setReadMessage")
    @e
    z<BaseResponse<Object>> q(@c("messageType") int i10);

    @o("https://bbsnew.flydigi.com//api/Comment/add")
    @e
    z<BaseResponse<CommentBean>> r(@c("id") int i10, @c(CommentListFragment.N8) int i11, @c("to_id") int i12, @c("to_uid") int i13, @c("parent_id") int i14, @c("parent_uid") int i15, @c("content") String str);

    @o("https://bbsnew.flydigi.com//api/Comment/action")
    @e
    z<BaseResponse<LikeCommentBean>> s(@c("id") int i10);

    @o("https://bbsnew.flydigi.com//api/v3/Archives/edit")
    @e
    z<BaseResponse<ArticleBean>> t(@c("id") int i10, @c("content") String str, @c("image") String str2, @c("video_file") String str3, @c("video_index_id") int i11, @c("topic_ids") String str4, @c("cfg_id") int i12, @c("cfg_name") String str5, @c("game_name") String str6, @c("gamepad") String str7, @c("gamepad_type") String str8, @c(Constants.PARAM_MODEL_NAME) String str9);

    @f("https://bbsnew.flydigi.com//api/v1/Archives/get_hot_article_list")
    z<BaseResponse<ArticleList>> u(@t("page") int i10, @t("page_size") int i11, @t(zc.f.f58391u) String str);

    @f("https://bbsnew.flydigi.com//api/v1/Home/message")
    z<BaseResponse<MyMessageBean>> v(@t("uid") String str, @t("page") int i10, @t("pageSize") int i11, @t("messageType") int i12);

    @f("https://bbsnew.flydigi.com//api/Search/hotArticle")
    z<BaseResponse<ArticleList>> w();

    @f("https://bbsnew.flydigi.com//api/Archives/search")
    z<BaseResponse<ArticleList>> x(@t("type") int i10, @t("handle_cate_id") int i11, @t(ResultFragment.H8) String str, @t("page") int i12, @t("page_size") int i13);

    @f("https://bbsnew.flydigi.com/api/topic/getList")
    z<BaseResponse<TopicListBean>> y(@t("type") int i10, @t("page") int i11, @t("pageSize") int i12);

    @f("https://bbsnew.flydigi.com//api/v3/Archives/get_hot_article_list")
    z<BaseResponse<ArticleList>> z(@t("page") int i10, @t("page_size") int i11, @t(zc.f.f58391u) String str);
}
