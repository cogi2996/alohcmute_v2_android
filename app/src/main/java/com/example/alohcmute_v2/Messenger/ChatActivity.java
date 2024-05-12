package com.example.alohcmute_v2.Messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.alohcmute_v2.Messenger.Fragments.ChatFragment;
import com.example.alohcmute_v2.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ChatFragment.newInstance())
                    .commitNow();
        }
    }
}