package org.tachacoin.wallet.viewholder;

import android.support.wear.widget.WearableRecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.entity.History;

import butterknife.BindView;
import butterknife.ButterKnife;

import org.tachacoin.wallet.listener.ItemClickListener;
import org.tachacoin.wallet.utils.DateCalculator;

/**
 * Created by kirillvolkov on 22.11.2017.
 */

public class HistoryViewHolder extends WearableRecyclerView.ViewHolder {

    @BindView(R.id.tv_value)
    TextView mTextViewValue;

    @BindView(R.id.tv_date)
    TextView mTextViewDate;

    @BindView(R.id.tv_id)
    TextView mTextViewID;

    @BindView(R.id.iv_icon)
    ImageView mImageViewIcon;

    public HistoryViewHolder(View itemView, final ItemClickListener itemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setClickable(true);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(getAdapterPosition() -1);
            }
        });
    }

    public void bind(History history) {
        if (history.getBlockTime() != null) {
            mTextViewDate.setText(DateCalculator.getShortDate(history.getBlockTime() * 1000L));

        } else {
            mTextViewDate.setText(mTextViewDate.getContext().getString(R.string.unconfirmed));
        }
        if(history.getChangeInBalance() != null) {
            if (history.getChangeInBalance().doubleValue() > 0) {
                mTextViewID.setText(history.getTxHash());
                mImageViewIcon.setImageResource(R.drawable.receive_shape);
            } else {
                mTextViewID.setText(history.getTxHash());
                mImageViewIcon.setImageResource(R.drawable.send_shape);
            }
        } else {
            mTextViewID.setText("NULL");
            mImageViewIcon.setImageResource(R.drawable.red_point);
        }
        if(history.getChangeInBalance() != null) {
            mTextViewValue.setText(String.format("%s TACHACOIN",history.getChangeInBalance().toString()));
        } else {
            mTextViewValue.setText(String.format("%s TACHACOIN","null"));
        }
    }
}
