package com.flydigi.base.widget.recyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import ei.c;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractModelItem<M, VH extends RecyclerView.e0> extends c<VH> implements Serializable {
    private M data;

    public AbstractModelItem(M m10) {
        this.data = m10;
    }

    public void A(M m10) {
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
        return Objects.equals(this.data, ((AbstractModelItem) obj).data);
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
