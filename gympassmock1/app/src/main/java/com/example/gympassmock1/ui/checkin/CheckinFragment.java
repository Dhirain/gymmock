package com.example.gympassmock1.ui.checkin;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.gympassmock1.R;
import com.example.gympassmock1.databinding.FragmentCheckinBinding;

public class CheckinFragment extends Fragment {

    private FragmentCheckinBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CheckinViewModel checkinViewModel =
                new ViewModelProvider(this).get(CheckinViewModel.class);

        binding = FragmentCheckinBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button button = binding.buttonSmartCheckin;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_checkin_to_completeCheckin );
            }
        });

        //final TextView textView = binding.textCheckin;
        //checkinViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.purple));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}