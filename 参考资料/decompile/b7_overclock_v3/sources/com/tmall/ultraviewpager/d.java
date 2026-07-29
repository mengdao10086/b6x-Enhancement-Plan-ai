package com.tmall.ultraviewpager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes5.dex */
public class d extends k2.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f22865i = 400;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k2.a f22866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22867b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22870e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f22872g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f22868c = Float.NaN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SparseArray f22873h = new SparseArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22871f = 400;

    public interface a {
        void a();

        void b();
    }

    public d(k2.a aVar) {
        this.f22866a = aVar;
    }

    public k2.a a() {
        return this.f22866a;
    }

    public int b() {
        return this.f22866a.getCount();
    }

    public View c(int i10) {
        return (View) this.f22873h.get(i10);
    }

    public boolean d() {
        return this.f22867b;
    }

    @Override // k2.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        if (this.f22867b && this.f22866a.getCount() != 0) {
            i10 %= this.f22866a.getCount();
        }
        if (e() && (obj instanceof RelativeLayout)) {
            RelativeLayout relativeLayout = (RelativeLayout) obj;
            View childAt = relativeLayout.getChildAt(0);
            relativeLayout.removeAllViews();
            this.f22866a.destroyItem(viewGroup, i10, (Object) childAt);
        } else {
            this.f22866a.destroyItem(viewGroup, i10, obj);
        }
        this.f22873h.remove(i10);
    }

    public boolean e() {
        return !Float.isNaN(this.f22868c) && this.f22868c < 1.0f;
    }

    public void f(a aVar) {
        this.f22872g = aVar;
    }

    @Override // k2.a
    public void finishUpdate(ViewGroup viewGroup) {
        if (!this.f22869d && this.f22866a.getCount() > 0 && getCount() > this.f22866a.getCount()) {
            this.f22872g.b();
        }
        this.f22869d = true;
        this.f22866a.finishUpdate(viewGroup);
    }

    public void g(boolean z10) {
        this.f22867b = z10;
        notifyDataSetChanged();
        if (z10) {
            return;
        }
        this.f22872g.a();
    }

    @Override // k2.a
    public int getCount() {
        if (!this.f22867b) {
            return this.f22866a.getCount();
        }
        if (this.f22866a.getCount() == 0) {
            return 0;
        }
        return this.f22866a.getCount() * this.f22871f;
    }

    @Override // k2.a
    public int getItemPosition(Object obj) {
        return this.f22866a.getItemPosition(obj);
    }

    @Override // k2.a
    public CharSequence getPageTitle(int i10) {
        return this.f22866a.getPageTitle(i10 % this.f22866a.getCount());
    }

    @Override // k2.a
    public float getPageWidth(int i10) {
        return this.f22866a.getPageWidth(i10);
    }

    public void h(int i10) {
        this.f22871f = i10;
    }

    public void i(float f10) {
        this.f22868c = f10;
    }

    @Override // k2.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        if (this.f22867b && this.f22866a.getCount() != 0) {
            i10 %= this.f22866a.getCount();
        }
        Object objInstantiateItem = this.f22866a.instantiateItem(viewGroup, i10);
        View view = objInstantiateItem instanceof View ? (View) objInstantiateItem : null;
        if (objInstantiateItem instanceof RecyclerView.e0) {
            view = ((RecyclerView.e0) objInstantiateItem).itemView;
        }
        int childCount = viewGroup.getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = viewGroup.getChildAt(i11);
            if (isViewFromObject(childAt, objInstantiateItem)) {
                this.f22873h.put(i10, childAt);
                break;
            }
            i11++;
        }
        if (!e()) {
            return objInstantiateItem;
        }
        if (this.f22870e == 0) {
            this.f22870e = viewGroup.getResources().getDisplayMetrics().widthPixels;
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        if (view.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (this.f22870e * this.f22868c), -1);
            layoutParams.addRule(13, -1);
            view.setLayoutParams(layoutParams);
        }
        viewGroup.removeView(view);
        relativeLayout.addView(view);
        viewGroup.addView(relativeLayout);
        return relativeLayout;
    }

    @Override // k2.a
    public boolean isViewFromObject(View view, Object obj) {
        return this.f22866a.isViewFromObject(view, obj);
    }

    @Override // k2.a
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f22866a.notifyDataSetChanged();
    }

    @Override // k2.a
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f22866a.registerDataSetObserver(dataSetObserver);
    }

    @Override // k2.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.f22866a.restoreState(parcelable, classLoader);
    }

    @Override // k2.a
    public Parcelable saveState() {
        return this.f22866a.saveState();
    }

    @Override // k2.a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        this.f22866a.setPrimaryItem(viewGroup, i10, obj);
    }

    @Override // k2.a
    public void startUpdate(ViewGroup viewGroup) {
        this.f22866a.startUpdate(viewGroup);
    }

    @Override // k2.a
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f22866a.unregisterDataSetObserver(dataSetObserver);
    }
}
