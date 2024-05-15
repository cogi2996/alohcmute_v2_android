package com.example.alohcmute_v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    private List<Post> postList;
    private Context context;
    private Calendar calendar;
    private SimpleDateFormat simpleDateFormat;
    LottieAnimationView likeAnimation;

    public PostAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
        calendar = Calendar.getInstance();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.post = post;
        holder.postText.setText(post.getPostText());
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss aaa");
        String dateTime = simpleDateFormat.format(post.getPostCreateTime()).toString();
        holder.postCreateTime.setText(dateTime);
        holder.countLike.setText(String.valueOf(post.getCountLike()));
        holder.update();
//        holder.liked.setChecked(post.isLiked());

        Glide.with(context)
                .load(post.getPostImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.postImage);
        holder.liked.setOnClickListener(v -> holder.toggleLike());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LottieAnimationView likeAnimation;
        private TextView postText, postCreateTime, countLike;
        private ImageView postImage;
        private ImageView liked;
        private Post post;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postText = itemView.findViewById(R.id.postText);
            postCreateTime = itemView.findViewById(R.id.postCreateTime);
            countLike = itemView.findViewById(R.id.countLike);
            postImage = itemView.findViewById(R.id.postImage);
            liked = itemView.findViewById(R.id.btn_like);
            likeAnimation = itemView.findViewById(R.id.animation_like);
            likeAnimation.addAnimatorListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(@NonNull Animator animation, boolean isReverse) {

                }

                @Override
                public void onAnimationEnd(@NonNull Animator animation, boolean isReverse) {
                    likeAnimation.setVisibility(View.INVISIBLE);
                }
            });

        }

        public void update() {
            int n = post.getCountLike();
            if (n > 0) {
                countLike.setVisibility(View.VISIBLE);
                String str = n + (n > 1 ? " likes" : " like");
                countLike.setText(str);
            } else {
                countLike.setVisibility(View.GONE);
            }
            if (post.isLiked()) liked.setImageResource(R.drawable.ic_heart);
            else liked.setImageResource(R.drawable.ic_heart_outlined);
        }
        public void toggleLike() {
            if (!post.isLiked()) {
                likeAnimation.playAnimation();
                likeAnimation.setVisibility(View.VISIBLE);
            } else {
                likeAnimation.setVisibility(View.INVISIBLE);
            }
            // update like data
            update();
        }



    }

}
