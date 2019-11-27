package com.rcb.financialservice.bindingadapter;


import android.widget.ImageView;


public class BindingAdapter {
    private final static String TAG ="BindingAdapter";

//    @android.databinding.BindingAdapter(value = {"imageUrl", "error", "android:layout_width", "android:layout_height"}, requireAll = false)
//    public static void setImage(CircularImageView imageView, String url, String error,
//                                int oldWidth, int newWidth, int oldHeight, int newHeight) {
//        LogUtil.i(TAG, " ==== setImage imageUrl=" + url + " error " + error + " oldWidth=" + oldWidth + " newWidth=" + newWidth + " oldHeight=" + oldHeight + " newHeight =" + newHeight);
//        GlideApp.with(imageView.getContext())
//                .load(url)
////                .placeholder(R.mipmap.default_hd_avatar)
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                .override(newWidth, newHeight)
//                .into(imageView);
//    }
    @androidx.databinding.BindingAdapter(value = {"imageUrl", "errorInfo","android:layout_width","android:layout_height"}, requireAll = false)
    public static void setImage(final ImageView imageView, String url, String errorInfo, int oldWidth, int oldHeight) {
//
//        Glide.with(imageView.getContext())
//                .load(url)
//                .error(R.drawable.bg_person_card_emp)
//                .override(DesyUtils.dp2px(imageView.getContext(),100f),DesyUtils.dp2px(imageView.getContext(),100f))
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .placeholder(R.drawable.bg_person_card_emp)
//                .into(new SimpleTarget<GlideDrawable>() {
//                    @Override
//                    public void onResourceReady(GlideDrawable resource,
//                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
//                        imageView.setImageDrawable(resource);
//                    }
//                });
    }

//    @android.databinding.BindingAdapter(value = {"imageUrl", "errorInfo","defaultValue","android:layout_width","android:layout_height"}, requireAll = false)
//    public static void setImage(final ImageView imageView, String url, String errorInfo, int defaultValue, int oldWidth, int oldHeight) {
//        LogUtil.i(TAG, " ==== setImage imageUrl=" + url + " errorInfo " + errorInfo + " defaultValue="+defaultValue+" oldWidth=" + oldWidth  + " oldHeight=" + oldHeight);
//
//        int errorDrawable =R.drawable.bg_person_card_emp;
//        if(defaultValue == 1){
//            errorDrawable = R.mipmap.blank;
//        }
//        if(TextUtils.isEmpty(url)){
//            imageView.setBackgroundResource(errorDrawable);
//        }else{
//            Glide.with(imageView.getContext())
//                .load(url)
//                .error(errorDrawable)
//                .override(DesyUtils.dp2px(imageView.getContext(),100f),DesyUtils.dp2px(imageView.getContext(),100f))
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
////                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
////                .override(newWidth, newHeight)
////                .placeholder(R.drawable.bg_person_card_emp)
////                .into(imageView);
//                .into(new SimpleTarget<GlideDrawable>() {
//                    @Override
//                    public void onResourceReady(GlideDrawable resource,
//                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
//                        imageView.setImageDrawable(resource);
//                    }
//                });
//        }
//
//    }


}
