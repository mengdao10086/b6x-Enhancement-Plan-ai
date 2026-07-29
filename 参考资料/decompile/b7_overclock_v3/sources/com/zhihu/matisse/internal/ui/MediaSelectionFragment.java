package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import g.p0;
import vh.b;
import vh.c;
import xh.a;
import zh.g;

/* JADX INFO: loaded from: classes5.dex */
public class MediaSelectionFragment extends Fragment implements b.a, a.c, a.e {

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final String f25102i8 = "extra_album";

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public final b f25103c8 = new b();

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public RecyclerView f25104d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public xh.a f25105e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public a f25106f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public a.c f25107g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public a.e f25108h8;

    public interface a {
        c K0();
    }

    public static MediaSelectionFragment E5(Album album) {
        MediaSelectionFragment mediaSelectionFragment = new MediaSelectionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_album", album);
        mediaSelectionFragment.c5(bundle);
        return mediaSelectionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void E3(@p0 Bundle bundle) {
        super.E3(bundle);
        Album album = (Album) T1().getParcelable("extra_album");
        xh.a aVar = new xh.a(X1(), this.f25106f8.K0(), this.f25104d8);
        this.f25105e8 = aVar;
        aVar.u(this);
        this.f25105e8.v(this);
        this.f25104d8.setHasFixedSize(true);
        th.c cVarB = th.c.b();
        int iA = cVarB.f51305n > 0 ? g.a(X1(), cVarB.f51305n) : cVarB.f51304m;
        this.f25104d8.setLayoutManager(new GridLayoutManager(X1(), iA));
        this.f25104d8.n(new yh.b(iA, V2().getDimensionPixelSize(R.dimen.media_grid_spacing), false));
        this.f25104d8.setAdapter(this.f25105e8);
        this.f25103c8.f(w1(), this);
        this.f25103c8.e(album, cVarB.f51302k);
    }

    public void F5() {
        this.f25105e8.notifyDataSetChanged();
    }

    @Override // vh.b.a
    public void G2(Cursor cursor) {
        this.f25105e8.p(cursor);
    }

    public void G5() {
        this.f25105e8.t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void H3(Context context) {
        super.H3(context);
        if (!(context instanceof a)) {
            throw new IllegalStateException("Context must implement SelectionProvider.");
        }
        this.f25106f8 = (a) context;
        if (context instanceof a.c) {
            this.f25107g8 = (a.c) context;
        }
        if (context instanceof a.e) {
            this.f25108h8 = (a.e) context;
        }
    }

    @Override // vh.b.a
    public void L1() {
        this.f25105e8.p(null);
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_media_selection, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R3() {
        super.R3();
        this.f25103c8.g();
    }

    @Override // androidx.fragment.app.Fragment
    public void j4(View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f25104d8 = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    @Override // xh.a.e
    public void l2(Album album, Item item, int i10) {
        a.e eVar = this.f25108h8;
        if (eVar != null) {
            eVar.l2((Album) T1().getParcelable("extra_album"), item, i10);
        }
    }

    @Override // xh.a.c
    public void onUpdate() {
        a.c cVar = this.f25107g8;
        if (cVar != null) {
            cVar.onUpdate();
        }
    }
}
