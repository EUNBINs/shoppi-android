package com.shoppi.android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shoppi.android.R

class CartegoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate을 통해 Fragment클래스와 보여줄 xml레이아웃을 연결해주기
        return inflater.inflate(R.layout.fragment_cartegory, container, false )
    }
}