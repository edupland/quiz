package com.example.sully.quizwithserver.Requests;

import android.content.Context;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.sully.quizwithserver.DatabaseFiles.QuizDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MyRequest {

    private Context context;
    private RequestQueue queue;

    public MyRequest(Context context, RequestQueue queue) {
        this.context = context;
        this.queue = queue;
    }

    public void insert(final ArrayList<Object> data){

        String url = "http://sullyvan.tremor.emi.u-bordeaux.fr/script_php/insertQuiz.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();

                map.put(QuizDAO.QUIZ_GENERATION, data.get(0).toString());
                map.put(QuizDAO.QUIZ_SEX, data.get(1).toString());
                map.put(QuizDAO.QUIZ_LEVEL, data.get(2).toString());
                map.put(QuizDAO.QUIZ_RESIDENCE, data.get(3).toString());
                map.put(QuizDAO.QUIZ_VISIT, data.get(4).toString());
                map.put(QuizDAO.QUIZ_CHILD,data.get(5).toString());
                map.put(QuizDAO.QUIZ_GROUP, data.get(6).toString());
                map.put(QuizDAO.QUIZ_FOUND, data.get(7).toString());
                map.put(QuizDAO.QUIZ_GRADE, data.get(8).toString());
                map.put(QuizDAO.QUIZ_DESCRIPTIF, data.get(9).toString());
                map.put(QuizDAO.QUIZ_RECOMMANDATION_LVL, data.get(10).toString());
                map.put(QuizDAO.QUIZ_COMMENTARY, data.get(11).toString());

                return map;
            }
        };

        queue.add(request);

    }


}
