package com.flydigi.community.ui.article_list;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.JzvdStd;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.x0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.ui.image_preview.PreviewBean;
import com.flydigi.base.widget.TagFlowLayout;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.community.ui.article_list.ArticleItem;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ArticleTopic;
import com.flydigi.data.bean.community.Tags;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.data.bean.community.UserInfo;
import com.flydigi.data.bean.community.UserTag;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import s4.r;
import top.androidman.SuperButton;
import y5.p;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nArticleItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArticleItem.kt\ncom/flydigi/community/ui/article_list/ArticleItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,370:1\n1855#2,2:371\n*S KotlinDebug\n*F\n+ 1 ArticleItem.kt\ncom/flydigi/community/ui/article_list/ArticleItem\n*L\n174#1:371,2\n*E\n"})
public final class ArticleItem extends AbstractModelItem<ArticleBean, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f13792a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13793b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13794c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13795d = 3;

    @yt.l
    private final Boolean showTopic;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @t0({"SMAP\nArticleItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArticleItem.kt\ncom/flydigi/community/ui/article_list/ArticleItem$ViewHolder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,370:1\n1855#2,2:371\n*S KotlinDebug\n*F\n+ 1 ArticleItem.kt\ncom/flydigi/community/ui/article_list/ArticleItem$ViewHolder\n*L\n321#1:371,2\n*E\n"})
    public static final class b extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public p f13796g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public eu.davidea.flexibleadapter.b<ImageItem> f13797h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            p pVarA = p.a(view);
            f0.o(pVarA, "bind(view)");
            this.f13796g = pVarA;
            pVarA.f56403g.fullscreenButton.setVisibility(4);
            this.f13796g.f56406j.setOnClickListener(this);
            this.f13796g.f56404h.setOnClickListener(this);
            this.f13796g.f56405i.setOnClickListener(this);
            this.f13796g.f56407k.setOnClickListener(this);
            this.f13796g.f56401e.setOnClickListener(this);
            this.f13796g.f56400d.setOnClickListener(this);
            v(new eu.davidea.flexibleadapter.b<>(null, new b.z() { // from class: com.flydigi.community.ui.article_list.b
                @Override // eu.davidea.flexibleadapter.b.z
                public final boolean M(View view2, int i10) {
                    return ArticleItem.b.s(this.f13817a, view2, i10);
                }
            }));
            this.f13796g.f56400d.setAdapter(t());
            this.f13796g.f56400d.setLayoutManager(new GridLayoutManager(h().getContext(), 3));
            p pVar = this.f13796g;
            pVar.f56400d.n(new s5.a(3, pVar.getRoot().getResources().getDimensionPixelSize(R.dimen.qb_px_6), false));
        }

        public static final boolean s(b this$0, View view, int i10) {
            f0.p(this$0, "this$0");
            f0.p(view, "<anonymous parameter 0>");
            ei.h hVarG2 = this$0.t().g2(i10);
            f0.n(hVarG2, "null cannot be cast to non-null type com.flydigi.community.ui.article_list.ImageItem");
            ImageItem imageItem = (ImageItem) hVarG2;
            if (imageItem.E()) {
                this$0.f13796g.getRoot().performClick();
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (ContentAddBean contentAddBean : imageItem.D()) {
                PreviewBean previewBean = new PreviewBean();
                previewBean.url = contentAddBean.url;
                arrayList.add(previewBean);
            }
            int size = arrayList.size();
            Postcard postcardWithSerializable = h3.a.j().d(i9.a.f31901c).withSerializable("main_image_urls", arrayList);
            if (size == 4 && i10 > 2) {
                i10--;
            }
            postcardWithSerializable.withInt("main_image_current_position", i10).navigation();
            return true;
        }

        @yt.k
        public final eu.davidea.flexibleadapter.b<ImageItem> t() {
            eu.davidea.flexibleadapter.b<ImageItem> bVar = this.f13797h;
            if (bVar != null) {
                return bVar;
            }
            f0.S("imageAdapter");
            return null;
        }

        @yt.k
        public final p u() {
            return this.f13796g;
        }

        public final void v(@yt.k eu.davidea.flexibleadapter.b<ImageItem> bVar) {
            f0.p(bVar, "<set-?>");
            this.f13797h = bVar;
        }

        public final void w(@yt.k p pVar) {
            f0.p(pVar, "<set-?>");
            this.f13796g = pVar;
        }
    }

    public static final class c extends TagFlowLayout.a<ArticleTopic> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f13798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<ArticleTopic> f13799c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, List<ArticleTopic> list, List<ArticleTopic> list2) {
            super(list2);
            this.f13798b = bVar;
            this.f13799c = list;
        }

        @Override // com.flydigi.base.widget.TagFlowLayout.a
        @yt.k
        public View c(int i10) {
            View item = LayoutInflater.from(this.f13798b.itemView.getContext()).inflate(R.layout.community_item_article_tag_topic, (ViewGroup) null);
            item.setSelected(true);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = item.getResources().getDimensionPixelSize(R.dimen.qb_px_8);
            item.setLayoutParams(marginLayoutParams);
            TextView textView = (TextView) item.findViewById(R.id.tv_title);
            TopicBean topic = this.f13799c.get(i10).getTopic();
            textView.setText(topic != null ? topic.getTitle() : null);
            f0.o(item, "item");
            return item;
        }
    }

    public /* synthetic */ ArticleItem(ArticleBean articleBean, Boolean bool, int i10, u uVar) {
        this(articleBean, (i10 & 2) != 0 ? Boolean.TRUE : bool);
    }

    public static final void D(List it2, int i10, View view) {
        f0.p(it2, "$it");
        f0.p(view, "view");
        view.setSelected(true);
        h3.a.j().d(a.b.f31918c).withParcelable(a.b.f31929n, ((ArticleTopic) it2.get(i10)).getTopic()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13283a).navigation();
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter, @yt.k b holder, int i10, @yt.k List<? extends Object> payloads) {
        r<ImageView, Drawable> rVarS1;
        List<ContentAddBean> image;
        CfgInfoBean cfgInfo;
        final List<ArticleTopic> topics;
        List<UserTag> userTag;
        UserTag userTag2;
        Tags tags;
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        int i11 = 2;
        if (payloads.isEmpty()) {
            int i12 = 8;
            holder.u().f56402f.setVisibility((n0.x(z().getVideoFile()) || n0.z(z().getImage())) ? 0 : 8);
            if (n0.m(z().getVideoFile())) {
                JzvdStd jzvdStd = holder.u().f56403g;
                f0.o(jzvdStd, "holder.viewBinding.areaVideo");
                o5.c.b(jzvdStd, Boolean.FALSE, false, 2, null);
                holder.u().f56399c.setVisibility(n0.z(z().getImage()) ? 0 : 8);
                List<ContentAddBean> image2 = z().getImage();
                if (image2 != null) {
                    holder.u().f56401e.setVisibility(image2.size() == 1 ? 0 : 8);
                    holder.u().f56400d.setVisibility(image2.size() > 1 ? 0 : 8);
                }
            } else {
                JzvdStd jzvdStd2 = holder.u().f56403g;
                f0.o(jzvdStd2, "holder.viewBinding.areaVideo");
                o5.c.b(jzvdStd2, Boolean.TRUE, false, 2, null);
                FrameLayout frameLayout = holder.u().f56399c;
                f0.o(frameLayout, "holder.viewBinding.areaImage");
                Boolean bool = Boolean.FALSE;
                o5.c.b(frameLayout, bool, false, 2, null);
                ImageView imageView = holder.u().f56401e;
                f0.o(imageView, "holder.viewBinding.areaImageSingle");
                o5.c.b(imageView, bool, false, 2, null);
                RecyclerView recyclerView = holder.u().f56400d;
                f0.o(recyclerView, "holder.viewBinding.areaImageMulti");
                o5.c.b(recyclerView, bool, false, 2, null);
            }
            LinearLayout linearLayout = holder.u().f56398b;
            CfgInfoBean cfgInfo2 = z().getCfgInfo();
            linearLayout.setVisibility((cfgInfo2 != null ? cfgInfo2.getId() : 0) > 0 ? 0 : 8);
            holder.u().f56413q.setVisibility((n0.x(z().getTitle()) || n0.x(z().getDescription())) ? 0 : 8);
            TagFlowLayout tagFlowLayout = holder.u().f56410n;
            Boolean bool2 = this.showTopic;
            Boolean bool3 = Boolean.TRUE;
            if (f0.g(bool2, bool3) && n0.z(z().getTopics())) {
                i12 = 0;
            }
            tagFlowLayout.setVisibility(i12);
            holder.u().f56416t.setText(z().getAuthor());
            UserInfo userInfo = z().getUserInfo();
            if (userInfo == null || (userTag = userInfo.getUserTag()) == null || (userTag2 = (UserTag) CollectionsKt___CollectionsKt.B2(userTag)) == null || (tags = userTag2.getTags()) == null) {
                rVarS1 = null;
            } else {
                ImageView imageView2 = holder.u().f56409m;
                f0.o(imageView2, "holder.viewBinding.ivUserMark");
                o5.c.b(imageView2, bool3, false, 2, null);
                TextView textView = holder.u().f56415s;
                f0.o(textView, "holder.viewBinding.tvUserMark");
                o5.c.b(textView, bool3, false, 2, null);
                holder.u().f56415s.setText(tags.getTag());
                rVarS1 = com.bumptech.glide.b.F(holder.itemView).t(tags.getImage()).s1(holder.u().f56409m);
            }
            if (rVarS1 == null) {
                ImageView imageView3 = holder.u().f56409m;
                f0.o(imageView3, "holder.viewBinding.ivUserMark");
                Boolean bool4 = Boolean.FALSE;
                o5.c.b(imageView3, bool4, false, 2, null);
                TextView textView2 = holder.u().f56415s;
                f0.o(textView2, "holder.viewBinding.tvUserMark");
                o5.c.b(textView2, bool4, false, 2, null);
            }
            holder.u().f56414r.setText(holder.u().getRoot().getResources().getString(z().getComments() > 0 ? R.string.community_reply_time : R.string.community_publish_time, d6.f.a(z().getUpdateTime())));
            if (n0.x(z().getTitle()) && n0.x(z().getDescription())) {
                String title = z().getTitle();
                if (title != null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(title + zc.f.f58383m + z().getDescription());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, title.length(), 18);
                    holder.u().f56413q.setText(spannableStringBuilder);
                }
            } else if (n0.x(z().getTitle())) {
                String title2 = z().getTitle();
                if (title2 != null) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(title2);
                    spannableStringBuilder2.setSpan(new StyleSpan(1), 0, title2.length(), 18);
                    holder.u().f56413q.setText(spannableStringBuilder2);
                }
            } else if (n0.x(z().getDescription())) {
                holder.u().f56413q.setText(z().getDescription());
            }
            com.bumptech.glide.h hVarG = com.bumptech.glide.b.F(holder.u().f56408l).t(z().getAvatar()).g();
            int i13 = R.drawable.main_ic_default_avatar;
            hVarG.E0(i13).x(i13).s1(holder.u().f56408l);
            if (f0.g(this.showTopic, bool3) && n0.z(z().getTopics()) && (topics = z().getTopics()) != null) {
                holder.u().f56410n.setAdapter(new c(holder, topics, z().getTopics()));
                holder.u().f56410n.setOnItemClickListener(new TagFlowLayout.b() { // from class: com.flydigi.community.ui.article_list.a
                    @Override // com.flydigi.base.widget.TagFlowLayout.b
                    public final void a(int i14, View view) {
                        ArticleItem.D(topics, i14, view);
                    }
                });
            }
            String string = "";
            if (n0.x(z().getVideoFile())) {
                holder.u().f56403g.setUp(z().getVideoFile(), "", 0);
                com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.F(holder.u().f56403g).t(z().getVideoImg());
                int i14 = R.drawable.pic_banner_place_holder;
                hVarT.E0(i14).x(i14).s1(holder.u().f56403g.posterImageView);
            } else if (n0.z(z().getImage()) && (image = z().getImage()) != null) {
                if (image.size() > 1) {
                    ArrayList arrayList = new ArrayList(image.size());
                    Iterator<Integer> it2 = CollectionsKt__CollectionsKt.F(image).iterator();
                    while (it2.hasNext()) {
                        int iB = ((k0) it2).b();
                        ContentAddBean contentAddBean = image.get(iB);
                        if (image.size() == 4 && iB == i11) {
                            Integer num = null;
                            arrayList.add(new ImageItem(image, new ContentAddBean(), true, num, 8, null));
                            arrayList.add(new ImageItem(image, contentAddBean, false, num, 8, null));
                        } else if (image.size() <= 6) {
                            arrayList.add(new ImageItem(image, contentAddBean, false, null, 8, null));
                        } else if (iB < 5) {
                            arrayList.add(new ImageItem(image, contentAddBean, false, null, 8, null));
                        } else if (iB == 5) {
                            arrayList.add(new ImageItem(image, contentAddBean, false, Integer.valueOf(image.size() - 6)));
                        }
                        i11 = 2;
                    }
                    int size = arrayList.size() % 3;
                    if (size == 1) {
                        boolean z10 = true;
                        Integer num2 = null;
                        int i15 = 8;
                        u uVar = null;
                        arrayList.add(new ImageItem(image, new ContentAddBean(), z10, num2, i15, uVar));
                        arrayList.add(new ImageItem(image, new ContentAddBean(), z10, num2, i15, uVar));
                    } else if (size == 2) {
                        arrayList.add(new ImageItem(image, new ContentAddBean(), true, null, 8, null));
                    }
                    holder.t().I4(arrayList);
                    z1 z1Var = z1.f38230a;
                } else {
                    f0.o(com.bumptech.glide.b.F(holder.u().f56401e).t(image.get(0).url).C0((((x0.b() - (holder.itemView.getResources().getDimensionPixelSize(R.dimen.qb_px_16) * 2)) - (holder.itemView.getResources().getDimensionPixelSize(R.dimen.qb_px_6) * 2)) / 3) * 2).s1(holder.u().f56401e), "{\n                      …le)\n                    }");
                }
            }
            if (z().getCfgId() > 0 && (cfgInfo = z().getCfgInfo()) != null) {
                String gameName = cfgInfo.getGameName();
                if (!(gameName == null || gameName.length() == 0)) {
                    string = cfgInfo.getGameName() + zc.f.f58380j;
                }
                String gamepad = cfgInfo.getGamepad();
                if (!(gamepad == null || gamepad.length() == 0)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    String gamepad2 = cfgInfo.getGamepad();
                    f0.o(gamepad2, "it.gamepad");
                    sb2.append(com.flydigi.community.ui.article_list.c.a(gamepad2));
                    sb2.append(zc.f.f58380j);
                    string = sb2.toString();
                }
                String modelName = cfgInfo.getModelName();
                if (!(modelName == null || modelName.length() == 0)) {
                    string = string + cfgInfo.getModelName();
                }
                holder.u().f56412p.setText(cfgInfo.getTitle());
                holder.u().f56411o.setText(string);
                SuperButton superButton = holder.u().f56405i;
                Resources resources = holder.u().f56405i.getResources();
                int i16 = R.string.community_config_download_with_count;
                Object[] objArr = new Object[1];
                objArr[0] = cfgInfo.getDownnum() >= 10000 ? holder.u().f56405i.getResources().getString(R.string.community_config_download_count_over_10000) : String.valueOf(cfgInfo.getDownnum());
                superButton.setText(resources.getString(i16, objArr));
            }
            if (z().getComments() == 0) {
                holder.u().f56404h.setText(holder.itemView.getContext().getString(R.string.community_comment));
            } else {
                holder.u().f56404h.setText(String.valueOf(z().getComments()));
            }
        } else {
            Object obj = payloads.get(0);
            if (f0.g(obj, 1)) {
                ArticleBean articleBeanZ = z();
                articleBeanZ.setLikes(articleBeanZ.getLikes() + 1);
            } else if (f0.g(obj, 2)) {
                ArticleBean articleBeanZ2 = z();
                articleBeanZ2.setLikes(articleBeanZ2.getLikes() - 1);
            } else if (f0.g(obj, 3)) {
                ArticleBean articleBeanZ3 = z();
                articleBeanZ3.setShareCount(articleBeanZ3.getShareCount() + 1);
            }
        }
        if (z().getShareCount() == 0) {
            holder.u().f56407k.setText(holder.itemView.getContext().getString(R.string.share));
        } else {
            holder.u().f56407k.setText(String.valueOf(z().getShareCount()));
        }
        if (z().getLikes() == 0) {
            holder.u().f56406j.setText(holder.itemView.getContext().getString(R.string.community_prize));
        } else {
            holder.u().f56406j.setText(String.valueOf(z().getLikes()));
        }
        int iF = h0.d.f(holder.itemView.getContext(), z().isLike() == 1 ? R.color.colorAccentRed : R.color.color_000000_a50);
        holder.u().f56406j.setIcon(h0.d.i(holder.itemView.getContext(), z().isLike() == 1 ? R.drawable.community_ic_liked : R.drawable.ic_like));
        holder.u().f56406j.setIconColor(iF);
        holder.u().f56406j.setTextColor(iF);
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public b i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new b(view, adapter);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void x(@yt.l eu.davidea.flexibleadapter.b<ei.h<?>> bVar, @yt.k b holder, int i10) {
        f0.p(holder, "holder");
        super.x(bVar, holder, i10);
        if (holder.u().f56403g.state == 5) {
            holder.u().f56403g.reset();
        }
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_article;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArticleItem(@yt.k ArticleBean data, @yt.l Boolean bool) {
        super(data);
        f0.p(data, "data");
        this.showTopic = bool;
    }
}
