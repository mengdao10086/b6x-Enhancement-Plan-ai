package com.flydigi.device_manager.ui.detail.waspwing.led;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: loaded from: classes7.dex */
public class OnItemClickSpinner extends AppCompatSpinner implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AdapterView.OnItemClickListener f14777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f14778q;

    public OnItemClickSpinner(Context context) {
        super(context);
        this.f14776o = false;
        this.f14777p = null;
        this.f14778q = null;
        super.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemClickListener onItemClickListener;
        if (this.f14776o && (onItemClickListener = this.f14777p) != null) {
            onItemClickListener.onItemClick(adapterView, view, i10, j10);
        }
        if (this.f14776o && (onItemSelectedListener = this.f14778q) != null) {
            onItemSelectedListener.onItemSelected(adapterView, view, i10, j10);
        }
        this.f14776o = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f14778q;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onNothingSelected(adapterView);
        }
        this.f14776o = false;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f14776o = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f14777p = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f14778q = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public OnItemClickSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14776o = false;
        this.f14777p = null;
        this.f14778q = null;
        super.setOnItemSelectedListener(this);
    }

    public OnItemClickSpinner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f14776o = false;
        this.f14777p = null;
        this.f14778q = null;
        super.setOnItemSelectedListener(this);
    }
}
