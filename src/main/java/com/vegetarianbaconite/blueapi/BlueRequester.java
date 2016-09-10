package com.vegetarianbaconite.blueapi;

public interface BlueRequester {
    void onResponse(String response);
    void onError(Exception e);
}
