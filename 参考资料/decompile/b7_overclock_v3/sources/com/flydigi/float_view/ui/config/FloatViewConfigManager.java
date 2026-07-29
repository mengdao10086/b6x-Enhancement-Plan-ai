package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.net.ApiException;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.RecommendConfigBean;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.just.agentweb.AgentWebView;
import com.yqritc.recyclerviewflexibledivider.a;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.greenrobot.eventbus.ThreadMode;
import top.androidman.SuperButton;
import z7.j;
import z7.p;

/* JADX INFO: loaded from: classes7.dex */
public class FloatViewConfigManager extends y7.b implements b.z {
    public static final int S7 = 1;
    public static final int T7 = 2;
    public SuperButton A;
    public SuperButton B;
    public View C;
    public eu.davidea.flexibleadapter.b C1;
    public View C2;
    public TextView D;
    public View E7;
    public View F7;
    public AgentWebView G7;
    public TextView H7;
    public View I7;
    public View J7;
    public View K0;
    public View K1;
    public View K2;
    public BubbleLayout K7;
    public int L7;
    public long M7;
    public boolean N7;
    public boolean O7;
    public boolean P7;
    public boolean Q7;
    public boolean R7;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public View f15520k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public TextView f15521k1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f15523q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f15524r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<CFGEntity> f15525s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<RecommendConfigBean.RecommendConfig> f15526t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15527u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z7.p f15528v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public View f15529v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public View f15530v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public z7.p f15531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ConstraintLayout f15532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Point f15533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SuperButton f15534z;

    public static class LocalConfigItem extends AbstractModelItem<CFGEntity, a> {
        private final GamepadInfo deviceInfo;

        public class a extends gi.d {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public TextView f15535g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public ImageView f15536h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public TextView f15537i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public ImageView f15538j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public ImageView f15539k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public View f15540l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public View f15541m;

            public a(View view, eu.davidea.flexibleadapter.b bVar) {
                super(view, bVar);
                this.f15535g = (TextView) view.findViewById(R.id.tv_name);
                this.f15536h = (ImageView) view.findViewById(R.id.iv_current_in_use);
                this.f15541m = view.findViewById(R.id.area_shortcut);
                this.f15537i = (TextView) view.findViewById(R.id.tv_shortcut);
                this.f15538j = (ImageView) view.findViewById(R.id.iv_shortcut);
                this.f15539k = (ImageView) view.findViewById(R.id.iv_arrow);
                this.f15540l = view.findViewById(R.id.tv_in_top);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // gi.d
            public void q() {
                super.q();
                boolean zB = this.f29556c.B(getAdapterPosition());
                this.itemView.setSelected(zB);
                this.f15541m.setSelected(zB);
                this.f15535g.setTextColor(((Boolean) this.f15535g.getTag()).booleanValue() ? h0.d.f(this.f15535g.getContext(), R.color.colorPrimary) : zB ? h0.d.f(this.f15535g.getContext(), R.color.color_white) : h0.d.f(this.f15535g.getContext(), R.color.color_ffffff_a60));
                int iF = zB ? h0.d.f(this.f15535g.getContext(), R.color.color_white) : h0.d.f(this.f15535g.getContext(), R.color.color_ffffff_a60);
                this.f15537i.setTextColor(iF);
                if (this.f15538j.getDrawable() != null) {
                    n0.c.n(this.f15538j.getDrawable(), iF);
                }
                if (LocalConfigItem.this.deviceInfo.getDeviceType() != 68) {
                    LocalConfigItem.this.E(this.f15541m, this.f15537i, this.f15538j, getAdapterPosition(), zB);
                }
                n0.c.n(this.f15539k.getDrawable(), iF);
                this.f15535g.setTypeface(Typeface.defaultFromStyle(zB ? 1 : 0));
            }
        }

        public LocalConfigItem(CFGEntity cFGEntity, GamepadInfo gamepadInfo) {
            super(cFGEntity);
            this.deviceInfo = gamepadInfo;
        }

        @Override // ei.c, ei.h
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
            aVar.f15535g.setText(z().title);
            aVar.f15536h.setVisibility(z().isInUse() ? 0 : 4);
            aVar.f15540l.setVisibility(z().isInTop() ? 0 : 4);
            boolean zB = bVar.B(i10);
            int iF = z().isInUse() ? h0.d.f(aVar.f15535g.getContext(), R.color.colorPrimary) : zB ? h0.d.f(aVar.f15535g.getContext(), R.color.color_white) : h0.d.f(aVar.f15535g.getContext(), R.color.color_ffffff_a60);
            aVar.f15535g.setTag(Boolean.valueOf(z().isInUse()));
            aVar.f15535g.setTypeface(Typeface.defaultFromStyle(zB ? 1 : 0));
            aVar.f15535g.setTextColor(iF);
            aVar.itemView.setSelected(zB);
            aVar.f15541m.setSelected(zB);
            int iF2 = zB ? h0.d.f(aVar.f15535g.getContext(), R.color.color_white) : h0.d.f(aVar.f15535g.getContext(), R.color.color_ffffff_a60);
            aVar.f15537i.setTextColor(iF2);
            n0.c.n(aVar.f15539k.getDrawable(), iF2);
            if (aVar.f15538j.getDrawable() != null) {
                n0.c.n(aVar.f15538j.getDrawable(), iF2);
            }
            if (this.deviceInfo.getDeviceType() == 68) {
                aVar.f15541m.setVisibility(8);
                return;
            }
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                E(aVar.f15541m, aVar.f15537i, aVar.f15538j, i10, zB);
            } else {
                aVar.f15541m.setVisibility(8);
            }
        }

        @Override // ei.c, ei.h
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
            return new a(view, bVar);
        }

        public void E(View view, TextView textView, ImageView imageView, int i10, boolean z10) {
            view.setVisibility(8);
            textView.setVisibility(8);
            imageView.setVisibility(8);
            if (i10 == 0) {
                if (this.deviceInfo.isGamepadKeyboard()) {
                    textView.setText("1");
                } else {
                    textView.setText(i1.a.W4);
                }
                textView.setVisibility(0);
                view.setVisibility(0);
                return;
            }
            if (i10 == 1) {
                if (this.deviceInfo.isGamepadKeyboard()) {
                    textView.setText("2");
                } else {
                    textView.setText("B");
                }
                textView.setVisibility(0);
                view.setVisibility(0);
                return;
            }
            if (i10 == 2) {
                if (this.deviceInfo.isGamepadKeyboard()) {
                    textView.setText("3");
                } else if (this.deviceInfo.isGamepadHalf()) {
                    textView.setText(ze.k.f58516r);
                } else {
                    textView.setText("X");
                }
                textView.setVisibility(0);
                view.setVisibility(0);
                return;
            }
            if (i10 == 3) {
                if (this.deviceInfo.isGamepadKeyboard()) {
                    textView.setText("4");
                } else if (this.deviceInfo.isGamepadHalf()) {
                    textView.setText("LT");
                } else {
                    textView.setText("Y");
                }
                textView.setVisibility(0);
                view.setVisibility(0);
                return;
            }
            if (i10 != 4) {
                if (i10 == 5) {
                    view.setVisibility(0);
                    if (this.deviceInfo.isGamepadKeyboard()) {
                        textView.setText("6");
                        textView.setVisibility(0);
                        return;
                    } else {
                        if (this.deviceInfo.isGamepadHalf()) {
                            view.setVisibility(8);
                            return;
                        }
                        imageView.setImageResource(z10 ? R.drawable.icon_right_selected : R.drawable.icon_right_normal);
                        imageView.setVisibility(0);
                        imageView.invalidate();
                        return;
                    }
                }
                return;
            }
            view.setVisibility(0);
            if (this.deviceInfo.isGamepadKeyboard()) {
                textView.setText("5");
                textView.setVisibility(0);
                return;
            }
            if (this.deviceInfo.getDeviceType() == 67) {
                textView.setText("M");
                textView.setVisibility(0);
            } else {
                if (this.deviceInfo.getDeviceType() == 65 || this.deviceInfo.getDeviceType() == 66 || this.deviceInfo.getDeviceType() == 64) {
                    view.setVisibility(8);
                    return;
                }
                imageView.setVisibility(0);
                imageView.setImageResource(z10 ? R.drawable.icon_up_selected : R.drawable.icon_up_normal);
                imageView.invalidate();
            }
        }

        @Override // ei.c, ei.h
        public int c() {
            return R.layout.floatview_item_local_config;
        }
    }

    public static class RecommendArticleItem extends AbstractModelItem<RecommendConfigBean.RecommendConfig, a> {

        public static class a extends gi.d {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public TextView f15543g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public ImageView f15544h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public TextView f15545i;

            public a(View view, eu.davidea.flexibleadapter.b bVar) {
                super(view, bVar);
                this.f15543g = (TextView) view.findViewById(R.id.tv_name);
                this.f15544h = (ImageView) view.findViewById(R.id.iv_arrow);
                this.f15545i = (TextView) view.findViewById(R.id.tv_tag);
            }

            @Override // gi.d
            public void q() {
                super.q();
                boolean zB = this.f29556c.B(getAdapterPosition());
                this.itemView.setSelected(zB);
                int iF = zB ? h0.d.f(this.f15543g.getContext(), R.color.color_white) : h0.d.f(this.f15543g.getContext(), R.color.color_ffffff_a60);
                this.f15543g.setTextColor(iF);
                this.f15543g.setTypeface(Typeface.defaultFromStyle(zB ? 1 : 0));
                n0.c.n(this.f15544h.getDrawable(), iF);
            }
        }

        public RecommendArticleItem(RecommendConfigBean.RecommendConfig recommendConfig) {
            super(recommendConfig);
        }

        @Override // ei.c, ei.h
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
            aVar.f15543g.setText(z().getTitle());
            boolean zB = bVar.B(i10);
            aVar.itemView.setSelected(zB);
            int iF = zB ? h0.d.f(aVar.f15543g.getContext(), R.color.color_white) : h0.d.f(aVar.f15543g.getContext(), R.color.color_ffffff_a60);
            aVar.f15543g.setTextColor(iF);
            aVar.f15543g.setTypeface(Typeface.defaultFromStyle(zB ? 1 : 0));
            n0.c.n(aVar.f15544h.getDrawable(), iF);
            if (!com.blankj.utilcode.util.n0.x(z().getTag())) {
                aVar.f15545i.setVisibility(8);
            } else {
                aVar.f15545i.setVisibility(0);
                aVar.f15545i.setText(z().getTag());
            }
        }

        @Override // ei.c, ei.h
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
            return new a(view, bVar);
        }

        @Override // ei.c, ei.h
        public int c() {
            return R.layout.floatview_item_recommend_article;
        }
    }

    public static class RecommendConfigItem extends AbstractModelItem<RecommendConfigBean.RecommendConfig, a> {

        public static class a extends gi.d {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public TextView f15546g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public ImageView f15547h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public TextView f15548i;

            public a(View view, eu.davidea.flexibleadapter.b bVar) {
                super(view, bVar);
                this.f15546g = (TextView) view.findViewById(R.id.tv_name);
                this.f15547h = (ImageView) view.findViewById(R.id.iv_arrow);
                this.f15548i = (TextView) view.findViewById(R.id.tv_tag);
            }

            @Override // gi.d
            public void q() {
                super.q();
                boolean zB = this.f29556c.B(getAdapterPosition());
                this.itemView.setSelected(zB);
                this.f15546g.setTextColor(zB ? h0.d.f(this.f15546g.getContext(), R.color.color_white) : h0.d.f(this.f15546g.getContext(), R.color.color_ffffff_a60));
                this.f15546g.setTypeface(Typeface.defaultFromStyle(zB ? 1 : 0));
                int iF = zB ? h0.d.f(this.f15546g.getContext(), R.color.color_white) : h0.d.f(this.f15546g.getContext(), R.color.color_ffffff_a30);
                this.f15548i.setTextColor(iF);
                n0.c.n(this.f15547h.getDrawable(), iF);
            }
        }

        public RecommendConfigItem(RecommendConfigBean.RecommendConfig recommendConfig) {
            super(recommendConfig);
        }

        @Override // ei.c, ei.h
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
            aVar.f15546g.setText(z().getTitle());
            boolean zB = bVar.B(i10);
            aVar.f15546g.setTextColor(zB ? h0.d.f(aVar.f15546g.getContext(), R.color.color_white) : h0.d.f(aVar.f15546g.getContext(), R.color.color_ffffff_a60));
            int iF = zB ? h0.d.f(aVar.f15546g.getContext(), R.color.color_white) : h0.d.f(aVar.f15546g.getContext(), R.color.color_ffffff_a30);
            aVar.f15548i.setTextColor(iF);
            aVar.f15546g.setTypeface(Typeface.defaultFromStyle(zB ? 1 : 0));
            n0.c.n(aVar.f15547h.getDrawable(), iF);
            aVar.itemView.setSelected(zB);
            if (!com.blankj.utilcode.util.n0.x(z().getTag())) {
                aVar.f15548i.setVisibility(8);
            } else {
                aVar.f15548i.setVisibility(0);
                aVar.f15548i.setText(String.format(Locale.CHINESE, "%s", z().getTag()));
            }
        }

        @Override // ei.c, ei.h
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
            return new a(view, bVar);
        }

        @Override // ei.c, ei.h
        public int c() {
            return R.layout.floatview_item_recommend_config;
        }
    }

    public class a extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f15549a;

        public a(ProgressBar progressBar) {
            this.f15549a = progressBar;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            this.f15549a.setProgress(i10);
        }
    }

    public class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f15551a;

        public b(ProgressBar progressBar) {
            this.f15551a = progressBar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f15551a.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f15551a.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            this.f15551a.setVisibility(8);
        }
    }

    public class c implements j.a {
        public c() {
        }

        @Override // z7.j.a
        public void a() {
        }

        @Override // z7.j.a
        public void b(boolean z10) {
            FloatViewConfigManager.this.r(14, FloatViewConfigManager.this.C1.v().get(0).intValue());
            com.flydigi.userBehavior.a.a().b(FloatViewConfigManager.this.f56478a, "悬浮窗_游戏配置_删除");
        }
    }

    public class d implements p.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CFGEntity f15555b;

        public d(boolean z10, CFGEntity cFGEntity) {
            this.f15554a = z10;
            this.f15555b = cFGEntity;
        }

        @Override // z7.p.c
        public void a(String str) {
            if (com.blankj.utilcode.util.n0.m(str.trim())) {
                n8.b.m(FloatViewConfigManager.this.f56478a, FloatViewConfigManager.this.f56478a.getString(R.string.floatview_config_name_cannot_empty));
                return;
            }
            if (str.length() > 20) {
                n8.b.m(FloatViewConfigManager.this.f56478a, FloatViewConfigManager.this.f56478a.getString(R.string.floatview_config_name_too_long));
                return;
            }
            if (com.blankj.utilcode.util.n0.z(FloatViewConfigManager.this.C1.v())) {
                FloatViewConfigManager floatViewConfigManager = FloatViewConfigManager.this;
                if (floatViewConfigManager.P1(floatViewConfigManager.C1.v().get(0), this.f15555b, str, this.f15554a)) {
                    FloatViewConfigManager.this.I0();
                    u9.h.u(FloatViewConfigManager.this.f56478a, this.f15555b.getTitle(), FloatViewConfigManager.this.f15524r, "修改名称");
                }
            }
        }

        @Override // z7.p.c
        public void onCancel() {
            if (this.f15554a) {
                return;
            }
            u9.h.u(FloatViewConfigManager.this.f56478a, this.f15555b.getTitle(), FloatViewConfigManager.this.f15524r, "取消");
        }
    }

    public class e implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CFGEntity f15558b;

        public e(boolean z10, CFGEntity cFGEntity) {
            this.f15557a = z10;
            this.f15558b = cFGEntity;
        }

        @Override // z7.j.a
        public void a() {
        }

        @Override // z7.j.a
        public void b(boolean z10) {
            if (this.f15557a) {
                FloatViewConfigManager.this.M1(this.f15558b);
            }
        }
    }

    public FloatViewConfigManager(Context context, y7.n nVar, Handler handler, GamepadInfo gamepadInfo, String str, List<CFGEntity> list, List<RecommendConfigBean.RecommendConfig> list2) {
        super(context, nVar, handler, gamepadInfo, true);
        this.f15522p = 1;
        this.f15527u = false;
        this.L7 = -1;
        this.M7 = 0L;
        this.N7 = true;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = false;
        this.R7 = false;
        this.f15524r = str;
        G1(list);
        if (list2 != null) {
            this.f15526t = list2;
        } else {
            this.f15526t = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1(Throwable th2) throws Exception {
        this.C1.m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B1() throws Exception {
        this.C1.n();
        this.f15527u = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C1() {
        E0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D1() {
        E0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(ConfigBean configBean, InstalledGameBean installedGameBean) throws Exception {
        configBean.setGameName(installedGameBean.getTitle());
        configBean.setPackageName(installedGameBean.getStandardPackageName());
        u9.h.k(this.f56478a, installedGameBean.getStandardPackageName(), "FloatView_Share_Config", "悬浮窗_游戏配置_分享配置");
        h3.a.j().d(a.b.f31927l).withParcelable("key_config", configBean).navigation();
    }

    public static /* synthetic */ void F1(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(Rect rect) {
        BubbleLayout bubbleLayout = this.K7;
        if (bubbleLayout != null) {
            bubbleLayout.setX(rect.right);
            this.K7.setY(rect.top + (rect.height() - this.K7.getHeight()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0() {
        if (this.K7 == null) {
            a2();
            BubbleLayout bubbleLayout = (BubbleLayout) LayoutInflater.from(this.f56478a).inflate(R.layout.floatview_layout_bubble_setting_config, (ViewGroup) null);
            this.K7 = bubbleLayout;
            ((TextView) bubbleLayout.findViewById(R.id.tv_bubble)).setText(Html.fromHtml(this.f56478a.getString(R.string.floatview_select_menu_setting_config_notice)));
            final Rect rect = new Rect();
            this.K1.findViewById(R.id.btn_edit).getGlobalVisibleRect(rect);
            this.f15523q.addView(this.K7);
            this.K7.e(ArrowDirection.LEFT);
            this.K7.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15650a.T0(rect);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CFGEntity V0(File file) throws Exception {
        return e6.z.j0(file, true, this.f56484g.getDeviceMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(RecommendConfigBean.RecommendConfig recommendConfig, CFGEntity cFGEntity) throws Exception {
        cFGEntity.title = recommendConfig.getTitle();
        cFGEntity.desc = recommendConfig.getDesc();
        cFGEntity.setRecommend(true);
        cFGEntity.setGamepad(this.f56484g.getDeviceCode());
        u9.h.t(this.f56478a, this.f15524r, recommendConfig.getTitle());
        com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_游戏配置_下载并应用_" + recommendConfig.getTitle());
        if (e6.z.z(this.f15525s, cFGEntity, cFGEntity.title)) {
            W1(cFGEntity, true);
        } else {
            O1(cFGEntity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(Throwable th2) throws Exception {
        if ((th2 instanceof ApiException) && ((ApiException) th2).a() == -101) {
            Context context = this.f56478a;
            n8.b.m(context, context.getString(R.string.net_state_error));
        } else {
            Context context2 = this.f56478a;
            n8.b.m(context2, context2.getString(R.string.floatview_recommend_config_download_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(View view) {
        E0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0(View view) {
        M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(View view) {
        R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(View view) {
        J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(View view) {
        S1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(View view) {
        a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(View view) {
        Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1(View view) {
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(View view) {
        L1();
    }

    public static /* synthetic */ void h1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(View view) {
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(View view) {
        T1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(View view) {
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(View view) {
        K1();
        if (this.K2.getVisibility() == 0) {
            H0();
        } else {
            S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(View view) {
        u9.h.k(this.f56478a, this.f15524r, "FloatView_Config_Help", "悬浮窗_游戏配置_帮助");
        Context context = this.f56478a;
        new z7.j(context, context.getString(R.string.floatview_config_manager_hint), 1, null).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(View view) {
        X1(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(View view) {
        X1(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(View view) {
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(View view) {
        N1();
    }

    public static /* synthetic */ Iterable r1(List list) throws Exception {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean s1(CFGEntity cFGEntity) throws Exception {
        return cFGEntity.isForCurrentDevice(this.f56484g.getDeviceCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(List list) throws Exception {
        this.f15525s = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(Throwable th2) throws Exception {
        this.f15525s = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LocalConfigItem v1(CFGEntity cFGEntity) throws Exception {
        return new LocalConfigItem(cFGEntity, this.f56484g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(int i10) {
        this.C1.M(i10);
        ei.h hVarG2 = this.C1.g2(i10);
        if (hVarG2 instanceof LocalConfigItem) {
            boolean zIsInTop = ((LocalConfigItem) hVarG2).z().isInTop();
            this.B.setIcon(h0.d.i(this.f56478a, zIsInTop ? R.drawable.ic_cancel_top : R.drawable.ic_top));
            this.B.setText(this.f56478a.getString(zIsInTop ? R.string.floatview_cancel_top : R.string.floatview_set_top));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x1(final int i10, List list) throws Exception {
        if (i10 >= 0) {
            i10 = R0(list, i10);
        }
        if (i10 < 0) {
            i10 = Q0();
        }
        this.f15527u = true;
        this.f56479b.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15645a.w1(i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1(Throwable th2) throws Exception {
        this.C1.I4(Collections.singletonList(new LocalConfigItem(e6.z.B(this.f56484g.getDeviceMode()), this.f56484g)));
    }

    public static /* synthetic */ AbstractModelItem z1(RecommendConfigBean.RecommendConfig recommendConfig) throws Exception {
        return recommendConfig.getType() == 0 ? new RecommendConfigItem(recommendConfig) : new RecommendArticleItem(recommendConfig);
    }

    public final void E0(boolean z10) {
        K1();
        if (com.blankj.utilcode.util.n0.z(this.C1.v())) {
            int iIntValue = this.C1.v().get(0).intValue();
            CFGEntity cFGEntityO0 = O0();
            if (cFGEntityO0 == null || !F0(cFGEntityO0)) {
                return;
            }
            Context context = this.f56478a;
            n8.b.m(context, context.getString(R.string.floatview_action_apply_config_success));
            s(8, iIntValue, cFGEntityO0);
            u9.h.q(this.f56478a, z10, iIntValue, this.f15524r);
            com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_游戏配置_应用配置_" + cFGEntityO0.title);
        }
    }

    public final boolean F0(CFGEntity cFGEntity) {
        androidx.core.util.k<Integer, String> kVarB = n8.b.b(this.f56478a, cFGEntity, this.f56484g, true);
        Integer num = kVarB.f4741a;
        if (num == null || num.intValue() == 0) {
            return true;
        }
        V1(kVarB);
        return false;
    }

    public final void G0() {
        if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_VIEW_GUIDE_SETTING_CONFIG, false)) {
            return;
        }
        o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_VIEW_GUIDE_SETTING_CONFIG, true);
        this.f15523q.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15618a.U0();
            }
        });
    }

    public final void G1(List<CFGEntity> list) {
        if (list != null) {
            xi.z.m3(list).z2(new dj.o() { // from class: com.flydigi.float_view.ui.config.a0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return FloatViewConfigManager.r1((List) obj);
                }
            }).h2(new dj.r() { // from class: com.flydigi.float_view.ui.config.b0
                @Override // dj.r
                public final boolean a(Object obj) {
                    return this.f15580a.s1((CFGEntity) obj);
                }
            }).Y6().a1(new dj.g() { // from class: com.flydigi.float_view.ui.config.r
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f15693a.t1((List) obj);
                }
            }, new dj.g() { // from class: com.flydigi.float_view.ui.config.p
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f15686a.u1((Throwable) obj);
                }
            });
        } else {
            this.f15525s = new ArrayList();
        }
    }

    public final void H0() {
        K1();
        this.C1.n();
        this.K2.setVisibility(8);
        this.K2.post(new e0(this));
    }

    public void H1(GamepadInfo gamepadInfo, String str, List<CFGEntity> list, List<RecommendConfigBean.RecommendConfig> list2) {
        this.f56484g = gamepadInfo;
        this.f15524r = str;
        G1(this.f15525s);
        if (list2 != null) {
            this.f15526t = list2;
        } else {
            this.f15526t = new ArrayList();
        }
        int i10 = this.f15522p;
        if (i10 == 1) {
            I1(-1, list);
        } else if (i10 == 2) {
            J1();
        }
        y();
    }

    public final void I0() {
        z7.p pVar = this.f15528v;
        if (pVar != null) {
            pVar.h();
            this.f15528v = null;
        }
    }

    public void I1(final int i10, final List<CFGEntity> list) {
        G1(list);
        xi.z zVarS0 = xi.z.P2(this.f15525s).A3(new dj.o() { // from class: com.flydigi.float_view.ui.config.x
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f15713a.v1((CFGEntity) obj);
            }
        }).Y6().v1().R1(new dj.a() { // from class: com.flydigi.float_view.ui.config.m
            @Override // dj.a
            public final void run() throws Exception {
                this.f15673a.x1(i10, list);
            }
        }).s0(o5.l.d());
        eu.davidea.flexibleadapter.b bVar = this.C1;
        Objects.requireNonNull(bVar);
        zVarS0.F5(new u(bVar), new dj.g() { // from class: com.flydigi.float_view.ui.config.n
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15678a.y1((Throwable) obj);
            }
        });
    }

    public final void J0() {
        K1();
        s(17, this.f15525s.size(), new CFGEntity());
        u9.h.k(this.f56478a, this.f15524r, "FloatView_Create_Config", "悬浮窗_游戏配置_新建配置");
    }

    public final void J1() {
        xi.z zVarS0 = xi.z.P2(this.f15526t).A3(new dj.o() { // from class: com.flydigi.float_view.ui.config.z
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatViewConfigManager.z1((RecommendConfigBean.RecommendConfig) obj);
            }
        }).Y6().v1().s0(o5.l.d());
        eu.davidea.flexibleadapter.b bVar = this.C1;
        Objects.requireNonNull(bVar);
        zVarS0.G5(new u(bVar), new dj.g() { // from class: com.flydigi.float_view.ui.config.q
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15690a.A1((Throwable) obj);
            }
        }, new dj.a() { // from class: com.flydigi.float_view.ui.config.k
            @Override // dj.a
            public final void run() throws Exception {
                this.f15654a.B1();
            }
        });
    }

    public final void K0() {
        K1();
        CFGEntity cFGEntityO0 = O0();
        if (cFGEntityO0 != null) {
            if (cFGEntityO0.isInUse()) {
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_action_delete_config_failure));
            } else {
                Context context2 = this.f56478a;
                new z7.j(context2, context2.getString(R.string.delete), this.f56478a.getString(R.string.floatview_are_you_sure_delete_current_config), 2, new c());
            }
        }
    }

    public final void K1() {
        BubbleLayout bubbleLayout = this.K7;
        if (bubbleLayout != null) {
            this.f15523q.removeView(bubbleLayout);
            this.K7 = null;
        }
    }

    public final void L0() {
        K1();
        final RecommendConfigBean.RecommendConfig recommendConfigP0 = P0();
        if (recommendConfigP0 == null) {
            return;
        }
        e6.z.F(recommendConfigP0.getConfigUrl()).A3(new dj.o() { // from class: com.flydigi.float_view.ui.config.y
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f15716a.V0((File) obj);
            }
        }).s0(o5.l.d()).F5(new dj.g() { // from class: com.flydigi.float_view.ui.config.t
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15700a.W0(recommendConfigP0, (CFGEntity) obj);
            }
        }, new dj.g() { // from class: com.flydigi.float_view.ui.config.o
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15682a.X0((Throwable) obj);
            }
        });
    }

    public final void L1() {
        K1();
        CFGEntity cFGEntityO0 = O0();
        if (cFGEntityO0 == null) {
            return;
        }
        u9.h.k(this.f56478a, this.f15524r, "FloatView_Rename_Config", "悬浮窗_游戏配置_重命名");
        W1(cFGEntityO0, false);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(View view, int i10) {
        K1();
        if (i10 == -1) {
            return false;
        }
        this.C1.M(i10);
        int i11 = this.f15522p;
        if (i11 == 2) {
            ei.h hVarG2 = this.C1.g2(i10);
            RecommendConfigBean.RecommendConfig recommendConfigZ = null;
            if (hVarG2 instanceof RecommendConfigItem) {
                recommendConfigZ = ((RecommendConfigItem) hVarG2).z();
            } else if (hVarG2 instanceof RecommendArticleItem) {
                recommendConfigZ = ((RecommendArticleItem) hVarG2).z();
            }
            if (recommendConfigZ != null) {
                com.flydigi.userBehavior.a.a().b(this.f56478a, "悬浮窗_游戏配置_推荐配置_" + recommendConfigZ.getTitle());
                U1(recommendConfigZ);
            }
        } else if (i11 == 1) {
            ei.h hVarG22 = this.C1.g2(i10);
            if (hVarG22 instanceof LocalConfigItem) {
                boolean zIsInTop = ((LocalConfigItem) hVarG22).z().isInTop();
                this.B.setIcon(h0.d.i(this.f56478a, zIsInTop ? R.drawable.ic_cancel_top : R.drawable.ic_top));
                this.B.setText(this.f56478a.getString(zIsInTop ? R.string.floatview_cancel_top : R.string.floatview_set_top));
            }
        }
        return true;
    }

    public final void M0() {
        K1();
        if (com.blankj.utilcode.util.n0.z(this.C1.v())) {
            int iIntValue = this.C1.v().get(0).intValue();
            CFGEntity cFGEntity = this.f15525s.get(iIntValue);
            s(17, iIntValue, cFGEntity);
            u9.h.k(this.f56478a, this.f15524r, "FloatView_Edit_Config", "悬浮窗_游戏配置_调整配置_" + cFGEntity.title);
        }
    }

    public final void M1(CFGEntity cFGEntity) {
        int size = this.f15525s.size();
        int i10 = 0;
        for (int i11 = 0; i11 < this.f15525s.size(); i11++) {
            this.f15525s.get(i11).setInUse(false);
        }
        while (true) {
            if (i10 >= this.f15525s.size()) {
                break;
            }
            if (com.blankj.utilcode.util.n0.b(this.f15525s.get(i10).title, cFGEntity.title)) {
                size = i10;
                break;
            }
            i10++;
        }
        cFGEntity.setInUse(true);
        this.f15525s.set(size, cFGEntity);
        this.C1.n();
        X1(1);
        this.f56479b.postDelayed(new Runnable() { // from class: com.flydigi.float_view.ui.config.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15594a.C1();
            }
        }, 250L);
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N0(byte[] r18) {
        /*
            Method dump skipped, instruction units count: 677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.float_view.ui.config.FloatViewConfigManager.N0(byte[]):void");
    }

    public final void N1() {
        h3.a.j().d(a.f.f31974c).withBoolean(a.f.f31981j, true).navigation();
        u9.h.k(this.f56478a, this.f15524r, "FloatView_Return_App", "悬浮窗_游戏配置_返回大厅");
    }

    public final CFGEntity O0() {
        eu.davidea.flexibleadapter.b bVar = this.C1;
        if (bVar == null || !com.blankj.utilcode.util.n0.z(bVar.v())) {
            return null;
        }
        CFGEntity cFGEntity = this.f15525s.get(this.C1.v().get(0).intValue());
        if (cFGEntity.isInvalid()) {
            return null;
        }
        return cFGEntity;
    }

    public final void O1(CFGEntity cFGEntity) {
        int size = this.f15525s.size();
        int i10 = 0;
        for (int i11 = 0; i11 < this.f15525s.size(); i11++) {
            this.f15525s.get(i11).setInUse(false);
        }
        while (true) {
            if (i10 >= this.f15525s.size()) {
                break;
            }
            if (!this.f15525s.get(i10).isInTop()) {
                size = i10;
                break;
            }
            i10++;
        }
        cFGEntity.setInUse(true);
        this.f15525s.add(size, cFGEntity);
        this.C1.n();
        X1(1);
        this.f56479b.postDelayed(new Runnable() { // from class: com.flydigi.float_view.ui.config.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15606a.D1();
            }
        }, 250L);
    }

    public final RecommendConfigBean.RecommendConfig P0() {
        eu.davidea.flexibleadapter.b bVar = this.C1;
        if (bVar == null || !com.blankj.utilcode.util.n0.z(bVar.v())) {
            return null;
        }
        return this.f15526t.get(this.C1.v().get(0).intValue());
    }

    public final boolean P1(Integer num, CFGEntity cFGEntity, String str, boolean z10) {
        if (e6.z.z(this.f15525s, cFGEntity, str)) {
            Context context = this.f56478a;
            new z7.j(context, z10 ? 2 : 1, "", context.getString(z10 ? R.string.floatview_config_name_conflict_to_replace : R.string.floatview_exist_same_config_name_please_rename_try_again), this.f56478a.getString(R.string.confirm), z10 ? this.f56478a.getString(R.string.cancel) : "", new e(z10, cFGEntity));
            return false;
        }
        cFGEntity.title = str;
        if (z10) {
            O1(cFGEntity);
        } else {
            s(13, num.intValue(), cFGEntity);
        }
        return true;
    }

    public final int Q0() {
        for (int i10 = 0; i10 < this.f15525s.size(); i10++) {
            if (this.f15525s.get(i10).isInUse()) {
                return i10;
            }
        }
        return 0;
    }

    public final void Q1() {
        K1();
        s(9, this.C1.v().get(0).intValue(), O0());
    }

    public final int R0(List<CFGEntity> list, int i10) {
        for (int i11 = 0; i11 < this.f15525s.size(); i11++) {
            if (com.blankj.utilcode.util.n0.b(list.get(i10), this.f15525s.get(i11))) {
                return i11;
            }
        }
        return -1;
    }

    public final void R1() {
        q(27);
    }

    public final void S0() {
        q(18);
        u9.b.u(this.f56478a);
    }

    public final void S1() {
        K1();
        CFGEntity cFGEntityO0 = O0();
        if (cFGEntityO0 == null) {
            return;
        }
        final ConfigBean configBean = new ConfigBean();
        cFGEntityO0.setGamepad(this.f56484g.getDeviceCode());
        cFGEntityO0.setManufacturer(com.blankj.utilcode.util.x.j());
        cFGEntityO0.setModel(com.blankj.utilcode.util.x.k());
        configBean.setTitle(cFGEntityO0.title);
        configBean.setDeviceName(this.f56484g.getDeviceName());
        configBean.setDeviceType(this.f56484g.getDeviceMode());
        configBean.setDeviceCode(this.f56484g.getDeviceCode());
        configBean.setManufacturer(com.blankj.utilcode.util.x.j());
        configBean.setModel(com.blankj.utilcode.util.x.k());
        configBean.setCfgEntity(cFGEntityO0.copy());
        DBManager.getInstance().getInstalledGameObservable(this.f15524r).s0(o5.l.d()).F5(new dj.g() { // from class: com.flydigi.float_view.ui.config.s
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f15696a.E1(configBean, (InstalledGameBean) obj);
            }
        }, new dj.g() { // from class: com.flydigi.float_view.ui.config.v
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                FloatViewConfigManager.F1((Throwable) obj);
            }
        });
    }

    public final void T1() {
        K1();
        RecommendConfigBean.RecommendConfig recommendConfigP0 = P0();
        if (recommendConfigP0 == null) {
            return;
        }
        h3.a.j().d(a.b.f31919d).withInt(DataConstant.COMMUNITY_ARTICLE_TYPE, recommendConfigP0.getArticleType()).withInt("id", recommendConfigP0.getArticleId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13294l).withFlags(268435456).navigation();
    }

    public final void U1(@g.p0 RecommendConfigBean.RecommendConfig recommendConfig) {
        K1();
        if (recommendConfig == null) {
            return;
        }
        this.K2.setVisibility(0);
        if (com.blankj.utilcode.util.n0.x(recommendConfig.getContentUrl())) {
            this.G7.loadUrl(recommendConfig.getContentUrl());
            this.E7.setVisibility(0);
            this.F7.setVisibility(8);
            this.J7.setVisibility(0);
        } else {
            this.H7.setText(recommendConfig.getDesc());
            this.E7.setVisibility(8);
            this.F7.setVisibility(0);
            this.J7.setVisibility(8);
        }
        this.I7.setVisibility(recommendConfig.getType() == 1 ? 8 : 0);
        this.f15523q.post(new e0(this));
    }

    public final void V1(androidx.core.util.k<Integer, String> kVar) {
        new z7.u0(this.f56478a, kVar).y();
    }

    public final void W1(CFGEntity cFGEntity, boolean z10) {
        I0();
        if (!z10) {
            u9.h.u(this.f56478a, cFGEntity.getTitle(), this.f15524r, "显示");
        }
        Context context = this.f56478a;
        this.f15528v = new z7.p(context, z10 ? "" : context.getString(R.string.floatview_rename), z10 ? "" : this.f56478a.getString(R.string.floatview_hint_input_new_config_name), cFGEntity.title, new d(z10, cFGEntity));
    }

    public final void X1(int i10) {
        K1();
        this.f15522p = i10;
        if (i10 == 1) {
            I1(-1, this.f15525s);
            View view = this.K1;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.K2;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            J1();
            View view3 = this.K1;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        b2();
        this.f15523q.post(new e0(this));
    }

    public final void Y1(boolean z10) {
        SuperButton superButton = this.f15534z;
        if (superButton == null) {
            return;
        }
        if (z10) {
            superButton.setText(this.f56478a.getText(R.string.floatview_show_config));
            this.f15534z.setIcon(h0.d.i(this.f56478a, R.drawable.ic_display));
        } else {
            superButton.setText(this.f56478a.getText(R.string.floatview_hide_config));
            this.f15534z.setIcon(h0.d.i(this.f56478a, R.drawable.ic_hide));
        }
    }

    public final void Z1() {
        K1();
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).c(this.f56478a, DataConstant.FLOAT_WINDOW_ACTION_HIDE_FLOAT_MAPPING_ICON);
        boolean zF = o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + this.f15524r, true);
        o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + this.f15524r, !zF);
        u9.h.w(this.f56478a, this.f15524r, zF);
        Y1(zF ^ true);
    }

    public final void a2() {
        K1();
        int i10 = 8;
        if (this.f15530v2.getVisibility() == 0) {
            int iF = h0.d.f(this.f56478a, R.color.color_white);
            this.f15530v2.setVisibility(8);
            this.C2.setVisibility(8);
            this.A.setIcon(h0.d.i(this.f56478a, R.drawable.ic_more));
            this.A.setIconColor(iF);
            this.A.setTextColor(iF);
            return;
        }
        this.f15530v2.setVisibility(0);
        if (m9.t.e(this.f56484g) && !v5.c.f()) {
            this.C2.setVisibility(0);
            View viewFindViewById = this.C2.findViewById(R.id.btn_vibrate);
            if (m9.t.e(this.f56484g) && !v5.c.f()) {
                i10 = 0;
            }
            viewFindViewById.setVisibility(i10);
        }
        int iF2 = h0.d.f(this.f56478a, R.color.colorPrimary);
        Drawable drawableI = h0.d.i(this.f56478a, R.drawable.ic_more_reserve);
        n0.c.n(drawableI, iF2);
        this.A.setIcon(drawableI);
        this.A.setIconColor(iF2);
        this.A.setTextColor(iF2);
    }

    public final void b2() {
        this.C.setSelected(this.f15522p == 1);
        this.D.setSelected(this.f15522p == 1);
        this.D.setTypeface(Typeface.defaultFromStyle(this.f15522p == 1 ? 1 : 0));
        this.f15520k0.setSelected(this.f15522p == 1);
        this.f15520k0.setVisibility(this.f15522p == 1 ? 0 : 4);
        this.K0.setSelected(this.f15522p == 2);
        this.f15521k1.setSelected(this.f15522p == 2);
        this.f15529v1.setSelected(this.f15522p == 2);
        this.f15529v1.setVisibility(this.f15522p == 2 ? 0 : 4);
        this.f15521k1.setTypeface(Typeface.defaultFromStyle(this.f15522p == 2 ? 1 : 0));
        if (this.f15522p == 2) {
            this.K1.setVisibility(8);
        }
    }

    public final void c2() {
        if (this.f15522p == 1) {
            if (this.f15533y == null) {
                int iMax = Math.max(this.f56479b.getMeasuredHeight(), this.f56479b.getMeasuredWidth());
                int iMin = Math.min(this.f56479b.getMeasuredHeight(), this.f56479b.getMeasuredWidth());
                int measuredWidth = this.f15532x.getMeasuredWidth();
                int measuredHeight = this.f15532x.getMeasuredHeight();
                Point point = new Point();
                this.f15533y = point;
                point.x = (iMax - measuredWidth) / 2;
                point.y = (iMin - measuredHeight) / 2;
            }
            this.f15532x.setVisibility(0);
            this.f15532x.setX(this.f15533y.x);
            this.f15532x.setY(this.f15533y.y);
        }
        G0();
    }

    @Override // y7.b
    public void h() {
        super.h();
        I0();
        u9.b.g(this.f56478a);
        this.f15527u = false;
        x7.f.f54911r = false;
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_select_menu;
    }

    @Override // y7.b
    public void l() {
        A();
        this.C1.n();
        this.f15522p = 1;
        this.f15530v2.setVisibility(8);
        this.C2.setVisibility(8);
        this.A.setIcon(h0.d.i(this.f56478a, R.drawable.ic_more));
        SuperButton superButton = this.A;
        Context context = this.f56478a;
        int i10 = R.color.color_white;
        superButton.setIconColor(h0.d.f(context, i10));
        this.A.setTextColor(h0.d.f(this.f56478a, i10));
        I0();
        super.l();
        u9.b.g(this.f56478a);
        this.f15527u = false;
        x7.f.f54913t = System.currentTimeMillis();
        x7.f.f54914u = System.currentTimeMillis();
        x7.f.f54916w = System.currentTimeMillis();
        x7.f.f54915v = System.currentTimeMillis();
        x7.f.f54917x = System.currentTimeMillis();
        x7.f.f54918y = System.currentTimeMillis();
        x7.f.f54911r = false;
    }

    @Override // y7.b
    public void n() {
        ViewGroup viewGroup = (ViewGroup) this.f56479b.findViewById(R.id.rl_select_menu);
        this.f15523q = viewGroup;
        com.blankj.utilcode.util.o.r(viewGroup, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15593a.l1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f56479b.findViewById(R.id.btn_help), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15655a.m1(view);
            }
        });
        this.f15532x = (ConstraintLayout) this.f56479b.findViewById(R.id.area_primary_panel);
        this.C = this.f56479b.findViewById(R.id.btn_my_config);
        this.D = (TextView) this.f56479b.findViewById(R.id.tv_my_config);
        this.f15520k0 = this.f56479b.findViewById(R.id.indicator_my_config);
        com.blankj.utilcode.util.o.r(this.C, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15597a.n1(view);
            }
        });
        this.K0 = this.f56479b.findViewById(R.id.btn_recommend_config);
        this.f15521k1 = (TextView) this.f56479b.findViewById(R.id.tv_recommend_config);
        this.f15529v1 = this.f56479b.findViewById(R.id.indicator_recommend_config);
        com.blankj.utilcode.util.o.r(this.K0, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15660a.o1(view);
            }
        });
        b2();
        SuperButton superButton = (SuperButton) this.f56479b.findViewById(R.id.btn_visibility);
        this.f15534z = superButton;
        com.blankj.utilcode.util.o.r(superButton, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15617a.p1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f56479b.findViewById(R.id.btn_return), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15601a.q1(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.f56479b.findViewById(R.id.rv_config);
        com.flydigi.base.widget.recyclerview.layoutmanager.c cVar = new com.flydigi.base.widget.recyclerview.layoutmanager.c();
        recyclerView.n(new a.C0280a(this.f56478a).t(1).l(R.color.color_ffffff_a10).s().y());
        cVar.d(recyclerView);
        if (this.C1 == null) {
            this.C1 = new eu.davidea.flexibleadapter.b(null, this);
        }
        this.C1.J(1);
        recyclerView.setAdapter(this.C1);
        this.K1 = this.f56479b.findViewById(R.id.area_operator_panel);
        this.f15530v2 = this.f56479b.findViewById(R.id.area_operator_panel_2);
        this.C2 = this.f56479b.findViewById(R.id.area_operator_panel_3);
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_apply), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15622a.Y0(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_edit), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15659a.Z0(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_vibrate), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15560a.a1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_create), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15579a.b1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_share), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15676a.c1(view);
            }
        });
        SuperButton superButton2 = (SuperButton) this.K1.findViewById(R.id.btn_more);
        this.A = superButton2;
        com.blankj.utilcode.util.o.r(superButton2, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15710a.d1(view);
            }
        });
        SuperButton superButton3 = (SuperButton) this.K1.findViewById(R.id.btn_top);
        this.B = superButton3;
        com.blankj.utilcode.util.o.r(superButton3, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15623a.e1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_delete), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15683a.f1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K1.findViewById(R.id.btn_rename), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15605a.g1(view);
            }
        });
        this.K2 = this.f56479b.findViewById(R.id.area_content);
        this.E7 = this.f56479b.findViewById(R.id.area_content_web);
        AgentWebView agentWebView = (AgentWebView) this.f56479b.findViewById(R.id.content_web);
        this.G7 = agentWebView;
        agentWebView.setBackgroundColor(0);
        ProgressBar progressBar = (ProgressBar) this.f56479b.findViewById(R.id.progress);
        WebSettings settings = this.G7.getSettings();
        this.G7.setWebChromeClient(new a(progressBar));
        this.G7.setWebViewClient(new b(progressBar));
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setJavaScriptEnabled(true);
        this.H7 = (TextView) this.f56479b.findViewById(R.id.content_text);
        this.F7 = this.f56479b.findViewById(R.id.area_content_text);
        View viewFindViewById = this.f56479b.findViewById(R.id.area_article_control);
        this.I7 = viewFindViewById;
        this.J7 = viewFindViewById.findViewById(R.id.btn_know_more);
        View viewFindViewById2 = this.I7.findViewById(R.id.btn_save_and_apply);
        com.blankj.utilcode.util.o.r(this.I7, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewConfigManager.h1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.K2.findViewById(R.id.btn_close), new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15687a.i1(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.J7, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15679a.j1(view);
            }
        });
        com.blankj.utilcode.util.o.r(viewFindViewById2, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15644a.k1(view);
            }
        });
        this.f56479b.setVisibility(4);
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(BluetoothDeviceOperateEvent bluetoothDeviceOperateEvent) {
        N0(bluetoothDeviceOperateEvent.value);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }

    @Override // y7.b
    public synchronized void y() {
        super.y();
        boolean z10 = true;
        this.N7 = true;
        x7.f.f54911r = true;
        u9.b.s(this.f56478a);
        u9.b.x(this.f56478a);
        X1(1);
        Y1(o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + this.f15524r, true));
        if (this.f15522p != 1) {
            z10 = false;
        }
        this.f15527u = z10;
        v();
    }
}
