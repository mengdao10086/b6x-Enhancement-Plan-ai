package com.flydigi.game.ui.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DataConstant;
import com.flydigi.game.R;
import com.flydigi.game.adapter.GameItemAdapter;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.SearchBean;
import com.flydigi.game.data.bean.SearchRecoBean;
import com.flydigi.game.widget.SearchRecoView;
import g.p0;
import i9.a;
import java.util.Collection;
import java.util.List;
import p5.d;
import u9.h;
import xi.z;
import y8.a;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class SearchFragment extends FZFragment implements a.b {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public ImageView f15902o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public EditText f15903p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public y8.b f15904q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public SearchRecoView f15905r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public RecyclerView f15906s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public GameItemAdapter f15907t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public View f15908u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public View f15909v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public View f15910w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public ImageView f15911x8;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SearchFragment.this.w6();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 0) {
                SearchFragment.this.f15911x8.setVisibility(0);
            } else {
                SearchFragment.this.f15911x8.setVisibility(8);
            }
        }
    }

    public class b extends m5.c<BaseResponse<List<SearchRecoBean>>> {
        public b() {
        }

        @Override // m5.c
        public void d(BaseResponse<List<SearchRecoBean>> baseResponse) {
            if (SearchFragment.this.f15907t8.getData().size() == 0) {
                SearchFragment.this.f15905r8.setVisibility(0);
                SearchFragment.this.f15905r8.setData(baseResponse.data);
            }
        }
    }

    public class c extends m5.c<BaseResponse<SearchBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15914a;

        public c(int i10) {
            this.f15914a = i10;
        }

        @Override // m5.c
        public void d(BaseResponse<SearchBean> baseResponse) {
            SearchBean searchBean = baseResponse.data;
            if (searchBean.cur_page == 1) {
                SearchFragment.this.f15907t8.setNewData(searchBean.list);
            } else {
                SearchFragment.this.f15907t8.loadMoreComplete();
                SearchFragment.this.f15907t8.addData((Collection) searchBean.list);
            }
            SearchBean searchBean2 = baseResponse.data;
            if (searchBean2.cur_page == searchBean2.total_page) {
                SearchFragment.this.f15907t8.loadMoreEnd();
            }
            if (baseResponse.data.total == 0) {
                SearchFragment.this.f15907t8.setEmptyView(SearchFragment.this.f15909v8);
            }
        }

        @Override // m5.c, xi.g0
        public void onError(Throwable th2) {
            super.onError(th2);
            if (this.f15914a == 1) {
                SearchFragment.this.f15907t8.setEmptyView(SearchFragment.this.f15910w8);
            } else {
                SearchFragment.this.f15907t8.loadMoreEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n6(View view) {
        w6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o6(View view) {
        w6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p6() {
        this.f15904q8.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q6(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        GameBean item = this.f15907t8.getItem(i10);
        if (item != null) {
            h.n(X1(), "游戏详情访问", item.f15815id, "search");
            h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, item.f15815id).navigation(X1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r6(View view) {
        I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s6(View view) {
        this.f15903p8.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(View view) {
        w6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean u6(TextView textView, int i10, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 84) {
            return w6();
        }
        return false;
    }

    public static SearchFragment v6() {
        return new SearchFragment();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_search;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f15904q8 = new y8.b(this);
        this.f15902o8 = (ImageView) F5(R.id.btn_back);
        this.f15903p8 = (EditText) F5(R.id.et_search);
        this.f15911x8 = (ImageView) F5(R.id.btn_clear);
        this.f15905r8 = (SearchRecoView) F5(R.id.search_reco_view);
        this.f15906s8 = (RecyclerView) F5(R.id.rv_content);
        this.f15906s8.setLayoutManager(new LinearLayoutManager(X1()));
        GameItemAdapter gameItemAdapter = new GameItemAdapter(null, "search");
        this.f15907t8 = gameItemAdapter;
        this.f15906s8.setAdapter(gameItemAdapter);
        this.f15908u8 = w2().inflate(R.layout.base_layout_view_placeholder_loading, (ViewGroup) this.f15906s8.getParent(), false);
        this.f15909v8 = w2().inflate(R.layout.game_view_search_empty, (ViewGroup) this.f15906s8.getParent(), false);
        this.f15910w8 = w2().inflate(R.layout.base_layout_view_placehoder_error, (ViewGroup) this.f15906s8.getParent(), false);
        this.f15909v8.setOnClickListener(new View.OnClickListener() { // from class: x8.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f54944a.n6(view2);
            }
        });
        this.f15910w8.setOnClickListener(new View.OnClickListener() { // from class: x8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f54943a.o6(view2);
            }
        });
        this.f15907t8.setEnableLoadMore(true);
        this.f15907t8.setLoadMoreView(new d());
        this.f15907t8.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: x8.h
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                this.f54948a.p6();
            }
        }, this.f15906s8);
        this.f15907t8.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: x8.g
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                this.f54947a.q6(baseQuickAdapter, view2, i10);
            }
        });
        this.f15902o8.setOnClickListener(new View.OnClickListener() { // from class: x8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f54945a.r6(view2);
            }
        });
        this.f15911x8.setOnClickListener(new View.OnClickListener() { // from class: x8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f54942a.s6(view2);
            }
        });
        this.f15903p8.requestFocus();
        this.f15903p8.addTextChangedListener(new a());
        F5(R.id.btn_search).setOnClickListener(new View.OnClickListener() { // from class: x8.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f54941a.t6(view2);
            }
        });
        this.f15903p8.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x8.f
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return this.f54946a.u6(textView, i10, keyEvent);
            }
        });
        this.f15904q8.K();
    }

    @Override // y8.a.b
    public void m1(z<BaseResponse<List<SearchRecoBean>>> zVar) {
        zVar.s0(y1()).c(new b());
    }

    @Override // y8.a.b
    public void p0(z<BaseResponse<SearchBean>> zVar, int i10) {
        zVar.s0(y1()).c(new c(i10));
    }

    public final boolean w6() {
        String strTrim = this.f15903p8.getText().toString().trim();
        if (d1.g(strTrim)) {
            o.E(c3(R.string.game_please_input_search_content));
            return false;
        }
        this.f15905r8.setVisibility(8);
        this.f15904q8.B(strTrim);
        this.f15907t8.setEmptyView(this.f15908u8);
        return false;
    }
}
