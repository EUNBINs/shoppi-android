package com.shoppi.android.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.shoppi.android.util.AssetLoader
import com.shoppi.android.R
import com.shoppi.android.R.*
import com.shoppi.android.dataclass.Title
import org.json.JSONObject


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout.fragment_home, container, false)   // fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)

        val assetLoader = AssetLoader()

        // context나 nullable이기 때문에 대체가능한 requireContext로 이미 가지고있는 context를 가져옴
        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
        Log.e("HomeFragment.homeData", homeData ?: "")

        if (!homeData.isNullOrEmpty()) {
            val jsonObject = JSONObject(homeData)

            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            val titleValue = Title(text, iconUrl)

            toolbarTitle.text = titleValue.text
            Glide.with(this)
                .load(titleValue.icon_url)
                .into(toolbarIcon)

            val topBanners =jsonObject.getJSONArray("top_banners")
            val firstBanners = topBanners.getJSONObject(0)
            val label = firstBanners.getString("label")
            val productDetail = firstBanners.getJSONObject("product_detail")
            val price = productDetail.getInt("price")

            Log.e("title", "text=$text, iconUrl=$iconUrl")
            Log.e("firstBanners", "label=$label, price=$price")
        }


    }

}