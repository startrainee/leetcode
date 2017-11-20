    # ViewPager
      ViewPager是android.support.v4.view.ViewPager的组件。
      借助ViewPager可以轻松实现多个view之间的左右滑动切换，甚至是多个fragment之间也可以实现相同的效果。
    ### 简单使用

      首先在布局中添加ViewPager组件：

    ```
    <LinearLayout
            xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            tools:context="com.snakotech.MainActivity">
        <android.support.v4.view.ViewPager
                android:id="@+id/view_pager"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1">
    </LinearLayout>
    ```

      新建三个布局文件(为了演示，只是换了背景色)
      layout1.xml，layout2.xml，layout3.xml：

    ```
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#ffff00"
        android:orientation="vertical" >
    </LinearLayout>
    ```

      之后在 Activity 中创建View 使用这些布局，之后添加到一个 list 中 :

    ```
    viewPager = (ViewPager) findViewById(R.id.viewpager);
    LayoutInflater inflater=getLayoutInflater();
    view1 = inflater.inflate(R.layout.layout1, null);
    view2 = inflater.inflate(R.layout.layout2,null);
    view3 = inflater.inflate(R.layout.layout3, null);
    List<View> viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
    viewList.add(view1);
    viewList.add(view2);
    viewList.add(view3);
    ```

      接下来，和 ListView 很像，需要实现适配器 PagerAdapter 添加到 PagerView 中。
      PageAdapter 必须重写的四个函数：
       *1 int getCount()
       *2 void destroyItem(ViewGroup container, int position,Object object)
       *3 Object instantiateItem(ViewGroup container, int position)
       *4 boolean isViewFromObject(View arg0, Object arg1)

    ```
    PagerAdapter pagerAdapter = new MyPagerAdapter() {
                @Override
                public boolean isViewFromObject(View arg0, Object arg1) {
                    return arg0 == arg1;
                }
                @Override
                public int getCount() {
                    return viewList.size();
                }
                @Override
                public void destroyItem(ViewGroup container, int position,
                        Object object) {
                    container.removeView(viewList.get(position));
                }
                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    container.addView(viewList.get(position));
                    return viewList.get(position);
                }
            };
            viewPager.setAdapter(pagerAdapter);
    ```

    > PagerAdapter SDK 地址: [http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html](http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html)
    对应翻译：
        PagerAdapter比AdapterView的使用更加普通.ViewPager使用回调函数来表示一个更新的步骤，而不是使用一个视图回收机制。在需要的时候PagerAdapter也可以实现视图的回收或者使用一种更为巧妙的方法来管理视图，比如采用可以管理自身视图的fragment。
        viewpager不直接处理每一个视图而是将各个视图与一个键(key)联系起来。这个键(key)用来跟踪且唯一代表一个页面，不仅如此，该键还独立于这个页面所在adapter的位置。当pageradapter将要改变的时候他会调用startUpdate函数，接下来会调用一次或多次的instantiateItem或者destroyItem。最后在更新的后期会调用finishUpdate。当finishUpdate返回时 instantiateItem返回的对象应该添加到父ViewGroup destroyItem返回的对象应该被ViewGroup删除。methodisViewFromObject(View, Object)代表了当前的页面是否与给定的键相关联。
        对于非常简单的pageradapter或许你可以选择用page本身作为键，在创建并且添加到viewgroup后instantiateItem方法里返回该page本身即可
        destroyItem将会将该page从viewgroup里面移除。isViewFromObject方法里面直接可以返回view == object。
        pageradapter支持数据集合的改变，数据集合的改变必须要在主线程里面执行，然后还要调用notifyDataSetChanged方法。和baseadapter非常相似。数据集合的改变包括页面的添加删除和修改位置。viewpager要维持当前页面是活动的，所以你必须提供getItemPosition方法。

    对于这四个方法：
    *1 public int getCount():
        名称就可以看出来是获取 List 中 View 的个数。
    *2 public void destroyItem(ViewGroup container, int position,Object object)
        从当前container中删除指定位置（position）的View;
          * container 包含将要删除 page 的 View 容器
          * position 为将要删除的 page 对应位置值
          * object 为 instantiateItem(ViewGroup container, int position)返回的Object.
    *3 public Object instantiateItem(ViewGroup container, int position)
        创建指定位置的页面视图。
        返回值代表新增视图页面的Object（Key），任意值均可以，只要与增加的View能够一一对应即可，比如position变量也可以做为Key。
    *4 public boolean isViewFromObject(View view, Object object)
        用来判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否是对应的，对应的表示同一个View)
        这里的object 和 instantiateItem 返回的值是一样的，该方法就是确定view 与 object 是否一一对应。

    下面就是自定义实现的 PagerAdapter：
    ```
    public class ViewPagerAdapter extends PagerAdapter {

        private List<View> views;

        public ViewPagerAdapter(List<View> views,List<String> titles) {
            this.views = views;
            this.titles = titles;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return position;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public int getCount() {
            Log.d("wcy", "getCount()");
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == views.get(Integer.parseInt(object.toString()));
        }
    }
    ```


    # FragmentPagerAdapter 和 FragmentStatePagerAdapter

    #### FragmentPagerAdapter
    * FragmentPagerAdapter派生自PagerAdapter，它是用来呈现Fragment页面的，这些Fragment页面会一直保存在fragmentmanager中，以便用户可以随时取用。
    * 每一个使用FragmentPagerAdapter的ViewPager都要有一个有效的ID集合，有效ID的集合就是Fragment的集合。
    * 但是最好用于有限个静态fragment页面的管理。尽管不可见的视图有时会被销毁，但用户所有访问过的fragment都会被保存在内存中。因此fragment实例会保存大量的各种状态，这就造成了很大的内存开销。所以如果要处理大量的页面切换，建议使用FragmentStatePagerAdapter.

    #### FragmentStatePagerAdapter
    * FragmentStatePagerAdapter 和 FragmentPagerAdapter 一样，是继承自PagerAdapter。但和 FragmentPagerAdapter 不一样的是，该 PagerAdapter 的实现将只保留当前页面，当页面离开视线后，就会被消除，释放其资源；而在页面需要显示时，生成新的页面(就像 ListView 的实现一样)，这么实现的好处就是当拥有大量的页面时，不必在内存中占用大量的内存。

    关于FragmentPagerAdapter 和 FragmentStatePagerAdapter都是通过FragmentManger管理Fragment的。二者的区别在于：关于FragmentPagerAdapter实现的destroyItem()方法是调用FragmentManager的detach()方法，并未销毁Fragment，而在FragmentStatePagerAdapter 则是调用FragmentManager的 remove() 方法。
引申出的问题：
使用关于FragmentPagerAdapter时，当 Fragment 对应的数据集发生改变时，通过调用 mAdapter.notifyDataSetChanged() 来触发 Fragment 页面使用新的数据调整或重新生成其内容时，发现什么都没发生。
解决办法之一是用FragmentStatePagerAdapter代替FragmentPagerAdapter，并重载 getItemPosition() 方法，返回 POSITION_NONE；
或者重写 方法 getItem() 以及 instantiateItem()，并重载 getItemPosition() 方法，返回 POSITION_NONE；
> 见网址：http://www.cnblogs.com/lianghui66/p/3607091.html


 FragmentPagerAdapter 和 FragmentStatePagerAdapter 使用需要重写以下方法 getItem(int)和getCount()即可。
   * public abstract Fragment getItem (int position)
      返回与指定位置关联的 fragment。可以在这里实例 Fragment。也可以通过Fragment集合返回对应的Fragment。
   * public abstract int getCount();
     返回 fragment 总数目。

以下为自实现的 FragmentPagerAdapter ，使用方法同 PagerAdapter。
```
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
```



