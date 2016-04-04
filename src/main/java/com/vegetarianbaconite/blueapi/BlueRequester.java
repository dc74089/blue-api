package com.vegetarianbaconite.blueapi;

import okhttp3.Response;

public interface BlueRequester {
    void onResponse(Response response);
    void onError(Exception e);
}
