package com.equifax.trial.backend.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Rest implements Serializable {

    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(String type, String code, String date) {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("type", type);
        map.put("date", date);

        this.metadata.add(map);
    }
}
