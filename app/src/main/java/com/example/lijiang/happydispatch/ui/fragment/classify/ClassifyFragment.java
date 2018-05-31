package com.example.lijiang.happydispatch.ui.fragment.classify;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.ClassifyLeftRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.ClassifyRightRvAdapter;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.entity.ClassifyLeft;
import com.example.lijiang.happydispatch.entity.ClassifyRight;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.classify.ClassifyPresenter;
import com.example.lijiang.happydispatch.ui.diyView.TitleItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/26.
 */

public class ClassifyFragment extends BaseFragment implements IClassifyFView,View.OnClickListener{

    private ClassifyPresenter mPresenter;

    private RecyclerView mClassifyLeftRv;
    private RecyclerView mClassifyRightRv;

    private LinearLayoutManager mClassifyLeftManager;
    private GridLayoutManager mClassifyRightManager;

    private ClassifyLeftRvAdapter mClassifyLeftRvAdapter;

    private List<ClassifyLeft> mClassifyLeftList = new ArrayList<>();

    private List<ClassifyRight> mClassifyRightList = new ArrayList<>();

    private boolean isMove = false;
    @Override
    public int bindLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    public void initView() {
        mPresenter = new ClassifyPresenter();
        mPresenter.attachView(this);

        mClassifyLeftRv = mView.findViewById(R.id.classify_left_rv);

        mClassifyLeftManager = new LinearLayoutManager(mActivity);
        mClassifyLeftRv.setLayoutManager(mClassifyLeftManager);
        mClassifyLeftRvAdapter = new ClassifyLeftRvAdapter(mActivity, mClassifyLeftList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                setChecked(position,false);
            }
        });
        mClassifyLeftRv.setAdapter(mClassifyLeftRvAdapter);

        mClassifyRightRv = mView.findViewById(R.id.classify_right_rv);
        mClassifyRightManager = new GridLayoutManager(mActivity,3);
        mClassifyRightManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mClassifyRightList.get(position).isTitle() ? 3 : 1;
            }
        });
        mClassifyRightRv.setLayoutManager(mClassifyRightManager);
        mClassifyRightRv.addItemDecoration(new TitleItemDecoration(mActivity,mClassifyRightList));
    }

    @Override
    public void initData() {
        Integer [] classifyImage = {R.drawable.heat_prefer,R.drawable.apple,
        R.drawable.hamburger,R.drawable.salt,R.drawable.office,R.drawable.home_textitl};
        Integer [] classifyCheckedImage = {R.drawable.heat_prefer_yellow,R.drawable.apple_yellow,
                R.drawable.hamburger_yellow,R.drawable.salt_yellow,R.drawable.office_yellow,R.drawable.home_textitl_yellow};
        String [] classifyName = {"热门推荐","生鲜水果","休闲零食","粮油调味","办公文体","家纺百货"};
        for (int i = 0;i < 6;i++){
            ClassifyLeft data = new ClassifyLeft();
            data.setTitle(classifyName[i]);
            data.setImageSource(classifyImage[i]);
            data.setCheckedImageSource(classifyCheckedImage[i]);
            mClassifyLeftList.add(data);
        }
        mPresenter.getClassifyRightList();
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void onClick(View view) {

    }

    private void setChecked(int position,boolean isScroll){
        Log.d("isscroll",isScroll+"");
        isMove = isScroll;
        if (!isMove){
            mClassifyLeftRvAdapter.setCheckedPosition(position);
            if (position < mClassifyLeftList.size()-2 ){
                mClassifyLeftManager.scrollToPosition(position);
            }else {
                mClassifyLeftManager.scrollToPosition(mClassifyLeftList.size()-1);
            }
            int count = 0;
            for (int i = 0;i < position;i++){

            }
            Log.d("position",count+"");
            //rightRv.stopScroll();
            //rightManager.scrollToPositionWithOffset(count,0);
            TitleItemDecoration.setCurrentTitle(mClassifyLeftList.get(position).getTitle());
        }else if (isMove){
            if (position < mClassifyLeftList.size()-2 ){
                mClassifyLeftManager.scrollToPosition(position);
            }else {
                mClassifyLeftManager.scrollToPosition(mClassifyLeftList.size()-1);
            }
            mClassifyLeftRvAdapter.setCheckedPosition(position);
            TitleItemDecoration.setCurrentTitle(mClassifyLeftList.get(position).getTitle());
            isMove = false;
        }
    }

    @Override
    public void getClassifyRightList(List<ClassifyRight> list) {
        mClassifyRightList.addAll(list);

        ClassifyRightRvAdapter adapter = new ClassifyRightRvAdapter(mActivity, list, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {

            }
        });
        mClassifyRightRv.setAdapter(adapter);
    }
}
