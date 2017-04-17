package com.dentalavenue.dentalavenue.statePOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class stateBean {

    @SerializedName("state")
    @Expose
    private List<State> state = null;

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

}
