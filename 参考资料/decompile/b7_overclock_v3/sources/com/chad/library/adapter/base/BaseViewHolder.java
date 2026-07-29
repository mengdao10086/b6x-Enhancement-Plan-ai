package com.chad.library.adapter.base;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import g.c1;
import g.d0;
import g.l;
import g.v;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BaseViewHolder extends RecyclerView.e0 {
    private BaseQuickAdapter adapter;
    private Object associatedObject;
    private final LinkedHashSet<Integer> childClickViewIds;

    @Deprecated
    public View convertView;
    private final LinkedHashSet<Integer> itemChildLongClickViewIds;
    private final HashSet<Integer> nestViews;
    private final SparseArray<View> views;

    public BaseViewHolder(View view) {
        super(view);
        this.views = new SparseArray<>();
        this.childClickViewIds = new LinkedHashSet<>();
        this.itemChildLongClickViewIds = new LinkedHashSet<>();
        this.nestViews = new HashSet<>();
        this.convertView = view;
    }

    public BaseViewHolder addOnClickListener(@d0 int... iArr) {
        for (int i10 : iArr) {
            this.childClickViewIds.add(Integer.valueOf(i10));
            View view = getView(i10);
            if (view != null) {
                if (!view.isClickable()) {
                    view.setClickable(true);
                }
                view.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        int adapterPosition;
                        if (BaseViewHolder.this.adapter.getOnItemChildClickListener() == null || (adapterPosition = BaseViewHolder.this.getAdapterPosition()) == -1) {
                            return;
                        }
                        BaseViewHolder.this.adapter.getOnItemChildClickListener().onItemChildClick(BaseViewHolder.this.adapter, view2, adapterPosition - BaseViewHolder.this.adapter.getHeaderLayoutCount());
                    }
                });
            }
        }
        return this;
    }

    public BaseViewHolder addOnLongClickListener(@d0 int... iArr) {
        for (int i10 : iArr) {
            this.itemChildLongClickViewIds.add(Integer.valueOf(i10));
            View view = getView(i10);
            if (view != null) {
                if (!view.isLongClickable()) {
                    view.setLongClickable(true);
                }
                view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseViewHolder.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        int adapterPosition;
                        if (BaseViewHolder.this.adapter.getOnItemChildLongClickListener() == null || (adapterPosition = BaseViewHolder.this.getAdapterPosition()) == -1) {
                            return false;
                        }
                        return BaseViewHolder.this.adapter.getOnItemChildLongClickListener().onItemChildLongClick(BaseViewHolder.this.adapter, view2, adapterPosition - BaseViewHolder.this.adapter.getHeaderLayoutCount());
                    }
                });
            }
        }
        return this;
    }

    public Object getAssociatedObject() {
        return this.associatedObject;
    }

    public HashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    @Deprecated
    public View getConvertView() {
        return this.convertView;
    }

    public HashSet<Integer> getItemChildLongClickViewIds() {
        return this.itemChildLongClickViewIds;
    }

    public Set<Integer> getNestViews() {
        return this.nestViews;
    }

    public <T extends View> T getView(@d0 int i10) {
        T t10 = (T) this.views.get(i10);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) this.itemView.findViewById(i10);
        this.views.put(i10, t11);
        return t11;
    }

    public BaseViewHolder linkify(@d0 int i10) {
        Linkify.addLinks((TextView) getView(i10), 15);
        return this;
    }

    public BaseViewHolder setAdapter(@d0 int i10, Adapter adapter) {
        ((AdapterView) getView(i10)).setAdapter(adapter);
        return this;
    }

    public BaseViewHolder setAlpha(@d0 int i10, float f10) {
        getView(i10).setAlpha(f10);
        return this;
    }

    public void setAssociatedObject(Object obj) {
        this.associatedObject = obj;
    }

    public BaseViewHolder setBackgroundColor(@d0 int i10, @l int i11) {
        getView(i10).setBackgroundColor(i11);
        return this;
    }

    public BaseViewHolder setBackgroundRes(@d0 int i10, @v int i11) {
        getView(i10).setBackgroundResource(i11);
        return this;
    }

    public BaseViewHolder setChecked(@d0 int i10, boolean z10) {
        KeyEvent.Callback view = getView(i10);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z10);
        }
        return this;
    }

    public BaseViewHolder setEnabled(@d0 int i10, boolean z10) {
        getView(i10).setEnabled(z10);
        return this;
    }

    public BaseViewHolder setGone(@d0 int i10, boolean z10) {
        getView(i10).setVisibility(z10 ? 0 : 8);
        return this;
    }

    public BaseViewHolder setImageBitmap(@d0 int i10, Bitmap bitmap) {
        ((ImageView) getView(i10)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(@d0 int i10, Drawable drawable) {
        ((ImageView) getView(i10)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(@d0 int i10, @v int i11) {
        ((ImageView) getView(i10)).setImageResource(i11);
        return this;
    }

    public BaseViewHolder setMax(@d0 int i10, int i11) {
        ((ProgressBar) getView(i10)).setMax(i11);
        return this;
    }

    public BaseViewHolder setNestView(@d0 int... iArr) {
        for (int i10 : iArr) {
            this.nestViews.add(Integer.valueOf(i10));
        }
        addOnClickListener(iArr);
        addOnLongClickListener(iArr);
        return this;
    }

    public BaseViewHolder setOnCheckedChangeListener(@d0 int i10, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ((CompoundButton) getView(i10)).setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnClickListener(@d0 int i10, View.OnClickListener onClickListener) {
        getView(i10).setOnClickListener(onClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnItemClickListener(@d0 int i10, AdapterView.OnItemClickListener onItemClickListener) {
        ((AdapterView) getView(i10)).setOnItemClickListener(onItemClickListener);
        return this;
    }

    public BaseViewHolder setOnItemLongClickListener(@d0 int i10, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ((AdapterView) getView(i10)).setOnItemLongClickListener(onItemLongClickListener);
        return this;
    }

    public BaseViewHolder setOnItemSelectedClickListener(@d0 int i10, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ((AdapterView) getView(i10)).setOnItemSelectedListener(onItemSelectedListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnLongClickListener(@d0 int i10, View.OnLongClickListener onLongClickListener) {
        getView(i10).setOnLongClickListener(onLongClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnTouchListener(@d0 int i10, View.OnTouchListener onTouchListener) {
        getView(i10).setOnTouchListener(onTouchListener);
        return this;
    }

    public BaseViewHolder setProgress(@d0 int i10, int i11) {
        ((ProgressBar) getView(i10)).setProgress(i11);
        return this;
    }

    public BaseViewHolder setRating(@d0 int i10, float f10) {
        ((RatingBar) getView(i10)).setRating(f10);
        return this;
    }

    public BaseViewHolder setTag(@d0 int i10, Object obj) {
        getView(i10).setTag(obj);
        return this;
    }

    public BaseViewHolder setText(@d0 int i10, CharSequence charSequence) {
        ((TextView) getView(i10)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(@d0 int i10, @l int i11) {
        ((TextView) getView(i10)).setTextColor(i11);
        return this;
    }

    public BaseViewHolder setTypeface(@d0 int i10, Typeface typeface) {
        TextView textView = (TextView) getView(i10);
        textView.setTypeface(typeface);
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        return this;
    }

    public BaseViewHolder setVisible(@d0 int i10, boolean z10) {
        getView(i10).setVisibility(z10 ? 0 : 4);
        return this;
    }

    public BaseViewHolder setAdapter(BaseQuickAdapter baseQuickAdapter) {
        this.adapter = baseQuickAdapter;
        return this;
    }

    public BaseViewHolder setProgress(@d0 int i10, int i11, int i12) {
        ProgressBar progressBar = (ProgressBar) getView(i10);
        progressBar.setMax(i12);
        progressBar.setProgress(i11);
        return this;
    }

    public BaseViewHolder setRating(@d0 int i10, float f10, int i11) {
        RatingBar ratingBar = (RatingBar) getView(i10);
        ratingBar.setMax(i11);
        ratingBar.setRating(f10);
        return this;
    }

    public BaseViewHolder setTag(@d0 int i10, int i11, Object obj) {
        getView(i10).setTag(i11, obj);
        return this;
    }

    public BaseViewHolder setText(@d0 int i10, @c1 int i11) {
        ((TextView) getView(i10)).setText(i11);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface typeface, int... iArr) {
        for (int i10 : iArr) {
            TextView textView = (TextView) getView(i10);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }
}
