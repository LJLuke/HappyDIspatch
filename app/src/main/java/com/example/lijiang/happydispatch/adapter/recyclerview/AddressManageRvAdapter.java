package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.AddressManage;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/3/9.
 */

public class AddressManageRvAdapter extends BaseRvAdapter<AddressManage> {
    private RvClickListener mRvClickListener;
    public AddressManageRvAdapter(Context context, List<AddressManage> list, RvClickListener listener) {
        super(context, list, listener);
    }

    public void setOnItemClickListener(RvClickListener mRvClickListener){
        this.mRvClickListener = mRvClickListener;
    }
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_address_manage;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new AddressManageHolder(view,viewType,listener);
    }

    private class AddressManageHolder extends BaseRvHolder<AddressManage>{
        ImageView mEditImage;
        ImageView mDeleteImage;

        public AddressManageHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mEditImage = itemView.findViewById(R.id.edit_image);
            mDeleteImage = itemView.findViewById(R.id.delete_iamge);
        }

        @Override
        public void bindHolder(AddressManage addressManage, final int position) {
            mEditImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRvClickListener.onItemClick(view.getId(),position);
                }
            });
        }
    }
}
