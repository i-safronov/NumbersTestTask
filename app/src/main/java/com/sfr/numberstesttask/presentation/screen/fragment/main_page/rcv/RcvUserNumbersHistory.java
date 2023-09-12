package com.sfr.numberstesttask.presentation.screen.fragment.main_page.rcv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.domain.model.UserNumberHistory;
import com.sfr.numberstesttask.databinding.RcvItemUserNumberBinding;

public class RcvUserNumbersHistory extends ListAdapter<UserNumberHistory, RcvUserNumbersHistory.UserNumbersHistoryViewHolder> {

    private RcvUserNumbersHistoryInt userNumbersHistoryInt;

    public RcvUserNumbersHistory(RcvUserNumbersHistoryInt userNumbersHistoryInt) {
        super(RcvUserNumbersHistory.DIFF_CALLBACK);
        this.userNumbersHistoryInt = userNumbersHistoryInt;
    }

    public static DiffUtil.ItemCallback<UserNumberHistory> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserNumberHistory>() {
        @Override
        public boolean areItemsTheSame(@NonNull UserNumberHistory oldItem, @NonNull UserNumberHistory newItem) {
            return oldItem.getPrimaryKey().equals(newItem.getPrimaryKey());
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserNumberHistory oldItem, @NonNull UserNumberHistory newItem) {
            return newItem.equals(oldItem);
        }
    };

    class UserNumbersHistoryViewHolder extends RecyclerView.ViewHolder {
        public RcvItemUserNumberBinding binding;
        public UserNumbersHistoryViewHolder(@NonNull RcvItemUserNumberBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public UserNumbersHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RcvItemUserNumberBinding binding = RcvItemUserNumberBinding.inflate(inflater, parent, false);
        return new UserNumbersHistoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserNumbersHistoryViewHolder holder, int position) {
        if (position != RecyclerView.NO_POSITION) {
            UserNumberHistory userNumberHistory = getCurrentList().get(position);
            holder.binding.tvNumber.setText(userNumberHistory.getNumberModel().getNumber());
            holder.binding.tvDescription.setText(userNumberHistory.getNumberInformationModel().getNumberInfo());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userNumbersHistoryInt.onHistoryClick(userNumberHistory);
                }
            });
        }
    }

}
