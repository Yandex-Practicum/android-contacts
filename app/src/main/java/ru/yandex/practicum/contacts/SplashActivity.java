package ru.yandex.practicum.contacts;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.yandex.practicum.contacts.databinding.SplashActivityBinding;
import ru.yandex.practicum.contacts.presentation.main.MainActivity;
import ru.yandex.practicum.contacts.utils.android.ContextUtils;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final int ANIMATION_TIME = 250;

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), this::onPermissionResult);

    private SplashActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SplashActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.settingsButton.setOnClickListener(view -> navigateToSettings());

        if (ContextUtils.hasContactPermissions(this)) {
            navigateToMain();
        } else {
            requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ContextUtils.hasContactPermissions(this)) {
            navigateToMain();
        }
    }

    private void navigateToMain() {
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showSettings() {
        final TransitionDrawable drawable = (TransitionDrawable) binding.getRoot().getBackground();
        drawable.startTransition(ANIMATION_TIME);
        binding.settingsButton.setVisibility(View.VISIBLE);
        binding.logo.setVisibility(View.GONE);
    }

    private void onPermissionResult(Boolean isGranted) {
        if (isGranted) {
            navigateToMain();
        } else {
            showSettings();
        }
    }

    private void navigateToSettings() {
        final Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        final Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }
}
