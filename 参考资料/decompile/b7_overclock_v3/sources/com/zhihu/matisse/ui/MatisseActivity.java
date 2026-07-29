package com.zhihu.matisse.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.AlbumPreviewActivity;
import com.zhihu.matisse.internal.ui.MediaSelectionFragment;
import com.zhihu.matisse.internal.ui.SelectedPreviewActivity;
import com.zhihu.matisse.internal.ui.widget.CheckRadioView;
import com.zhihu.matisse.internal.ui.widget.IncapableDialog;
import g.p0;
import java.util.ArrayList;
import th.c;
import vh.a;
import xh.a;
import zh.d;
import zh.f;

/* JADX INFO: loaded from: classes5.dex */
public class MatisseActivity extends f implements a.InterfaceC0620a, AdapterView.OnItemSelectedListener, MediaSelectionFragment.a, View.OnClickListener, a.c, a.e, a.f {
    public static final String J7 = "extra_result_selection";
    public static final String K7 = "extra_result_selection_path";
    public static final String L7 = "extra_result_original_enable";
    public static final int M7 = 23;
    public static final int N7 = 24;
    public static final String O7 = "checkState";
    public c C1;
    public TextView C2;
    public View E7;
    public View F7;
    public LinearLayout G7;
    public CheckRadioView H7;
    public boolean I7;
    public yh.a K1;
    public TextView K2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public zh.b f25150k1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public xh.b f25152v2;
    public final vh.a K0 = new vh.a();

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public vh.c f25151v1 = new vh.c(this);

    public class a implements f.a {
        public a() {
        }

        @Override // zh.f.a
        public void h() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cursor f25154a;

        public b(Cursor cursor) {
            this.f25154a = cursor;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25154a.moveToPosition(MatisseActivity.this.K0.d());
            yh.a aVar = MatisseActivity.this.K1;
            MatisseActivity matisseActivity = MatisseActivity.this;
            aVar.j(matisseActivity, matisseActivity.K0.d());
            Album albumC = Album.C(this.f25154a);
            if (albumC.s() && c.b().f51302k) {
                albumC.a();
            }
            MatisseActivity.this.d4(albumC);
        }
    }

    @Override // xh.a.f
    public void C2() {
        zh.b bVar = this.f25150k1;
        if (bVar != null) {
            bVar.b(this, 24);
        }
    }

    @Override // com.zhihu.matisse.internal.ui.MediaSelectionFragment.a
    public vh.c K0() {
        return this.f25151v1;
    }

    @Override // vh.a.InterfaceC0620a
    public void Q() {
        this.f25152v2.swapCursor(null);
    }

    public final int c4() {
        int iF = this.f25151v1.f();
        int i10 = 0;
        for (int i11 = 0; i11 < iF; i11++) {
            Item item = this.f25151v1.b().get(i11);
            if (item.g() && d.e(item.f25100d) > this.C1.f51312u) {
                i10++;
            }
        }
        return i10;
    }

    public final void d4(Album album) {
        if (album.s() && album.z()) {
            this.E7.setVisibility(8);
            this.F7.setVisibility(0);
        } else {
            this.E7.setVisibility(0);
            this.F7.setVisibility(8);
            n3().u().D(R.id.container, MediaSelectionFragment.E5(album), MediaSelectionFragment.class.getSimpleName()).r();
        }
    }

    public final void e4() {
        int iF = this.f25151v1.f();
        if (iF == 0) {
            this.C2.setEnabled(false);
            this.K2.setEnabled(false);
            this.K2.setText(getString(R.string.button_apply_default));
        } else if (iF == 1 && this.C1.h()) {
            this.C2.setEnabled(true);
            this.K2.setText(R.string.button_apply_default);
            this.K2.setEnabled(true);
        } else {
            this.C2.setEnabled(true);
            this.K2.setEnabled(true);
            this.K2.setText(getString(R.string.button_apply, new Object[]{Integer.valueOf(iF)}));
        }
        if (!this.C1.f51310s) {
            this.G7.setVisibility(4);
        } else {
            this.G7.setVisibility(0);
            f4();
        }
    }

    public final void f4() {
        this.H7.setChecked(this.I7);
        if (c4() <= 0 || !this.I7) {
            return;
        }
        IncapableDialog.b6("", getString(R.string.error_over_original_size, new Object[]{Integer.valueOf(this.C1.f51312u)})).Z5(n3(), IncapableDialog.class.getName());
        this.H7.setChecked(false);
        this.I7 = false;
    }

    @Override // vh.a.InterfaceC0620a
    public void j1(Cursor cursor) {
        this.f25152v2.swapCursor(cursor);
        new Handler(Looper.getMainLooper()).post(new b(cursor));
    }

    @Override // xh.a.e
    public void l2(Album album, Item item, int i10) {
        Intent intent = new Intent(this, (Class<?>) AlbumPreviewActivity.class);
        intent.putExtra("extra_album", album);
        intent.putExtra(AlbumPreviewActivity.T7, item);
        intent.putExtra(wh.a.L7, this.f25151v1.i());
        intent.putExtra("extra_result_original_enable", this.I7);
        startActivityForResult(intent, 23);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 != -1) {
            return;
        }
        if (i10 != 23) {
            if (i10 == 24) {
                Uri uriD = this.f25150k1.d();
                String strC = this.f25150k1.c();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(uriD);
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(strC);
                Intent intent2 = new Intent();
                intent2.putParcelableArrayListExtra(J7, arrayList);
                intent2.putStringArrayListExtra(K7, arrayList2);
                setResult(-1, intent2);
                new zh.f(getApplicationContext(), strC, new a());
                finish();
                return;
            }
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra(wh.a.M7);
        ArrayList<Item> parcelableArrayList = bundleExtra.getParcelableArrayList(vh.c.f53174d);
        this.I7 = intent.getBooleanExtra("extra_result_original_enable", false);
        int i12 = bundleExtra.getInt(vh.c.f53175e, 0);
        if (!intent.getBooleanExtra(wh.a.N7, false)) {
            this.f25151v1.p(parcelableArrayList, i12);
            Fragment fragmentS0 = n3().s0(MediaSelectionFragment.class.getSimpleName());
            if (fragmentS0 instanceof MediaSelectionFragment) {
                ((MediaSelectionFragment) fragmentS0).F5();
            }
            e4();
            return;
        }
        Intent intent3 = new Intent();
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        if (parcelableArrayList != null) {
            for (Item item : parcelableArrayList) {
                arrayList3.add(item.a());
                arrayList4.add(zh.c.b(this, item.a()));
            }
        }
        intent3.putParcelableArrayListExtra(J7, arrayList3);
        intent3.putStringArrayListExtra(K7, arrayList4);
        intent3.putExtra("extra_result_original_enable", this.I7);
        setResult(-1, intent3);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_preview) {
            Intent intent = new Intent(this, (Class<?>) SelectedPreviewActivity.class);
            intent.putExtra(wh.a.L7, this.f25151v1.i());
            intent.putExtra("extra_result_original_enable", this.I7);
            startActivityForResult(intent, 23);
            return;
        }
        if (view.getId() == R.id.button_apply) {
            Intent intent2 = new Intent();
            intent2.putParcelableArrayListExtra(J7, (ArrayList) this.f25151v1.d());
            intent2.putStringArrayListExtra(K7, (ArrayList) this.f25151v1.c());
            intent2.putExtra("extra_result_original_enable", this.I7);
            setResult(-1, intent2);
            finish();
            return;
        }
        if (view.getId() == R.id.originalLayout) {
            int iC4 = c4();
            if (iC4 > 0) {
                IncapableDialog.b6("", getString(R.string.error_over_original_count, new Object[]{Integer.valueOf(iC4), Integer.valueOf(this.C1.f51312u)})).Z5(n3(), IncapableDialog.class.getName());
                return;
            }
            boolean z10 = !this.I7;
            this.I7 = z10;
            this.H7.setChecked(z10);
            ai.a aVar = this.C1.f51313v;
            if (aVar != null) {
                aVar.onCheck(this.I7);
            }
        }
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        c cVarB = c.b();
        this.C1 = cVarB;
        setTheme(cVarB.f51295d);
        super.onCreate(bundle);
        if (!this.C1.f51308q) {
            setResult(0);
            finish();
            return;
        }
        setContentView(R.layout.activity_matisse);
        if (this.C1.c()) {
            setRequestedOrientation(this.C1.f51296e);
        }
        if (this.C1.f51302k) {
            zh.b bVar = new zh.b(this);
            this.f25150k1 = bVar;
            th.a aVar = this.C1.f51303l;
            if (aVar == null) {
                throw new RuntimeException("Don't forget to set CaptureStrategy.");
            }
            bVar.f(aVar);
        }
        int i10 = R.id.toolbar;
        Toolbar toolbar = (Toolbar) findViewById(i10);
        Q3(toolbar);
        androidx.appcompat.app.a aVarI3 = I3();
        aVarI3.d0(false);
        aVarI3.Y(true);
        Drawable navigationIcon = toolbar.getNavigationIcon();
        TypedArray typedArrayObtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{R.attr.album_element_color});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        navigationIcon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.C2 = (TextView) findViewById(R.id.button_preview);
        this.K2 = (TextView) findViewById(R.id.button_apply);
        this.C2.setOnClickListener(this);
        this.K2.setOnClickListener(this);
        this.E7 = findViewById(R.id.container);
        this.F7 = findViewById(R.id.empty_view);
        this.G7 = (LinearLayout) findViewById(R.id.originalLayout);
        this.H7 = (CheckRadioView) findViewById(R.id.original);
        this.G7.setOnClickListener(this);
        this.f25151v1.n(bundle);
        if (bundle != null) {
            this.I7 = bundle.getBoolean("checkState");
        }
        e4();
        this.f25152v2 = new xh.b((Context) this, (Cursor) null, false);
        yh.a aVar2 = new yh.a(this);
        this.K1 = aVar2;
        aVar2.g(this);
        this.K1.i((TextView) findViewById(R.id.selected_album));
        this.K1.h(findViewById(i10));
        this.K1.f(this.f25152v2);
        this.K0.f(this, this);
        this.K0.i(bundle);
        this.K0.e();
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.K0.g();
        c cVar = this.C1;
        cVar.f51313v = null;
        cVar.f51309r = null;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.K0.k(i10);
        this.f25152v2.getCursor().moveToPosition(i10);
        Album albumC = Album.C(this.f25152v2.getCursor());
        if (albumC.s() && c.b().f51302k) {
            albumC.a();
        }
        d4(albumC);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f25151v1.o(bundle);
        this.K0.j(bundle);
        bundle.putBoolean("checkState", this.I7);
    }

    @Override // xh.a.c
    public void onUpdate() {
        e4();
        ai.c cVar = this.C1.f51309r;
        if (cVar != null) {
            cVar.a(this.f25151v1.d(), this.f25151v1.c());
        }
    }
}
