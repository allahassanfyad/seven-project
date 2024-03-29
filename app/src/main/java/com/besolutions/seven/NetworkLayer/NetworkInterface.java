package com.besolutions.seven.NetworkLayer;

import com.android.volley.VolleyError;

import java.util.Map;

/**
 *
 * @desc Java Interface Response Callback
 */

public interface NetworkInterface
{
    void OnStart();
    void OnResponse(ResponseModel model);
    void OnError(VolleyError error);
}
