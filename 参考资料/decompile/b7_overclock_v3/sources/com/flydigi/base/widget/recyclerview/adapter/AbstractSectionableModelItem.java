package com.flydigi.base.widget.recyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import ei.e;
import ei.i;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSectionableModelItem<M, VH extends RecyclerView.e0, H extends i> extends e<VH, H> implements Serializable {
    private final M data;

    public AbstractSectionableModelItem(M m10, H h10) {
        super(h10);
        this.data = m10;
    }

    @Override // ei.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        M m10 = this.data;
        M m11 = ((AbstractSectionableModelItem) obj).data;
        return m10 != null ? m10.equals(m11) : m11 == null;
    }

    public int hashCode() {
        M m10 = this.data;
        if (m10 != null) {
            return m10.hashCode();
        }
        return 0;
    }

    public M z() {
        return this.data;
    }
}
