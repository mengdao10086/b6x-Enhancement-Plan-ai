package com.flydigi.game.data.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RecoGameEntity {

    @SerializedName("cateid")
    public String catId;

    @SerializedName("catename")
    public String catName;

    @SerializedName("list")
    public List<GameBean> games;

    public String toString() {
        return "RecoGameEntity{catName='" + this.catName + "', catId='" + this.catId + "', games=" + this.games + '}';
    }
}
