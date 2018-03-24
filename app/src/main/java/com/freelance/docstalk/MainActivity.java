package com.freelance.docstalk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.freelance.docstalk.Model.GitModel;
import com.freelance.docstalk.Presenter.DataLoader;
import com.freelance.docstalk.Service.ApiClient;
import com.freelance.docstalk.Service.GitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private EditText searchedt;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView noresultstext;
    private ImageView searchimage;
    private RelativeLayout relativeLayout;
    private Toolbar toolbar;
    private DataLoader dataLoader;
    private LinearLayoutManager linearLayoutManager;
    private GitInterface gitInterface;
    private Observable<ArrayList<GitModel.InnerItems>> observable1;
    private Subscription subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUI();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }

    private void initUI(){
        searchedt=(EditText)findViewById(R.id.searchbar_Edittext);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        noresultstext=(TextView)findViewById(R.id.no_resultstext);
        searchimage=(ImageView)findViewById(R.id.search_image);
        relativeLayout=(RelativeLayout)findViewById(R.id.search_relative);
        fillUI();
    }
    private void fillUI(){
        gitInterface= ApiClient.getClient().create(GitInterface.class);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        searchedt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Call<GitModel> gitModelCall=gitInterface.Gitresponse(charSequence.toString(),"followers");
                gitModelCall.enqueue(new Callback<GitModel>() {
                    @Override
                    public void onResponse(Call<GitModel> call, Response<GitModel> response) {
                        if(response.isSuccessful()){
                            observable1=Observable.just(response.body().getItems());
                            //Log.d("size", String.valueOf(response.body().getItems().size()));
                            setAdapter();
                        }
                    }

                    @Override
                    public void onFailure(Call<GitModel> call, Throwable t) {
                        Log.d("throwable",t.getMessage());
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }
    private void setAdapter(){
        Observer<ArrayList<GitModel.InnerItems>> observer=new Observer<ArrayList<GitModel.InnerItems>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ArrayList<GitModel.InnerItems> innerItems) {
                if(innerItems.size()==0){
                    noresultstext.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
                else{
                    recyclerView.setVisibility(View.VISIBLE);
                    noresultstext.setVisibility(View.GONE);
                    dataLoader=new DataLoader(getApplicationContext(),innerItems);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(dataLoader);
                }
            }
        } ;
        subscription=observable1.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
