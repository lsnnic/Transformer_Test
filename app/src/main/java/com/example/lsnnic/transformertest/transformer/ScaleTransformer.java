package com.example.lsnnic.transformertest.transformer;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.lsnnic.transformertest.L;

public class ScaleTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(@NonNull View page, float pos) {
//        L.d(page.getTag()+", pos = "+pos);
        /**
         * a->b  position
         *  a的是从 0 -> -1
         *  b的是从 1 -> 0
         *
         *  b->a position
         *  b  0 -> 1
         *  a  -1 -> 0
         */
        if (pos<-1){
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setAlpha(MIN_ALPHA);
        }
        else if (pos<=1){
            // 左边页面
            if(pos<0){
                // a->b  [1,0.75f]  pos [0,-1]
                float scaleA = MIN_SCALE + (1-MIN_SCALE) * (1+pos);
                page.setScaleX(scaleA);
                page.setScaleY(scaleA);
                float alphaA = MIN_ALPHA + (1-MIN_ALPHA)*(1+pos);
                page.setAlpha(alphaA);

                // b->a [0.75f,1]  pos [-1,0]
//                MIN_SCALE + (1-MIN_SCALE)*(1+pos);

            }
            // 右边页面
            else {
                //a->b pos [1,0] [0.75f,1]
                float scaleB = MIN_SCALE + (1-MIN_SCALE)*(1-pos);
                page.setScaleX(scaleB);
                page.setScaleY(scaleB);
                float alphaB = MIN_ALPHA+(1-MIN_ALPHA)*(1-pos);
                page.setAlpha(alphaB);
                //b->a pos [0,1] [1,0.75f]
//                MIN_SCALE + (1-MIN_SCALE)*(1-pos);
            }
        }
        else{
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setAlpha(MIN_ALPHA);
        }
    }
}
